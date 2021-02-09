/*
 * Copyright 2021 InPowered. All Rights Reserved.
 *
 * This software is the proprietary information of InPowered.
 * Use is subject to license terms.
 */
package com.taboola.backstage.internal;

import com.taboola.backstage.exceptions.BackstageAPIException;
import com.taboola.backstage.model.Results;
import com.taboola.backstage.model.media.campaigns.performancevideos.PerformanceVideoItem;
import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Performance video item endpoint.
 *
 * Created by Gabriel Diaz, 09/02/2020.
 */
public interface BackstagePerformanceVideoItemsEndpoint {

    @POST(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/campaigns/{campaign_id}/performance_video/items")
    @Headers("Content-Type: application/json")
    PerformanceVideoItem createItem(@Header("Authorization") String accessToken,
                                    @Path("account_id") String accountId,
                                    @Path("campaign_id") String campaignId,
                                    @Body PerformanceVideoItem item) throws BackstageAPIException;

    @POST(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/campaigns/{campaign_id}/performance_video/items")
    @Headers("Content-Type: multipart/form-data")
    PerformanceVideoItem uploadItem(@Header("Authorization") String accessToken,
                                    @Path("account_id") String accountId,
                                    @Path("campaign_id") String campaignId,
                                    @Body MultipartBody body) throws BackstageAPIException;

    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/campaigns/{campaign_id}/items")
    @Headers("Content-Type: application/json")
    Results<PerformanceVideoItem> readItems(@Header("Authorization") String accessToken,
                                            @Path("account_id") String accountId,
                                            @Path("campaign_id") String campaignId) throws BackstageAPIException;

    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/campaigns/{campaign_id}/performance_video/items/{item_id}")
    @Headers("Content-Type: application/json")
    PerformanceVideoItem readItem(@Header("Authorization") String accessToken,
                                  @Path("account_id") String accountId,
                                  @Path("campaign_id") String campaignId,
                                  @Path("item_id") String itemId) throws BackstageAPIException;

    @POST(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/campaigns/{campaign_id}/performance_video/items/{item_id}")
    @Headers("Content-Type: application/json")
    PerformanceVideoItem updateItem(@Header("Authorization") String accessToken,
                                    @Path("account_id") String accountId,
                                    @Path("campaign_id") String campaignId,
                                    @Path("item_id") String itemId,
                                    @Body PerformanceVideoItem item) throws BackstageAPIException;

    @DELETE(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/campaigns/{campaign_id}/performance_video/items/{item_id}")
    @Headers("Content-Type: application/json")
    PerformanceVideoItem deleteItem(@Header("Authorization") String accessToken,
                                    @Path("account_id") String accountId,
                                    @Path("campaign_id") String campaignId,
                                    @Path("item_id") String itemId) throws BackstageAPIException;

}
