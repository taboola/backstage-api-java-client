package com.taboola.backstage.model.media.campaigns.items;

import java.util.Objects;

/**
 * Created by vladi
 * Date: 9/12/2017
 * Time: 11:22 PM
 * By Taboola
 */
public class CampaignItem {

    private String id;
    private String campaignId;
    private ItemType type;
    private String url;
    private String thumbnailUrl;
    private String title;
    private ItemApprovalState approvalState;
    private Boolean isActive;
    private ItemStatus status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ItemApprovalState getApprovalState() {
        return approvalState;
    }

    public void setApprovalState(ItemApprovalState approvalState) {
        this.approvalState = approvalState;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }

    public ItemStatus getStatus() {
        return status;
    }

    public void setStatus(ItemStatus status) {
        this.status = status;
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
