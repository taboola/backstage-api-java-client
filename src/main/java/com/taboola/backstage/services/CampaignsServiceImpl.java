package com.taboola.backstage.services;

import com.taboola.backstage.exceptions.BackstageAPIConnectivityException;
import com.taboola.backstage.exceptions.BackstageAPIRequestException;
import com.taboola.backstage.exceptions.BackstageAPITokenExpiredException;
import com.taboola.backstage.model.Results;
import com.taboola.backstage.model.auth.BackstageAuthentication;
import com.taboola.backstage.model.media.campaigns.Campaign;
import com.taboola.backstage.internal.BackstageCampaignsEndpoint;

/**
 * Created by vladi
 * Date: 10/13/2017
 * Time: 11:37 PM
 * By Taboola
 */
public class CampaignsServiceImpl implements CampaignsService {

    private final BackstageCampaignsEndpoint endpoint;

    public CampaignsServiceImpl(BackstageCampaignsEndpoint endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public Campaign create(BackstageAuthentication auth, String accountId, Campaign campaign) throws BackstageAPITokenExpiredException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.createCampaign(accessToken, accountId, campaign);
    }

    @Override
    public Campaign read(BackstageAuthentication auth, String accountId, String campaignId) throws BackstageAPITokenExpiredException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.getCampaign(accessToken, accountId, campaignId);
    }

    @Override
    public Results<Campaign> read(BackstageAuthentication auth, String accountId) throws BackstageAPITokenExpiredException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.getAllCampaigns(accessToken, accountId);
    }

    @Override
    public Campaign update(BackstageAuthentication auth, String accountId, String campaignId, Campaign campaign) throws BackstageAPITokenExpiredException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.updateCampaign(accessToken, accountId, campaignId,  campaign);
    }

}
