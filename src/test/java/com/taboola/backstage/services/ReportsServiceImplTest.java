package com.taboola.backstage.services;

import com.taboola.backstage.BackstageTestBase;
import com.taboola.backstage.internal.BackstageInternalToolsImpl;
import com.taboola.backstage.internal.BackstageMediaReportsEndpoint;
import com.taboola.backstage.internal.BackstagePublisherReportsEndpoint;
import com.taboola.backstage.internal.factories.BackstageEndpointsFactory;
import com.taboola.backstage.model.auth.BackstageAuthentication;
import com.taboola.backstage.model.dynamic.DynamicField;
import com.taboola.backstage.model.dynamic.DynamicFields;
import com.taboola.backstage.model.dynamic.DynamicFieldsMetadata;
import com.taboola.backstage.model.media.reports.*;
import com.taboola.backstage.model.publishers.reports.*;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * Created by vladi
 * Date: 2/4/2018
 * Time: 11:44 PM
 * By Taboola
 */
public class ReportsServiceImplTest extends BackstageTestBase {

    private ReportsServiceImpl testInstance;
    private BackstagePublisherReportsEndpoint pubReportMock;
    private BackstageMediaReportsEndpoint advertiserReportMock;
    private BackstageInternalToolsImpl backstageInternalTools;

    @Before
    public void beforeTest() {
        pubReportMock = mock(BackstagePublisherReportsEndpoint.class);
        advertiserReportMock = mock(BackstageMediaReportsEndpoint.class);
        backstageInternalTools = new BackstageInternalToolsImpl(mock(BackstageEndpointsFactory.class));

        testInstance = new ReportsServiceImpl(advertiserReportMock, pubReportMock, backstageInternalTools,true);
        reset(pubReportMock);
        reset(advertiserReportMock);
    }

    @Test
    public void testHappyFlow_CampaignSummary() throws Exception {
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        LocalDate date = LocalDate.of(2018, 1, 2);
        String dateStr = DateTimeFormatter.ISO_LOCAL_DATE.format(date);
        CampaignSummaryReport expected = generateDummyReport(CampaignSummaryReport.class, CampaignSummaryRow.class, 3);
        when(advertiserReportMock.getCampaignSummary(auth.getToken().getAccessTokenForHeader(), "accountId",
                            CampaignSummaryDimensions.DAY.getName(), dateStr, dateStr, Collections.emptyMap())).thenReturn(expected);

        CampaignSummaryReport actual = testInstance.getCampaignSummaryReport(auth, "accountId", date, date, CampaignSummaryDimensions.DAY);
        assertNotNull("Missing report", actual);
        assertEquals("Invalid timezone", expected.getTimezone(), actual.getTimezone());
        assertEquals("Invalid last used rawdata update time", expected.getLastUsedRawdataUpdateTime(), actual.getLastUsedRawdataUpdateTime());
        Collection<CampaignSummaryRow> actualResults = actual.getResults();
        assertNotNull("Missing report results", actualResults);
        assertEquals("Invalid number of rows", 3, actualResults.size());
        assertEquals("Invalid rows", expected.getResults(), actualResults);

        verify(advertiserReportMock, times(1)).getCampaignSummary(auth.getToken().getAccessTokenForHeader(), "accountId",
                            CampaignSummaryDimensions.DAY.getName(), dateStr, dateStr, Collections.emptyMap());
    }

    @Test
    public void testHappyFlow_TopCampaignContent() throws Exception {
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        LocalDate date = LocalDate.of(2018, 1, 2);
        String dateStr = DateTimeFormatter.ISO_LOCAL_DATE.format(date);
        TopCampaignContentReport expected = generateDummyReport(TopCampaignContentReport.class, TopCampaignContentRow.class, 3);
        when(advertiserReportMock.getTopCampaignContentReport(auth.getToken().getAccessTokenForHeader(), "accountId", dateStr, dateStr, Collections.emptyMap())).thenReturn(expected);

        TopCampaignContentReport actual = testInstance.getTopCampaignContentReport(auth, "accountId", date, date);
        assertNotNull("Missing report", actual);
        assertEquals("Invalid timezone", expected.getTimezone(), actual.getTimezone());
        assertEquals("Invalid last used rawdata update time", expected.getLastUsedRawdataUpdateTime(), actual.getLastUsedRawdataUpdateTime());
        Collection<TopCampaignContentRow> actualResults = actual.getResults();
        assertNotNull("Missing report results", actualResults);
        assertEquals("Invalid number of rows", 3, actualResults.size());
        assertEquals("Invalid rows", expected.getResults(), actualResults);

        verify(advertiserReportMock, times(1))
                            .getTopCampaignContentReport(auth.getToken().getAccessTokenForHeader(), "accountId", dateStr, dateStr, Collections.emptyMap());
    }

