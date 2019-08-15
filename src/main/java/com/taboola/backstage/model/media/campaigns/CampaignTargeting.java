package com.taboola.backstage.model.media.campaigns;

import com.taboola.backstage.annotations.ReadOnly;
import com.taboola.backstage.annotations.Required;
import com.taboola.backstage.model.media.campaigns.targeting.Type;

import java.util.Collection;

/**
 * <p>
 *    Targeting your campaigns to the right segment helps you get the most out of your
 *    campaigns. In the following document you will find information regarding the targeting
 *    abilities supported by the API.
 *    <br> The supported targeting options are:
 *    <br> 1. Geo Targeting - You can target specific geographic areas - like countries or
 *    regions within a specific country. You can also target more granularly - by postal
 *    code. For example, you can run your local store campaigns only in places you
 *    have physical stores, helping you spend your budget wisely and attract relevant
 *    customers.
 *    <br> 2. Platform Targeting (include only) - You can choose on which devices your
 *    campaign items will appear. Platform targeting can be useful if you have different
 *    product or service offerings for users that browse from different platforms. For
 *    example, if you’re offering a mobile app, it would make sense to target mobile
 *    devices only.
 *    <br> 3. Publisher Targeting (exclude only) - You can block specific publishers from
 *    serving your campaign.
 *    <br> 4. OS Targeting - The campaign can be targeted for specific operation system
 *    <br> 5. Connectivity Type Targeting (include only) - The campaign can be targeted for specific connectivity type (e.g. WIFI)
 * </p>
 *
 * Created by vladi
 * Date: 9/29/2017
 * Time: 10:34 PM
 * By Taboola
 */
public class CampaignTargeting<T> {

    @Required
    private Type type;
    @Required
    private Collection<T> value;
    @ReadOnly
    private String href;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Collection<T> getValue() {
        return value;
    }

    public void setValue(Collection<T> value) {
        this.value = value;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public String toString() {
        return "CampaignTargeting{" +
        "type=" + type +
        ", value=" + value +
        ", href='" + href + '\'' +
        '}';
    }
}
