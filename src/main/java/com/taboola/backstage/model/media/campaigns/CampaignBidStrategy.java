package com.taboola.backstage.model.media.campaigns;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

/**
 * Created by vladi.m
 * Date 16/04/2020
 * Time 13
 * Copyright Taboola
 */
public enum CampaignBidStrategy {
    SMART,
    FIXED,
    TARGET_CPA,
    MAX_CONVERSIONS,
    @JsonEnumDefaultValue UNSUPPORTED_BY_SDK_VALUE
}
