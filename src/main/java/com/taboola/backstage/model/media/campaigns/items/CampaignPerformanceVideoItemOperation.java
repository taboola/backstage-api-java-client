package com.taboola.backstage.model.media.campaigns.items;

import com.taboola.backstage.model.media.campaigns.verifications.VerificationPixel;
import com.taboola.backstage.model.media.campaigns.viewability.ViewabilityTag;

/**
 * Created by vladi.m
 * Date 13/11/2023
 * Time 21:16
 * Copyright Taboola
 */
public class CampaignPerformanceVideoItemOperation extends CampaignPerformanceVideoItem {

    private CampaignPerformanceVideoItemOperation() { }

    public static CampaignPerformanceVideoItemOperation create() {
        return new CampaignPerformanceVideoItemOperation();
    }

    public CampaignPerformanceVideoItemOperation setCampaignId(String campaignId) {
        this.campaignId = campaignId;
        return this;
    }

    public CampaignPerformanceVideoItemOperation setUrl(String url) {
        this.url = url;
        return this;
    }

    public CampaignPerformanceVideoItemOperation setTitle(String title) {
        this.title = title;
        return this;
    }

    public CampaignPerformanceVideoItemOperation setDescription(String description) {
        this.description = description;
        return this;
    }

    public CampaignPerformanceVideoItemOperation setActive(Boolean active) {
        isActive = active;
        return this;
    }

    public CampaignPerformanceVideoItemOperation setFallbackUrl(String fallbackUrl) {
        this.fallbackUrl = fallbackUrl;
        return this;
    }

    public CampaignPerformanceVideoItemOperation setGifUrl(String gifUrl) {
        this.gifUrl = gifUrl;
        return this;
    }

    public CampaignPerformanceVideoItemOperation setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public CampaignPerformanceVideoItemOperation setCta(CampaignItemCTA cta) {
        this.cta = cta;
        return this;
    }

    public CampaignPerformanceVideoItemOperation setVerificationPixel(VerificationPixel verificationPixel) {
        this.verificationPixel = verificationPixel;
        return this;
    }

    public CampaignPerformanceVideoItemOperation setViewabilityTag(ViewabilityTag viewabilityTag) {
        this.viewabilityTag = viewabilityTag;
        return this;
    }

    public CampaignPerformanceVideoItemOperation setMotionAdsStudio(MotionAdsStudio motionAdsStudio) {
        this.motionAdsStudio = motionAdsStudio;
        return this;
    }

    public CampaignPerformanceVideoItemOperation setAppInstall(CampaignItemAppInstall appInstall) {
        this.appInstall = appInstall;
        return this;
    }

    public CampaignPerformanceVideoItemOperation setRating(CampaignItemRating rating) {
        this.rating = rating;
        return this;
    }

    public CampaignPerformanceVideoItemOperation setLogo(CampaignItemLogo logo) {
        this.logo = logo;
        return this;
    }

    public CampaignPerformanceVideoItemOperation setDisclaimer(CampaignItemDisclaimer disclaimer) {
        this.disclaimer = disclaimer;
        return this;
    }

    public CampaignPerformanceVideoItemOperation setBrandingText(String brandingText) {
        this.brandingText = brandingText;
        return this;
    }
}
