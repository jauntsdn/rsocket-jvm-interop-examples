// Generated by jauntsdn.com rpc compiler (version 1.5.4)
// source: service.proto

package trisocket;

@com.jauntsdn.rsocket.Rpc.Generated(
    role = com.jauntsdn.rsocket.Rpc.Role.SERVICE,
    service = Roundsman.class)
@SuppressWarnings("all")
public final class RoundsmanServer implements com.jauntsdn.rsocket.RpcService {
  private final java.util.concurrent.CompletableFuture<Void> onClose = new java.util.concurrent.CompletableFuture<>();
  private final Roundsman service;
  private final java.util.function.Function<com.google.protobuf.MessageLite, com.jauntsdn.rsocket.Message> messageEncoder;
  private final com.jauntsdn.rsocket.Rpc.Codec rpcCodec;
  private final java.util.function.Function<io.smallrye.mutiny.Uni<com.jauntsdn.rsocket.Message>, io.smallrye.mutiny.Uni<com.jauntsdn.rsocket.Message>> chopInstrumentation;
  private final java.util.function.Function<io.smallrye.mutiny.Uni<com.jauntsdn.rsocket.Message>, io.smallrye.mutiny.Uni<com.jauntsdn.rsocket.Message>> marinadeInstrumentation;

  private RoundsmanServer(Roundsman service, com.jauntsdn.rsocket.RpcInstrumentation instrumentation, io.netty.buffer.ByteBufAllocator allocator, com.jauntsdn.rsocket.Rpc.Codec rpcCodec) {
    this.messageEncoder = com.jauntsdn.rsocket.generated.ProtobufCodec.encode("RoundsmanServer", allocator, rpcCodec);
    this.service = service;
    this.rpcCodec = rpcCodec;
    if (instrumentation == null) {
      this.chopInstrumentation = null;
      this.marinadeInstrumentation = null;
    } else {
      this.chopInstrumentation = instrumentation.instrumentUni("service", Roundsman.SERVICE, Roundsman.METHOD_CHOP);
      this.marinadeInstrumentation = instrumentation.instrumentUni("service", Roundsman.SERVICE, Roundsman.METHOD_MARINADE);
    }
  }

  public static RoundsmanServer.Factory create(Roundsman service, java.util.Optional<com.jauntsdn.rsocket.RpcInstrumentation> instrumentation) {
    return new RoundsmanServer.Factory(service, instrumentation);
  }

  public static RoundsmanServer.Factory create(Roundsman service) {
    return new RoundsmanServer.Factory(service);
  }

  @Override
  public String service() {
    return Roundsman.SERVICE;
  }

  @Override
  public Class<?> serviceType() {
    return Roundsman.SERVICE_TYPE;
  }

  @Override
  public io.smallrye.mutiny.Uni<Void> fireAndForget(com.jauntsdn.rsocket.Message message) {
    message.release();
    return io.smallrye.mutiny.Uni.createFrom().failure(new com.jauntsdn.rsocket.exceptions.RpcException("RoundsmanServer: fireAndForget not implemented"));
  }

  @Override
  public io.smallrye.mutiny.Uni<com.jauntsdn.rsocket.Message> requestResponse(com.jauntsdn.rsocket.Message message) {
    try {
      io.netty.buffer.ByteBuf metadata = message.metadata();
      long header = com.jauntsdn.rsocket.Rpc.RpcMetadata.header(metadata);
      int flags = com.jauntsdn.rsocket.Rpc.RpcMetadata.flags(header);
      String method = rpcCodec.decodeMessageMethod(metadata, header, flags);

      io.smallrye.mutiny.Uni<com.jauntsdn.rsocket.Message> handler = requestResponseHandler(flags, method, message.data(), metadata);
      if (handler != null) {
        return handler;
      }
      return io.smallrye.mutiny.Uni.createFrom().failure(new com.jauntsdn.rsocket.exceptions.RpcException("RoundsmanServer: requestResponse not implemented"));
    } catch (Throwable t) {
      return io.smallrye.mutiny.Uni.createFrom().failure(t);
    } finally {
      message.release();
    }
  }

  @Override
  public io.smallrye.mutiny.Multi<com.jauntsdn.rsocket.Message> requestStream(com.jauntsdn.rsocket.Message message) {
    message.release();
    return io.smallrye.mutiny.Multi.createFrom().failure(new com.jauntsdn.rsocket.exceptions.RpcException("RoundsmanServer: requestStream not implemented"));
  }

