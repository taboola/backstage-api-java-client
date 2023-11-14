package com.taboola.backstage.model.media.campaigns;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by vladi.m
 * Date 13/11/2023
 * Time 9:38
 * Copyright Taboola
 */
public class AttributionConfig {
    private Integer lookBackWindowInMinutes;
    private Integer vtaLookBackWindowInMinutes;
    private AggregationType aggregationType;

    public Integer getLookBackWindowInMinutes() {
        return lookBackWindowInMinutes;
    }

    public void setLookBackWindowInMinutes(Integer lookBackWindowInMinutes) {
        this.lookBackWindowInMinutes = lookBackWindowInMinutes;
    }

    public Integer getVtaLookBackWindowInMinutes() {
        return vtaLookBackWindowInMinutes;
    }

    public void setVtaLookBackWindowInMinutes(Integer vtaLookBackWindowInMinutes) {
        this.vtaLookBackWindowInMinutes = vtaLookBackWindowInMinutes;
    }

    public AggregationType getAggregationType() {
        return aggregationType;
    }

    public void setAggregationType(AggregationType aggregationType) {
        this.aggregationType = aggregationType;
    }

    @Override
    public String toString() {
        return "AttributionConfig{" +
                "lookBackWindowInMinutes=" + lookBackWindowInMinutes +
                ", vtaLookBackWindowInMinutes=" + vtaLookBackWindowInMinutes +
                ", aggregationType=" + aggregationType +
                '}';
    }
}
