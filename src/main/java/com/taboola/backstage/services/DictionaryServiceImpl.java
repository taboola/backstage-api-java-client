package com.taboola.backstage.services;

import com.taboola.backstage.exceptions.BackstageAPIConnectivityException;
import com.taboola.backstage.exceptions.BackstageAPIRequestException;
import com.taboola.backstage.exceptions.BackstageAPITokenExpiredException;
import com.taboola.backstage.model.Results;
import com.taboola.backstage.model.auth.BackstageAuthentication;
import com.taboola.backstage.model.dictionary.Resource;

/**
 * Created by vladi
 * Date: 10/17/2017
 * Time: 11:42 PM
 * By Taboola
 */
public class DictionaryServiceImpl implements DictionaryService {

    private final CommunicationHandler communicationHandler;

    public DictionaryServiceImpl(CommunicationHandler communicationHandler) {
        this.communicationHandler = communicationHandler;
    }

    @Override
    public Results<Resource> custom(BackstageAuthentication auth, String ... resourceName) throws BackstageAPITokenExpiredException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return communicationHandler.request("dictionary custom",
                () -> communicationHandler.getDictionaryService().custom(accessToken, String.join("/", resourceName)));
    }

    @Override
    public Results<Resource> getRoot(BackstageAuthentication auth) throws BackstageAPITokenExpiredException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return communicationHandler.request("get dictionary root",
                () -> communicationHandler.getDictionaryService().getRoot(accessToken));
    }

    @Override
    public Results<Resource> getCountries(BackstageAuthentication auth) throws BackstageAPITokenExpiredException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return communicationHandler.request("get dictionary countries",
                () -> communicationHandler.getDictionaryService().getCountries(accessToken));
    }

    @Override
    public Results<Resource> getSpecificCountryRegions(BackstageAuthentication auth, String countryCode) throws BackstageAPITokenExpiredException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return communicationHandler.request("get dictionary specific country regions",
                () -> communicationHandler.getDictionaryService().getSpecificCountryRegions(accessToken, countryCode));
    }

    @Override
    public Results<Resource> getSpecificCountryPostals(BackstageAuthentication auth, String countryCode) throws BackstageAPITokenExpiredException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return communicationHandler.request("get dictionary specific country postal",
                () -> communicationHandler.getDictionaryService().getSpecificCountryPostals(accessToken, countryCode));
    }

    @Override
    public Results<Resource> getUnitedStatesDMA(BackstageAuthentication auth) throws BackstageAPITokenExpiredException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return communicationHandler.request("get dictionary United States DMA",
                () -> communicationHandler.getDictionaryService().getUnitedStatesDMA(accessToken));
    }

    @Override
    public Results<Resource> getPlatforms(BackstageAuthentication auth) throws BackstageAPITokenExpiredException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return communicationHandler.request("get dictionary platforms",
                () -> communicationHandler.getDictionaryService().getPlatforms(accessToken));
    }
}
