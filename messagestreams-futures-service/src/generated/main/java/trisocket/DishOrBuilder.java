// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service.proto

// Protobuf Java Version: 3.25.0
package trisocket;

public interface DishOrBuilder extends
    // @@protoc_insertion_point(interface_extends:trisocket.Dish)
    com.google.protobuf.MessageLiteOrBuilder {

  /**
   * <code>.trisocket.Veggie veggie = 1;</code>
   * @return Whether the veggie field is set.
   */
  boolean hasVeggie();
  /**
   * <code>.trisocket.Veggie veggie = 1;</code>
   * @return The veggie.
   */
  trisocket.Veggie getVeggie();

  /**
   * <code>.trisocket.Meat meat = 2;</code>
   * @return Whether the meat field is set.
   */
  boolean hasMeat();
  /**
   * <code>.trisocket.Meat meat = 2;</code>
   * @return The meat.
   */
  trisocket.Meat getMeat();

  /**
   * <pre>
   *welldone
   * </pre>
   *
   * <code>string doneness = 3;</code>
   * @return The doneness.
   */
  java.lang.String getDoneness();
  /**
   * <pre>
   *welldone
   * </pre>
   *
   * <code>string doneness = 3;</code>
   * @return The bytes for doneness.
   */
  com.google.protobuf.ByteString
      getDonenessBytes();
}
