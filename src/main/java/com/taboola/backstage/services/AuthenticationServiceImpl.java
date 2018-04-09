package com.taboola.backstage.services;

import com.taboola.backstage.exceptions.BackstageAPIConnectivityException;
import com.taboola.backstage.exceptions.BackstageAPIRequestException;
import com.taboola.backstage.exceptions.BackstageAPIUnauthorizedException;
import com.taboola.backstage.model.auth.*;
import com.taboola.backstage.internal.BackstageAuthenticationEndpoint;

import java.util.Objects;

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
        ClientCredentialAuthenticationDetails details = new ClientCredentialAuthenticationDetails(clientId, clientSecret);
        return new BackstageAuthentication(details, endpoint.getAuthToken(clientId, clientSecret, details.getGrantType().getValue()));
    }

    @Override
    public BackstageAuthentication passwordAuthentication(String clientId, String clientSecret, String username, String password) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        PasswordAuthenticationDetails details = new PasswordAuthenticationDetails(clientId, clientSecret, username, password);
        return new BackstageAuthentication(details, endpoint.getAuthToken(clientId, clientSecret,username, password, details.getGrantType().getValue()));
    }

    @Override
    public BackstageAuthentication reAuthenticate(BackstageAuthentication auth) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        AuthenticationDetails details = auth.getDetails();
        if(details == null) {
            throw new IllegalStateException("Can't reAuthenticate without authentication details");
        }

        GrantType grantType = details.getGrantType();
        if(grantType == null) {
            throw new IllegalStateException("Unknown grant type");
        }

        //In order to save some usability pain paying here with down cast...
        switch (grantType) {
            case CLIENT_CREDENTIALS:
                if(details instanceof ClientCredentialAuthenticationDetails) {
                    ClientCredentialAuthenticationDetails clientCredentialDetails = (ClientCredentialAuthenticationDetails) details;
                    return clientCredentials(clientCredentialDetails.getClientId(), clientCredentialDetails.getClientSecret());
                } else {
                    throw new IllegalStateException("Invalid BackstageAuthentication instance, expected to be ClientCredentialAuthenticationDetails");
                }

            case PASSWORD_AUTHENTICATION:
                if(details instanceof PasswordAuthenticationDetails) {
                    PasswordAuthenticationDetails passwordAuthDetails = (PasswordAuthenticationDetails) details;
                    return passwordAuthentication(passwordAuthDetails.getClientId(), passwordAuthDetails.getClientSecret(), passwordAuthDetails.getUsername(), passwordAuthDetails.getPassword());
                } else {
                    throw new IllegalStateException("Invalid BackstageAuthentication instance, expected to be PasswordAuthenticationDetails");
                }

            default:
                throw new IllegalStateException("Unknown grant type");
        }
    }

    @Override
    public BackstageAuthentication authenticate(String accessToken) {
        Objects.requireNonNull(accessToken, "accessToken");
        Token token = new Token();
        token.setAccessToken(accessToken);
        return new BackstageAuthentication(null, token);
    }

    @Override
    public TokenDetails getTokenDetails(BackstageAuthentication auth) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        return endpoint.getTokenDetails(auth.getToken().getAccessTokenForHeader());
    }
}
