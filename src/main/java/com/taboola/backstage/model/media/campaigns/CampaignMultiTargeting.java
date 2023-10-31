package com.taboola.backstage.model.media.campaigns;

import java.util.Collection;

import com.taboola.backstage.model.media.campaigns.targeting.MultiTargetingState;
import com.taboola.rest.api.annotations.ReadOnly;

/**
 * Created by vladi.m
 * Date 16/04/2020
 * Time 12:34
 * Copyright Taboola
 */
public class CampaignMultiTargeting<V> {

    private MultiTargetingState state;
    private Collection<CampaignTargeting<V>> value;
    @ReadOnly
    private String href;

    public MultiTargetingState getState() {
        return state;
    }

    public void setState(MultiTargetingState state) {
        this.state = state;
    }

    public Collection<CampaignTargeting<V>> getValue() {
        return value;
    }

    public void setValue(Collection<CampaignTargeting<V>> value) {
        this.value = value;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public String toString() {
        return "CampaignMultiTargeting{" +
                "state=" + state +
                ", value=" + value +
                ", href='" + href + '\'' +
                '}';
    }
}
