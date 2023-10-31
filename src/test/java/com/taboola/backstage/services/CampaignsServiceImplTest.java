package com.taboola.backstage.services;

import com.taboola.backstage.internal.BackstageCampaignsEndpoint;
import com.taboola.backstage.model.Results;
import com.taboola.backstage.model.auth.BackstageAuthentication;
import com.taboola.backstage.model.media.campaigns.Campaign;
import com.taboola.backstage.model.media.campaigns.CampaignBase;
import com.taboola.backstage.model.media.campaigns.CampaignOperation;
import com.taboola.backstage.model.media.campaigns.CampaignPatch;
import com.taboola.backstage.model.media.campaigns.CampaignsMassiveOperation;
import com.taboola.backstage.model.media.campaigns.SpendingLimitModel;
import org.junit.Before;
import org.junit.Test;
import com.taboola.backstage.BackstageTestBase;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by vladi
 * Date: 11/23/2017
 * Time: 11:15 PM
 * By Taboola
 */
public class CampaignsServiceImplTest extends BackstageTestBase {

    private CampaignsServiceImpl testInstance;
    private BackstageCampaignsEndpoint endpointMock;

    @Before
    public void beforeTest() {
        endpointMock = mock(BackstageCampaignsEndpoint.class);
        testInstance = new CampaignsServiceImpl(true, endpointMock);

        reset(endpointMock);
    }

    @Test
    public void testCreate() {
        CampaignOperation campaignOperation = generateDummyCampaignOperation();
        campaignOperation.setName("dummy_name")
                        .setBrandingText("dummy_branding")
                        .setCpc(1d)
                        .setSpendingLimit(1d)
                        .setSpendingLimitModel(SpendingLimitModel.ENTIRE)
                        .setStartDate(new Date());
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.createCampaign(auth.getToken().getAccessTokenForHeader(),"accountId", campaignOperation)).thenReturn(campaignOperation);

