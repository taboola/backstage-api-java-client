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
public interface DictionaryService {

    /**
     * What is not supported in the interface can be fetched by custom method just by supplying resources names
     */
    Results<Resource> custom(BackstageAuthentication auth, String ... resourceName) throws BackstageAPITokenExpiredException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    Results<Resource> getRoot(BackstageAuthentication auth) throws BackstageAPITokenExpiredException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    Results<Resource> getCountries(BackstageAuthentication auth) throws BackstageAPITokenExpiredException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    Results<Resource> getSpecificCountryRegions(BackstageAuthentication auth, String countryCode) throws BackstageAPITokenExpiredException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    Results<Resource> getSpecificCountryPostals(BackstageAuthentication auth, String countryCode) throws BackstageAPITokenExpiredException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    Results<Resource> getUnitedStatesDMA(BackstageAuthentication auth) throws BackstageAPITokenExpiredException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    Results<Resource> getPlatforms(BackstageAuthentication auth) throws BackstageAPITokenExpiredException, BackstageAPIConnectivityException, BackstageAPIRequestException;
}
