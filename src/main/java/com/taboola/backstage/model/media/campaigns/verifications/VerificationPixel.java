package com.taboola.backstage.model.media.campaigns.verifications;

import java.util.List;

/**
 * Created by vladi.m
 * Date 16/04/2020
 * Time 13:06
 * Copyright Taboola
 */
public class VerificationPixel {
    private List<VerificationPixelItem> verificationPixelItems;

    public List<VerificationPixelItem> getVerificationPixelItems() {
        return verificationPixelItems;
    }

    public void setVerificationPixelItems(List<VerificationPixelItem> verificationPixelItems) {
        this.verificationPixelItems = verificationPixelItems;
    }

    @Override
    public String toString() {
        return "VerificationPixel{" +
                "verificationPixelItems=" + verificationPixelItems +
                '}';
    }
}
