package com.taboola.backstage.internal;

import com.taboola.backstage.exceptions.BackstageAPIException;
import com.taboola.backstage.model.Results;
import com.taboola.backstage.model.media.campaigns.items.CampaignItem;

import retrofit2.http.*;

/**
 * Created by vladi
 * Date: 10/16/2017
 * Time: 11:30 PM
 * By Taboola
 */
public interface BackstageCampaignItemsEndpoint {

    @POST(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/campaigns/{campaign_id}/items")
    @Headers("Content-Type: application/json")
    CampaignItem createItem(@Header("Authorization") String accessToken,
                                              @Path("account_id") String accountId,
                                              @Path("campaign_id") String campaignId,
                                              @Body CampaignItem item) throws BackstageAPIException;

    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/campaigns/{campaign_id}/items")
    @Headers("Content-Type: application/json")
    Results<CampaignItem> readItems(@Header("Authorization") String accessToken,
                                          @Path("account_id") String accountId,
                                          @Path("campaign_id") String campaignId) throws BackstageAPIException;

    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/campaigns/{campaign_id}/items/{item_id}/children")
    @Headers("Content-Type: application/json")
    Results<CampaignItem> readRSSChildrenItems(@Header("Authorization") String accessToken,
                                                     @Path("account_id") String accountId,
                                                     @Path("campaign_id") String campaignId,
                                                     @Path("item_id") String itemId) throws BackstageAPIException;

    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/campaigns/{campaign_id}/items/{item_id}/children/{child_id}")
    @Headers("Content-Type: application/json")
    CampaignItem readSpecificRSSChildItem(@Header("Authorization") String accessToken,
                                                        @Path("account_id") String accountId,
                                                        @Path("campaign_id") String campaignId,
                                                        @Path("item_id") String itemId,
                                                        @Path("child_id") String childId) throws BackstageAPIException;

    @POST(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/campaigns/{campaign_id}/items/{item_id}/children/{child_id}")
    @Headers("Content-Type: application/json")
    CampaignItem updateSpecificRSSChildItem(@Header("Authorization") String accessToken,
                                                  @Path("account_id") String accountId,
                                                  @Path("campaign_id") String campaignId,
                                                  @Path("item_id") String itemId,
                                                  @Path("child_id") String childId,
                                                  @Body CampaignItem campaignItem) throws BackstageAPIException;

    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/campaigns/{campaign_id}/items/{item_id}")
    @Headers("Content-Type: application/json")
    CampaignItem readItem(@Header("Authorization") String accessToken,
                                 @Path("account_id") String accountId,
                                 @Path("campaign_id") String campaignId,
                                 @Path("item_id") String itemId) throws BackstageAPIException;

    @POST(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/campaigns/{campaign_id}/items/{item_id}")
    @Headers("Content-Type: application/json")
    CampaignItem updateItem(@Header("Authorization") String accessToken,
                                   @Path("account_id") String accountId,
                                   @Path("campaign_id") String campaignId,
                                   @Path("item_id") String itemId,
                                   @Body CampaignItem item) throws BackstageAPIException;

    @DELETE(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/campaigns/{campaign_id}/items/{item_id}")
    @Headers("Content-Type: application/json")
    CampaignItem deleteItem(@Header("Authorization") String accessToken,
                                  @Path("account_id") String accountId,
                                  @Path("campaign_id") String campaignId,
                                  @Path("item_id") String itemId) throws BackstageAPIException;
}
