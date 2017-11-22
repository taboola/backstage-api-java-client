package com.taboola.backstage.services;

import com.taboola.backstage.exceptions.BackstageAPIConnectivityException;
import com.taboola.backstage.exceptions.BackstageAPIRequestException;
import com.taboola.backstage.exceptions.BackstageAPITokenExpiredException;
import com.taboola.backstage.model.Results;
import com.taboola.backstage.model.auth.BackstageAuthentication;
import com.taboola.backstage.model.dictionary.Resource;
import com.taboola.backstage.services.internal.BackstageDictionaryService;

/**
 * Created by vladi
 * Date: 10/17/2017
 * Time: 11:42 PM
 * By Taboola
 */
public class DictionaryServiceImpl implements DictionaryService {

    private final BackstageDictionaryService service;

    public DictionaryServiceImpl(BackstageDictionaryService service) {
        this.service = service;
    }

    @Override
    public Results<Resource> custom(BackstageAuthentication auth, String ... resourceName) throws BackstageAPITokenExpiredException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return service.custom(accessToken, String.join("/", resourceName));
    }

    @Override
    public Results<Resource> getRoot(BackstageAuthentication auth) throws BackstageAPITokenExpiredException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return service.getRoot(accessToken);
    }

    @Override
    public Results<Resource> getCountries(BackstageAuthentication auth) throws BackstageAPITokenExpiredException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return service.getCountries(accessToken);
    }

    @Override
    public Results<Resource> getSpecificCountryRegions(BackstageAuthentication auth, String countryCode) throws BackstageAPITokenExpiredException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return service.getSpecificCountryRegions(accessToken, countryCode);
    }

    @Override
    public Results<Resource> getSpecificCountryPostals(BackstageAuthentication auth, String countryCode) throws BackstageAPITokenExpiredException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return service.getSpecificCountryPostals(accessToken, countryCode);
    }

    @Override
    public Results<Resource> getUnitedStatesDMA(BackstageAuthentication auth) throws BackstageAPITokenExpiredException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return service.getUnitedStatesDMA(accessToken);
    }

    @Override
    public Results<Resource> getPlatforms(BackstageAuthentication auth) throws BackstageAPITokenExpiredException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return service.getPlatforms(accessToken);
    }
}
