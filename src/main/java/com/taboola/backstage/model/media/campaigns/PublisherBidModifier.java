package com.taboola.backstage.model.media.campaigns;

import java.util.List;

import com.taboola.rest.api.annotations.Required;

/**
 * Created by vladi
 * Date: 9/29/2017
 * Time: 10:34 PM
 * By Taboola
 */
public class PublisherBidModifier {

    @Required
    private List<TargetedBidModifier> values;

    public List<TargetedBidModifier> getValues() {
        return values;
    }

    public void setValues(List<TargetedBidModifier> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "PublisherBidModifier{" +
                "values=" + values +
                '}';
    }
}
