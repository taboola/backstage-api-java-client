package com.taboola.backstage.model.publishers.reports;

import com.taboola.backstage.model.ReportFilter;

/**
 * Created by vladi
 * Date: 2/3/2018
 * Time: 10:51 PM
 * By Taboola
 */
public enum RecirculationSummaryOptionalFilters implements ReportFilter {

    PAGE_TYPE("page_type"),
    PACEMENT("placement"),
    COUNTRY("country"),
    PLATFORM("platform");

    private final String name;

    RecirculationSummaryOptionalFilters(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
