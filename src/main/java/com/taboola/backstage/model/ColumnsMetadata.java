package com.taboola.backstage.model;

import java.util.Objects;

import com.taboola.backstage.model.dynamic.DynamicFieldsMetadata;

/**
 * Created by vladi.m
 * Date 05/10/2018
 * Time 13:37
 * Copyright Taboola
 */
public class ColumnsMetadata {

    private DynamicFieldsMetadata dynamicFields;

    public DynamicFieldsMetadata getDynamicFields() {
        return dynamicFields;
    }

    public ColumnsMetadata setDynamicFields(DynamicFieldsMetadata dynamicFields) {
        this.dynamicFields = dynamicFields;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColumnsMetadata that = (ColumnsMetadata) o;
        return Objects.equals(dynamicFields, that.dynamicFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dynamicFields);
    }

    @Override
    public String toString() {
        return "ColumnsMetadata{" +
                "dynamicFields=" + dynamicFields +
                '}';
    }
}
