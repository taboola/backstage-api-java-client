package com.taboola.backstage.model.media.campaigns.items;

/**
 * Created by vladi.m
 * Date 13/11/2023
 * Time 21:11
 * Copyright Taboola
 */
public class CampaignItemDisclaimer {
    private String disclaimerUrl;

    public String getDisclaimerUrl() {
        return disclaimerUrl;
    }

    public void setDisclaimerUrl(String disclaimerUrl) {
        this.disclaimerUrl = disclaimerUrl;
    }

    @Override
    public String toString() {
        return "CampaignItemDisclaimer{" +
                "disclaimerUrl='" + disclaimerUrl + '\'' +
                '}';
    }
}
