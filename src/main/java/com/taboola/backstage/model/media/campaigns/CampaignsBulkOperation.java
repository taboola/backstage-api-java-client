package com.taboola.backstage.model.media.campaigns;

import java.util.List;

public class CampaignsBulkOperation {
    private List<Long> campaigns;
    private List<String> orderIds;
    private Campaign update;

    private CampaignsBulkOperation() { }

    public static CampaignsBulkOperation create() {
        return new CampaignsBulkOperation();
    }

    public List<Long> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<Long> campaigns) {
        this.campaigns = campaigns;
    }

    public List<String> getOrderIds() {
        return orderIds;
    }

    public void setOrderIds(List<String> orderIds) {
        this.orderIds = orderIds;
    }

    public Campaign getUpdate() {
        return update;
    }

    public void setUpdate(CampaignOperation update) {
        this.update = update;
    }

    @Override
    public String toString() {
        return "CampaignsBulkOperation{" +
                "campaigns=" + campaigns +
                ", orderIds=" + orderIds +
                ", update=" + update +
                '}';
    }
}
