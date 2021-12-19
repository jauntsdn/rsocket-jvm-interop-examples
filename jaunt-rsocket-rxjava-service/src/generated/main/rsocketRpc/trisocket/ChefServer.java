package trisocket;

@javax.annotation.Generated(
    value = "jauntsdn.com rpc compiler (version 1.1.0)",
    comments = "source: service.proto")
@com.jauntsdn.rsocket.Rpc.Generated(
    role = com.jauntsdn.rsocket.Rpc.Role.SERVICE,
    service = Chef.class)
public final class ChefServer implements com.jauntsdn.rsocket.RpcService {
  private final Chef service;
  private final io.netty.buffer.ByteBufAllocator allocator;
  private final io.reactivex.rxjava3.core.SingleTransformer<com.jauntsdn.rsocket.Message, com.jauntsdn.rsocket.Message> roastInstrumentation;
  private final com.jauntsdn.rsocket.Rpc.Codec rpcCodec;

  private ChefServer(Chef service, com.jauntsdn.rsocket.RpcInstrumentation instrumentation, io.netty.buffer.ByteBufAllocator allocator, com.jauntsdn.rsocket.Rpc.Codec rpcCodec) {
    this.service = service;
    this.rpcCodec = rpcCodec;
    this.allocator = allocator;
    if (instrumentation == null) {
      this.roastInstrumentation = null;
    } else {
      this.roastInstrumentation = instrumentation.instrumentSingle("service", Chef.SERVICE, Chef.METHOD_ROAST);
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
  public io.reactivex.rxjava3.core.Completable fireAndForget(com.jauntsdn.rsocket.Message message) {
    message.release();
    return io.reactivex.rxjava3.core.Completable.error(new com.jauntsdn.rsocket.exceptions.RpcException("ChefServer: fireAndForget not implemented"));
  }

  @Override
  public io.reactivex.rxjava3.core.Single<com.jauntsdn.rsocket.Message> requestResponse(com.jauntsdn.rsocket.Message message) {
    try {
      io.netty.buffer.ByteBuf metadata = message.metadata();
      long header = com.jauntsdn.rsocket.Rpc.RpcMetadata.header(metadata);
      int flags = com.jauntsdn.rsocket.Rpc.RpcMetadata.flags(header);
      String method = rpcCodec.decodeMessageMethod(metadata, header, flags);

      io.reactivex.rxjava3.core.Single<com.jauntsdn.rsocket.Message> handler = requestResponseHandler(flags, method, message.data(), metadata);
      if (handler != null) {
        return handler;
      }
      return io.reactivex.rxjava3.core.Single.error(new com.jauntsdn.rsocket.exceptions.RpcException("ChefServer: requestResponse not implemented"));
    } catch (Throwable t) {
      return io.reactivex.rxjava3.core.Single.error(t);
    } finally {
      message.release();
    }
  }

  @Override
  public io.reactivex.rxjava3.core.Flowable<com.jauntsdn.rsocket.Message> requestStream(com.jauntsdn.rsocket.Message message) {
    try {
      io.netty.buffer.ByteBuf metadata = message.metadata();
      long header = com.jauntsdn.rsocket.Rpc.RpcMetadata.header(metadata);
      int flags = com.jauntsdn.rsocket.Rpc.RpcMetadata.flags(header);
      String method = rpcCodec.decodeMessageMethod(metadata, header, flags);

      if (com.jauntsdn.rsocket.Rpc.RpcMetadata.flagForeignCall(flags)) {
        io.reactivex.rxjava3.core.Single<com.jauntsdn.rsocket.Message> handler = requestResponseHandler(flags, method, message.data(), metadata);
        if (handler != null) {
          return handler.toFlowable();
        }
      }
      return io.reactivex.rxjava3.core.Flowable.error(new com.jauntsdn.rsocket.exceptions.RpcException("ChefServer: requestStream unknown method: " + method));
    } catch (Throwable t) {
      return io.reactivex.rxjava3.core.Flowable.error(t);
    } finally {
      message.release();
    }
  }

  @Override
  public io.reactivex.rxjava3.core.Flowable<com.jauntsdn.rsocket.Message> requestChannel(com.jauntsdn.rsocket.Message message, org.reactivestreams.Publisher<com.jauntsdn.rsocket.Message> publisher) {
    message.release();
    return io.reactivex.rxjava3.core.Flowable.error(new com.jauntsdn.rsocket.exceptions.RpcException("ChefServer: requestChannel not implemented"));
  }

  @Override
  public io.reactivex.rxjava3.core.Flowable<com.jauntsdn.rsocket.Message> requestChannel(org.reactivestreams.Publisher<com.jauntsdn.rsocket.Message> messages) {
    return io.reactivex.rxjava3.core.Flowable.error(new com.jauntsdn.rsocket.exceptions.RpcException("ChefServer: requestChannel not implemented"));
  }

  @Override
  public void dispose() {
    Chef svc = service;
    if (svc instanceof com.jauntsdn.rsocket.Closeable) {
      ((com.jauntsdn.rsocket.Closeable) svc).dispose();
    }
  }

  @Override
  public boolean isDisposed() {
    Chef svc = service;
    if (svc instanceof com.jauntsdn.rsocket.Closeable) {
      return ((com.jauntsdn.rsocket.Closeable) svc).isDisposed();
    }
    return false;
  }

  @Override
  public io.reactivex.rxjava3.core.Completable onClose() {
    Chef svc = service;
    if (svc instanceof com.jauntsdn.rsocket.Closeable) {
      return ((com.jauntsdn.rsocket.Closeable) svc).onClose();
    }
    return io.reactivex.rxjava3.core.Completable.never();
  }

  private io.reactivex.rxjava3.core.Single<com.jauntsdn.rsocket.Message> requestResponseHandler(int flags, String method, io.netty.buffer.ByteBuf data, io.netty.buffer.ByteBuf metadata) throws java.io.IOException {
    switch (method) {
      case Chef.METHOD_ROAST: {
        if (!Chef.METHOD_ROAST_IDEMPOTENT && com.jauntsdn.rsocket.Rpc.RpcMetadata.flagIdempotentCall(flags)) {
          return io.reactivex.rxjava3.core.Single.error(new com.jauntsdn.rsocket.exceptions.RpcException("ChefServer: idempotent call to non-idempotent method: " + method));
        }
        com.google.protobuf.CodedInputStream is = com.google.protobuf.CodedInputStream.newInstance(data.internalNioBuffer(0, data.readableBytes()));
        io.reactivex.rxjava3.core.Single<com.jauntsdn.rsocket.Message> roast = service.roast(trisocket.Pan.parseFrom(is), metadata).map(encode);
        if (roastInstrumentation != null) {
          return roast.compose(roastInstrumentation);
        }
        return roast;
      }
      default: {
        return null;
      }
    }
  }

  private final io.reactivex.rxjava3.functions.Function<com.google.protobuf.MessageLite, com.jauntsdn.rsocket.Message> encode =
    new io.reactivex.rxjava3.functions.Function<com.google.protobuf.MessageLite, com.jauntsdn.rsocket.Message>() {
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
          throw new com.jauntsdn.rsocket.exceptions.SerializationException("ChefServer: message serialization error", t);
        }
      }
    };

