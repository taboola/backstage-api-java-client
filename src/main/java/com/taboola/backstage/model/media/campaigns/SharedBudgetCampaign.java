package com.taboola.backstage.model.media.campaigns;

public class SharedBudgetCampaign {
    private Long id;
    private String name;
    private CampaignStatus status;
    private SharedBudgetCampaignAttribute<Double> spendingLimit;
    private SharedBudgetCampaignAttribute<Double> dailyCap;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CampaignStatus getStatus() {
        return status;
    }

    public void setStatus(CampaignStatus status) {
        this.status = status;
    }

    public SharedBudgetCampaignAttribute<Double> getSpendingLimit() {
        return spendingLimit;
    }

    public void setSpendingLimit(SharedBudgetCampaignAttribute<Double> spendingLimit) {
        this.spendingLimit = spendingLimit;
    }

    public SharedBudgetCampaignAttribute<Double> getDailyCap() {
        return dailyCap;
    }

    public void setDailyCap(SharedBudgetCampaignAttribute<Double> dailyCap) {
        this.dailyCap = dailyCap;
    }

    @Override
    public String toString() {
        return "SharedBudgetCampaign{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", spendingLimit=" + spendingLimit +
                ", dailyCap=" + dailyCap +
                '}';
    }
}
