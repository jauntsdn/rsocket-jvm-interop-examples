package com.jauntsdn.rsocket.trisocket.kitchen;

import com.jauntsdn.rsocket.*;
import com.jauntsdn.rsocket.trisocket.RSocketFactory;
import com.jauntsdn.rsocket.trisocket.RSocketFactory.MultiProtocolTransport;
import com.jauntsdn.rsocket.trisocket.RSocketFactory.MultiProtocolTransport.Protocol;
import com.jauntsdn.rsocket.trisocket.RSocketFactory.Server;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import trisocket.*;

public class Main {
  private static final Logger logger = LoggerFactory.getLogger(Main.class);

  public static void main(RSocketFactory rSocketFactory) {
    Protocol grpcTransport = Protocol.of("GRPC");
    Protocol httpTransport =
        Protocol.ofTranscoded("HTTP/JSON", SupervisorServer.Descriptor.INSTANCE);
    String kitchenAddress = System.getProperty("KITCHEN_ADDRESS", "localhost:7777");

    String farmTransport = "TCP";
    String farmAddress = System.getProperty("FARM_ADDRESS", "localhost:7778");

    String chefTransport = "UNIX";
    String chefAddress = System.getProperty("CHEF_ADDRESS", "/tmp/trisocket_chef_service.sock");

    String roundsmanTransport = "WEBSOCKET-HTTP2";
    String roundsmanAddress = System.getProperty("ROUNDSMAN_ADDRESS", "localhost:7779");

    logger.info(
        "==> GOOD KITCHEN SERVICE: {}, {}",
        Arrays.asList(grpcTransport, httpTransport),
        kitchenAddress);
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

    Single<GoodKitchen> goodKitchen =
        Single.zip(singleChef, singleRoundsman, singleFarmer, GoodKitchen::new);

    Single<Disposable> server =
        goodKitchen.flatMap(
            (GoodKitchen kitchen) -> {
              ServerStreamsAcceptor serverAcceptor =
                  (SetupMessage setup, MessageStreams messageStreams) -> {
                    logClientAccepted();

                    GoodSupervisor supervisor = new GoodSupervisor(kitchen);
                    /*serve 2 services with 2 transports over same port*/
                    return Single.just(
                        RpcHandler.create(
                                KitchenServer.create(kitchen), SupervisorServer.create(supervisor))
                            .withLifecycle(messageStreams));
                  };

              return rSocketFactory
                  .<Server<ServerStreamsAcceptor, Single<Disposable>>>multiProtocolServer(
                      "KITCHEN",
                      multiProtocolTransport(kitchenAddress, grpcTransport, httpTransport))
                  .start(serverAcceptor)
                  .doOnEvent(logServerStarted());
            });

    server.blockingGet().onClose().awaitUninterruptibly();
  }

  static class GoodKitchen implements Kitchen {
    final Chef chef;
    final Roundsman roundsman;
    final Farmer farmer;
    final ConcurrentMap<String, AtomicInteger> dishes = new ConcurrentHashMap<>();

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
                return dishes.doOnNext(this::record);
              });
    }

    int records(String dish) {
      AtomicInteger counter = dishes.get(dish);
      if (counter != null) {
        return counter.getAndSet(0);
      }
      return 0;
    }

    void record(Dish dish) {
      String meat = dish.getMeat().getName();
      AtomicInteger counter = dishes.computeIfAbsent(meat, unused -> new AtomicInteger());
      counter.incrementAndGet();
    }
  }

  static class GoodSupervisor implements Supervisor {
    final GoodKitchen kitchen;

    public GoodSupervisor(GoodKitchen kitchen) {
      this.kitchen = kitchen;
    }

    @Override
    public Single<Report> inquiry(Inquiry message, Headers metadata) {
      String dish = message.getDish();
      int records = kitchen.records(dish);
      return Single.just(Report.newBuilder().setDish(dish).setCount(records).build());
    }
  }

  private static MultiProtocolTransport multiProtocolTransport(
      String address, Protocol... transports) {
    return MultiProtocolTransport.of(address, transports);
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
