package com.taboola.backstage.model.media.campaigns.verifications;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

/**
 * Created by vladi.m
 * Date 16/04/2020
 * Time 13:06
 * Copyright Taboola
 */
public enum VerificationPixelEventType {
    CLICK,
    VIEWABLE_IMPRESSION,
    IMPRESSION,
    @JsonEnumDefaultValue UNSUPPORTED_BY_SDK_VALUE
}
