package com.taboola.backstage.model.media.reports;

import com.taboola.backstage.model.dynamic.DynamicFields;
import com.taboola.backstage.model.dynamic.DynamicRow;

import java.util.Objects;

/**
 * Created by vladi
 * Date: 12/7/2017
 * Time: 10:10 PM
 * By Taboola
 */
public class CampaignRealtimeSummaryRow implements DynamicRow {

    private Integer visibleImpressions;
    private Double conversionsValue;
    private Double vctr;
    private Integer clicks;
    private Double cpc;
    private Double vcpm;
    private Double cpa;
    private Integer cpaActionsNum;
    private Double spent;
    private Long campaignId;
    private String campaignName;
    private Double roas;

    // dynamic
    private DynamicFields dynamicFields;

    public Integer getVisibleImpressions() {
        return visibleImpressions;
    }

    public void setVisibleImpressions(Integer visibleImpressions) {
        this.visibleImpressions = visibleImpressions;
    }

    public Double getConversionsValue() {
        return conversionsValue;
    }

    public void setConversionsValue(Double conversionsValue) {
        this.conversionsValue = conversionsValue;
    }

    public Double getVctr() {
        return vctr;
    }

    public void setVctr(Double vctr) {
        this.vctr = vctr;
    }

    public Integer getClicks() {
        return clicks;
    }

    public void setClicks(Integer clicks) {
        this.clicks = clicks;
    }

    public Double getCpc() {
        return cpc;
    }

    public void setCpc(Double cpc) {
        this.cpc = cpc;
    }

    public Double getVcpm() {
        return vcpm;
    }

    public void setVcpm(Double vcpm) {
        this.vcpm = vcpm;
    }

    public Double getCpa() {
        return cpa;
    }

    public void setCpa(Double cpa) {
        this.cpa = cpa;
    }

    public Integer getCpaActionsNum() {
        return cpaActionsNum;
    }

    public void setCpaActionsNum(Integer cpaActionsNum) {
        this.cpaActionsNum = cpaActionsNum;
    }

    public Double getSpent() {
        return spent;
    }

    public void setSpent(Double spent) {
        this.spent = spent;
    }

    public Long getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(Long campaignId) {
        this.campaignId = campaignId;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public Double getRoas() {
        return roas;
    }

    public void setRoas(Double roas) {
        this.roas = roas;
    }

    @Override
    public DynamicFields getDynamicFields() {
        return dynamicFields;
    }

    public void setDynamicFields(DynamicFields dynamicFields) {
        this.dynamicFields = dynamicFields;
    }

    @Override
    public String toString() {
        return "CampaignRealtimeSummaryRow{" +
            "visibleImpressions=" + visibleImpressions +
            ", conversionsValue=" + conversionsValue +
            ", vctr=" + vctr +
            ", clicks=" + clicks +
            ", cpc=" + cpc +
            ", vcpm=" + vcpm +
            ", cpa=" + cpa +
            ", cpaActionsNum=" + cpaActionsNum +
            ", spent=" + spent +
            ", campaignId=" + campaignId +
            ", campaignName='" + campaignName + '\'' +
            ", roas=" + roas +
            ", dynamicFields=" + dynamicFields +
            '}';
    }

}
