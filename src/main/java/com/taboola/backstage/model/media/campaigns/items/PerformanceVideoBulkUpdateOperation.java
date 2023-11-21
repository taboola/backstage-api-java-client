package com.taboola.backstage.model.media.campaigns.items;

import java.util.List;

import com.taboola.rest.api.annotations.Required;

/**
 * Created by vladi.m
 * Date 13/11/2023
 * Time 21:26
 * Copyright Taboola
 */
public class PerformanceVideoBulkUpdateOperation {
    @Required
    private List<Long> itemsToUpdate;
    @Required
    private CampaignPerformanceVideoItem baselineItem;

    public static PerformanceVideoBulkUpdateOperation create() {
        return new PerformanceVideoBulkUpdateOperation();
    }

    public List<Long> getItemsToUpdate() {
        return itemsToUpdate;
    }

    public PerformanceVideoBulkUpdateOperation setItemsToUpdate(List<Long> itemsToUpdate) {
        this.itemsToUpdate = itemsToUpdate;
        return this;
    }

    public CampaignPerformanceVideoItem getBaselineItem() {
        return baselineItem;
    }

    public PerformanceVideoBulkUpdateOperation setBaselineItem(CampaignPerformanceVideoItem baselineItem) {
        this.baselineItem = baselineItem;
        return this;
    }

    @Override
    public String toString() {
        return "PerformanceVideoBulkUpdateOperation{" +
                "itemsToUpdate=" + itemsToUpdate +
                ", baselineItem=" + baselineItem +
                '}';
    }
}