    @Test
    public void testHappyFlow_History() throws Exception {
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        LocalDate date = LocalDate.of(2018, 1, 2);
        String dateStr = DateTimeFormatter.ISO_LOCAL_DATE.format(date);
        HistoryReport expected = generateDummyReport(HistoryReport.class, HistoryReportRow.class, 3);
        when(advertiserReportMock.getCampaignHistoryByAccountReport(auth.getToken().getAccessTokenForHeader(), "accountId", dateStr, dateStr)).thenReturn(expected);

        HistoryReport actual = testInstance.getHistoryReport(auth, "accountId", date, date);
        assertNotNull("Missing report", actual);
        assertEquals("Invalid timezone", expected.getTimezone(), actual.getTimezone());
        assertEquals("Invalid last used rawdata update time", expected.getLastUsedRawdataUpdateTime(), actual.getLastUsedRawdataUpdateTime());
        Collection<HistoryReportRow> actualResults = actual.getResults();
        assertNotNull("Missing report results", actualResults);
        assertEquals("Invalid number of rows", 3, actualResults.size());
        assertEquals("Invalid rows", expected.getResults(), actualResults);

        verify(advertiserReportMock, times(1))
                .getCampaignHistoryByAccountReport(auth.getToken().getAccessTokenForHeader(), "accountId", dateStr, dateStr);
    }

    @Test
    public void testHappyFlow_RevenueSummary() throws Exception {
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        LocalDate date = LocalDate.of(2018, 1, 2);
        String dateStr = DateTimeFormatter.ISO_LOCAL_DATE.format(date);
        RevenueSummaryReport expected = generateDummyReport(RevenueSummaryReport.class, RevenueSummaryRow.class, 3);
        when(pubReportMock.getRevenueSummary(auth.getToken().getAccessTokenForHeader(), "accountId",
                                    RevenueSummaryDimensions.DAY.getName(), dateStr, dateStr, Collections.emptyMap())).thenReturn(expected);

        RevenueSummaryReport actual = testInstance.getRevenueSummaryReport(auth, "accountId", date, date, RevenueSummaryDimensions.DAY);
        assertNotNull("Missing report", actual);
        assertEquals("Invalid timezone", expected.getTimezone(), actual.getTimezone());
        assertEquals("Invalid last used rawdata update time", expected.getLastUsedRawdataUpdateTime(), actual.getLastUsedRawdataUpdateTime());
        Collection<RevenueSummaryRow> actualResults = actual.getResults();
        assertNotNull("Missing report results", actualResults);
        assertEquals("Invalid number of rows", 3, actualResults.size());
        assertEquals("Invalid rows", expected.getResults(), actualResults);

        verify(pubReportMock, times(1)).getRevenueSummary(auth.getToken().getAccessTokenForHeader(), "accountId",
                                    RevenueSummaryDimensions.DAY.getName(), dateStr, dateStr, Collections.emptyMap());
    }

    @Test
    public void testHappyFlow_VisitValue() throws Exception {
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        LocalDate date = LocalDate.of(2018, 1, 2);
        String dateStr = DateTimeFormatter.ISO_LOCAL_DATE.format(date);
        VisitValueReport expected = generateDummyReport(VisitValueReport.class, VisitValueRow.class, 3);
        when(pubReportMock.getVisitValue(auth.getToken().getAccessTokenForHeader(), "accountId",
                                        VisitValueDimensions.DAY.getName(), dateStr, dateStr, Collections.emptyMap())).thenReturn(expected);

        VisitValueReport actual = testInstance.getVisitValueReport(auth, "accountId", date, date, VisitValueDimensions.DAY);
        assertNotNull("Missing report", actual);
        assertEquals("Invalid timezone", expected.getTimezone(), actual.getTimezone());
        assertEquals("Invalid last used rawdata update time", expected.getLastUsedRawdataUpdateTime(), actual.getLastUsedRawdataUpdateTime());
        Collection<VisitValueRow> actualResults = actual.getResults();
        assertNotNull("Missing report results", actualResults);
        assertEquals("Invalid number of rows", 3, actualResults.size());
        assertEquals("Invalid rows", expected.getResults(), actualResults);

        verify(pubReportMock, times(1)).getVisitValue(auth.getToken().getAccessTokenForHeader(), "accountId",
                                       VisitValueDimensions.DAY.getName(), dateStr, dateStr, Collections.emptyMap());
    }

    @Test
    public void testHappyFlow_RecircSummary() throws Exception {
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        LocalDate date = LocalDate.of(2018, 1, 2);
        String dateStr = DateTimeFormatter.ISO_LOCAL_DATE.format(date);
        RecirculationSummaryReport expected = generateDummyReport(RecirculationSummaryReport.class, RecirculationSummaryRow.class, 3);
        when(pubReportMock.getRecirculationSummary(auth.getToken().getAccessTokenForHeader(), "accountId",
                        RecirculationSummaryDimensions.DAY.getName(), dateStr, dateStr, Collections.emptyMap())).thenReturn(expected);

        RecirculationSummaryReport actual = testInstance.getRecirculationSummaryReport(auth, "accountId", date, date, RecirculationSummaryDimensions.DAY);
        assertNotNull("Missing report", actual);
        assertEquals("Invalid timezone", expected.getTimezone(), actual.getTimezone());
        assertEquals("Invalid last used rawdata update time", expected.getLastUsedRawdataUpdateTime(), actual.getLastUsedRawdataUpdateTime());
        Collection<RecirculationSummaryRow> actualResults = actual.getResults();
        assertNotNull("Missing report results", actualResults);
        assertEquals("Invalid number of rows", 3, actualResults.size());
        assertEquals("Invalid rows", expected.getResults(), actualResults);

        verify(pubReportMock, times(1)).getRecirculationSummary(auth.getToken().getAccessTokenForHeader(), "accountId",
                         RecirculationSummaryDimensions.DAY.getName(), dateStr, dateStr, Collections.emptyMap());
    }

