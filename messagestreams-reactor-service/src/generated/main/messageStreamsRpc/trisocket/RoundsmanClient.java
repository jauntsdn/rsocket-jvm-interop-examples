package trisocket;

@javax.annotation.Generated(
    value = "jauntsdn.com rpc compiler (version 1.5.1)",
    comments = "source: service.proto")
@com.jauntsdn.rsocket.Rpc.Generated(
    role = com.jauntsdn.rsocket.Rpc.Role.CLIENT,
    service = Roundsman.class)
@SuppressWarnings("all")
public final class RoundsmanClient implements Roundsman {
  private final com.jauntsdn.rsocket.MessageStreams streams;
  private final io.netty.buffer.ByteBufAllocator allocator;
  private final java.util.function.Function<? super org.reactivestreams.Publisher<trisocket.Veggie>, ? extends org.reactivestreams.Publisher<trisocket.Veggie>> chopInstrumentation;
  private final java.util.function.Function<? super org.reactivestreams.Publisher<trisocket.Meat>, ? extends org.reactivestreams.Publisher<trisocket.Meat>> marinadeInstrumentation;
  private final com.jauntsdn.rsocket.Rpc.Codec rpcCodec;

  private RoundsmanClient(com.jauntsdn.rsocket.MessageStreams streams, java.util.Optional<com.jauntsdn.rsocket.RpcInstrumentation> instrumentation) {
    this.streams = streams;
    this.allocator = streams.allocator().orElse(io.netty.buffer.ByteBufAllocator.DEFAULT);
    com.jauntsdn.rsocket.RpcInstrumentation i = instrumentation == null
      ? streams.attributes().attr(com.jauntsdn.rsocket.Attributes.RPC_INSTRUMENTATION)
      : instrumentation.orElse(null);
    if (i == null) {
      this.chopInstrumentation = null;
      this.marinadeInstrumentation = null;
    } else {
      this.chopInstrumentation = i.instrument("client", Roundsman.SERVICE, Roundsman.METHOD_CHOP, false);
      this.marinadeInstrumentation = i.instrument("client", Roundsman.SERVICE, Roundsman.METHOD_MARINADE, false);
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

  public static RoundsmanClient create(com.jauntsdn.rsocket.MessageStreams streams, java.util.Optional<com.jauntsdn.rsocket.RpcInstrumentation> instrumentation) {
    java.util.Objects.requireNonNull(streams, "streams");
    java.util.Objects.requireNonNull(instrumentation, "instrumentation");
    return new RoundsmanClient(streams, instrumentation);
  }

  public static RoundsmanClient create(com.jauntsdn.rsocket.MessageStreams streams) {
    java.util.Objects.requireNonNull(streams, "streams");
    return new RoundsmanClient(streams, null);
  }

  @Override
  @com.jauntsdn.rsocket.Rpc.GeneratedMethod(returnType = trisocket.Veggie.class)
  public reactor.core.publisher.Mono<trisocket.Veggie> chop(trisocket.Veggie message, com.jauntsdn.rsocket.Headers headersMetadata) {
    reactor.core.publisher.Mono<trisocket.Veggie> chop = reactor.core.publisher.Mono.defer(new java.util.function.Supplier<reactor.core.publisher.Mono<com.jauntsdn.rsocket.Message>>() {
      @Override
      public reactor.core.publisher.Mono<com.jauntsdn.rsocket.Message> get() {
        int externalMetadataSize = streams.attributes().intAttr(com.jauntsdn.rsocket.Attributes.EXTERNAL_METADATA_SIZE);
        int dataSize = message.getSerializedSize();
        boolean isDefaultService = headersMetadata.isDefaultService();
        String service = isDefaultService ? com.jauntsdn.rsocket.Rpc.RpcMetadata.defaultService() : Roundsman.SERVICE;
        io.netty.buffer.ByteBuf metadata = com.jauntsdn.rsocket.generated.ProtobufCodec.encodeHeaders(headersMetadata);
        com.jauntsdn.rsocket.Rpc.Codec codec = rpcCodec;
        io.netty.buffer.ByteBuf content = codec.encodeContent(allocator, metadata, service, Roundsman.METHOD_CHOP, false, Roundsman.METHOD_CHOP_IDEMPOTENT, dataSize, externalMetadataSize);
        com.jauntsdn.rsocket.generated.ProtobufCodec.encode("RoundsmanClient", content, message);
        com.jauntsdn.rsocket.Message message = codec.encodeMessage(content, Roundsman.METHOD_CHOP_RANK);
        return streams.requestResponse(message);
      }
    }).map(com.jauntsdn.rsocket.generated.ProtobufCodec.decode("RoundsmanClient", trisocket.Veggie.parser()));
    if (chopInstrumentation != null) {
      return chop.transform(chopInstrumentation);
    }
    return chop;
  }

  @Override
  @com.jauntsdn.rsocket.Rpc.GeneratedMethod(returnType = trisocket.Meat.class)
  public reactor.core.publisher.Mono<trisocket.Meat> marinade(trisocket.Meat message, com.jauntsdn.rsocket.Headers headersMetadata) {
    reactor.core.publisher.Mono<trisocket.Meat> marinade = reactor.core.publisher.Mono.defer(new java.util.function.Supplier<reactor.core.publisher.Mono<com.jauntsdn.rsocket.Message>>() {
      @Override
      public reactor.core.publisher.Mono<com.jauntsdn.rsocket.Message> get() {
        int externalMetadataSize = streams.attributes().intAttr(com.jauntsdn.rsocket.Attributes.EXTERNAL_METADATA_SIZE);
        int dataSize = message.getSerializedSize();
        boolean isDefaultService = headersMetadata.isDefaultService();
        String service = isDefaultService ? com.jauntsdn.rsocket.Rpc.RpcMetadata.defaultService() : Roundsman.SERVICE;
        io.netty.buffer.ByteBuf metadata = com.jauntsdn.rsocket.generated.ProtobufCodec.encodeHeaders(headersMetadata);
        com.jauntsdn.rsocket.Rpc.Codec codec = rpcCodec;
        io.netty.buffer.ByteBuf content = codec.encodeContent(allocator, metadata, service, Roundsman.METHOD_MARINADE, false, Roundsman.METHOD_MARINADE_IDEMPOTENT, dataSize, externalMetadataSize);
        com.jauntsdn.rsocket.generated.ProtobufCodec.encode("RoundsmanClient", content, message);
        com.jauntsdn.rsocket.Message message = codec.encodeMessage(content, Roundsman.METHOD_MARINADE_RANK);
        return streams.requestResponse(message);
      }
    }).map(com.jauntsdn.rsocket.generated.ProtobufCodec.decode("RoundsmanClient", trisocket.Meat.parser()));
    if (marinadeInstrumentation != null) {
      return marinade.transform(marinadeInstrumentation);
    }
    return marinade;
  }
}
