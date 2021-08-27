package trisocket;

@javax.annotation.Generated(
    value = "jauntsdn.com rsocket-rpc compiler (version 1.0.0)",
    comments = "source: service.proto")
@com.jauntsdn.rsocket.Rpc.Generated(
    role = com.jauntsdn.rsocket.Rpc.Role.CLIENT,
    service = Chef.class)
public final class ChefClient implements Chef {
  private final com.jauntsdn.rsocket.RSocket rSocket;
  private final io.netty.buffer.ByteBufAllocator allocator;
  private final java.util.function.Function<? super io.helidon.common.reactive.Single<trisocket.Dish>, ? extends io.helidon.common.reactive.Single<trisocket.Dish>> roastInstrumentation;
  private final com.jauntsdn.rsocket.Rpc.Codec rpcCodec;

  private ChefClient(com.jauntsdn.rsocket.RSocket rSocket, java.util.Optional<com.jauntsdn.rsocket.RSocketRpcInstrumentation> instrumentation) {
    this.rSocket = rSocket;
    this.allocator = rSocket.allocator().orElse(io.netty.buffer.ByteBufAllocator.DEFAULT);
    if (!instrumentation.isPresent()) {
      this.roastInstrumentation = null;
    } else {
      com.jauntsdn.rsocket.RSocketRpcInstrumentation i = instrumentation.get();
      this.roastInstrumentation = i.instrumentSingle("client", Chef.SERVICE, Chef.METHOD_ROAST);
    }
    com.jauntsdn.rsocket.Rpc.Codec codec = rSocket.attributes().attr(com.jauntsdn.rsocket.Attributes.RPC_CODEC);
    if (codec != null) {
      rpcCodec = codec;
      if (codec.isDisposable()) {
        rSocket.onClose().subscribe(ignored -> {}, err -> {}, () -> codec.dispose());
      }
      return;
    }
    throw new IllegalArgumentException("RSocket " + rSocket.getClass() + " does not provide RSocket-RPC codec");
  }

  public static ChefClient create(com.jauntsdn.rsocket.RSocket rSocket, java.util.Optional<com.jauntsdn.rsocket.RSocketRpcInstrumentation> instrumentation) {
    java.util.Objects.requireNonNull(rSocket, "rSocket");
    java.util.Objects.requireNonNull(instrumentation, "instrumentation");
    return new ChefClient(rSocket, instrumentation);
  }

  @Override
  @com.jauntsdn.rsocket.Rpc.GeneratedMethod(returnType = trisocket.Dish.class)
  public io.helidon.common.reactive.Single<trisocket.Dish> roast(trisocket.Pan message, io.netty.buffer.ByteBuf metadata) {
    io.helidon.common.reactive.Single<trisocket.Dish> roast = io.helidon.common.reactive.Single.defer(new java.util.function.Supplier<io.helidon.common.reactive.Single<com.jauntsdn.rsocket.Message>>() {
      @Override
      public io.helidon.common.reactive.Single<com.jauntsdn.rsocket.Message> get() {
        int externalMetadataSize = rSocket.attributes().intAttr(com.jauntsdn.rsocket.Attributes.EXTERNAL_METADATA_SIZE);
        int dataSize = message.getSerializedSize();
        int localHeader = com.jauntsdn.rsocket.MessageMetadata.header(metadata);
        boolean isDefaultService = com.jauntsdn.rsocket.MessageMetadata.defaultService(localHeader);
        String service = isDefaultService ? com.jauntsdn.rsocket.Rpc.RpcMetadata.defaultService() : Chef.SERVICE;
        com.jauntsdn.rsocket.Rpc.Codec codec = rpcCodec;
        io.netty.buffer.ByteBuf content = codec.encodeContent(allocator, metadata, localHeader, service, Chef.METHOD_ROAST, false, Chef.METHOD_ROAST_IDEMPOTENT, dataSize, externalMetadataSize);
        encode(content, message);
        com.jauntsdn.rsocket.Message message = codec.encodeMessage(content, Chef.METHOD_ROAST_RANK);
        return rSocket.requestResponse(message);
      }
    }).map(decode(trisocket.Dish.parser()));
    if (roastInstrumentation != null) {
      return roast.compose(roastInstrumentation);
    }
    return roast;
  }

  private io.netty.buffer.ByteBuf encode(io.netty.buffer.ByteBuf content, final com.google.protobuf.MessageLite message) {
    int length = message.getSerializedSize();
    try {
      int writerIndex = content.writerIndex();
      message.writeTo(com.google.protobuf.CodedOutputStream.newInstance(content.internalNioBuffer(writerIndex, length)));
      content.writerIndex(writerIndex + length);
      return content;
    } catch (Throwable t) {
      content.release();
      com.jauntsdn.rsocket.exceptions.Exceptions.throwIfJvmFatal(t);
      throw new com.jauntsdn.rsocket.exceptions.SerializationException("ChefClient: message serialization error", t);
    }
  }

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
          throw new com.jauntsdn.rsocket.exceptions.SerializationException("ChefClient: message deserialization error", t);
        } finally {
          message.release();
        }
      }
    };
  }
}
