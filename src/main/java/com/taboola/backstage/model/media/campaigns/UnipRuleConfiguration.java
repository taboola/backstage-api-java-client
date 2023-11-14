package com.taboola.backstage.model.media.campaigns;

import com.taboola.rest.api.annotations.ReadOnly;

/**
 * Created by vladi.m
 * Date 13/11/2023
 * Time 9:38
 * Copyright Taboola
 */
public class UnipRuleConfiguration {
    private Long id;
    @ReadOnly
    private String displayName;
    @ReadOnly
    private UnipRuleStatus status;
    @ReadOnly
    private Boolean includeInTotalConversions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public UnipRuleStatus getStatus() {
        return status;
    }

    public void setStatus(UnipRuleStatus status) {
        this.status = status;
    }

    public Boolean getIncludeInTotalConversions() {
        return includeInTotalConversions;
    }

    public void setIncludeInTotalConversions(Boolean includeInTotalConversions) {
        this.includeInTotalConversions = includeInTotalConversions;
    }

    @Override
    public String toString() {
        return "UnipRuleConfiguration{" +
                "id=" + id +
                ", displayName='" + displayName + '\'' +
                ", status=" + status +
                ", includeInTotalConversions=" + includeInTotalConversions +
                '}';
    }
}
