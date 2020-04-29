package com.taboola.backstage.model.media.campaigns;

import java.util.Collection;

/**
 * Created by vladi.m
 * Date 29/04/2020
 * Time 11:10
 * Copyright Taboola
 */
public class CampaignMultiTargetingCollection<T> {
    private Collection<CampaignTargetingCollection<T>> collection;

    public CampaignMultiTargetingCollection() {
    }

    public CampaignMultiTargetingCollection(Collection<CampaignTargetingCollection<T>> collection) {
        this.collection = collection;
    }

    public Collection<CampaignTargetingCollection<T>> getCollection() {
        return collection;
    }

    public void setCollection(Collection<CampaignTargetingCollection<T>> collection) {
        this.collection = collection;
    }

    @Override
    public String toString() {
        return "CampaignMultiTargetingCollection{" +
                "collection=" + collection +
                '}';
    }
}
