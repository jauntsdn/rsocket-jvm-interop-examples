package trisocket;

@javax.annotation.Generated(
    value = "jauntsdn.com rpc compiler (version 1.5.1)",
    comments = "source: service.proto")
public interface Farmer {
  String SERVICE = "trisocket.Farmer";
  Class<?> SERVICE_TYPE = trisocket.Farmer.class;

  String METHOD_MEAT = "meat";
  boolean METHOD_MEAT_IDEMPOTENT = false;
  int METHOD_MEAT_RANK = 0;

  String METHOD_VEGGIES = "veggies";
  boolean METHOD_VEGGIES_IDEMPOTENT = false;
  int METHOD_VEGGIES_RANK = 0;

  reactor.core.publisher.Flux<trisocket.Meat> meat(trisocket.Order message, com.jauntsdn.rsocket.Headers metadata);

  reactor.core.publisher.Flux<trisocket.Veggie> veggies(trisocket.Order message, com.jauntsdn.rsocket.Headers metadata);

  default reactor.core.publisher.Flux<trisocket.Meat> meat(trisocket.Order message) {
    return meat(message, com.jauntsdn.rsocket.Headers.empty());
  }

  default reactor.core.publisher.Flux<trisocket.Veggie> veggies(trisocket.Order message) {
    return veggies(message, com.jauntsdn.rsocket.Headers.empty());
  }
}
