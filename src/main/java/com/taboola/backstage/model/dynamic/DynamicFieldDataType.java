package com.taboola.backstage.model.dynamic;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

/**
 * Created by vladi.m
 * Date 05/10/2018
 * Time 13:42
 * Copyright Taboola
 */
public enum DynamicFieldDataType {
    STRING,
    FLOAT,
    MONEY,
    PERCENT,
    NUMERIC,
    DATA,
    DATE,
    TIMESTAMP,
    URL,
    BOOLEAN,
    @JsonEnumDefaultValue UNSUPPORTED_BY_SDK_VALUE
}
