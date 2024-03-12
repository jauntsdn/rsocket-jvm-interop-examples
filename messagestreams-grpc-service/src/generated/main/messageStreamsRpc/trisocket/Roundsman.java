// Generated by jauntsdn.com rpc compiler (version 1.5.4)
// source: service.proto

package trisocket;

public interface Roundsman {
  String SERVICE = "trisocket.Roundsman";
  Class<?> SERVICE_TYPE = trisocket.Roundsman.class;

  String METHOD_CHOP = "chop";
  boolean METHOD_CHOP_IDEMPOTENT = false;
  int METHOD_CHOP_RANK = 0;

  String METHOD_MARINADE = "marinade";
  boolean METHOD_MARINADE_IDEMPOTENT = false;
  int METHOD_MARINADE_RANK = 0;

  void chop(trisocket.Veggie message, com.jauntsdn.rsocket.Headers metadata, io.grpc.stub.StreamObserver<trisocket.Veggie> observer);

  void marinade(trisocket.Meat message, com.jauntsdn.rsocket.Headers metadata, io.grpc.stub.StreamObserver<trisocket.Meat> observer);

  default void chop(trisocket.Veggie message, io.grpc.stub.StreamObserver<trisocket.Veggie> observer) {
    chop(message, com.jauntsdn.rsocket.Headers.empty(), observer);
  }

  default void marinade(trisocket.Meat message, io.grpc.stub.StreamObserver<trisocket.Meat> observer) {
    marinade(message, com.jauntsdn.rsocket.Headers.empty(), observer);
  }
}
