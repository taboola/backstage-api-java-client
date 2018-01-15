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
    private String id;
    @ReadOnly
    private String advertiserId;
    @Required
    private String name;
    @Required
    private String brandingText;
    private String trackingCode;
    @Required
    private Double cpc;
    private Double dailyCap;
    private DailyAdDeliveryMode dailyAdDeliveryMode;
    private PublisherBidModifier publisherBidModifier;
    @Required
    private Double spendingLimit;
    @Required
    private SpendingLimitModel spendingLimitModel;
    private CampaignTargeting countryTargeting;
    private CampaignTargeting subCountryTargeting;
    private CampaignTargeting platformTargeting;
    private CampaignTargeting publisherTargeting;
    @ReadOnly
    private CampaignTargeting postalCodeTargeting;
    private String comments;
    @Final
    private Date startDate;
    private Date endDate;
    @ReadOnly
    private CampaignApprovalState approvalState;
    private Boolean isActive;
    @ReadOnly
    private Double spent;
    @ReadOnly
    private CampaignStatus status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdvertiserId() {
        return advertiserId;
    }

    public void setAdvertiserId(String advertiserId) {
        this.advertiserId = advertiserId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrandingText() {
        return brandingText;
    }

    public void setBrandingText(String brandingText) {
        this.brandingText = brandingText;
    }

    public String getTrackingCode() {
        return trackingCode;
    }

    public void setTrackingCode(String trackingCode) {
        this.trackingCode = trackingCode;
    }

    public Double getCpc() {
        return cpc;
    }

    public void setCpc(Double cpc) {
        this.cpc = cpc;
    }

    public Double getDailyCap() {
        return dailyCap;
    }

    public void setDailyCap(Double dailyCap) {
        this.dailyCap = dailyCap;
    }

    public DailyAdDeliveryMode getDailyAdDeliveryMode() {
        return dailyAdDeliveryMode;
    }

    public void setDailyAdDeliveryMode(DailyAdDeliveryMode dailyAdDeliveryMode) {
        this.dailyAdDeliveryMode = dailyAdDeliveryMode;
    }

    public PublisherBidModifier getPublisherBidModifier() {
        return publisherBidModifier;
    }

    public void setPublisherBidModifier(PublisherBidModifier publisherBidModifier) {
        this.publisherBidModifier = publisherBidModifier;
    }

    public Double getSpendingLimit() {
        return spendingLimit;
    }

    public void setSpendingLimit(Double spendingLimit) {
        this.spendingLimit = spendingLimit;
    }

    public SpendingLimitModel getSpendingLimitModel() {
        return spendingLimitModel;
    }

    public void setSpendingLimitModel(SpendingLimitModel spendingLimitModel) {
        this.spendingLimitModel = spendingLimitModel;
    }

    public CampaignTargeting getCountryTargeting() {
        return countryTargeting;
    }

    public void setCountryTargeting(CampaignTargeting countryTargeting) {
        this.countryTargeting = countryTargeting;
    }

    public CampaignTargeting getSubCountryTargeting() {
        return subCountryTargeting;
    }

    public void setSubCountryTargeting(CampaignTargeting subCountryTargeting) {
        this.subCountryTargeting = subCountryTargeting;
    }

    public CampaignTargeting getPlatformTargeting() {
        return platformTargeting;
    }

    public void setPlatformTargeting(CampaignTargeting platformTargeting) {
        this.platformTargeting = platformTargeting;
    }

    public CampaignTargeting getPublisherTargeting() {
        return publisherTargeting;
    }

    public void setPublisherTargeting(CampaignTargeting publisherTargeting) {
        this.publisherTargeting = publisherTargeting;
    }

    public CampaignTargeting getPostalCodeTargeting() {
        return postalCodeTargeting;
    }

    public void setPostalCodeTargeting(CampaignTargeting postalCodeTargeting) {
        this.postalCodeTargeting = postalCodeTargeting;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public CampaignApprovalState getApprovalState() {
        return approvalState;
    }

    public void setApprovalState(CampaignApprovalState approvalState) {
        this.approvalState = approvalState;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }

    public Double getSpent() {
        return spent;
    }

    public void setSpent(Double spent) {
        this.spent = spent;
    }

    public CampaignStatus getStatus() {
        return status;
    }

    public void setStatus(CampaignStatus status) {
        this.status = status;
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
        ", dailyAdDeliveryMode='" + dailyAdDeliveryMode + '\'' +
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
        Objects.equals(dailyAdDeliveryMode, campaign.dailyAdDeliveryMode) &&
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
        return Objects.hash(id, advertiserId, name, brandingText, trackingCode, cpc, dailyCap, dailyAdDeliveryMode, publisherBidModifier, spendingLimit, spendingLimitModel, countryTargeting, subCountryTargeting, platformTargeting, publisherTargeting, postalCodeTargeting, comments, startDate, endDate, approvalState, isActive, spent, status);
    }
}
