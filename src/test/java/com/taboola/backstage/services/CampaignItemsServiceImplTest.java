package com.taboola.backstage.services;

import com.taboola.backstage.internal.BackstageCampaignItemsEndpoint;
import com.taboola.backstage.model.Results;
import com.taboola.backstage.model.auth.BackstageAuthentication;
import com.taboola.backstage.model.media.campaigns.items.CampaignItem;
import com.taboola.backstage.model.media.campaigns.items.CampaignItemOperation;
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
        testInstance = new CampaignItemsServiceImpl(true, endpointMock);

        reset(endpointMock);
    }

    @Test
    public void testCreateItem() {
        CampaignItemOperation campaignItemOperation = generateDummyCampaignItemOperation();
        campaignItemOperation.setUrl("http://www.dummy.com");
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.createItem(auth.getToken().getAccessTokenForHeader(),"accountId", "1", campaignItemOperation)).thenReturn(campaignItemOperation);

        CampaignItem actual = testInstance.createItem(auth, "accountId", "1", campaignItemOperation);
        assertEquals("Invalid campaign item", campaignItemOperation, actual);
        verify(endpointMock, times(1)).createItem(any(), any(), any(), any());
    }

    @Test
    public void testCreateItem_notPerformingValidations() {
        testInstance = new CampaignItemsServiceImpl(false, endpointMock);
        CampaignItemOperation campaignItemOperation = generateDummyCampaignItemOperation();
        campaignItemOperation.setUrl(null);
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.createItem(auth.getToken().getAccessTokenForHeader(),"accountId", "1", campaignItemOperation)).thenReturn(campaignItemOperation);

        CampaignItem actual = testInstance.createItem(auth, "accountId", "1", campaignItemOperation);
        assertEquals("Invalid campaign item", campaignItemOperation, actual);
        verify(endpointMock, times(1)).createItem(any(), any(), any(), any());
    }

    @Test
    public void testReadItems() {
        CampaignItem campaignItem = generateDummyCampaignItem();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        Results<CampaignItem> results = new Results<>(Collections.singleton(campaignItem));
        when(endpointMock.readItems(auth.getToken().getAccessTokenForHeader(),"accountId", "1")).thenReturn(results);

        Results<CampaignItem> actual = testInstance.readItems(auth, "accountId", "1");
        assertEquals("Invalid campaign items", results, actual);
        verify(endpointMock, times(1)).readItems(any(), any(), any());
    }

    @Test
    public void testReadRSSChildrenItems() {
        CampaignItem campaignItem = generateDummyCampaignItem();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        Results<CampaignItem> results = new Results<>(Collections.singleton(campaignItem));
        when(endpointMock.readRSSChildrenItems(auth.getToken().getAccessTokenForHeader(),"accountId", "1", "2")).thenReturn(results);

        Results<CampaignItem> actual = testInstance.readRSSChildrenItems(auth, "accountId", "1", "2");
        assertEquals("Invalid campaign RSS children items", results, actual);
        verify(endpointMock, times(1)).readRSSChildrenItems(any(), any(), any(), any());
    }

    @Test
    public void testReadSpecificRSSChildItem() {
        CampaignItem campaignItem = generateDummyCampaignItem();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.readSpecificRSSChildItem(auth.getToken().getAccessTokenForHeader(),"accountId", "1", "2", "3")).thenReturn(campaignItem);

        CampaignItem actual = testInstance.readSpecificRSSChildItem(auth, "accountId", "1", "2", "3");
        assertEquals("Invalid campaign RSS specific child item", campaignItem, actual);
        verify(endpointMock, times(1)).readSpecificRSSChildItem(any(), any(), any(), any(), any());
    }

    @Test
    public void testUpdateSpecificRSSChildItem() {
        CampaignItemOperation campaignItemOperation = generateDummyCampaignItemOperation();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.updateSpecificRSSChildItem(auth.getToken().getAccessTokenForHeader(),"accountId", "1", "2", "3", campaignItemOperation)).thenReturn(campaignItemOperation);

        CampaignItem actual = testInstance.updateSpecificRSSChildItem(auth, "accountId", "1", "2", "3", campaignItemOperation);
        assertEquals("Invalid updated campaign RSS specific child item", campaignItemOperation, actual);
        verify(endpointMock, times(1)).updateSpecificRSSChildItem(any(), any(), any(), any(), any(), any());
    }


    @Test
    public void testUpdateSpecificRSSChildItem_notPerformingValidations() {
        testInstance = new CampaignItemsServiceImpl(false, endpointMock);
        CampaignItemOperation campaignItemOperation = generateDummyCampaignItemOperation();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.updateSpecificRSSChildItem(auth.getToken().getAccessTokenForHeader(),"accountId", "1", "2", "3", campaignItemOperation)).thenReturn(campaignItemOperation);

        CampaignItem actual = testInstance.updateSpecificRSSChildItem(auth, "accountId", "1", "2", "3", campaignItemOperation);
        assertEquals("Invalid updated campaign RSS specific child item", campaignItemOperation, actual);
        verify(endpointMock, times(1)).updateSpecificRSSChildItem(any(), any(), any(), any(), any(), any());
    }

    @Test
    public void testReadItem() {
        CampaignItem campaignItem = generateDummyCampaignItem();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.readItem(auth.getToken().getAccessTokenForHeader(),"accountId", "1", "2")).thenReturn(campaignItem);

        CampaignItem actual = testInstance.readItem(auth, "accountId", "1", "2");
        assertEquals("Invalid campaign item", campaignItem, actual);
        verify(endpointMock, times(1)).readItem(any(), any(), any(), any());
    }

    @Test
    public void testUpdateItem() {
        CampaignItemOperation campaignItemOperation = generateDummyCampaignItemOperation();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.updateItem(auth.getToken().getAccessTokenForHeader(),"accountId", "1", "2", campaignItemOperation)).thenReturn(campaignItemOperation);

        CampaignItem actual = testInstance.updateItem(auth, "accountId", "1", "2", campaignItemOperation);
        assertEquals("Invalid campaign item", campaignItemOperation, actual);
        verify(endpointMock, times(1)).updateItem(any(), any(), any(), any(), any());
    }


    @Test
    public void testUpdateItem_notPerformingValidations() {
        testInstance = new CampaignItemsServiceImpl(false, endpointMock);
        CampaignItemOperation campaignItemOperation = generateDummyCampaignItemOperation();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.updateItem(auth.getToken().getAccessTokenForHeader(),"accountId", "1", "2", campaignItemOperation)).thenReturn(campaignItemOperation);

        CampaignItem actual = testInstance.updateItem(auth, "accountId", "1", "2", campaignItemOperation);
        assertEquals("Invalid campaign item", campaignItemOperation, actual);
        verify(endpointMock, times(1)).updateItem(any(), any(), any(), any(), any());
    }

    @Test
    public void testDeleteItem() {
        CampaignItem campaignItem = generateDummyCampaignItem();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.deleteItem(auth.getToken().getAccessTokenForHeader(),"accountId", "1", "2")).thenReturn(campaignItem);

        CampaignItem actual = testInstance.deleteItem(auth, "accountId", "1", "2");
        assertEquals("Invalid campaign item", campaignItem, actual);
        verify(endpointMock, times(1)).deleteItem(any(), any(), any(), any());
    }
}
