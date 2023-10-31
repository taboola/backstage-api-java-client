package com.taboola.backstage.services;

import com.taboola.backstage.exceptions.BackstageAPIConnectivityException;
import com.taboola.backstage.exceptions.BackstageAPIRequestException;
import com.taboola.backstage.exceptions.BackstageAPIUnauthorizedException;
import com.taboola.backstage.model.Results;
import com.taboola.backstage.model.auth.BackstageAuthentication;
import com.taboola.backstage.model.media.campaigns.SharedBudgetBase;
import com.taboola.backstage.model.media.campaigns.SharedBudgetOperation;
import com.taboola.backstage.model.media.campaigns.SharedBudget;

/**
 * {@link SharedBudget} entity CRUD operations
 *
 * <p>
 *    The following operations are available via the API:
 *    <br> {@link SharedBudgetService#read(BackstageAuthentication, String, Long) read} 1. Fetch a single SharedBudget resource using the SharedBudget ID.
 *    <br> {@link SharedBudgetService#readBase(BackstageAuthentication auth, String accountId) read} 2. Fetch a list of SharedBudgetBase associated with a specific partner account.
 *    <br> {@link SharedBudgetService#create} 3. Create a SharedBudget - Create a new SharedBudget under a specific partner account.
 *    <br> {@link SharedBudgetService#update} 4. Update a SharedBudget - Update an existing SharedBudget of a specific partner account.
 * </p>
 *
 * @author vladi
 * @version 1.1.1
 */
public interface SharedBudgetService {

    /**
     * Create {@link SharedBudget} entity
     *
     * @param auth Authentication object ({@link BackstageAuthentication})
     * @param accountId Under which {@link com.taboola.backstage.model.Account Account} the SharedBudget is going to be created. Taken from {@link com.taboola.backstage.model.Account#getAccountId() Account.getAccountId()}
     * @param sharedBudgetOperation {@link SharedBudgetOperation} defines SharedBudget configuration at time of creation
     * @return Fully populated {@link SharedBudget} pojo
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    SharedBudget create(BackstageAuthentication auth, String accountId, SharedBudgetOperation sharedBudgetOperation) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    /**
     * Update {@link SharedBudget} entity
     *
     * @param auth Authentication object ({@link BackstageAuthentication})
     * @param accountId {@link com.taboola.backstage.model.Account Account} to which {@link SharedBudget} belongs. Taken from {@link com.taboola.backstage.model.Account#getAccountId Account.getAccountId()}
     * @param shareBudgetId {@link SharedBudget} Id. Taken from {@link SharedBudget#getId()} object
     * @param sharedBudgetOperation {@link SharedBudgetOperation} defines SharedBudget configuration at time of creation
     * @return Fully populated {@link SharedBudget} pojo
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    SharedBudget update(BackstageAuthentication auth, String accountId, Long shareBudgetId, SharedBudgetOperation sharedBudgetOperation) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    /**
     * Read {@link SharedBudget} entity
     *
     * @param auth Authentication object ({@link BackstageAuthentication})
     * @param accountId {@link com.taboola.backstage.model.Account Account} to which {@link SharedBudget} belongs. Taken from {@link com.taboola.backstage.model.Account#getAccountId Account.getAccountId()}
     * @param shareBudgetId {@link SharedBudget} Id. Taken from {@link SharedBudget#getId()} object
     * @return Fully populated {@link SharedBudget} pojo
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    SharedBudget read(BackstageAuthentication auth, String accountId, Long shareBudgetId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    /**
     * Read all {@link SharedBudgetBase} base entities, will return partial entity fields
     *
     * @param auth Authentication object ({@link BackstageAuthentication})
     * @param accountId {@link com.taboola.backstage.model.Account Account} to which {@link SharedBudgetBase} belongs. Taken from {@link com.taboola.backstage.model.Account#getAccountId Account.getAccountId()}
     * @return Fully populated {@link SharedBudgetBase} pojo
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    Results<SharedBudgetBase> readBase(BackstageAuthentication auth, String accountId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;
}
