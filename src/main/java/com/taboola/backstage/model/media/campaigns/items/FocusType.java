package com.taboola.backstage.model.media.campaigns.items;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

/**
 * Created by vladi.m
 * Date 11/11/2020
 * Time 9:54
 * Copyright Taboola
 */
public enum FocusType {
    AUTOMATIC,
    COORDINATES,
    @JsonEnumDefaultValue UNSUPPORTED_BY_SDK_VALUE
}
