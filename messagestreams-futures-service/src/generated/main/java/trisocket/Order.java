// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service.proto

// Protobuf Java Version: 3.25.3
package trisocket;

/**
 * Protobuf type {@code trisocket.Order}
 */
public  final class Order extends
    com.google.protobuf.GeneratedMessageLite<
        Order, Order.Builder> implements
    // @@protoc_insertion_point(message_implements:trisocket.Order)
    OrderOrBuilder {
  private Order() {
  }
  public static final int COUNT_FIELD_NUMBER = 1;
  private int count_;
  /**
   * <code>int32 count = 1;</code>
   * @return The count.
   */
  @java.lang.Override
  public int getCount() {
    return count_;
  }
  /**
   * <code>int32 count = 1;</code>
   * @param value The count to set.
   */
  private void setCount(int value) {
    
    count_ = value;
  }
  /**
   * <code>int32 count = 1;</code>
   */
  private void clearCount() {

    count_ = 0;
  }

  public static trisocket.Order parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static trisocket.Order parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static trisocket.Order parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static trisocket.Order parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static trisocket.Order parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static trisocket.Order parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static trisocket.Order parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static trisocket.Order parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static trisocket.Order parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }

  public static trisocket.Order parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static trisocket.Order parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static trisocket.Order parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return (Builder) DEFAULT_INSTANCE.createBuilder();
  }
  public static Builder newBuilder(trisocket.Order prototype) {
    return DEFAULT_INSTANCE.createBuilder(prototype);
  }

  /**
   * Protobuf type {@code trisocket.Order}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        trisocket.Order, Builder> implements
      // @@protoc_insertion_point(builder_implements:trisocket.Order)
      trisocket.OrderOrBuilder {
    // Construct using trisocket.Order.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <code>int32 count = 1;</code>
     * @return The count.
     */
    @java.lang.Override
    public int getCount() {
      return instance.getCount();
    }
    /**
     * <code>int32 count = 1;</code>
     * @param value The count to set.
     * @return This builder for chaining.
     */
    public Builder setCount(int value) {
      copyOnWrite();
      instance.setCount(value);
      return this;
    }
    /**
     * <code>int32 count = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearCount() {
      copyOnWrite();
      instance.clearCount();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:trisocket.Order)
  }
  @java.lang.Override
  @java.lang.SuppressWarnings({"unchecked", "fallthrough"})
  protected final java.lang.Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      java.lang.Object arg0, java.lang.Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new trisocket.Order();
      }
      case NEW_BUILDER: {
        return new Builder();
      }
      case BUILD_MESSAGE_INFO: {
          java.lang.Object[] objects = new java.lang.Object[] {
            "count_",
          };
          java.lang.String info =
              "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004";
          return newMessageInfo(DEFAULT_INSTANCE, info, objects);
      }
      // fall through
      case GET_DEFAULT_INSTANCE: {
        return DEFAULT_INSTANCE;
      }
      case GET_PARSER: {
        com.google.protobuf.Parser<trisocket.Order> parser = PARSER;
        if (parser == null) {
          synchronized (trisocket.Order.class) {
            parser = PARSER;
            if (parser == null) {
              parser =
                  new DefaultInstanceBasedParser<trisocket.Order>(
                      DEFAULT_INSTANCE);
              PARSER = parser;
            }
          }
        }
        return parser;
    }
    case GET_MEMOIZED_IS_INITIALIZED: {
      return (byte) 1;
    }
    case SET_MEMOIZED_IS_INITIALIZED: {
      return null;
    }
    }
    throw new UnsupportedOperationException();
  }


  // @@protoc_insertion_point(class_scope:trisocket.Order)
  private static final trisocket.Order DEFAULT_INSTANCE;
  static {
    Order defaultInstance = new Order();
    // New instances are implicitly immutable so no need to make
    // immutable.
    DEFAULT_INSTANCE = defaultInstance;
    com.google.protobuf.GeneratedMessageLite.registerDefaultInstance(
      Order.class, defaultInstance);
  }

  public static trisocket.Order getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<Order> PARSER;

  public static com.google.protobuf.Parser<Order> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

