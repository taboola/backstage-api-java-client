package com.taboola.backstage.model.media.campaigns;

import com.taboola.backstage.annotations.Final;
import com.taboola.backstage.annotations.ReadOnly;
import com.taboola.backstage.annotations.Required;

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
    protected TrafficAllocationMode trafficAllocationMode;
    @Required
    protected Double spendingLimit;
    @Required
    protected SpendingLimitModel spendingLimitModel;
    protected CampaignTargeting<String> countryTargeting;
    protected CampaignTargeting<String> subCountryTargeting;
    protected CampaignTargeting<String> platformTargeting;
    protected CampaignTargeting<String> publisherTargeting;
    protected CampaignTargeting<OperationSystem> osTargeting;
    @ReadOnly
    protected CampaignTargeting<String> postalCodeTargeting;
    protected String comments;
    protected BidType bidType;
    protected MarketingObjective marketingObjective;
    @Final
    protected Date startDate;
    protected Date endDate;
    @ReadOnly
    protected CampaignApprovalState approvalState;
    protected Boolean isActive;
    @ReadOnly
    protected Double spent;
    @ReadOnly
    protected CampaignStatus status;

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

    public CampaignTargeting<String> getPlatformTargeting() {
        return platformTargeting;
    }

    public CampaignTargeting<String> getPublisherTargeting() {
        return publisherTargeting;
    }

    public CampaignTargeting<String> getPostalCodeTargeting() {
        return postalCodeTargeting;
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
                ", trafficAllocationMode=" + trafficAllocationMode +
                ", spendingLimit=" + spendingLimit +
                ", spendingLimitModel=" + spendingLimitModel +
                ", countryTargeting=" + countryTargeting +
                ", subCountryTargeting=" + subCountryTargeting +
                ", platformTargeting=" + platformTargeting +
                ", publisherTargeting=" + publisherTargeting +
                ", osTargeting=" + osTargeting +
                ", postalCodeTargeting=" + postalCodeTargeting +
                ", comments='" + comments + '\'' +
                ", bidType=" + bidType +
                ", marketingObjective=" + marketingObjective +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", approvalState=" + approvalState +
                ", isActive=" + isActive +
                ", spent=" + spent +
                ", status=" + status +
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
                trafficAllocationMode == campaign.trafficAllocationMode &&
                Objects.equals(spendingLimit, campaign.spendingLimit) &&
                spendingLimitModel == campaign.spendingLimitModel &&
                Objects.equals(countryTargeting, campaign.countryTargeting) &&
                Objects.equals(subCountryTargeting, campaign.subCountryTargeting) &&
                Objects.equals(platformTargeting, campaign.platformTargeting) &&
                Objects.equals(publisherTargeting, campaign.publisherTargeting) &&
                Objects.equals(osTargeting, campaign.osTargeting) &&
                Objects.equals(postalCodeTargeting, campaign.postalCodeTargeting) &&
                Objects.equals(comments, campaign.comments) &&
                bidType == campaign.bidType &&
                marketingObjective == campaign.marketingObjective &&
                Objects.equals(startDate, campaign.startDate) &&
                Objects.equals(endDate, campaign.endDate) &&
                approvalState == campaign.approvalState &&
                Objects.equals(isActive, campaign.isActive) &&
                Objects.equals(spent, campaign.spent) &&
                status == campaign.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, advertiserId, name, brandingText, trackingCode, cpc, dailyCap, dailyAdDeliveryModel, publisherBidModifier, trafficAllocationMode, spendingLimit, spendingLimitModel, countryTargeting, subCountryTargeting, platformTargeting, publisherTargeting, osTargeting, postalCodeTargeting, comments, bidType, marketingObjective, startDate, endDate, approvalState, isActive, spent, status);
    }
}
