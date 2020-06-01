package com.taboola.backstage.services;

import com.taboola.backstage.exceptions.BackstageAPIConnectivityException;
import com.taboola.backstage.exceptions.BackstageAPIRequestException;
import com.taboola.backstage.exceptions.BackstageAPIUnauthorizedException;
import com.taboola.backstage.internal.FieldsValidator;
import com.taboola.backstage.model.Results;
import com.taboola.backstage.model.auth.BackstageAuthentication;
import com.taboola.backstage.model.media.campaigns.Campaign;
import com.taboola.backstage.internal.BackstageCampaignsEndpoint;
import com.taboola.backstage.model.media.campaigns.CampaignOperation;
import com.taboola.backstage.model.media.campaigns.CampaignPatch;

/**
 * Created by vladi
 * Date: 10/13/2017
 * Time: 11:37 PM
 * By Taboola
 */
public class CampaignsServiceImpl implements CampaignsService {

    private final BackstageCampaignsEndpoint endpoint;
    private final Boolean performValidations;

    public CampaignsServiceImpl(Boolean performValidations, BackstageCampaignsEndpoint endpoint) {
        this.endpoint = endpoint;
        this.performValidations = performValidations;
    }

    @Override
    public Campaign create(BackstageAuthentication auth, String accountId, CampaignOperation campaignOperation) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        if(performValidations) {
            FieldsValidator.validateCreateOperation(campaignOperation);
        }
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.createCampaign(accessToken, accountId, campaignOperation);
    }

    @Override
    public Campaign read(BackstageAuthentication auth, String accountId, String campaignId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.getCampaign(accessToken, accountId, campaignId);
    }

    @Override
    public Results<Campaign> read(BackstageAuthentication auth, String accountId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.getAllCampaigns(accessToken, accountId);
    }

    @Override
    public Campaign update(BackstageAuthentication auth, String accountId, String campaignId, CampaignOperation campaignOperation) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        if(performValidations) {
            FieldsValidator.validateUpdateOperation(campaignOperation);
        }
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.updateCampaign(accessToken, accountId, campaignId,  campaignOperation);
    }

    @Override
    public Campaign duplicate(BackstageAuthentication auth, String accountId, String campaignId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        return endpoint.duplicateCampaign(auth.getToken().getAccessTokenForHeader(), accountId, campaignId);
    }

    @Override
    public Campaign duplicate(BackstageAuthentication auth, String accountId, String campaignId, CampaignOperation campaignOperation) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        return endpoint.duplicateCampaign(auth.getToken().getAccessTokenForHeader(), accountId, campaignId,  campaignOperation);
    }

    @Override
    public CampaignPatch patch(BackstageAuthentication auth, String accountId, String campaignId, CampaignPatch campaignPatch) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        if(performValidations) {
            FieldsValidator.validateCreateOperation(campaignPatch);
        }
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.patchCampaign(accessToken, accountId, campaignId, campaignPatch);
    }

    @Override
    public Campaign delete(BackstageAuthentication auth, String accountId, String campaignId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.deleteCampaign(accessToken, accountId, campaignId);
    }
}
