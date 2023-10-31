package com.taboola.backstage.model;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

/**
 * Created by vladi.m
 * Date 2019-07-25
 * Time 16
 * Copyright Taboola
 */
public enum PatchOperation {
    ADD,
    REMOVE,
    REPLACE,
    @JsonEnumDefaultValue UNSUPPORTED_BY_SDK_VALUE
}
