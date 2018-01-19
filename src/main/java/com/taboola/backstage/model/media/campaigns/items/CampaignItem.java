package com.taboola.backstage.model.media.campaigns.items;

import com.taboola.backstage.annotations.ReadOnly;
import com.taboola.backstage.annotations.Required;

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

    @Override
    public String toString() {
        return "CampaignItem{" +
        "id='" + id + '\'' +
        ", campaignId='" + campaignId + '\'' +
        ", type='" + type + '\'' +
        ", url='" + url + '\'' +
        ", thumbnailUrl='" + thumbnailUrl + '\'' +
        ", title='" + title + '\'' +
        ", approvalState='" + approvalState + '\'' +
        ", isActive=" + isActive +
        ", status='" + status + '\'' +
        '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CampaignItem that = (CampaignItem) o;
        return Objects.equals(id, that.id) &&
        Objects.equals(campaignId, that.campaignId) &&
        Objects.equals(type, that.type) &&
        Objects.equals(url, that.url) &&
        Objects.equals(thumbnailUrl, that.thumbnailUrl) &&
        Objects.equals(title, that.title) &&
        Objects.equals(approvalState, that.approvalState) &&
        Objects.equals(isActive, that.isActive) &&
        Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, campaignId, type, url, thumbnailUrl, title, approvalState, isActive, status);
    }
}
