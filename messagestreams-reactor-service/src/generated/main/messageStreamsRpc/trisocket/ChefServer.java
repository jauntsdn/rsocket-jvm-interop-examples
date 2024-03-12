package trisocket;

@javax.annotation.Generated(
    value = "jauntsdn.com rpc compiler (version 1.5.4)",
    comments = "source: service.proto")
@com.jauntsdn.rsocket.Rpc.Generated(
    role = com.jauntsdn.rsocket.Rpc.Role.SERVICE,
    service = Chef.class)
@SuppressWarnings("all")
public final class ChefServer implements com.jauntsdn.rsocket.RpcService {
  private final java.util.concurrent.CompletableFuture<Void> onClose = new java.util.concurrent.CompletableFuture<>();
  private final Chef service;
  private final java.util.function.Function<com.google.protobuf.MessageLite, com.jauntsdn.rsocket.Message> messageEncoder;
  private final com.jauntsdn.rsocket.Rpc.Codec rpcCodec;
  private final java.util.function.Function<? super org.reactivestreams.Publisher<com.jauntsdn.rsocket.Message>, ? extends org.reactivestreams.Publisher<com.jauntsdn.rsocket.Message>> roastInstrumentation;

  private ChefServer(Chef service, com.jauntsdn.rsocket.RpcInstrumentation instrumentation, io.netty.buffer.ByteBufAllocator allocator, com.jauntsdn.rsocket.Rpc.Codec rpcCodec) {
    this.messageEncoder = com.jauntsdn.rsocket.generated.ProtobufCodec.encode("ChefServer", allocator, rpcCodec);
    this.service = service;
    this.rpcCodec = rpcCodec;
    if (instrumentation == null) {
      this.roastInstrumentation = null;
    } else {
      this.roastInstrumentation = instrumentation.instrument("service", Chef.SERVICE, Chef.METHOD_ROAST, false);
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
  public reactor.core.publisher.Mono<Void> fireAndForget(com.jauntsdn.rsocket.Message message) {
    message.release();
    return reactor.core.publisher.Mono.error(new com.jauntsdn.rsocket.exceptions.RpcException("ChefServer: fireAndForget not implemented"));
  }

  @Override
  public reactor.core.publisher.Mono<com.jauntsdn.rsocket.Message> requestResponse(com.jauntsdn.rsocket.Message message) {
    try {
      io.netty.buffer.ByteBuf metadata = message.metadata();
      long header = com.jauntsdn.rsocket.Rpc.RpcMetadata.header(metadata);
      int flags = com.jauntsdn.rsocket.Rpc.RpcMetadata.flags(header);
      String method = rpcCodec.decodeMessageMethod(metadata, header, flags);

      reactor.core.publisher.Mono<com.jauntsdn.rsocket.Message> handler = requestResponseHandler(flags, method, message.data(), metadata);
      if (handler != null) {
        return handler;
      }
      return reactor.core.publisher.Mono.error(new com.jauntsdn.rsocket.exceptions.RpcException("ChefServer: requestResponse not implemented"));
    } catch (Throwable t) {
      return reactor.core.publisher.Mono.error(t);
    } finally {
      message.release();
    }
  }

  @Override
  public reactor.core.publisher.Flux<com.jauntsdn.rsocket.Message> requestStream(com.jauntsdn.rsocket.Message message) {
    message.release();
    return reactor.core.publisher.Flux.error(new com.jauntsdn.rsocket.exceptions.RpcException("ChefServer: requestStream not implemented"));
  }

  @Override
  public reactor.core.publisher.Flux<com.jauntsdn.rsocket.Message> requestChannel(com.jauntsdn.rsocket.Message message, org.reactivestreams.Publisher<com.jauntsdn.rsocket.Message> publisher) {
    try {
      io.netty.buffer.ByteBuf metadata = message.metadata();
      long header = com.jauntsdn.rsocket.Rpc.RpcMetadata.header(metadata);
      int flags = com.jauntsdn.rsocket.Rpc.RpcMetadata.flags(header);
      String method = rpcCodec.decodeMessageMethod(metadata, header, flags);

      if (com.jauntsdn.rsocket.Rpc.RpcMetadata.flagForeignCall(flags)) {
        reactor.core.publisher.Mono<com.jauntsdn.rsocket.Message> responseHandler = requestResponseHandler(flags, method, message.data(), metadata);
        if (responseHandler != null) {
          message.release();
          return responseHandler.flux();
        }
      }
      message.release();
      return reactor.core.publisher.Flux.error(new com.jauntsdn.rsocket.exceptions.RpcException("ChefServer: requestChannel unknown method: " + method));
    } catch (Throwable t) {
      io.netty.util.ReferenceCountUtil.safeRelease(message);
      return reactor.core.publisher.Flux.error(t);
    }
  }

  @Override
  public reactor.core.publisher.Flux<com.jauntsdn.rsocket.Message> requestChannel(org.reactivestreams.Publisher<com.jauntsdn.rsocket.Message> messages) {
    return reactor.core.publisher.Flux.error(new com.jauntsdn.rsocket.exceptions.RpcException("ChefServer: requestChannel not implemented"));
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
  public reactor.core.publisher.Mono<Void> onClose() {
    return reactor.core.publisher.Mono.fromFuture(onClose);
  }

  private reactor.core.publisher.Mono<com.jauntsdn.rsocket.Message> requestResponseHandler(int flags, String method, io.netty.buffer.ByteBuf data, io.netty.buffer.ByteBuf metadata) throws java.io.IOException {
    switch (method) {
      case Chef.METHOD_ROAST: {
        if (!Chef.METHOD_ROAST_IDEMPOTENT && com.jauntsdn.rsocket.Rpc.RpcMetadata.flagIdempotentCall(flags)) {
          return reactor.core.publisher.Mono.error(new com.jauntsdn.rsocket.exceptions.RpcException("ChefServer: idempotent call to non-idempotent method: " + method));
        }
        com.google.protobuf.CodedInputStream is = com.google.protobuf.CodedInputStream.newInstance(data.internalNioBuffer(0, data.readableBytes()));
        com.jauntsdn.rsocket.Headers roastHeaders = com.jauntsdn.rsocket.generated.ProtobufCodec.decodeHeaders(metadata);
        reactor.core.publisher.Mono<com.jauntsdn.rsocket.Message> roast = service.roast(trisocket.Pan.parseFrom(is), roastHeaders).map(messageEncoder);
        if (roastInstrumentation != null) {
          return roast.transform(roastInstrumentation);
        }
        return roast;
      }
      default: {
        return null;
      }
    }
  }

  @javax.inject.Named(
      value ="ChefServer")
  public static final class Factory extends com.jauntsdn.rsocket.RpcService.ServerFactory<ChefServer> {

    @javax.inject.Inject
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
