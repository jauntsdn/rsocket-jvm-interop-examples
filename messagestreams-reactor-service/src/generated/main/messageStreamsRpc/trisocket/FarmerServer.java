package trisocket;

@javax.annotation.Generated(
    value = "jauntsdn.com rpc compiler (version 1.5.2)",
    comments = "source: service.proto")
@com.jauntsdn.rsocket.Rpc.Generated(
    role = com.jauntsdn.rsocket.Rpc.Role.SERVICE,
    service = Farmer.class)
@SuppressWarnings("all")
public final class FarmerServer implements com.jauntsdn.rsocket.RpcService {
  private final java.util.concurrent.CompletableFuture<Void> onClose = new java.util.concurrent.CompletableFuture<>();
  private final Farmer service;
  private final java.util.function.Function<com.google.protobuf.MessageLite, com.jauntsdn.rsocket.Message> messageEncoder;
  private final com.jauntsdn.rsocket.Rpc.Codec rpcCodec;
  private final java.util.function.Function<? super org.reactivestreams.Publisher<com.jauntsdn.rsocket.Message>, ? extends org.reactivestreams.Publisher<com.jauntsdn.rsocket.Message>> meatInstrumentation;
  private final java.util.function.Function<? super org.reactivestreams.Publisher<com.jauntsdn.rsocket.Message>, ? extends org.reactivestreams.Publisher<com.jauntsdn.rsocket.Message>> veggiesInstrumentation;

  private FarmerServer(Farmer service, com.jauntsdn.rsocket.RpcInstrumentation instrumentation, io.netty.buffer.ByteBufAllocator allocator, com.jauntsdn.rsocket.Rpc.Codec rpcCodec) {
    this.messageEncoder = com.jauntsdn.rsocket.generated.ProtobufCodec.encode("FarmerServer", allocator, rpcCodec);
    this.service = service;
    this.rpcCodec = rpcCodec;
    if (instrumentation == null) {
      this.meatInstrumentation = null;
      this.veggiesInstrumentation = null;
    } else {
      this.meatInstrumentation = instrumentation.instrument("service", Farmer.SERVICE, Farmer.METHOD_MEAT, true);
      this.veggiesInstrumentation = instrumentation.instrument("service", Farmer.SERVICE, Farmer.METHOD_VEGGIES, true);
    }
  }

  public static FarmerServer.Factory create(Farmer service, java.util.Optional<com.jauntsdn.rsocket.RpcInstrumentation> instrumentation) {
    return new FarmerServer.Factory(service, instrumentation);
  }

  public static FarmerServer.Factory create(Farmer service) {
    return new FarmerServer.Factory(service);
  }

  @Override
  public String service() {
    return Farmer.SERVICE;
  }

  @Override
  public Class<?> serviceType() {
    return Farmer.SERVICE_TYPE;
  }

  @Override
  public reactor.core.publisher.Mono<Void> fireAndForget(com.jauntsdn.rsocket.Message message) {
    message.release();
    return reactor.core.publisher.Mono.error(new com.jauntsdn.rsocket.exceptions.RpcException("FarmerServer: fireAndForget not implemented"));
  }

  @Override
  public reactor.core.publisher.Mono<com.jauntsdn.rsocket.Message> requestResponse(com.jauntsdn.rsocket.Message message) {
    message.release();
    return reactor.core.publisher.Mono.error(new com.jauntsdn.rsocket.exceptions.RpcException("FarmerServer: requestResponse not implemented"));
  }

  @Override
  public reactor.core.publisher.Flux<com.jauntsdn.rsocket.Message> requestStream(com.jauntsdn.rsocket.Message message) {
    try {
      io.netty.buffer.ByteBuf metadata = message.metadata();
      long header = com.jauntsdn.rsocket.Rpc.RpcMetadata.header(metadata);
      int flags = com.jauntsdn.rsocket.Rpc.RpcMetadata.flags(header);
      String method = rpcCodec.decodeMessageMethod(metadata, header, flags);

      reactor.core.publisher.Flux<com.jauntsdn.rsocket.Message> handler = requestStreamHandler(flags, method, message.data(), metadata);
      if (handler != null) {
        return handler;
      }
      return reactor.core.publisher.Flux.error(new com.jauntsdn.rsocket.exceptions.RpcException("FarmerServer: requestStream unknown method: " + method));
    } catch (Throwable t) {
      return reactor.core.publisher.Flux.error(t);
    } finally {
      message.release();
    }
  }

