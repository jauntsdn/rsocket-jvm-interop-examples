package trisocket;

@javax.annotation.Generated(
    value = "jauntsdn.com rsocket-rpc compiler (version 1.1.3)",
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

  java.util.concurrent.CompletionStage<trisocket.Veggie> chop(trisocket.Veggie message, io.netty.buffer.ByteBuf metadata);

  java.util.concurrent.CompletionStage<trisocket.Meat> marinade(trisocket.Meat message, io.netty.buffer.ByteBuf metadata);

  default java.util.concurrent.CompletionStage<trisocket.Veggie> chop(trisocket.Veggie message) {
    return chop(message, io.netty.buffer.Unpooled.EMPTY_BUFFER);
  }

  default java.util.concurrent.CompletionStage<trisocket.Meat> marinade(trisocket.Meat message) {
    return marinade(message, io.netty.buffer.Unpooled.EMPTY_BUFFER);
  }
}
