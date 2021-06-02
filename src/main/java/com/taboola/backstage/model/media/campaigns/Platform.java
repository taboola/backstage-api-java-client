package com.taboola.backstage.model.media.campaigns;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

/**
 * Created by vladi
 * Date: 12/23/2017
 * Time: 10:37 PM
 * By Taboola
 */
public enum Platform {
    DESK,
    PHON,
    TBLT,
    @JsonEnumDefaultValue UNSUPPORTED_BY_SDK_VALUE
}
