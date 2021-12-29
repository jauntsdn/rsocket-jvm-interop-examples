package trisocket;

@javax.annotation.Generated(
    value = "jauntsdn.com rpc compiler (version 1.1.1)",
    comments = "source: service.proto")
public interface Chef {
  String SERVICE = "trisocket.Chef";
  Class<?> SERVICE_TYPE = trisocket.Chef.class;

  String METHOD_ROAST = "roast";
  boolean METHOD_ROAST_IDEMPOTENT = false;
  int METHOD_ROAST_RANK = 0;

  io.smallrye.mutiny.Uni<trisocket.Dish> roast(trisocket.Pan message, io.netty.buffer.ByteBuf metadata);

  default io.smallrye.mutiny.Uni<trisocket.Dish> roast(trisocket.Pan message) {
    return roast(message, io.netty.buffer.Unpooled.EMPTY_BUFFER);
  }
}