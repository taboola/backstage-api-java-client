package com.taboola.backstage.internal;

import com.taboola.backstage.exceptions.BackstageAPIException;
import com.taboola.backstage.model.media.campaigns.CampaignTargetingCollection;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by vladi
 * Date: 1/15/2018
 * Time: 11:49 PM
 * By Taboola
 */
public interface BackstagePostalTargetingEndpoint {

    @POST(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/campaigns/{campaign_id}/targeting/postal_code")
    @Headers("Content-Type: application/json")
    CampaignTargetingCollection<String> update(@Header("Authorization") String accessToken,
                                               @Path("account_id") String accountId,
                                               @Path("campaign_id") String campaignId,
                                               @Body CampaignTargetingCollection<String> targeting) throws BackstageAPIException;

    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/campaigns/{campaign_id}/targeting/postal_code")
    @Headers("Content-Type: application/json")
    CampaignTargetingCollection<String> read(@Header("Authorization") String authToken,
                         @Path("account_id") String accountId,
                         @Path("campaign_id") String campaignId) throws BackstageAPIException;
}
