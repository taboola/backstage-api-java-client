package com.taboola.backstage.model.media.campaigns;

import java.util.List;

/**
 * Created by vladi
 * Date: 9/29/2017
 * Time: 10:34 PM
 * By Taboola
 */
public class CampaignTargeting {

    private Type type;
    private List<String> value;
    private String href;

    public enum Type {
        INCLUDE,
        EXCLUDE,
        ALL
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<String> getValue() {
        return value;
    }

    public void setValue(List<String> value) {
        this.value = value;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
