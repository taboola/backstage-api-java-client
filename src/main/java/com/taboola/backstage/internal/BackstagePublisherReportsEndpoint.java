package com.taboola.backstage.internal;

import com.taboola.backstage.exceptions.BackstageAPIException;
import com.taboola.backstage.model.publishers.reports.RecirculationSummaryReport;
import com.taboola.backstage.model.publishers.reports.RevenueSummaryReport;
import com.taboola.backstage.model.publishers.reports.VisitValueReport;
import retrofit2.http.*;

import java.util.Map;

/**
 * Created by vladi
 * Date: 2/3/2018
 * Time: 10:25 PM
 * By Taboola
 */
public interface BackstagePublisherReportsEndpoint {


    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/reports/revenue-summary/dimensions/{dimension}")
    @Headers("Content-Type: application/json")
    RevenueSummaryReport getRevenueSummary(@Header("Authorization") String authToken,
                                           @Path("account_id") String accountId,
                                           @Path("dimension") String dimension,
                                           @Query("start_date") String startDate,
                                           @Query("end_date") String endDate,
                                           @QueryMap Map<String, String> filters) throws BackstageAPIException;

    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/reports/visit-value/dimensions/{dimension}")
    @Headers("Content-Type: application/json")
    VisitValueReport getVisitValue(@Header("Authorization") String authToken,
                                   @Path("account_id") String accountId,
                                   @Path("dimension") String dimension,
                                   @Query("start_date") String startDate,
                                   @Query("end_date") String endDate,
                                   @QueryMap Map<String, String> filters) throws BackstageAPIException;

    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/reports/recirc-summary/dimensions/{dimension}")
    @Headers("Content-Type: application/json")
    RecirculationSummaryReport getRecirculationSummary(@Header("Authorization") String authToken,
                                                       @Path("account_id") String accountId,
                                                       @Path("dimension") String dimension,
                                                       @Query("start_date") String startDate,
                                                       @Query("end_date") String endDate,
                                                       @QueryMap Map<String, String> filters) throws BackstageAPIException;
}
