package com.taboola.backstage.services;

import com.taboola.backstage.exceptions.BackstageAPIConnectivityException;
import com.taboola.backstage.exceptions.BackstageAPIRequestException;
import com.taboola.backstage.exceptions.BackstageAPITokenExpiredException;
import com.taboola.backstage.model.Results;
import com.taboola.backstage.model.auth.BackstageAuthentication;
import com.taboola.backstage.model.media.campaigns.items.CampaignItem;
import com.taboola.backstage.services.internal.BackstageCampaignItemsService;

/**
 * Created by vladi
 * Date: 10/16/2017
 * Time: 11:47 PM
 * By Taboola
 */
public class CampaignItemsServiceImpl implements CampaignItemsService {

    private final BackstageCampaignItemsService service;

    public CampaignItemsServiceImpl(BackstageCampaignItemsService service) {
        this.service = service;
    }

    @Override
    public CampaignItem createItem(BackstageAuthentication auth, String accountId, String campaignId, CampaignItem item) throws BackstageAPITokenExpiredException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return service.createItem(accessToken, accountId, campaignId, item);
    }

    @Override
    public Results<CampaignItem> readItems(BackstageAuthentication auth, String accountId, String campaignId) throws BackstageAPITokenExpiredException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return service.readItems(accessToken, accountId, campaignId);
    }

    @Override
    public Results<CampaignItem> readRSSChildrenItems(BackstageAuthentication auth, String accountId, String campaignId, Long itemId) throws BackstageAPIRequestException, BackstageAPITokenExpiredException, BackstageAPIConnectivityException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return service.readRSSChildrenItems(accessToken, accountId, campaignId, itemId);
    }

    @Override
    public CampaignItem readSpecificRSSChildItem(BackstageAuthentication auth, String accountId, String campaignId, Long itemId, Long childId) throws BackstageAPITokenExpiredException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return service.readSpecificRSSChildItem(accessToken, accountId, campaignId, itemId, childId);
    }

    @Override
    public CampaignItem updateSpecificRSSChildItem(BackstageAuthentication auth, String accountId, String campaignId, Long itemId, Long childId, CampaignItem campaignItem) throws BackstageAPITokenExpiredException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return service.updateSpecificRSSChildItem(accessToken, accountId, campaignId, itemId, childId, campaignItem);
    }

    @Override
    public CampaignItem readItem(BackstageAuthentication auth, String accountId, String campaignId, Long itemId) throws BackstageAPITokenExpiredException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return service.readItem(accessToken, accountId, campaignId, itemId);
    }

    @Override
    public CampaignItem updateItem(BackstageAuthentication auth, String accountId, String campaignId, Long itemId, CampaignItem item) throws BackstageAPITokenExpiredException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return service.updateItem(accessToken, accountId, campaignId, itemId, item);
    }

    @Override
    public CampaignItem deleteItem(BackstageAuthentication auth, String accountId, String campaignId, Long itemId) throws BackstageAPITokenExpiredException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return service.deleteItem(accessToken, accountId, campaignId, itemId);
    }
}
