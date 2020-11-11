package com.taboola.backstage.model.media.campaigns.items;

import java.util.Objects;

/**
 * Created by vladi.m
 * Date 11/11/2020
 * Time 9:53
 * Copyright Taboola
 */
public class CampaignItemCreativeFocus {
    private FocusType type;
    private FocusCoordinates coordinates;

    public FocusType getType() {
        return type;
    }

    public void setType(FocusType type) {
        this.type = type;
    }

    public FocusCoordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(FocusCoordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CampaignItemCreativeFocus that = (CampaignItemCreativeFocus) o;
        return type == that.type &&
                Objects.equals(coordinates, that.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, coordinates);
    }

    @Override
    public String toString() {
        return "CampaignItemCreativeFocus{" +
                "type=" + type +
                ", coordinates=" + coordinates +
                '}';
    }
}
