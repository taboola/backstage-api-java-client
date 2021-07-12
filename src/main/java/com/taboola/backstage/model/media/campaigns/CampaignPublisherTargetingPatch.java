package com.taboola.backstage.model.media.campaigns;

import java.util.List;

import com.taboola.rest.api.annotations.Required;

/**
 * Created by vladi.m
 * Date 2019-07-25
 * Time 17:57
 * Copyright Taboola
 */
public class CampaignPublisherTargetingPatch {

    @Required
    private List<String> publishers;

    public List<String> getPublishers() {
        return publishers;
    }

    public void setPublishers(List<String> publishers) {
        this.publishers = publishers;
    }
}
