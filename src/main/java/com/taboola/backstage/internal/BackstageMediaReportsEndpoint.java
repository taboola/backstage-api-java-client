package com.taboola.backstage.internal;

import com.taboola.backstage.exceptions.BackstageAPIException;
import com.taboola.backstage.model.media.reports.CampaignSummaryReport;
import com.taboola.backstage.model.media.reports.HistoryReport;
import com.taboola.backstage.model.media.reports.TopCampaignContentReport;
import retrofit2.http.*;

import java.util.Map;

/**
 * Created by vladi
 * Date: 10/17/2017
 * Time: 11:27 PM
 * By Taboola
 */
public interface BackstageMediaReportsEndpoint {

    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/reports/top-campaign-content/dimensions/item_breakdown")
    @Headers("Content-Type: application/json")
    TopCampaignContentReport getTopCampaignContentReport(@Header("Authorization") String authToken,
                                                               @Path("account_id") String accountId,
                                                               @Query("start_date") String startDate,
                                                               @Query("end_date") String endDate,
                                                               @QueryMap Map<String, String> filters) throws BackstageAPIException;


    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/reports/campaign-summary/dimensions/{dimension}")
    @Headers("Content-Type: application/json")
    CampaignSummaryReport getCampaignSummary(@Header("Authorization") String authToken,
                                   @Path("account_id") String accountId,
                                   @Path("dimension") String dimension,
                                   @Query("start_date") String startDate,
                                   @Query("end_date") String endDate,
                                   @QueryMap Map<String, String> filters) throws BackstageAPIException;

    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/reports/campaign-history/dimensions/by_account")
    @Headers("Content-Type: application/json")
    HistoryReport getCampaignHistoryByAccountReport(@Header("Authorization") String authToken,
                                                    @Path("account_id") String accountId,
                                                    @Query("start_date") String startDate,
                                                    @Query("end_date") String endDate) throws BackstageAPIException;
}
