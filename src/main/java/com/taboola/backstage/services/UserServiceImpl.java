package com.taboola.backstage.services;

import com.taboola.backstage.exceptions.BackstageAPIConnectivityException;
import com.taboola.backstage.exceptions.BackstageAPIRequestException;
import com.taboola.backstage.exceptions.BackstageAPITokenExpiredException;
import com.taboola.backstage.model.Results;
import com.taboola.backstage.model.Account;
import com.taboola.backstage.model.auth.BackstageAuthentication;
import com.taboola.backstage.services.internal.BackstageAccountService;

/**
 * Created by vladi
 * Date: 10/16/2017
 * Time: 11:19 PM
 * By Taboola
 */
public class UserServiceImpl implements UserService {

    private final BackstageAccountService accountService;

    public UserServiceImpl(BackstageAccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public Results<Account> readAllowedAccounts(BackstageAuthentication auth) throws BackstageAPITokenExpiredException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return accountService.getUserAllowedAccounts(accessToken);
    }
}
