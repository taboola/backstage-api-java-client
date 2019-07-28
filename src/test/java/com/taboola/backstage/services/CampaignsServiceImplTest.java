package com.taboola.backstage.services;

import com.taboola.backstage.internal.BackstageCampaignsEndpoint;
import com.taboola.backstage.model.Results;
import com.taboola.backstage.model.auth.BackstageAuthentication;
import com.taboola.backstage.model.media.campaigns.Campaign;
import com.taboola.backstage.model.media.campaigns.CampaignOperation;
import com.taboola.backstage.model.media.campaigns.CampaignPatch;
import com.taboola.backstage.model.media.campaigns.SpendingLimitModel;
import org.junit.Before;
import org.junit.Test;
import com.taboola.backstage.BackstageTestBase;

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
}
