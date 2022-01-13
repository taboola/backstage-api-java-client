package com.taboola.backstage.model.media.campaigns;

import java.util.Date;

import com.taboola.backstage.model.CampaignType;

public class CampaignBase {
    private Long id;
    private Long advertiserId;
    private String advertiserName;
    private String advertiserDescription;
    private String name;
    private String brandingText;
    private String policyState;
    private CampaignStatus status;
    private Date createTime;
    private Double totalSpent;
    private CampaignType type;
    private MarketingObjective marketingObjective;
    private CampaignsGroup campaignGroups;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAdvertiserId() {
        return advertiserId;
    }

    public void setAdvertiserId(Long advertiserId) {
        this.advertiserId = advertiserId;
    }

    public String getAdvertiserName() {
        return advertiserName;
    }

    public void setAdvertiserName(String advertiserName) {
        this.advertiserName = advertiserName;
    }

    public String getAdvertiserDescription() {
        return advertiserDescription;
    }

    public void setAdvertiserDescription(String advertiserDescription) {
        this.advertiserDescription = advertiserDescription;
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

    public String getPolicyState() {
        return policyState;
    }

    public void setPolicyState(String policyState) {
        this.policyState = policyState;
    }

    public CampaignStatus getStatus() {
        return status;
    }

    public void setStatus(CampaignStatus status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Double getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent(Double totalSpent) {
        this.totalSpent = totalSpent;
    }

    public CampaignType getType() {
        return type;
    }

    public void setType(CampaignType type) {
        this.type = type;
    }

    public MarketingObjective getMarketingObjective() {
        return marketingObjective;
    }

    public void setMarketingObjective(MarketingObjective marketingObjective) {
        this.marketingObjective = marketingObjective;
    }

    public CampaignsGroup getCampaignGroups() {
        return campaignGroups;
    }

    public void setCampaignGroups(CampaignsGroup campaignGroups) {
        this.campaignGroups = campaignGroups;
    }

    @Override
    public String toString() {
        return "CampaignBase{" +
                "id=" + id +
                ", advertiserId=" + advertiserId +
                ", advertiserName='" + advertiserName + '\'' +
                ", advertiserDescription='" + advertiserDescription + '\'' +
                ", name='" + name + '\'' +
                ", brandingText='" + brandingText + '\'' +
                ", policyState='" + policyState + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                ", totalSpent=" + totalSpent +
                ", type=" + type +
                ", marketingObjective=" + marketingObjective +
                ", campaignGroups=" + campaignGroups +
                '}';
    }
}
