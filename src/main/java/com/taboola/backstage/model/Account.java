package com.taboola.backstage.model;

import java.util.List;
import java.util.Objects;

/**
 * Created by vladi
 * Date: 10/16/2017
 * Time: 11:21 PM
 * By Taboola
 */
public class Account {

    private Long id;
    private String name;
    private String accountId;
    private AccountType type;
    private List<PartnerType> partnerTypes;
    private List<CampaignType> campaignTypes;

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

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public AccountType getType() { return type; }

    public void setType(AccountType type) { this.type = type; }

    public List<PartnerType> getPartnerTypes() {
        return partnerTypes;
    }

    public void setPartnerTypes(List<PartnerType> partnerTypes) {
        this.partnerTypes = partnerTypes;
    }

    public List<CampaignType> getCampaignTypes() {
        return campaignTypes;
    }

    public void setCampaignTypes(List<CampaignType> campaignTypes) {
        this.campaignTypes = campaignTypes;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", accountId='" + accountId + '\'' +
                ", type=" + type +
                ", partnerTypes=" + partnerTypes +
                ", campaignTypes=" + campaignTypes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) &&
                Objects.equals(name, account.name) &&
                Objects.equals(accountId, account.accountId) &&
                type == account.type &&
                Objects.equals(partnerTypes, account.partnerTypes) &&
                Objects.equals(campaignTypes, account.campaignTypes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, accountId, type, partnerTypes, campaignTypes);
    }
}
