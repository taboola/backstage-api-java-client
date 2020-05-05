package com.taboola.backstage.model.media.campaigns.brandsafety;

/**
 * Created by vladi.m
 * Date 16/04/2020
 * Time 13:03
 * Copyright Taboola
 */
public class ExternalBrandSafetyItem {
    private String categoryName;
    private ExternalBrandSafetyRiskLevel riskLevel;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public ExternalBrandSafetyRiskLevel getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(ExternalBrandSafetyRiskLevel riskLevel) {
        this.riskLevel = riskLevel;
    }

    @Override
    public String toString() {
        return "ExternalBrandSafetyItem{" +
                "categoryName='" + categoryName + '\'' +
                ", riskLevel=" + riskLevel +
                '}';
    }
}
