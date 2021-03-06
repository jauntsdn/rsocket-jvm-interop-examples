package trisocket;

@javax.annotation.Generated(
    value = "jauntsdn.com rpc compiler (version 1.1.3)",
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

  io.smallrye.mutiny.Multi<trisocket.Meat> meat(trisocket.Order message, io.netty.buffer.ByteBuf metadata);

  io.smallrye.mutiny.Multi<trisocket.Veggie> veggies(trisocket.Order message, io.netty.buffer.ByteBuf metadata);

  default io.smallrye.mutiny.Multi<trisocket.Meat> meat(trisocket.Order message) {
    return meat(message, io.netty.buffer.Unpooled.EMPTY_BUFFER);
  }

  default io.smallrye.mutiny.Multi<trisocket.Veggie> veggies(trisocket.Order message) {
    return veggies(message, io.netty.buffer.Unpooled.EMPTY_BUFFER);
  }
}
