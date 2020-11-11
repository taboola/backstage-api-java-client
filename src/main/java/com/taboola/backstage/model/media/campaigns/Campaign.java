package com.taboola.backstage.model.media.campaigns;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.taboola.backstage.annotations.Final;
import com.taboola.backstage.annotations.ReadOnly;
import com.taboola.backstage.annotations.Required;
import com.taboola.backstage.model.media.campaigns.brandsafety.ExternalBrandSafety;
import com.taboola.backstage.model.media.campaigns.scheduling.ActivitySchedule;
import com.taboola.backstage.model.media.campaigns.verifications.VerificationPixel;
import com.taboola.backstage.model.media.campaigns.viewability.ViewabilityTag;

import java.util.Date;
import java.util.Objects;

/**
 * Created by vladi
 * Date: 9/12/2017
 * Time: 11:22 PM
 * By Taboola
 */
public class Campaign {

    @ReadOnly
    protected String id;
    @ReadOnly
    protected String advertiserId;
    @Required
    protected String name;
    @Required
    protected String brandingText;
    protected String trackingCode;
    @Required
    protected Double cpc;
    protected Double dailyCap;
    protected DailyAdDeliveryModel dailyAdDeliveryModel;
    protected PublisherBidModifier publisherBidModifier;
    protected BidStrategyModifiers publisherBidStrategyModifiers;
    protected TrafficAllocationMode trafficAllocationMode;
    @Required
    protected Double spendingLimit;
    @Required
    protected SpendingLimitModel spendingLimitModel;
    protected CampaignTargeting<String> countryTargeting;
    protected CampaignTargeting<String> dmaCountryTargeting;
    protected CampaignTargeting<String> regionCountryTargeting;
    protected CampaignTargeting<String> subCountryTargeting;
    protected CampaignTargeting<String> cityTargeting;
    protected CampaignTargeting<String> platformTargeting;
    protected CampaignTargeting<String> publisherTargeting;
    @ReadOnly
    protected CampaignTargeting<String> autoPublisherTargeting;
    protected CampaignTargeting<OperationSystem> osTargeting;
    protected CampaignTargeting<ConnectionType> connectionTypeTargeting;
    protected CampaignTargeting<String> contextualTargeting;
    protected CampaignTargeting<String> browserTargeting;
    @ReadOnly
    protected CampaignTargeting<String> postalCodeTargeting;
    @ReadOnly
    protected CampaignMultiTargeting<Long> audienceSegmentsMultiTargeting;
    @ReadOnly
    protected CampaignMultiTargeting<Long> customAudienceTargeting;
    @ReadOnly
    protected CampaignMultiTargeting<String> markingLabelMultiTargeting;
    @ReadOnly
    protected CampaignMultiTargeting<CampaignLookalikeAudienceTargeting> lookalikeAudienceTargeting;
    protected String comments;
    protected BidType bidType;
    @Required
    protected MarketingObjective marketingObjective;
    protected ActivitySchedule activitySchedule;
    @Final
    protected Date startDate;
    protected Date endDate;
    @ReadOnly
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    protected Date startDateInUtc;
    @ReadOnly
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    protected Date endDateInUtc;
    @ReadOnly
    protected CampaignApprovalState approvalState;
    protected Boolean isActive;
    @ReadOnly
    protected Double spent;
    @ReadOnly
    protected CampaignStatus status;
    protected Double cpaGoal;
    protected CampaignPricingModel pricingModel;
    protected ExternalBrandSafety externalBrandSafety;
    protected VerificationPixel verificationPixel;
    protected ViewabilityTag viewabilityTag;
    protected CampaignPolicyReview policyReview;

    public String getId() {
        return id;
    }

    public String getAdvertiserId() {
        return advertiserId;
    }

    public String getName() {
        return name;
    }

    public String getBrandingText() {
        return brandingText;
    }

    public String getTrackingCode() {
        return trackingCode;
    }

    public Double getCpc() {
        return cpc;
    }

    public Double getDailyCap() {
        return dailyCap;
    }

    public DailyAdDeliveryModel getDailyAdDeliveryModel() {
        return dailyAdDeliveryModel;
    }

    public PublisherBidModifier getPublisherBidModifier() {
        return publisherBidModifier;
    }

    public Double getSpendingLimit() {
        return spendingLimit;
    }

    public SpendingLimitModel getSpendingLimitModel() {
        return spendingLimitModel;
    }

    public CampaignTargeting<String> getCountryTargeting() {
        return countryTargeting;
    }

    public CampaignTargeting<String> getSubCountryTargeting() {
        return subCountryTargeting;
    }

    public CampaignTargeting<String> getCityTargeting() {
        return cityTargeting;
    }

    public CampaignTargeting<String> getPlatformTargeting() {
        return platformTargeting;
    }

    public CampaignTargeting<String> getPublisherTargeting() {
        return publisherTargeting;
    }

