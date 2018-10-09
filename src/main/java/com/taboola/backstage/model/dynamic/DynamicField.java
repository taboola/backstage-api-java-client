package com.taboola.backstage.model.dynamic;

import java.util.Objects;

/**
 * Created by vladi.m
 * Date 05/10/2018
 * Time 13:33
 * Copyright Taboola
 */
public class DynamicField {

    private String id;
    private String value;
    private DynamicFieldMetadata dynamicFieldMetadata;

    public String getId() {
        return id;
    }

    public DynamicField setId(String id) {
        this.id = id;
        return this;
    }

    public String getValue() {
        return value;
    }

    public DynamicField setValue(String value) {
        this.value = value;
        return this;
    }

    public DynamicFieldMetadata getDynamicFieldMetadata() {
        return dynamicFieldMetadata;
    }

    public DynamicField setDynamicFieldMetadata(DynamicFieldMetadata dynamicFieldMetadata) {
        this.dynamicFieldMetadata = dynamicFieldMetadata;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DynamicField that = (DynamicField) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(value, that.value) &&
                Objects.equals(dynamicFieldMetadata, that.dynamicFieldMetadata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value, dynamicFieldMetadata);
    }

    @Override
    public String toString() {
        return "DynamicField{" +
                "id='" + id + '\'' +
                ", value='" + value + '\'' +
                ", dynamicFieldMetadata=" + dynamicFieldMetadata +
                '}';
    }
}
