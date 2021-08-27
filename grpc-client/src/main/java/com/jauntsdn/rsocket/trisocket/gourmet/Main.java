package com.jauntsdn.rsocket.trisocket.gourmet;

import io.grpc.Codec;
import io.grpc.CompressorRegistry;
import io.grpc.DecompressorRegistry;
import io.grpc.ManagedChannel;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import io.grpc.stub.ClientCallStreamObserver;
import io.grpc.stub.ClientResponseObserver;
import java.net.InetSocketAddress;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import trisocket.Dish;
import trisocket.KitchenGrpc;
import trisocket.Meat;
import trisocket.Order;

public class Main {
  private static final Logger logger = LoggerFactory.getLogger(Main.class);
  private static final int WINDOW_SIZE = 64;

  public static void main(String[] args) throws Exception {
    String kitchenHost = System.getProperty("KITCHEN_HOST", "localhost");
    int kitchenPort = Integer.parseInt(System.getProperty("KITCHEN_PORT", "7777"));
    logger.info("==> KITCHEN SERVICE: {}:{}", kitchenHost, kitchenPort);

    CompressorRegistry compressorRegistry = CompressorRegistry.newEmptyInstance();
    compressorRegistry.register(Codec.Identity.NONE);
    DecompressorRegistry decompressorRegistry =
        DecompressorRegistry.emptyInstance().with(Codec.Identity.NONE, true);

    ManagedChannel channel =
        NettyChannelBuilder.forAddress(new InetSocketAddress(kitchenHost, kitchenPort))
            .compressorRegistry(compressorRegistry)
            .decompressorRegistry(decompressorRegistry)
            .usePlaintext()
            .flowControlWindow(100_000)
            .build();

    KitchenGrpc.KitchenStub kitchen = KitchenGrpc.newStub(channel);

    AtomicInteger sentCounter = new AtomicInteger();
    AtomicInteger receivedCounter = new AtomicInteger();
    Counter receivedPotatos = new Counter();
    Counter receivedHams = new Counter();
    Counter receivedWellDoneHams = new Counter();

    ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    ScheduledFuture<?> counterFuture =
        executorService.scheduleAtFixedRate(
            new Runnable() {
              int round = 1;

              @Override
              public void run() {
                int sent = sentCounter.getAndSet(0);
                int received = receivedCounter.getAndSet(0);
                int receivedPotato = receivedPotatos.getAndSet(0);
                int receivedHam = receivedHams.getAndSet(0);
                int receivedWellDoneHam = receivedWellDoneHams.getAndSet(0);
                int hamPercent = (int) (100 * (receivedHam / (float) received));
                int potatoPercent = (int) (100 * (receivedPotato / (float) received));
                int wellDoneHamPercent = (int) (100 * (receivedWellDoneHam / (float) receivedHam));
                logger.info("==> Day {} =============================================", round++);
                logger.info("==> Gourmet sent orders: {}, received dishes: {}", sent, received);
                logger.info("==> Gourmet's ham dishes: {} %", hamPercent);
                logger.info("==> Gourmet's potato dishes: {} %", potatoPercent);
                logger.info("==> Gourmet's welldone ham: {} %", wellDoneHamPercent);
              }
            },
            1_000,
            1_000,
            TimeUnit.MILLISECONDS);

    kitchen.serve(
        new ClientResponseObserver<Order, Dish>() {
          ClientCallStreamObserver<Order> ordersStream;
          int windowSize;

          @Override
          public void beforeStart(ClientCallStreamObserver<Order> ordersStream) {
            this.ordersStream = ordersStream;
            windowSize += WINDOW_SIZE;
            ordersStream.disableAutoRequestWithInitial(WINDOW_SIZE);
            ordersStream.setOnReadyHandler(
                new RunnableOnce() {

                  @Override
                  public void runOnce() {
                    addOrders(ordersStream, WINDOW_SIZE);
                  }
                });
          }

          @Override
          public void onNext(Dish dish) {
            Meat meat = dish.getMeat();
            if (meat.getName().equals("ham")) {
              receivedHams.increment();
              if (dish.getDoneness().equals("welldone")) {
                receivedWellDoneHams.increment();
              }
            }
            if (dish.getVeggie().getName().equals("potato")) {
              receivedPotatos.increment();
            }
            if (--windowSize == WINDOW_SIZE / 2) {
              int durationMillis = ThreadLocalRandom.current().nextInt(128);
              executorService.schedule(
                  () -> {
                    windowSize += WINDOW_SIZE;
                    ordersStream.request(WINDOW_SIZE);
                    addOrders(ordersStream, WINDOW_SIZE);
                  },
                  durationMillis,
                  TimeUnit.MILLISECONDS);
            }
            receivedCounter.incrementAndGet();
          }

          @Override
          public void onError(Throwable t) {
            logger.error("Gourmet dishes stream terminated with error", t);
            channel.shutdownNow();
            counterFuture.cancel(true);
          }

          @Override
          public void onCompleted() {
            logger.info("Gourmet dishes stream completed");
            channel.shutdownNow();
            counterFuture.cancel(true);
          }

          private void addOrders(ClientCallStreamObserver<Order> ordersStream, int size) {
            for (int i = 0; i < size; i++) {
              sentCounter.incrementAndGet();
              Order order = Order.newBuilder().setCount(1).build();
              ordersStream.onNext(order);
            }
          }
        });

    channel.awaitTermination(365, TimeUnit.DAYS);
  }

  static class Counter {
    int count;

    public void increment() {
      count++;
    }

    public int getAndSet(int value) {
      int c = count;
      count = value;
      return c;
    }
  }

  abstract static class RunnableOnce implements Runnable {
    boolean started;

    abstract void runOnce();

    @Override
    public void run() {
      if (started) {
        return;
      }
      started = true;
      runOnce();
    }
  }
}
