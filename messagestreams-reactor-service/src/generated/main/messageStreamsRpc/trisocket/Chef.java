package trisocket;

@javax.annotation.Generated(
    value = "jauntsdn.com rpc compiler (version 1.5.2)",
    comments = "source: service.proto")
public interface Chef {
  String SERVICE = "trisocket.Chef";
  Class<?> SERVICE_TYPE = trisocket.Chef.class;

  String METHOD_ROAST = "roast";
  boolean METHOD_ROAST_IDEMPOTENT = false;
  int METHOD_ROAST_RANK = 0;

  reactor.core.publisher.Mono<trisocket.Dish> roast(trisocket.Pan message, com.jauntsdn.rsocket.Headers metadata);

  default reactor.core.publisher.Mono<trisocket.Dish> roast(trisocket.Pan message) {
    return roast(message, com.jauntsdn.rsocket.Headers.empty());
  }
}
