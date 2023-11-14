package com.taboola.backstage.model.media.campaigns;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

/**
 * Created by vladi.m
 * Date 13/11/2023
 * Time 9:39
 * Copyright Taboola
 */
public enum UnipRuleStatus {
    ACTIVE,
    NO_RECENT_ACTIVITY,
    NO_ACTIVITY_YET,
    READY,
    PROCESSING,
    DISABLED,
    ARCHIVED,
    ERROR,
    GAINING_SCALE,
    ERROR_SEED_SIZE_TOO_SMALL,
    @JsonEnumDefaultValue UNSUPPORTED_BY_SDK_VALUE
}
