package com.taboola.backstage.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.taboola.backstage.BackstageTestBase;
import com.taboola.backstage.internal.BackstageAudienceTargetingEndpoint;
import com.taboola.backstage.model.auth.BackstageAuthentication;
import com.taboola.backstage.model.media.campaigns.CampaignLookalikeAudienceTargeting;
import com.taboola.backstage.model.media.campaigns.CampaignMultiTargetingCollection;

/**
 * Created by vladi
 * Date: 4/5/2020
 * Time: 12:04 AM
 * By Taboola
 */
public class CampaignAudienceTargetingImplTest extends BackstageTestBase {

    private CampaignAudienceTargetingService testInstance;
    private BackstageAudienceTargetingEndpoint endpointMock;

    @Before
    public void beforeTest() {
        endpointMock = mock(BackstageAudienceTargetingEndpoint.class);
        testInstance = new CampaignAudienceTargetingServiceImpl(true, endpointMock);

        reset(endpointMock);
    }

    @Test
    public void testReadAudienceSegments() {
        CampaignMultiTargetingCollection<Long> audienceMultiTargeting = generateDummyAudienceMultiTargeting();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.readAudienceSegments(auth.getToken().getAccessTokenForHeader(),"accountId", "1")).thenReturn(audienceMultiTargeting);

