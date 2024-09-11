/*
 * Copyright 2024 InPowered. All Rights Reserved.
 *
 * This software is the proprietary information of InPowered.
 * Use is subject to license terms.
 */
package com.taboola.backstage.model.media.campaigns;

import java.util.List;

/**
 * @author gldiazcardenas, 10/09/24.
 */
public class CampaignLinkedGroups {

    private List<CampaignsGroup> linkedGroups;

    public List<CampaignsGroup> getLinkedGroups() {
        return linkedGroups;
    }

    public void setLinkedGroups(List<CampaignsGroup> linkedGroups) {
        this.linkedGroups = linkedGroups;
    }

}
