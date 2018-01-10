package com.taboola.backstage.services;

import com.taboola.backstage.exceptions.BackstageAPIConnectivityException;
import com.taboola.backstage.exceptions.BackstageAPIRequestException;
import com.taboola.backstage.exceptions.BackstageAPIUnauthorizedException;
import com.taboola.backstage.model.auth.BackstageAuthentication;
import com.taboola.backstage.model.media.reports.*;

import java.time.LocalDate;
import java.util.Map;

/**
 * Reports
 *
 * <p>
 *    It’s important to note that data in Taboola reports can (and will) change retroactively during the
 *    Taboola billing cycle. This can happen because of multiple reasons, including, but not limited to
 *    - billing rules that define guarantees as per average monthly RPMs, changes in billing rules
 *    during the billing cycle, click or impression fraud that is credited, conversions that arrive out of
 *    order.
 * </p>
 * <p>
 *    This means that when fetching reports data from Taboola for a data warehouse or BI solution,
 *    the data for the entire billing cycle (current calendar month + previous calendar month up to the
 *    5th in any given month) should be periodically refreshed.
 * </p>
 *
 * <p>
 *    Note: the dimensions are the equivalent of the different tabs of the relevant report in Backstage,
 *    Taboola’s management system for advertisers and publishers
 * </p>
 * @author vladi
 * @version 1.0
 */
public interface ReportsService {

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
    CampaignSummaryReport getCampaignSummeryReport(BackstageAuthentication auth, String accountId, LocalDate startDate, LocalDate endDate, CampaignSummaryDimensions dimension) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;


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
    CampaignSummaryReport getCampaignSummeryReport(BackstageAuthentication auth, String accountId, LocalDate startDate, LocalDate endDate,
                                                   CampaignSummaryDimensions dimension, Map<CampaignSummaryOptionalFilters, String> filters) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;
}
