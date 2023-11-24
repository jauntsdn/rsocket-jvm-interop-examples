package trisocket;

@javax.annotation.Generated(
    value = "jauntsdn.com rpc compiler (version 1.5.2)",
    comments = "source: service.proto")
@com.jauntsdn.rsocket.Rpc.Generated(
    role = com.jauntsdn.rsocket.Rpc.Role.CLIENT,
    service = Chef.class)
@SuppressWarnings("all")
public final class ChefClient implements Chef {
  private final com.jauntsdn.rsocket.MessageStreams streams;
  private final io.netty.buffer.ByteBufAllocator allocator;
  private final java.util.function.Function<? super org.reactivestreams.Publisher<trisocket.Dish>, ? extends org.reactivestreams.Publisher<trisocket.Dish>> roastInstrumentation;
  private final com.jauntsdn.rsocket.Rpc.Codec rpcCodec;

  private ChefClient(com.jauntsdn.rsocket.MessageStreams streams, java.util.Optional<com.jauntsdn.rsocket.RpcInstrumentation> instrumentation) {
    this.streams = streams;
    this.allocator = streams.allocator().orElse(io.netty.buffer.ByteBufAllocator.DEFAULT);
    com.jauntsdn.rsocket.RpcInstrumentation i = instrumentation == null
      ? streams.attributes().attr(com.jauntsdn.rsocket.Attributes.RPC_INSTRUMENTATION)
      : instrumentation.orElse(null);
    if (i == null) {
      this.roastInstrumentation = null;
    } else {
      this.roastInstrumentation = i.instrument("client", Chef.SERVICE, Chef.METHOD_ROAST, false);
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

  public static ChefClient create(com.jauntsdn.rsocket.MessageStreams streams, java.util.Optional<com.jauntsdn.rsocket.RpcInstrumentation> instrumentation) {
    java.util.Objects.requireNonNull(streams, "streams");
    java.util.Objects.requireNonNull(instrumentation, "instrumentation");
    return new ChefClient(streams, instrumentation);
  }

  public static ChefClient create(com.jauntsdn.rsocket.MessageStreams streams) {
    java.util.Objects.requireNonNull(streams, "streams");
    return new ChefClient(streams, null);
  }

  @Override
  @com.jauntsdn.rsocket.Rpc.GeneratedMethod(returnType = trisocket.Dish.class)
  public reactor.core.publisher.Mono<trisocket.Dish> roast(trisocket.Pan message, com.jauntsdn.rsocket.Headers headersMetadata) {
    reactor.core.publisher.Mono<trisocket.Dish> roast = reactor.core.publisher.Mono.defer(new java.util.function.Supplier<reactor.core.publisher.Mono<com.jauntsdn.rsocket.Message>>() {
      @Override
      public reactor.core.publisher.Mono<com.jauntsdn.rsocket.Message> get() {
        int externalMetadataSize = streams.attributes().intAttr(com.jauntsdn.rsocket.Attributes.EXTERNAL_METADATA_SIZE);
        int dataSize = message.getSerializedSize();
        boolean isDefaultService = headersMetadata.isDefaultService();
        String service = isDefaultService ? com.jauntsdn.rsocket.Rpc.RpcMetadata.defaultService() : Chef.SERVICE;
        io.netty.buffer.ByteBuf metadata = com.jauntsdn.rsocket.generated.ProtobufCodec.encodeHeaders(headersMetadata);
        com.jauntsdn.rsocket.Rpc.Codec codec = rpcCodec;
        io.netty.buffer.ByteBuf content = codec.encodeContent(allocator, metadata, service, Chef.METHOD_ROAST, false, Chef.METHOD_ROAST_IDEMPOTENT, dataSize, externalMetadataSize);
        com.jauntsdn.rsocket.generated.ProtobufCodec.encode("ChefClient", content, message);
        com.jauntsdn.rsocket.Message message = codec.encodeMessage(content, Chef.METHOD_ROAST_RANK);
        return streams.requestResponse(message);
      }
    }).map(com.jauntsdn.rsocket.generated.ProtobufCodec.decode("ChefClient", trisocket.Dish.parser()));
    if (roastInstrumentation != null) {
      return roast.transform(roastInstrumentation);
    }
    return roast;
  }
}
