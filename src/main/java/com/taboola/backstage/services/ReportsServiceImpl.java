package com.taboola.backstage.services;

import com.taboola.backstage.exceptions.BackstageAPIConnectivityException;
import com.taboola.backstage.exceptions.BackstageAPIRequestException;
import com.taboola.backstage.exceptions.BackstageAPIUnauthorizedException;
import com.taboola.backstage.internal.BackstageInternalTools;
import com.taboola.backstage.internal.BackstageMediaReportsEndpoint;
import com.taboola.backstage.internal.BackstagePublisherReportsEndpoint;
import com.taboola.backstage.internal.BackstageRealtimeReportsEndpoint;
import com.taboola.backstage.model.ReportFilter;
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
import com.taboola.backstage.model.publishers.reports.RecirculationSummaryDimensions;
import com.taboola.backstage.model.publishers.reports.RecirculationSummaryOptionalFilters;
import com.taboola.backstage.model.publishers.reports.RecirculationSummaryReport;
import com.taboola.backstage.model.publishers.reports.RevenueSummaryDimensions;
import com.taboola.backstage.model.publishers.reports.RevenueSummaryOptionalFilters;
import com.taboola.backstage.model.publishers.reports.RevenueSummaryReport;
import com.taboola.backstage.model.publishers.reports.VisitValueDimensions;
import com.taboola.backstage.model.publishers.reports.VisitValueOptionalFilters;
import com.taboola.backstage.model.publishers.reports.VisitValueReport;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by vladi
 * Date: 10/28/2017
 * Time: 11:10 PM
 * By Taboola
 */
public class ReportsServiceImpl implements ReportsService {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE;
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    private final BackstageMediaReportsEndpoint mediaReportsEndpoint;
    private final BackstagePublisherReportsEndpoint publisherReportsService;
    private final BackstageRealtimeReportsEndpoint realtimeReportsEndpoint;
    private final BackstageInternalTools backstageInternalTools;
    private final Boolean organizeDynamicColumns;

    public ReportsServiceImpl(BackstageMediaReportsEndpoint mediaReportsEndpoint,
                              BackstagePublisherReportsEndpoint publisherReportsService,
                              BackstageRealtimeReportsEndpoint realtimeReportsEndpoint,
                              BackstageInternalTools backstageInternalTools,
                              Boolean organizeDynamicColumns) {
        this.mediaReportsEndpoint = mediaReportsEndpoint;
        this.publisherReportsService = publisherReportsService;
        this.realtimeReportsEndpoint = realtimeReportsEndpoint;
        this.backstageInternalTools = backstageInternalTools;
        this.organizeDynamicColumns = organizeDynamicColumns;
    }

