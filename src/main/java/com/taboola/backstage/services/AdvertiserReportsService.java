package com.taboola.backstage.services;

import com.taboola.backstage.exceptions.BackstageAPIConnectivityException;
import com.taboola.backstage.exceptions.BackstageAPIRequestException;
import com.taboola.backstage.exceptions.BackstageAPIUnauthorizedException;
import com.taboola.backstage.model.auth.BackstageAuthentication;
import com.taboola.backstage.model.media.reports.CampaignRealtimeDimensions;
import com.taboola.backstage.model.media.reports.CampaignRealtimeOptionalFilters;
import com.taboola.backstage.model.media.reports.CampaignRealtimeSummaryReport;
import com.taboola.backstage.model.media.reports.CampaignSummaryDimensions;
import com.taboola.backstage.model.media.reports.CampaignSummaryOptionalFilters;
import com.taboola.backstage.model.media.reports.CampaignSummaryReport;
import com.taboola.backstage.model.media.reports.HistoryReport;
import com.taboola.backstage.model.media.reports.TopCampaignContentOptionalFilters;
import com.taboola.backstage.model.media.reports.TopCampaignContentReport;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * Created by vladi
 * Date: 2/3/2018
 * Time: 12:22 AM
 * By Taboola
 */
public interface AdvertiserReportsService {

    /**
     * <p>
     *    The "Top Campaign Content" report is an advertiser report. This report lists the top 1000 Items of
     *    a Campaign. The report allows fetching the top 1000 Items for all Campaigns of an Account, or
     *    filter the results to include only the Items of a specific Campaign.
     * </p>
     *
     * @param auth Authentication object {@link BackstageAuthentication}
     * @param accountId Specific {@link com.taboola.backstage.model.Account Account.getId()}
     * @param startDate From {@link LocalDate} period
     * @param endDate To {@link LocalDate} period
     * @return Report data in form of {@link TopCampaignContentReport} object
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    TopCampaignContentReport getTopCampaignContentReport(BackstageAuthentication auth, String accountId,
                                                         LocalDate startDate, LocalDate endDate) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    /**
     * <p>
     *    The "Top Campaign Content" report is an advertiser report. This report lists the top 1000 Items of
     *    a Campaign. The report allows fetching the top 1000 Items for all Campaigns of an Account, or
     *    filter the results to include only the Items of a specific Campaign.
     * </p>
     *
     * @param auth Authentication object {@link BackstageAuthentication}
     * @param accountId Specific {@link com.taboola.backstage.model.Account Account.getId()}
     * @param startDate From {@link LocalDate} period
     * @param endDate To {@link LocalDate} period
     * @param filters Optional report filters ({@link TopCampaignContentOptionalFilters})
     * @return Report data in form of {@link TopCampaignContentReport} object
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    TopCampaignContentReport getTopCampaignContentReport(BackstageAuthentication auth, String accountId,
                                                         LocalDate startDate, LocalDate endDate,
                                                         Map<TopCampaignContentOptionalFilters, String> filters) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    /**
     * <p>
     *    The "Campaign Summary" report is an advertiser report. This report provides general campaign
     *    metrics such as impressions, clicks, conversions, spend, as well as performance metrics such
     *    as CTR, CPC, CPM, CPA. The report can be broken down by date, campaign, referring site,
     *    country or platform.
     * </p>
     *
     * @param auth Authentication object {@link BackstageAuthentication}
     * @param accountId Specific {@link com.taboola.backstage.model.Account Account.getId()}
     * @param startDate From {@link LocalDate} period
     * @param endDate To {@link LocalDate} period
     * @param dimension {@link CampaignSummaryDimensions} enum
     * @return Report data in form of {@link CampaignSummaryReport} object
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    CampaignSummaryReport getCampaignSummaryReport(BackstageAuthentication auth, String accountId, LocalDate startDate, LocalDate endDate, CampaignSummaryDimensions dimension) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;


    /**
     * <p>
     *    The "Campaign Summary" report is an advertiser report. This report provides general campaign
     *    metrics such as impressions, clicks, conversions, spend, as well as performance metrics such
     *    as CTR, CPC, CPM, CPA. The report can be broken down by date, campaign, referring site,
     *    country or platform.
     * </p>
     *
     * @param auth Authentication object {@link BackstageAuthentication}
     * @param accountId Specific {@link com.taboola.backstage.model.Account Account.getId()}
     * @param startDate From {@link LocalDate} period
     * @param endDate To {@link LocalDate} period
     * @param dimension {@link CampaignSummaryDimensions} enum
     * @param filters Optional report filters ({@link CampaignSummaryOptionalFilters})
     * @return Report data in form of {@link CampaignSummaryReport} object
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    CampaignSummaryReport getCampaignSummaryReport(BackstageAuthentication auth, String accountId, LocalDate startDate, LocalDate endDate,
                                                   CampaignSummaryDimensions dimension, Map<CampaignSummaryOptionalFilters, String> filters) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    CampaignRealtimeSummaryReport getCampaignRealtimeReport(BackstageAuthentication auth, String accountId, LocalDateTime startDate, LocalDateTime endDate,
                                                            CampaignRealtimeDimensions dimension, Map<CampaignRealtimeOptionalFilters, String> filters) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    /**
     *  The "History" report is an advertiser report. This report provide insight into changes done on advertiser and its entities
     *
     * @param auth Authentication object {@link BackstageAuthentication}
     * @param accountId Specific {@link com.taboola.backstage.model.Account Account.getId()}
     * @param startDate From {@link LocalDate} period
     * @param endDate To {@link LocalDate} period
     * @return Report data in form of {@link HistoryReport} object
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    HistoryReport getHistoryReport(BackstageAuthentication auth, String accountId, LocalDate startDate, LocalDate endDate) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;
}
