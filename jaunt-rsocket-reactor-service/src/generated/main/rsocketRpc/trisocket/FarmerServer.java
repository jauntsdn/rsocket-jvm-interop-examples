package trisocket;

@javax.annotation.Generated(
    value = "jauntsdn.com rpc compiler (version 1.1.3)",
    comments = "source: service.proto")
@com.jauntsdn.rsocket.Rpc.Generated(
    role = com.jauntsdn.rsocket.Rpc.Role.SERVICE,
    service = Farmer.class)
public final class FarmerServer implements com.jauntsdn.rsocket.RpcService {
  private final java.util.concurrent.CompletableFuture onClose = new java.util.concurrent.CompletableFuture();
  private final Farmer service;
  private final io.netty.buffer.ByteBufAllocator allocator;
  private final java.util.function.Function<? super org.reactivestreams.Publisher<com.jauntsdn.rsocket.Message>, ? extends org.reactivestreams.Publisher<com.jauntsdn.rsocket.Message>> meatInstrumentation;
  private final java.util.function.Function<? super org.reactivestreams.Publisher<com.jauntsdn.rsocket.Message>, ? extends org.reactivestreams.Publisher<com.jauntsdn.rsocket.Message>> veggiesInstrumentation;
  private final com.jauntsdn.rsocket.Rpc.Codec rpcCodec;

