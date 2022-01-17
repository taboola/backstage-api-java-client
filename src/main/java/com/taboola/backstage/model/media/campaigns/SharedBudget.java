package com.taboola.backstage.model.media.campaigns;

import java.util.Collection;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.taboola.rest.api.annotations.ReadOnly;
import com.taboola.rest.api.annotations.Required;

public class SharedBudget {

    @ReadOnly
    protected Long id;
    @Required
    protected String name;
    @ReadOnly
    protected String status;
    @Required
    protected MarketingObjective marketingObjective;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    protected Date startDate;
    @ReadOnly
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    protected Date startDateInUtc;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    protected Date endDate;
    @ReadOnly
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    protected Date endDateInUtc;
    @Required
    protected SpendingLimitModel spendingLimitModel;
    @Required
    protected Double spendingLimit;
    protected Double dailyCap;
    protected DailyAdDeliveryModel dailyAdDeliveryModel;
    protected Boolean isActive;
    protected Collection<SharedBudgetCampaign> campaigns;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public MarketingObjective getMarketingObjective() {
        return marketingObjective;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getStartDateInUtc() {
        return startDateInUtc;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Date getEndDateInUtc() {
        return endDateInUtc;
    }

    public SpendingLimitModel getSpendingLimitModel() {
        return spendingLimitModel;
    }

    public Double getSpendingLimit() {
        return spendingLimit;
    }

    public Double getDailyCap() {
        return dailyCap;
    }

    public DailyAdDeliveryModel getDailyAdDeliveryModel() {
        return dailyAdDeliveryModel;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public Collection<SharedBudgetCampaign> getCampaigns() {
        return campaigns;
    }

    @Override
    public String toString() {
        return "SharedBudget{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", marketingObjective=" + marketingObjective +
                ", startDate=" + startDate +
                ", startDateInUtc=" + startDateInUtc +
                ", endDate=" + endDate +
                ", endDateInUtc=" + endDateInUtc +
                ", spendingLimitModel=" + spendingLimitModel +
                ", spendingLimit=" + spendingLimit +
                ", dailyCap=" + dailyCap +
                ", dailyAdDeliveryModel=" + dailyAdDeliveryModel +
                ", isActive=" + isActive +
                ", campaigns=" + campaigns +
                '}';
    }
}
