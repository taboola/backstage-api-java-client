package com.taboola.backstage.model.dictionary;

import java.util.Map;

/**
 * Created by vladi.m
 * Date 04/05/2020
 * Time 22:54
 * Copyright Taboola
 */
public class LookalikeAudience {
    private Long ruleId;
    private String audienceName;
    private Map<Integer, Long> similarityLevelToSize;

    public Long getRuleId() {
        return ruleId;
    }

    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }

    public String getAudienceName() {
        return audienceName;
    }

    public void setAudienceName(String audienceName) {
        this.audienceName = audienceName;
    }

    public Map<Integer, Long> getSimilarityLevelToSize() {
        return similarityLevelToSize;
    }

    public void setSimilarityLevelToSize(Map<Integer, Long> similarityLevelToSize) {
        this.similarityLevelToSize = similarityLevelToSize;
    }

    @Override
    public String toString() {
        return "LookalikeAudience{" +
                "ruleId=" + ruleId +
                ", audienceName='" + audienceName + '\'' +
                ", similarityLevelToSize=" + similarityLevelToSize +
                '}';
    }
}