  private FarmerServer(Farmer service, com.jauntsdn.rsocket.RpcInstrumentation instrumentation, io.netty.buffer.ByteBufAllocator allocator, com.jauntsdn.rsocket.Rpc.Codec rpcCodec) {
    this.service = service;
    this.rpcCodec = rpcCodec;
    this.allocator = allocator;
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

      switch (method) {
        case Farmer.METHOD_MEAT: {
          if (!Farmer.METHOD_MEAT_IDEMPOTENT && com.jauntsdn.rsocket.Rpc.RpcMetadata.flagIdempotentCall(flags)) {
            return reactor.core.publisher.Flux.error(new com.jauntsdn.rsocket.exceptions.RpcException("FarmerServer: idempotent call to non-idempotent method: " + method));
          }
          io.netty.buffer.ByteBuf messageData = message.data();
          com.google.protobuf.CodedInputStream is = com.google.protobuf.CodedInputStream.newInstance(messageData.internalNioBuffer(0, messageData.readableBytes()));
          reactor.core.publisher.Flux<com.jauntsdn.rsocket.Message> meat = service.meat(trisocket.Order.parseFrom(is), metadata).map(encode);
          if (meatInstrumentation != null) {
            return meat.transform(meatInstrumentation);
          }
          return meat;
        }
        case Farmer.METHOD_VEGGIES: {
          if (!Farmer.METHOD_VEGGIES_IDEMPOTENT && com.jauntsdn.rsocket.Rpc.RpcMetadata.flagIdempotentCall(flags)) {
            return reactor.core.publisher.Flux.error(new com.jauntsdn.rsocket.exceptions.RpcException("FarmerServer: idempotent call to non-idempotent method: " + method));
          }
          io.netty.buffer.ByteBuf messageData = message.data();
          com.google.protobuf.CodedInputStream is = com.google.protobuf.CodedInputStream.newInstance(messageData.internalNioBuffer(0, messageData.readableBytes()));
          reactor.core.publisher.Flux<com.jauntsdn.rsocket.Message> veggies = service.veggies(trisocket.Order.parseFrom(is), metadata).map(encode);
          if (veggiesInstrumentation != null) {
            return veggies.transform(veggiesInstrumentation);
          }
          return veggies;
        }
      }
      if (com.jauntsdn.rsocket.Rpc.RpcMetadata.flagForeignCall(flags)) {
        reactor.core.publisher.Mono<com.jauntsdn.rsocket.Message> handler = requestResponseHandler(flags, method, message.data(), metadata);
        if (handler != null) {
          return handler.flux();
        }
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
    message.release();
    return reactor.core.publisher.Flux.error(new com.jauntsdn.rsocket.exceptions.RpcException("FarmerServer: requestChannel not implemented"));
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

  private reactor.core.publisher.Mono<com.jauntsdn.rsocket.Message> requestResponseHandler(int flags, String method, io.netty.buffer.ByteBuf data, io.netty.buffer.ByteBuf metadata) throws java.io.IOException {
    return null;
  }

  private final java.util.function.Function<com.google.protobuf.MessageLite, com.jauntsdn.rsocket.Message> encode =
    new java.util.function.Function<com.google.protobuf.MessageLite, com.jauntsdn.rsocket.Message>() {
      @Override
      public com.jauntsdn.rsocket.Message apply(com.google.protobuf.MessageLite message) {
        int length = message.getSerializedSize();
        com.jauntsdn.rsocket.Rpc.Codec codec = rpcCodec;
        io.netty.buffer.ByteBuf content = codec.encodeContent(allocator, length);
        try {
          int writerIndex = content.writerIndex();
          message.writeTo(com.google.protobuf.CodedOutputStream.newInstance(content.internalNioBuffer(writerIndex, length)));
          content.writerIndex(writerIndex + length);
          return codec.encodeMessage(content);
        } catch (Throwable t) {
          content.release();
          com.jauntsdn.rsocket.exceptions.Exceptions.throwIfJvmFatal(t);
          throw new com.jauntsdn.rsocket.exceptions.SerializationException("FarmerServer: message serialization error", t);
        }
      }
    };

  private static <T> java.util.function.Function<com.jauntsdn.rsocket.Message, T> decode(final com.google.protobuf.Parser<T> parser) {
    return new java.util.function.Function<com.jauntsdn.rsocket.Message, T>() {
      @Override
      public T apply(com.jauntsdn.rsocket.Message message) {
        try {
          io.netty.buffer.ByteBuf messageData = message.data();
          com.google.protobuf.CodedInputStream is = com.google.protobuf.CodedInputStream.newInstance(messageData.internalNioBuffer(0, messageData.readableBytes()));
          return parser.parseFrom(is);
        } catch (Throwable t) {
          com.jauntsdn.rsocket.exceptions.Exceptions.throwIfJvmFatal(t);
          throw new com.jauntsdn.rsocket.exceptions.SerializationException("FarmerServer: message deserialization error", t);
        } finally {
          message.release();
        }
      }
    };
  }

  @javax.inject.Named(
      value ="FarmerServer")
  public static final class Factory implements com.jauntsdn.rsocket.RpcService.Factory<FarmerServer> {
    private final Farmer service;
    private final java.util.Optional<com.jauntsdn.rsocket.RpcInstrumentation> instrumentation;

    @javax.inject.Inject
    public Factory(Farmer service, java.util.Optional<com.jauntsdn.rsocket.RpcInstrumentation> instrumentation) {
      this.service = java.util.Objects.requireNonNull(service, "service");
      this.instrumentation = java.util.Objects.requireNonNull(instrumentation, "instrumentation");
    }

    public Factory(Farmer service) {
      this.service = java.util.Objects.requireNonNull(service, "service");
      this.instrumentation = null;
    }

    @Override
    public FarmerServer withLifecycle(com.jauntsdn.rsocket.Closeable requester) {
      java.util.Objects.requireNonNull(requester, "requester");
      com.jauntsdn.rsocket.Rpc.Codec codec = requester.attributes().attr(com.jauntsdn.rsocket.Attributes.RPC_CODEC);
      if (codec != null) {
        if (codec.isDisposable()) {
          requester.onClose().subscribe(ignored -> {}, err -> {}, () -> codec.dispose());
        }
        io.netty.buffer.ByteBufAllocator alloc = requester.attributes().attr(com.jauntsdn.rsocket.Attributes.ALLOCATOR);
        io.netty.buffer.ByteBufAllocator allocator = alloc != null ? alloc : io.netty.buffer.ByteBufAllocator.DEFAULT;
        java.util.Optional<com.jauntsdn.rsocket.RpcInstrumentation> instr = instrumentation;
        com.jauntsdn.rsocket.RpcInstrumentation rpcInstrumentation = instr == null
          ? requester.attributes().attr(com.jauntsdn.rsocket.Attributes.RPC_INSTRUMENTATION)
          : instr.orElse(null);
        return new FarmerServer(service, rpcInstrumentation, allocator, codec);
      }
      throw new IllegalArgumentException("Requester " + requester.getClass() + " does not provide RPC codec");
    }
  }
}
