package com.taboola.backstage.services;

import com.taboola.backstage.exceptions.BackstageAPIConnectivityException;
import com.taboola.backstage.exceptions.BackstageAPIRequestException;
import com.taboola.backstage.exceptions.BackstageAPIUnauthorizedException;
import com.taboola.backstage.model.auth.BackstageAuthentication;
import com.taboola.backstage.model.auth.TokenDetails;

/**
 * Authentication service allow different authentication types and supply additional token metadata
 *
 * @author vladi
 * @version 1.0
 */
public interface AuthenticationService {

    /**
     * <p>
     *     Client Credentials: The client submits a Client ID + Client Secret pair to the
     *     token-endpoint, and in exchange receives an Access Token.
     *     This scheme is only appropriate when a confidential app performs server-to-server communication.
     * </p>
     *
     * @param clientId specific client id (given by Taboola)
     * @param clientSecret specific client secret (given by Taboola)
     * @return {@link BackstageAuthentication} object which is being required by all services
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    BackstageAuthentication clientCredentials(String clientId, String clientSecret) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    /**
     * <p>
     *     Password Authentication: The client submits a valid Username + Password pair to the
     *     token-endpoint, and in exchange receives an Access Token and a Refresh Token.
     *     This scheme is more appropriate for non-confidential client apps (e.g. web-apps, mobile apps).
     * </p>
     *
     * @param clientId specific client id (given by Taboola)
     * @param clientSecret specific client secret (given by Taboola)
     * @param username specific Taboola username (given by Taboola)
     * @param password specific Taboola user password (given by Taboola)
     * @return {@link BackstageAuthentication} object which is being required by all services
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    BackstageAuthentication passwordAuthentication(String clientId, String clientSecret, String username, String password) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    /**
     * Refresh previously created {@link BackstageAuthentication} object
     *
     * @param auth Authentication object {@link BackstageAuthentication}
     * @return re-authenticated {@link BackstageAuthentication} new object
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    BackstageAuthentication reAuthenticate(BackstageAuthentication auth) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    /**
     * Specific {@link com.taboola.backstage.model.auth.Token Token} metadata
     *
     * <p>
     *     Fetching the Token Details resource associated with an Access Token is probably
     *     crucial for any client-app, because that's the only way you can know which Accounts
     *     this Access Token allows you to access.
     * </p>
     *
     * @param auth Authentication object {@link BackstageAuthentication}
     * @return {@link TokenDetails} metadata of specific {@link com.taboola.backstage.model.auth.Token Token}
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    TokenDetails getTokenDetails(BackstageAuthentication auth) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

}
