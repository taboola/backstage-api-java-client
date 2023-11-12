package com.taboola.backstage.model.media.campaigns.items;

import java.util.Objects;

/**
 * Created by vladi.m
 * Date 12/11/2023
 * Time 23:05
 * Copyright Taboola
 */
public class CampaignItemAppInstall {
    private String downloads;
    private String appName;
    private String appUrl;
    private String uiVersion;

    public String getDownloads() {
        return downloads;
    }

    public void setDownloads(String downloads) {
        this.downloads = downloads;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    public String getUiVersion() {
        return uiVersion;
    }

    public void setUiVersion(String uiVersion) {
        this.uiVersion = uiVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CampaignItemAppInstall that = (CampaignItemAppInstall) o;
        return Objects.equals(downloads, that.downloads) && Objects.equals(appName, that.appName) && Objects.equals(appUrl, that.appUrl) && Objects.equals(uiVersion, that.uiVersion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(downloads, appName, appUrl, uiVersion);
    }

    @Override
    public String toString() {
        return "CampaignItemAppInstall{" +
                "downloads='" + downloads + '\'' +
                ", appName='" + appName + '\'' +
                ", appUrl='" + appUrl + '\'' +
                ", uiVersion='" + uiVersion + '\'' +
                '}';
    }
}
