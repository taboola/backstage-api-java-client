package com.taboola.backstage.model.media.campaigns;

import java.time.LocalDate;

public class CampaignsGroup {

    private Long id;
    private String name;
    private String status;
    private LocalDate startDate;
    private LocalDate endDate;
    private SpendingLimitModel spendingLimitModel;
    private Double spendingLimit;
    private Double dailyCap;
    private String accountId;
    private String groupType;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public SpendingLimitModel getSpendingLimitModel() {
        return spendingLimitModel;
    }

    public void setSpendingLimitModel(SpendingLimitModel spendingLimitModel) {
        this.spendingLimitModel = spendingLimitModel;
    }

    public Double getSpendingLimit() {
        return spendingLimit;
    }

    public void setSpendingLimit(Double spendingLimit) {
        this.spendingLimit = spendingLimit;
    }

    public Double getDailyCap() {
        return dailyCap;
    }

    public void setDailyCap(Double dailyCap) {
        this.dailyCap = dailyCap;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    @Override
    public String toString() {
        return "CampaignsGroup{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", status='" + status + '\'' +
            ", startDate=" + startDate +
            ", endDate=" + endDate +
            ", spendingLimitModel=" + spendingLimitModel +
            ", spendingLimit=" + spendingLimit +
            ", dailyCap=" + dailyCap +
            ", accountId='" + accountId + '\'' +
            ", groupType='" + groupType + '\'' +
            '}';
    }
}
