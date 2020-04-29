package com.taboola.backstage.model.media.campaigns;

import java.util.Collection;

import com.taboola.backstage.model.media.campaigns.targeting.Type;

/**
 * Created by vladi.m
 * Date 29/04/2020
 * Time 11:11
 * Copyright Taboola
 */
public class CampaignTargetingCollection<T> {
    private Collection<T> collection;
    private Type type;

    public CampaignTargetingCollection() {
    }

    public CampaignTargetingCollection(Collection<T> collection, Type type) {
        this.collection = collection;
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Collection<T> getCollection() {
        return collection;
    }

    public void setCollection(Collection<T> collection) {
        this.collection = collection;
    }

    @Override
    public String toString() {
        return "CampaignTargetingCollection{" +
                "collection=" + collection +
                ", type=" + type +
                '}';
    }
}
