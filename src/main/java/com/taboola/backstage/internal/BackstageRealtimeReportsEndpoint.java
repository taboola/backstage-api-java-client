package com.taboola.backstage.internal;

import com.taboola.backstage.exceptions.BackstageAPIException;
import com.taboola.backstage.model.media.reports.CampaignRealtimeSummaryReport;
import com.taboola.backstage.model.media.reports.CampaignRealtimeSummaryRow;
import com.taboola.backstage.model.media.reports.CampaignSummaryReport;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

import java.util.Map;

/**
 * @author Gabriel Diaz, 21/12/23.
 */
public interface BackstageRealtimeReportsEndpoint {

    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/reports/realtime-campaign-summary/dimensions/{dimension}")
    @Headers("Content-Type: application/json")
    CampaignRealtimeSummaryReport getCampaignSummary(@Header("Authorization") String authToken,
                                                     @Path("account_id") String accountId,
                                                     @Path("dimension") String dimension,
                                                     @Query("start_date") String startDate,
                                                     @Query("end_date") String endDate,
                                                     @QueryMap Map<String, String> filters) throws BackstageAPIException;

}
