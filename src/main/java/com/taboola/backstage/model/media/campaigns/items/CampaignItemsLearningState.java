package com.taboola.backstage.model.media.campaigns.items;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

/**
 * Created by vladi.m
 * Date 12/11/2023
 * Time 23:04
 * Copyright Taboola
 */
public enum CampaignItemsLearningState {
    EMPTY_DISPLAY,
    EXPEDITED_LEARNING,
    LEARNING,
    LEARNING_COMPLETE,
    LEARNING_LIMITED,
    @JsonEnumDefaultValue UNSUPPORTED_BY_SDK_VALUE
}
