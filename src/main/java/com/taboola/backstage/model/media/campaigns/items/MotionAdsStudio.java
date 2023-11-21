package com.taboola.backstage.model.media.campaigns.items;

/**
 * Created by vladi.m
 * Date 13/11/2023
 * Time 21:15
 * Copyright Taboola
 */
public class MotionAdsStudio {
    private String vendorTemplateType;
    private String vendorVideoId;

    public String getVendorTemplateType() {
        return vendorTemplateType;
    }

    public void setVendorTemplateType(String vendorTemplateType) {
        this.vendorTemplateType = vendorTemplateType;
    }

    public String getVendorVideoId() {
        return vendorVideoId;
    }

    public void setVendorVideoId(String vendorVideoId) {
        this.vendorVideoId = vendorVideoId;
    }

    @Override
    public String toString() {
        return "MotionAdsStudio{" +
                "vendorTemplateType='" + vendorTemplateType + '\'' +
                ", vendorVideoId='" + vendorVideoId + '\'' +
                '}';
    }
}
