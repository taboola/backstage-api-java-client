package com.taboola.backstage.services;

import com.taboola.backstage.exceptions.BackstageAPIConnectivityException;
import com.taboola.backstage.exceptions.BackstageAPIRequestException;
import com.taboola.backstage.exceptions.BackstageAPIUnauthorizedException;
import com.taboola.backstage.model.Results;
import com.taboola.backstage.model.auth.BackstageAuthentication;
import com.taboola.backstage.model.media.campaigns.Campaign;
import com.taboola.backstage.model.media.campaigns.CampaignOperation;
import com.taboola.backstage.model.media.campaigns.CampaignPatch;

/**
 * {@link Campaign} entity CRUD operations
 *
 * <p>
 *    The following operations are available via the API:
 *    <br> {@link CampaignsService#read(BackstageAuthentication auth, String accountId) read} 1. Fetch a List of Campaigns - Fetch a list of Campaigns associated with a specific partner account.
 *    <br> {@link CampaignsService#read(BackstageAuthentication auth, String accountId, String campaignId) read} 2. Fetch a Single Campaign - Fetch a single Campaign resource using the Campaign ID.
 *    <br> {@link CampaignsService#create} 3. Create a Campaign - Create a new Campaign under a specific partner account.
 *    <br> {@link CampaignsService#update} 4. Update a Campaign - Update an existing Campaign of a specific partner account.
 *    <br> {@link CampaignsService#patch} 5. Patch Campaign - Update an existing Campaign of a specific partner account.
 * </p>
 *
 * @author vladi
 * @version 1.0
 */
public interface CampaignsService {

    /**
     * Create {@link Campaign} entity
     *
     * @param auth Authentication object ({@link BackstageAuthentication})
     * @param accountId Under which {@link com.taboola.backstage.model.Account Account} the campaign is going to be created. Taken from {@link com.taboola.backstage.model.Account#getAccountId() Account.getAccountId()}
     * @param campaignOperation {@link CampaignOperation} defines campaign configuration at time of creation
     * @return Fully populated {@link Campaign} pojo
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    Campaign create(BackstageAuthentication auth, String accountId, CampaignOperation campaignOperation) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    /**
     * Read campaign entity
     *
     * @param auth Authentication object {@link BackstageAuthentication}
     * @param accountId {@link com.taboola.backstage.model.Account Account} to which {@link Campaign} belongs. Taken from {@link com.taboola.backstage.model.Account#getAccountId Account.getAccountId()}
     * @param campaignId {@link Campaign} Id. Taken from {@link Campaign#getId()} object
     * @return Fully populated {@link Campaign} pojo
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    Campaign read(BackstageAuthentication auth, String accountId, String campaignId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    /**
     * Read all campaign entities
     *
     * @param auth Authentication object {@link BackstageAuthentication}
     * @param accountId {@link com.taboola.backstage.model.Account Account} to which {@link Campaign} belongs. Taken from {@link com.taboola.backstage.model.Account#getAccountId Account.getAccountId()}
     * @return Fully populated collection of {@link Campaign} pojos
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    Results<Campaign> read(BackstageAuthentication auth, String accountId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    /**
     * Update campaign entity
     *
     * @param auth Authentication object ({@link BackstageAuthentication})
     * @param accountId {@link com.taboola.backstage.model.Account Account} to which {@link Campaign} belongs. Taken from {@link com.taboola.backstage.model.Account#getAccountId() Account.getAccountId()}
     * @param campaignId {@link Campaign} that is going to be updated. Taken from {@link Campaign#getId()} object
     * @param campaignOperation Full or partial {@link CampaignOperation} defines campaign configuration change
     * @return Fully populated {@link Campaign} pojo
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    Campaign update(BackstageAuthentication auth, String accountId, String campaignId, CampaignOperation campaignOperation) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    /**
     * Patch campaign entity, allowing to change inner Campaign entities like publisher targeting or publishers bid modifiers.
     * The main difference of this method from {@link CampaignsService#update} is the ability to receive inner object value without supplying its full state with the change.
     * Example: In case of adding one publisher to publisher targeting list the Patch requiring only this publisher value to be supplied and results with adding/removing based on supplied {@link com.taboola.backstage.model.PatchOperation operation}
     * @param auth Authentication object ({@link BackstageAuthentication})
     * @param accountId {@link com.taboola.backstage.model.Account Account} to which {@link Campaign} belongs. Taken from {@link com.taboola.backstage.model.Account#getAccountId() Account.getAccountId()}
     * @param campaignId {@link Campaign} that is going to be updated. Taken from {@link Campaign#getId()} object
     * @param campaignPatch patch object {@link CampaignPatch} defines campaign partial inner object state change
     * @return {@link CampaignPatch}
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    CampaignPatch patch(BackstageAuthentication auth, String accountId, String campaignId, CampaignPatch campaignPatch) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;
}