    public CampaignTargeting<String> getPostalCodeTargeting() {
        return postalCodeTargeting;
    }

    public CampaignTargeting<String> getBrowserTargeting() {
        return browserTargeting;
    }

    public CampaignTargeting<OperationSystem> getOsTargeting() {
        return osTargeting;
    }

    public String getComments() {
        return comments;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public CampaignApprovalState getApprovalState() {
        return approvalState;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public Double getSpent() {
        return spent;
    }

    public CampaignStatus getStatus() {
        return status;
    }

    public TrafficAllocationMode getTrafficAllocationMode() {
        return trafficAllocationMode;
    }

    public BidType getBidType() {
        return bidType;
    }

    public MarketingObjective getMarketingObjective() {
        return marketingObjective;
    }

    public ActivitySchedule getActivitySchedule() {
        return activitySchedule;
    }

    public CampaignTargeting<ConnectionType> getConnectionTypeTargeting() {
        return connectionTypeTargeting;
    }

    public Double getCpaGoal() {
        return cpaGoal;
    }

    public BidStrategyModifiers getPublisherBidStrategyModifiers() {
        return publisherBidStrategyModifiers;
    }

    public CampaignTargeting<String> getDmaCountryTargeting() {
        return dmaCountryTargeting;
    }

    public CampaignTargeting<String> getRegionCountryTargeting() {
        return regionCountryTargeting;
    }

    public CampaignTargeting<String> getAutoPublisherTargeting() {
        return autoPublisherTargeting;
    }

    public CampaignTargeting<String> getContextualTargeting() {
        return contextualTargeting;
    }

    public CampaignMultiTargeting<Long> getAudienceSegmentsMultiTargeting() {
        return audienceSegmentsMultiTargeting;
    }

    public CampaignMultiTargeting<Long> getCustomAudienceTargeting() {
        return customAudienceTargeting;
    }

    public CampaignMultiTargeting<String> getMarkingLabelMultiTargeting() {
        return markingLabelMultiTargeting;
    }

    public CampaignMultiTargeting<CampaignLookalikeAudienceTargeting> getLookalikeAudienceTargeting() {
        return lookalikeAudienceTargeting;
    }

    public Date getStartDateInUtc() {
        return startDateInUtc;
    }

    public Date getEndDateInUtc() {
        return endDateInUtc;
    }

    public CampaignPricingModel getPricingModel() {
        return pricingModel;
    }

    public ExternalBrandSafety getExternalBrandSafety() {
        return externalBrandSafety;
    }

    public VerificationPixel getVerificationPixel() {
        return verificationPixel;
    }

    public ViewabilityTag getViewabilityTag() {
        return viewabilityTag;
    }

    public CampaignPolicyReview getPolicyReview() {
        return policyReview;
    }

    @Override
    public String toString() {
        return "Campaign{" +
                "id='" + id + '\'' +
                ", advertiserId='" + advertiserId + '\'' +
                ", name='" + name + '\'' +
                ", brandingText='" + brandingText + '\'' +
                ", trackingCode='" + trackingCode + '\'' +
                ", cpc=" + cpc +
                ", dailyCap=" + dailyCap +
                ", dailyAdDeliveryModel=" + dailyAdDeliveryModel +
                ", publisherBidModifier=" + publisherBidModifier +
                ", publisherBidStrategyModifiers=" + publisherBidStrategyModifiers +
                ", trafficAllocationMode=" + trafficAllocationMode +
                ", spendingLimit=" + spendingLimit +
                ", spendingLimitModel=" + spendingLimitModel +
                ", countryTargeting=" + countryTargeting +
                ", dmaCountryTargeting=" + dmaCountryTargeting +
                ", regionCountryTargeting=" + regionCountryTargeting +
                ", subCountryTargeting=" + subCountryTargeting +
                ", cityTargeting=" + cityTargeting +
                ", platformTargeting=" + platformTargeting +
                ", publisherTargeting=" + publisherTargeting +
                ", autoPublisherTargeting=" + autoPublisherTargeting +
                ", osTargeting=" + osTargeting +
                ", connectionTypeTargeting=" + connectionTypeTargeting +
                ", contextualTargeting=" + contextualTargeting +
                ", browserTargeting=" + browserTargeting +
                ", postalCodeTargeting=" + postalCodeTargeting +
                ", audienceSegmentsMultiTargeting=" + audienceSegmentsMultiTargeting +
                ", customAudienceTargeting=" + customAudienceTargeting +
                ", markingLabelMultiTargeting=" + markingLabelMultiTargeting +
                ", lookalikeAudienceTargeting=" + lookalikeAudienceTargeting +
                ", comments='" + comments + '\'' +
                ", bidType=" + bidType +
                ", marketingObjective=" + marketingObjective +
                ", activitySchedule=" + activitySchedule +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", startDateInUtc=" + startDateInUtc +
                ", endDateInUtc=" + endDateInUtc +
                ", approvalState=" + approvalState +
                ", isActive=" + isActive +
                ", spent=" + spent +
                ", status=" + status +
                ", cpaGoal=" + cpaGoal +
                ", pricingModel=" + pricingModel +
                ", externalBrandSafety=" + externalBrandSafety +
                ", verificationPixel=" + verificationPixel +
                ", viewabilityTag=" + viewabilityTag +
                ", policyReview=" + policyReview +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Campaign campaign = (Campaign) o;
        return Objects.equals(id, campaign.id) &&
                Objects.equals(advertiserId, campaign.advertiserId) &&
                Objects.equals(name, campaign.name) &&
                Objects.equals(brandingText, campaign.brandingText) &&
                Objects.equals(trackingCode, campaign.trackingCode) &&
                Objects.equals(cpc, campaign.cpc) &&
                Objects.equals(dailyCap, campaign.dailyCap) &&
                dailyAdDeliveryModel == campaign.dailyAdDeliveryModel &&
                Objects.equals(publisherBidModifier, campaign.publisherBidModifier) &&
                Objects.equals(publisherBidStrategyModifiers, campaign.publisherBidStrategyModifiers) &&
                trafficAllocationMode == campaign.trafficAllocationMode &&
                Objects.equals(spendingLimit, campaign.spendingLimit) &&
                spendingLimitModel == campaign.spendingLimitModel &&
                Objects.equals(countryTargeting, campaign.countryTargeting) &&
                Objects.equals(dmaCountryTargeting, campaign.dmaCountryTargeting) &&
                Objects.equals(regionCountryTargeting, campaign.regionCountryTargeting) &&
                Objects.equals(subCountryTargeting, campaign.subCountryTargeting) &&
                Objects.equals(cityTargeting, campaign.cityTargeting) &&
                Objects.equals(platformTargeting, campaign.platformTargeting) &&
                Objects.equals(publisherTargeting, campaign.publisherTargeting) &&
                Objects.equals(autoPublisherTargeting, campaign.autoPublisherTargeting) &&
                Objects.equals(osTargeting, campaign.osTargeting) &&
                Objects.equals(connectionTypeTargeting, campaign.connectionTypeTargeting) &&
                Objects.equals(contextualTargeting, campaign.contextualTargeting) &&
                Objects.equals(browserTargeting, campaign.browserTargeting) &&
                Objects.equals(postalCodeTargeting, campaign.postalCodeTargeting) &&
                Objects.equals(audienceSegmentsMultiTargeting, campaign.audienceSegmentsMultiTargeting) &&
                Objects.equals(customAudienceTargeting, campaign.customAudienceTargeting) &&
                Objects.equals(markingLabelMultiTargeting, campaign.markingLabelMultiTargeting) &&
                Objects.equals(lookalikeAudienceTargeting, campaign.lookalikeAudienceTargeting) &&
                Objects.equals(comments, campaign.comments) &&
                bidType == campaign.bidType &&
                marketingObjective == campaign.marketingObjective &&
                Objects.equals(activitySchedule, campaign.activitySchedule) &&
                Objects.equals(startDate, campaign.startDate) &&
                Objects.equals(endDate, campaign.endDate) &&
                Objects.equals(startDateInUtc, campaign.startDateInUtc) &&
                Objects.equals(endDateInUtc, campaign.endDateInUtc) &&
                approvalState == campaign.approvalState &&
                Objects.equals(isActive, campaign.isActive) &&
                Objects.equals(spent, campaign.spent) &&
                status == campaign.status &&
                Objects.equals(cpaGoal, campaign.cpaGoal) &&
                pricingModel == campaign.pricingModel &&
                Objects.equals(externalBrandSafety, campaign.externalBrandSafety) &&
                Objects.equals(verificationPixel, campaign.verificationPixel) &&
                Objects.equals(viewabilityTag, campaign.viewabilityTag) &&
                Objects.equals(policyReview, campaign.policyReview);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, advertiserId, name, brandingText, trackingCode, cpc, dailyCap, dailyAdDeliveryModel, publisherBidModifier, publisherBidStrategyModifiers, trafficAllocationMode, spendingLimit, spendingLimitModel, countryTargeting, dmaCountryTargeting, regionCountryTargeting, subCountryTargeting, cityTargeting, platformTargeting, publisherTargeting, autoPublisherTargeting, osTargeting, connectionTypeTargeting, contextualTargeting, browserTargeting, postalCodeTargeting, audienceSegmentsMultiTargeting, customAudienceTargeting, markingLabelMultiTargeting, lookalikeAudienceTargeting, comments, bidType, marketingObjective, activitySchedule, startDate, endDate, startDateInUtc, endDateInUtc, approvalState, isActive, spent, status, cpaGoal, pricingModel, externalBrandSafety, verificationPixel, viewabilityTag, policyReview);
    }
}
