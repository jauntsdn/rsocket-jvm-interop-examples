package trisocket;

@javax.annotation.Generated(
    value = "jauntsdn.com rsocket-rpc compiler (version 1.1.4)",
    comments = "source: service.proto")
public interface Recipes {
  String SERVICE = "trisocket.Recipes";
  Class<?> SERVICE_TYPE = trisocket.Recipes.class;

  String METHOD_MARINADE = "marinade";
  boolean METHOD_MARINADE_IDEMPOTENT = false;
  int METHOD_MARINADE_RANK = 0;

  io.reactivex.rxjava3.core.Single<trisocket.Recipe> marinade(trisocket.Meat message, io.netty.buffer.ByteBuf metadata);

  default io.reactivex.rxjava3.core.Single<trisocket.Recipe> marinade(trisocket.Meat message) {
    return marinade(message, io.netty.buffer.Unpooled.EMPTY_BUFFER);
  }
}
