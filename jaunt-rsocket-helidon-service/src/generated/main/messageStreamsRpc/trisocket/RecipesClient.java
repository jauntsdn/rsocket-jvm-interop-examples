package trisocket;

@javax.annotation.Generated(
    value = "jauntsdn.com rpc compiler (version 1.1.3)",
    comments = "source: service.proto")
@com.jauntsdn.rsocket.Rpc.Generated(
    role = com.jauntsdn.rsocket.Rpc.Role.CLIENT,
    service = Recipes.class)
public final class RecipesClient implements Recipes {
  private final com.jauntsdn.rsocket.MessageStreams streams;
  private final io.netty.buffer.ByteBufAllocator allocator;
  private final java.util.function.Function<? super io.helidon.common.reactive.Single<trisocket.Recipe>, ? extends io.helidon.common.reactive.Single<trisocket.Recipe>> marinadeInstrumentation;
  private final com.jauntsdn.rsocket.Rpc.Codec rpcCodec;

  private RecipesClient(com.jauntsdn.rsocket.MessageStreams streams, java.util.Optional<com.jauntsdn.rsocket.RpcInstrumentation> instrumentation) {
    this.streams = streams;
    this.allocator = streams.allocator().orElse(io.netty.buffer.ByteBufAllocator.DEFAULT);
    com.jauntsdn.rsocket.RpcInstrumentation i = instrumentation == null
      ? streams.attributes().attr(com.jauntsdn.rsocket.Attributes.RPC_INSTRUMENTATION)
      : instrumentation.orElse(null);
    if (i == null) {
      this.marinadeInstrumentation = null;
    } else {
      this.marinadeInstrumentation = i.instrumentSingle("client", Recipes.SERVICE, Recipes.METHOD_MARINADE);
    }
    com.jauntsdn.rsocket.Rpc.Codec codec = streams.attributes().attr(com.jauntsdn.rsocket.Attributes.RPC_CODEC);
    if (codec != null) {
      rpcCodec = codec;
      if (codec.isDisposable()) {
        streams.onClose().subscribe(ignored -> {}, err -> {}, () -> codec.dispose());
      }
      return;
    }
    throw new IllegalArgumentException("MessageStreams " + streams.getClass() + " does not provide RPC codec");
  }

  public static RecipesClient create(com.jauntsdn.rsocket.MessageStreams streams, java.util.Optional<com.jauntsdn.rsocket.RpcInstrumentation> instrumentation) {
    java.util.Objects.requireNonNull(streams, "streams");
    java.util.Objects.requireNonNull(instrumentation, "instrumentation");
    return new RecipesClient(streams, instrumentation);
  }

  public static RecipesClient create(com.jauntsdn.rsocket.MessageStreams streams) {
    java.util.Objects.requireNonNull(streams, "streams");
    return new RecipesClient(streams, null);
  }

  @Override
  @com.jauntsdn.rsocket.Rpc.GeneratedMethod(returnType = trisocket.Recipe.class)
  public io.helidon.common.reactive.Single<trisocket.Recipe> marinade(trisocket.Meat message, io.netty.buffer.ByteBuf metadata) {
    io.helidon.common.reactive.Single<trisocket.Recipe> marinade = io.helidon.common.reactive.Single.defer(new java.util.function.Supplier<io.helidon.common.reactive.Single<com.jauntsdn.rsocket.Message>>() {
      @Override
      public io.helidon.common.reactive.Single<com.jauntsdn.rsocket.Message> get() {
        int externalMetadataSize = streams.attributes().intAttr(com.jauntsdn.rsocket.Attributes.EXTERNAL_METADATA_SIZE);
        int dataSize = message.getSerializedSize();
        int localHeader = com.jauntsdn.rsocket.MessageMetadata.header(metadata);
        boolean isDefaultService = com.jauntsdn.rsocket.MessageMetadata.defaultService(localHeader);
        String service = isDefaultService ? com.jauntsdn.rsocket.Rpc.RpcMetadata.defaultService() : Recipes.SERVICE;
        com.jauntsdn.rsocket.Rpc.Codec codec = rpcCodec;
        io.netty.buffer.ByteBuf content = codec.encodeContent(allocator, metadata, localHeader, service, Recipes.METHOD_MARINADE, false, Recipes.METHOD_MARINADE_IDEMPOTENT, dataSize, externalMetadataSize);
        encode(content, message);
        com.jauntsdn.rsocket.Message message = codec.encodeMessage(content, Recipes.METHOD_MARINADE_RANK);
        return streams.requestResponse(message);
      }
    }).map(decode(trisocket.Recipe.parser()));
    if (marinadeInstrumentation != null) {
      return marinade.compose(marinadeInstrumentation);
    }
    return marinade;
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
      throw new com.jauntsdn.rsocket.exceptions.SerializationException("RecipesClient: message serialization error", t);
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
          throw new com.jauntsdn.rsocket.exceptions.SerializationException("RecipesClient: message deserialization error", t);
        } finally {
          message.release();
        }
      }
    };
  }
}
