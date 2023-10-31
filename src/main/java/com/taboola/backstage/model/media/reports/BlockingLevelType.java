package com.taboola.backstage.model.media.reports;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

/**
 * Created by vladi
 * Date: 12/7/2017
 * Time: 10:15 PM
 * By Taboola
 */
public enum BlockingLevelType {
    NONE,
    CAMPAIGN,
    ADVERTISER,
    AUTO,
    EMULATED,
    NETWORK,
    ADVERTISER_NETWORK,
    @JsonEnumDefaultValue UNSUPPORTED_BY_SDK_VALUE
}
