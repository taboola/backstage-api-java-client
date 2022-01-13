package com.taboola.backstage.model.media.campaigns;

public class CampaignsGroup {

    private SharedBudgetBase sharedBudget;

    public SharedBudgetBase getSharedBudget() {
        return sharedBudget;
    }

    public void setSharedBudget(SharedBudgetBase sharedBudget) {
        this.sharedBudget = sharedBudget;
    }

    @Override
    public String toString() {
        return "CampaignsGroup{" +
                "sharedBudget=" + sharedBudget +
                '}';
    }
}
