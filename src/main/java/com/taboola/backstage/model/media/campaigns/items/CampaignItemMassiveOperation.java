package com.taboola.backstage.model.media.campaigns.items;

import java.util.ArrayList;
import java.util.List;

import com.taboola.rest.api.annotations.Required;

/**
 * Created by gabriel.diaz
 * Date: 7/09/2020
 * Time: 11:07 AM
 * By Gabriel Diaz
 */
public class CampaignItemMassiveOperation {

    @Required
    private List<CampaignItemOperation> collection;

    private CampaignItemMassiveOperation() {
        super();
    }

    public List<CampaignItemOperation> getCollection() {
        return collection;
    }

    public CampaignItemMassiveOperation addItem(CampaignItemOperation item) {
        if (collection == null) {
            collection = new ArrayList<>();
        }
        collection.add(item);
        return this;
    }

    public CampaignItemMassiveOperation addItem(String title, String thumbnailUrl, String url) {
        addItem(CampaignItemOperation.create()
                .setTitle(title)
                .setThumbnailUrl(thumbnailUrl)
                .setUrl(url));
        return this;
    }

    public static CampaignItemMassiveOperation create() {
        return new CampaignItemMassiveOperation();
    }

}
