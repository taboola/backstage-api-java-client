package com.taboola.backstage.model.media.campaigns.targeting;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

/**
 * Created by vladi.m
 * Date 16/04/2020
 * Time 12:33
 * Copyright Taboola
 */
public enum MultiTargetingState {
    ALL,
    EXISTS,
    UNSUPPORTED,
    @JsonEnumDefaultValue UNSUPPORTED_BY_SDK_VALUE
}