  @Override
  public reactor.core.publisher.Flux<com.jauntsdn.rsocket.Message> requestChannel(com.jauntsdn.rsocket.Message message, org.reactivestreams.Publisher<com.jauntsdn.rsocket.Message> publisher) {
    try {
      io.netty.buffer.ByteBuf metadata = message.metadata();
      long header = com.jauntsdn.rsocket.Rpc.RpcMetadata.header(metadata);
      int flags = com.jauntsdn.rsocket.Rpc.RpcMetadata.flags(header);
      String method = rpcCodec.decodeMessageMethod(metadata, header, flags);

      if (com.jauntsdn.rsocket.Rpc.RpcMetadata.flagForeignCall(flags)) {
        reactor.core.publisher.Flux<com.jauntsdn.rsocket.Message> streamHandler = requestStreamHandler(flags, method, message.data(), metadata);
        if (streamHandler != null) {
          message.release();
          return streamHandler;
        }
      }
      message.release();
      return reactor.core.publisher.Flux.error(new com.jauntsdn.rsocket.exceptions.RpcException("FarmerServer: requestChannel unknown method: " + method));
    } catch (Throwable t) {
      io.netty.util.ReferenceCountUtil.safeRelease(message);
      return reactor.core.publisher.Flux.error(t);
    }
  }

  @Override
  public reactor.core.publisher.Flux<com.jauntsdn.rsocket.Message> requestChannel(org.reactivestreams.Publisher<com.jauntsdn.rsocket.Message> messages) {
    return reactor.core.publisher.Flux.error(new com.jauntsdn.rsocket.exceptions.RpcException("FarmerServer: requestChannel not implemented"));
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

  private reactor.core.publisher.Flux<com.jauntsdn.rsocket.Message> requestStreamHandler(int flags, String method, io.netty.buffer.ByteBuf data, io.netty.buffer.ByteBuf metadata) throws java.io.IOException {
    switch (method) {
      case Farmer.METHOD_MEAT: {
        if (!Farmer.METHOD_MEAT_IDEMPOTENT && com.jauntsdn.rsocket.Rpc.RpcMetadata.flagIdempotentCall(flags)) {
          return reactor.core.publisher.Flux.error(new com.jauntsdn.rsocket.exceptions.RpcException("FarmerServer: idempotent call to non-idempotent method: " + method));
        }
        com.google.protobuf.CodedInputStream is = com.google.protobuf.CodedInputStream.newInstance(data.internalNioBuffer(0, data.readableBytes()));
        com.jauntsdn.rsocket.Headers meatHeaders = com.jauntsdn.rsocket.generated.ProtobufCodec.decodeHeaders(metadata);
        reactor.core.publisher.Flux<com.jauntsdn.rsocket.Message> meat = service.meat(trisocket.Order.parseFrom(is), meatHeaders).map(messageEncoder);
        if (meatInstrumentation != null) {
          return meat.transform(meatInstrumentation);
        }
        return meat;
      }
      case Farmer.METHOD_VEGGIES: {
        if (!Farmer.METHOD_VEGGIES_IDEMPOTENT && com.jauntsdn.rsocket.Rpc.RpcMetadata.flagIdempotentCall(flags)) {
          return reactor.core.publisher.Flux.error(new com.jauntsdn.rsocket.exceptions.RpcException("FarmerServer: idempotent call to non-idempotent method: " + method));
        }
        com.google.protobuf.CodedInputStream is = com.google.protobuf.CodedInputStream.newInstance(data.internalNioBuffer(0, data.readableBytes()));
        com.jauntsdn.rsocket.Headers veggiesHeaders = com.jauntsdn.rsocket.generated.ProtobufCodec.decodeHeaders(metadata);
        reactor.core.publisher.Flux<com.jauntsdn.rsocket.Message> veggies = service.veggies(trisocket.Order.parseFrom(is), veggiesHeaders).map(messageEncoder);
        if (veggiesInstrumentation != null) {
          return veggies.transform(veggiesInstrumentation);
        }
        return veggies;
      }
      default: {
        return null;
      }
    }
  }

  @javax.inject.Named(
      value ="FarmerServer")
  public static final class Factory extends com.jauntsdn.rsocket.RpcService.ServerFactory<FarmerServer> {

    @javax.inject.Inject
    public Factory(Farmer service, java.util.Optional<com.jauntsdn.rsocket.RpcInstrumentation> instrumentation) {
      super(service, instrumentation);
    }

    public Factory(Farmer service) {
      super(service);
    }

    @Override
    public FarmerServer create(com.jauntsdn.rsocket.RpcInstrumentation rpcInstrumentation, io.netty.buffer.ByteBufAllocator allocator, com.jauntsdn.rsocket.Rpc.Codec rpcCodec) {
      return new FarmerServer(service(), rpcInstrumentation, allocator, rpcCodec);
    }
  }
}
