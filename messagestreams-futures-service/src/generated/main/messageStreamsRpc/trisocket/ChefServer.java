// Generated by jauntsdn.com rsocket-rpc compiler (version 1.5.2)
// source: service.proto

package trisocket;

@com.jauntsdn.rsocket.Rpc.Generated(
    role = com.jauntsdn.rsocket.Rpc.Role.SERVICE,
    service = Chef.class)
@SuppressWarnings("all")
public final class ChefServer implements com.jauntsdn.rsocket.RpcService {
  private final java.util.concurrent.CompletableFuture<Void> onClose = new java.util.concurrent.CompletableFuture<>();
  private final Chef service;
  private final com.jauntsdn.rsocket.Rpc.Codec rpcCodec;
  private final java.util.function.Function<com.google.protobuf.MessageLite, com.jauntsdn.rsocket.Message> messageEncoder;
  private final com.jauntsdn.rsocket.RpcInstrumentation.Factory<com.jauntsdn.rsocket.Message> roastInstrumentation;

  private ChefServer(Chef service, com.jauntsdn.rsocket.RpcInstrumentation instrumentation, io.netty.buffer.ByteBufAllocator allocator, com.jauntsdn.rsocket.Rpc.Codec rpcCodec) {
    this.messageEncoder = com.jauntsdn.rsocket.generated.ProtobufCodec.encode("ChefServer", allocator, rpcCodec);
    this.service = service;
    this.rpcCodec = rpcCodec;
    if (instrumentation == null) {
      this.roastInstrumentation = null;
    } else {
      this.roastInstrumentation = instrumentation.instrument("service", Chef.SERVICE, Chef.METHOD_ROAST, true);
    }
  }

  public static ChefServer.Factory create(Chef service, java.util.Optional<com.jauntsdn.rsocket.RpcInstrumentation> instrumentation) {
    return new ChefServer.Factory(service, instrumentation);
  }

  public static ChefServer.Factory create(Chef service) {
    return new ChefServer.Factory(service);
  }

  @Override
  public String service() {
    return Chef.SERVICE;
  }

  @Override
  public Class<?> serviceType() {
    return Chef.SERVICE_TYPE;
  }

  @Override
  public java.util.concurrent.CompletionStage<Void> fireAndForget(com.jauntsdn.rsocket.Message message) {
    message.release();
    return com.jauntsdn.rsocket.RpcHandler.completedFuture(new com.jauntsdn.rsocket.exceptions.RpcException("ChefServer: fireAndForget not implemented"));
  }

  @Override
  public java.util.concurrent.CompletionStage<com.jauntsdn.rsocket.Message> requestResponse(com.jauntsdn.rsocket.Message message) {
    try {
      io.netty.buffer.ByteBuf metadata = message.metadata();
      long header = com.jauntsdn.rsocket.Rpc.RpcMetadata.header(metadata);
      int flags = com.jauntsdn.rsocket.Rpc.RpcMetadata.flags(header);
      String method = rpcCodec.decodeMessageMethod(metadata, header, flags);

      java.util.concurrent.CompletionStage<com.jauntsdn.rsocket.Message> handler = requestResponseHandler(flags, method, message.data(), metadata);
      if (handler != null) {
        return handler;
      }
      return com.jauntsdn.rsocket.RpcHandler.completedFuture(new com.jauntsdn.rsocket.exceptions.RpcException("ChefServer: requestResponse not implemented"));
    } catch (Throwable t) {
      return com.jauntsdn.rsocket.RpcHandler.completedFuture(t);
    } finally {
      message.release();
    }
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
  public java.util.concurrent.CompletionStage<Void> onClose() {
    return onClose;
  }

  private java.util.concurrent.CompletionStage<com.jauntsdn.rsocket.Message> requestResponseHandler(int flags, String method, io.netty.buffer.ByteBuf data, io.netty.buffer.ByteBuf metadata) throws java.io.IOException {
    switch (method) {
      case Chef.METHOD_ROAST: {
        if (!Chef.METHOD_ROAST_IDEMPOTENT && com.jauntsdn.rsocket.Rpc.RpcMetadata.flagIdempotentCall(flags)) {
          return com.jauntsdn.rsocket.RpcHandler.completedFuture(new com.jauntsdn.rsocket.exceptions.RpcException("ChefServer: idempotent call to non-idempotent method: " + method));
        }
        com.google.protobuf.CodedInputStream is = com.google.protobuf.CodedInputStream.newInstance(data.internalNioBuffer(0, data.readableBytes()));
        com.jauntsdn.rsocket.RpcInstrumentation.Listener<com.jauntsdn.rsocket.Message> instrumentationListener = null;
        if (roastInstrumentation != null) {
          instrumentationListener = roastInstrumentation.create();
          instrumentationListener.onStart();
        }
        com.jauntsdn.rsocket.Headers roastHeaders = com.jauntsdn.rsocket.generated.ProtobufCodec.decodeHeaders(metadata);
        java.util.concurrent.CompletionStage<com.jauntsdn.rsocket.Message> roastResponse = service.roast(trisocket.Pan.parseFrom(is), roastHeaders).thenApply(messageEncoder);
        if (instrumentationListener != null) {
          roastResponse.whenComplete(instrumentationListener.onComplete());
        }
        return roastResponse;
      }
      default: {
        return null;
      }
    }
  }

  public static final class Factory extends com.jauntsdn.rsocket.RpcService.ServerFactory<ChefServer> {

    public Factory(Chef service, java.util.Optional<com.jauntsdn.rsocket.RpcInstrumentation> instrumentation) {
      super(service, instrumentation);
    }

    public Factory(Chef service) {
      super(service);
    }

    @Override
    public ChefServer create(com.jauntsdn.rsocket.RpcInstrumentation rpcInstrumentation, io.netty.buffer.ByteBufAllocator allocator, com.jauntsdn.rsocket.Rpc.Codec rpcCodec) {
      return new ChefServer(service(), rpcInstrumentation, allocator, rpcCodec);
    }
  }
}
