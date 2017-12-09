package com.taboola.backstage.services;

import com.taboola.backstage.exceptions.BackstageAPIConnectivityException;
import com.taboola.backstage.exceptions.BackstageAPIRequestException;
import com.taboola.backstage.exceptions.BackstageAPIUnauthorizedException;
import com.taboola.backstage.model.Results;
import com.taboola.backstage.model.auth.BackstageAuthentication;
import com.taboola.backstage.model.dictionary.Resource;
import com.taboola.backstage.internal.BackstageDictionaryEndpoint;

/**
 * Created by vladi
 * Date: 10/17/2017
 * Time: 11:42 PM
 * By Taboola
 */
public class DictionaryServiceImpl implements DictionaryService {

    private final BackstageDictionaryEndpoint endpoint;

    public DictionaryServiceImpl(BackstageDictionaryEndpoint endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public Results<Resource> custom(BackstageAuthentication auth, String ... resourceName) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.custom(accessToken, String.join("/", resourceName));
    }

    @Override
    public Results<Resource> getRoot(BackstageAuthentication auth) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.getRoot(accessToken);
    }

    @Override
    public Results<Resource> getCountries(BackstageAuthentication auth) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.getCountries(accessToken);
    }

    @Override
    public Results<Resource> getSpecificCountryRegions(BackstageAuthentication auth, String countryCode) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.getSpecificCountryRegions(accessToken, countryCode);
    }

    @Override
    public Results<Resource> getSpecificCountryPostals(BackstageAuthentication auth, String countryCode) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.getSpecificCountryPostals(accessToken, countryCode);
    }

    @Override
    public Results<Resource> getUnitedStatesDMA(BackstageAuthentication auth) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.getUnitedStatesDMA(accessToken);
    }

    @Override
    public Results<Resource> getPlatforms(BackstageAuthentication auth) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.getPlatforms(accessToken);
    }
}