        Campaign actual = testInstance.create(auth, "accountId", campaignOperation);
        assertEquals("Invalid campaignOperation", campaignOperation, actual);
        verify(endpointMock, times(1)).createCampaign(any(), any(), any());
    }

    @Test
    public void testCreate_notPerformingValidations() {
        testInstance = new CampaignsServiceImpl(false, endpointMock);
        CampaignOperation campaignOperation = generateDummyCampaignOperation();
        campaignOperation.setName(null)
                        .setBrandingText(null)
                        .setCpc(null)
                        .setSpendingLimit(null)
                        .setSpendingLimitModel(null)
                        .setStartDate(null);
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.createCampaign(auth.getToken().getAccessTokenForHeader(),"accountId", campaignOperation)).thenReturn(campaignOperation);

        Campaign actual = testInstance.create(auth, "accountId", campaignOperation);
        assertEquals("Invalid campaignOperation", campaignOperation, actual);
        verify(endpointMock, times(1)).createCampaign(any(), any(), any());
    }

    @Test
    public void testRead() {
        Campaign campaign = generateDummyCampaign();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.getCampaign(auth.getToken().getAccessTokenForHeader(),"accountId", campaign.getId())).thenReturn(campaign);

        Campaign actual = testInstance.read(auth, "accountId", campaign.getId());
        assertEquals("Invalid campaign", campaign, actual);
        verify(endpointMock, times(1)).getCampaign(any(), any(), any());
    }

    @Test
    public void testReadAllBase() {
        CampaignBase campaignBase = generateDummyCampaignBase();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        Results<CampaignBase> results = new Results<>(Collections.singleton(campaignBase));
        when(endpointMock.getAllCampaignsBase(auth.getToken().getAccessTokenForHeader(),"accountId")).thenReturn(results);

        Results<CampaignBase> actual = testInstance.readBase(auth, "accountId");
        assertEquals("Invalid campaign results", results, actual);
        verify(endpointMock, times(1)).getAllCampaignsBase(any(), any());
    }

    @Test
    public void testReadAll() {
        Campaign campaign = generateDummyCampaign();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        Results<Campaign> results = new Results<>(Collections.singleton(campaign));
        when(endpointMock.getAllCampaigns(auth.getToken().getAccessTokenForHeader(),"accountId")).thenReturn(results);

        Results<Campaign> actual = testInstance.read(auth, "accountId");
        assertEquals("Invalid campaign results", results, actual);
        verify(endpointMock, times(1)).getAllCampaigns(any(), any());
    }

    @Test
    public void testUpdate() {
        CampaignOperation campaignOperation = generateDummyCampaignOperation();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.updateCampaign(auth.getToken().getAccessTokenForHeader(),"accountId", campaignOperation.getId(), campaignOperation)).thenReturn(campaignOperation);

        Campaign actual = testInstance.update(auth, "accountId", campaignOperation.getId(), campaignOperation);
        assertEquals("Invalid campaignOperation", campaignOperation, actual);
        verify(endpointMock, times(1)).updateCampaign(any(), any(), any(), any());
    }

    @Test
    public void testUpdate_notPerformingValidations() {
        testInstance = new CampaignsServiceImpl(false, endpointMock);
        CampaignOperation campaignOperation = generateDummyCampaignOperation();
        campaignOperation.setStartDate(new Date());
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.updateCampaign(auth.getToken().getAccessTokenForHeader(),"accountId", campaignOperation.getId(), campaignOperation)).thenReturn(campaignOperation);

        Campaign actual = testInstance.update(auth, "accountId", campaignOperation.getId(), campaignOperation);
        assertEquals("Invalid campaignOperation", campaignOperation, actual);
        verify(endpointMock, times(1)).updateCampaign(any(), any(), any(), any());
    }

    @Test
    public void testUpdateMassive() {
        CampaignsMassiveOperation campaignsMassiveOperation = generateDummyCampaignsBulkOperation();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        Results<Campaign> expected = new Results<>(Collections.singleton(campaignsMassiveOperation.getUpdate()));
        when(endpointMock.updateMassiveCampaigns(auth.getToken().getAccessTokenForHeader(),"accountId", campaignsMassiveOperation)).thenReturn(expected);

        Results<Campaign> actual = testInstance.updateMassive(auth, "accountId", campaignsMassiveOperation);
        assertEquals("Invalid campaign bulk response", expected, actual);
        verify(endpointMock, times(1)).updateMassiveCampaigns(any(), any(), any());
    }

    @Test
    public void testDuplicate_withJustId() {
        CampaignOperation campaignOperation = generateDummyCampaignOperation();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.duplicateCampaign(auth.getToken().getAccessTokenForHeader(),"accountId", campaignOperation.getId())).thenReturn(campaignOperation);

        Campaign actual = testInstance.duplicate(auth, "accountId", campaignOperation.getId());
        assertEquals("Invalid campaignOperation", campaignOperation, actual);
        verify(endpointMock, times(1)).duplicateCampaign(any(), any(), any());
    }

    @Test
    public void testDuplicate_withIdAndPayload() {
        CampaignOperation campaignOperation = generateDummyCampaignOperation();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.duplicateCampaign(auth.getToken().getAccessTokenForHeader(),"accountId", campaignOperation.getId(), campaignOperation)).thenReturn(campaignOperation);

        Campaign actual = testInstance.duplicate(auth, "accountId", campaignOperation.getId(), campaignOperation);
        assertEquals("Invalid campaignOperation", campaignOperation, actual);
        verify(endpointMock, times(1)).duplicateCampaign(any(), any(), any(), any());
    }

    @Test
    public void testPatch() {
        CampaignPatch campaignPatch = generateDummyCampaignPatch();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.patchCampaign(auth.getToken().getAccessTokenForHeader(),"accountId", "123", campaignPatch)).thenReturn(campaignPatch);

        CampaignPatch actual = testInstance.patch(auth, "accountId", "123", campaignPatch);
        assertEquals("Invalid campaignPatch", campaignPatch, actual);
        verify(endpointMock, times(1)).patchCampaign(any(), any(), any(), any());
    }

    @Test
    public void testPatch_notPerformingValidations() {
        testInstance = new CampaignsServiceImpl(false, endpointMock);
        CampaignPatch campaignPatch = generateDummyCampaignPatch();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.patchCampaign(auth.getToken().getAccessTokenForHeader(),"accountId", "123", campaignPatch)).thenReturn(campaignPatch);

        CampaignPatch actual = testInstance.patch(auth, "accountId", "123", campaignPatch);
        assertEquals("Invalid campaignPatch", campaignPatch, actual);
        verify(endpointMock, times(1)).patchCampaign(any(), any(), any(), any());
    }

    @Test
    public void testDelete() {
        Campaign campaign = generateDummyCampaign();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.deleteCampaign(auth.getToken().getAccessTokenForHeader(),"accountId", campaign.getId())).thenReturn(campaign);

        Campaign actual = testInstance.delete(auth, "accountId", campaign.getId());
        assertEquals("Invalid campaign", campaign, actual);
        verify(endpointMock, times(1)).deleteCampaign(any(), any(), any());
    }

    @Test
    public void testCreate_verifyStartEndData() throws NoSuchFieldException, IllegalAccessException, ParseException {
        Date campaignEndDate = Date.from(LocalDateTime.now().plusDays(10).atZone(ZoneId.systemDefault()).toInstant());
        CampaignOperation campaignOperation = generateDummyCampaignOperation();
        campaignOperation.setName("dummy_name")
                .setBrandingText("dummy_branding")
                .setCpc(1d)
                .setSpendingLimit(1d)
                .setSpendingLimitModel(SpendingLimitModel.ENTIRE)
                .setStartDate(new Date())
                .setEndDate(campaignEndDate);
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.createCampaign(auth.getToken().getAccessTokenForHeader(),"accountId", campaignOperation)).thenReturn(campaignOperation);

        Campaign actual = testInstance.create(auth, "accountId", campaignOperation);
        Date expectedStartDate = Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        Date expectedEndDate = Date.from(LocalDate.now().plusDays(10).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());

        Field utcDateFormatField = actual.getClass().getSuperclass().getDeclaredField("EXTENDED_DATE_TIME_FORMAT");
        utcDateFormatField.setAccessible(true);
        String utcDateFormat = (String) utcDateFormatField.get(actual);
        LocalDateTime ldNow = LocalDateTime.now();
        String startDateInUtcString = ldNow.format(DateTimeFormatter.ofPattern(utcDateFormat));
        String endDateInUtcString = ldNow.plusDays(10).format(DateTimeFormatter.ofPattern(utcDateFormat));

        Field startDateInUtcField = actual.getClass().getSuperclass().getDeclaredField("startDateInUtc");
        startDateInUtcField.setAccessible(true);
        startDateInUtcField.set(actual, startDateInUtcString);
        Field endDateInUtcField = actual.getClass().getSuperclass().getDeclaredField("endDateInUtc");
        endDateInUtcField.setAccessible(true);
        endDateInUtcField.set(actual, endDateInUtcString);

        SimpleDateFormat simpleUtcDateFormat = new SimpleDateFormat(utcDateFormat);

        assertEquals("Invalid start date", expectedStartDate, actual.getStartDate());
        assertEquals("Invalid end date", expectedEndDate, actual.getEndDate());
        assertEquals("Invalid start date in utc", simpleUtcDateFormat.parse(startDateInUtcString), actual.getStartDateInUtc());
        assertEquals("Invalid end date in utc", simpleUtcDateFormat.parse(endDateInUtcString), actual.getEndDateInUtc());
        assertEquals("Invalid campaignOperation", campaignOperation, actual);
        verify(endpointMock, times(1)).createCampaign(any(), any(), any());
    }

}
