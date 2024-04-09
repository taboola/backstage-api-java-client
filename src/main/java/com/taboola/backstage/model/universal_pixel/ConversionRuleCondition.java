/*
 * Copyright 2024 InPowered. All Rights Reserved.
 *
 * This software is the proprietary information of InPowered.
 * Use is subject to license terms.
 */
package com.taboola.backstage.model.universal_pixel;

import java.util.List;

/**
 * @author Gabriel Diaz, 9/04/24.
 */
public class ConversionRuleCondition {

    private String property;
    private String predicate;
    private String paramName;
    private String value;
    private List<ConversionRuleCondition> children;

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getPredicate() {
        return predicate;
    }

    public void setPredicate(String predicate) {
        this.predicate = predicate;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<ConversionRuleCondition> getChildren() {
        return children;
    }

    public void setChildren(List<ConversionRuleCondition> children) {
        this.children = children;
    }

}
