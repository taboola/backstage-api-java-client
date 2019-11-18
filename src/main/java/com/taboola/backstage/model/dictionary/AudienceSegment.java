package com.taboola.backstage.model.dictionary;

import java.util.List;

/**
 * Created by vladi.m
 * Date 2019-08-12
 * Time 16:39
 * Copyright Taboola
 */
public class AudienceSegment {

    private Long taboolaAudienceId;
    private String dataPartner;
    private String dataPartnerAudienceId;
    private String dataPartnerGroup;
    private String audienceName;
    private List<String> allowedCountries;
    private List<String> taxonomyCategories;
    private Long audienceSize;

    public Long getTaboolaAudienceId() {
        return taboolaAudienceId;
    }

    public AudienceSegment setTaboolaAudienceId(Long taboolaAudienceId) {
        this.taboolaAudienceId = taboolaAudienceId;
        return this;
    }

    public String getDataPartner() {
        return dataPartner;
    }

    public AudienceSegment setDataPartner(String dataPartner) {
        this.dataPartner = dataPartner;
        return this;
    }

    public String getDataPartnerAudienceId() {
        return dataPartnerAudienceId;
    }

    public AudienceSegment setDataPartnerAudienceId(String dataPartnerAudienceId) {
        this.dataPartnerAudienceId = dataPartnerAudienceId;
        return this;
    }

    public String getAudienceName() {
        return audienceName;
    }

    public AudienceSegment setAudienceName(String audienceName) {
        this.audienceName = audienceName;
        return this;
    }

    public List<String> getAllowedCountries() {
        return allowedCountries;
    }

    public AudienceSegment setAllowedCountries(List<String> allowedCountries) {
        this.allowedCountries = allowedCountries;
        return this;
    }

    public String getDataPartnerGroup() {
        return dataPartnerGroup;
    }

    public void setDataPartnerGroup(String dataPartnerGroup) {
        this.dataPartnerGroup = dataPartnerGroup;
    }

    public List<String> getTaxonomyCategories() {
        return taxonomyCategories;
    }

    public void setTaxonomyCategories(List<String> taxonomyCategories) {
        this.taxonomyCategories = taxonomyCategories;
    }

    public Long getAudienceSize() {
        return audienceSize;
    }

    public void setAudienceSize(Long audienceSize) {
        this.audienceSize = audienceSize;
    }

    @Override
    public String toString() {
        return "AudienceSegment{" +
                "taboolaAudienceId=" + taboolaAudienceId +
                ", dataPartner='" + dataPartner + '\'' +
                ", dataPartnerAudienceId='" + dataPartnerAudienceId + '\'' +
                ", dataPartnerGroup='" + dataPartnerGroup + '\'' +
                ", audienceName='" + audienceName + '\'' +
                ", allowedCountries=" + allowedCountries +
                ", taxonomyCategories=" + taxonomyCategories +
                ", audienceSize=" + audienceSize +
                '}';
    }
}
