package com.taboola.backstage.services;

import com.taboola.backstage.BackstageTestBase;
import com.taboola.backstage.internal.BackstageDictionaryEndpoint;
import com.taboola.backstage.model.Results;
import com.taboola.backstage.model.auth.BackstageAuthentication;
import com.taboola.backstage.model.dictionary.Resource;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

/**
 * Created by vladi
 * Date: 11/23/2017
 * Time: 11:35 PM
 * By Taboola
 */
public class DictionaryServiceImplTest extends BackstageTestBase {

    private DictionaryServiceImpl testInstance;
    private BackstageDictionaryEndpoint endpointMock;

    @Before
    public void beforeTest() {
        endpointMock = mock(BackstageDictionaryEndpoint.class);
        testInstance = new DictionaryServiceImpl(endpointMock);

        reset(endpointMock);
    }

    @Test
    public void testCustom() {
        Resource resource = generateDummyResource();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        Results<Resource> results = new Results<>(Collections.singleton(resource));
        when(endpointMock.custom(auth.getToken().getAccessTokenForHeader(), "countries/US")).thenReturn(results);

        Results<Resource> actual = testInstance.custom(auth, "countries", "US");
        assertEquals("Invalid custom resource", results, actual);
        verify(endpointMock, times(1)).custom(any(), any());
    }

    @Test
    public void testGetRoot() {
        Resource resource = generateDummyResource();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        Results<Resource> results = new Results<>(Collections.singleton(resource));
        when(endpointMock.getRoot(auth.getToken().getAccessTokenForHeader())).thenReturn(results);

        Results<Resource> actual = testInstance.getRoot(auth);
        assertEquals("Invalid root resource", results, actual);
        verify(endpointMock, times(1)).getRoot(any());
    }

    @Test
    public void testGetCountries() {
        Resource resource = generateDummyResource();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        Results<Resource> results = new Results<>(Collections.singleton(resource));
        when(endpointMock.getCountries(auth.getToken().getAccessTokenForHeader())).thenReturn(results);

        Results<Resource> actual = testInstance.getCountries(auth);
        assertEquals("Invalid countries resource", results, actual);
        verify(endpointMock, times(1)).getCountries(any());
    }

    @Test
    public void testGetSpecificCountryRegions() {
        Resource resource = generateDummyResource();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        Results<Resource> results = new Results<>(Collections.singleton(resource));
        when(endpointMock.getSpecificCountryRegions(auth.getToken().getAccessTokenForHeader(), "US")).thenReturn(results);

        Results<Resource> actual = testInstance.getSpecificCountryRegions(auth, "US");
        assertEquals("Invalid specific country region resource", results, actual);
        verify(endpointMock, times(1)).getSpecificCountryRegions(any(), any());
    }

    @Test
    public void testGetSpecificCountryPostals() {
        Resource resource = generateDummyResource();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        Results<Resource> results = new Results<>(Collections.singleton(resource));
        when(endpointMock.getSpecificCountryPostals(auth.getToken().getAccessTokenForHeader(), "US")).thenReturn(results);

        Results<Resource> actual = testInstance.getSpecificCountryPostals(auth, "US");
        assertEquals("Invalid specific country postal resource", results, actual);
        verify(endpointMock, times(1)).getSpecificCountryPostals(any(), any());
    }

    @Test
    public void testGetUnitedStatesDMA() {
        Resource resource = generateDummyResource();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        Results<Resource> results = new Results<>(Collections.singleton(resource));
        when(endpointMock.getUnitedStatesDMA(auth.getToken().getAccessTokenForHeader())).thenReturn(results);

        Results<Resource> actual = testInstance.getUnitedStatesDMA(auth);
        assertEquals("Invalid USA DMA resource", results, actual);
        verify(endpointMock, times(1)).getUnitedStatesDMA(any());
    }

    @Test
    public void testGtPlatforms() {
        Resource resource = generateDummyResource();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        Results<Resource> results = new Results<>(Collections.singleton(resource));
        when(endpointMock.getPlatforms(auth.getToken().getAccessTokenForHeader())).thenReturn(results);

        Results<Resource> actual = testInstance.getPlatforms(auth);
        assertEquals("Invalid platforms resource", results, actual);
        verify(endpointMock, times(1)).getPlatforms(any());
    }
}
