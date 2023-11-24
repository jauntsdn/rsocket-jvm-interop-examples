package trisocket;

@javax.annotation.Generated(
    value = "jauntsdn.com rpc compiler (version 1.5.2)",
    comments = "source: service.proto")
public interface Kitchen {
  String SERVICE = "trisocket.Kitchen";
  Class<?> SERVICE_TYPE = trisocket.Kitchen.class;

  String METHOD_SERVE = "serve";
  boolean METHOD_SERVE_IDEMPOTENT = false;
  int METHOD_SERVE_RANK = 0;

  reactor.core.publisher.Flux<trisocket.Dish> serve(org.reactivestreams.Publisher<trisocket.Order> messages, com.jauntsdn.rsocket.Headers metadata);

  default reactor.core.publisher.Flux<trisocket.Dish> serve(org.reactivestreams.Publisher<trisocket.Order> messages) {
    return serve(messages, com.jauntsdn.rsocket.Headers.empty());
  }
}
