package com.taboola.backstage.services;

import com.taboola.backstage.BackstageTestBase;
import com.taboola.backstage.internal.BackstagePostalTargetingEndpoint;
import com.taboola.backstage.model.auth.BackstageAuthentication;
import com.taboola.backstage.model.media.campaigns.targeting.PostalTargeting;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by vladi
 * Date: 1/16/2018
 * Time: 12:04 AM
 * By Taboola
 */
public class CampaignPostalTargetingServiceImplTest extends BackstageTestBase {

    private CampaignPostalTargetingServiceImpl testInstance;
    private BackstagePostalTargetingEndpoint endpointMock;

    @Before
    public void beforeTest() {
        endpointMock = mock(BackstagePostalTargetingEndpoint.class);
        testInstance = new CampaignPostalTargetingServiceImpl(endpointMock);

        reset(endpointMock);
    }

    @Test
    public void testRead() {
        PostalTargeting postalCodeTargeting = generateDummyPostalCodeTargeting();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.read(auth.getToken().getAccessTokenForHeader(),"accountId", "1")).thenReturn(postalCodeTargeting);

        PostalTargeting actual = testInstance.read(auth, "accountId", "1");
        assertEquals("Invalid postal code targeting", postalCodeTargeting, actual);
        verify(endpointMock, times(1)).read(any(), any(), any());
    }

    @Test
    public void testUpdate() {
        PostalTargeting postalCodeTargeting = generateDummyPostalCodeTargeting();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.update(auth.getToken().getAccessTokenForHeader(),"accountId", "2", postalCodeTargeting)).thenReturn(postalCodeTargeting);

        PostalTargeting actual = testInstance.update(auth, "accountId", "2", postalCodeTargeting);
        assertEquals("Invalid postal code targeting", postalCodeTargeting, actual);
        verify(endpointMock, times(1)).update(any(), any(), any(), any());
    }
}
