package com.taboola.backstage.model.media.campaigns.viewability;

import java.util.List;

/**
 * Created by vladi.m
 * Date 16/04/2020
 * Time 13:11
 * Copyright Taboola
 */
public class ViewabilityTag {
    private List<ViewabilityTagItem> values;

    public List<ViewabilityTagItem> getValues() {
        return values;
    }

    public void setValues(List<ViewabilityTagItem> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "ViewabilityTag{" +
                "values=" + values +
                '}';
    }
}
