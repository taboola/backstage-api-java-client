package com.taboola.backstage.model.media.reports;

/**
 * Created by vladi
 * Date: 12/7/2017
 * Time: 10:24 PM
 * By Taboola
 */
public enum CampaignSummaryDimensions {

    DAY("day"),
    BY_HOUR_OF_DAY("by_hour_of_day"),
    WEEK("week"),
    MONTH("month"),
    CONTENT_PROVIDER_BREAKDOWN("content_provider_breakdown"),
    CAMPAIGN_BREAKDOWN("campaign_breakdown"),
    SITE_BREAKDOWN("site_breakdown"),
    COUNTRY_BREAKDOWN("country_breakdown"),
    REGION_BREAKDOWN("region_breakdown"),
    DMA_BREAKDOWN("dma_breakdown"),
    PLATFORM_BREAKDOWN("platform_breakdown"),
    OS_FAMILY_BREAKDOWN("os_family_breakdown"),
    OS_VERSION_BREAKDOWN("os_version_breakdown"),
    BROWSER_BREAKDOWN("browser_breakdown"),
    CAMPAIGN_DAY_BREAKDOWN("campaign_day_breakdown"),
    CAMPAIGN_SITE_DATE_BREAKDOWN("campaign_site_day_breakdown"),
    USER_SEGMENT_BREAKDOWNM("user_segment_breakdown");


    private final String name;

    CampaignSummaryDimensions(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
