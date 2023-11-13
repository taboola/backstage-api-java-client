package com.taboola.backstage.model.media.campaigns.items;

import java.util.List;

import com.taboola.rest.api.annotations.Required;

/**
 * Created by vladi.m
 * Date 13/11/2023
 * Time 21:23
 * Copyright Taboola
 */
public class PerformanceVideoBulkCreateOperation {
    @Required
    private List<Long> campaignIds;
    @Required
    private List<CampaignPerformanceVideoItem> items;

    public static PerformanceVideoBulkCreateOperation create() {
        return new PerformanceVideoBulkCreateOperation();
    }

    public List<Long> getCampaignIds() {
        return campaignIds;
    }

    public PerformanceVideoBulkCreateOperation setCampaignIds(List<Long> campaignIds) {
        this.campaignIds = campaignIds;
        return this;
    }

    public List<CampaignPerformanceVideoItem> getItems() {
        return items;
    }

    public PerformanceVideoBulkCreateOperation setItems(List<CampaignPerformanceVideoItem> items) {
        this.items = items;
        return this;
    }

    @Override
    public String toString() {
        return "PerformanceVideoBulkCreateOperation{" +
                "campaignIds=" + campaignIds +
                ", items=" + items +
                '}';
    }
}
