package com.jauntsdn.rsocket.trisocket.supervisor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.ssl.SslContext;
import java.time.Duration;
import javax.net.ssl.SSLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.netty.ByteBufFlux;
import reactor.netty.http.HttpProtocol;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;

public class Main {
  private static final Logger logger = LoggerFactory.getLogger(Main.class);

  public static void main(String[] args) throws Exception {
    String kitchenHost = System.getProperty("KITCHEN_HOST", "localhost");
    String kitchenPort = System.getProperty("KITCHEN_PORT", "7777");
    logger.info("==> KITCHEN SERVICE: {}:{}", kitchenHost, kitchenPort);
    String path = String.format("%s:%s/trisocket.Supervisor/inquiry", kitchenHost, kitchenPort);
    logger.info("==> KITCHEN PATH: {}", path);

    ObjectMapper mapper = new ObjectMapper();
    HttpClient httpClient = httpClient();

    Inquiry inquiry = new Inquiry();
    inquiry.setDish("ham");
    String inquiryBody = mapper.writeValueAsString(inquiry);

    Flux.interval(Duration.ZERO, Duration.ofSeconds(3))
        .flatMap(
            ignored -> {
              logger.info("sending inquiry: {}", inquiry);
              return httpClient
                  .post()
                  .uri(path)
                  .send(ByteBufFlux.fromString(Mono.just(inquiryBody)))
                  .responseSingle(
                      (response, bytes) ->
                          bytes
                              .asString()
                              .map(
                                  responseBody -> {
                                    HttpResponseStatus status = response.status();
                                    if (status == HttpResponseStatus.OK) {
                                      try {
                                        return mapper.readValue(responseBody, Report.class);
                                      } catch (JsonProcessingException e) {
                                        throw new RuntimeException("json decoding error", e);
                                      }
                                    } else {
                                      throw new RuntimeException(
                                          "non-success response: " + response.responseHeaders());
                                    }
                                  }));
            },
            1)
        .doOnNext(report -> logger.info("received report over http: {}", report))
        .doOnError(err -> logger.info("receive error", err))
        .doOnComplete(() -> logger.info("receive completed"))
        .blockLast();
  }

  private static HttpClient httpClient() throws SSLException {
    SslContext sslContext = Security.clientLocalSslContext();
    return HttpClient.create(ConnectionProvider.builder("http2").maxConnections(1).build())
        .protocol(HttpProtocol.H2)
        .secure(sslContextSpec -> sslContextSpec.sslContext(sslContext));
  }

  public static class Inquiry {
    public String dish;

    public void setDish(String dish) {
      this.dish = dish;
    }

    @Override
    public String toString() {
      return "Inquiry{" + "dish='" + dish + '\'' + '}';
    }
  }

  public static class Report {
    public String dish;
    public int count;

    public void setDish(String dish) {
      this.dish = dish;
    }

    public void setCount(int count) {
      this.count = count;
    }

    @Override
    public String toString() {
      return "Report{" + "dish='" + dish + '\'' + ", count=" + count + '}';
    }
  }
}
