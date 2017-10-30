package com.taboola.backstage.services;

import com.taboola.backstage.exceptions.BackstageAPIConnectivityException;
import com.taboola.backstage.exceptions.BackstageAPIRequestException;
import com.taboola.backstage.exceptions.BackstageAPITokenExpiredException;
import com.taboola.backstage.model.auth.BackstageAuthentication;
import com.taboola.backstage.model.media.reports.ReportFilter;
import com.taboola.backstage.model.media.reports.TopCampaignContentOptionalFilters;
import com.taboola.backstage.model.media.reports.TopCampaignContentReport;

import java.time.LocalDate;
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

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE;

    private final CommunicationHandler communicationHandler;

    public ReportsServiceImpl(CommunicationHandler communicationHandler) {
        this.communicationHandler = communicationHandler;
    }

    @Override
    public TopCampaignContentReport getTopCampaignContentReport(BackstageAuthentication auth, String accountId, LocalDate startDate, LocalDate endDate) throws BackstageAPITokenExpiredException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        return getTopCampaignContentReport(auth, accountId, startDate, endDate, Collections.emptyMap());
    }

    @Override
    public TopCampaignContentReport getTopCampaignContentReport(BackstageAuthentication auth, String accountId, LocalDate startDate, LocalDate endDate,
                                                                Map<TopCampaignContentOptionalFilters, String> filters) throws BackstageAPITokenExpiredException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return communicationHandler.request("get top campaign content report",
                () -> communicationHandler.getMediaReportsService().getTopCampaignContentReport(accessToken, accountId,
                                                                                                DATE_TIME_FORMATTER.format(startDate),
                                                                                                DATE_TIME_FORMATTER.format(endDate),
                                                                                                formatOptionalFilters(filters)));
    }

    //TODO support campaign summary dimensions

    private <T extends ReportFilter> Map<String, String> formatOptionalFilters(Map<T, String> filters) {
        return filters.entrySet().stream().collect(Collectors.toMap(e -> e.getKey().getName(), Map.Entry::getValue));
    }
}
