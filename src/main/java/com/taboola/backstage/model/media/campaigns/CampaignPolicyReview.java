package com.taboola.backstage.model.media.campaigns;

import com.taboola.backstage.annotations.ReadOnly;

/**
 * Created by vladi.m
 * Date 16/04/2020
 * Time 13:14
 * Copyright Taboola
 */
public class CampaignPolicyReview {
    @ReadOnly
    private String rejectReason;

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    @Override
    public String toString() {
        return "CampaignPolicyReview{" +
                "rejectReason='" + rejectReason + '\'' +
                '}';
    }
}
