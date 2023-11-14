package com.taboola.backstage.services;

import com.taboola.backstage.internal.BackstageCampaignItemsEndpoint;
import com.taboola.backstage.model.Results;
import com.taboola.backstage.model.auth.BackstageAuthentication;
import com.taboola.backstage.model.media.campaigns.items.CampaignItem;
import com.taboola.backstage.model.media.campaigns.items.CampaignItemMassiveCreationOperation;
import com.taboola.backstage.model.media.campaigns.items.CampaignItemMassiveOperation;
import com.taboola.backstage.model.media.campaigns.items.CampaignItemMassiveUpdateOperation;
import com.taboola.backstage.model.media.campaigns.items.CampaignItemOperation;
import org.junit.Before;
import org.junit.Test;
import com.taboola.backstage.BackstageTestBase;
import com.taboola.backstage.model.media.campaigns.items.CampaignPerformanceVideoItem;
import com.taboola.backstage.model.media.campaigns.items.CampaignPerformanceVideoItemOperation;
import com.taboola.backstage.model.media.campaigns.items.PerformanceVideoBulkCreateOperation;
import com.taboola.backstage.model.media.campaigns.items.PerformanceVideoBulkUpdateOperation;

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
    public void testCreateItemMass() {
        CampaignItemOperation campaignItemOperation1 = generateDummyCampaignItemOperation();
        campaignItemOperation1.setUrl("http://www.dummy1.com");

        CampaignItemMassiveOperation massiveOperation = CampaignItemMassiveOperation.create().addItem(campaignItemOperation1).addItem(campaignItemOperation1);
        Results<CampaignItem> expectedResult = new Results<>(Collections.singletonList(campaignItemOperation1));

        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.createMassive(auth.getToken().getAccessTokenForHeader(),"accountId", "1", massiveOperation)).thenReturn(expectedResult);

        Results<CampaignItem> actual = testInstance.createMassive(auth, "accountId", "1", massiveOperation);
        assertEquals("Invalid campaign item result", expectedResult, actual);
        verify(endpointMock, times(1)).createMassive(any(), any(), any(), any());
    }

    @Test
    public void testCreateMassive_crossCampaigns() {
        CampaignItemOperation campaignItemOperation1 = generateDummyCampaignItemOperation();
        campaignItemOperation1.setUrl("http://www.dummy1.com");

        CampaignItemMassiveCreationOperation massiveOperation = CampaignItemMassiveCreationOperation.create();
        massiveOperation.setCampaignIds(Collections.singletonList(123L));
        massiveOperation.setItems(Collections.singletonList(campaignItemOperation1));
        Results<CampaignItem> expectedResult = new Results<>(Collections.singletonList(campaignItemOperation1));

        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.createCrossCampaignsMassive(auth.getToken().getAccessTokenForHeader(),"accountId", massiveOperation)).thenReturn(expectedResult);

        Results<CampaignItem> actual = testInstance.createMassive(auth, "accountId", massiveOperation);
        assertEquals("Invalid campaign item result", expectedResult, actual);
        verify(endpointMock, times(1)).createCrossCampaignsMassive(any(), any(), any());
    }

    @Test
    public void testCreateMassive_crossCampaigns_notPerformingValidations() {
        testInstance = new CampaignItemsServiceImpl(false, endpointMock);
        CampaignItemOperation campaignItemOperation1 = generateDummyCampaignItemOperation();
        campaignItemOperation1.setUrl(null);

        CampaignItemMassiveCreationOperation massiveOperation = CampaignItemMassiveCreationOperation.create();
        massiveOperation.setCampaignIds(Collections.singletonList(123L));
        massiveOperation.setItems(Collections.singletonList(campaignItemOperation1));
        Results<CampaignItem> expectedResult = new Results<>(Collections.singletonList(campaignItemOperation1));

        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.createCrossCampaignsMassive(auth.getToken().getAccessTokenForHeader(),"accountId", massiveOperation)).thenReturn(expectedResult);

        Results<CampaignItem> actual = testInstance.createMassive(auth, "accountId", massiveOperation);
        assertEquals("Invalid campaign item result", expectedResult, actual);
        verify(endpointMock, times(1)).createCrossCampaignsMassive(any(), any(), any());
    }

    @Test
    public void testUpdateMassive_crossCampaigns() {
        CampaignItemOperation campaignItemOperation1 = generateDummyCampaignItemOperation();
        campaignItemOperation1.setTitle("New Title");

        CampaignItemMassiveUpdateOperation massiveOperation = CampaignItemMassiveUpdateOperation.create();
        massiveOperation.setItemsToUpdate(Collections.singletonList(123L));
        massiveOperation.setBaselineItem(campaignItemOperation1);
        Results<CampaignItem> expectedResult = new Results<>(Collections.singletonList(campaignItemOperation1));

        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.updateCrossCampaignsMassive(auth.getToken().getAccessTokenForHeader(), "accountId", Boolean.TRUE, massiveOperation)).thenReturn(expectedResult);

        Results<CampaignItem> actual = testInstance.updateMassive(auth, Boolean.TRUE, "accountId", massiveOperation);
        assertEquals("Invalid campaign item result", expectedResult, actual);
        verify(endpointMock, times(1)).updateCrossCampaignsMassive(any(), any(), anyBoolean(), any());
    }

    @Test
    public void testDeleteMassive_crossCampaigns() {
        CampaignItemMassiveUpdateOperation massiveOperation = CampaignItemMassiveUpdateOperation.create();
        massiveOperation.setItemsToUpdate(Collections.singletonList(123L));
        Results<CampaignItem> expectedResult = new Results<>(Collections.emptyList());

        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.deleteCrossCampaignsMassive(auth.getToken().getAccessTokenForHeader(), "accountId", Boolean.TRUE, massiveOperation)).thenReturn(expectedResult);

        Results<CampaignItem> actual = testInstance.deleteMassive(auth, Boolean.TRUE, "accountId", massiveOperation);
        assertEquals("Invalid campaign item result", expectedResult, actual);
        verify(endpointMock, times(1)).deleteCrossCampaignsMassive(any(), any(), anyBoolean(), any());
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

    @Test
    public void testReadPerformanceVideoItems() {
        CampaignPerformanceVideoItem campaignItem = generateDummyCampaignPerformanceVideoItem();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        Results<CampaignPerformanceVideoItem> expectedResult = new Results<>(Collections.singletonList(campaignItem));
        when(endpointMock.getVideoCreatives(auth.getToken().getAccessTokenForHeader(),"accountId", "1")).thenReturn(expectedResult);

        Results<CampaignPerformanceVideoItem> actual = testInstance.readPerformanceVideoItems(auth, "accountId", "1");
        assertEquals("Invalid return value", expectedResult, actual);
        assertEquals("Invalid results", expectedResult.getResults(), actual.getResults());
        verify(endpointMock, times(1)).getVideoCreatives(any(), any(), any());
    }

    @Test
    public void testReadPerformanceVideoItem() {
        CampaignPerformanceVideoItem campaignItem = generateDummyCampaignPerformanceVideoItem();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.getVideoCreative(auth.getToken().getAccessTokenForHeader(),"accountId", "1", "2")).thenReturn(campaignItem);

        CampaignPerformanceVideoItem actual = testInstance.readPerformanceVideoItem(auth, "accountId", "1", "2");
        assertEquals("Invalid return value", campaignItem, actual);
        verify(endpointMock, times(1)).getVideoCreative(any(), any(), any(), any());
    }

    @Test
    public void testCreatePerformanceVideoItem() {
        CampaignPerformanceVideoItemOperation campaignItem = generateDummyCampaignPerformanceVideoItemOperation();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.insertVideoCreative(auth.getToken().getAccessTokenForHeader(),"accountId", "1", campaignItem)).thenReturn(campaignItem);

        CampaignPerformanceVideoItem actual = testInstance.createPerformanceVideoItem(auth, "accountId", "1", campaignItem);
        assertEquals("Invalid return value", campaignItem, actual);
        verify(endpointMock, times(1)).insertVideoCreative(any(), any(), any(), any());
    }

    @Test
    public void testUpdatePerformanceVideoItem() {
        CampaignPerformanceVideoItemOperation campaignItem = generateDummyCampaignPerformanceVideoItemOperation();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.updateVideoCreative(auth.getToken().getAccessTokenForHeader(),"accountId", "1", "2", false, campaignItem)).thenReturn(campaignItem);

        CampaignPerformanceVideoItem actual = testInstance.updatePerformanceVideoItem(auth, "accountId", "1", "2", campaignItem);
        assertEquals("Invalid return value", campaignItem, actual);
        verify(endpointMock, times(1)).updateVideoCreative(any(), any(), any(), any(), anyBoolean(), any());
    }

    @Test
    public void testDeletePerformanceVideoItem() {
        CampaignPerformanceVideoItemOperation campaignItem = generateDummyCampaignPerformanceVideoItemOperation();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.deleteVideoCreative(auth.getToken().getAccessTokenForHeader(),"accountId", "1", "2")).thenReturn(campaignItem);

        CampaignPerformanceVideoItem actual = testInstance.deletePerformanceVideoItem(auth, "accountId", "1", "2");
        assertEquals("Invalid return value", campaignItem, actual);
        verify(endpointMock, times(1)).deleteVideoCreative(any(), any(), any(), any());
    }

    @Test
    public void testBulkCreatePerformanceVideoItem() {
        CampaignPerformanceVideoItemOperation campaignItem = generateDummyCampaignPerformanceVideoItemOperation();
        PerformanceVideoBulkCreateOperation bulkCreateOperation = generateDummyPerformanceVideoBulkCreateOperation();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        Results<CampaignPerformanceVideoItem> expectedResult = new Results<>(Collections.singletonList(campaignItem));
        when(endpointMock.bulkCreateVideo(auth.getToken().getAccessTokenForHeader(),"accountId", bulkCreateOperation)).thenReturn(expectedResult);

        Results<CampaignPerformanceVideoItem> actual = testInstance.bulkCreatePerformanceVideoItem(auth, "accountId", bulkCreateOperation);
        assertEquals("Invalid return value", campaignItem, actual.getResults().iterator().next());
        verify(endpointMock, times(1)).bulkCreateVideo(any(), any(), any());
    }

    @Test
    public void testBulkUpdatePerformanceVideoItem() {
        CampaignPerformanceVideoItemOperation campaignItem = generateDummyCampaignPerformanceVideoItemOperation();
        PerformanceVideoBulkUpdateOperation bulkUpdateOperation = generateDummyPerformanceVideoBulkUpdateOperation();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        Results<CampaignPerformanceVideoItem> expectedResult = new Results<>(Collections.singletonList(campaignItem));
        when(endpointMock.bulkUpdateVideo(auth.getToken().getAccessTokenForHeader(),"accountId", false, bulkUpdateOperation)).thenReturn(expectedResult);

        Results<CampaignPerformanceVideoItem> actual = testInstance.bulkUpdatePerformanceVideoItem(auth, "accountId", bulkUpdateOperation);
        assertEquals("Invalid return value", campaignItem, actual.getResults().iterator().next());
        verify(endpointMock, times(1)).bulkUpdateVideo(any(), any(), anyBoolean(), any());
    }
}
