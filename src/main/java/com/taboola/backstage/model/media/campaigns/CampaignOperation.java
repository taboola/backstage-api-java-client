package com.taboola.backstage.model.media.campaigns;

import java.util.Date;

import com.taboola.backstage.model.media.campaigns.brandsafety.ExternalBrandSafety;
import com.taboola.backstage.model.media.campaigns.scheduling.ActivitySchedule;
import com.taboola.backstage.model.media.campaigns.verifications.VerificationPixel;

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

    public CampaignOperation setCountryTargeting(CampaignTargeting<String> countryTargeting) {
        this.countryTargeting = countryTargeting;
        return this;
    }

    public CampaignOperation setSubCountryTargeting(CampaignTargeting<String> subCountryTargeting) {
        this.subCountryTargeting = subCountryTargeting;
        return this;
    }

    public CampaignOperation setPlatformTargeting(CampaignTargeting<String> platformTargeting) {
        this.platformTargeting = platformTargeting;
        return this;
    }

    public CampaignOperation setCityTargeting(CampaignTargeting<String> cityTargeting) {
        this.cityTargeting = cityTargeting;
        return this;
    }

    public CampaignOperation setPublisherTargeting(CampaignTargeting<String> publisherTargeting) {
        this.publisherTargeting = publisherTargeting;
        return this;
    }

    public CampaignOperation setOsTargeting(CampaignTargeting<OperationSystem> osTargeting) {
        this.osTargeting = osTargeting;
        return this;
    }

    public CampaignOperation setComments(String comments) {
        this.comments = comments;
        return this;
    }

    public CampaignOperation setStartDate(Date startDate) {
        if (startDate != null) {
            dateFormat.applyPattern(DATE_TIME_FORMAT);
            this.startDate = dateFormat.format(startDate);
        } else {
            this.startDate = null;
        }
        return this;
    }

    public CampaignOperation setEndDate(Date endDate) {
        if (endDate != null) {
            dateFormat.applyPattern(DATE_TIME_FORMAT);
            this.endDate = dateFormat.format(endDate);
        } else {
            this.startDate = null;
        }
        return this;
    }

    public CampaignOperation setActive(Boolean active) {
        isActive = active;
        return this;
    }

    public CampaignOperation setTrafficAllocationMode(TrafficAllocationMode trafficAllocationMode) {
        this.trafficAllocationMode = trafficAllocationMode;
        return this;
    }

    public CampaignOperation setBidType(BidType bidType) {
        this.bidType = bidType;
        return this;
    }

    public CampaignOperation setMarketingObjective(MarketingObjective marketingObjective) {
        this.marketingObjective = marketingObjective;
        return this;
    }

    public CampaignOperation setActivitySchedule(ActivitySchedule activitySchedule) {
        this.activitySchedule = activitySchedule;
        return this;
    }

    public CampaignOperation setConnectionTypeTargeting(CampaignTargeting<ConnectionType> connectionTypeTargeting) {
        this.connectionTypeTargeting = connectionTypeTargeting;
        return this;
    }

    public CampaignOperation setCpaGoal(Double cpaGoal) {
        this.cpaGoal = cpaGoal;
        return this;
    }

    public CampaignOperation setPublisherBidStrategyModifiers(BidStrategyModifiers publisherBidStrategyModifiers) {
        this.publisherBidStrategyModifiers = publisherBidStrategyModifiers;
        return this;
    }

    public CampaignOperation setDmaCountryTargeting(CampaignTargeting<String> dmaCountryTargeting) {
        this.dmaCountryTargeting = dmaCountryTargeting;
        return this;
    }

    public CampaignOperation setRegionCountryTargeting(CampaignTargeting<String> regionCountryTargeting) {
        this.regionCountryTargeting = regionCountryTargeting;
        return this;
    }

    public CampaignOperation setContextualTargeting(CampaignTargeting<String> contextualTargeting) {
        this.contextualTargeting = contextualTargeting;
        return this;
    }

    public CampaignOperation setPricingModel(CampaignPricingModel pricingModel) {
        this.pricingModel = pricingModel;
        return this;
    }

    public CampaignOperation setExternalBrandSafety(ExternalBrandSafety externalBrandSafety) {
        this.externalBrandSafety = externalBrandSafety;
        return this;
    }

    public CampaignOperation setVerificationPixel(VerificationPixel verificationPixel) {
        this.verificationPixel = verificationPixel;
        return this;
    }

    public CampaignOperation setBrowserTargeting(CampaignTargeting<String> browserTargeting) {
        this.browserTargeting = browserTargeting;
        return this;
    }
}
