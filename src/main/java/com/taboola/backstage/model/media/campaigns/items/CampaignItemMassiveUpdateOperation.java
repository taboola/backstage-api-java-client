package com.taboola.backstage.model.media.campaigns.items;

import java.util.List;

public class CampaignItemMassiveUpdateOperation {
    private List<Long> itemsToUpdate;
    private CampaignItemOperation baselineItem;

    private CampaignItemMassiveUpdateOperation() { }

    public static CampaignItemMassiveUpdateOperation create() {
        return new CampaignItemMassiveUpdateOperation();
    }

    public List<Long> getItemsToUpdate() {
        return itemsToUpdate;
    }

    public void setItemsToUpdate(List<Long> itemsToUpdate) {
        this.itemsToUpdate = itemsToUpdate;
    }

    public CampaignItemOperation getBaselineItem() {
        return baselineItem;
    }

    public void setBaselineItem(CampaignItemOperation baselineItem) {
        this.baselineItem = baselineItem;
    }

    @Override
    public String toString() {
        return "CampaignItemMassiveUpdateOperation{" +
                "itemsToUpdate=" + itemsToUpdate +
                ", baselineItem=" + baselineItem +
                '}';
    }
}
