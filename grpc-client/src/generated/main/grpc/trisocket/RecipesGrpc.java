package trisocket;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.46.0)",
    comments = "Source: service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RecipesGrpc {

  private RecipesGrpc() {}

  public static final String SERVICE_NAME = "trisocket.Recipes";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<trisocket.Meat,
      trisocket.Recipe> getMarinadeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "marinade",
      requestType = trisocket.Meat.class,
      responseType = trisocket.Recipe.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<trisocket.Meat,
      trisocket.Recipe> getMarinadeMethod() {
    io.grpc.MethodDescriptor<trisocket.Meat, trisocket.Recipe> getMarinadeMethod;
    if ((getMarinadeMethod = RecipesGrpc.getMarinadeMethod) == null) {
      synchronized (RecipesGrpc.class) {
        if ((getMarinadeMethod = RecipesGrpc.getMarinadeMethod) == null) {
          RecipesGrpc.getMarinadeMethod = getMarinadeMethod =
              io.grpc.MethodDescriptor.<trisocket.Meat, trisocket.Recipe>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "marinade"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  trisocket.Meat.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  trisocket.Recipe.getDefaultInstance()))
              .setSchemaDescriptor(new RecipesMethodDescriptorSupplier("marinade"))
              .build();
        }
      }
    }
    return getMarinadeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RecipesStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RecipesStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RecipesStub>() {
        @java.lang.Override
        public RecipesStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RecipesStub(channel, callOptions);
        }
      };
    return RecipesStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RecipesBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RecipesBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RecipesBlockingStub>() {
        @java.lang.Override
        public RecipesBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RecipesBlockingStub(channel, callOptions);
        }
      };
    return RecipesBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RecipesFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RecipesFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RecipesFutureStub>() {
        @java.lang.Override
        public RecipesFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RecipesFutureStub(channel, callOptions);
        }
      };
    return RecipesFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class RecipesImplBase implements io.grpc.BindableService {

    /**
     */
    public void marinade(trisocket.Meat request,
        io.grpc.stub.StreamObserver<trisocket.Recipe> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getMarinadeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getMarinadeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                trisocket.Meat,
                trisocket.Recipe>(
                  this, METHODID_MARINADE)))
          .build();
    }
  }

  /**
   */
  public static final class RecipesStub extends io.grpc.stub.AbstractAsyncStub<RecipesStub> {
    private RecipesStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecipesStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecipesStub(channel, callOptions);
    }

    /**
     */
    public void marinade(trisocket.Meat request,
        io.grpc.stub.StreamObserver<trisocket.Recipe> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getMarinadeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RecipesBlockingStub extends io.grpc.stub.AbstractBlockingStub<RecipesBlockingStub> {
    private RecipesBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecipesBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecipesBlockingStub(channel, callOptions);
    }

    /**
     */
    public trisocket.Recipe marinade(trisocket.Meat request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getMarinadeMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RecipesFutureStub extends io.grpc.stub.AbstractFutureStub<RecipesFutureStub> {
    private RecipesFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecipesFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecipesFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<trisocket.Recipe> marinade(
        trisocket.Meat request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getMarinadeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_MARINADE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RecipesImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RecipesImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_MARINADE:
          serviceImpl.marinade((trisocket.Meat) request,
              (io.grpc.stub.StreamObserver<trisocket.Recipe>) responseObserver);
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

  private static abstract class RecipesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RecipesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return trisocket.ServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Recipes");
    }
  }

  private static final class RecipesFileDescriptorSupplier
      extends RecipesBaseDescriptorSupplier {
    RecipesFileDescriptorSupplier() {}
  }

  private static final class RecipesMethodDescriptorSupplier
      extends RecipesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RecipesMethodDescriptorSupplier(String methodName) {
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
      synchronized (RecipesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RecipesFileDescriptorSupplier())
              .addMethod(getMarinadeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
