package com.taboola.backstage.model.media.campaigns.items;

import java.util.Objects;

/**
 * Created by vladi.m
 * Date 12/11/2023
 * Time 23:06
 * Copyright Taboola
 */
public class CampaignItemLogo {
    private String logo;
    private String position;

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CampaignItemLogo that = (CampaignItemLogo) o;
        return Objects.equals(logo, that.logo) && Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(logo, position);
    }

    @Override
    public String toString() {
        return "CampaignItemLogo{" +
                "logo='" + logo + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
