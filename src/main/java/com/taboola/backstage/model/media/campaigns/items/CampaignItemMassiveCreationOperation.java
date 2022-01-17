package com.taboola.backstage.model.media.campaigns.items;

import java.util.List;

import com.taboola.rest.api.annotations.Required;

public class CampaignItemMassiveCreationOperation {
    @Required
    private List<Long> campaignIds;
    @Required
    private List<CampaignItemOperation> items;

    private CampaignItemMassiveCreationOperation() { }

    public static CampaignItemMassiveCreationOperation create() {
        return new CampaignItemMassiveCreationOperation();
    }

    public List<Long> getCampaignIds() {
        return campaignIds;
    }

    public void setCampaignIds(List<Long> campaignIds) {
        this.campaignIds = campaignIds;
    }

    public List<CampaignItemOperation> getItems() {
        return items;
    }

    public void setItems(List<CampaignItemOperation> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "CampaignItemMassiveCreationOperation{" +
                "campaignIds=" + campaignIds +
                ", items=" + items +
                '}';
    }
}
