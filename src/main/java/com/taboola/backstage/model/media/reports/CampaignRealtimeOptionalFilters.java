/*
 * Copyright 2023 InPowered. All Rights Reserved.
 *
 * This software is the proprietary information of InPowered.
 * Use is subject to license terms.
 */
package com.taboola.backstage.model.media.reports;

import com.taboola.backstage.model.ReportFilter;

/**
 * @author Gabriel Diaz, 21/12/23.
 */
public enum CampaignRealtimeOptionalFilters implements ReportFilter {

    CAMPAIGN_ID("campaign"),
    PLATFORM("platform"),
    COUNTRY("country"),
    SITE("site_id"),
    INCLUDE_MULTI_CONVERSIONS("include_multi_conversions"),
    FETCH_CONFIG("fetch_config")
    ;

    private final String name;

    CampaignRealtimeOptionalFilters(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
