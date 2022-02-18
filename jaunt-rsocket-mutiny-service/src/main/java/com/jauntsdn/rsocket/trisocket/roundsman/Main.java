package com.jauntsdn.rsocket.trisocket.roundsman;

import com.jauntsdn.rsocket.Disposable;
import com.jauntsdn.rsocket.RSocket;
import com.jauntsdn.rsocket.ServerStreamsAcceptor;
import com.jauntsdn.rsocket.trisocket.RSocketFactory;
import io.netty.buffer.ByteBuf;
import io.smallrye.mutiny.Uni;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
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

    Uni<RSocket> singleRecipes =
        rSocketFactory.client("ROUNDSMAN", recipesTransport, recipesAddress);

    Uni<Disposable> server =
        singleRecipes
            .map(RecipesClient::create)
            .flatMap(
                recipes -> {
                  Roundsman roundsman = new GoodRoundsman(recipes);
                  return rSocketFactory
                      .<Function<ServerStreamsAcceptor, Uni<Disposable>>>server(
                          "ROUNDSMAN", roundsmanTransport, roundsmanAddress)
                      .apply(
                          (setupMessage, rSocket) -> {
                            logger.info(
                                "==> {} CLIENT ACCEPTED SUCCESSFULLY",
                                setupMessage.message().data().toString(StandardCharsets.UTF_8));
                            return Uni.createFrom()
                                .item(
                                    RoundsmanServer.create(roundsman, Optional.empty())
                                        .withLifecycle(rSocket));
                          })
                      .onItem()
                      .invoke(() -> logger.info("==> ROUNDSMAN SERVER BOUND SUCCESSFULLY"))
                      .onFailure()
                      .invoke(
                          err ->
                              logger.info(
                                  "==> CHEF SERVER BOUND WITH ERROR: {}:{}",
                                  err.getClass(),
                                  err.getMessage()));
                });
    server.await().atMost(Duration.ofSeconds(5)).onClose().awaitUninterruptibly();
  }

  private static class GoodRoundsman implements Roundsman {
    private final Recipes recipes;

    GoodRoundsman(Recipes recipes) {
      this.recipes = recipes;
    }

    @Override
    public Uni<Veggie> chop(Veggie veggie, ByteBuf metadata) {
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
    public Uni<Meat> marinade(Meat meat, ByteBuf metadata) {
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
}
