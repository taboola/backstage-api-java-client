package com.taboola.backstage.services;

import com.taboola.backstage.exceptions.BackstageAPIConnectivityException;
import com.taboola.backstage.exceptions.BackstageAPIRequestException;
import com.taboola.backstage.exceptions.BackstageAPIUnauthorizedException;
import com.taboola.backstage.model.Results;
import com.taboola.backstage.model.auth.BackstageAuthentication;
import com.taboola.backstage.model.media.campaigns.performancevideos.PerformanceVideoItem;
import com.taboola.backstage.model.media.campaigns.performancevideos.PerformanceVideoItemOperation;

/**
 * {@link PerformanceVideoItem} entity CRUD operations.
 *
 * Created by Gabriel Diaz, 09/02/2020.
 */
public interface PerformanceVideoItemsService {

    PerformanceVideoItem createItem(BackstageAuthentication auth, String accountId, String campaignId, PerformanceVideoItemOperation itemOperation) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    Results<PerformanceVideoItem> readItems(BackstageAuthentication auth, String accountId, String campaignId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    PerformanceVideoItem readItem(BackstageAuthentication auth, String accountId, String campaignId, String itemId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    PerformanceVideoItem updateItem(BackstageAuthentication auth, String accountId, String campaignId, String itemId, PerformanceVideoItemOperation campaignItemOperation) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    PerformanceVideoItem deleteItem(BackstageAuthentication auth, String accountId, String campaignId, String itemId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

}
