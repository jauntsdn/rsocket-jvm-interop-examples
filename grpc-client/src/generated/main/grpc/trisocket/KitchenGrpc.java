package trisocket;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.46.0)",
    comments = "Source: service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class KitchenGrpc {

  private KitchenGrpc() {}

  public static final String SERVICE_NAME = "trisocket.Kitchen";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<trisocket.Order,
      trisocket.Dish> getServeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "serve",
      requestType = trisocket.Order.class,
      responseType = trisocket.Dish.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<trisocket.Order,
      trisocket.Dish> getServeMethod() {
    io.grpc.MethodDescriptor<trisocket.Order, trisocket.Dish> getServeMethod;
    if ((getServeMethod = KitchenGrpc.getServeMethod) == null) {
      synchronized (KitchenGrpc.class) {
        if ((getServeMethod = KitchenGrpc.getServeMethod) == null) {
          KitchenGrpc.getServeMethod = getServeMethod =
              io.grpc.MethodDescriptor.<trisocket.Order, trisocket.Dish>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "serve"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  trisocket.Order.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  trisocket.Dish.getDefaultInstance()))
              .setSchemaDescriptor(new KitchenMethodDescriptorSupplier("serve"))
              .build();
        }
      }
    }
    return getServeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static KitchenStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<KitchenStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<KitchenStub>() {
        @java.lang.Override
        public KitchenStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new KitchenStub(channel, callOptions);
        }
      };
    return KitchenStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static KitchenBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<KitchenBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<KitchenBlockingStub>() {
        @java.lang.Override
        public KitchenBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new KitchenBlockingStub(channel, callOptions);
        }
      };
    return KitchenBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static KitchenFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<KitchenFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<KitchenFutureStub>() {
        @java.lang.Override
        public KitchenFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new KitchenFutureStub(channel, callOptions);
        }
      };
    return KitchenFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class KitchenImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<trisocket.Order> serve(
        io.grpc.stub.StreamObserver<trisocket.Dish> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getServeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getServeMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                trisocket.Order,
                trisocket.Dish>(
                  this, METHODID_SERVE)))
          .build();
    }
  }

  /**
   */
  public static final class KitchenStub extends io.grpc.stub.AbstractAsyncStub<KitchenStub> {
    private KitchenStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected KitchenStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new KitchenStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<trisocket.Order> serve(
        io.grpc.stub.StreamObserver<trisocket.Dish> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getServeMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class KitchenBlockingStub extends io.grpc.stub.AbstractBlockingStub<KitchenBlockingStub> {
    private KitchenBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected KitchenBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new KitchenBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class KitchenFutureStub extends io.grpc.stub.AbstractFutureStub<KitchenFutureStub> {
    private KitchenFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected KitchenFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new KitchenFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_SERVE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final KitchenImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(KitchenImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SERVE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.serve(
              (io.grpc.stub.StreamObserver<trisocket.Dish>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class KitchenBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    KitchenBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return trisocket.ServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Kitchen");
    }
  }

  private static final class KitchenFileDescriptorSupplier
      extends KitchenBaseDescriptorSupplier {
    KitchenFileDescriptorSupplier() {}
  }

  private static final class KitchenMethodDescriptorSupplier
      extends KitchenBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    KitchenMethodDescriptorSupplier(String methodName) {
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
      synchronized (KitchenGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new KitchenFileDescriptorSupplier())
              .addMethod(getServeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
