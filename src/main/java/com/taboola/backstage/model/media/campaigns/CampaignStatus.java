package com.taboola.backstage.model.media.campaigns;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

/**
 * Created by vladi
 * Date: 12/23/2017
 * Time: 10:33 PM
 * By Taboola
 */
public enum CampaignStatus {
    RUNNING,
    PAUSED,
    PENDING_START_DATE,
    DEPLETED_MONTHLY,
    DEPLETED,
    EXPIRED,
    TERMINATED,
    FROZEN,
    PENDING_APPROVAL,
    REJECTED,
    @JsonEnumDefaultValue UNSUPPORTED_BY_SDK_VALUE
}
