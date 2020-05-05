package com.taboola.backstage.model.media.campaigns;

import java.util.List;

/**
 * Created by vladi.m
 * Date 16/04/2020
 * Time 12:59
 * Copyright Taboola
 */
public class BidStrategyModifiers {

    private List<BidStrategyPerAffiliate> values;

    public List<BidStrategyPerAffiliate> getValues() {
        return values;
    }

    public void setValues(List<BidStrategyPerAffiliate> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "BidStrategyModifiers{" +
                "values=" + values +
                '}';
    }
}
