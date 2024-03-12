// Generated by jauntsdn.com rpc compiler (version 1.5.4)
// source: service.proto

package trisocket;

public interface Kitchen {
  String SERVICE = "trisocket.Kitchen";
  Class<?> SERVICE_TYPE = trisocket.Kitchen.class;

  String METHOD_SERVE = "serve";
  boolean METHOD_SERVE_IDEMPOTENT = false;
  int METHOD_SERVE_RANK = 0;

  io.reactivex.rxjava3.core.Flowable<trisocket.Dish> serve(org.reactivestreams.Publisher<trisocket.Order> messages, com.jauntsdn.rsocket.Headers metadata);

  default io.reactivex.rxjava3.core.Flowable<trisocket.Dish> serve(org.reactivestreams.Publisher<trisocket.Order> messages) {
    return serve(messages, com.jauntsdn.rsocket.Headers.empty());
  }
}
