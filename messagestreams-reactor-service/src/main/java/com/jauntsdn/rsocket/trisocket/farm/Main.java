package com.jauntsdn.rsocket.trisocket.farm;

import com.jauntsdn.rsocket.*;
import com.jauntsdn.rsocket.trisocket.RSocketFactory;
import com.jauntsdn.rsocket.trisocket.RSocketFactory.Server;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import trisocket.*;

public class Main {
  private static final Logger logger = LoggerFactory.getLogger(Main.class);

  public static void main(RSocketFactory rSocketFactory) {
    String farmTransport = "TCP";
    String farmAddress = System.getProperty("FARM_ADDRESS", "localhost:7778");
    logger.info("==> FARM SERVICE: {}, {}", farmTransport, farmAddress);

    ServerStreamsAcceptor serverAcceptor =
        (SetupMessage setup, MessageStreams messageStreams) -> {
          logClientAccepted(setup);

          Farmer farmer = new GoodFarmer();

          return Mono.just(
              FarmerServer.create(farmer, Optional.empty()).withLifecycle(messageStreams));
        };
    Mono<Disposable> server =
        rSocketFactory
            .<Server<ServerStreamsAcceptor, Mono<Disposable>>>server(
                "FARM", farmTransport, farmAddress)
            .start(serverAcceptor)
            .doOnSuccess(logServerStarted())
            .doOnError(logServerStartFailed());

    server.block(Duration.ofSeconds(5)).onClose().awaitUninterruptibly();
  }

  static class GoodFarmer implements Farmer {
    private static final String[] VEGGIES = new String[] {"potato", "cabbage"};
    private static final String[] MEATS = new String[] {"ram", "ham"};

    int meatIndex = 0;
    int veggieIndex = 0;

    @Override
    public Flux<Meat> meat(Order message, Headers metadata) {
      int durationMillis = ThreadLocalRandom.current().nextInt(30);
      return Flux.<Meat>create(
              sink -> {
                for (int i = 0; i < message.getCount(); i++) {
                  int index = meatIndex;
                  meatIndex = index == Integer.MAX_VALUE ? 0 : index + 1;
                  String meat = MEATS[index % 2];
                  sink.next(Meat.newBuilder().setName(meat).setStiffness(1.0f).build());
                }
                sink.complete();
              })
          .delaySubscription(Duration.ofMillis(durationMillis));
    }

    @Override
    public Flux<Veggie> veggies(Order message, Headers metadata) {
      int durationMillis = ThreadLocalRandom.current().nextInt(30);
      return Flux.<Veggie>create(
              sink -> {
                for (int i = 0; i < message.getCount(); i++) {
                  int index = veggieIndex;
                  veggieIndex = index == Integer.MAX_VALUE ? 0 : index + 1;
                  String veggie = VEGGIES[index % 2];
                  sink.next(Veggie.newBuilder().setName(veggie).setSize(1.0f).build());
                }
                sink.complete();
              })
          .delaySubscription(Duration.ofMillis(durationMillis));
    }
  }

  private static void logClientAccepted(SetupMessage setup) {
    logger.info(
        "==> {} CLIENT ACCEPTED SUCCESSFULLY",
        setup.message().data().toString(StandardCharsets.UTF_8));
  }

  private static Consumer<Throwable> logServerStartFailed() {
    return err ->
        logger.info("==> FARM SERVER BOUND WITH ERROR: {}:{}", err.getClass(), err.getMessage());
  }

  private static Consumer<Disposable> logServerStarted() {
    return (tcpServer) -> logger.info("==> FARM SERVER BOUND SUCCESSFULLY");
  }
}
