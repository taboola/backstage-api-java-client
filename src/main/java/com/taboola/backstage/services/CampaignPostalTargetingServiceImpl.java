package com.taboola.backstage.services;

import com.taboola.backstage.exceptions.BackstageAPIConnectivityException;
import com.taboola.backstage.exceptions.BackstageAPIRequestException;
import com.taboola.backstage.exceptions.BackstageAPIUnauthorizedException;
import com.taboola.backstage.internal.BackstagePostalTargetingEndpoint;
import com.taboola.backstage.model.auth.BackstageAuthentication;
import com.taboola.backstage.model.media.campaigns.targeting.PostalTargeting;

/**
 * Created by vladi
 * Date: 1/15/2018
 * Time: 11:27 PM
 * By Taboola
 */
public class CampaignPostalTargetingServiceImpl implements CampaignPostalTargetingService {

    private final BackstagePostalTargetingEndpoint endpoint;

    public CampaignPostalTargetingServiceImpl(BackstagePostalTargetingEndpoint endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public PostalTargeting read(BackstageAuthentication auth, String accountId, String campaignId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessTokenForHeader = auth.getToken().getAccessTokenForHeader();
        return endpoint.read(accessTokenForHeader, accountId, campaignId);
    }

    @Override
    public PostalTargeting update(BackstageAuthentication auth, String accountId, String campaignId, PostalTargeting targeting) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessTokenForHeader = auth.getToken().getAccessTokenForHeader();
        return endpoint.update(accessTokenForHeader, accountId, campaignId, targeting);
    }
}
