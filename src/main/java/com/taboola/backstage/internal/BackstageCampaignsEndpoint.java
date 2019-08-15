package com.taboola.backstage.internal;

import com.taboola.backstage.exceptions.BackstageAPIException;
import com.taboola.backstage.model.Results;
import com.taboola.backstage.model.media.campaigns.Campaign;
import com.taboola.backstage.model.media.campaigns.CampaignPatch;

import retrofit2.http.*;

/**
 * Created by vladi
 * Date: 10/4/2017
 * Time: 10:48 PM
 * By Taboola
 */
public interface BackstageCampaignsEndpoint {

    @POST(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/campaigns")
    @Headers("Content-Type: application/json")
    Campaign createCampaign(@Header("Authorization") String accessToken,
                                  @Path("account_id") String accountId,
                                  @Body Campaign campaign) throws BackstageAPIException;

    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/campaigns")
    @Headers("Content-Type: application/json")
    Results<Campaign> getAllCampaigns(@Header("Authorization") String authToken,
                                            @Path("account_id") String accountId) throws BackstageAPIException;

    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/campaigns/{campaign_id}")
    @Headers("Content-Type: application/json")
    Campaign getCampaign(@Header("Authorization") String authToken,
                               @Path("account_id") String accountId,
                               @Path("campaign_id") String campaignId) throws BackstageAPIException;

    @POST(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/campaigns/{campaign_id}")
    @Headers("Content-Type: application/json")
    Campaign updateCampaign(@Header("Authorization") String accessToken,
                                  @Path("account_id") String accountId,
                                  @Path("campaign_id") String campaignId,
                                  @Body Campaign campaign) throws BackstageAPIException;

    @PATCH(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/campaigns/{campaign_id}")
    @Headers("Content-Type: application/json")
    CampaignPatch patchCampaign(@Header("Authorization") String accessToken,
                                @Path("account_id") String accountId,
                                @Path("campaign_id") String campaignId,
                                @Body CampaignPatch campaignPatch) throws BackstageAPIException;

    @DELETE(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/campaigns/{campaign_id}")
    @Headers("Content-Type: application/json")
    Campaign deleteCampaign(@Header("Authorization") String accessToken,
                            @Path("account_id") String accountId,
                            @Path("campaign_id") String campaignId);
}