  private static <T> io.reactivex.rxjava3.functions.Function<com.jauntsdn.rsocket.Message, T> decode(final com.google.protobuf.Parser<T> parser) {
    return new io.reactivex.rxjava3.functions.Function<com.jauntsdn.rsocket.Message, T>() {
      @Override
      public T apply(com.jauntsdn.rsocket.Message message) {
        try {
          io.netty.buffer.ByteBuf messageData = message.data();
          com.google.protobuf.CodedInputStream is = com.google.protobuf.CodedInputStream.newInstance(messageData.internalNioBuffer(0, messageData.readableBytes()));
          return parser.parseFrom(is);
        } catch (Throwable t) {
          com.jauntsdn.rsocket.exceptions.Exceptions.throwIfJvmFatal(t);
          throw new com.jauntsdn.rsocket.exceptions.SerializationException("ChefServer: message deserialization error", t);
        } finally {
          message.release();
        }
      }
    };
  }

  @javax.inject.Named(
      value ="ChefServer")
  public static final class Factory implements com.jauntsdn.rsocket.RpcService.Factory<ChefServer> {
    private final Chef service;
    private final java.util.Optional<com.jauntsdn.rsocket.RpcInstrumentation> instrumentation;

    @javax.inject.Inject
    public Factory(Chef service, java.util.Optional<com.jauntsdn.rsocket.RpcInstrumentation> instrumentation) {
      this.service = java.util.Objects.requireNonNull(service, "service");
      this.instrumentation = java.util.Objects.requireNonNull(instrumentation, "instrumentation");
    }

    public Factory(Chef service) {
      this.service = java.util.Objects.requireNonNull(service, "service");
      this.instrumentation = null;
    }

    @Override
    public ChefServer withLifecycle(com.jauntsdn.rsocket.Closeable requester) {
      java.util.Objects.requireNonNull(requester, "requester");
      com.jauntsdn.rsocket.Rpc.Codec codec = requester.attributes().attr(com.jauntsdn.rsocket.Attributes.RPC_CODEC);
      if (codec != null) {
        if (codec.isDisposable()) {
          requester.onClose().subscribe(() -> codec.dispose());
        }
        io.netty.buffer.ByteBufAllocator alloc = requester.attributes().attr(com.jauntsdn.rsocket.Attributes.ALLOCATOR);
        io.netty.buffer.ByteBufAllocator allocator = alloc != null ? alloc : io.netty.buffer.ByteBufAllocator.DEFAULT;
        java.util.Optional<com.jauntsdn.rsocket.RpcInstrumentation> instr = instrumentation;
        com.jauntsdn.rsocket.RpcInstrumentation rpcInstrumentation = instr == null
          ? requester.attributes().attr(com.jauntsdn.rsocket.Attributes.RPC_INSTRUMENTATION)
          : instr.orElse(null);
        return new ChefServer(service, rpcInstrumentation, allocator, codec);
      }
      throw new IllegalArgumentException("Requester " + requester.getClass() + " does not provide RPC codec");
    }
  }
}
