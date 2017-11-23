package com.taboola.backstage.services;

import com.taboola.backstage.BackstageTestBase;
import com.taboola.backstage.internal.BackstageCampaignsEndpoint;
import com.taboola.backstage.model.Results;
import com.taboola.backstage.model.auth.BackstageAuthentication;
import com.taboola.backstage.model.media.campaigns.Campaign;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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
        testInstance = new CampaignsServiceImpl(endpointMock);

        reset(endpointMock);
    }

    @Test
    public void testCreate() {
        Campaign campaign = generateDummyCampaign();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.createCampaign(auth.getToken().getAccessTokenForHeader(),"accountId", campaign)).thenReturn(campaign);

        Campaign actual = testInstance.create(auth, "accountId", campaign);
        assertEquals("Invalid campaign", campaign, actual);
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
        Campaign campaign = generateDummyCampaign();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.updateCampaign(auth.getToken().getAccessTokenForHeader(),"accountId", campaign.getId(), campaign)).thenReturn(campaign);

        Campaign actual = testInstance.update(auth, "accountId", campaign.getId(), campaign);
        assertEquals("Invalid campaign", campaign, actual);
        verify(endpointMock, times(1)).updateCampaign(any(), any(), any(), any());
    }
}
