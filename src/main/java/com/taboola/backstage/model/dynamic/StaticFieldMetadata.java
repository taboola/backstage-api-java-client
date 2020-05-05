package com.taboola.backstage.model.dynamic;

import java.util.Objects;

/**
 * Created by vladi.m
 * Date 04/05/2020
 * Time 14:26
 * Copyright Taboola
 */
public class StaticFieldMetadata {

    private String id;
    private String format;
    private DynamicFieldDataType dataType;

    public String getId() {
        return id;
    }

    public StaticFieldMetadata setId(String id) {
        this.id = id;
        return this;
    }

    public String getFormat() {
        return format;
    }

    public StaticFieldMetadata setFormat(String format) {
        this.format = format;
        return this;
    }

    public DynamicFieldDataType getDataType() {
        return dataType;
    }

    public StaticFieldMetadata setDataType(DynamicFieldDataType dataType) {
        this.dataType = dataType;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaticFieldMetadata that = (StaticFieldMetadata) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(format, that.format) &&
                dataType == that.dataType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, format, dataType);
    }

    @Override
    public String toString() {
        return "StaticFieldMetadata{" +
                "id='" + id + '\'' +
                ", format='" + format + '\'' +
                ", dataType=" + dataType +
                '}';
    }
}
