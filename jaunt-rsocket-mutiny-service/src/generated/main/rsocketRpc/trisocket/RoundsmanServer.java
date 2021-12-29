package trisocket;

@javax.annotation.Generated(
    value = "jauntsdn.com rpc compiler (version 1.1.1)",
    comments = "source: service.proto")
@com.jauntsdn.rsocket.Rpc.Generated(
    role = com.jauntsdn.rsocket.Rpc.Role.SERVICE,
    service = Roundsman.class)
public final class RoundsmanServer implements com.jauntsdn.rsocket.RpcService {
  private final java.util.concurrent.CompletableFuture onClose = new java.util.concurrent.CompletableFuture();
  private final Roundsman service;
  private final io.netty.buffer.ByteBufAllocator allocator;
  private final java.util.function.Function<io.smallrye.mutiny.Uni<com.jauntsdn.rsocket.Message>, io.smallrye.mutiny.Uni<com.jauntsdn.rsocket.Message>> chopInstrumentation;
  private final java.util.function.Function<io.smallrye.mutiny.Uni<com.jauntsdn.rsocket.Message>, io.smallrye.mutiny.Uni<com.jauntsdn.rsocket.Message>> marinadeInstrumentation;
  private final com.jauntsdn.rsocket.Rpc.Codec rpcCodec;

  private RoundsmanServer(Roundsman service, com.jauntsdn.rsocket.RpcInstrumentation instrumentation, io.netty.buffer.ByteBufAllocator allocator, com.jauntsdn.rsocket.Rpc.Codec rpcCodec) {
    this.service = service;
    this.rpcCodec = rpcCodec;
    this.allocator = allocator;
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
    try {
      io.netty.buffer.ByteBuf metadata = message.metadata();
      long header = com.jauntsdn.rsocket.Rpc.RpcMetadata.header(metadata);
      int flags = com.jauntsdn.rsocket.Rpc.RpcMetadata.flags(header);
      String method = rpcCodec.decodeMessageMethod(metadata, header, flags);

      if (com.jauntsdn.rsocket.Rpc.RpcMetadata.flagForeignCall(flags)) {
        io.smallrye.mutiny.Uni<com.jauntsdn.rsocket.Message> handler = requestResponseHandler(flags, method, message.data(), metadata);
        if (handler != null) {
          return io.smallrye.mutiny.Multi.createFrom().uni(handler);
        }
      }
      return io.smallrye.mutiny.Multi.createFrom().failure(new com.jauntsdn.rsocket.exceptions.RpcException("RoundsmanServer: requestStream unknown method: " + method));
    } catch (Throwable t) {
      return io.smallrye.mutiny.Multi.createFrom().failure(t);
    } finally {
      message.release();
    }
  }

  @Override
  public io.smallrye.mutiny.Multi<com.jauntsdn.rsocket.Message> requestChannel(com.jauntsdn.rsocket.Message message, org.reactivestreams.Publisher<com.jauntsdn.rsocket.Message> publisher) {
    message.release();
    return io.smallrye.mutiny.Multi.createFrom().failure(new com.jauntsdn.rsocket.exceptions.RpcException("RoundsmanServer: requestChannel not implemented"));
  }

  @Override
  public io.smallrye.mutiny.Multi<com.jauntsdn.rsocket.Message> requestChannel(org.reactivestreams.Publisher<com.jauntsdn.rsocket.Message> messages) {
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
        io.smallrye.mutiny.Uni<com.jauntsdn.rsocket.Message> chop = service.chop(trisocket.Veggie.parseFrom(is), metadata).map(encode);
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
        io.smallrye.mutiny.Uni<com.jauntsdn.rsocket.Message> marinade = service.marinade(trisocket.Meat.parseFrom(is), metadata).map(encode);
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
          throw new com.jauntsdn.rsocket.exceptions.SerializationException("RoundsmanServer: message serialization error", t);
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
          throw new com.jauntsdn.rsocket.exceptions.SerializationException("RoundsmanServer: message deserialization error", t);
        } finally {
          message.release();
        }
      }
    };
  }

  @javax.inject.Named(
      value ="RoundsmanServer")
  public static final class Factory implements com.jauntsdn.rsocket.RpcService.Factory<RoundsmanServer> {
    private final Roundsman service;
    private final java.util.Optional<com.jauntsdn.rsocket.RpcInstrumentation> instrumentation;

    @javax.inject.Inject
    public Factory(Roundsman service, java.util.Optional<com.jauntsdn.rsocket.RpcInstrumentation> instrumentation) {
      this.service = java.util.Objects.requireNonNull(service, "service");
      this.instrumentation = java.util.Objects.requireNonNull(instrumentation, "instrumentation");
    }

    public Factory(Roundsman service) {
      this.service = java.util.Objects.requireNonNull(service, "service");
      this.instrumentation = null;
    }

    @Override
    public RoundsmanServer withLifecycle(com.jauntsdn.rsocket.Closeable requester) {
      java.util.Objects.requireNonNull(requester, "requester");
      com.jauntsdn.rsocket.Rpc.Codec codec = requester.attributes().attr(com.jauntsdn.rsocket.Attributes.RPC_CODEC);
      if (codec != null) {
        if (codec.isDisposable()) {
          requester.onClose().subscribe().with(ignored -> codec.dispose());
        }
        io.netty.buffer.ByteBufAllocator alloc = requester.attributes().attr(com.jauntsdn.rsocket.Attributes.ALLOCATOR);
        io.netty.buffer.ByteBufAllocator allocator = alloc != null ? alloc : io.netty.buffer.ByteBufAllocator.DEFAULT;
        java.util.Optional<com.jauntsdn.rsocket.RpcInstrumentation> instr = instrumentation;
        com.jauntsdn.rsocket.RpcInstrumentation rpcInstrumentation = instr == null
          ? requester.attributes().attr(com.jauntsdn.rsocket.Attributes.RPC_INSTRUMENTATION)
          : instr.orElse(null);
        return new RoundsmanServer(service, rpcInstrumentation, allocator, codec);
      }
      throw new IllegalArgumentException("Requester " + requester.getClass() + " does not provide RPC codec");
    }
  }
}
