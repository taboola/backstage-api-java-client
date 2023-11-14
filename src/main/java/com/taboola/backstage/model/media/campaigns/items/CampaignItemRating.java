package com.taboola.backstage.model.media.campaigns.items;

import java.util.Objects;

/**
 * Created by vladi.m
 * Date 12/11/2023
 * Time 23:06
 * Copyright Taboola
 */
public class CampaignItemRating {
    private Double rating;

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CampaignItemRating that = (CampaignItemRating) o;
        return Objects.equals(rating, that.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rating);
    }

    @Override
    public String toString() {
        return "CampaignItemRating{" +
                "rating=" + rating +
                '}';
    }
}
