package trisocket;

@javax.annotation.Generated(
    value = "jauntsdn.com rpc compiler (version 1.1.3)",
    comments = "source: service.proto")
@com.jauntsdn.rsocket.Rpc.Generated(
    role = com.jauntsdn.rsocket.Rpc.Role.CLIENT,
    service = Roundsman.class)
public final class RoundsmanClient implements Roundsman {
  private final com.jauntsdn.rsocket.MessageStreams streams;
  private final io.netty.buffer.ByteBufAllocator allocator;
  private final com.jauntsdn.rsocket.RpcInstrumentation.Factory<trisocket.Veggie> chopInstrumentation;
  private final com.jauntsdn.rsocket.RpcInstrumentation.Factory<trisocket.Meat> marinadeInstrumentation;
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
      this.chopInstrumentation = i.instrument("client", Roundsman.SERVICE, Roundsman.METHOD_CHOP, true);
      this.marinadeInstrumentation = i.instrument("client", Roundsman.SERVICE, Roundsman.METHOD_MARINADE, true);
    }
    com.jauntsdn.rsocket.Rpc.Codec codec = streams.attributes().attr(com.jauntsdn.rsocket.Attributes.RPC_CODEC);
    if (codec != null) {
      rpcCodec = codec;
      if (codec.isDisposable()) {
        streams.onClose().thenAccept(ignored -> codec.dispose());
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
  public java.util.concurrent.CompletionStage<trisocket.Veggie> chop(trisocket.Veggie message, io.netty.buffer.ByteBuf metadata) {
    int externalMetadataSize = streams.attributes().intAttr(com.jauntsdn.rsocket.Attributes.EXTERNAL_METADATA_SIZE);
    int dataSize = message.getSerializedSize();
    int localHeader = com.jauntsdn.rsocket.MessageMetadata.header(metadata);
    boolean isDefaultService = com.jauntsdn.rsocket.MessageMetadata.defaultService(localHeader);
    String service = isDefaultService ? com.jauntsdn.rsocket.Rpc.RpcMetadata.defaultService() : Roundsman.SERVICE;
    com.jauntsdn.rsocket.Rpc.Codec codec = rpcCodec;
    io.netty.buffer.ByteBuf content = codec.encodeContent(allocator, metadata, localHeader, service, Roundsman.METHOD_CHOP, false, Roundsman.METHOD_CHOP_IDEMPOTENT, dataSize, externalMetadataSize);
    encode(content, message);
    com.jauntsdn.rsocket.Message msg = codec.encodeMessage(content, Roundsman.METHOD_CHOP_RANK);
    com.jauntsdn.rsocket.RpcInstrumentation.Listener<trisocket.Veggie> instrumentationListener = null;
    if (chopInstrumentation != null) {
      instrumentationListener = chopInstrumentation.create();
      instrumentationListener.onStart();
    }
    java.util.concurrent.CompletionStage<trisocket.Veggie> chop = streams.requestResponse(msg).thenApply(decode(trisocket.Veggie.parser()));
    if (instrumentationListener != null) {
      chop.whenComplete(instrumentationListener.onComplete());
    }
    return chop;
  }

  @Override
  @com.jauntsdn.rsocket.Rpc.GeneratedMethod(returnType = trisocket.Meat.class)
  public java.util.concurrent.CompletionStage<trisocket.Meat> marinade(trisocket.Meat message, io.netty.buffer.ByteBuf metadata) {
    int externalMetadataSize = streams.attributes().intAttr(com.jauntsdn.rsocket.Attributes.EXTERNAL_METADATA_SIZE);
    int dataSize = message.getSerializedSize();
    int localHeader = com.jauntsdn.rsocket.MessageMetadata.header(metadata);
    boolean isDefaultService = com.jauntsdn.rsocket.MessageMetadata.defaultService(localHeader);
    String service = isDefaultService ? com.jauntsdn.rsocket.Rpc.RpcMetadata.defaultService() : Roundsman.SERVICE;
    com.jauntsdn.rsocket.Rpc.Codec codec = rpcCodec;
    io.netty.buffer.ByteBuf content = codec.encodeContent(allocator, metadata, localHeader, service, Roundsman.METHOD_MARINADE, false, Roundsman.METHOD_MARINADE_IDEMPOTENT, dataSize, externalMetadataSize);
    encode(content, message);
    com.jauntsdn.rsocket.Message msg = codec.encodeMessage(content, Roundsman.METHOD_MARINADE_RANK);
    com.jauntsdn.rsocket.RpcInstrumentation.Listener<trisocket.Meat> instrumentationListener = null;
    if (marinadeInstrumentation != null) {
      instrumentationListener = marinadeInstrumentation.create();
      instrumentationListener.onStart();
    }
    java.util.concurrent.CompletionStage<trisocket.Meat> marinade = streams.requestResponse(msg).thenApply(decode(trisocket.Meat.parser()));
    if (instrumentationListener != null) {
      marinade.whenComplete(instrumentationListener.onComplete());
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
      throw new com.jauntsdn.rsocket.exceptions.SerializationException("RoundsmanClient: message serialization error", t);
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
          throw new com.jauntsdn.rsocket.exceptions.SerializationException("RoundsmanClient: message deserialization error", t);
        } finally {
          message.release();
        }
      }
    };
  }
}
