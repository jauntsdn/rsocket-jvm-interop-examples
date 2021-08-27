package trisocket;

@javax.annotation.Generated(
    value = "jauntsdn.com rsocket-rpc compiler (version 1.0.0)",
    comments = "source: service.proto")
@com.jauntsdn.rsocket.Rpc.Generated(
    role = com.jauntsdn.rsocket.Rpc.Role.SERVICE,
    service = Kitchen.class)
public final class KitchenServer implements com.jauntsdn.rsocket.RSocketRpcService {
  private final Kitchen service;
  private final io.netty.buffer.ByteBufAllocator allocator;
  private final java.util.function.Function<? super java.util.concurrent.Flow.Publisher<com.jauntsdn.rsocket.Message>, ? extends java.util.concurrent.Flow.Publisher<com.jauntsdn.rsocket.Message>> serveInstrumentation;
  private final com.jauntsdn.rsocket.Rpc.Codec rpcCodec;

  private KitchenServer(Kitchen service, java.util.Optional<com.jauntsdn.rsocket.RSocketRpcInstrumentation> instrumentation, io.netty.buffer.ByteBufAllocator allocator, com.jauntsdn.rsocket.Rpc.Codec rpcCodec) {
    this.service = service;
    this.rpcCodec = rpcCodec;
    this.allocator = allocator;
    if (!instrumentation.isPresent()) {
      this.serveInstrumentation = null;
    } else {
      com.jauntsdn.rsocket.RSocketRpcInstrumentation i = instrumentation.get();
      this.serveInstrumentation = i.instrumentMulti("service", Kitchen.SERVICE, Kitchen.METHOD_SERVE, true);
    }
  }

