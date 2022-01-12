package trisocket;

@javax.annotation.Generated(
    value = "jauntsdn.com rpc compiler (version 1.1.3)",
    comments = "source: service.proto")
public interface Kitchen {
  String SERVICE = "trisocket.Kitchen";
  Class<?> SERVICE_TYPE = trisocket.Kitchen.class;

  String METHOD_SERVE = "serve";
  boolean METHOD_SERVE_IDEMPOTENT = false;
  int METHOD_SERVE_RANK = 0;

  io.smallrye.mutiny.Multi<trisocket.Dish> serve(org.reactivestreams.Publisher<trisocket.Order> messages, io.netty.buffer.ByteBuf metadata);

  default io.smallrye.mutiny.Multi<trisocket.Dish> serve(org.reactivestreams.Publisher<trisocket.Order> messages) {
    return serve(messages, io.netty.buffer.Unpooled.EMPTY_BUFFER);
  }
}
