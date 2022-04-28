package trisocket;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.46.0)",
    comments = "Source: service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class FarmerGrpc {

  private FarmerGrpc() {}

  public static final String SERVICE_NAME = "trisocket.Farmer";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<trisocket.Order,
      trisocket.Meat> getMeatMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "meat",
      requestType = trisocket.Order.class,
      responseType = trisocket.Meat.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<trisocket.Order,
      trisocket.Meat> getMeatMethod() {
    io.grpc.MethodDescriptor<trisocket.Order, trisocket.Meat> getMeatMethod;
    if ((getMeatMethod = FarmerGrpc.getMeatMethod) == null) {
      synchronized (FarmerGrpc.class) {
        if ((getMeatMethod = FarmerGrpc.getMeatMethod) == null) {
          FarmerGrpc.getMeatMethod = getMeatMethod =
              io.grpc.MethodDescriptor.<trisocket.Order, trisocket.Meat>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "meat"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  trisocket.Order.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  trisocket.Meat.getDefaultInstance()))
              .setSchemaDescriptor(new FarmerMethodDescriptorSupplier("meat"))
              .build();
        }
      }
    }
    return getMeatMethod;
  }

  private static volatile io.grpc.MethodDescriptor<trisocket.Order,
      trisocket.Veggie> getVeggiesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "veggies",
      requestType = trisocket.Order.class,
      responseType = trisocket.Veggie.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<trisocket.Order,
      trisocket.Veggie> getVeggiesMethod() {
    io.grpc.MethodDescriptor<trisocket.Order, trisocket.Veggie> getVeggiesMethod;
    if ((getVeggiesMethod = FarmerGrpc.getVeggiesMethod) == null) {
      synchronized (FarmerGrpc.class) {
        if ((getVeggiesMethod = FarmerGrpc.getVeggiesMethod) == null) {
          FarmerGrpc.getVeggiesMethod = getVeggiesMethod =
              io.grpc.MethodDescriptor.<trisocket.Order, trisocket.Veggie>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "veggies"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  trisocket.Order.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  trisocket.Veggie.getDefaultInstance()))
              .setSchemaDescriptor(new FarmerMethodDescriptorSupplier("veggies"))
              .build();
        }
      }
    }
    return getVeggiesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FarmerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FarmerStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FarmerStub>() {
        @java.lang.Override
        public FarmerStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FarmerStub(channel, callOptions);
        }
      };
    return FarmerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FarmerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FarmerBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FarmerBlockingStub>() {
        @java.lang.Override
        public FarmerBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FarmerBlockingStub(channel, callOptions);
        }
      };
    return FarmerBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FarmerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FarmerFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FarmerFutureStub>() {
        @java.lang.Override
        public FarmerFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FarmerFutureStub(channel, callOptions);
        }
      };
    return FarmerFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class FarmerImplBase implements io.grpc.BindableService {

    /**
     */
    public void meat(trisocket.Order request,
        io.grpc.stub.StreamObserver<trisocket.Meat> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getMeatMethod(), responseObserver);
    }

    /**
     */
    public void veggies(trisocket.Order request,
        io.grpc.stub.StreamObserver<trisocket.Veggie> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getVeggiesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getMeatMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                trisocket.Order,
                trisocket.Meat>(
                  this, METHODID_MEAT)))
          .addMethod(
            getVeggiesMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                trisocket.Order,
                trisocket.Veggie>(
                  this, METHODID_VEGGIES)))
          .build();
    }
  }

  /**
   */
  public static final class FarmerStub extends io.grpc.stub.AbstractAsyncStub<FarmerStub> {
    private FarmerStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FarmerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FarmerStub(channel, callOptions);
    }

    /**
     */
    public void meat(trisocket.Order request,
        io.grpc.stub.StreamObserver<trisocket.Meat> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getMeatMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void veggies(trisocket.Order request,
        io.grpc.stub.StreamObserver<trisocket.Veggie> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getVeggiesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class FarmerBlockingStub extends io.grpc.stub.AbstractBlockingStub<FarmerBlockingStub> {
    private FarmerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FarmerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FarmerBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<trisocket.Meat> meat(
        trisocket.Order request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getMeatMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<trisocket.Veggie> veggies(
        trisocket.Order request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getVeggiesMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class FarmerFutureStub extends io.grpc.stub.AbstractFutureStub<FarmerFutureStub> {
    private FarmerFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FarmerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FarmerFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_MEAT = 0;
  private static final int METHODID_VEGGIES = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FarmerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FarmerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_MEAT:
          serviceImpl.meat((trisocket.Order) request,
              (io.grpc.stub.StreamObserver<trisocket.Meat>) responseObserver);
          break;
        case METHODID_VEGGIES:
          serviceImpl.veggies((trisocket.Order) request,
              (io.grpc.stub.StreamObserver<trisocket.Veggie>) responseObserver);
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

  private static abstract class FarmerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FarmerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return trisocket.ServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Farmer");
    }
  }

  private static final class FarmerFileDescriptorSupplier
      extends FarmerBaseDescriptorSupplier {
    FarmerFileDescriptorSupplier() {}
  }

  private static final class FarmerMethodDescriptorSupplier
      extends FarmerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FarmerMethodDescriptorSupplier(String methodName) {
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
      synchronized (FarmerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FarmerFileDescriptorSupplier())
              .addMethod(getMeatMethod())
              .addMethod(getVeggiesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
