package com.taboola.backstage.model.media.reports;

import com.taboola.backstage.model.ReportFilter;

/**
 * Created by vladi
 * Date: 12/7/2017
 * Time: 10:41 PM
 * By Taboola
 */
public enum CampaignSummaryOptionalFilters implements ReportFilter {

    CAMPAIGN_ID("campaign"),
    PLATFORM("platform"),
    COUNTRY("country"),
    SITE("site"),
    INCLUDE_MULTI_CONVERSIONS("include_multi_conversions");

    private final String name;

    CampaignSummaryOptionalFilters(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
