/*
 * Copyright 2023 InPowered. All Rights Reserved.
 *
 * This software is the proprietary information of InPowered.
 * Use is subject to license terms.
 */
package com.taboola.backstage.model.media.reports;

/**
 * @author Gabriel Diaz, 21/12/23.
 */
public enum CampaignRealtimeDimensions {
    BY_HOUR("by_hour"),
    BY_SMALLEST_TIME_BUCKET("by_smallest_time_bucket"),
    BY_CAMPAIGN("by_campaign"),
    BY_CAMPAIGN_BY_SMALLEST_TIME_BUCKET("by_campaign_by_smallest_time_bucket"),
    BY_SITE("by_site"),
    BY_SITE_BY_SMALLEST_TIME_BUCKET("by_site_by_smallest_time_bucket")
    ;

    private final String name;

    CampaignRealtimeDimensions(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
