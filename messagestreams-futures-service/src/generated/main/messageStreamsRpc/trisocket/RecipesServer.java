// Generated by jauntsdn.com rsocket-rpc compiler (version 1.5.4)
// source: service.proto

package trisocket;

@com.jauntsdn.rsocket.Rpc.Generated(
    role = com.jauntsdn.rsocket.Rpc.Role.SERVICE,
    service = Recipes.class)
@SuppressWarnings("all")
public final class RecipesServer implements com.jauntsdn.rsocket.RpcService {
  private final java.util.concurrent.CompletableFuture<Void> onClose = new java.util.concurrent.CompletableFuture<>();
  private final Recipes service;
  private final com.jauntsdn.rsocket.Rpc.Codec rpcCodec;
  private final java.util.function.Function<com.google.protobuf.MessageLite, com.jauntsdn.rsocket.Message> messageEncoder;
  private final com.jauntsdn.rsocket.RpcInstrumentation.Factory<com.jauntsdn.rsocket.Message> marinadeInstrumentation;

  private RecipesServer(Recipes service, com.jauntsdn.rsocket.RpcInstrumentation instrumentation, io.netty.buffer.ByteBufAllocator allocator, com.jauntsdn.rsocket.Rpc.Codec rpcCodec) {
    this.messageEncoder = com.jauntsdn.rsocket.generated.ProtobufCodec.encode("RecipesServer", allocator, rpcCodec);
    this.service = service;
    this.rpcCodec = rpcCodec;
    if (instrumentation == null) {
      this.marinadeInstrumentation = null;
    } else {
      this.marinadeInstrumentation = instrumentation.instrument("service", Recipes.SERVICE, Recipes.METHOD_MARINADE, true);
    }
  }

  public static RecipesServer.Factory create(Recipes service, java.util.Optional<com.jauntsdn.rsocket.RpcInstrumentation> instrumentation) {
    return new RecipesServer.Factory(service, instrumentation);
  }

  public static RecipesServer.Factory create(Recipes service) {
    return new RecipesServer.Factory(service);
  }

  @Override
  public String service() {
    return Recipes.SERVICE;
  }

  @Override
  public Class<?> serviceType() {
    return Recipes.SERVICE_TYPE;
  }

  @Override
  public java.util.concurrent.CompletionStage<Void> fireAndForget(com.jauntsdn.rsocket.Message message) {
    message.release();
    return com.jauntsdn.rsocket.RpcHandler.completedFuture(new com.jauntsdn.rsocket.exceptions.RpcException("RecipesServer: fireAndForget not implemented"));
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
      return com.jauntsdn.rsocket.RpcHandler.completedFuture(new com.jauntsdn.rsocket.exceptions.RpcException("RecipesServer: requestResponse not implemented"));
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
      case Recipes.METHOD_MARINADE: {
        if (!Recipes.METHOD_MARINADE_IDEMPOTENT && com.jauntsdn.rsocket.Rpc.RpcMetadata.flagIdempotentCall(flags)) {
          return com.jauntsdn.rsocket.RpcHandler.completedFuture(new com.jauntsdn.rsocket.exceptions.RpcException("RecipesServer: idempotent call to non-idempotent method: " + method));
        }
        com.google.protobuf.CodedInputStream is = com.google.protobuf.CodedInputStream.newInstance(data.internalNioBuffer(0, data.readableBytes()));
        com.jauntsdn.rsocket.RpcInstrumentation.Listener<com.jauntsdn.rsocket.Message> instrumentationListener = null;
        if (marinadeInstrumentation != null) {
          instrumentationListener = marinadeInstrumentation.create();
          instrumentationListener.onStart();
        }
        com.jauntsdn.rsocket.Headers marinadeHeaders = com.jauntsdn.rsocket.generated.ProtobufCodec.decodeHeaders(metadata);
        java.util.concurrent.CompletionStage<trisocket.Recipe> marinadeResponse = service.marinade(trisocket.Meat.parseFrom(is), marinadeHeaders);
        java.util.concurrent.CompletionStage<com.jauntsdn.rsocket.Message> marinadeMessageResponse = marinadeResponse.thenApply(messageEncoder);
        if (instrumentationListener != null) {
          marinadeMessageResponse.whenComplete(com.jauntsdn.rsocket.RpcService.ResponseListener.create(marinadeResponse, instrumentationListener.onComplete()));
          return marinadeMessageResponse;
        }
        marinadeMessageResponse.whenComplete(com.jauntsdn.rsocket.RpcService.ResponseListener.create(marinadeResponse));
        return marinadeMessageResponse;
      }
      default: {
        return null;
      }
    }
  }

  public static final class Factory extends com.jauntsdn.rsocket.RpcService.ServerFactory<RecipesServer> {

    public Factory(Recipes service, java.util.Optional<com.jauntsdn.rsocket.RpcInstrumentation> instrumentation) {
      super(service, instrumentation);
    }

    public Factory(Recipes service) {
      super(service);
    }

    @Override
    public RecipesServer create(com.jauntsdn.rsocket.RpcInstrumentation rpcInstrumentation, io.netty.buffer.ByteBufAllocator allocator, com.jauntsdn.rsocket.Rpc.Codec rpcCodec) {
      return new RecipesServer(service(), rpcInstrumentation, allocator, rpcCodec);
    }
  }
}
