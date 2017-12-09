package com.taboola.backstage.services;

import com.taboola.backstage.exceptions.BackstageAPIConnectivityException;
import com.taboola.backstage.exceptions.BackstageAPIRequestException;
import com.taboola.backstage.exceptions.BackstageAPIUnauthorizedException;
import com.taboola.backstage.model.auth.BackstageAuthentication;
import com.taboola.backstage.model.auth.TokenDetails;

/**
 * Created by vladi
 * Date: 10/14/2017
 * Time: 12:23 AM
 * By Taboola
 */
public interface AuthenticationService {

    BackstageAuthentication clientCredentials(String clientId, String clientSecret) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    BackstageAuthentication passwordAuthentication(String clientId, String clientSecret, String username, String password) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    BackstageAuthentication reAuthenticate(BackstageAuthentication auth) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    TokenDetails getTokenDetails(BackstageAuthentication auth) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

}
