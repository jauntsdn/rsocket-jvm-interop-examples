package trisocket;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.53.0)",
    comments = "Source: service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ChefGrpc {

  private ChefGrpc() {}

  public static final String SERVICE_NAME = "trisocket.Chef";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<trisocket.Pan,
      trisocket.Dish> getRoastMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "roast",
      requestType = trisocket.Pan.class,
      responseType = trisocket.Dish.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<trisocket.Pan,
      trisocket.Dish> getRoastMethod() {
    io.grpc.MethodDescriptor<trisocket.Pan, trisocket.Dish> getRoastMethod;
    if ((getRoastMethod = ChefGrpc.getRoastMethod) == null) {
      synchronized (ChefGrpc.class) {
        if ((getRoastMethod = ChefGrpc.getRoastMethod) == null) {
          ChefGrpc.getRoastMethod = getRoastMethod =
              io.grpc.MethodDescriptor.<trisocket.Pan, trisocket.Dish>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "roast"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  trisocket.Pan.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  trisocket.Dish.getDefaultInstance()))
              .setSchemaDescriptor(new ChefMethodDescriptorSupplier("roast"))
              .build();
        }
      }
    }
    return getRoastMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ChefStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ChefStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ChefStub>() {
        @java.lang.Override
        public ChefStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ChefStub(channel, callOptions);
        }
      };
    return ChefStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ChefBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ChefBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ChefBlockingStub>() {
        @java.lang.Override
        public ChefBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ChefBlockingStub(channel, callOptions);
        }
      };
    return ChefBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ChefFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ChefFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ChefFutureStub>() {
        @java.lang.Override
        public ChefFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ChefFutureStub(channel, callOptions);
        }
      };
    return ChefFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ChefImplBase implements io.grpc.BindableService {

    /**
     */
    public void roast(trisocket.Pan request,
        io.grpc.stub.StreamObserver<trisocket.Dish> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRoastMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRoastMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                trisocket.Pan,
                trisocket.Dish>(
                  this, METHODID_ROAST)))
          .build();
    }
  }

  /**
   */
  public static final class ChefStub extends io.grpc.stub.AbstractAsyncStub<ChefStub> {
    private ChefStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChefStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ChefStub(channel, callOptions);
    }

    /**
     */
    public void roast(trisocket.Pan request,
        io.grpc.stub.StreamObserver<trisocket.Dish> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRoastMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ChefBlockingStub extends io.grpc.stub.AbstractBlockingStub<ChefBlockingStub> {
    private ChefBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChefBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ChefBlockingStub(channel, callOptions);
    }

    /**
     */
    public trisocket.Dish roast(trisocket.Pan request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRoastMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ChefFutureStub extends io.grpc.stub.AbstractFutureStub<ChefFutureStub> {
    private ChefFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChefFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ChefFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<trisocket.Dish> roast(
        trisocket.Pan request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRoastMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ROAST = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ChefImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ChefImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ROAST:
          serviceImpl.roast((trisocket.Pan) request,
              (io.grpc.stub.StreamObserver<trisocket.Dish>) responseObserver);
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

  private static abstract class ChefBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ChefBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return trisocket.ServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Chef");
    }
  }

  private static final class ChefFileDescriptorSupplier
      extends ChefBaseDescriptorSupplier {
    ChefFileDescriptorSupplier() {}
  }

  private static final class ChefMethodDescriptorSupplier
      extends ChefBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ChefMethodDescriptorSupplier(String methodName) {
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
      synchronized (ChefGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ChefFileDescriptorSupplier())
              .addMethod(getRoastMethod())
              .build();
        }
      }
    }
    return result;
  }
}
