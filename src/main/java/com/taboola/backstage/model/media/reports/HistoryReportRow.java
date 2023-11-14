package com.taboola.backstage.model.media.reports;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Created by vladi.m
 * Date 13/11/2023
 * Time 22:31
 * Copyright Taboola
 */
public class HistoryReportRow {
    private Long id;
    private Long accountId;
    private String accountName;
    private Long campaignId;
    private String campaignName;
    private String changeType;
    private String activityCode;
    private String activityCodeDescription;
    private String activityDetailsCode;
    private String activityDetailsDescription;
    private String oldValue;
    private String newValue;
    private String performer;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.S")
    private Date changeTime;
    private String parametersDetails;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Long getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(Long campaignId) {
        this.campaignId = campaignId;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }

    public String getActivityCode() {
        return activityCode;
    }

    public void setActivityCode(String activityCode) {
        this.activityCode = activityCode;
    }

    public String getActivityCodeDescription() {
        return activityCodeDescription;
    }

    public void setActivityCodeDescription(String activityCodeDescription) {
        this.activityCodeDescription = activityCodeDescription;
    }

    public String getActivityDetailsCode() {
        return activityDetailsCode;
    }

    public void setActivityDetailsCode(String activityDetailsCode) {
        this.activityDetailsCode = activityDetailsCode;
    }

    public String getActivityDetailsDescription() {
        return activityDetailsDescription;
    }

    public void setActivityDetailsDescription(String activityDetailsDescription) {
        this.activityDetailsDescription = activityDetailsDescription;
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public Date getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(Date changeTime) {
        this.changeTime = changeTime;
    }

    public String getParametersDetails() {
        return parametersDetails;
    }

    public void setParametersDetails(String parametersDetails) {
        this.parametersDetails = parametersDetails;
    }

    @Override
    public String toString() {
        return "HistoryReportRow{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", accountName='" + accountName + '\'' +
                ", campaignId=" + campaignId +
                ", campaignName='" + campaignName + '\'' +
                ", changeType='" + changeType + '\'' +
                ", activityCode='" + activityCode + '\'' +
                ", activityCodeDescription='" + activityCodeDescription + '\'' +
                ", activityDetailsCode='" + activityDetailsCode + '\'' +
                ", activityDetailsDescription='" + activityDetailsDescription + '\'' +
                ", oldValue='" + oldValue + '\'' +
                ", newValue='" + newValue + '\'' +
                ", performer='" + performer + '\'' +
                ", changeTime=" + changeTime +
                ", parametersDetails='" + parametersDetails + '\'' +
                '}';
    }
}
