package com.taboola.backstage.model.media.campaigns.items;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

/**
 * Created by vladi.m
 * Date 13/11/2023
 * Time 21:14
 * Copyright Taboola
 */
public enum MediaUploadSource {
    WOCHIT,
    URL,
    URL_TA,
    URL_OFFSTAGE,
    FILE,
    MEDIA_LIBRARY,
    RECOMMENDED_MEDIA,
    URL_BULK_UPLOAD,
    @JsonEnumDefaultValue UNSUPPORTED_BY_SDK_VALUE
}
