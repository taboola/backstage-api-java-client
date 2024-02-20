package com.taboola.backstage.internal;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

import com.taboola.backstage.exceptions.BackstageAPIException;
import com.taboola.backstage.model.media.campaigns.CampaignLookalikeAudienceTargeting;
import com.taboola.backstage.model.media.campaigns.CampaignMultiTargetingCollection;

/**
 * Created by vladi.m
 * Date 29/04/2020
 * Time 15:31
 * Copyright Taboola
 */
public interface BackstageAudienceTargetingEndpoint {

    @POST(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/campaigns/{campaign_id}/targeting/audience_segments")
    @Headers("Content-Type: application/json")
    CampaignMultiTargetingCollection<Long> updateAudienceSegments(@Header("Authorization") String accessToken,
                                                                @Path("account_id") String accountId,
                                                                @Path("campaign_id") String campaignId,
                                                                @Body CampaignMultiTargetingCollection<Long> targeting) throws BackstageAPIException;

    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/campaigns/{campaign_id}/targeting/audience_segments")
    @Headers("Content-Type: application/json")
    CampaignMultiTargetingCollection<Long> readAudienceSegments(@Header("Authorization") String authToken,
                                                                @Path("account_id") String accountId,
                                                                @Path("campaign_id") String campaignId) throws BackstageAPIException;

    @POST(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/campaigns/{campaign_id}/targeting/contextual_segments")
    @Headers("Content-Type: application/json")
    CampaignMultiTargetingCollection<Long> updateContextualSegments(@Header("Authorization") String accessToken,
                                                                    @Path("account_id") String accountId,
                                                                    @Path("campaign_id") String campaignId,
                                                                    @Body CampaignMultiTargetingCollection<Long> targeting) throws BackstageAPIException;

    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/campaigns/{campaign_id}/targeting/contextual_segments")
    @Headers("Content-Type: application/json")
    CampaignMultiTargetingCollection<Long> readContextualSegments(@Header("Authorization") String authToken,
                                                                  @Path("account_id") String accountId,
                                                                  @Path("campaign_id") String campaignId) throws BackstageAPIException;

    @POST(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/campaigns/{campaign_id}/targeting/custom_audience")
    @Headers("Content-Type: application/json")
    CampaignMultiTargetingCollection<Long> updateCustomAudience(@Header("Authorization") String accessToken,
                                                                @Path("account_id") String accountId,
                                                                @Path("campaign_id") String campaignId,
                                                                @Body CampaignMultiTargetingCollection<Long> targeting) throws BackstageAPIException;

    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/campaigns/{campaign_id}/targeting/custom_audience")
    @Headers("Content-Type: application/json")
    CampaignMultiTargetingCollection<Long> readCustomAudience(@Header("Authorization") String authToken,
                                                              @Path("account_id") String accountId,
                                                              @Path("campaign_id") String campaignId) throws BackstageAPIException;

    @POST(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/campaigns/{campaign_id}/targeting/lookalike_audience")
    @Headers("Content-Type: application/json")
    CampaignMultiTargetingCollection<CampaignLookalikeAudienceTargeting> updateLookalikeAudience(@Header("Authorization") String accessToken,
                                                                                                 @Path("account_id") String accountId,
                                                                                                 @Path("campaign_id") String campaignId,
                                                                                                 @Body CampaignMultiTargetingCollection<CampaignLookalikeAudienceTargeting> targeting) throws BackstageAPIException;

    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/campaigns/{campaign_id}/targeting/lookalike_audience")
    @Headers("Content-Type: application/json")
    CampaignMultiTargetingCollection<CampaignLookalikeAudienceTargeting> readLookalikeAudience(@Header("Authorization") String authToken,
                                                                                               @Path("account_id") String accountId,
                                                                                               @Path("campaign_id") String campaignId) throws BackstageAPIException;

    @POST(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/campaigns/{campaign_id}/targeting/marking_labels")
    @Headers("Content-Type: application/json")
    CampaignMultiTargetingCollection<String> updateMarkingLabels(@Header("Authorization") String accessToken,
                                                                 @Path("account_id") String accountId,
                                                                 @Path("campaign_id") String campaignId,
                                                                 @Body CampaignMultiTargetingCollection<String> targeting) throws BackstageAPIException;

    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/campaigns/{campaign_id}/targeting/marking_labels")
    @Headers("Content-Type: application/json")
    CampaignMultiTargetingCollection<String> readMarkingLabels(@Header("Authorization") String authToken,
                                                               @Path("account_id") String accountId,
                                                               @Path("campaign_id") String campaignId) throws BackstageAPIException;

    @POST(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/campaigns/{campaign_id}/targeting/my_audiences")
    @Headers("Content-Type: application/json")
    CampaignMultiTargetingCollection<Long> updateMyAudiences(@Header("Authorization") String accessToken,
                                                                @Path("account_id") String accountId,
                                                                @Path("campaign_id") String campaignId,
                                                                @Body CampaignMultiTargetingCollection<Long> targeting) throws BackstageAPIException;

    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/campaigns/{campaign_id}/targeting/my_audiences")
    @Headers("Content-Type: application/json")
    CampaignMultiTargetingCollection<Long> readMyAudiences(@Header("Authorization") String authToken,
                                                           @Path("account_id") String accountId,
                                                           @Path("campaign_id") String campaignId) throws BackstageAPIException;

}
