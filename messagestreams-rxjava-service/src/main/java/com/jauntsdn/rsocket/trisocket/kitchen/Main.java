package com.jauntsdn.rsocket.trisocket.kitchen;

import com.jauntsdn.rsocket.*;
import com.jauntsdn.rsocket.trisocket.RSocketFactory;
import com.jauntsdn.rsocket.trisocket.RSocketFactory.Server;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Optional;
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
            .<Single<MessageStreams>>client("KITCHEN", farmTransport, farmAddress)
            .doOnError(logClientStartFailed("FARM"))
            .map(
                (MessageStreams messageStreams) -> {
                  logClientStarted("FARM");

                  return FarmerClient.create(messageStreams, Optional.empty());
                });

    Single<Chef> singleChef =
        rSocketFactory
            .<Single<MessageStreams>>client("KITCHEN", chefTransport, chefAddress)
            .doOnError(logClientStartFailed("CHEF"))
            .map(
                (MessageStreams messageStreams) -> {
                  logClientStarted("CHEF");

                  return ChefClient.create(messageStreams, Optional.empty());
                });

    Single<Roundsman> singleRoundsman =
        rSocketFactory
            .<Single<MessageStreams>>client("KITCHEN", roundsmanTransport, roundsmanAddress)
            .doOnError(logClientStartFailed("ROUNDSMAN"))
            .map(
                (MessageStreams messageStreams) -> {
                  logClientStarted("ROUNDSMAN");

                  return RoundsmanClient.create(messageStreams, Optional.empty());
                });

    Single<Kitchen> goodKitchen =
        Single.zip(singleChef, singleRoundsman, singleFarmer, GoodKitchen::new);

    Single<Disposable> server =
        goodKitchen.flatMap(
            (Kitchen kitchen) -> {
              ServerStreamsAcceptor serverAcceptor =
                  (SetupMessage setup, MessageStreams messageStreams) -> {
                    logClientAccepted();

                    return Single.just(
                        KitchenServer.create(kitchen, Optional.empty())
                            .withLifecycle(messageStreams));
                  };
              return rSocketFactory
                  .<Server<ServerStreamsAcceptor, Single<Disposable>>>server(
                      "KITCHEN", kitchenTransport, kitchenAddress)
                  .start(serverAcceptor)
                  .doOnEvent(logServerStarted());
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
    public Flowable<Dish> serve(Publisher<Order> orders, Headers metadata) {
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

  private static BiConsumer<Disposable, Throwable> logServerStarted() {
    return (grpcRSocketServer, err) -> {
      if (err != null) {
        logger.info("==> KITCHEN SERVER BOUND WITH ERROR: {}:{}", err.getClass(), err.getMessage());
      } else {
        logger.info("==> KITCHEN SERVER BOUND SUCCESSFULLY");
      }
    };
  }

  private static void logClientAccepted() {
    logger.info("==> GOURMET CLIENT ACCEPTED SUCCESSFULLY");
  }

  private static void logClientStarted(String service) {
    logger.info("==> {} SERVICE CONNECTED SUCCESSFULLY", service);
  }

  private static Consumer<Throwable> logClientStartFailed(String service) {
    return err ->
        logger.info(
            "==> {} SERVICE CONNECTION ERROR: {}:{}", service, err.getClass(), err.getMessage());
  }
}
