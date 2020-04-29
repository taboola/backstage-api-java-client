package com.taboola.backstage.model.media.campaigns;

/**
 * Created by vladi.m
 * Date 16/04/2020
 * Time 12:57
 * Copyright Taboola
 */
public class CampaignLookalikeAudienceTargeting {
    private Long ruleId;
    private Integer similarityLevel;

    public Long getRuleId() {
        return ruleId;
    }

    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }

    public Integer getSimilarityLevel() {
        return similarityLevel;
    }

    public void setSimilarityLevel(Integer similarityLevel) {
        this.similarityLevel = similarityLevel;
    }

    @Override
    public String toString() {
        return "LookalikeAudienceTargeting{" +
                "ruleId=" + ruleId +
                ", similarityLevel=" + similarityLevel +
                '}';
    }
}
