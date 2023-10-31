package com.taboola.backstage.model.media.campaigns.items;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

/**
 * Created by vladi
 * Date: 12/23/2017
 * Time: 10:30 PM
 * By Taboola
 */
public enum ItemApprovalState {
    APPROVED,
    REJECTED,
    PENDING,
    @JsonEnumDefaultValue UNSUPPORTED_BY_SDK_VALUE
}
