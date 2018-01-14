package com.taboola.backstage.internal;

import com.taboola.backstage.exceptions.BackstageAPIException;
import com.taboola.backstage.model.Results;
import com.taboola.backstage.model.dictionary.Resource;
import retrofit2.http.*;

/**
 * Created by vladi
 * Date: 10/17/2017
 * Time: 11:27 PM
 * By Taboola
 */
public interface BackstageDictionaryEndpoint {

    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/resources/{dictionary_suffix}")
    @Headers("Content-Type: application/json")
    String custom(@Header("Authorization") String authToken, @Path(value = "dictionary_suffix", encoded = true) String dictionarySuffix) throws BackstageAPIException;

    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/resources")
    @Headers("Content-Type: application/json")
    Results<Resource> getRoot(@Header("Authorization") String authToken) throws BackstageAPIException;

    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/resources/countries")
    @Headers("Content-Type: application/json")
    Results<Resource> getCountries(@Header("Authorization") String authToken) throws BackstageAPIException;

    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/resources/countries/{country_code}/regions")
    @Headers("Content-Type: application/json")
    Results<Resource> getSpecificCountryRegions(@Header("Authorization") String authToken, @Path("country_code") String countryCode) throws BackstageAPIException;

    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/resources/countries/{country_code}/postal")
    @Headers("Content-Type: application/json")
    Results<Resource> getSpecificCountryPostals(@Header("Authorization") String authToken, @Path("country_code") String countryCode) throws BackstageAPIException;

    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/resources/countries/US/dma")
    @Headers("Content-Type: application/json")
    Results<Resource> getUnitedStatesDMA(@Header("Authorization") String authToken) throws BackstageAPIException;

    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/resources/platforms")
    @Headers("Content-Type: application/json")
    Results<Resource> getPlatforms(@Header("Authorization") String authToken) throws BackstageAPIException;
}
