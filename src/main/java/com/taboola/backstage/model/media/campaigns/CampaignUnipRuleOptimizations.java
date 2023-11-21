package com.taboola.backstage.model.media.campaigns;

import java.util.List;

/**
 * Created by vladi.m
 * Date 13/11/2023
 * Time 9:38
 * Copyright Taboola
 */
public class CampaignUnipRuleOptimizations {
    private List<UnipRuleConfiguration> rules;

    public List<UnipRuleConfiguration> getRules() {
        return rules;
    }

    public void setRules(List<UnipRuleConfiguration> rules) {
        this.rules = rules;
    }

    @Override
    public String toString() {
        return "CampaignUnipRuleOptimizations{" +
                "rules=" + rules +
                '}';
    }
}
