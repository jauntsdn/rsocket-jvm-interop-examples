package com.jauntsdn.rsocket.trisocket.roundsman;

import com.jauntsdn.rsocket.*;
import com.jauntsdn.rsocket.trisocket.RSocketFactory;
import com.jauntsdn.rsocket.trisocket.RSocketFactory.Server;
import io.smallrye.mutiny.Uni;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import trisocket.*;

public class Main {
  private static final Logger logger = LoggerFactory.getLogger(Main.class);

  public static void main(RSocketFactory rSocketFactory) {
    String roundsmanTransport = "WEBSOCKET-HTTP2";
    String roundsmanAddress = System.getProperty("ROUNDSMAN_ADDRESS", "localhost:7779");
    String recipesTransport = "TCP";
    String recipesAddress = System.getProperty("RECIPES_ADDRESS", "localhost:7780");

    logger.info("==> GOOD ROUNDSMAN SERVICE: {}, {}", roundsmanTransport, roundsmanAddress);

    Uni<MessageStreams> singleRecipes =
        rSocketFactory.client("ROUNDSMAN", recipesTransport, recipesAddress);

    Uni<Disposable> server =
        singleRecipes
            .map(RecipesClient::create)
            .flatMap(
                (Recipes recipes) -> {
                  Roundsman roundsman = new GoodRoundsman(recipes);

                  ServerStreamsAcceptor serverAcceptor =
                      (SetupMessage setup, MessageStreams messageStreams) -> {
                        logClientAccepted(setup);

                        return Uni.createFrom()
                            .item(
                                RoundsmanServer.create(roundsman, Optional.empty())
                                    .withLifecycle(messageStreams));
                      };
                  return rSocketFactory
                      .<Server<ServerStreamsAcceptor, Uni<Disposable>>>server(
                          "ROUNDSMAN", roundsmanTransport, roundsmanAddress)
                      .start(serverAcceptor)
                      .onItem()
                      .invoke(logServerStarted())
                      .onFailure()
                      .invoke(logServerStartFailed());
                });
    server.await().atMost(Duration.ofSeconds(5)).onClose().awaitUninterruptibly();
  }

  private static class GoodRoundsman implements Roundsman {
    private final Recipes recipes;

    GoodRoundsman(Recipes recipes) {
      this.recipes = recipes;
    }

    @Override
    public Uni<Veggie> chop(Veggie veggie, Headers metadata) {
      return Uni.createFrom()
          .deferred(
              () -> {
                int durationMillis = 1 + ThreadLocalRandom.current().nextInt(50);
                float size = Math.max(0.05f, veggie.getSize() / 5);
                return Uni.createFrom()
                    .item(veggie.toBuilder().setSize(size).build())
                    .onItem()
                    .delayIt()
                    .by(Duration.ofMillis(durationMillis));
              });
    }

    @Override
    public Uni<Meat> marinade(Meat meat, Headers metadata) {
      return Uni.createFrom()
          .deferred(
              () ->
                  recipes
                      .marinade(meat)
                      .flatMap(
                          recipe ->
                              Uni.createFrom()
                                  .item(
                                      meat.toBuilder().setStiffness(recipe.getStiffness()).build())
                                  .onItem()
                                  .delayIt()
                                  .by(Duration.ofMillis(recipe.getDuration()))));
    }
  }

  private static void logClientAccepted(SetupMessage setup) {
    logger.info(
        "==> {} CLIENT ACCEPTED SUCCESSFULLY",
        setup.message().data().toString(StandardCharsets.UTF_8));
  }

  private static Runnable logServerStarted() {
    return () -> logger.info("==> ROUNDSMAN SERVER BOUND SUCCESSFULLY");
  }

  private static Consumer<Throwable> logServerStartFailed() {
    return err ->
        logger.info(
            "==> ROUNDSMAN SERVER BOUND WITH ERROR: {}:{}", err.getClass(), err.getMessage());
  }
}
