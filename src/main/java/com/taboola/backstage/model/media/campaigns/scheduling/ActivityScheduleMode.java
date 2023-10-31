package com.taboola.backstage.model.media.campaigns.scheduling;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

/**
 * Created by vladi.m
 * Date 03/10/2018
 * Time 16:13
 * Copyright Taboola
 */
public enum ActivityScheduleMode {
    ALWAYS,
    CUSTOM,
    @JsonEnumDefaultValue UNSUPPORTED_BY_SDK_VALUE
}