    @Test
    public void campaignSummary_whenAttachDynamicMetadataFlagDisabled_expectingNullMetadataOnField() throws InstantiationException, IllegalAccessException {
        testInstance = new ReportsServiceImpl(advertiserReportMock, pubReportMock, backstageInternalTools, false);

        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        LocalDate date = LocalDate.of(2018, 1, 2);
        String dateStr = DateTimeFormatter.ISO_LOCAL_DATE.format(date);
        CampaignSummaryReport expected = generateDummyReport(CampaignSummaryReport.class, CampaignSummaryRow.class, 1,1);
        when(advertiserReportMock.getCampaignSummary(auth.getToken().getAccessTokenForHeader(), "accountId",
                CampaignSummaryDimensions.DAY.getName(), dateStr, dateStr, Collections.emptyMap())).thenReturn(expected);

        CampaignSummaryReport actual = testInstance.getCampaignSummaryReport(auth, "accountId", date, date, CampaignSummaryDimensions.DAY);
        assertNotNull("Missing report", actual);
        assertEquals("Invalid timezone", expected.getTimezone(), actual.getTimezone());
        assertEquals("Invalid last used rawdata update time", expected.getLastUsedRawdataUpdateTime(), actual.getLastUsedRawdataUpdateTime());
        Collection<CampaignSummaryRow> actualResults = actual.getResults();
        assertNotNull("Missing report results", actualResults);
        assertEquals("Invalid number of rows", 1, actualResults.size());
        assertEquals("Invalid rows", expected.getResults(), actualResults);

        assertNotNull("Expecting metadata object", actual.getMetadata());
        DynamicField actualDynamicField = actual.getResults().iterator().next().getDynamicFields().get(0);
        assertNotNull("Expecting dynamic field", actualDynamicField);
        assertNull("Expecting no metadata on dynamic fields", actualDynamicField.getDynamicFieldMetadata());

        verify(advertiserReportMock, times(1)).getCampaignSummary(auth.getToken().getAccessTokenForHeader(), "accountId",
                CampaignSummaryDimensions.DAY.getName(), dateStr, dateStr, Collections.emptyMap());
    }

    @Test
    public void campaignSummary_whenAttachDynamicMetadataFlagEnabled_expectingMetadataOnField() throws InstantiationException, IllegalAccessException {
        testInstance = new ReportsServiceImpl(advertiserReportMock, pubReportMock, backstageInternalTools, true);

        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        LocalDate date = LocalDate.of(2018, 1, 2);
        String dateStr = DateTimeFormatter.ISO_LOCAL_DATE.format(date);
        CampaignSummaryReport expected = generateDummyReport(CampaignSummaryReport.class, CampaignSummaryRow.class, 1,1);
        when(advertiserReportMock.getCampaignSummary(auth.getToken().getAccessTokenForHeader(), "accountId",
                CampaignSummaryDimensions.DAY.getName(), dateStr, dateStr, Collections.emptyMap())).thenReturn(expected);

        CampaignSummaryReport actual = testInstance.getCampaignSummaryReport(auth, "accountId", date, date, CampaignSummaryDimensions.DAY);
        assertNotNull("Missing report", actual);
        assertEquals("Invalid timezone", expected.getTimezone(), actual.getTimezone());
        assertEquals("Invalid last used rawdata update time", expected.getLastUsedRawdataUpdateTime(), actual.getLastUsedRawdataUpdateTime());
        Collection<CampaignSummaryRow> actualResults = actual.getResults();
        assertNotNull("Missing report results", actualResults);
        assertEquals("Invalid number of rows", 1, actualResults.size());
        assertEquals("Invalid rows", expected.getResults(), actualResults);

        assertNotNull("Expecting metadata object", actual.getMetadata());
        DynamicFields dynamicFields = actual.getResults().iterator().next().getDynamicFields();
        assertNotNull("Expecting dynamic fields", dynamicFields);

        DynamicFieldsMetadata dynamicFieldsMetadata = actual.getMetadata().getDynamicFields();
        for(DynamicField field : dynamicFields) {
            assertEquals("Miss match between dynamic field and its metadata", field.getId(), field.getDynamicFieldMetadata().getId());
            assertThat("Metadata does not exists", dynamicFieldsMetadata, hasItem(field.getDynamicFieldMetadata()));
        }

        verify(advertiserReportMock, times(1)).getCampaignSummary(auth.getToken().getAccessTokenForHeader(), "accountId",
                CampaignSummaryDimensions.DAY.getName(), dateStr, dateStr, Collections.emptyMap());
    }
}
