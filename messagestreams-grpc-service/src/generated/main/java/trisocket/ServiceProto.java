// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service.proto

// Protobuf Java Version: 3.25.3
package trisocket;

public final class ServiceProto {
  private ServiceProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_trisocket_Veggie_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_trisocket_Veggie_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_trisocket_Meat_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_trisocket_Meat_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_trisocket_Recipe_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_trisocket_Recipe_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_trisocket_Pan_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_trisocket_Pan_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_trisocket_Dish_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_trisocket_Dish_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_trisocket_Order_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_trisocket_Order_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rservice.proto\022\ttrisocket\"$\n\006Veggie\022\014\n\004" +
      "name\030\001 \001(\t\022\014\n\004size\030\002 \001(\002\"\'\n\004Meat\022\014\n\004name" +
      "\030\001 \001(\t\022\021\n\tstiffness\030\002 \001(\002\";\n\006Recipe\022\014\n\004n" +
      "ame\030\001 \001(\t\022\021\n\tstiffness\030\002 \001(\002\022\020\n\010duration" +
      "\030\003 \001(\005\"G\n\003Pan\022!\n\006veggie\030\001 \001(\0132\021.trisocke" +
      "t.Veggie\022\035\n\004meat\030\002 \001(\0132\017.trisocket.Meat\"" +
      "Z\n\004Dish\022!\n\006veggie\030\001 \001(\0132\021.trisocket.Vegg" +
      "ie\022\035\n\004meat\030\002 \001(\0132\017.trisocket.Meat\022\020\n\010don" +
      "eness\030\003 \001(\t\"\026\n\005Order\022\r\n\005count\030\001 \001(\00522\n\004C" +
      "hef\022*\n\005roast\022\016.trisocket.Pan\032\017.trisocket" +
      ".Dish\"\0002;\n\007Recipes\0220\n\010marinade\022\017.trisock" +
      "et.Meat\032\021.trisocket.Recipe\"\0002k\n\tRoundsma" +
      "n\022.\n\004chop\022\021.trisocket.Veggie\032\021.trisocket" +
      ".Veggie\"\000\022.\n\010marinade\022\017.trisocket.Meat\032\017" +
      ".trisocket.Meat\"\0002k\n\006Farmer\022-\n\004meat\022\020.tr" +
      "isocket.Order\032\017.trisocket.Meat\"\0000\001\0222\n\007ve" +
      "ggies\022\020.trisocket.Order\032\021.trisocket.Vegg" +
      "ie\"\0000\0012;\n\007Kitchen\0220\n\005serve\022\020.trisocket.O" +
      "rder\032\017.trisocket.Dish\"\000(\0010\001B\033\n\ttrisocket" +
      "B\014ServiceProtoP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_trisocket_Veggie_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_trisocket_Veggie_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_trisocket_Veggie_descriptor,
        new java.lang.String[] { "Name", "Size", });
    internal_static_trisocket_Meat_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_trisocket_Meat_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_trisocket_Meat_descriptor,
        new java.lang.String[] { "Name", "Stiffness", });
    internal_static_trisocket_Recipe_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_trisocket_Recipe_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_trisocket_Recipe_descriptor,
        new java.lang.String[] { "Name", "Stiffness", "Duration", });
    internal_static_trisocket_Pan_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_trisocket_Pan_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_trisocket_Pan_descriptor,
        new java.lang.String[] { "Veggie", "Meat", });
    internal_static_trisocket_Dish_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_trisocket_Dish_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_trisocket_Dish_descriptor,
        new java.lang.String[] { "Veggie", "Meat", "Doneness", });
    internal_static_trisocket_Order_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_trisocket_Order_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_trisocket_Order_descriptor,
        new java.lang.String[] { "Count", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