        CampaignMultiTargetingCollection<Long> actual = testInstance.readAudienceSegments(auth, "accountId", "1");
        assertEquals("Invalid audience segment targeting", audienceMultiTargeting, actual);
        verify(endpointMock, times(1)).readAudienceSegments(auth.getToken().getAccessTokenForHeader(), "accountId", "1");
    }

    @Test
    public void testUpdateAudienceSegments() {
        CampaignMultiTargetingCollection<Long> audienceMultiTargeting = generateDummyAudienceMultiTargeting();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.updateAudienceSegments(auth.getToken().getAccessTokenForHeader(),"accountId", "2", audienceMultiTargeting)).thenReturn(audienceMultiTargeting);

        CampaignMultiTargetingCollection<Long> actual = testInstance.updateAudienceSegments(auth, "accountId", "2", audienceMultiTargeting);
        assertEquals("Invalid audience segment targeting", audienceMultiTargeting, actual);
        verify(endpointMock, times(1)).updateAudienceSegments(auth.getToken().getAccessTokenForHeader(), "accountId", "2", audienceMultiTargeting);
    }

    @Test
    public void testReadContextualSegments() {
        CampaignMultiTargetingCollection<Long> contextualMultiTargeting = generateDummyContextualMultiTargeting();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.readContextualSegments(auth.getToken().getAccessTokenForHeader(),"accountId", "1")).thenReturn(contextualMultiTargeting);

        CampaignMultiTargetingCollection<Long> actual = testInstance.readContextualSegments(auth, "accountId", "1");
        assertEquals("Invalid contextual segment targeting", contextualMultiTargeting, actual);
        verify(endpointMock, times(1)).readContextualSegments(auth.getToken().getAccessTokenForHeader(), "accountId", "1");
    }

    @Test
    public void testUpdateContextualSegments() {
        CampaignMultiTargetingCollection<Long> contextualMultiTargeting = generateDummyContextualMultiTargeting();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.updateContextualSegments(auth.getToken().getAccessTokenForHeader(),"accountId", "2", contextualMultiTargeting)).thenReturn(contextualMultiTargeting);

        CampaignMultiTargetingCollection<Long> actual = testInstance.updateContextualSegments(auth, "accountId", "2", contextualMultiTargeting);
        assertEquals("Invalid contextual segment targeting", contextualMultiTargeting, actual);
        verify(endpointMock, times(1)).updateContextualSegments(auth.getToken().getAccessTokenForHeader(), "accountId", "2", contextualMultiTargeting);
    }

    @Test
    public void testReadCustomAudience() {
        CampaignMultiTargetingCollection<Long> customAudienceTargeting = generateDummyCustomAudience();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.readCustomAudience(auth.getToken().getAccessTokenForHeader(),"accountId", "1")).thenReturn(customAudienceTargeting);

        CampaignMultiTargetingCollection<Long> actual = testInstance.readCustomAudience(auth, "accountId", "1");
        assertEquals("Invalid custom audience targeting", customAudienceTargeting, actual);
        verify(endpointMock, times(1)).readCustomAudience(auth.getToken().getAccessTokenForHeader(), "accountId", "1");
    }

    @Test
    public void testUpdateCustomAudience() {
        CampaignMultiTargetingCollection<Long> customAudienceTargeting = generateDummyCustomAudience();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.updateCustomAudience(auth.getToken().getAccessTokenForHeader(),"accountId", "2", customAudienceTargeting)).thenReturn(customAudienceTargeting);

        CampaignMultiTargetingCollection<Long> actual = testInstance.updateCustomAudience(auth, "accountId", "2", customAudienceTargeting);
        assertEquals("Invalid custom audience targeting", customAudienceTargeting, actual);
        verify(endpointMock, times(1)).updateCustomAudience(auth.getToken().getAccessTokenForHeader(), "accountId", "2", customAudienceTargeting);
    }

    @Test
    public void testReadLookalikeAudience() {
        CampaignMultiTargetingCollection<CampaignLookalikeAudienceTargeting> lookalikeAudienceTargeting = generateDummyLookalikeAudience();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.readLookalikeAudience(auth.getToken().getAccessTokenForHeader(),"accountId", "1")).thenReturn(lookalikeAudienceTargeting);

        CampaignMultiTargetingCollection<CampaignLookalikeAudienceTargeting> actual = testInstance.readLookalikeAudience(auth, "accountId", "1");
        assertEquals("Invalid lookalike audience targeting", lookalikeAudienceTargeting, actual);
        verify(endpointMock, times(1)).readLookalikeAudience(auth.getToken().getAccessTokenForHeader(), "accountId", "1");
    }

    @Test
    public void testUpdateLookalikeAudience() {
        CampaignMultiTargetingCollection<CampaignLookalikeAudienceTargeting> lookalikeAudienceTargeting = generateDummyLookalikeAudience();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.updateLookalikeAudience(auth.getToken().getAccessTokenForHeader(),"accountId", "2", lookalikeAudienceTargeting)).thenReturn(lookalikeAudienceTargeting);

        CampaignMultiTargetingCollection<CampaignLookalikeAudienceTargeting> actual = testInstance.updateLookalikeAudience(auth, "accountId", "2", lookalikeAudienceTargeting);
        assertEquals("Invalid lookalike audience targeting", lookalikeAudienceTargeting, actual);
        verify(endpointMock, times(1)).updateLookalikeAudience(auth.getToken().getAccessTokenForHeader(), "accountId", "2", lookalikeAudienceTargeting);
    }

    @Test
    public void testReadMarkingLabels() {
        CampaignMultiTargetingCollection<String> markingLabelsTargeting = generateDummyMarkingLabels();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.readMarkingLabels(auth.getToken().getAccessTokenForHeader(),"accountId", "1")).thenReturn(markingLabelsTargeting);

        CampaignMultiTargetingCollection<String> actual = testInstance.readMarkingLabels(auth, "accountId", "1");
        assertEquals("Invalid marking labels targeting", markingLabelsTargeting, actual);
        verify(endpointMock, times(1)).readMarkingLabels(auth.getToken().getAccessTokenForHeader(), "accountId", "1");
    }

    @Test
    public void testUpdateMarkingLabels() {
        CampaignMultiTargetingCollection<String> markingLabelsTargeting = generateDummyMarkingLabels();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.updateMarkingLabels(auth.getToken().getAccessTokenForHeader(),"accountId", "2", markingLabelsTargeting)).thenReturn(markingLabelsTargeting);

        CampaignMultiTargetingCollection<String> actual = testInstance.updateMarkingLabels(auth, "accountId", "2", markingLabelsTargeting);
        assertEquals("Invalid marking labels targeting", markingLabelsTargeting, actual);
        verify(endpointMock, times(1)).updateMarkingLabels(auth.getToken().getAccessTokenForHeader(), "accountId", "2", markingLabelsTargeting);
    }
}
