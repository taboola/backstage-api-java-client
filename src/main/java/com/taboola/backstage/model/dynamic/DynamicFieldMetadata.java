package com.taboola.backstage.model.dynamic;

import java.util.Objects;

/**
 * Created by vladi.m
 * Date 05/10/2018
 * Time 13:40
 * Copyright Taboola
 */
public class DynamicFieldMetadata {

    private String id;
    private String format;
    private DynamicFieldDataType dataType;
    private String caption;

    public String getId() {
        return id;
    }

    public DynamicFieldMetadata setId(String id) {
        this.id = id;
        return this;
    }

    public String getFormat() {
        return format;
    }

    public DynamicFieldMetadata setFormat(String format) {
        this.format = format;
        return this;
    }

    public DynamicFieldDataType getDataType() {
        return dataType;
    }

    public DynamicFieldMetadata setDataType(DynamicFieldDataType dataType) {
        this.dataType = dataType;
        return this;
    }

    public String getCaption() {
        return caption;
    }

    public DynamicFieldMetadata setCaption(String caption) {
        this.caption = caption;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DynamicFieldMetadata that = (DynamicFieldMetadata) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(format, that.format) &&
                dataType == that.dataType &&
                Objects.equals(caption, that.caption);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, format, dataType, caption);
    }

    @Override
    public String toString() {
        return "DynamicFieldMetadata{" +
                "id='" + id + '\'' +
                ", format='" + format + '\'' +
                ", dataType=" + dataType +
                ", caption='" + caption + '\'' +
                '}';
    }
}
