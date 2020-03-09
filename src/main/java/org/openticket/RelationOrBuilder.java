// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: OpenTicket.proto

package org.openticket;

public interface RelationOrBuilder extends
    // @@protoc_insertion_point(interface_extends:OpenTicket.Relation)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * start stop ID
   * </pre>
   *
   * <code>uint32 startStopId = 1;</code>
   */
  int getStartStopId();

  /**
   * <pre>
   * destination stop ID
   * </pre>
   *
   * <code>uint32 destinationStopId = 2;</code>
   */
  int getDestinationStopId();

  /**
   * <pre>
   * reference to one or more fare areas in which the legitimation is valid
   * </pre>
   *
   * <code>repeated uint32 containingAreaIds = 3;</code>
   */
  java.util.List<java.lang.Integer> getContainingAreaIdsList();
  /**
   * <pre>
   * reference to one or more fare areas in which the legitimation is valid
   * </pre>
   *
   * <code>repeated uint32 containingAreaIds = 3;</code>
   */
  int getContainingAreaIdsCount();
  /**
   * <pre>
   * reference to one or more fare areas in which the legitimation is valid
   * </pre>
   *
   * <code>repeated uint32 containingAreaIds = 3;</code>
   */
  int getContainingAreaIds(int index);
}