  public static KitchenServer.Factory create(Kitchen service, java.util.Optional<com.jauntsdn.rsocket.RSocketRpcInstrumentation> instrumentation) {
    return new KitchenServer.Factory(service, instrumentation);
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
  public io.helidon.common.reactive.Single<Void> fireAndForget(com.jauntsdn.rsocket.Message message) {
    message.release();
    return io.helidon.common.reactive.Single.error(new com.jauntsdn.rsocket.exceptions.RpcException("KitchenServer: fireAndForget not implemented"));
  }

  @Override
  public io.helidon.common.reactive.Single<com.jauntsdn.rsocket.Message> requestResponse(com.jauntsdn.rsocket.Message message) {
    message.release();
    return io.helidon.common.reactive.Single.error(new com.jauntsdn.rsocket.exceptions.RpcException("KitchenServer: requestResponse not implemented"));
  }

  @Override
  public io.helidon.common.reactive.Multi<com.jauntsdn.rsocket.Message> requestStream(com.jauntsdn.rsocket.Message message) {
    try {
      io.netty.buffer.ByteBuf metadata = message.metadata();
      long header = com.jauntsdn.rsocket.Rpc.RpcMetadata.header(metadata);
      int flags = com.jauntsdn.rsocket.Rpc.RpcMetadata.flags(header);
      String method = rpcCodec.decodeMessageMethod(metadata, header, flags);

      if (com.jauntsdn.rsocket.Rpc.RpcMetadata.flagForeignCall(flags)) {
        io.helidon.common.reactive.Single<com.jauntsdn.rsocket.Message> handler = requestResponseHandler(flags, method, message.data(), metadata);
        if (handler != null) {
          return io.helidon.common.reactive.Multi.create(handler);
        }
      }
      return io.helidon.common.reactive.Multi.error(new com.jauntsdn.rsocket.exceptions.RpcException("KitchenServer: requestStream unknown method: " + method));
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

      switch (method) {
        case Kitchen.METHOD_SERVE: {
          if (!Kitchen.METHOD_SERVE_IDEMPOTENT && com.jauntsdn.rsocket.Rpc.RpcMetadata.flagIdempotentCall(flags)) {
            message.release();
            return io.helidon.common.reactive.Multi.error(new com.jauntsdn.rsocket.exceptions.RpcException("KitchenServer: idempotent call to non-idempotent method: " + method));
          }
          io.helidon.common.reactive.Multi<trisocket.Order> messages =
            io.helidon.common.reactive.Multi.from(publisher).map(decode(trisocket.Order.parser()));
          io.helidon.common.reactive.Multi<com.jauntsdn.rsocket.Message> serve = service.serve(messages, metadata).map(encode);
          if (serveInstrumentation != null) {
            return serve.compose(serveInstrumentation);
          }
          return serve;
        }
        default: {
          message.release();
          return io.helidon.common.reactive.Multi.error(new com.jauntsdn.rsocket.exceptions.RpcException("KitchenServer: requestChannel unknown method: " + method));
        }
      }
    } catch (Throwable t) {
      io.netty.util.ReferenceCountUtil.safeRelease(message);
      return io.helidon.common.reactive.Multi.error(t);
    }
  }

  @Override
  public io.helidon.common.reactive.Multi<com.jauntsdn.rsocket.Message> requestChannel(java.util.concurrent.Flow.Publisher<com.jauntsdn.rsocket.Message> messages) {
    return io.helidon.common.reactive.Multi.error(new com.jauntsdn.rsocket.exceptions.RpcException("KitchenServer: unsupported method: requestChannel(Publisher<Message>)"));
  }

  @Override
  public void dispose() {
    Kitchen svc = service;
    if (svc instanceof com.jauntsdn.rsocket.Closeable) {
      ((com.jauntsdn.rsocket.Closeable) svc).dispose();
    }
  }

  @Override
  public boolean isDisposed() {
    Kitchen svc = service;
    if (svc instanceof com.jauntsdn.rsocket.Closeable) {
      return ((com.jauntsdn.rsocket.Closeable) svc).isDisposed();
    }
    return false;
  }

  @Override
  public io.helidon.common.reactive.Single<Void> onClose() {
    Kitchen svc = service;
    if (svc instanceof com.jauntsdn.rsocket.Closeable) {
      return ((com.jauntsdn.rsocket.Closeable) svc).onClose();
    }
    return io.helidon.common.reactive.Single.never();
  }

  private io.helidon.common.reactive.Single<com.jauntsdn.rsocket.Message> requestResponseHandler(int flags, String method, io.netty.buffer.ByteBuf data, io.netty.buffer.ByteBuf metadata) throws java.io.IOException {
    return null;
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
          throw new com.jauntsdn.rsocket.exceptions.SerializationException("KitchenServer: message serialization error", t);
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
          throw new com.jauntsdn.rsocket.exceptions.SerializationException("KitchenServer: message deserialization error", t);
        } finally {
          message.release();
        }
      }
    };
  }

  @javax.inject.Named(
      value ="KitchenServer")
  public static final class Factory implements com.jauntsdn.rsocket.RSocketRpcService.Factory<KitchenServer> {
    private final Kitchen service;
    private final java.util.Optional<com.jauntsdn.rsocket.RSocketRpcInstrumentation> instrumentation;

    @javax.inject.Inject
    public Factory(Kitchen service, java.util.Optional<com.jauntsdn.rsocket.RSocketRpcInstrumentation> instrumentation) {
      this.service = java.util.Objects.requireNonNull(service, "service");
      this.instrumentation = java.util.Objects.requireNonNull(instrumentation, "instrumentation");
    }

    @Override
    public KitchenServer withLifecycle(com.jauntsdn.rsocket.RSocket rSocket) {
      java.util.Objects.requireNonNull(rSocket, "rSocket");
      com.jauntsdn.rsocket.Rpc.Codec codec = rSocket.attributes().attr(com.jauntsdn.rsocket.Attributes.RPC_CODEC);
      if (codec != null) {
        if (codec.isDisposable()) {
          rSocket.onClose().subscribe(ignored -> {}, err -> {}, () -> codec.dispose());
        }
        io.netty.buffer.ByteBufAllocator allocator = rSocket.allocator().orElse(io.netty.buffer.ByteBufAllocator.DEFAULT);
        return new KitchenServer(service, instrumentation, allocator, codec);
      }
      throw new IllegalArgumentException("RSocket " + rSocket.getClass() + " does not provide RSocket-RPC codec");
    }
  }
}
