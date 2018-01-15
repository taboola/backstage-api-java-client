package com.taboola.backstage.internal;

import com.taboola.backstage.exceptions.BackstageAPIException;
import com.taboola.backstage.model.media.campaigns.targeting.PostalTargeting;
import retrofit2.http.*;

/**
 * Created by vladi
 * Date: 1/15/2018
 * Time: 11:49 PM
 * By Taboola
 */
public interface BackstagePostalTargetingEndpoint {

    @POST(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/campaigns/{campaign_id}/targeting/postal_code")
    @Headers("Content-Type: application/json")
    PostalTargeting update(@Header("Authorization") String accessToken,
                           @Path("account_id") String accountId,
                           @Path("campaign_id") String campaignId,
                           @Body PostalTargeting campaign) throws BackstageAPIException;

    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/campaigns/{campaign_id}/targeting/postal_code")
    @Headers("Content-Type: application/json")
    PostalTargeting read(@Header("Authorization") String authToken,
                         @Path("account_id") String accountId,
                         @Path("campaign_id") String campaignId) throws BackstageAPIException;
}
