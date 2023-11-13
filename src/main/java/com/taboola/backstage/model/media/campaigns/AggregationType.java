package com.taboola.backstage.model.media.campaigns;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

/**
 * Created by vladi.m
 * Date 13/11/2023
 * Time 9:46
 * Copyright Taboola
 */
public enum AggregationType {
    AGGREGATED,
    LAST_VALUE,
    @JsonEnumDefaultValue UNSUPPORTED_BY_SDK_VALUE
}
