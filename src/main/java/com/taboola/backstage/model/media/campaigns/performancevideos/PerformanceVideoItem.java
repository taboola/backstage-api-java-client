/*
 * Copyright 2021 InPowered. All Rights Reserved.
 *
 * This software is the proprietary information of InPowered.
 * Use is subject to license terms.
 */
package com.taboola.backstage.model.media.campaigns.performancevideos;

import com.taboola.backstage.model.media.campaigns.items.CampaignItemPolicyReview;
import com.taboola.backstage.model.media.campaigns.items.ItemApprovalState;
import com.taboola.backstage.model.media.campaigns.items.ItemStatus;
import com.taboola.rest.api.annotations.ReadOnly;
import com.taboola.rest.api.annotations.Required;

import java.io.File;
import java.util.Objects;

/**
 * Performance video item object.
 *
 * Created by Gabriel Diaz, 09/02/2020.
 */
public class PerformanceVideoItem {

    @ReadOnly
    protected String id;
    @ReadOnly
    protected String campaignId;
    @Required
    protected String url;
    @Required
    protected String title;
    @ReadOnly
    protected ItemApprovalState approvalState;
    protected Boolean isActive;
    @ReadOnly
    protected ItemStatus status;
    @ReadOnly
    protected CampaignItemPolicyReview policyReview;
    protected String videoUrl;
    protected String fallbackUrl;
    protected String gifUrl;

    protected File videoFile;
    protected File fallbackFile;

    public String getId() {
        return id;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public ItemApprovalState getApprovalState() {
        return approvalState;
    }

    public Boolean getActive() {
        return isActive;
    }

    public ItemStatus getStatus() {
        return status;
    }

    public CampaignItemPolicyReview getPolicyReview() {
        return policyReview;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public String getFallbackUrl() {
        return fallbackUrl;
    }

    public String getGifUrl() {
        return gifUrl;
    }

    public File getVideoFile() {
        return videoFile;
    }

    public File getFallbackFile() {
        return fallbackFile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PerformanceVideoItem that = (PerformanceVideoItem) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(campaignId, that.campaignId) &&
                Objects.equals(url, that.url) &&
                Objects.equals(title, that.title) &&
                approvalState == that.approvalState &&
                Objects.equals(isActive, that.isActive) &&
                status == that.status &&
                Objects.equals(policyReview, that.policyReview) &&
                Objects.equals(videoUrl, that.videoUrl) &&
                Objects.equals(fallbackUrl, that.fallbackUrl) &&
                Objects.equals(gifUrl, that.gifUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, campaignId, url, title, approvalState, isActive, status, policyReview, videoUrl, fallbackUrl, gifUrl);
    }

    @Override
    public String toString() {
        return "PerformanceVideoItem{" +
                "id='" + id + '\'' +
                ", campaignId='" + campaignId + '\'' +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", approvalState=" + approvalState +
                ", isActive=" + isActive +
                ", status=" + status +
                ", policyReview=" + policyReview +
                ", videoUrl='" + videoUrl + '\'' +
                ", fallbackUrl='" + fallbackUrl + '\'' +
                ", gifUrl='" + gifUrl + '\'' +
                '}';
    }

}
