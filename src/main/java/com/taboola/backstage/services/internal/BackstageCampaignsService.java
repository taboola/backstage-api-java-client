package com.taboola.backstage.services.internal;

import com.taboola.backstage.model.Results;
import com.taboola.backstage.model.media.campaigns.Campaign;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * Created by vladi
 * Date: 10/4/2017
 * Time: 10:48 PM
 * By Taboola
 */
public interface BackstageCampaignsService {

    @POST(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/campaigns")
    @Headers("Content-Type: application/json")
    Call<Campaign> createCampaign(@Header("Authorization") String accessToken,
                                  @Path("account_id") String accountId,
                                  @Body Campaign campaign);

    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/campaigns")
    @Headers("Content-Type: application/json")
    Call<Results<Campaign>> getAllCampaigns(@Header("Authorization") String authToken,
                                            @Path("account_id") String accountId);

    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/campaigns/{campaign_id}")
    @Headers("Content-Type: application/json")
    Call<Campaign> getCampaign(@Header("Authorization") String authToken,
                               @Path("account_id") String accountId,
                               @Path("campaign_id") String campaignId);

    @POST(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/campaigns/{campaign_id}")
    @Headers("Content-Type: application/json")
    Call<Campaign> updateCampaign(@Header("Authorization") String accessToken,
                                  @Path("account_id") String accountId,
                                  @Path("campaign_id") String campaignId,
                                  @Body Campaign campaign);
}
