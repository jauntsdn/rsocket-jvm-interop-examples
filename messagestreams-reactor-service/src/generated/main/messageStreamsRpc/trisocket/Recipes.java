package trisocket;

@javax.annotation.Generated(
    value = "jauntsdn.com rpc compiler (version 1.5.4)",
    comments = "source: service.proto")
public interface Recipes {
  String SERVICE = "trisocket.Recipes";
  Class<?> SERVICE_TYPE = trisocket.Recipes.class;

  String METHOD_MARINADE = "marinade";
  boolean METHOD_MARINADE_IDEMPOTENT = false;
  int METHOD_MARINADE_RANK = 0;

  reactor.core.publisher.Mono<trisocket.Recipe> marinade(trisocket.Meat message, com.jauntsdn.rsocket.Headers metadata);

  default reactor.core.publisher.Mono<trisocket.Recipe> marinade(trisocket.Meat message) {
    return marinade(message, com.jauntsdn.rsocket.Headers.empty());
  }
}
