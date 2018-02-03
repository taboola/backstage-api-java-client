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

    //TODO docs

    RevenueSummaryReport getRevenueSummaryReport(BackstageAuthentication auth, String accountId,
                                                 LocalDate startDate, LocalDate endDate, RevenueSummaryDimensions dimension) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    RevenueSummaryReport getRevenueSummaryReport(BackstageAuthentication auth, String accountId,
                                                 LocalDate startDate, LocalDate endDate, RevenueSummaryDimensions dimension,
                                                 Map<RevenueSummaryOptionalFilters, String> filters) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    VisitValueReport getVisitValueReport(BackstageAuthentication auth, String accountId,
                                         LocalDate startDate, LocalDate endDate, VisitValueDimensions dimension) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    VisitValueReport getVisitValueReport(BackstageAuthentication auth, String accountId,
                                         LocalDate startDate, LocalDate endDate, VisitValueDimensions dimension,
                                         Map<VisitValueOptionalFilters, String> filters) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    RecirculationSummaryReport getRecirculationSummaryReport(BackstageAuthentication auth, String accountId,
                                                             LocalDate startDate, LocalDate endDate, RecirculationSummaryDimensions dimension) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    RecirculationSummaryReport getRecirculationSummaryReport(BackstageAuthentication auth, String accountId,
                                                             LocalDate startDate, LocalDate endDate, RecirculationSummaryDimensions dimension,
                                                             Map<RecirculationSummaryOptionalFilters, String> filters) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

}
