package com.taboola.backstage.services;

import com.taboola.backstage.exceptions.BackstageAPIConnectivityException;
import com.taboola.backstage.exceptions.BackstageAPIRequestException;
import com.taboola.backstage.exceptions.BackstageAPITokenExpiredException;
import com.taboola.backstage.model.Results;
import com.taboola.backstage.model.auth.BackstageAuthentication;
import com.taboola.backstage.model.media.campaigns.Campaign;

/**
 * Created by vladi
 * Date: 10/14/2017
 * Time: 12:21 AM
 * By Taboola
 */
public interface CampaignsService {

    Campaign create(BackstageAuthentication auth, String accountId, Campaign campaign) throws BackstageAPITokenExpiredException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    Campaign read(BackstageAuthentication auth, String accountId, String campaignId) throws BackstageAPITokenExpiredException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    Results<Campaign> read(BackstageAuthentication auth, String accountId) throws BackstageAPITokenExpiredException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    Campaign update(BackstageAuthentication auth, String accountId, String campaignId, Campaign campaign) throws BackstageAPITokenExpiredException, BackstageAPIConnectivityException, BackstageAPIRequestException;

}
