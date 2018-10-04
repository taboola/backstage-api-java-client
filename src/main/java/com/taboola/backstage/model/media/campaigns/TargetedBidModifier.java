package com.taboola.backstage.model.media.campaigns;

/**
 * Created by vladi
 * Date: 9/29/2017
 * Time: 10:35 PM
 * By Taboola
 */
public class TargetedBidModifier {

    private String target;
    private Double cpcModification;

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Double getCpcModification() {
        return cpcModification;
    }

    public void setCpcModification(Double cpcModification) {
        this.cpcModification = cpcModification;
    }

    @Override
    public String toString() {
        return "TargetedBidModifier{" +
                "target='" + target + '\'' +
                ", cpcModification=" + cpcModification +
                '}';
    }
}
