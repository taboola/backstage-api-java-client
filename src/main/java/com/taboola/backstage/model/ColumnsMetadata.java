package com.taboola.backstage.model;

import java.util.Objects;

import com.taboola.backstage.model.dynamic.DynamicFieldsMetadata;
import com.taboola.backstage.model.dynamic.StaticFieldsMetadata;

/**
 * Created by vladi.m
 * Date 05/10/2018
 * Time 13:37
 * Copyright Taboola
 */
public class ColumnsMetadata {

    private DynamicFieldsMetadata dynamicFields;
    private StaticFieldsMetadata staticFields;

    public DynamicFieldsMetadata getDynamicFields() {
        return dynamicFields;
    }

    public ColumnsMetadata setDynamicFields(DynamicFieldsMetadata dynamicFields) {
        this.dynamicFields = dynamicFields;
        return this;
    }

    public StaticFieldsMetadata getStaticFields() {
        return staticFields;
    }

    public ColumnsMetadata setStaticFields(StaticFieldsMetadata staticFields) {
        this.staticFields = staticFields;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColumnsMetadata that = (ColumnsMetadata) o;
        return Objects.equals(dynamicFields, that.dynamicFields) &&
                Objects.equals(staticFields, that.staticFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dynamicFields, staticFields);
    }

    @Override
    public String toString() {
        return "ColumnsMetadata{" +
                "dynamicFields=" + dynamicFields +
                ", staticFields=" + staticFields +
                '}';
    }
}
