package trisocket;

@jakarta.annotation.Generated(
    value = "jauntsdn.com rpc compiler (version 1.2.0)",
    comments = "source: service.proto")
@com.jauntsdn.rsocket.Rpc.Generated(
    role = com.jauntsdn.rsocket.Rpc.Role.SERVICE,
    service = Farmer.class)
@SuppressWarnings("all")
public final class FarmerServer implements com.jauntsdn.rsocket.RpcService {
  private final java.util.concurrent.CompletableFuture<Void> onClose = new java.util.concurrent.CompletableFuture<>();
  private final Farmer service;
  private final io.netty.buffer.ByteBufAllocator allocator;
  private final java.util.function.Function<? super java.util.concurrent.Flow.Publisher<com.jauntsdn.rsocket.Message>, ? extends java.util.concurrent.Flow.Publisher<com.jauntsdn.rsocket.Message>> meatInstrumentation;
  private final java.util.function.Function<? super java.util.concurrent.Flow.Publisher<com.jauntsdn.rsocket.Message>, ? extends java.util.concurrent.Flow.Publisher<com.jauntsdn.rsocket.Message>> veggiesInstrumentation;
  private final com.jauntsdn.rsocket.Rpc.Codec rpcCodec;

  private FarmerServer(Farmer service, com.jauntsdn.rsocket.RpcInstrumentation instrumentation, io.netty.buffer.ByteBufAllocator allocator, com.jauntsdn.rsocket.Rpc.Codec rpcCodec) {
    this.service = service;
    this.rpcCodec = rpcCodec;
    this.allocator = allocator;
    if (instrumentation == null) {
      this.meatInstrumentation = null;
      this.veggiesInstrumentation = null;
    } else {
      this.meatInstrumentation = instrumentation.instrumentMulti("service", Farmer.SERVICE, Farmer.METHOD_MEAT, true);
      this.veggiesInstrumentation = instrumentation.instrumentMulti("service", Farmer.SERVICE, Farmer.METHOD_VEGGIES, true);
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
  public io.helidon.common.reactive.Single<Void> fireAndForget(com.jauntsdn.rsocket.Message message) {
    message.release();
    return io.helidon.common.reactive.Single.error(new com.jauntsdn.rsocket.exceptions.RpcException("FarmerServer: fireAndForget not implemented"));
  }

  @Override
  public io.helidon.common.reactive.Single<com.jauntsdn.rsocket.Message> requestResponse(com.jauntsdn.rsocket.Message message) {
    message.release();
    return io.helidon.common.reactive.Single.error(new com.jauntsdn.rsocket.exceptions.RpcException("FarmerServer: requestResponse not implemented"));
  }

  @Override
  public io.helidon.common.reactive.Multi<com.jauntsdn.rsocket.Message> requestStream(com.jauntsdn.rsocket.Message message) {
    try {
      io.netty.buffer.ByteBuf metadata = message.metadata();
      long header = com.jauntsdn.rsocket.Rpc.RpcMetadata.header(metadata);
      int flags = com.jauntsdn.rsocket.Rpc.RpcMetadata.flags(header);
      String method = rpcCodec.decodeMessageMethod(metadata, header, flags);

      io.helidon.common.reactive.Multi<com.jauntsdn.rsocket.Message> handler = requestStreamHandler(flags, method, message.data(), metadata);
      if (handler != null) {
        return handler;
      }
      return io.helidon.common.reactive.Multi.error(new com.jauntsdn.rsocket.exceptions.RpcException("FarmerServer: requestStream unknown method: " + method));
    } catch (Throwable t) {
      return io.helidon.common.reactive.Multi.error(t);
    } finally {
      message.release();
    }
  }

  @Override
  public io.helidon.common.reactive.Multi<com.jauntsdn.rsocket.Message> requestChannel(com.jauntsdn.rsocket.Message message, java.util.concurrent.Flow.Publisher<com.jauntsdn.rsocket.Message> publisher) {
    try {
      io.netty.buffer.ByteBuf metadata = message.metadata();
      long header = com.jauntsdn.rsocket.Rpc.RpcMetadata.header(metadata);
      int flags = com.jauntsdn.rsocket.Rpc.RpcMetadata.flags(header);
      String method = rpcCodec.decodeMessageMethod(metadata, header, flags);

      if (com.jauntsdn.rsocket.Rpc.RpcMetadata.flagForeignCall(flags)) {
        io.helidon.common.reactive.Multi<com.jauntsdn.rsocket.Message> streamHandler = requestStreamHandler(flags, method, message.data(), metadata);
        if (streamHandler != null) {
          message.release();
          return streamHandler;
        }
        io.helidon.common.reactive.Single<com.jauntsdn.rsocket.Message> responseHandler = requestResponseHandler(flags, method, message.data(), metadata);
        if (responseHandler != null) {
          message.release();
          return io.helidon.common.reactive.Multi.create(responseHandler);
        }
      }
      message.release();
      return io.helidon.common.reactive.Multi.error(new com.jauntsdn.rsocket.exceptions.RpcException("FarmerServer: requestChannel unknown method: " + method));
    } catch (Throwable t) {
      io.netty.util.ReferenceCountUtil.safeRelease(message);
      return io.helidon.common.reactive.Multi.error(t);
    }
  }

  @Override
  public io.helidon.common.reactive.Multi<com.jauntsdn.rsocket.Message> requestChannel(java.util.concurrent.Flow.Publisher<com.jauntsdn.rsocket.Message> messages) {
    return io.helidon.common.reactive.Multi.error(new com.jauntsdn.rsocket.exceptions.RpcException("FarmerServer: unsupported method: requestChannel(Publisher<Message>)"));
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
  public io.helidon.common.reactive.Single<Void> onClose() {
    return io.helidon.common.reactive.Single.create(onClose, true);
  }

  private io.helidon.common.reactive.Single<com.jauntsdn.rsocket.Message> requestResponseHandler(int flags, String method, io.netty.buffer.ByteBuf data, io.netty.buffer.ByteBuf metadata) throws java.io.IOException {
    return null;
  }

  private io.helidon.common.reactive.Multi<com.jauntsdn.rsocket.Message> requestStreamHandler(int flags, String method, io.netty.buffer.ByteBuf data, io.netty.buffer.ByteBuf metadata) throws java.io.IOException {
    switch (method) {
      case Farmer.METHOD_MEAT: {
        if (!Farmer.METHOD_MEAT_IDEMPOTENT && com.jauntsdn.rsocket.Rpc.RpcMetadata.flagIdempotentCall(flags)) {
          return io.helidon.common.reactive.Multi.error(new com.jauntsdn.rsocket.exceptions.RpcException("FarmerServer: idempotent call to non-idempotent method: " + method));
        }
        com.google.protobuf.CodedInputStream is = com.google.protobuf.CodedInputStream.newInstance(data.internalNioBuffer(0, data.readableBytes()));
        io.helidon.common.reactive.Multi<com.jauntsdn.rsocket.Message> meat = service.meat(trisocket.Order.parseFrom(is), metadata).map(encode);
        if (meatInstrumentation != null) {
          return meat.compose(meatInstrumentation);
        }
        return meat;
      }
      case Farmer.METHOD_VEGGIES: {
        if (!Farmer.METHOD_VEGGIES_IDEMPOTENT && com.jauntsdn.rsocket.Rpc.RpcMetadata.flagIdempotentCall(flags)) {
          return io.helidon.common.reactive.Multi.error(new com.jauntsdn.rsocket.exceptions.RpcException("FarmerServer: idempotent call to non-idempotent method: " + method));
        }
        com.google.protobuf.CodedInputStream is = com.google.protobuf.CodedInputStream.newInstance(data.internalNioBuffer(0, data.readableBytes()));
        io.helidon.common.reactive.Multi<com.jauntsdn.rsocket.Message> veggies = service.veggies(trisocket.Order.parseFrom(is), metadata).map(encode);
        if (veggiesInstrumentation != null) {
          return veggies.compose(veggiesInstrumentation);
        }
        return veggies;
      }
      default: {
        return null;
      }
    }
  }

  private final java.util.function.Function<com.google.protobuf.MessageLite, com.jauntsdn.rsocket.Message> encode =
    new java.util.function.Function<com.google.protobuf.MessageLite, com.jauntsdn.rsocket.Message>() {
      @Override
      public com.jauntsdn.rsocket.Message apply(com.google.protobuf.MessageLite message) {
        int length = message.getSerializedSize();
        com.jauntsdn.rsocket.Rpc.Codec codec = rpcCodec;
        io.netty.buffer.ByteBuf byteBuf = codec.encodeContent(allocator, length);
        try {
          int writerIndex = byteBuf.writerIndex();
          message.writeTo(com.google.protobuf.CodedOutputStream.newInstance(byteBuf.internalNioBuffer(writerIndex, length)));
          byteBuf.writerIndex(writerIndex + length);
          return codec.encodeMessage(byteBuf);
        } catch (Throwable t) {
          byteBuf.release();
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

  @jakarta.inject.Named(
      value ="FarmerServer")
  public static final class Factory implements com.jauntsdn.rsocket.RpcService.Factory<FarmerServer> {
    private final Farmer service;
    private final java.util.Optional<com.jauntsdn.rsocket.RpcInstrumentation> instrumentation;

    @jakarta.inject.Inject
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