  @Override
  public io.smallrye.mutiny.Multi<com.jauntsdn.rsocket.Message> requestChannel(com.jauntsdn.rsocket.Message message, java.util.concurrent.Flow.Publisher<com.jauntsdn.rsocket.Message> publisher) {
    try {
      io.netty.buffer.ByteBuf metadata = message.metadata();
      long header = com.jauntsdn.rsocket.Rpc.RpcMetadata.header(metadata);
      int flags = com.jauntsdn.rsocket.Rpc.RpcMetadata.flags(header);
      String method = rpcCodec.decodeMessageMethod(metadata, header, flags);

      if (com.jauntsdn.rsocket.Rpc.RpcMetadata.flagForeignCall(flags)) {
        io.smallrye.mutiny.Uni<com.jauntsdn.rsocket.Message> responseHandler = requestResponseHandler(flags, method, message.data(), metadata);
        if (responseHandler != null) {
          message.release();
          return responseHandler.toMulti();
        }
      }
      message.release();
      return io.smallrye.mutiny.Multi.createFrom().failure(new com.jauntsdn.rsocket.exceptions.RpcException("RoundsmanServer: requestChannel unknown method: " + method));
    } catch (Throwable t) {
      io.netty.util.ReferenceCountUtil.safeRelease(message);
      return io.smallrye.mutiny.Multi.createFrom().failure(t);
    }
  }

  @Override
  public io.smallrye.mutiny.Multi<com.jauntsdn.rsocket.Message> requestChannel(java.util.concurrent.Flow.Publisher<com.jauntsdn.rsocket.Message> messages) {
    return io.smallrye.mutiny.Multi.createFrom().failure(new com.jauntsdn.rsocket.exceptions.RpcException("RoundsmanServer: unsupported method: requestChannel(Publisher<Message>)"));
  }

  @Override
  public void dispose() {
    onClose.complete(null);
  }

  @Override
  public boolean isDisposed() {
    return onClose.isDone();
  }

  @Override
  public io.smallrye.mutiny.Uni<Void> onClose() {
    return io.smallrye.mutiny.Uni.createFrom().completionStage(onClose);
  }

  private io.smallrye.mutiny.Uni<com.jauntsdn.rsocket.Message> requestResponseHandler(int flags, String method, io.netty.buffer.ByteBuf data, io.netty.buffer.ByteBuf metadata) throws java.io.IOException {
    switch (method) {
      case Roundsman.METHOD_CHOP: {
        if (!Roundsman.METHOD_CHOP_IDEMPOTENT && com.jauntsdn.rsocket.Rpc.RpcMetadata.flagIdempotentCall(flags)) {
          return io.smallrye.mutiny.Uni.createFrom().failure(new UnsupportedOperationException("RoundsmanServer: idempotent call to non-idempotent method: " + method));
        }
        com.google.protobuf.CodedInputStream is = com.google.protobuf.CodedInputStream.newInstance(data.internalNioBuffer(0, data.readableBytes()));
        com.jauntsdn.rsocket.Headers chopHeaders = com.jauntsdn.rsocket.generated.ProtobufCodec.decodeHeaders(metadata);
        io.smallrye.mutiny.Uni<com.jauntsdn.rsocket.Message> chop = service.chop(trisocket.Veggie.parseFrom(is), chopHeaders).map(messageEncoder);
        if (chopInstrumentation != null) {
          return chop.plug(chopInstrumentation);
        }
        return chop;
      }
      case Roundsman.METHOD_MARINADE: {
        if (!Roundsman.METHOD_MARINADE_IDEMPOTENT && com.jauntsdn.rsocket.Rpc.RpcMetadata.flagIdempotentCall(flags)) {
          return io.smallrye.mutiny.Uni.createFrom().failure(new UnsupportedOperationException("RoundsmanServer: idempotent call to non-idempotent method: " + method));
        }
        com.google.protobuf.CodedInputStream is = com.google.protobuf.CodedInputStream.newInstance(data.internalNioBuffer(0, data.readableBytes()));
        com.jauntsdn.rsocket.Headers marinadeHeaders = com.jauntsdn.rsocket.generated.ProtobufCodec.decodeHeaders(metadata);
        io.smallrye.mutiny.Uni<com.jauntsdn.rsocket.Message> marinade = service.marinade(trisocket.Meat.parseFrom(is), marinadeHeaders).map(messageEncoder);
        if (marinadeInstrumentation != null) {
          return marinade.plug(marinadeInstrumentation);
        }
        return marinade;
      }
      default: {
        return null;
      }
    }
  }

  public static final class Factory extends com.jauntsdn.rsocket.RpcService.ServerFactory<RoundsmanServer> {

    public Factory(Roundsman service, java.util.Optional<com.jauntsdn.rsocket.RpcInstrumentation> instrumentation) {
      super(service, instrumentation);
    }

    public Factory(Roundsman service) {
      super(service);
    }

    @Override
    public RoundsmanServer create(com.jauntsdn.rsocket.RpcInstrumentation rpcInstrumentation, io.netty.buffer.ByteBufAllocator allocator, com.jauntsdn.rsocket.Rpc.Codec rpcCodec) {
      return new RoundsmanServer(service(), rpcInstrumentation, allocator, rpcCodec);
    }
  }
}
