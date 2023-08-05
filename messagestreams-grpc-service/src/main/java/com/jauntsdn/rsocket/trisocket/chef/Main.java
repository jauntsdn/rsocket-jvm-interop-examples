package com.jauntsdn.rsocket.trisocket.chef;

import com.jauntsdn.rsocket.Disposable;
import com.jauntsdn.rsocket.Headers;
import com.jauntsdn.rsocket.MessageStreams;
import com.jauntsdn.rsocket.ServerStreamsAcceptor;
import com.jauntsdn.rsocket.SetupMessage;
import com.jauntsdn.rsocket.trisocket.RSocketFactory;
import com.jauntsdn.rsocket.trisocket.RSocketFactory.Server;
import io.grpc.stub.StreamObserver;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.concurrent.*;
import java.util.function.BiConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import trisocket.Chef;
import trisocket.ChefServer;
import trisocket.Dish;
import trisocket.Pan;

public class Main {
  private static final Logger logger = LoggerFactory.getLogger(Main.class);

  public static void main(RSocketFactory rSocketFactory) throws Exception {
    String chefTransport = "UNIX";
    String chefAddress = System.getProperty("CHEF_ADDRESS", "/tmp/trisocket_chef_service.sock");

    logger.info("==> CHEF SERVICE: {}, {}", chefTransport, chefAddress);

    Chef chef = new GoodChef(Executors.newSingleThreadScheduledExecutor());

    ServerStreamsAcceptor serverAcceptor =
        (SetupMessage setup, MessageStreams messageStreams) -> {
          logClientAccepted(setup);

          return CompletableFuture.completedFuture(
              ChefServer.create(chef, Optional.empty()).withLifecycle(messageStreams));
        };

    CompletionStage<Disposable> server =
        rSocketFactory
            .<Server<ServerStreamsAcceptor, CompletionStage<Disposable>>>server(
                "CHEF", chefTransport, chefAddress)
            .start(serverAcceptor)
            .whenComplete(logServerStarted());

    server.toCompletableFuture().join().onClose().awaitUninterruptibly();
  }

  static class GoodChef implements Chef {
    private final ScheduledExecutorService scheduler;

    GoodChef(ScheduledExecutorService scheduler) {
      this.scheduler = scheduler;
    }

    @Override
    public void roast(Pan pan, Headers metadata, StreamObserver<Dish> observer) {
      int durationMillis = ThreadLocalRandom.current().nextInt(100);
      scheduler.schedule(
          () -> {
            observer.onNext(
                Dish.newBuilder()
                    .setMeat(pan.getMeat())
                    .setVeggie(pan.getVeggie())
                    .setDoneness("welldone")
                    .build());
            observer.onCompleted();
          },
          durationMillis,
          TimeUnit.MILLISECONDS);
    }
  }

  private static void logClientAccepted(SetupMessage setup) {
    logger.info(
        "==> {} CLIENT ACCEPTED SUCCESSFULLY",
        setup.message().data().toString(StandardCharsets.UTF_8));
  }

  private static BiConsumer<Disposable, Throwable> logServerStarted() {
    return (disposable, err) -> {
      if (err != null) {
        logger.info("==> CHEF SERVER BOUND WITH ERROR: {}:{}", err.getClass(), err.getMessage());
      } else {
        logger.info("==> CHEF SERVER BOUND SUCCESSFULLY");
      }
    };
  }
}
