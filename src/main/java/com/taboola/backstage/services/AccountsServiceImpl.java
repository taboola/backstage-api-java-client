package com.taboola.backstage.services;

import com.taboola.backstage.exceptions.BackstageAPIConnectivityException;
import com.taboola.backstage.exceptions.BackstageAPIRequestException;
import com.taboola.backstage.exceptions.BackstageAPIUnauthorizedException;
import com.taboola.backstage.internal.BackstageAccountEndpoint;
import com.taboola.backstage.model.Account;
import com.taboola.backstage.model.Results;
import com.taboola.backstage.model.auth.BackstageAuthentication;

/**
 * Created by vladi
 * Date: 1/15/2018
 * Time: 11:05 PM
 * By Taboola
 */
public class AccountsServiceImpl implements AccountsService {

    private final BackstageAccountEndpoint endpoint;

    public AccountsServiceImpl(BackstageAccountEndpoint endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public Results<Account> readPublishersUnderTaboolaNetwork(BackstageAuthentication auth) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.getAvailablePublishersUnderTaboolaNetwork(accessToken);
    }
}
