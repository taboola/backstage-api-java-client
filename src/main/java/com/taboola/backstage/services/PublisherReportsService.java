package com.taboola.backstage.services;

import com.taboola.backstage.exceptions.BackstageAPIConnectivityException;
import com.taboola.backstage.exceptions.BackstageAPIRequestException;
import com.taboola.backstage.exceptions.BackstageAPIUnauthorizedException;
import com.taboola.backstage.model.auth.BackstageAuthentication;
import com.taboola.backstage.model.publishers.reports.*;

import java.time.LocalDate;
import java.util.Map;

/**
 * Created by vladi
 * Date: 2/3/2018
 * Time: 12:26 AM
 * By Taboola
 */
public interface PublisherReportsService {

    /**
     * <p>
     *    The "Revenue Summary" report is a publisher report. This report provides general revenue
     *    information, as well as revenue performance statistics such as RPM, CPC and CTR. This report
     *    allows breaking down revenue performance metrics by site, page type, placement, platform and
     *    country.
     * </p>
     *
     * @param auth Authentication object {@link BackstageAuthentication}
     * @param accountId Specific {@link com.taboola.backstage.model.Account Account.getId()}
     * @param startDate From {@link LocalDate} period
     * @param endDate To {@link LocalDate} period
     * @param dimension {@link RevenueSummaryDimensions} enum
     * @return Report data in form of {@link RevenueSummaryReport} object
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    RevenueSummaryReport getRevenueSummaryReport(BackstageAuthentication auth, String accountId,
                                                 LocalDate startDate, LocalDate endDate, RevenueSummaryDimensions dimension) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    /**
     * <p>
     *    The "Revenue Summary" report is a publisher report. This report provides general revenue
     *    information, as well as revenue performance statistics such as RPM, CPC and CTR. This report
     *    allows breaking down revenue performance metrics by site, page type, placement, platform and
     *    country.
     * </p>
     *
     * @param auth Authentication object {@link BackstageAuthentication}
     * @param accountId Specific {@link com.taboola.backstage.model.Account Account.getId()}
     * @param startDate From {@link LocalDate} period
     * @param endDate To {@link LocalDate} period
     * @param dimension {@link RevenueSummaryDimensions} enum
     * @param filters Optional report filters ({@link RevenueSummaryOptionalFilters})
     * @return Report data in form of {@link RevenueSummaryReport} object
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    RevenueSummaryReport getRevenueSummaryReport(BackstageAuthentication auth, String accountId,
                                                 LocalDate startDate, LocalDate endDate, RevenueSummaryDimensions dimension,
                                                 Map<RevenueSummaryOptionalFilters, String> filters) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    /**
     * <p>
     *    The "Visit Value" report is a publisher report. This report provides revenue and engagement
     *    metrics for an entire visit, allowing to deduce the value of a visitor. This report allows breaking
     *    down that value by referral source, visit landing page, platform and country.
     * </p>
     *
     * @param auth Authentication object {@link BackstageAuthentication}
     * @param accountId Specific {@link com.taboola.backstage.model.Account Account.getId()}
     * @param startDate From {@link LocalDate} period
     * @param endDate To {@link LocalDate} period
     * @param dimension {@link VisitValueDimensions} enum
     * @return Report data in form of {@link VisitValueReport} object
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    VisitValueReport getVisitValueReport(BackstageAuthentication auth, String accountId,
                                         LocalDate startDate, LocalDate endDate, VisitValueDimensions dimension) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    /**
     * <p>
     *    The "Visit Value" report is a publisher report. This report provides revenue and engagement
     *    metrics for an entire visit, allowing to deduce the value of a visitor. This report allows breaking
     *    down that value by referral source, visit landing page, platform and country.
     * </p>
     *
     * @param auth Authentication object {@link BackstageAuthentication}
     * @param accountId Specific {@link com.taboola.backstage.model.Account Account.getId()}
     * @param startDate From {@link LocalDate} period
     * @param endDate To {@link LocalDate} period
     * @param dimension {@link VisitValueDimensions} enum
     * @param filters Optional report filters ({@link VisitValueOptionalFilters})
     * @return Report data in form of {@link VisitValueReport} object
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    VisitValueReport getVisitValueReport(BackstageAuthentication auth, String accountId,
                                         LocalDate startDate, LocalDate endDate, VisitValueDimensions dimension,
                                         Map<VisitValueOptionalFilters, String> filters) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    /**
     * <p>
     *    The "Recirculation Summary" report is a publisher report. This report provides organic content
     *    performance information such as Page Views and CTR. This report allows breaking down
     *    organic (recirculation) performance metrics by date, page type, publisher, country and platform.
     * </p>
     *
     * @param auth Authentication object {@link BackstageAuthentication}
     * @param accountId Specific {@link com.taboola.backstage.model.Account Account.getId()}
     * @param startDate From {@link LocalDate} period
     * @param endDate To {@link LocalDate} period
     * @param dimension {@link RecirculationSummaryDimensions} enum
     * @return Report data in form of {@link RecirculationSummaryReport} object
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    RecirculationSummaryReport getRecirculationSummaryReport(BackstageAuthentication auth, String accountId,
                                                             LocalDate startDate, LocalDate endDate, RecirculationSummaryDimensions dimension) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    /**
     * <p>
     *    The "Recirculation Summary" report is a publisher report. This report provides organic content
     *    performance information such as Page Views and CTR. This report allows breaking down
     *    organic (recirculation) performance metrics by date, page type, publisher, country and platform.
     * </p>
     *
     * @param auth Authentication object {@link BackstageAuthentication}
     * @param accountId Specific {@link com.taboola.backstage.model.Account Account.getId()}
     * @param startDate From {@link LocalDate} period
     * @param endDate To {@link LocalDate} period
     * @param dimension {@link RecirculationSummaryDimensions} enum
     * @param filters Optional report filters ({@link RecirculationSummaryOptionalFilters})
     * @return Report data in form of {@link RecirculationSummaryReport} object
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    RecirculationSummaryReport getRecirculationSummaryReport(BackstageAuthentication auth, String accountId,
                                                             LocalDate startDate, LocalDate endDate, RecirculationSummaryDimensions dimension,
                                                             Map<RecirculationSummaryOptionalFilters, String> filters) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

}
