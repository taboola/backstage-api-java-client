/*
 * Copyright 2023 InPowered. All Rights Reserved.
 *
 * This software is the proprietary information of InPowered.
 * Use is subject to license terms.
 */
package com.taboola.backstage.model.dictionary;

/**
 * @author Gabriel Diaz, 21/11/23.
 */
public class ContextualSegment {

    private Long id;
    private String provider;
    private String label;
    private String description;
    private String taxonomy;
    private String allowedCountries;
    private Long size;
    private Long articles;
    private Boolean isTargetable;
    private Boolean isBundle;
    private Boolean isActive;
    private String taxonomyLabel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTaxonomy() {
        return taxonomy;
    }

    public void setTaxonomy(String taxonomy) {
        this.taxonomy = taxonomy;
    }

    public String getAllowedCountries() {
        return allowedCountries;
    }

    public void setAllowedCountries(String allowedCountries) {
        this.allowedCountries = allowedCountries;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getArticles() {
        return articles;
    }

    public void setArticles(Long articles) {
        this.articles = articles;
    }

    private Boolean getIsTargetable() {
        return isTargetable;
    }

    public void setIsTargetable(Boolean isTargetable) {
        this.isTargetable = isTargetable;
    }

    public Boolean getIsBundle() {
        return isBundle;
    }

    public void setIsBundle(Boolean isBundle) {
        this.isBundle = isBundle;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getTaxonomyLabel() {
        return taxonomyLabel;
    }

    public void setTaxonomyLabel(String taxonomyLabel) {
        this.taxonomyLabel = taxonomyLabel;
    }
}
