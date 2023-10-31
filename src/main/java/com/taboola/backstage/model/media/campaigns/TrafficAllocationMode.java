package com.taboola.backstage.model.media.campaigns;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

/**
 * Created by vladi
 * Date: 3/4/2018
 * Time: 11:23 PM
 * By Taboola
 */
public enum TrafficAllocationMode {
    OPTIMIZED,
    EVEN,
    @JsonEnumDefaultValue UNSUPPORTED_BY_SDK_VALUE
}
