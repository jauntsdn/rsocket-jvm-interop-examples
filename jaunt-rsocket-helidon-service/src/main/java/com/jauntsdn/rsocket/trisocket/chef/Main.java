package com.jauntsdn.rsocket.trisocket.chef;

import com.jauntsdn.rsocket.Disposable;
import com.jauntsdn.rsocket.ServerAcceptor;
import com.jauntsdn.rsocket.trisocket.RSocketFactory;
import io.helidon.common.reactive.Single;
import io.netty.buffer.ByteBuf;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.concurrent.*;
import java.util.function.Function;
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

    Single<Disposable> server =
        rSocketFactory
            .<Function<ServerAcceptor, Single<Disposable>>>server(
                "CHEF", chefTransport, chefAddress)
            .apply(
                (setupMessage, rSocket) -> {
                  logger.info(
                      "==> {} CLIENT ACCEPTED SUCCESSFULLY",
                      setupMessage.message().data().toString(StandardCharsets.UTF_8));
                  return Single.just(
                      ChefServer.create(chef, Optional.empty()).withLifecycle(rSocket));
                })
            .onComplete(() -> logger.info("==> CHEF SERVER BOUND SUCCESSFULLY"))
            .onError(
                err ->
                    logger.info(
                        "==> CHEF SERVER BOUND WITH ERROR: {}:{}",
                        err.getClass(),
                        err.getMessage()));

    server.get(5, TimeUnit.SECONDS).onClose().awaitUninterruptibly();
  }

  static class GoodChef implements Chef {
    private final ScheduledExecutorService scheduler;

    GoodChef(ScheduledExecutorService scheduler) {
      this.scheduler = scheduler;
    }

    @Override
    public Single<Dish> roast(Pan pan, ByteBuf metadata) {
      int durationMillis = ThreadLocalRandom.current().nextInt(100);
      return Single.timer(durationMillis, TimeUnit.MILLISECONDS, scheduler)
          .map(
              v ->
                  Dish.newBuilder()
                      .setMeat(pan.getMeat())
                      .setVeggie(pan.getVeggie())
                      .setDoneness("welldone")
                      .build());
    }
  }
}