    @Override
    public TopCampaignContentReport getTopCampaignContentReport(BackstageAuthentication auth, String accountId, LocalDate startDate, LocalDate endDate) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        return getTopCampaignContentReport(auth, accountId, startDate, endDate, Collections.emptyMap());
    }

    @Override
    public TopCampaignContentReport getTopCampaignContentReport(BackstageAuthentication auth, String accountId, LocalDate startDate, LocalDate endDate,
                                                                Map<TopCampaignContentOptionalFilters, String> filters) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        TopCampaignContentReport report = mediaReportsEndpoint.getTopCampaignContentReport(accessToken, accountId,
                DATE_FORMATTER.format(startDate),
                DATE_FORMATTER.format(endDate),
                formatOptionalFilters(filters));

        if(organizeDynamicColumns) {
            backstageInternalTools.attachDynamicFieldMetadataToFields(report);
        }
        return report;
    }

    @Override
    public CampaignSummaryReport getCampaignSummaryReport(BackstageAuthentication auth, String accountId, LocalDate startDate, LocalDate endDate, CampaignSummaryDimensions dimension) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        return getCampaignSummaryReport(auth, accountId, startDate, endDate, dimension, Collections.emptyMap());
    }

    @Override
    public CampaignSummaryReport getCampaignSummaryReport(BackstageAuthentication auth, String accountId, LocalDate startDate, LocalDate endDate,
                                                          CampaignSummaryDimensions dimension, Map<CampaignSummaryOptionalFilters, String> filters) {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        //TODO verify correct use of filters based on spec and save HTTP call
        CampaignSummaryReport report = mediaReportsEndpoint.getCampaignSummary(accessToken, accountId, dimension.getName(),
                DATE_FORMATTER.format(startDate), DATE_FORMATTER.format(endDate),
                formatOptionalFilters(filters));

        if(organizeDynamicColumns) {
            backstageInternalTools.attachDynamicFieldMetadataToFields(report);
        }
        return report;
    }

    @Override
    public CampaignRealtimeSummaryReport getCampaignRealtimeReport(BackstageAuthentication auth, String accountId, LocalDateTime startDate, LocalDateTime endDate, CampaignRealtimeDimensions dimension, Map<CampaignRealtimeOptionalFilters, String> filters) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        //TODO verify correct use of filters based on spec and save HTTP call
        CampaignRealtimeSummaryReport report = realtimeReportsEndpoint.getCampaignSummary(accessToken, accountId, dimension.getName(),
            DATE_TIME_FORMATTER.format(startDate),
            DATE_TIME_FORMATTER.format(endDate),
            formatOptionalFilters(filters));

        if(organizeDynamicColumns) {
            backstageInternalTools.attachDynamicFieldMetadataToFields(report);
        }
        return report;
    }

    @Override
    public HistoryReport getHistoryReport(BackstageAuthentication auth, String accountId, LocalDate startDate, LocalDate endDate) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return mediaReportsEndpoint.getCampaignHistoryByAccountReport(accessToken, accountId,
                                                                            DATE_FORMATTER.format(startDate),
                                                                            DATE_FORMATTER.format(endDate));
    }

    private <T extends ReportFilter> Map<String, String> formatOptionalFilters(Map<T, String> filters) {
        return filters.entrySet().stream().collect(Collectors.toMap(e -> e.getKey().getName(), Map.Entry::getValue));
    }

    @Override
    public RevenueSummaryReport getRevenueSummaryReport(BackstageAuthentication auth, String accountId, LocalDate startDate, LocalDate endDate,
                                                        RevenueSummaryDimensions dimension) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        return getRevenueSummaryReport(auth, accountId, startDate, endDate, dimension, Collections.emptyMap());
    }

    @Override
    public RevenueSummaryReport getRevenueSummaryReport(BackstageAuthentication auth, String accountId, LocalDate startDate, LocalDate endDate,
                                                        RevenueSummaryDimensions dimension, Map<RevenueSummaryOptionalFilters, String> filters) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        //TODO verify correct use of filters based on spec and save HTTP call
        return publisherReportsService.getRevenueSummary(accessToken, accountId, dimension.getName(),
                                                        DATE_FORMATTER.format(startDate),
                                                        DATE_FORMATTER.format(endDate),
                                                        formatOptionalFilters(filters));
    }

    @Override
    public VisitValueReport getVisitValueReport(BackstageAuthentication auth, String accountId, LocalDate startDate, LocalDate endDate,
                                                VisitValueDimensions dimension) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        return getVisitValueReport(auth, accountId, startDate, endDate, dimension, Collections.emptyMap());
    }

    @Override
    public VisitValueReport getVisitValueReport(BackstageAuthentication auth, String accountId, LocalDate startDate, LocalDate endDate,
                                                VisitValueDimensions dimension, Map<VisitValueOptionalFilters, String> filters) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        //TODO verify correct use of filters based on spec and save HTTP call
        return publisherReportsService.getVisitValue(accessToken, accountId, dimension.getName(),
                                                     DATE_FORMATTER.format(startDate),
                                                     DATE_FORMATTER.format(endDate),
                                                     formatOptionalFilters(filters));
    }

    @Override
    public RecirculationSummaryReport getRecirculationSummaryReport(BackstageAuthentication auth, String accountId, LocalDate startDate, LocalDate endDate,
                                                                    RecirculationSummaryDimensions dimension) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        return getRecirculationSummaryReport(auth, accountId, startDate, endDate, dimension, Collections.emptyMap());
    }

    @Override
    public RecirculationSummaryReport getRecirculationSummaryReport(BackstageAuthentication auth, String accountId, LocalDate startDate, LocalDate endDate,
                                                                    RecirculationSummaryDimensions dimension, Map<RecirculationSummaryOptionalFilters, String> filters) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        //TODO verify correct use of filters based on spec and save HTTP call
        return publisherReportsService.getRecirculationSummary(accessToken, accountId, dimension.getName(),
                                                               DATE_FORMATTER.format(startDate),
                                                               DATE_FORMATTER.format(endDate),
                                                               formatOptionalFilters(filters));
    }
}
