package com.jauntsdn.rsocket.trisocket.recipes;

import com.jauntsdn.rsocket.*;
import com.jauntsdn.rsocket.trisocket.RSocketFactory;
import com.jauntsdn.rsocket.trisocket.RSocketFactory.Server;
import io.netty.buffer.ByteBuf;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.concurrent.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import trisocket.*;

public class Main {
  private static final Logger logger = LoggerFactory.getLogger(Main.class);

  public static void main(RSocketFactory rSocketFactory) {
    String recipesTransport = "TCP";
    String farmAddress = System.getProperty("RECIPES_ADDRESS", "localhost:7780");
    logger.info("==> RECIPES SERVICE: {}, {}", recipesTransport, farmAddress);
    Recipes recipes = new GoodRecipes();
    CompletionStage<Disposable> server =
        rSocketFactory
            .<Server<ServerStreamsAcceptor, CompletionStage<Disposable>>>server(
                "RECIPES", recipesTransport, farmAddress)
            .start(
                (SetupMessage setup, MessageStreams messageStreams) -> {
                  logger.info(
                      "==> {} CLIENT ACCEPTED SUCCESSFULLY",
                      setup.message().data().toString(StandardCharsets.UTF_8));
                  return CompletableFuture.completedFuture(
                      RecipesServer.create(recipes, Optional.empty())
                          .withLifecycle(messageStreams));
                })
            .whenComplete(
                (disposable, err) -> {
                  if (err != null) {
                    logger.info("==> RECIPES SERVER BOUND SUCCESSFULLY");
                  } else {
                    logger.info(
                        "==> RECIPES SERVER BOUND WITH ERROR: {}:{}",
                        err.getClass(),
                        err.getMessage());
                  }
                });
    server.toCompletableFuture().join().onClose().awaitUninterruptibly();
  }

  private static class GoodRecipes implements Recipes {

    @Override
    public CompletionStage<Recipe> marinade(Meat meat, ByteBuf metadata) {
      int durationMillis = 1 + ThreadLocalRandom.current().nextInt(50);
      float stiffness = Math.max(0.1f, meat.getStiffness() / 2);
      return CompletableFuture.completedFuture(
          Recipe.newBuilder()
              .setDuration(durationMillis)
              .setStiffness(stiffness)
              .setName(meat.getName())
              .build());
    }
  }
}
