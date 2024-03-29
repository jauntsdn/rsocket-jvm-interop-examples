// Generated by jauntsdn.com rpc compiler (version 1.5.4)
// source: control_service.proto

package trisocket;

@com.jauntsdn.rsocket.Rpc.Generated(
    role = com.jauntsdn.rsocket.Rpc.Role.CLIENT,
    service = Supervisor.class)
@SuppressWarnings("all")
public final class SupervisorClient implements Supervisor {
  private final com.jauntsdn.rsocket.MessageStreams streams;
  private final io.netty.buffer.ByteBufAllocator allocator;
  private final io.reactivex.rxjava3.core.SingleTransformer<trisocket.Report, trisocket.Report> inquiryInstrumentation;
  private final com.jauntsdn.rsocket.Rpc.Codec rpcCodec;

  private SupervisorClient(com.jauntsdn.rsocket.MessageStreams streams, java.util.Optional<com.jauntsdn.rsocket.RpcInstrumentation> instrumentation) {
    this.streams = streams;
    this.allocator = streams.allocator().orElse(io.netty.buffer.ByteBufAllocator.DEFAULT);
    com.jauntsdn.rsocket.RpcInstrumentation i = instrumentation == null
      ? streams.attributes().attr(com.jauntsdn.rsocket.Attributes.RPC_INSTRUMENTATION)
      : instrumentation.orElse(null);
    if (i == null) {
      this.inquiryInstrumentation = null;
    } else {
      this.inquiryInstrumentation = i.instrumentSingle("client", Supervisor.SERVICE, Supervisor.METHOD_INQUIRY);
    }
    com.jauntsdn.rsocket.Rpc.Codec codec = streams.attributes().attr(com.jauntsdn.rsocket.Attributes.RPC_CODEC);
    if (codec != null) {
      rpcCodec = codec;
      if (codec.isDisposable()) {
        streams.onClose().subscribe(() -> codec.dispose());
      }
      return;
    }
    throw new IllegalArgumentException("MessageStreams " + streams.getClass() + " does not provide RPC codec");
  }

  public static SupervisorClient create(com.jauntsdn.rsocket.MessageStreams streams, java.util.Optional<com.jauntsdn.rsocket.RpcInstrumentation> instrumentation) {
    java.util.Objects.requireNonNull(streams, "streams");
    java.util.Objects.requireNonNull(instrumentation, "instrumentation");
    return new SupervisorClient(streams, instrumentation);
  }

  public static SupervisorClient create(com.jauntsdn.rsocket.MessageStreams streams) {
    java.util.Objects.requireNonNull(streams, "streams");
    return new SupervisorClient(streams, null);
  }

  @Override
  @com.jauntsdn.rsocket.Rpc.GeneratedMethod(returnType = trisocket.Report.class)
  public io.reactivex.rxjava3.core.Single<trisocket.Report> inquiry(trisocket.Inquiry message, com.jauntsdn.rsocket.Headers headersMetadata) {
    io.reactivex.rxjava3.core.Single<trisocket.Report> inquiry = io.reactivex.rxjava3.core.Single.defer(new io.reactivex.rxjava3.functions.Supplier<io.reactivex.rxjava3.core.Single<com.jauntsdn.rsocket.Message>>() {
      @Override
      public io.reactivex.rxjava3.core.Single<com.jauntsdn.rsocket.Message> get() {
        int externalMetadataSize = streams.attributes().intAttr(com.jauntsdn.rsocket.Attributes.EXTERNAL_METADATA_SIZE);
        int dataSize = message.getSerializedSize();
        boolean isDefaultService = headersMetadata.isDefaultService();
        String service = isDefaultService ? com.jauntsdn.rsocket.Rpc.RpcMetadata.defaultService() : Supervisor.SERVICE;
        io.netty.buffer.ByteBuf metadata = com.jauntsdn.rsocket.generated.ProtobufCodec.encodeHeaders(headersMetadata);
        com.jauntsdn.rsocket.Rpc.Codec codec = rpcCodec;
        io.netty.buffer.ByteBuf content = codec.encodeContent(allocator, metadata, service, Supervisor.METHOD_INQUIRY, false, Supervisor.METHOD_INQUIRY_IDEMPOTENT, dataSize, externalMetadataSize);
        com.jauntsdn.rsocket.generated.ProtobufCodec.encode("SupervisorClient", content, message);
        com.jauntsdn.rsocket.Message message = codec.encodeMessage(content, Supervisor.METHOD_INQUIRY_RANK);
        return streams.requestResponse(message);
      }
    }).map(com.jauntsdn.rsocket.generated.ProtobufCodec.decode("SupervisorClient", trisocket.Report.parser()));
    if (inquiryInstrumentation != null) {
      return inquiry.compose(inquiryInstrumentation);
    }
    return inquiry;
  }
}
