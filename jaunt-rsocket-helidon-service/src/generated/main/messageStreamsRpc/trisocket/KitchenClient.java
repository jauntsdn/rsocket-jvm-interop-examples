package trisocket;

@jakarta.annotation.Generated(
    value = "jauntsdn.com rpc compiler (version 1.1.4)",
    comments = "source: service.proto")
@com.jauntsdn.rsocket.Rpc.Generated(
    role = com.jauntsdn.rsocket.Rpc.Role.CLIENT,
    service = Kitchen.class)
@SuppressWarnings("all")
public final class KitchenClient implements Kitchen {
  private final com.jauntsdn.rsocket.MessageStreams streams;
  private final io.netty.buffer.ByteBufAllocator allocator;
  private final java.util.function.Function<? super java.util.concurrent.Flow.Publisher<trisocket.Dish>, ? extends java.util.concurrent.Flow.Publisher<trisocket.Dish>> serveInstrumentation;
  private final com.jauntsdn.rsocket.Rpc.Codec rpcCodec;

  private KitchenClient(com.jauntsdn.rsocket.MessageStreams streams, java.util.Optional<com.jauntsdn.rsocket.RpcInstrumentation> instrumentation) {
    this.streams = streams;
    this.allocator = streams.allocator().orElse(io.netty.buffer.ByteBufAllocator.DEFAULT);
    com.jauntsdn.rsocket.RpcInstrumentation i = instrumentation == null
      ? streams.attributes().attr(com.jauntsdn.rsocket.Attributes.RPC_INSTRUMENTATION)
      : instrumentation.orElse(null);
    if (i == null) {
      this.serveInstrumentation = null;
    } else {
      this.serveInstrumentation = i.instrumentMulti("client", Kitchen.SERVICE, Kitchen.METHOD_SERVE, true);
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

  public static KitchenClient create(com.jauntsdn.rsocket.MessageStreams streams, java.util.Optional<com.jauntsdn.rsocket.RpcInstrumentation> instrumentation) {
    java.util.Objects.requireNonNull(streams, "streams");
    java.util.Objects.requireNonNull(instrumentation, "instrumentation");
    return new KitchenClient(streams, instrumentation);
  }

  public static KitchenClient create(com.jauntsdn.rsocket.MessageStreams streams) {
    java.util.Objects.requireNonNull(streams, "streams");
    return new KitchenClient(streams, null);
  }

  @Override
  @com.jauntsdn.rsocket.Rpc.GeneratedMethod(returnType = trisocket.Dish.class)
  public io.helidon.common.reactive.Multi<trisocket.Dish> serve(java.util.concurrent.Flow.Publisher<trisocket.Order> messages, io.netty.buffer.ByteBuf metadata) {
    io.helidon.common.reactive.Multi<trisocket.Dish> serve = 
      io.helidon.common.reactive.Multi.defer(new java.util.function.Supplier<java.util.concurrent.Flow.Publisher<com.jauntsdn.rsocket.Message>>() {

        @Override
        public java.util.concurrent.Flow.Publisher<com.jauntsdn.rsocket.Message> get() {
          return streams.requestChannel(io.helidon.common.reactive.Multi.from(messages).map(
            new java.util.function.Function<com.google.protobuf.MessageLite, com.jauntsdn.rsocket.Message>() {
              private boolean started;

              @Override
              public com.jauntsdn.rsocket.Message apply(com.google.protobuf.MessageLite message) {
                int dataSize = message.getSerializedSize();
                com.jauntsdn.rsocket.Rpc.Codec codec = rpcCodec;
                if (!started) {
                  started = true;
                  int externalMetadataSize = streams.attributes().intAttr(com.jauntsdn.rsocket.Attributes.EXTERNAL_METADATA_SIZE);
                  int localHeader = com.jauntsdn.rsocket.MessageMetadata.header(metadata);
                  boolean isDefaultService = com.jauntsdn.rsocket.MessageMetadata.defaultService(localHeader);
                  String service = isDefaultService ? com.jauntsdn.rsocket.Rpc.RpcMetadata.defaultService() : Kitchen.SERVICE;
                  io.netty.buffer.ByteBuf content = codec.encodeContent(allocator, metadata, localHeader, service, Kitchen.METHOD_SERVE, true, Kitchen.METHOD_SERVE_IDEMPOTENT, dataSize, externalMetadataSize);
                  encode(content, message);
                  return codec.encodeMessage(content, Kitchen.METHOD_SERVE_RANK);
                } else {
                  io.netty.buffer.ByteBuf content = codec.encodeContent(allocator, dataSize);
                  encode(content, message);
                  return codec.encodeMessage(content);
                }
              }
             }));
           }
          }).map(decode(trisocket.Dish.parser()));
          if (serveInstrumentation != null) {
            return serve.compose(serveInstrumentation);
          }
          return serve;
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
          throw new com.jauntsdn.rsocket.exceptions.SerializationException("KitchenClient: message serialization error", t);
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
              throw new com.jauntsdn.rsocket.exceptions.SerializationException("KitchenClient: message deserialization error", t);
            } finally {
              message.release();
            }
          }
        };
      }
    }
