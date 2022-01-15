package com.jauntsdn.rsocket.trisocket.kitchen;

import com.jauntsdn.rsocket.Disposable;
import com.jauntsdn.rsocket.RSocket;
import com.jauntsdn.rsocket.ServerStreamsAcceptor;
import com.jauntsdn.rsocket.trisocket.RSocketFactory;
import io.netty.buffer.ByteBuf;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;
import java.util.Optional;
import java.util.function.Function;
import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import trisocket.*;

public class Main {
  private static final Logger logger = LoggerFactory.getLogger(Main.class);

  public static void main(RSocketFactory rSocketFactory) {
    String kitchenTransport = "GRPC";
    String kitchenAddress = System.getProperty("KITCHEN_ADDRESS", "localhost:7777");
    String farmTransport = "TCP";
    String farmAddress = System.getProperty("FARM_ADDRESS", "localhost:7778");
    String chefTransport = "UNIX";
    String chefAddress = System.getProperty("CHEF_ADDRESS", "/tmp/trisocket_chef_service.sock");
    String roundsmanTransport = "WEBSOCKET-HTTP2";
    String roundsmanAddress = System.getProperty("ROUNDSMAN_ADDRESS", "localhost:7779");

    logger.info("==> GOOD KITCHEN SERVICE: {}, {}", kitchenTransport, kitchenAddress);
    logger.info("==> CHEF SERVICE: {}, {}", chefTransport, chefAddress);
    logger.info("==> ROUNDSMAN SERVICE: {}, {}", roundsmanTransport, roundsmanAddress);
    logger.info("==> FARM SERVICE: {}, {}", farmTransport, farmAddress);

    Single<Farmer> singleFarmer =
        rSocketFactory
            .<Single<RSocket>>client("KITCHEN", farmTransport, farmAddress)
            .doOnError(
                err ->
                    logger.info(
                        "==> FARM SERVICE CONNECTION ERROR: {}:{}",
                        err.getClass(),
                        err.getMessage()))
            .map(
                rSocket -> {
                  logger.info("==> FARM SERVICE CONNECTED SUCCESSFULLY");
                  return FarmerClient.create(rSocket, Optional.empty());
                });

    Single<Chef> singleChef =
        rSocketFactory
            .<Single<RSocket>>client("KITCHEN", chefTransport, chefAddress)
            .doOnError(
                err ->
                    logger.info(
                        "==> CHEF SERVICE CONNECTION ERROR: {}:{}",
                        err.getClass(),
                        err.getMessage()))
            .map(
                rSocket -> {
                  logger.info("==> CHEF SERVICE CONNECTED SUCCESSFULLY");
                  return ChefClient.create(rSocket, Optional.empty());
                });

    Single<Roundsman> singleRoundsman =
        rSocketFactory
            .<Single<RSocket>>client("KITCHEN", roundsmanTransport, roundsmanAddress)
            .doOnError(
                err ->
                    logger.info(
                        "==> ROUNDSMAN SERVICE CONNECTION ERROR: {}:{}",
                        err.getClass(),
                        err.getMessage()))
            .map(
                rSocket -> {
                  logger.info("==> ROUNDSMAN SERVICE CONNECTED SUCCESSFULLY");
                  return RoundsmanClient.create(rSocket, Optional.empty());
                });

    Single<GoodKitchen> goodKitchen =
        Single.zip(singleChef, singleRoundsman, singleFarmer, GoodKitchen::new);

    Single<Disposable> server =
        goodKitchen
            .flatMap(
                kitchen ->
                    rSocketFactory
                        .<Function<ServerStreamsAcceptor, Single<Disposable>>>server(
                            "KITCHEN", kitchenTransport, kitchenAddress)
                        .apply(
                            (setupMessage, rSocket) -> {
                              logger.info("==> GOURMET CLIENT ACCEPTED SUCCESSFULLY");
                              return Single.just(
                                  KitchenServer.create(kitchen, Optional.empty())
                                      .withLifecycle(rSocket));
                            }))
            .doOnEvent(
                (grpcRSocketServer, err) -> {
                  if (err != null) {
                    logger.info(
                        "==> KITCHEN SERVER BOUND WITH ERROR: {}:{}",
                        err.getClass(),
                        err.getMessage());
                  } else {
                    logger.info("==> KITCHEN SERVER BOUND SUCCESSFULLY");
                  }
                });

    server.blockingGet().onClose().awaitUninterruptibly();
  }

  @SuppressWarnings("UnnecessaryLocalVariable")
  static class GoodKitchen implements Kitchen {
    final Chef chef;
    final Roundsman roundsman;
    final Farmer farmer;

    GoodKitchen(Chef chef, Roundsman roundsman, Farmer farmer) {
      this.chef = chef;
      this.roundsman = roundsman;
      this.farmer = farmer;
    }

    @Override
    public Flowable<Dish> serve(Publisher<Order> orders, ByteBuf metadata) {
      return Flowable.fromPublisher(orders)
          .flatMap(
              order -> {
                Flowable<Meat> meats = farmer.meat(order);
                /*first marinade the meat*/
                Flowable<Meat> marinadedMeats = meats.flatMapSingle(roundsman::marinade, false, 64);
                Flowable<Veggie> veggies = farmer.veggies(order);
                /*then chop the veggies*/
                Flowable<Veggie> choppedVeggies = veggies.flatMapSingle(roundsman::chop, false, 64);
                Flowable<Pan> pans =
                    marinadedMeats.zipWith(
                        choppedVeggies,
                        (marinadedMeat, choppedVeggie) ->
                            Pan.newBuilder()
                                .setMeat(marinadedMeat)
                                .setVeggie(choppedVeggie)
                                .build());
                Flowable<Dish> dishes = pans.flatMapSingle(chef::roast);
                return dishes;
              });
    }
  }
}
