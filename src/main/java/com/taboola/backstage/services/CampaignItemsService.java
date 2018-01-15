package com.taboola.backstage.services;

import com.taboola.backstage.exceptions.BackstageAPIConnectivityException;
import com.taboola.backstage.exceptions.BackstageAPIRequestException;
import com.taboola.backstage.exceptions.BackstageAPIUnauthorizedException;
import com.taboola.backstage.model.Results;
import com.taboola.backstage.model.auth.BackstageAuthentication;
import com.taboola.backstage.model.media.campaigns.items.CampaignItem;

/**
 * {@link CampaignItem} entity CRUD operations
 *
 * <p>
 *    The following operations are available via the API:
 *    <br> {@link CampaignItemsService#readItems} - Fetch a List of Items for a specific Campaign - Fetch all of the Items associated with a
 *    certain Campaign.
 *    <br> {@link CampaignItemsService#readItem} - Fetch a Single Item from a Campaign - Fetch a single Item associated with a certain
 *    Campaign.
 *    <br> {@link CampaignItemsService#createItem} - Create an Item - Create a new Item in a specific Campaign.
 *    <br> {@link CampaignItemsService#updateItem} - Update an Item - Update an existing Item.
 *    <br> {@link CampaignItemsService#deleteItem} - Delete (Stop) an Item - Move an existing Item to a 'STOPPED' status.
 *    <br> {@link CampaignItemsService#readRSSChildrenItems} - Fetch Children Items of an RSS Item
 *    <br> {@link CampaignItemsService#readSpecificRSSChildItem} - Fetch a specific Child Item of an RSS Item
 *    <br> {@link CampaignItemsService#updateSpecificRSSChildItem} - Update a child of an RSS Item
 * </p>
 *
 *
 * <p>
 *    <br>The type field defines the type of Item at hand. It is a read-only field, and its value is
 *    automatically determined from the URL supplied when creating the Item.
 *    There are two possible types of items:
 *    <br>⚫ ITEM - A simple Item, referencing a specific URL of a web page (e.g. link to an article).
 *    <br>⚫ RSS - An item with a URL referencing an RSS feed (we support mRSS format). This Item
 *    will have Children Items - an Item for each URL in its feed.
 *    <br>The handling of both these types is similar, with minor differences in the request URL.
 * </p>
 *
 * @author vladi
 * @version 1.0
 */
public interface CampaignItemsService {

