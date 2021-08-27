package trisocket;

@javax.annotation.Generated(
    value = "jauntsdn.com rsocket-rpc compiler (version 1.0.0)",
    comments = "source: service.proto")
@com.jauntsdn.rsocket.Rpc.Generated(
    role = com.jauntsdn.rsocket.Rpc.Role.SERVICE,
    service = Farmer.class)
public final class FarmerServer implements com.jauntsdn.rsocket.RSocketRpcService {
  private final Farmer service;
  private final io.netty.buffer.ByteBufAllocator allocator;
  private final io.reactivex.rxjava3.core.FlowableTransformer<com.jauntsdn.rsocket.Message, com.jauntsdn.rsocket.Message> meatInstrumentation;
  private final io.reactivex.rxjava3.core.FlowableTransformer<com.jauntsdn.rsocket.Message, com.jauntsdn.rsocket.Message> veggiesInstrumentation;
  private final com.jauntsdn.rsocket.Rpc.Codec rpcCodec;

  private FarmerServer(Farmer service, java.util.Optional<com.jauntsdn.rsocket.RSocketRpcInstrumentation> instrumentation, io.netty.buffer.ByteBufAllocator allocator, com.jauntsdn.rsocket.Rpc.Codec rpcCodec) {
    this.service = service;
    this.rpcCodec = rpcCodec;
    this.allocator = allocator;
    if (!instrumentation.isPresent()) {
      this.meatInstrumentation = null;
      this.veggiesInstrumentation = null;
    } else {
      com.jauntsdn.rsocket.RSocketRpcInstrumentation i = instrumentation.get();
      this.meatInstrumentation = i.instrumentFlowable("service", Farmer.SERVICE, Farmer.METHOD_MEAT, true);
      this.veggiesInstrumentation = i.instrumentFlowable("service", Farmer.SERVICE, Farmer.METHOD_VEGGIES, true);
    }
  }

