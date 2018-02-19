package com.taboola.backstage.model.publishers.reports;


/**
 * Created by vladi
 * Date: 2/3/2018
 * Time: 10:59 PM
 * By Taboola
 */
public enum RevenueSummaryDimensions {

    DAY("day"),
    WEEK("week"),
    MONTH("month"),
    PAGE_TYPE_BREAKDOWN("page_type_breakdown"),
    PLACEMENT_BREAKDOWN("placement_breakdown"),
    SITE_BREAKDOWN("site_breakdown"),
    COUNTRY_BREAKDOWN("country_breakdown"),
    PLATFORM_BREAKDOWN("platform_breakdown"),
    DAY_SITE_PLACEMENT_BREAKDOWN("day_site_placement_breakdown"), //only for networks
    DAY_SITE_PLACEMENT_COUNTRY_BREAKDOWN("day_site_placement_country_platform_breakdown"), //only for networks
    DAY_SITE_PAGE_TYPE_COUNTRY_PLATFORM_BREAKDOWN("day_site_page_type_country_platform_breakdown"); //only for networks

    private final String name;

    RevenueSummaryDimensions(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
