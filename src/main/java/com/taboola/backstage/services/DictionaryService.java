package com.taboola.backstage.services;

import com.taboola.backstage.exceptions.BackstageAPIConnectivityException;
import com.taboola.backstage.exceptions.BackstageAPIRequestException;
import com.taboola.backstage.exceptions.BackstageAPIUnauthorizedException;
import com.taboola.backstage.model.Results;
import com.taboola.backstage.model.auth.BackstageAuthentication;
import com.taboola.backstage.model.dictionary.Resource;

/**
 * <p>
 *    The dictionary allows to get from Taboola lists of possible values and their meaning in various
 *    contexts (enum’s and their relevant codes). This is used in order to get predefined allowed
 *    values to be selected by the user. For example, if the user would like to target specific countries,
 *    the dictionary will allow to get the possible country values supported in Taboola and display
 *    them as selectable options to the user.
 * </p>
 * @author vladi
 * @version 1.0
 */
public interface DictionaryService {

    /**
     * What is not supported in the interface can be fetched by this method just by supplying resources names
     * @param auth Authentication object {@link BackstageAuthentication}
     * @param resourceName array that represents path for specific dictionary
     * @return {@link String} representing response payload
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    String custom(BackstageAuthentication auth, String ... resourceName) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    /**
     * Dictionary list of root resources display names and codes
     * @param auth Authentication object {@link BackstageAuthentication}
     * @return Collection of {@link Resource}
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    Results<Resource> getRoot(BackstageAuthentication auth) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    /**
     * Dictionary list of countries display names and codes
     * @param auth Authentication object {@link BackstageAuthentication}
     * @return Collection of {@link Resource}
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    Results<Resource> getCountries(BackstageAuthentication auth) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    /**
     * Dictionary list of specific country regions display names and codes
     * @param auth Authentication object {@link BackstageAuthentication}
     * @param countryCode country code (two upper case letters)
     * @return Collection of {@link Resource}
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    Results<Resource> getSpecificCountryRegions(BackstageAuthentication auth, String countryCode) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    /**
     * Dictionary list of specific country postal/zip display names and codes
     * @param auth Authentication object {@link BackstageAuthentication}
     * @param countryCode country code (two upper case letters)
     * @return Collection of {@link Resource}
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    Results<Resource> getSpecificCountryPostals(BackstageAuthentication auth, String countryCode) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    /**
     * Dictionary list of united states DMA display names and codes
     * @param auth Authentication object {@link BackstageAuthentication}
     * @return Collection of {@link Resource}
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    Results<Resource> getUnitedStatesDMA(BackstageAuthentication auth) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    /**
     * Dictionary list of platform display names and codes
     * @param auth Authentication object {@link BackstageAuthentication}
     * @return Collection of {@link Resource}
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    Results<Resource> getPlatforms(BackstageAuthentication auth) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;
}