  public static FarmerServer.Factory create(Farmer service, java.util.Optional<com.jauntsdn.rsocket.RSocketRpcInstrumentation> instrumentation) {
    return new FarmerServer.Factory(service, instrumentation);
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
  public io.reactivex.rxjava3.core.Completable fireAndForget(com.jauntsdn.rsocket.Message message) {
    message.release();
    return io.reactivex.rxjava3.core.Completable.error(new com.jauntsdn.rsocket.exceptions.RpcException("FarmerServer: fireAndForget not implemented"));
  }

  @Override
  public io.reactivex.rxjava3.core.Single<com.jauntsdn.rsocket.Message> requestResponse(com.jauntsdn.rsocket.Message message) {
    message.release();
    return io.reactivex.rxjava3.core.Single.error(new com.jauntsdn.rsocket.exceptions.RpcException("FarmerServer: requestResponse not implemented"));
  }

  @Override
  public io.reactivex.rxjava3.core.Flowable<com.jauntsdn.rsocket.Message> requestStream(com.jauntsdn.rsocket.Message message) {
    try {
      io.netty.buffer.ByteBuf metadata = message.metadata();
      long header = com.jauntsdn.rsocket.Rpc.RpcMetadata.header(metadata);
      int flags = com.jauntsdn.rsocket.Rpc.RpcMetadata.flags(header);
      String method = rpcCodec.decodeMessageMethod(metadata, header, flags);

      switch (method) {
        case Farmer.METHOD_MEAT: {
          if (!Farmer.METHOD_MEAT_IDEMPOTENT && com.jauntsdn.rsocket.Rpc.RpcMetadata.flagIdempotentCall(flags)) {
            return io.reactivex.rxjava3.core.Flowable.error(new com.jauntsdn.rsocket.exceptions.RpcException("FarmerServer: idempotent call to non-idempotent method: " + method));
          }
          io.netty.buffer.ByteBuf messageData = message.data();
          com.google.protobuf.CodedInputStream is = com.google.protobuf.CodedInputStream.newInstance(messageData.internalNioBuffer(0, messageData.readableBytes()));
          io.reactivex.rxjava3.core.Flowable<com.jauntsdn.rsocket.Message> meat = service.meat(trisocket.Order.parseFrom(is), metadata).map(encode);
          if (meatInstrumentation != null) {
            return meat.compose(meatInstrumentation);
          }
          return meat;
        }
        case Farmer.METHOD_VEGGIES: {
          if (!Farmer.METHOD_VEGGIES_IDEMPOTENT && com.jauntsdn.rsocket.Rpc.RpcMetadata.flagIdempotentCall(flags)) {
            return io.reactivex.rxjava3.core.Flowable.error(new com.jauntsdn.rsocket.exceptions.RpcException("FarmerServer: idempotent call to non-idempotent method: " + method));
          }
          io.netty.buffer.ByteBuf messageData = message.data();
          com.google.protobuf.CodedInputStream is = com.google.protobuf.CodedInputStream.newInstance(messageData.internalNioBuffer(0, messageData.readableBytes()));
          io.reactivex.rxjava3.core.Flowable<com.jauntsdn.rsocket.Message> veggies = service.veggies(trisocket.Order.parseFrom(is), metadata).map(encode);
          if (veggiesInstrumentation != null) {
            return veggies.compose(veggiesInstrumentation);
          }
          return veggies;
        }
      }
      if (com.jauntsdn.rsocket.Rpc.RpcMetadata.flagForeignCall(flags)) {
        io.reactivex.rxjava3.core.Single<com.jauntsdn.rsocket.Message> handler = requestResponseHandler(flags, method, message.data(), metadata);
        if (handler != null) {
          return handler.toFlowable();
        }
      }
      return io.reactivex.rxjava3.core.Flowable.error(new com.jauntsdn.rsocket.exceptions.RpcException("FarmerServer: requestStream unknown method: " + method));
    } catch (Throwable t) {
      return io.reactivex.rxjava3.core.Flowable.error(t);
    } finally {
      message.release();
    }
  }

  @Override
  public io.reactivex.rxjava3.core.Flowable<com.jauntsdn.rsocket.Message> requestChannel(com.jauntsdn.rsocket.Message message, org.reactivestreams.Publisher<com.jauntsdn.rsocket.Message> publisher) {
    message.release();
    return io.reactivex.rxjava3.core.Flowable.error(new com.jauntsdn.rsocket.exceptions.RpcException("FarmerServer: requestChannel not implemented"));
  }

  @Override
  public io.reactivex.rxjava3.core.Flowable<com.jauntsdn.rsocket.Message> requestChannel(org.reactivestreams.Publisher<com.jauntsdn.rsocket.Message> messages) {
    return io.reactivex.rxjava3.core.Flowable.error(new com.jauntsdn.rsocket.exceptions.RpcException("FarmerServer: requestChannel not implemented"));
  }

  @Override
  public void dispose() {
    Farmer svc = service;
    if (svc instanceof com.jauntsdn.rsocket.Closeable) {
      ((com.jauntsdn.rsocket.Closeable) svc).dispose();
    }
  }

  @Override
  public boolean isDisposed() {
    Farmer svc = service;
    if (svc instanceof com.jauntsdn.rsocket.Closeable) {
      return ((com.jauntsdn.rsocket.Closeable) svc).isDisposed();
    }
    return false;
  }

  @Override
  public io.reactivex.rxjava3.core.Completable onClose() {
    Farmer svc = service;
    if (svc instanceof com.jauntsdn.rsocket.Closeable) {
      return ((com.jauntsdn.rsocket.Closeable) svc).onClose();
    }
    return io.reactivex.rxjava3.core.Completable.never();
  }

  private io.reactivex.rxjava3.core.Single<com.jauntsdn.rsocket.Message> requestResponseHandler(int flags, String method, io.netty.buffer.ByteBuf data, io.netty.buffer.ByteBuf metadata) throws java.io.IOException {
    return null;
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
          throw new com.jauntsdn.rsocket.exceptions.SerializationException("FarmerServer: message serialization error", t);
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
          throw new com.jauntsdn.rsocket.exceptions.SerializationException("FarmerServer: message deserialization error", t);
        } finally {
          message.release();
        }
      }
    };
  }

  @javax.inject.Named(
      value ="FarmerServer")
  public static final class Factory implements com.jauntsdn.rsocket.RSocketRpcService.Factory<FarmerServer> {
    private final Farmer service;
    private final java.util.Optional<com.jauntsdn.rsocket.RSocketRpcInstrumentation> instrumentation;

    @javax.inject.Inject
    public Factory(Farmer service, java.util.Optional<com.jauntsdn.rsocket.RSocketRpcInstrumentation> instrumentation) {
      this.service = java.util.Objects.requireNonNull(service, "service");
      this.instrumentation = java.util.Objects.requireNonNull(instrumentation, "instrumentation");
    }

    @Override
    public FarmerServer withLifecycle(com.jauntsdn.rsocket.RSocket rSocket) {
      java.util.Objects.requireNonNull(rSocket, "rSocket");
      com.jauntsdn.rsocket.Rpc.Codec codec = rSocket.attributes().attr(com.jauntsdn.rsocket.Attributes.RPC_CODEC);
      if (codec != null) {
        if (codec.isDisposable()) {
          rSocket.onClose().subscribe(() -> codec.dispose());
        }
        io.netty.buffer.ByteBufAllocator allocator = rSocket.allocator().orElse(io.netty.buffer.ByteBufAllocator.DEFAULT);
        return new FarmerServer(service, instrumentation, allocator, codec);
      }
      throw new IllegalArgumentException("RSocket " + rSocket.getClass() + " does not provide RSocket-RPC codec");
    }
  }
}
