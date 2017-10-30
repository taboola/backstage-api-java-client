package com.taboola.backstage.services;

import com.taboola.backstage.exceptions.BackstageAPIConnectivityException;
import com.taboola.backstage.exceptions.BackstageAPIRequestException;
import com.taboola.backstage.exceptions.BackstageAPITokenExpiredException;
import com.taboola.backstage.model.auth.BackstageAuthentication;
import com.taboola.backstage.model.media.reports.TopCampaignContentOptionalFilters;
import com.taboola.backstage.model.media.reports.TopCampaignContentReport;

import java.time.LocalDate;
import java.util.Map;

/**
 * Created by vladi
 * Date: 10/28/2017
 * Time: 11:10 PM
 * By Taboola
 */
public interface ReportsService {

    TopCampaignContentReport getTopCampaignContentReport(BackstageAuthentication auth, String accountId,
                                                         LocalDate startDate, LocalDate endDate) throws BackstageAPITokenExpiredException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    TopCampaignContentReport getTopCampaignContentReport(BackstageAuthentication auth, String accountId,
                                                         LocalDate startDate, LocalDate endDate,
                                                         Map<TopCampaignContentOptionalFilters, String> filters) throws BackstageAPITokenExpiredException, BackstageAPIConnectivityException, BackstageAPIRequestException;
}
