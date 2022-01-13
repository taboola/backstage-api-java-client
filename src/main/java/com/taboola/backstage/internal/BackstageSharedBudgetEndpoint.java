package com.taboola.backstage.internal;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

import com.taboola.backstage.exceptions.BackstageAPIException;
import com.taboola.backstage.model.Results;
import com.taboola.backstage.model.media.campaigns.SharedBudget;
import com.taboola.backstage.model.media.campaigns.SharedBudgetBase;

public interface BackstageSharedBudgetEndpoint {

    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/shared-budget/{share_budget_id}")
    @Headers("Content-Type: application/json")
    SharedBudget getSharedBudget(@Header("Authorization") String authToken,
                                 @Path("account_id") String accountId,
                                 @Path("share_budget_id") Long shareBudgetId) throws BackstageAPIException;

    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/shared-budget/base")
    @Headers("Content-Type: application/json")
    Results<SharedBudgetBase> getAllSharedBudgetsBase(@Header("Authorization") String authToken,
                                                      @Path("account_id") String accountId) throws BackstageAPIException;

    @PUT(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/shared-budget/{share_budget_id}")
    @Headers("Content-Type: application/json")
    SharedBudget updateSharedBudget(@Header("Authorization") String accessToken,
                                    @Path("account_id") String accountId,
                                    @Path("share_budget_id") Long shareBudgetId,
                                    @Body SharedBudget sharedBudget) throws BackstageAPIException;

    @POST(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/shared-budget")
    @Headers("Content-Type: application/json")
    SharedBudget createSharedBudget(@Header("Authorization") String accessToken,
                                    @Path("account_id") String accountId,
                                    @Body SharedBudget sharedBudget) throws BackstageAPIException;

}