    /**
     * Create a new {@link CampaignItem} in a specific {@link com.taboola.backstage.model.media.campaigns.Campaign Campaign}.
     *
     * <p>
     *    When creating a new Item, the only field acceptable is the url field. After sending the
     *    appropriate request, a new Item resource is created with a status of CRAWLING. As long as an Item
     *    has the CRAWLING status, it is in read-only state - no field can be modified.
     *    For the client-app to know when the Item has stopped crawling, and is available for edit, it
     *    needs to poll the server every couple of seconds (10 seconds is a good number to choose),
     *    requesting the Item each time, and checking whether its status has changed.
     *    Once the Item has its status changed from CRAWLING, it becomes available for edit.
     * </p>
     *
     *
     * @param auth Authentication object ({@link BackstageAuthentication})
     * @param accountId To which {@link com.taboola.backstage.model.Account Account} the campaign belongs. Taken from {@link com.taboola.backstage.model.Account#getAccountId() Account.getAccountId()}
     * @param campaignId Under what {@link com.taboola.backstage.model.media.campaigns.Campaign Campaign} the new {@link CampaignItem} is going to be create. Taken from {@link com.taboola.backstage.model.media.campaigns.Campaign#getId Campaign#getId()} object
     * @param item {@link CampaignItem} pojo with single populated field {@link CampaignItem#url url}
     * @return {@link CampaignItem} pojo with status {@link com.taboola.backstage.model.media.campaigns.items.ItemStatus#CRAWLING CRAWLING}
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    CampaignItem createItem(BackstageAuthentication auth, String accountId, String campaignId, CampaignItem item) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    /**
     * Fetch all {@link CampaignItem}  associated with a specific {@link com.taboola.backstage.model.media.campaigns.Campaign Campaign}
     * @param auth Authentication object ({@link BackstageAuthentication})
     * @param accountId To which {@link com.taboola.backstage.model.Account Account} the campaign belongs. Taken from {@link com.taboola.backstage.model.Account#getAccountId() Account.getAccountId()}
     * @param campaignId {@link com.taboola.backstage.model.media.campaigns.Campaign Campaign} Id. Taken from {@link com.taboola.backstage.model.media.campaigns.Campaign Campaign#getId()} object
     * @return Fully populated collection of {@link CampaignItem} pojos
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    Results<CampaignItem> readItems(BackstageAuthentication auth, String accountId, String campaignId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    /**
     * Fetch all children {@link CampaignItem} of an RSS item type
     * @param auth Authentication object ({@link BackstageAuthentication})
     * @param accountId To which {@link com.taboola.backstage.model.Account Account} the campaign belongs. Taken from {@link com.taboola.backstage.model.Account#getAccountId() Account.getAccountId()}
     * @param campaignId {@link com.taboola.backstage.model.media.campaigns.Campaign Campaign} Id. Taken from {@link com.taboola.backstage.model.media.campaigns.Campaign Campaign#getId()} object
     * @param itemId RSS parent id. Taken from {@link CampaignItem#getId()} with a type of RSS
     * @return Fully populated collection of {@link CampaignItem} pojos
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    Results<CampaignItem> readRSSChildrenItems(BackstageAuthentication auth, String accountId, String campaignId, Long itemId) throws BackstageAPIRequestException, BackstageAPIUnauthorizedException, BackstageAPIConnectivityException;

    /**
     * Fetch a specific child {@link CampaignItem} of {@link CampaignItem} of type RSS
     * @param auth Authentication object ({@link BackstageAuthentication})
     * @param accountId To which {@link com.taboola.backstage.model.Account Account} the campaign belongs. Taken from {@link com.taboola.backstage.model.Account#getAccountId() Account.getAccountId()}
     * @param campaignId {@link com.taboola.backstage.model.media.campaigns.Campaign Campaign} Id. Taken from {@link com.taboola.backstage.model.media.campaigns.Campaign Campaign#getId()} object
     * @param itemId RSS parent id. Taken from {@link CampaignItem#getId()} with a type of RSS
     * @param childId RSS child item id. Taken from {@link CampaignItem#getId()}
     * @return Fully populated {@link CampaignItem} pojo
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    CampaignItem readSpecificRSSChildItem(BackstageAuthentication auth, String accountId, String campaignId, Long itemId, Long childId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    /**
     * Update a child of an RSS {@link CampaignItem}
     * @param auth Authentication object ({@link BackstageAuthentication})
     * @param accountId To which {@link com.taboola.backstage.model.Account Account} the campaign belongs. Taken from {@link com.taboola.backstage.model.Account#getAccountId() Account.getAccountId()}
     * @param campaignId {@link com.taboola.backstage.model.media.campaigns.Campaign Campaign} Id. Taken from {@link com.taboola.backstage.model.media.campaigns.Campaign Campaign#getId()} object
     * @param itemId RSS parent id. Taken from {@link CampaignItem#getId()} with a type of RSS
     * @param childId RSS child item id. Taken from {@link CampaignItem#getId()}
     * @param campaignItem Full or partial {@link CampaignItem} pojo to update.
     * @return Fully populated {@link CampaignItem} pojo
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    CampaignItem updateSpecificRSSChildItem(BackstageAuthentication auth, String accountId, String campaignId, Long itemId, Long childId, CampaignItem campaignItem) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    /**
     * Fetch a single {@link CampaignItem} associated with a certain {@link com.taboola.backstage.model.media.campaigns.Campaign Campaign}
     * @param auth Authentication object ({@link BackstageAuthentication})
     * @param accountId To which {@link com.taboola.backstage.model.Account Account} the campaign belongs. Taken from {@link com.taboola.backstage.model.Account#getAccountId() Account.getAccountId()}
     * @param campaignId {@link com.taboola.backstage.model.media.campaigns.Campaign Campaign} Id. Taken from {@link com.taboola.backstage.model.media.campaigns.Campaign Campaign#getId()} object
     * @param itemId {@link CampaignItem} Id to read. Taken from {@link CampaignItem#getId()} object
     * @return Fully populated {@link CampaignItem} pojo
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    CampaignItem readItem(BackstageAuthentication auth, String accountId, String campaignId, Long itemId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    /**
     * Update an existing {@link CampaignItem}
     * @param auth Authentication object ({@link BackstageAuthentication})
     * @param accountId To which {@link com.taboola.backstage.model.Account Account} the campaign belongs. Taken from {@link com.taboola.backstage.model.Account#getAccountId() Account.getAccountId()}
     * @param campaignId {@link com.taboola.backstage.model.media.campaigns.Campaign Campaign} Id. Taken from {@link com.taboola.backstage.model.media.campaigns.Campaign Campaign#getId()} object
     * @param itemId {@link CampaignItem} Id. Taken from {@link CampaignItem#getId()} object
     * @param item Full or partial {@link CampaignItem} pojo to update.
     * @return Fully populated {@link CampaignItem} pojo
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    CampaignItem updateItem(BackstageAuthentication auth, String accountId, String campaignId, Long itemId, CampaignItem item) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    /**
     * Move an existing {@link CampaignItem} to a 'STOPPED' status.
     *
     * <p>
     *    Deleting Items is not possible in Taboola's system. Instead, the Item status is set to
     *    STOPPED, it will stop appearing in the Campaign's items list and will not be served as an ad.
     * </p>
     *
     * @param auth Authentication object ({@link BackstageAuthentication})
     * @param accountId To which {@link com.taboola.backstage.model.Account Account} the campaign belongs. Taken from {@link com.taboola.backstage.model.Account#getAccountId() Account.getAccountId()}
     * @param campaignId {@link com.taboola.backstage.model.media.campaigns.Campaign Campaign} Id. Taken from {@link com.taboola.backstage.model.media.campaigns.Campaign Campaign#getId()} object
     * @param itemId {@link CampaignItem} Id. Taken from {@link CampaignItem#getId()} object
     * @return Fully populated {@link CampaignItem} pojo
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    CampaignItem deleteItem(BackstageAuthentication auth, String accountId, String campaignId, Long itemId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;
}
