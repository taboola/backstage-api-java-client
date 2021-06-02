package com.taboola.backstage.model.media.campaigns.brandsafety;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

/**
 * Created by vladi.m
 * Date 16/04/2020
 * Time 13
 * Copyright Taboola
 */
public enum ExternalBrandSafetyProviderType {
    NONE,
    IAS,
    @JsonEnumDefaultValue UNSUPPORTED_BY_SDK_VALUE
}
