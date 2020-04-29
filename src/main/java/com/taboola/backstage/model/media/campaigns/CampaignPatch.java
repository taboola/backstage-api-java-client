package com.taboola.backstage.model.media.campaigns;

import com.taboola.backstage.model.Patch;

/**
 * Created by vladi.m
 * Date 2019-07-25
 * Time 16:29
 * Copyright Taboola
 */
public class CampaignPatch extends Patch {

    private CampaignPublisherTargetingPatch publisherTargeting;
    private CampaignAutoPublisherTargetingPatch autoPublisherTargeting;
    private PublisherBidModifier publisherBidModifier;
    private BidStrategyModifiers publisherBidStrategyModifiers;

    public CampaignPublisherTargetingPatch getPublisherTargeting() {
        return publisherTargeting;
    }

    public void setPublisherTargeting(CampaignPublisherTargetingPatch publisherTargeting) {
        this.publisherTargeting = publisherTargeting;
    }

    public PublisherBidModifier getPublisherBidModifier() {
        return publisherBidModifier;
    }

    public void setPublisherBidModifier(PublisherBidModifier publisherBidModifier) {
        this.publisherBidModifier = publisherBidModifier;
    }

    public CampaignAutoPublisherTargetingPatch getAutoPublisherTargeting() {
        return autoPublisherTargeting;
    }

    public void setAutoPublisherTargeting(CampaignAutoPublisherTargetingPatch autoPublisherTargeting) {
        this.autoPublisherTargeting = autoPublisherTargeting;
    }

    public BidStrategyModifiers getPublisherBidStrategyModifiers() {
        return publisherBidStrategyModifiers;
    }

    public void setPublisherBidStrategyModifiers(BidStrategyModifiers publisherBidStrategyModifiers) {
        this.publisherBidStrategyModifiers = publisherBidStrategyModifiers;
    }
}
