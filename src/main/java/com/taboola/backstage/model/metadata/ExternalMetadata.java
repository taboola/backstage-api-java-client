package com.taboola.backstage.model.metadata;

import java.util.List;
import java.util.Objects;

/**
 * Created by vladi.m
 * Date 12/11/2023
 * Time 22:51
 * Copyright Taboola
 */
public class ExternalMetadata {
    private List<KeyValue> data;

    public List<KeyValue> getData() {
        return data;
    }

    public void setData(List<KeyValue> data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExternalMetadata that = (ExternalMetadata) o;
        return Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
        return "ExternalMetadata{" +
                "data=" + data +
                '}';
    }
}
