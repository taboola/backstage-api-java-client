package com.taboola.backstage.model.publishers.reports;

import com.taboola.backstage.model.ReportFilter;

/**
 * Created by vladi
 * Date: 2/3/2018
 * Time: 10:48 PM
 * By Taboola
 */
public enum VisitValueOptionalFilters implements ReportFilter {

    REFERRAL_DOMAIN("referral_domain"),
    LANDING_PAGE("landing_page"),
    COUNTRY("country"),
    PLATFORM("platform"),
    CAMPAIGN_SOURCE("campaign_source"),
    CAMPAIGN_MEDIUM("campaign_medium"),
    CAMPAIGN_TERM("campaign_term"),
    CAMPAIGN_CONTENT("campaign_content"),
    CAMPAIGN_NAME("campaign_name"),
    CUSTOM_KEY("custom_key"),
    CUSTOM_VALUE("custom_value"),
    PAGE_TYPE("page_type");

    private final String name;

    VisitValueOptionalFilters(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
