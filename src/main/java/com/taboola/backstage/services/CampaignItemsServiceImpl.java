package com.taboola.backstage.services;

import com.taboola.backstage.exceptions.BackstageAPIConnectivityException;
import com.taboola.backstage.exceptions.BackstageAPIRequestException;
import com.taboola.backstage.exceptions.BackstageAPIUnauthorizedException;
import com.taboola.backstage.internal.FieldsValidator;
import com.taboola.backstage.model.Results;
import com.taboola.backstage.model.auth.BackstageAuthentication;
import com.taboola.backstage.model.media.campaigns.items.CampaignItem;
import com.taboola.backstage.internal.BackstageCampaignItemsEndpoint;

/**
 * Created by vladi
 * Date: 10/16/2017
 * Time: 11:47 PM
 * By Taboola
 */
public class CampaignItemsServiceImpl implements CampaignItemsService {

    private final BackstageCampaignItemsEndpoint endpoint;
    private final Boolean performValidations;

    public CampaignItemsServiceImpl(Boolean performValidations, BackstageCampaignItemsEndpoint endpoint) {
        this.endpoint = endpoint;
        this.performValidations = performValidations;
    }

    @Override
    public CampaignItem createItem(BackstageAuthentication auth, String accountId, String campaignId, CampaignItem item) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        if(performValidations) {
            FieldsValidator.validateCreateOperation(item);
        }
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.createItem(accessToken, accountId, campaignId, item);
    }

    @Override
    public Results<CampaignItem> readItems(BackstageAuthentication auth, String accountId, String campaignId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.readItems(accessToken, accountId, campaignId);
    }

    @Override
    public Results<CampaignItem> readRSSChildrenItems(BackstageAuthentication auth, String accountId, String campaignId, String itemId) throws BackstageAPIRequestException, BackstageAPIUnauthorizedException, BackstageAPIConnectivityException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.readRSSChildrenItems(accessToken, accountId, campaignId, itemId);
    }

    @Override
    public CampaignItem readSpecificRSSChildItem(BackstageAuthentication auth, String accountId, String campaignId, String itemId, String childId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.readSpecificRSSChildItem(accessToken, accountId, campaignId, itemId, childId);
    }

    @Override
    public CampaignItem updateSpecificRSSChildItem(BackstageAuthentication auth, String accountId, String campaignId, String itemId, String childId, CampaignItem campaignItem) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        if(performValidations) {
            FieldsValidator.validateUpdateOperation(campaignItem);
        }
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.updateSpecificRSSChildItem(accessToken, accountId, campaignId, itemId, childId, campaignItem);
    }

    @Override
    public CampaignItem readItem(BackstageAuthentication auth, String accountId, String campaignId, String itemId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.readItem(accessToken, accountId, campaignId, itemId);
    }

    @Override
    public CampaignItem updateItem(BackstageAuthentication auth, String accountId, String campaignId, String itemId, CampaignItem item) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        if(performValidations) {
            FieldsValidator.validateUpdateOperation(item);
        }
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.updateItem(accessToken, accountId, campaignId, itemId, item);
    }

    @Override
    public CampaignItem deleteItem(BackstageAuthentication auth, String accountId, String campaignId, String itemId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.deleteItem(accessToken, accountId, campaignId, itemId);
    }
}
