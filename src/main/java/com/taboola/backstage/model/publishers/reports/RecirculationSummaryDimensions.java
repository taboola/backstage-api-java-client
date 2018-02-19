package com.taboola.backstage.model.publishers.reports;

/**
 * Created by vladi
 * Date: 2/3/2018
 * Time: 11:01 PM
 * By Taboola
 */
public enum RecirculationSummaryDimensions {

    DAY("day"),
    WEEK("week"),
    MONTH("month"),
    PAGE_TYPE_BREAKDOWN("page_type_breakdown"),
    PLACEMENT_BREAKDOWN("placement_breakdown"),
    SITE_BREAKDOWN("site_breakdown"),
    COUNTRY_BREAKDOWN("country_breakdown"),
    PLATFORM_BREAKDOWN("platform_breakdown"),
    DAY_SITE_PLACEMENT_BREAKDOWN("day_site_placement_breakdown");


    private final String name;

    RecirculationSummaryDimensions(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
