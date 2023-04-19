package trisocket;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.54.1)",
    comments = "Source: service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RoundsmanGrpc {

  private RoundsmanGrpc() {}

  public static final String SERVICE_NAME = "trisocket.Roundsman";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<trisocket.Veggie,
      trisocket.Veggie> getChopMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "chop",
      requestType = trisocket.Veggie.class,
      responseType = trisocket.Veggie.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<trisocket.Veggie,
      trisocket.Veggie> getChopMethod() {
    io.grpc.MethodDescriptor<trisocket.Veggie, trisocket.Veggie> getChopMethod;
    if ((getChopMethod = RoundsmanGrpc.getChopMethod) == null) {
      synchronized (RoundsmanGrpc.class) {
        if ((getChopMethod = RoundsmanGrpc.getChopMethod) == null) {
          RoundsmanGrpc.getChopMethod = getChopMethod =
              io.grpc.MethodDescriptor.<trisocket.Veggie, trisocket.Veggie>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "chop"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  trisocket.Veggie.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  trisocket.Veggie.getDefaultInstance()))
              .setSchemaDescriptor(new RoundsmanMethodDescriptorSupplier("chop"))
              .build();
        }
      }
    }
    return getChopMethod;
  }

  private static volatile io.grpc.MethodDescriptor<trisocket.Meat,
      trisocket.Meat> getMarinadeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "marinade",
      requestType = trisocket.Meat.class,
      responseType = trisocket.Meat.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<trisocket.Meat,
      trisocket.Meat> getMarinadeMethod() {
    io.grpc.MethodDescriptor<trisocket.Meat, trisocket.Meat> getMarinadeMethod;
    if ((getMarinadeMethod = RoundsmanGrpc.getMarinadeMethod) == null) {
      synchronized (RoundsmanGrpc.class) {
        if ((getMarinadeMethod = RoundsmanGrpc.getMarinadeMethod) == null) {
          RoundsmanGrpc.getMarinadeMethod = getMarinadeMethod =
              io.grpc.MethodDescriptor.<trisocket.Meat, trisocket.Meat>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "marinade"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  trisocket.Meat.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  trisocket.Meat.getDefaultInstance()))
              .setSchemaDescriptor(new RoundsmanMethodDescriptorSupplier("marinade"))
              .build();
        }
      }
    }
    return getMarinadeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RoundsmanStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RoundsmanStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RoundsmanStub>() {
        @java.lang.Override
        public RoundsmanStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RoundsmanStub(channel, callOptions);
        }
      };
    return RoundsmanStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RoundsmanBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RoundsmanBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RoundsmanBlockingStub>() {
        @java.lang.Override
        public RoundsmanBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RoundsmanBlockingStub(channel, callOptions);
        }
      };
    return RoundsmanBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RoundsmanFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RoundsmanFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RoundsmanFutureStub>() {
        @java.lang.Override
        public RoundsmanFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RoundsmanFutureStub(channel, callOptions);
        }
      };
    return RoundsmanFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void chop(trisocket.Veggie request,
        io.grpc.stub.StreamObserver<trisocket.Veggie> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getChopMethod(), responseObserver);
    }

    /**
     */
    default void marinade(trisocket.Meat request,
        io.grpc.stub.StreamObserver<trisocket.Meat> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getMarinadeMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Roundsman.
   */
  public static abstract class RoundsmanImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return RoundsmanGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Roundsman.
   */
  public static final class RoundsmanStub
      extends io.grpc.stub.AbstractAsyncStub<RoundsmanStub> {
    private RoundsmanStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RoundsmanStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RoundsmanStub(channel, callOptions);
    }

    /**
     */
    public void chop(trisocket.Veggie request,
        io.grpc.stub.StreamObserver<trisocket.Veggie> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getChopMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void marinade(trisocket.Meat request,
        io.grpc.stub.StreamObserver<trisocket.Meat> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getMarinadeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Roundsman.
   */
  public static final class RoundsmanBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<RoundsmanBlockingStub> {
    private RoundsmanBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RoundsmanBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RoundsmanBlockingStub(channel, callOptions);
    }

    /**
     */
    public trisocket.Veggie chop(trisocket.Veggie request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getChopMethod(), getCallOptions(), request);
    }

    /**
     */
    public trisocket.Meat marinade(trisocket.Meat request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getMarinadeMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Roundsman.
   */
  public static final class RoundsmanFutureStub
      extends io.grpc.stub.AbstractFutureStub<RoundsmanFutureStub> {
    private RoundsmanFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RoundsmanFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RoundsmanFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<trisocket.Veggie> chop(
        trisocket.Veggie request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getChopMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<trisocket.Meat> marinade(
        trisocket.Meat request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getMarinadeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CHOP = 0;
  private static final int METHODID_MARINADE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CHOP:
          serviceImpl.chop((trisocket.Veggie) request,
              (io.grpc.stub.StreamObserver<trisocket.Veggie>) responseObserver);
          break;
        case METHODID_MARINADE:
          serviceImpl.marinade((trisocket.Meat) request,
              (io.grpc.stub.StreamObserver<trisocket.Meat>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getChopMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              trisocket.Veggie,
              trisocket.Veggie>(
                service, METHODID_CHOP)))
        .addMethod(
          getMarinadeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              trisocket.Meat,
              trisocket.Meat>(
                service, METHODID_MARINADE)))
        .build();
  }

  private static abstract class RoundsmanBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RoundsmanBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return trisocket.ServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Roundsman");
    }
  }

  private static final class RoundsmanFileDescriptorSupplier
      extends RoundsmanBaseDescriptorSupplier {
    RoundsmanFileDescriptorSupplier() {}
  }

  private static final class RoundsmanMethodDescriptorSupplier
      extends RoundsmanBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RoundsmanMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (RoundsmanGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RoundsmanFileDescriptorSupplier())
              .addMethod(getChopMethod())
              .addMethod(getMarinadeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
