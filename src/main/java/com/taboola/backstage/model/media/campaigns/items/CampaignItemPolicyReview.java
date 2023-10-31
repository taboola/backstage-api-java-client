package com.taboola.backstage.model.media.campaigns.items;

import java.util.Objects;

import com.taboola.rest.api.annotations.ReadOnly;

/**
 * Created by vladi.m
 * Date 11/11/2020
 * Time 9:50
 * Copyright Taboola
 */
public class CampaignItemPolicyReview {

    @ReadOnly
    private String rejectReason;

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CampaignItemPolicyReview that = (CampaignItemPolicyReview) o;
        return Objects.equals(rejectReason, that.rejectReason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rejectReason);
    }

    @Override
    public String toString() {
        return "CampaignItemPolicyReview{" +
                "rejectReason='" + rejectReason + '\'' +
                '}';
    }
}
