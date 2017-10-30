package com.taboola.backstage.model.media.reports;

/**
 * Created by vladi
 * Date: 10/20/2017
 * Time: 10:40 PM
 * By Taboola
 */
public enum TopCampaignContentOptionalFilters implements ReportFilter {

    CAMPAIGN_ID("campaign");

    private final String name;

    TopCampaignContentOptionalFilters(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
