package com.taboola.backstage.model.media.campaigns.brandsafety;

import java.util.Collection;

/**
 * Created by vladi.m
 * Date 16/04/2020
 * Time 13:02
 * Copyright Taboola
 */
public class ExternalBrandSafety {
    private ExternalBrandSafetyProviderType type;
    private Collection<ExternalBrandSafetyItem> values;

    public ExternalBrandSafetyProviderType getType() {
        return type;
    }

    public void setType(ExternalBrandSafetyProviderType type) {
        this.type = type;
    }

    public Collection<ExternalBrandSafetyItem> getValues() {
        return values;
    }

    public void setValues(Collection<ExternalBrandSafetyItem> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "ExternalBrandSafety{" +
                "type=" + type +
                ", values=" + values +
                '}';
    }
}
