package com.taboola.backstage.services.internal;

import com.taboola.backstage.model.media.reports.TopCampaignContentReport;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

/**
 * Created by vladi
 * Date: 10/17/2017
 * Time: 11:27 PM
 * By Taboola
 */
public interface BackstageMediaReportsService {

    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/reports/top-campaign-content/dimensions/item_breakdown")
    @Headers("Content-Type: application/json")
    Call<TopCampaignContentReport> getTopCampaignContentReport(@Header("Authorization") String authToken,
                                                               @Path("account_id") String accountId,
                                                               @Query("start_date") String startDate,
                                                               @Query("end_date") String endDate,
                                                               @QueryMap Map<String, String> filters);
}
