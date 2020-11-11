package com.taboola.backstage.model.media.campaigns.items;

import java.util.Objects;

/**
 * Created by vladi.m
 * Date 11/11/2020
 * Time 9:52
 * Copyright Taboola
 */
public class CampaignItemCTA {
    private CtaType ctaType;

    public CtaType getCtaType() {
        return ctaType;
    }

    public void setCtaType(CtaType ctaType) {
        this.ctaType = ctaType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CampaignItemCTA that = (CampaignItemCTA) o;
        return Objects.equals(ctaType, that.ctaType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ctaType);
    }

    @Override
    public String toString() {
        return "CampaignItemCTA{" +
                "ctaType=" + ctaType +
                '}';
    }
}
