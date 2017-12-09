package com.taboola.backstage.services;

import com.taboola.backstage.exceptions.BackstageAPIConnectivityException;
import com.taboola.backstage.exceptions.BackstageAPIRequestException;
import com.taboola.backstage.exceptions.BackstageAPIUnauthorizedException;
import com.taboola.backstage.model.auth.*;
import com.taboola.backstage.internal.BackstageAuthenticationEndpoint;


import static com.taboola.backstage.model.auth.GrantType.CLIENT_CREDENTIALS;
import static com.taboola.backstage.model.auth.GrantType.PASSWORD_AUTHENTICATION;

/**
 * Created by vladi
 * Date: 10/14/2017
 * Time: 12:23 AM
 * By Taboola
 */
public class AuthenticationServiceImpl implements AuthenticationService {

    private final BackstageAuthenticationEndpoint endpoint;

    public AuthenticationServiceImpl(BackstageAuthenticationEndpoint endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public BackstageAuthentication clientCredentials(String clientId, String clientSecret) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        return authenticate(clientId, clientSecret, null, null, CLIENT_CREDENTIALS);
    }

    @Override
    public BackstageAuthentication passwordAuthentication(String clientId, String clientSecret, String username, String password) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        return authenticate(clientId, clientSecret, username, password, PASSWORD_AUTHENTICATION);
    }

    @Override
    public BackstageAuthentication reAuthenticate(BackstageAuthentication auth) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        AuthenticationDetails details = auth.getDetails();
        return authenticate(details.getClientId(), details.getClientSecret(), details.getUsername(), details.getPassword(), details.getGrantType());
    }

    @Override
    public TokenDetails getTokenDetails(BackstageAuthentication auth) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        return endpoint.getTokenDetails(auth.getToken().getAccessTokenForHeader());
    }

    private BackstageAuthentication authenticate(String clientId, String clientSecret, String username, String password, GrantType grantType) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        Token token;
        switch (grantType) {
            case CLIENT_CREDENTIALS:
                token = endpoint.getAuthToken(clientId, clientSecret, grantType.getValue());
                break;
            case PASSWORD_AUTHENTICATION:
                token = endpoint.getAuthToken(clientId, clientSecret, username, password, grantType.getValue());
                break;
            default:
                    throw new IllegalStateException("Unknown grant type, seems like a bug");
        }

        return new BackstageAuthentication(new AuthenticationDetails(clientId, clientSecret, username, password, grantType), token);
    }
}
