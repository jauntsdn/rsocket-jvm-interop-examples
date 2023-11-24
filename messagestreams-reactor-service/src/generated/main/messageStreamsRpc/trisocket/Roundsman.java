package trisocket;

@javax.annotation.Generated(
    value = "jauntsdn.com rpc compiler (version 1.5.2)",
    comments = "source: service.proto")
public interface Roundsman {
  String SERVICE = "trisocket.Roundsman";
  Class<?> SERVICE_TYPE = trisocket.Roundsman.class;

  String METHOD_CHOP = "chop";
  boolean METHOD_CHOP_IDEMPOTENT = false;
  int METHOD_CHOP_RANK = 0;

  String METHOD_MARINADE = "marinade";
  boolean METHOD_MARINADE_IDEMPOTENT = false;
  int METHOD_MARINADE_RANK = 0;

  reactor.core.publisher.Mono<trisocket.Veggie> chop(trisocket.Veggie message, com.jauntsdn.rsocket.Headers metadata);

  reactor.core.publisher.Mono<trisocket.Meat> marinade(trisocket.Meat message, com.jauntsdn.rsocket.Headers metadata);

  default reactor.core.publisher.Mono<trisocket.Veggie> chop(trisocket.Veggie message) {
    return chop(message, com.jauntsdn.rsocket.Headers.empty());
  }

  default reactor.core.publisher.Mono<trisocket.Meat> marinade(trisocket.Meat message) {
    return marinade(message, com.jauntsdn.rsocket.Headers.empty());
  }
}
