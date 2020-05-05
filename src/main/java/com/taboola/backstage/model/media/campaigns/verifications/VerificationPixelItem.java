package com.taboola.backstage.model.media.campaigns.verifications;

/**
 * Created by vladi.m
 * Date 16/04/2020
 * Time 13:06
 * Copyright Taboola
 */
public class VerificationPixelItem {
    private String url;
    private VerificationPixelEventType verificationPixelType;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public VerificationPixelEventType getVerificationPixelType() {
        return verificationPixelType;
    }

    public void setVerificationPixelType(VerificationPixelEventType verificationPixelType) {
        this.verificationPixelType = verificationPixelType;
    }

    @Override
    public String toString() {
        return "VerificationPixelItem{" +
                "url='" + url + '\'' +
                ", verificationPixelType=" + verificationPixelType +
                '}';
    }
}
