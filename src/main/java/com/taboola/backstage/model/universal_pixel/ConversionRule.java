/*
 * Copyright 2024 InPowered. All Rights Reserved.
 *
 * This software is the proprietary information of InPowered.
 * Use is subject to license terms.
 */
package com.taboola.backstage.model.universal_pixel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Gabriel Diaz, 9/04/24.
 */
public class ConversionRule {

    public enum Category {
        VIEW_CONTENT
    }

    public enum Type {
        EVENT_BASED
    }

    private Long id;
    private String displayName;
    private Integer lookBackWindow;
    private Integer viewThroughLookBackWindow;
    @JsonProperty("category")
    private String categoryValue;
    private String status;
    @JsonProperty("type")
    private String typeValue;
    private String eventName;
    private ConversionRuleCondition condition;
    private Boolean includeInTotalConversions;
    private Boolean includeInTotalValue;
    private String aggregationType;
    private Boolean excludeFromCampaigns;
    private String description;
    private String advertiserId;
    private List<ConversionRuleEffect> effects;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Integer getLookBackWindow() {
        return lookBackWindow;
    }

    public void setLookBackWindow(Integer lookBackWindow) {
        this.lookBackWindow = lookBackWindow;
    }

    public Integer getViewThroughLookBackWindow() {
        return viewThroughLookBackWindow;
    }

    public void setViewThroughLookBackWindow(Integer viewThroughLookBackWindow) {
        this.viewThroughLookBackWindow = viewThroughLookBackWindow;
    }

    public String getCategoryValue() {
        return categoryValue;
    }

    public void setCategoryValue(String categoryValue) {
        this.categoryValue = categoryValue;
    }

    @JsonIgnore
    public Category getCategory() {
        return Category.valueOf(categoryValue);
    }

    @JsonIgnore
    public void setCategory(Category category) {
        this.categoryValue = category.name();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTypeValue() {
        return typeValue;
    }

    public void setTypeValue(String typeValue) {
        this.typeValue = typeValue;
    }

    @JsonIgnore
    public Type getType() {
        return Type.valueOf(typeValue);
    }

    @JsonIgnore
    public void setType(Type type) {
        this.typeValue = type.name();
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public ConversionRuleCondition getCondition() {
        return condition;
    }

    public void setCondition(ConversionRuleCondition condition) {
        this.condition = condition;
    }

    public Boolean getIncludeInTotalConversions() {
        return includeInTotalConversions;
    }

    public void setIncludeInTotalConversions(Boolean includeInTotalConversions) {
        this.includeInTotalConversions = includeInTotalConversions;
    }

    public Boolean getIncludeInTotalValue() {
        return includeInTotalValue;
    }

    public void setIncludeInTotalValue(Boolean includeInTotalValue) {
        this.includeInTotalValue = includeInTotalValue;
    }

    public String getAggregationType() {
        return aggregationType;
    }

    public void setAggregationType(String aggregationType) {
        this.aggregationType = aggregationType;
    }

    public Boolean getExcludeFromCampaigns() {
        return excludeFromCampaigns;
    }

    public void setExcludeFromCampaigns(Boolean excludeFromCampaigns) {
        this.excludeFromCampaigns = excludeFromCampaigns;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdvertiserId() {
        return advertiserId;
    }

    public void setAdvertiserId(String advertiserId) {
        this.advertiserId = advertiserId;
    }

    public List<ConversionRuleEffect> getEffects() {
        return effects;
    }

    public void setEffects(List<ConversionRuleEffect> effects) {
        this.effects = effects;
    }

}
