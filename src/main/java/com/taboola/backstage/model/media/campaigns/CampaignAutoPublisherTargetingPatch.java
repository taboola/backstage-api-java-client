package com.taboola.backstage.model.media.campaigns;

import java.util.List;

import com.taboola.rest.api.annotations.Required;

/**
 * Created by vladi.m
 * Date 27/04/2020
 * Time 18:35
 * Copyright Taboola
 */
public class CampaignAutoPublisherTargetingPatch {

    @Required
    private List<String> publishers;

    public List<String> getPublishers() {
        return publishers;
    }

    public void setPublishers(List<String> publishers) {
        this.publishers = publishers;
    }
}
