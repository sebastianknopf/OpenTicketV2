// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: OpenTicket.proto

package org.openticket;

/**
 * <pre>
 **
 * The StopList message defines a start stop ID and all destination stop IDs
 * which can be reached by using this stop list.
 * </pre>
 *
 * Protobuf type {@code OpenTicket.StopList}
 */
public  final class StopList extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:OpenTicket.StopList)
    StopListOrBuilder {
private static final long serialVersionUID = 0L;
  // Use StopList.newBuilder() to construct.
  private StopList(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private StopList() {
    startStopId_ = 0;
    containingStopIds_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private StopList(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {

            startStopId_ = input.readUInt32();
            break;
          }
          case 16: {
            if (!((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
              containingStopIds_ = new java.util.ArrayList<java.lang.Integer>();
              mutable_bitField0_ |= 0x00000002;
            }
            containingStopIds_.add(input.readUInt32());
            break;
          }
          case 18: {
            int length = input.readRawVarint32();
            int limit = input.pushLimit(length);
            if (!((mutable_bitField0_ & 0x00000002) == 0x00000002) && input.getBytesUntilLimit() > 0) {
              containingStopIds_ = new java.util.ArrayList<java.lang.Integer>();
              mutable_bitField0_ |= 0x00000002;
            }
            while (input.getBytesUntilLimit() > 0) {
              containingStopIds_.add(input.readUInt32());
            }
            input.popLimit(limit);
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
        containingStopIds_ = java.util.Collections.unmodifiableList(containingStopIds_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return OpenTicket.internal_static_OpenTicket_StopList_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return OpenTicket.internal_static_OpenTicket_StopList_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            StopList.class, StopList.Builder.class);
  }

  private int bitField0_;
  public static final int STARTSTOPID_FIELD_NUMBER = 1;
  private int startStopId_;
  /**
   * <pre>
   * start stop ID
   * </pre>
   *
   * <code>uint32 startStopId = 1;</code>
   */
  public int getStartStopId() {
    return startStopId_;
  }

  public static final int CONTAININGSTOPIDS_FIELD_NUMBER = 2;
  private java.util.List<java.lang.Integer> containingStopIds_;
  /**
   * <pre>
   * all stop IDs which can be reached by the legitimation
   * </pre>
   *
   * <code>repeated uint32 containingStopIds = 2;</code>
   */
  public java.util.List<java.lang.Integer>
      getContainingStopIdsList() {
    return containingStopIds_;
  }
  /**
   * <pre>
   * all stop IDs which can be reached by the legitimation
   * </pre>
   *
   * <code>repeated uint32 containingStopIds = 2;</code>
   */
  public int getContainingStopIdsCount() {
    return containingStopIds_.size();
  }
  /**
   * <pre>
   * all stop IDs which can be reached by the legitimation
   * </pre>
   *
   * <code>repeated uint32 containingStopIds = 2;</code>
   */
  public int getContainingStopIds(int index) {
    return containingStopIds_.get(index);
  }
  private int containingStopIdsMemoizedSerializedSize = -1;

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
    getSerializedSize();
    if (startStopId_ != 0) {
      output.writeUInt32(1, startStopId_);
    }
    if (getContainingStopIdsList().size() > 0) {
      output.writeUInt32NoTag(18);
      output.writeUInt32NoTag(containingStopIdsMemoizedSerializedSize);
    }
    for (int i = 0; i < containingStopIds_.size(); i++) {
      output.writeUInt32NoTag(containingStopIds_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (startStopId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(1, startStopId_);
    }
    {
      int dataSize = 0;
      for (int i = 0; i < containingStopIds_.size(); i++) {
        dataSize += com.google.protobuf.CodedOutputStream
          .computeUInt32SizeNoTag(containingStopIds_.get(i));
      }
      size += dataSize;
      if (!getContainingStopIdsList().isEmpty()) {
        size += 1;
        size += com.google.protobuf.CodedOutputStream
            .computeInt32SizeNoTag(dataSize);
      }
      containingStopIdsMemoizedSerializedSize = dataSize;
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof StopList)) {
      return super.equals(obj);
    }
    StopList other = (StopList) obj;

    boolean result = true;
    result = result && (getStartStopId()
        == other.getStartStopId());
    result = result && getContainingStopIdsList()
        .equals(other.getContainingStopIdsList());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + STARTSTOPID_FIELD_NUMBER;
    hash = (53 * hash) + getStartStopId();
    if (getContainingStopIdsCount() > 0) {
      hash = (37 * hash) + CONTAININGSTOPIDS_FIELD_NUMBER;
      hash = (53 * hash) + getContainingStopIdsList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static StopList parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static StopList parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static StopList parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static StopList parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static StopList parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static StopList parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static StopList parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static StopList parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static StopList parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static StopList parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static StopList parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static StopList parseFrom(
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
  public static Builder newBuilder(StopList prototype) {
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
   * <pre>
   **
   * The StopList message defines a start stop ID and all destination stop IDs
   * which can be reached by using this stop list.
   * </pre>
   *
   * Protobuf type {@code OpenTicket.StopList}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:OpenTicket.StopList)
          StopListOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return OpenTicket.internal_static_OpenTicket_StopList_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return OpenTicket.internal_static_OpenTicket_StopList_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              StopList.class, StopList.Builder.class);
    }

    // Construct using de.openticket.StopList.newBuilder()
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
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      startStopId_ = 0;

      containingStopIds_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return OpenTicket.internal_static_OpenTicket_StopList_descriptor;
    }

    @java.lang.Override
    public StopList getDefaultInstanceForType() {
      return StopList.getDefaultInstance();
    }

    @java.lang.Override
    public StopList build() {
      StopList result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public StopList buildPartial() {
      StopList result = new StopList(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      result.startStopId_ = startStopId_;
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        containingStopIds_ = java.util.Collections.unmodifiableList(containingStopIds_);
        bitField0_ = (bitField0_ & ~0x00000002);
      }
      result.containingStopIds_ = containingStopIds_;
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof StopList) {
        return mergeFrom((StopList)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(StopList other) {
      if (other == StopList.getDefaultInstance()) return this;
      if (other.getStartStopId() != 0) {
        setStartStopId(other.getStartStopId());
      }
      if (!other.containingStopIds_.isEmpty()) {
        if (containingStopIds_.isEmpty()) {
          containingStopIds_ = other.containingStopIds_;
          bitField0_ = (bitField0_ & ~0x00000002);
        } else {
          ensureContainingStopIdsIsMutable();
          containingStopIds_.addAll(other.containingStopIds_);
        }
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
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
      StopList parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (StopList) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private int startStopId_ ;
    /**
     * <pre>
     * start stop ID
     * </pre>
     *
     * <code>uint32 startStopId = 1;</code>
     */
    public int getStartStopId() {
      return startStopId_;
    }
    /**
     * <pre>
     * start stop ID
     * </pre>
     *
     * <code>uint32 startStopId = 1;</code>
     */
    public Builder setStartStopId(int value) {
      
      startStopId_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * start stop ID
     * </pre>
     *
     * <code>uint32 startStopId = 1;</code>
     */
    public Builder clearStartStopId() {
      
      startStopId_ = 0;
      onChanged();
      return this;
    }

    private java.util.List<java.lang.Integer> containingStopIds_ = java.util.Collections.emptyList();
    private void ensureContainingStopIdsIsMutable() {
      if (!((bitField0_ & 0x00000002) == 0x00000002)) {
        containingStopIds_ = new java.util.ArrayList<java.lang.Integer>(containingStopIds_);
        bitField0_ |= 0x00000002;
       }
    }
    /**
     * <pre>
     * all stop IDs which can be reached by the legitimation
     * </pre>
     *
     * <code>repeated uint32 containingStopIds = 2;</code>
     */
    public java.util.List<java.lang.Integer>
        getContainingStopIdsList() {
      return java.util.Collections.unmodifiableList(containingStopIds_);
    }
    /**
     * <pre>
     * all stop IDs which can be reached by the legitimation
     * </pre>
     *
     * <code>repeated uint32 containingStopIds = 2;</code>
     */
    public int getContainingStopIdsCount() {
      return containingStopIds_.size();
    }
    /**
     * <pre>
     * all stop IDs which can be reached by the legitimation
     * </pre>
     *
     * <code>repeated uint32 containingStopIds = 2;</code>
     */
    public int getContainingStopIds(int index) {
      return containingStopIds_.get(index);
    }
    /**
     * <pre>
     * all stop IDs which can be reached by the legitimation
     * </pre>
     *
     * <code>repeated uint32 containingStopIds = 2;</code>
     */
    public Builder setContainingStopIds(
        int index, int value) {
      ensureContainingStopIdsIsMutable();
      containingStopIds_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * all stop IDs which can be reached by the legitimation
     * </pre>
     *
     * <code>repeated uint32 containingStopIds = 2;</code>
     */
    public Builder addContainingStopIds(int value) {
      ensureContainingStopIdsIsMutable();
      containingStopIds_.add(value);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * all stop IDs which can be reached by the legitimation
     * </pre>
     *
     * <code>repeated uint32 containingStopIds = 2;</code>
     */
    public Builder addAllContainingStopIds(
        java.lang.Iterable<? extends java.lang.Integer> values) {
      ensureContainingStopIdsIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, containingStopIds_);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * all stop IDs which can be reached by the legitimation
     * </pre>
     *
     * <code>repeated uint32 containingStopIds = 2;</code>
     */
    public Builder clearContainingStopIds() {
      containingStopIds_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:OpenTicket.StopList)
  }

  // @@protoc_insertion_point(class_scope:OpenTicket.StopList)
  private static final StopList DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new StopList();
  }

  public static StopList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<StopList>
      PARSER = new com.google.protobuf.AbstractParser<StopList>() {
    @java.lang.Override
    public StopList parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new StopList(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<StopList> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<StopList> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public StopList getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

