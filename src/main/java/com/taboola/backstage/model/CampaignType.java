package com.taboola.backstage.model;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

/**
 * Created by vladi.m
 * Date 2019-04-18
 * Time 15
 * Copyright Taboola
 */
public enum CampaignType {
    PAID,
    NATIVE,
    EXCHANGE,
    RTB_OPEN_EXCHANGE,
    PMP_DEAL,
    @JsonEnumDefaultValue UNSUPPORTED_BY_SDK_VALUE
}
