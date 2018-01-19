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
    @Required
    protected Double spendingLimit;
    @Required
    protected SpendingLimitModel spendingLimitModel;
    protected CampaignTargeting countryTargeting;
    protected CampaignTargeting subCountryTargeting;
    protected CampaignTargeting platformTargeting;
    protected CampaignTargeting publisherTargeting;
    @ReadOnly
    protected CampaignTargeting postalCodeTargeting;
    protected String comments;
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

    public CampaignTargeting getCountryTargeting() {
        return countryTargeting;
    }

    public CampaignTargeting getSubCountryTargeting() {
        return subCountryTargeting;
    }

    public CampaignTargeting getPlatformTargeting() {
        return platformTargeting;
    }

    public CampaignTargeting getPublisherTargeting() {
        return publisherTargeting;
    }

    public CampaignTargeting getPostalCodeTargeting() {
        return postalCodeTargeting;
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

    @Override
    public String toString() {
        return "Campaign{" +
        "id=" + id +
        ", advertiserId='" + advertiserId + '\'' +
        ", name='" + name + '\'' +
        ", brandingText='" + brandingText + '\'' +
        ", trackingCode='" + trackingCode + '\'' +
        ", cpc=" + cpc +
        ", dailyCap=" + dailyCap +
        ", dailyAdDeliveryModel='" + dailyAdDeliveryModel + '\'' +
        ", publisherBidModifier=" + publisherBidModifier +
        ", spendingLimit=" + spendingLimit +
        ", spendingLimitModel='" + spendingLimitModel + '\'' +
        ", countryTargeting=" + countryTargeting +
        ", subCountryTargeting=" + subCountryTargeting +
        ", platformTargeting=" + platformTargeting +
        ", publisherTargeting=" + publisherTargeting +
        ", postalCodeTargeting=" + postalCodeTargeting +
        ", comments='" + comments + '\'' +
        ", startDate=" + startDate +
        ", endDate=" + endDate +
        ", approvalState='" + approvalState + '\'' +
        ", isActive=" + isActive +
        ", spent=" + spent +
        ", status='" + status + '\'' +
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
        Objects.equals(dailyAdDeliveryModel, campaign.dailyAdDeliveryModel) &&
        Objects.equals(publisherBidModifier, campaign.publisherBidModifier) &&
        Objects.equals(spendingLimit, campaign.spendingLimit) &&
        Objects.equals(spendingLimitModel, campaign.spendingLimitModel) &&
        Objects.equals(countryTargeting, campaign.countryTargeting) &&
        Objects.equals(subCountryTargeting, campaign.subCountryTargeting) &&
        Objects.equals(platformTargeting, campaign.platformTargeting) &&
        Objects.equals(publisherTargeting, campaign.publisherTargeting) &&
        Objects.equals(postalCodeTargeting, campaign.postalCodeTargeting) &&
        Objects.equals(comments, campaign.comments) &&
        Objects.equals(startDate, campaign.startDate) &&
        Objects.equals(endDate, campaign.endDate) &&
        Objects.equals(approvalState, campaign.approvalState) &&
        Objects.equals(isActive, campaign.isActive) &&
        Objects.equals(spent, campaign.spent) &&
        Objects.equals(status, campaign.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, advertiserId, name, brandingText, trackingCode, cpc, dailyCap, dailyAdDeliveryModel, publisherBidModifier, spendingLimit, spendingLimitModel, countryTargeting, subCountryTargeting, platformTargeting, publisherTargeting, postalCodeTargeting, comments, startDate, endDate, approvalState, isActive, spent, status);
    }
}
