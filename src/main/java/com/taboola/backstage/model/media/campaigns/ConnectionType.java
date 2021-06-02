package com.taboola.backstage.model.media.campaigns;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

/**
 * Created by vladi.m
 * Date 2019-08-15
 * Time 16
 * Copyright Taboola
 */
public enum ConnectionType {
    WIFI,
    @JsonEnumDefaultValue UNSUPPORTED_BY_SDK_VALUE
}
