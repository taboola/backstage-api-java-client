package com.taboola.backstage.model.media.campaigns;

import java.util.Collection;
import java.util.Date;

public class SharedBudgetOperation extends SharedBudget {

    private SharedBudgetOperation() { }

    public static SharedBudgetOperation create() {
        return new SharedBudgetOperation();
    }

    public SharedBudgetOperation setName(String name) {
        this.name = name;
        return this;
    }

    public SharedBudgetOperation setMarketingObjective(MarketingObjective marketingObjective) {
        this.marketingObjective = marketingObjective;
        return this;
    }

    public SharedBudgetOperation setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public SharedBudgetOperation setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public SharedBudgetOperation setSpendingLimitModel(SpendingLimitModel spendingLimitModel) {
        this.spendingLimitModel = spendingLimitModel;
        return this;
    }

    public SharedBudgetOperation setSpendingLimit(Double spendingLimit) {
        this.spendingLimit = spendingLimit;
        return this;
    }

    public SharedBudgetOperation setDailyCap(Double dailyCap) {
        this.dailyCap = dailyCap;
        return this;
    }

    public SharedBudgetOperation setDailyAdDeliveryModel(DailyAdDeliveryModel dailyAdDeliveryModel) {
        this.dailyAdDeliveryModel = dailyAdDeliveryModel;
        return this;
    }

    public SharedBudgetOperation setIsActive(Boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    public SharedBudgetOperation setCampaigns(Collection<SharedBudgetCampaign> campaigns) {
        this.campaigns = campaigns;
        return this;
    }
}
