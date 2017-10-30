package com.taboola.backstage.model.media.campaigns;

import java.util.List;

/**
 * Created by vladi
 * Date: 9/29/2017
 * Time: 10:34 PM
 * By Taboola
 */
public class PublisherBidModifier {

    private List<TargetedBidModifier> values;

    public List<TargetedBidModifier> getValues() {
        return values;
    }

    public void setValues(List<TargetedBidModifier> values) {
        this.values = values;
    }
}
