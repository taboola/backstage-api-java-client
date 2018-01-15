package com.taboola.backstage.services;

import com.taboola.backstage.exceptions.BackstageAPIConnectivityException;
import com.taboola.backstage.exceptions.BackstageAPIRequestException;
import com.taboola.backstage.exceptions.BackstageAPIUnauthorizedException;
import com.taboola.backstage.model.auth.BackstageAuthentication;
import com.taboola.backstage.model.media.campaigns.targeting.PostalTargeting;

/**
 *
 * <p>
 *    The following operations are available via the API:
 *    <br> 1. Fetch targeted postal codes for specific Campaign.
 *    <br> 2. Update postal codes - target specific Campaign to new postal codes, or change the targeting type.
 * </p>
 *
 * @author vladi
 * @version 1.0
 */
public interface CampaignPostalTargetingService {

    /**
     * Read postal code targeting
     *
     * @param auth Authentication object ({@link BackstageAuthentication})
     * @param accountId To which {@link com.taboola.backstage.model.Account Account} the campaign belongs. Taken from {@link com.taboola.backstage.model.Account#getAccountId() Account.getAccountId()}
     * @param campaignId {@link com.taboola.backstage.model.media.campaigns.Campaign Campaign} Id. Taken from {@link com.taboola.backstage.model.media.campaigns.Campaign Campaign#getId()} object
     * @return Fully populated {@link PostalTargeting}
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    PostalTargeting read(BackstageAuthentication auth, String accountId, String campaignId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    /**
     * <p>
     *    Updating postal code targeting can be performed in two ways:
     *    <br> 1. Full update - change both type and values in one request.
     *    <br> 2. Partial update - Update either type or values separately.
     * </p>
     *
     * @param auth Authentication object ({@link BackstageAuthentication})
     * @param accountId To which {@link com.taboola.backstage.model.Account Account} the campaign belongs. Taken from {@link com.taboola.backstage.model.Account#getAccountId() Account.getAccountId()}
     * @param campaignId {@link com.taboola.backstage.model.media.campaigns.Campaign Campaign} Id. Taken from {@link com.taboola.backstage.model.media.campaigns.Campaign Campaign#getId()} object
     * @param targeting Full or partial {@link PostalTargeting} pojo to update.
     * @return Fully populated {@link PostalTargeting}
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    PostalTargeting update(BackstageAuthentication auth, String accountId, String campaignId, PostalTargeting targeting) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;
}
