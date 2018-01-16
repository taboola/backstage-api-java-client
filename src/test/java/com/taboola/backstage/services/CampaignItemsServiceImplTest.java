package com.taboola.backstage.services;

import com.taboola.backstage.internal.BackstageCampaignItemsEndpoint;
import com.taboola.backstage.model.Results;
import com.taboola.backstage.model.auth.BackstageAuthentication;
import com.taboola.backstage.model.media.campaigns.items.CampaignItem;
import org.junit.Before;
import org.junit.Test;
import com.taboola.backstage.BackstageTestBase;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by vladi
 * Date: 11/23/2017
 * Time: 11:45 PM
 * By Taboola
 */
public class CampaignItemsServiceImplTest extends BackstageTestBase {

    private CampaignItemsServiceImpl testInstance;
    private BackstageCampaignItemsEndpoint endpointMock;

    @Before
    public void beforeTest() {
        endpointMock = mock(BackstageCampaignItemsEndpoint.class);
        testInstance = new CampaignItemsServiceImpl(endpointMock);

        reset(endpointMock);
    }

    @Test
    public void testCreateItem() {
        CampaignItem campaignItem = generateDummyCamppaignItem();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.createItem(auth.getToken().getAccessTokenForHeader(),"accountId", "1", campaignItem)).thenReturn(campaignItem);

        CampaignItem actual = testInstance.createItem(auth, "accountId", "1", campaignItem);
        assertEquals("Invalid campaign item", campaignItem, actual);
        verify(endpointMock, times(1)).createItem(any(), any(), any(), any());
    }

    @Test
    public void testReadItems() {
        CampaignItem campaignItem = generateDummyCamppaignItem();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        Results<CampaignItem> results = new Results<>(Collections.singleton(campaignItem));
        when(endpointMock.readItems(auth.getToken().getAccessTokenForHeader(),"accountId", "1")).thenReturn(results);

        Results<CampaignItem> actual = testInstance.readItems(auth, "accountId", "1");
        assertEquals("Invalid campaign items", results, actual);
        verify(endpointMock, times(1)).readItems(any(), any(), any());
    }

    @Test
    public void testReadRSSChildrenItems() {
        CampaignItem campaignItem = generateDummyCamppaignItem();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        Results<CampaignItem> results = new Results<>(Collections.singleton(campaignItem));
        when(endpointMock.readRSSChildrenItems(auth.getToken().getAccessTokenForHeader(),"accountId", "1", "2")).thenReturn(results);

        Results<CampaignItem> actual = testInstance.readRSSChildrenItems(auth, "accountId", "1", "2");
        assertEquals("Invalid campaign RSS children items", results, actual);
        verify(endpointMock, times(1)).readRSSChildrenItems(any(), any(), any(), any());
    }

    @Test
    public void testReadSpecificRSSChildItem() {
        CampaignItem campaignItem = generateDummyCamppaignItem();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.readSpecificRSSChildItem(auth.getToken().getAccessTokenForHeader(),"accountId", "1", "2", "3")).thenReturn(campaignItem);

        CampaignItem actual = testInstance.readSpecificRSSChildItem(auth, "accountId", "1", "2", "3");
        assertEquals("Invalid campaign RSS specific child item", campaignItem, actual);
        verify(endpointMock, times(1)).readSpecificRSSChildItem(any(), any(), any(), any(), any());
    }

    @Test
    public void testUpdateSpecificRSSChildItem() {
        CampaignItem campaignItem = generateDummyCamppaignItem();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.updateSpecificRSSChildItem(auth.getToken().getAccessTokenForHeader(),"accountId", "1", "2", "3", campaignItem)).thenReturn(campaignItem);

        CampaignItem actual = testInstance.updateSpecificRSSChildItem(auth, "accountId", "1", "2", "3", campaignItem);
        assertEquals("Invalid updated campaign RSS specific child item", campaignItem, actual);
        verify(endpointMock, times(1)).updateSpecificRSSChildItem(any(), any(), any(), any(), any(), any());
    }

    @Test
    public void testReadItem() {
        CampaignItem campaignItem = generateDummyCamppaignItem();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.readItem(auth.getToken().getAccessTokenForHeader(),"accountId", "1", "2")).thenReturn(campaignItem);

        CampaignItem actual = testInstance.readItem(auth, "accountId", "1", "2");
        assertEquals("Invalid campaign item", campaignItem, actual);
        verify(endpointMock, times(1)).readItem(any(), any(), any(), any());
    }

    @Test
    public void testUpdateItem() {
        CampaignItem campaignItem = generateDummyCamppaignItem();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.updateItem(auth.getToken().getAccessTokenForHeader(),"accountId", "1", "2", campaignItem)).thenReturn(campaignItem);

        CampaignItem actual = testInstance.updateItem(auth, "accountId", "1", "2", campaignItem);
        assertEquals("Invalid campaign item", campaignItem, actual);
        verify(endpointMock, times(1)).updateItem(any(), any(), any(), any(), any());
    }

    @Test
    public void testDeleteItem() {
        CampaignItem campaignItem = generateDummyCamppaignItem();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.deleteItem(auth.getToken().getAccessTokenForHeader(),"accountId", "1", "2")).thenReturn(campaignItem);

        CampaignItem actual = testInstance.deleteItem(auth, "accountId", "1", "2");
        assertEquals("Invalid campaign item", campaignItem, actual);
        verify(endpointMock, times(1)).deleteItem(any(), any(), any(), any());
    }
}
