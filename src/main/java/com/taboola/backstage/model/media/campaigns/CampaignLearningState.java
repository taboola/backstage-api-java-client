package com.taboola.backstage.model.media.campaigns;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

/**
 * Created by vladi.m
 * Date 12/11/2023
 * Time 23:02
 * Copyright Taboola
 */
public enum CampaignLearningState {
    EXPEDITED_LEARNING,
    EMPTY_DISPLAY,
    LEARNING,
    LEARNING_LIMITED,
    @JsonEnumDefaultValue UNSUPPORTED_BY_SDK_VALUE
}
