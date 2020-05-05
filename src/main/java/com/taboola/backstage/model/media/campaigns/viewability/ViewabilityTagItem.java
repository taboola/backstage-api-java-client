package com.taboola.backstage.model.media.campaigns.viewability;

/**
 * Created by vladi.m
 * Date 16/04/2020
 * Time 13:12
 * Copyright Taboola
 */
public class ViewabilityTagItem {
    private String tag;
    private ViewabilityTagType type;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public ViewabilityTagType getType() {
        return type;
    }

    public void setType(ViewabilityTagType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ViewabilityTagItem{" +
                "tag='" + tag + '\'' +
                ", type=" + type +
                '}';
    }
}
