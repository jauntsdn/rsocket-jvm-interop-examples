// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service.proto

// Protobuf Java Version: 3.25.0
package trisocket;

/**
 * Protobuf type {@code trisocket.Dish}
 */
public final class Dish extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:trisocket.Dish)
    DishOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Dish.newBuilder() to construct.
  private Dish(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Dish() {
    doneness_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Dish();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return trisocket.ServiceProto.internal_static_trisocket_Dish_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return trisocket.ServiceProto.internal_static_trisocket_Dish_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            trisocket.Dish.class, trisocket.Dish.Builder.class);
  }

  private int bitField0_;
  public static final int VEGGIE_FIELD_NUMBER = 1;
  private trisocket.Veggie veggie_;
  /**
   * <code>.trisocket.Veggie veggie = 1;</code>
   * @return Whether the veggie field is set.
   */
  @java.lang.Override
  public boolean hasVeggie() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>.trisocket.Veggie veggie = 1;</code>
   * @return The veggie.
   */
  @java.lang.Override
  public trisocket.Veggie getVeggie() {
    return veggie_ == null ? trisocket.Veggie.getDefaultInstance() : veggie_;
  }
  /**
   * <code>.trisocket.Veggie veggie = 1;</code>
   */
  @java.lang.Override
  public trisocket.VeggieOrBuilder getVeggieOrBuilder() {
    return veggie_ == null ? trisocket.Veggie.getDefaultInstance() : veggie_;
  }

  public static final int MEAT_FIELD_NUMBER = 2;
  private trisocket.Meat meat_;
  /**
   * <code>.trisocket.Meat meat = 2;</code>
   * @return Whether the meat field is set.
   */
  @java.lang.Override
  public boolean hasMeat() {
    return ((bitField0_ & 0x00000002) != 0);
  }
  /**
   * <code>.trisocket.Meat meat = 2;</code>
   * @return The meat.
   */
  @java.lang.Override
  public trisocket.Meat getMeat() {
    return meat_ == null ? trisocket.Meat.getDefaultInstance() : meat_;
  }
  /**
   * <code>.trisocket.Meat meat = 2;</code>
   */
  @java.lang.Override
  public trisocket.MeatOrBuilder getMeatOrBuilder() {
    return meat_ == null ? trisocket.Meat.getDefaultInstance() : meat_;
  }

  public static final int DONENESS_FIELD_NUMBER = 3;
  @SuppressWarnings("serial")
  private volatile java.lang.Object doneness_ = "";
  /**
   * <pre>
   *welldone
   * </pre>
   *
   * <code>string doneness = 3;</code>
   * @return The doneness.
   */
  @java.lang.Override
  public java.lang.String getDoneness() {
    java.lang.Object ref = doneness_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      doneness_ = s;
      return s;
    }
  }
  /**
   * <pre>
   *welldone
   * </pre>
   *
   * <code>string doneness = 3;</code>
   * @return The bytes for doneness.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getDonenessBytes() {
    java.lang.Object ref = doneness_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      doneness_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (((bitField0_ & 0x00000001) != 0)) {
      output.writeMessage(1, getVeggie());
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      output.writeMessage(2, getMeat());
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(doneness_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, doneness_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getVeggie());
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getMeat());
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(doneness_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, doneness_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof trisocket.Dish)) {
      return super.equals(obj);
    }
    trisocket.Dish other = (trisocket.Dish) obj;

    if (hasVeggie() != other.hasVeggie()) return false;
    if (hasVeggie()) {
      if (!getVeggie()
          .equals(other.getVeggie())) return false;
    }
    if (hasMeat() != other.hasMeat()) return false;
    if (hasMeat()) {
      if (!getMeat()
          .equals(other.getMeat())) return false;
    }
    if (!getDoneness()
        .equals(other.getDoneness())) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasVeggie()) {
      hash = (37 * hash) + VEGGIE_FIELD_NUMBER;
      hash = (53 * hash) + getVeggie().hashCode();
    }
    if (hasMeat()) {
      hash = (37 * hash) + MEAT_FIELD_NUMBER;
      hash = (53 * hash) + getMeat().hashCode();
    }
    hash = (37 * hash) + DONENESS_FIELD_NUMBER;
    hash = (53 * hash) + getDoneness().hashCode();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static trisocket.Dish parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static trisocket.Dish parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static trisocket.Dish parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static trisocket.Dish parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static trisocket.Dish parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static trisocket.Dish parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static trisocket.Dish parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static trisocket.Dish parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static trisocket.Dish parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static trisocket.Dish parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static trisocket.Dish parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static trisocket.Dish parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(trisocket.Dish prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code trisocket.Dish}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:trisocket.Dish)
      trisocket.DishOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return trisocket.ServiceProto.internal_static_trisocket_Dish_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return trisocket.ServiceProto.internal_static_trisocket_Dish_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              trisocket.Dish.class, trisocket.Dish.Builder.class);
    }

    // Construct using trisocket.Dish.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getVeggieFieldBuilder();
        getMeatFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      veggie_ = null;
      if (veggieBuilder_ != null) {
        veggieBuilder_.dispose();
        veggieBuilder_ = null;
      }
      meat_ = null;
      if (meatBuilder_ != null) {
        meatBuilder_.dispose();
        meatBuilder_ = null;
      }
      doneness_ = "";
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return trisocket.ServiceProto.internal_static_trisocket_Dish_descriptor;
    }

    @java.lang.Override
    public trisocket.Dish getDefaultInstanceForType() {
      return trisocket.Dish.getDefaultInstance();
    }

    @java.lang.Override
    public trisocket.Dish build() {
      trisocket.Dish result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public trisocket.Dish buildPartial() {
      trisocket.Dish result = new trisocket.Dish(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(trisocket.Dish result) {
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.veggie_ = veggieBuilder_ == null
            ? veggie_
            : veggieBuilder_.build();
        to_bitField0_ |= 0x00000001;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.meat_ = meatBuilder_ == null
            ? meat_
            : meatBuilder_.build();
        to_bitField0_ |= 0x00000002;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.doneness_ = doneness_;
      }
      result.bitField0_ |= to_bitField0_;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof trisocket.Dish) {
        return mergeFrom((trisocket.Dish)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(trisocket.Dish other) {
      if (other == trisocket.Dish.getDefaultInstance()) return this;
      if (other.hasVeggie()) {
        mergeVeggie(other.getVeggie());
      }
      if (other.hasMeat()) {
        mergeMeat(other.getMeat());
      }
      if (!other.getDoneness().isEmpty()) {
        doneness_ = other.doneness_;
        bitField0_ |= 0x00000004;
        onChanged();
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              input.readMessage(
                  getVeggieFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 18: {
              input.readMessage(
                  getMeatFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000002;
              break;
            } // case 18
            case 26: {
              doneness_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000004;
              break;
            } // case 26
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private trisocket.Veggie veggie_;
    private com.google.protobuf.SingleFieldBuilderV3<
        trisocket.Veggie, trisocket.Veggie.Builder, trisocket.VeggieOrBuilder> veggieBuilder_;
    /**
     * <code>.trisocket.Veggie veggie = 1;</code>
     * @return Whether the veggie field is set.
     */
    public boolean hasVeggie() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>.trisocket.Veggie veggie = 1;</code>
     * @return The veggie.
     */
    public trisocket.Veggie getVeggie() {
      if (veggieBuilder_ == null) {
        return veggie_ == null ? trisocket.Veggie.getDefaultInstance() : veggie_;
      } else {
        return veggieBuilder_.getMessage();
      }
    }
    /**
     * <code>.trisocket.Veggie veggie = 1;</code>
     */
    public Builder setVeggie(trisocket.Veggie value) {
      if (veggieBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        veggie_ = value;
      } else {
        veggieBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.trisocket.Veggie veggie = 1;</code>
     */
    public Builder setVeggie(
        trisocket.Veggie.Builder builderForValue) {
      if (veggieBuilder_ == null) {
        veggie_ = builderForValue.build();
      } else {
        veggieBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.trisocket.Veggie veggie = 1;</code>
     */
    public Builder mergeVeggie(trisocket.Veggie value) {
      if (veggieBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0) &&
          veggie_ != null &&
          veggie_ != trisocket.Veggie.getDefaultInstance()) {
          getVeggieBuilder().mergeFrom(value);
        } else {
          veggie_ = value;
        }
      } else {
        veggieBuilder_.mergeFrom(value);
      }
      if (veggie_ != null) {
        bitField0_ |= 0x00000001;
        onChanged();
      }
      return this;
    }
    /**
     * <code>.trisocket.Veggie veggie = 1;</code>
     */
    public Builder clearVeggie() {
      bitField0_ = (bitField0_ & ~0x00000001);
      veggie_ = null;
      if (veggieBuilder_ != null) {
        veggieBuilder_.dispose();
        veggieBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>.trisocket.Veggie veggie = 1;</code>
     */
    public trisocket.Veggie.Builder getVeggieBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getVeggieFieldBuilder().getBuilder();
    }
    /**
     * <code>.trisocket.Veggie veggie = 1;</code>
     */
    public trisocket.VeggieOrBuilder getVeggieOrBuilder() {
      if (veggieBuilder_ != null) {
        return veggieBuilder_.getMessageOrBuilder();
      } else {
        return veggie_ == null ?
            trisocket.Veggie.getDefaultInstance() : veggie_;
      }
    }
    /**
     * <code>.trisocket.Veggie veggie = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        trisocket.Veggie, trisocket.Veggie.Builder, trisocket.VeggieOrBuilder> 
        getVeggieFieldBuilder() {
      if (veggieBuilder_ == null) {
        veggieBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            trisocket.Veggie, trisocket.Veggie.Builder, trisocket.VeggieOrBuilder>(
                getVeggie(),
                getParentForChildren(),
                isClean());
        veggie_ = null;
      }
      return veggieBuilder_;
    }

    private trisocket.Meat meat_;
    private com.google.protobuf.SingleFieldBuilderV3<
        trisocket.Meat, trisocket.Meat.Builder, trisocket.MeatOrBuilder> meatBuilder_;
    /**
     * <code>.trisocket.Meat meat = 2;</code>
     * @return Whether the meat field is set.
     */
    public boolean hasMeat() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>.trisocket.Meat meat = 2;</code>
     * @return The meat.
     */
    public trisocket.Meat getMeat() {
      if (meatBuilder_ == null) {
        return meat_ == null ? trisocket.Meat.getDefaultInstance() : meat_;
      } else {
        return meatBuilder_.getMessage();
      }
    }
    /**
     * <code>.trisocket.Meat meat = 2;</code>
     */
    public Builder setMeat(trisocket.Meat value) {
      if (meatBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        meat_ = value;
      } else {
        meatBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>.trisocket.Meat meat = 2;</code>
     */
    public Builder setMeat(
        trisocket.Meat.Builder builderForValue) {
      if (meatBuilder_ == null) {
        meat_ = builderForValue.build();
      } else {
        meatBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>.trisocket.Meat meat = 2;</code>
     */
    public Builder mergeMeat(trisocket.Meat value) {
      if (meatBuilder_ == null) {
        if (((bitField0_ & 0x00000002) != 0) &&
          meat_ != null &&
          meat_ != trisocket.Meat.getDefaultInstance()) {
          getMeatBuilder().mergeFrom(value);
        } else {
          meat_ = value;
        }
      } else {
        meatBuilder_.mergeFrom(value);
      }
      if (meat_ != null) {
        bitField0_ |= 0x00000002;
        onChanged();
      }
      return this;
    }
    /**
     * <code>.trisocket.Meat meat = 2;</code>
     */
    public Builder clearMeat() {
      bitField0_ = (bitField0_ & ~0x00000002);
      meat_ = null;
      if (meatBuilder_ != null) {
        meatBuilder_.dispose();
        meatBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>.trisocket.Meat meat = 2;</code>
     */
    public trisocket.Meat.Builder getMeatBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getMeatFieldBuilder().getBuilder();
    }
    /**
     * <code>.trisocket.Meat meat = 2;</code>
     */
    public trisocket.MeatOrBuilder getMeatOrBuilder() {
      if (meatBuilder_ != null) {
        return meatBuilder_.getMessageOrBuilder();
      } else {
        return meat_ == null ?
            trisocket.Meat.getDefaultInstance() : meat_;
      }
    }
    /**
     * <code>.trisocket.Meat meat = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        trisocket.Meat, trisocket.Meat.Builder, trisocket.MeatOrBuilder> 
        getMeatFieldBuilder() {
      if (meatBuilder_ == null) {
        meatBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            trisocket.Meat, trisocket.Meat.Builder, trisocket.MeatOrBuilder>(
                getMeat(),
                getParentForChildren(),
                isClean());
        meat_ = null;
      }
      return meatBuilder_;
    }

    private java.lang.Object doneness_ = "";
    /**
     * <pre>
     *welldone
     * </pre>
     *
     * <code>string doneness = 3;</code>
     * @return The doneness.
     */
    public java.lang.String getDoneness() {
      java.lang.Object ref = doneness_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        doneness_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     *welldone
     * </pre>
     *
     * <code>string doneness = 3;</code>
     * @return The bytes for doneness.
     */
    public com.google.protobuf.ByteString
        getDonenessBytes() {
      java.lang.Object ref = doneness_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        doneness_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     *welldone
     * </pre>
     *
     * <code>string doneness = 3;</code>
     * @param value The doneness to set.
     * @return This builder for chaining.
     */
    public Builder setDoneness(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      doneness_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *welldone
     * </pre>
     *
     * <code>string doneness = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearDoneness() {
      doneness_ = getDefaultInstance().getDoneness();
      bitField0_ = (bitField0_ & ~0x00000004);
      onChanged();
      return this;
    }
    /**
     * <pre>
     *welldone
     * </pre>
     *
     * <code>string doneness = 3;</code>
     * @param value The bytes for doneness to set.
     * @return This builder for chaining.
     */
    public Builder setDonenessBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      doneness_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:trisocket.Dish)
  }

  // @@protoc_insertion_point(class_scope:trisocket.Dish)
  private static final trisocket.Dish DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new trisocket.Dish();
  }

  public static trisocket.Dish getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Dish>
      PARSER = new com.google.protobuf.AbstractParser<Dish>() {
    @java.lang.Override
    public Dish parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<Dish> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Dish> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public trisocket.Dish getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

