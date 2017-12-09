package com.taboola.backstage.services;

import com.taboola.backstage.exceptions.BackstageAPIConnectivityException;
import com.taboola.backstage.exceptions.BackstageAPIRequestException;
import com.taboola.backstage.exceptions.BackstageAPIUnauthorizedException;
import com.taboola.backstage.model.Results;
import com.taboola.backstage.model.auth.BackstageAuthentication;
import com.taboola.backstage.model.media.campaigns.items.CampaignItem;

/**
 * Created by vladi
 * Date: 10/16/2017
 * Time: 11:47 PM
 * By Taboola
 */
public interface CampaignItemsService {

    CampaignItem createItem(BackstageAuthentication auth, String accountId, String campaignId, CampaignItem item) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    Results<CampaignItem> readItems(BackstageAuthentication auth, String accountId, String campaignId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;
    
    Results<CampaignItem> readRSSChildrenItems(BackstageAuthentication auth, String accountId, String campaignId, Long itemId) throws BackstageAPIRequestException, BackstageAPIUnauthorizedException, BackstageAPIConnectivityException;

    CampaignItem readSpecificRSSChildItem(BackstageAuthentication auth, String accountId, String campaignId, Long itemId, Long childId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    CampaignItem updateSpecificRSSChildItem(BackstageAuthentication auth, String accountId, String campaignId, Long itemId, Long childId, CampaignItem campaignItem) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    CampaignItem readItem(BackstageAuthentication auth, String accountId, String campaignId, Long itemId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    CampaignItem updateItem(BackstageAuthentication auth, String accountId, String campaignId, Long itemId, CampaignItem item) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    CampaignItem deleteItem(BackstageAuthentication auth, String accountId, String campaignId, Long itemId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;
}
