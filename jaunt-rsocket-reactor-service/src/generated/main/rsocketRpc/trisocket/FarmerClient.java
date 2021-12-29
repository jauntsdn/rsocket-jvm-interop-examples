package trisocket;

@javax.annotation.Generated(
    value = "jauntsdn.com rpc compiler (version 1.1.1)",
    comments = "source: service.proto")
@com.jauntsdn.rsocket.Rpc.Generated(
    role = com.jauntsdn.rsocket.Rpc.Role.CLIENT,
    service = Farmer.class)
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
  public reactor.core.publisher.Flux<trisocket.Meat> meat(trisocket.Order message, io.netty.buffer.ByteBuf metadata) {
    reactor.core.publisher.Flux<trisocket.Meat> meat = reactor.core.publisher.Flux.defer(new java.util.function.Supplier<reactor.core.publisher.Flux<com.jauntsdn.rsocket.Message>>() {
      @Override
      public reactor.core.publisher.Flux<com.jauntsdn.rsocket.Message> get() {
        int externalMetadataSize = streams.attributes().intAttr(com.jauntsdn.rsocket.Attributes.EXTERNAL_METADATA_SIZE);
        int dataSize = message.getSerializedSize();
        int localHeader = com.jauntsdn.rsocket.MessageMetadata.header(metadata);
        boolean isDefaultService = com.jauntsdn.rsocket.MessageMetadata.defaultService(localHeader);
        String service = isDefaultService ? com.jauntsdn.rsocket.Rpc.RpcMetadata.defaultService() : Farmer.SERVICE;
        com.jauntsdn.rsocket.Rpc.Codec codec = rpcCodec;
        io.netty.buffer.ByteBuf content = codec.encodeContent(allocator, metadata, localHeader, service, Farmer.METHOD_MEAT, true, Farmer.METHOD_MEAT_IDEMPOTENT, dataSize, externalMetadataSize);
        encode(content, message);
        com.jauntsdn.rsocket.Message message = codec.encodeMessage(content, Farmer.METHOD_MEAT_RANK);
        return streams.requestStream(message);
      }
    }).map(decode(trisocket.Meat.parser()));
    if (meatInstrumentation != null) {
      return meat.transform(meatInstrumentation);
    }
    return meat;
  }

  @Override
  @com.jauntsdn.rsocket.Rpc.GeneratedMethod(returnType = trisocket.Veggie.class)
  public reactor.core.publisher.Flux<trisocket.Veggie> veggies(trisocket.Order message, io.netty.buffer.ByteBuf metadata) {
    reactor.core.publisher.Flux<trisocket.Veggie> veggies = reactor.core.publisher.Flux.defer(new java.util.function.Supplier<reactor.core.publisher.Flux<com.jauntsdn.rsocket.Message>>() {
      @Override
      public reactor.core.publisher.Flux<com.jauntsdn.rsocket.Message> get() {
        int externalMetadataSize = streams.attributes().intAttr(com.jauntsdn.rsocket.Attributes.EXTERNAL_METADATA_SIZE);
        int dataSize = message.getSerializedSize();
        int localHeader = com.jauntsdn.rsocket.MessageMetadata.header(metadata);
        boolean isDefaultService = com.jauntsdn.rsocket.MessageMetadata.defaultService(localHeader);
        String service = isDefaultService ? com.jauntsdn.rsocket.Rpc.RpcMetadata.defaultService() : Farmer.SERVICE;
        com.jauntsdn.rsocket.Rpc.Codec codec = rpcCodec;
        io.netty.buffer.ByteBuf content = codec.encodeContent(allocator, metadata, localHeader, service, Farmer.METHOD_VEGGIES, true, Farmer.METHOD_VEGGIES_IDEMPOTENT, dataSize, externalMetadataSize);
        encode(content, message);
        com.jauntsdn.rsocket.Message message = codec.encodeMessage(content, Farmer.METHOD_VEGGIES_RANK);
        return streams.requestStream(message);
      }
    }).map(decode(trisocket.Veggie.parser()));
    if (veggiesInstrumentation != null) {
      return veggies.transform(veggiesInstrumentation);
    }
    return veggies;
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
      throw new com.jauntsdn.rsocket.exceptions.SerializationException("FarmerClient: message serialization error", t);
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
          throw new com.jauntsdn.rsocket.exceptions.SerializationException("FarmerClient: message deserialization error", t);
        } finally {
          message.release();
        }
      }
    };
  }
}
