package com.taboola.backstage.model.media.campaigns.items;

/**
 * Created by vladi
 * Date: 1/19/2018
 * Time: 10:48 PM
 * By Taboola
 */
public class CampaignItemOperation extends CampaignItem {

    private CampaignItemOperation() { }

    public static CampaignItemOperation create() {
        return new CampaignItemOperation();
    }

    public CampaignItemOperation setUrl(String url) {
        this.url = url;
        return this;
    }

    public CampaignItemOperation setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
        return this;
    }

    public CampaignItemOperation setTitle(String title) {
        this.title = title;
        return this;
    }

    public CampaignItemOperation setActive(Boolean active) {
        this.isActive = active;
        return this;
    }
}
