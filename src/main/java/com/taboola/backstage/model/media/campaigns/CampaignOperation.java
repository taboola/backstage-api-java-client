package com.taboola.backstage.model.media.campaigns;

import java.util.Date;

/**
 * Created by vladi
 * Date: 1/19/2018
 * Time: 11:06 AM
 * By Taboola
 */
public class CampaignOperation extends Campaign {

    private CampaignOperation() { }

    public static CampaignOperation create() {
        return new CampaignOperation();
    }

    public CampaignOperation setName(String name) {
        this.name = name;
        return this;
    }

    public CampaignOperation setBrandingText(String brandingText) {
        this.brandingText = brandingText;
        return this;
    }

    public CampaignOperation setTrackingCode(String trackingCode) {
        this.trackingCode = trackingCode;
        return this;
    }

    public CampaignOperation setCpc(Double cpc) {
        this.cpc = cpc;
        return this;
    }

    public CampaignOperation setDailyCap(Double dailyCap) {
        this.dailyCap = dailyCap;
        return this;
    }

    public CampaignOperation setDailyAdDeliveryModel(DailyAdDeliveryModel dailyAdDeliveryModel) {
        this.dailyAdDeliveryModel = dailyAdDeliveryModel;
        return this;
    }

    public CampaignOperation setPublisherBidModifier(PublisherBidModifier publisherBidModifier) {
        this.publisherBidModifier = publisherBidModifier;
        return this;
    }

    public CampaignOperation setSpendingLimit(Double spendingLimit) {
        this.spendingLimit = spendingLimit;
        return this;
    }

    public CampaignOperation setSpendingLimitModel(SpendingLimitModel spendingLimitModel) {
        this.spendingLimitModel = spendingLimitModel;
        return this;
    }

    public CampaignOperation setCountryTargeting(CampaignTargeting countryTargeting) {
        this.countryTargeting = countryTargeting;
        return this;
    }

    public CampaignOperation setSubCountryTargeting(CampaignTargeting subCountryTargeting) {
        this.subCountryTargeting = subCountryTargeting;
        return this;
    }

    public CampaignOperation setPlatformTargeting(CampaignTargeting platformTargeting) {
        this.platformTargeting = platformTargeting;
        return this;
    }

    public CampaignOperation setPublisherTargeting(CampaignTargeting publisherTargeting) {
        this.publisherTargeting = publisherTargeting;
        return this;
    }

    public CampaignOperation setComments(String comments) {
        this.comments = comments;
        return this;
    }

    public CampaignOperation setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public CampaignOperation setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public CampaignOperation setActive(Boolean active) {
        isActive = active;
        return this;
    }
}
