package com.taboola.backstage.model.tracking;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Marcelo Dias on 08/30/2024.
 */
public class ConversionAction {
    @JsonProperty("click-id")
    private String clickId;
    private String name;
    private Long timestamp;
    private Float revenue;
    private String currency;
    private Integer quantity;

    public String getClickId() {
        return clickId;
    }

    public void setClickId(String clickId) {
        this.clickId = clickId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Float getRevenue() {
        return revenue;
    }

    public void setRevenue(Float revenue) {
        this.revenue = revenue;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
