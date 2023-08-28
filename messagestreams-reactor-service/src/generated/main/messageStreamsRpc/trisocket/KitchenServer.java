package trisocket;

@javax.annotation.Generated(
    value = "jauntsdn.com rpc compiler (version 1.5.1)",
    comments = "source: service.proto")
@com.jauntsdn.rsocket.Rpc.Generated(
    role = com.jauntsdn.rsocket.Rpc.Role.SERVICE,
    service = Kitchen.class)
@SuppressWarnings("all")
public final class KitchenServer implements com.jauntsdn.rsocket.RpcService {
  private final java.util.concurrent.CompletableFuture<Void> onClose = new java.util.concurrent.CompletableFuture<>();
  private final Kitchen service;
  private final java.util.function.Function<com.google.protobuf.MessageLite, com.jauntsdn.rsocket.Message> messageEncoder;
  private final com.jauntsdn.rsocket.Rpc.Codec rpcCodec;
  private final java.util.function.Function<? super org.reactivestreams.Publisher<com.jauntsdn.rsocket.Message>, ? extends org.reactivestreams.Publisher<com.jauntsdn.rsocket.Message>> serveInstrumentation;

  private KitchenServer(Kitchen service, com.jauntsdn.rsocket.RpcInstrumentation instrumentation, io.netty.buffer.ByteBufAllocator allocator, com.jauntsdn.rsocket.Rpc.Codec rpcCodec) {
    this.messageEncoder = com.jauntsdn.rsocket.generated.ProtobufCodec.encode("KitchenServer", allocator, rpcCodec);
    this.service = service;
    this.rpcCodec = rpcCodec;
    if (instrumentation == null) {
      this.serveInstrumentation = null;
    } else {
      this.serveInstrumentation = instrumentation.instrument("service", Kitchen.SERVICE, Kitchen.METHOD_SERVE, true);
    }
  }

  public static KitchenServer.Factory create(Kitchen service, java.util.Optional<com.jauntsdn.rsocket.RpcInstrumentation> instrumentation) {
    return new KitchenServer.Factory(service, instrumentation);
  }

  public static KitchenServer.Factory create(Kitchen service) {
    return new KitchenServer.Factory(service);
  }

  @Override
  public String service() {
    return Kitchen.SERVICE;
  }

  @Override
  public Class<?> serviceType() {
    return Kitchen.SERVICE_TYPE;
  }

  @Override
  public reactor.core.publisher.Mono<Void> fireAndForget(com.jauntsdn.rsocket.Message message) {
    message.release();
    return reactor.core.publisher.Mono.error(new com.jauntsdn.rsocket.exceptions.RpcException("KitchenServer: fireAndForget not implemented"));
  }

  @Override
  public reactor.core.publisher.Mono<com.jauntsdn.rsocket.Message> requestResponse(com.jauntsdn.rsocket.Message message) {
    message.release();
    return reactor.core.publisher.Mono.error(new com.jauntsdn.rsocket.exceptions.RpcException("KitchenServer: requestResponse not implemented"));
  }

  @Override
  public reactor.core.publisher.Flux<com.jauntsdn.rsocket.Message> requestStream(com.jauntsdn.rsocket.Message message) {
    message.release();
    return reactor.core.publisher.Flux.error(new com.jauntsdn.rsocket.exceptions.RpcException("KitchenServer: requestStream not implemented"));
  }

  @Override
  public reactor.core.publisher.Flux<com.jauntsdn.rsocket.Message> requestChannel(com.jauntsdn.rsocket.Message message, org.reactivestreams.Publisher<com.jauntsdn.rsocket.Message> publisher) {
    try {
      io.netty.buffer.ByteBuf metadata = message.metadata();
      long header = com.jauntsdn.rsocket.Rpc.RpcMetadata.header(metadata);
      int flags = com.jauntsdn.rsocket.Rpc.RpcMetadata.flags(header);
      String method = rpcCodec.decodeMessageMethod(metadata, header, flags);

      switch (method) {
        case Kitchen.METHOD_SERVE: {
          if (!Kitchen.METHOD_SERVE_IDEMPOTENT && com.jauntsdn.rsocket.Rpc.RpcMetadata.flagIdempotentCall(flags)) {
            message.release();
            return reactor.core.publisher.Flux.error(new com.jauntsdn.rsocket.exceptions.RpcException("KitchenServer: idempotent call to non-idempotent method: " + method));
          }
          reactor.core.publisher.Flux<trisocket.Order> messages =
            reactor.core.publisher.Flux.from(publisher).map(com.jauntsdn.rsocket.generated.ProtobufCodec.decode("KitchenServer", trisocket.Order.parser()));
          com.jauntsdn.rsocket.Headers serveHeaders = com.jauntsdn.rsocket.generated.ProtobufCodec.decodeHeaders(metadata);
          reactor.core.publisher.Flux<com.jauntsdn.rsocket.Message> serve = service.serve(messages, serveHeaders).map(messageEncoder);
          if (serveInstrumentation != null) {
            return serve.transform(serveInstrumentation);
          }
          return serve;
        }
      }
      message.release();
      return reactor.core.publisher.Flux.error(new com.jauntsdn.rsocket.exceptions.RpcException("KitchenServer: requestChannel unknown method: " + method));
    } catch (Throwable t) {
      io.netty.util.ReferenceCountUtil.safeRelease(message);
      return reactor.core.publisher.Flux.error(t);
    }
  }

  @Override
  public reactor.core.publisher.Flux<com.jauntsdn.rsocket.Message> requestChannel(org.reactivestreams.Publisher<com.jauntsdn.rsocket.Message> messages) {
    return reactor.core.publisher.Flux.error(new com.jauntsdn.rsocket.exceptions.RpcException("KitchenServer: unsupported method: requestChannel(Publisher<Message>)"));
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

  @javax.inject.Named(
      value ="KitchenServer")
  public static final class Factory extends com.jauntsdn.rsocket.RpcService.ServerFactory<KitchenServer> {

    @javax.inject.Inject
    public Factory(Kitchen service, java.util.Optional<com.jauntsdn.rsocket.RpcInstrumentation> instrumentation) {
      super(service, instrumentation);
    }

    public Factory(Kitchen service) {
      super(service);
    }

    @Override
    public KitchenServer create(com.jauntsdn.rsocket.RpcInstrumentation rpcInstrumentation, io.netty.buffer.ByteBufAllocator allocator, com.jauntsdn.rsocket.Rpc.Codec rpcCodec) {
      return new KitchenServer(service(), rpcInstrumentation, allocator, rpcCodec);
    }
  }
}
