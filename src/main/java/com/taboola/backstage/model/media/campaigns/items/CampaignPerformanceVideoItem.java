package com.taboola.backstage.model.media.campaigns.items;

import com.taboola.backstage.model.media.campaigns.verifications.VerificationPixel;
import com.taboola.backstage.model.media.campaigns.viewability.ViewabilityTag;
import com.taboola.rest.api.annotations.ReadOnly;

/**
 * Created by vladi.m
 * Date 13/11/2023
 * Time 21:07
 * Copyright Taboola
 */
public class CampaignPerformanceVideoItem {
    @ReadOnly
    protected String id;
    protected String campaignId;
    protected String url;
    protected String title;
    protected String description;
    @ReadOnly
    protected ItemApprovalState approvalState;
    protected Boolean isActive;
    @ReadOnly
    protected ItemStatus status;
    @ReadOnly
    protected CampaignItemPolicyReview policyReview;
    protected String fallbackUrl;
    protected String gifUrl;
    protected String videoUrl;
    protected CampaignItemCTA cta;
    protected String recommendedFBImage;
    protected VerificationPixel verificationPixel;
    protected ViewabilityTag viewabilityTag;
    protected MediaUploadSource mediaUploadSource;
    protected MotionAdsStudio motionAdsStudio;
    protected CampaignItemAppInstall appInstall;
    protected CampaignItemRating rating;
    protected CampaignItemLogo logo;
    protected CampaignItemDisclaimer disclaimer;
    protected String brandingText;

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

    public String getDescription() {
        return description;
    }

    public ItemApprovalState getApprovalState() {
        return approvalState;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public ItemStatus getStatus() {
        return status;
    }

    public CampaignItemPolicyReview getPolicyReview() {
        return policyReview;
    }

    public String getFallbackUrl() {
        return fallbackUrl;
    }

    public String getGifUrl() {
        return gifUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public CampaignItemCTA getCta() {
        return cta;
    }

    public String getRecommendedFBImage() {
        return recommendedFBImage;
    }

    public VerificationPixel getVerificationPixel() {
        return verificationPixel;
    }

    public ViewabilityTag getViewabilityTag() {
        return viewabilityTag;
    }

    public MediaUploadSource getMediaUploadSource() {
        return mediaUploadSource;
    }

    public MotionAdsStudio getMotionAdsStudio() {
        return motionAdsStudio;
    }

    public CampaignItemAppInstall getAppInstall() {
        return appInstall;
    }

    public CampaignItemRating getRating() {
        return rating;
    }

    public CampaignItemLogo getLogo() {
        return logo;
    }

    public CampaignItemDisclaimer getDisclaimer() {
        return disclaimer;
    }

    public String getBrandingText() {
        return brandingText;
    }

    @Override
    public String toString() {
        return "CampaignPerformanceVideoItem{" +
                "id='" + id + '\'' +
                ", campaignId='" + campaignId + '\'' +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", approvalState=" + approvalState +
                ", isActive=" + isActive +
                ", status=" + status +
                ", policyReview=" + policyReview +
                ", fallbackUrl='" + fallbackUrl + '\'' +
                ", gifUrl='" + gifUrl + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", cta=" + cta +
                ", recommendedFBImage='" + recommendedFBImage + '\'' +
                ", verificationPixel=" + verificationPixel +
                ", viewabilityTag=" + viewabilityTag +
                ", mediaUploadSource=" + mediaUploadSource +
                ", motionAdsStudio=" + motionAdsStudio +
                ", appInstall=" + appInstall +
                ", rating=" + rating +
                ", logo=" + logo +
                ", disclaimer=" + disclaimer +
                ", brandingText='" + brandingText + '\'' +
                '}';
    }
}
