package com.taboola.backstage.model.publishers.reports;

/**
 * Created by vladi
 * Date: 2/3/2018
 * Time: 11:01 PM
 * By Taboola
 */
public enum VisitValueDimensions {

    DAY("day"),
    WEEK("week"),
    MONTH("month"),
    BY_REFERRAL("by_referral"),
    LANDING_PAGE_BREAKDOWN("landing_page_breakdown"),
    PLATFORM_BREAKDOWN("platform_breakdown"),
    COUNTRY_BREAKDOWN("country_breakdown"),
    PAGE_TYPE_BREAKDOWN("page_type_breakdown"),
    DAY_REFERRAL_LANDING_PAGE_BREAKDOWN("day_referral_landing_page_breakdown"),
    BY_SOURCE_MEDIUM("by_source_medium"),
    BY_CAMPAIGN("by_campaign"),
    BY_CUSTOM_TRACKING_CODE("by_custom_tracking_code"),
    BY_REFERRAL_AND_TRACKING_CODE("by_referral_and_tracking_code");

    private final String name;

    VisitValueDimensions(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
