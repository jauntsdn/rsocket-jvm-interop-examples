package trisocket;

@javax.annotation.Generated(
    value = "jauntsdn.com rpc compiler (version 1.5.4)",
    comments = "source: service.proto")
@com.jauntsdn.rsocket.Rpc.Generated(
    role = com.jauntsdn.rsocket.Rpc.Role.CLIENT,
    service = Farmer.class)
@SuppressWarnings("all")
public final class FarmerClient implements Farmer {
  private final com.jauntsdn.rsocket.MessageStreams streams;
  private final io.netty.buffer.ByteBufAllocator allocator;
  private final java.util.function.Function<? super org.reactivestreams.Publisher<trisocket.Meat>, ? extends org.reactivestreams.Publisher<trisocket.Meat>> meatInstrumentation;
  private final java.util.function.Function<? super org.reactivestreams.Publisher<trisocket.Veggie>, ? extends org.reactivestreams.Publisher<trisocket.Veggie>> veggiesInstrumentation;
  private final com.jauntsdn.rsocket.Rpc.Codec rpcCodec;

  private FarmerClient(com.jauntsdn.rsocket.MessageStreams streams, java.util.Optional<com.jauntsdn.rsocket.RpcInstrumentation> instrumentation) {
    this.streams = streams;
    this.allocator = streams.allocator().orElse(io.netty.buffer.ByteBufAllocator.DEFAULT);
    com.jauntsdn.rsocket.RpcInstrumentation i = instrumentation == null
      ? streams.attributes().attr(com.jauntsdn.rsocket.Attributes.RPC_INSTRUMENTATION)
      : instrumentation.orElse(null);
    if (i == null) {
      this.meatInstrumentation = null;
      this.veggiesInstrumentation = null;
    } else {
      this.meatInstrumentation = i.instrument("client", Farmer.SERVICE, Farmer.METHOD_MEAT, true);
      this.veggiesInstrumentation = i.instrument("client", Farmer.SERVICE, Farmer.METHOD_VEGGIES, true);
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

  public static FarmerClient create(com.jauntsdn.rsocket.MessageStreams streams, java.util.Optional<com.jauntsdn.rsocket.RpcInstrumentation> instrumentation) {
    java.util.Objects.requireNonNull(streams, "streams");
    java.util.Objects.requireNonNull(instrumentation, "instrumentation");
    return new FarmerClient(streams, instrumentation);
  }

  public static FarmerClient create(com.jauntsdn.rsocket.MessageStreams streams) {
    java.util.Objects.requireNonNull(streams, "streams");
    return new FarmerClient(streams, null);
  }

  @Override
  @com.jauntsdn.rsocket.Rpc.GeneratedMethod(returnType = trisocket.Meat.class)
  public reactor.core.publisher.Flux<trisocket.Meat> meat(trisocket.Order message, com.jauntsdn.rsocket.Headers headersMetadata) {
    reactor.core.publisher.Flux<trisocket.Meat> meat = reactor.core.publisher.Flux.defer(new java.util.function.Supplier<reactor.core.publisher.Flux<com.jauntsdn.rsocket.Message>>() {
      @Override
      public reactor.core.publisher.Flux<com.jauntsdn.rsocket.Message> get() {
        int externalMetadataSize = streams.attributes().intAttr(com.jauntsdn.rsocket.Attributes.EXTERNAL_METADATA_SIZE);
        int dataSize = message.getSerializedSize();
        boolean isDefaultService = headersMetadata.isDefaultService();
        String service = isDefaultService ? com.jauntsdn.rsocket.Rpc.RpcMetadata.defaultService() : Farmer.SERVICE;
        io.netty.buffer.ByteBuf metadata = com.jauntsdn.rsocket.generated.ProtobufCodec.encodeHeaders(headersMetadata);
        com.jauntsdn.rsocket.Rpc.Codec codec = rpcCodec;
        io.netty.buffer.ByteBuf content = codec.encodeContent(allocator, metadata, service, Farmer.METHOD_MEAT, true, Farmer.METHOD_MEAT_IDEMPOTENT, dataSize, externalMetadataSize);
        com.jauntsdn.rsocket.generated.ProtobufCodec.encode("FarmerClient", content, message);
        com.jauntsdn.rsocket.Message message = codec.encodeMessage(content, Farmer.METHOD_MEAT_RANK);
        return streams.requestStream(message);
      }
    }).map(com.jauntsdn.rsocket.generated.ProtobufCodec.decode("FarmerClient", trisocket.Meat.parser()));
    if (meatInstrumentation != null) {
      return meat.transform(meatInstrumentation);
    }
    return meat;
  }

  @Override
  @com.jauntsdn.rsocket.Rpc.GeneratedMethod(returnType = trisocket.Veggie.class)
  public reactor.core.publisher.Flux<trisocket.Veggie> veggies(trisocket.Order message, com.jauntsdn.rsocket.Headers headersMetadata) {
    reactor.core.publisher.Flux<trisocket.Veggie> veggies = reactor.core.publisher.Flux.defer(new java.util.function.Supplier<reactor.core.publisher.Flux<com.jauntsdn.rsocket.Message>>() {
      @Override
      public reactor.core.publisher.Flux<com.jauntsdn.rsocket.Message> get() {
        int externalMetadataSize = streams.attributes().intAttr(com.jauntsdn.rsocket.Attributes.EXTERNAL_METADATA_SIZE);
        int dataSize = message.getSerializedSize();
        boolean isDefaultService = headersMetadata.isDefaultService();
        String service = isDefaultService ? com.jauntsdn.rsocket.Rpc.RpcMetadata.defaultService() : Farmer.SERVICE;
        io.netty.buffer.ByteBuf metadata = com.jauntsdn.rsocket.generated.ProtobufCodec.encodeHeaders(headersMetadata);
        com.jauntsdn.rsocket.Rpc.Codec codec = rpcCodec;
        io.netty.buffer.ByteBuf content = codec.encodeContent(allocator, metadata, service, Farmer.METHOD_VEGGIES, true, Farmer.METHOD_VEGGIES_IDEMPOTENT, dataSize, externalMetadataSize);
        com.jauntsdn.rsocket.generated.ProtobufCodec.encode("FarmerClient", content, message);
        com.jauntsdn.rsocket.Message message = codec.encodeMessage(content, Farmer.METHOD_VEGGIES_RANK);
        return streams.requestStream(message);
      }
    }).map(com.jauntsdn.rsocket.generated.ProtobufCodec.decode("FarmerClient", trisocket.Veggie.parser()));
    if (veggiesInstrumentation != null) {
      return veggies.transform(veggiesInstrumentation);
    }
    return veggies;
  }
}
