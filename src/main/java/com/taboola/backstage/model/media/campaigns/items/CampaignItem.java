package com.taboola.backstage.model.media.campaigns.items;

import com.taboola.backstage.model.media.campaigns.verifications.VerificationPixel;
import com.taboola.backstage.model.media.campaigns.viewability.ViewabilityTag;
import com.taboola.backstage.model.metadata.ExternalMetadata;
import com.taboola.rest.api.annotations.ReadOnly;
import com.taboola.rest.api.annotations.Required;

import java.util.Objects;

/**
 * Created by vladi
 * Date: 9/12/2017
 * Time: 11:22 PM
 * By Taboola
 */
public class CampaignItem {

    @ReadOnly
    protected String id;
    @ReadOnly
    protected String campaignId;
    @ReadOnly
    protected ItemType type;
    @Required
    protected String url;
    protected String thumbnailUrl;
    protected String title;
    @ReadOnly
    protected ItemApprovalState approvalState;
    protected Boolean isActive;
    @ReadOnly
    protected ItemStatus status;
    protected String description;
    @ReadOnly
    protected CampaignItemPolicyReview policyReview;
    protected CampaignItemCTA cta;
    protected CampaignItemCreativeFocus creativeFocus;
    protected VerificationPixel verificationPixel;
    protected ViewabilityTag viewabilityTag;
    @ReadOnly
    protected CampaignItemsLearningState learningState;
    protected CampaignItemAppInstall appInstall;
    protected CampaignItemRating rating;
    protected CampaignItemLogo logo;
    protected CampaignItemDisclaimer disclaimer;
    protected ExternalMetadata externalMetadata;
    protected CustomData customData;

    public String getId() {
        return id;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public ItemType getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public String getTitle() {
        return title;
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

    public String getDescription() {
        return description;
    }

    public CampaignItemPolicyReview getPolicyReview() {
        return policyReview;
    }

    public CampaignItemCTA getCta() {
        return cta;
    }

    public CampaignItemCreativeFocus getCreativeFocus() {
        return creativeFocus;
    }

    public VerificationPixel getVerificationPixel() {
        return verificationPixel;
    }

    public ViewabilityTag getViewabilityTag() {
        return viewabilityTag;
    }

    public CampaignItemsLearningState getLearningState() {
        return learningState;
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

    public ExternalMetadata getExternalMetadata() {
        return externalMetadata;
    }

    public CampaignItemDisclaimer getDisclaimer() {
        return disclaimer;
    }

    public CustomData getCustomData() {
        return customData;
    }

    public void setCustomData(CustomData customData) {
        this.customData = customData;
    }

    @Override
    public String toString() {
        return "CampaignItem{" +
                "id='" + id + '\'' +
                ", campaignId='" + campaignId + '\'' +
                ", type=" + type +
                ", url='" + url + '\'' +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                ", title='" + title + '\'' +
                ", approvalState=" + approvalState +
                ", isActive=" + isActive +
                ", status=" + status +
                ", description='" + description + '\'' +
                ", policyReview=" + policyReview +
                ", cta=" + cta +
                ", creativeFocus=" + creativeFocus +
                ", verificationPixel=" + verificationPixel +
                ", viewabilityTag=" + viewabilityTag +
                ", learningState=" + learningState +
                ", appInstall=" + appInstall +
                ", rating=" + rating +
                ", logo=" + logo +
                ", disclaimer=" + disclaimer +
                ", externalMetadata=" + externalMetadata +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CampaignItem that = (CampaignItem) o;
        return Objects.equals(id, that.id) && Objects.equals(campaignId, that.campaignId) && type == that.type && Objects.equals(url, that.url) && Objects.equals(thumbnailUrl, that.thumbnailUrl) && Objects.equals(title, that.title) && approvalState == that.approvalState && Objects.equals(isActive, that.isActive) && status == that.status && Objects.equals(description, that.description) && Objects.equals(policyReview, that.policyReview) && Objects.equals(cta, that.cta) && Objects.equals(creativeFocus, that.creativeFocus) && Objects.equals(verificationPixel, that.verificationPixel) && Objects.equals(viewabilityTag, that.viewabilityTag) && learningState == that.learningState && Objects.equals(appInstall, that.appInstall) && Objects.equals(rating, that.rating) && Objects.equals(logo, that.logo) && Objects.equals(disclaimer, that.disclaimer) && Objects.equals(externalMetadata, that.externalMetadata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, campaignId, type, url, thumbnailUrl, title, approvalState, isActive, status, description, policyReview, cta, creativeFocus, verificationPixel, viewabilityTag, learningState, appInstall, rating, logo, disclaimer, externalMetadata);
    }
}
