package com.taboola.backstage.model.media.reports;

import com.taboola.backstage.model.ReportFilter;

/**
 * Created by vladi
 * Date: 10/20/2017
 * Time: 10:40 PM
 * By Taboola
 */
public enum TopCampaignContentOptionalFilters implements ReportFilter {

    CAMPAIGN_ID("campaign"),
    INCLUDE_MULTI_CONVERSIONS("include_multi_conversions");

    private final String name;

    TopCampaignContentOptionalFilters(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
