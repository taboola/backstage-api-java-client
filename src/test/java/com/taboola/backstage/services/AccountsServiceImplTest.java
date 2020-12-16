package com.taboola.backstage.services;

import com.taboola.backstage.internal.BackstageAccountEndpoint;
import com.taboola.backstage.model.Account;
import com.taboola.backstage.model.Results;
import com.taboola.backstage.model.auth.BackstageAuthentication;
import com.taboola.backstage.model.media.account.AccountBlockedPublishers;
import org.junit.Before;
import org.junit.Test;
import com.taboola.backstage.BackstageTestBase;
import com.taboola.backstage.model.dictionary.AudienceSegment;
import com.taboola.backstage.model.dictionary.LookalikeAudience;
import com.taboola.backstage.model.media.account.AccountBlockedPublishersPatch;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by vladi
 * Date: 1/15/2018
 * Time: 11:20 PM
 * By Taboola
 */
public class AccountsServiceImplTest extends BackstageTestBase {

    private BackstageAccountEndpoint accountsEndpointMock;
    private AccountsServiceImpl testInstance;

    @Before
    public void beforeTest() {
        accountsEndpointMock = mock(BackstageAccountEndpoint.class);
        testInstance = new AccountsServiceImpl(false, accountsEndpointMock);

        reset(accountsEndpointMock);
    }

    @Test
    public void testReadAllowedAccounts(){
        Account account = generateDummyAccount();
        Results<Account> expected = new Results<>(Collections.singleton(account));
        when(accountsEndpointMock.getAvailablePublishersUnderTaboolaNetwork(any())).thenReturn(expected);

        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        Results<Account> actual = testInstance.readPublishersUnderTaboolaNetwork(auth);
        assertEquals("Invalid accounts", expected, actual);
    }

    @Test
    public void testReadAudienceSegments(){
        AudienceSegment audienceSegment = generateDummyAudienceSegment();
        Results<AudienceSegment> expected = new Results<>(Collections.singleton(audienceSegment));
        when(accountsEndpointMock.getAllAudienceSegments(any(), any())).thenReturn(expected);

        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        Results<AudienceSegment> actual = testInstance.readAudienceSegments(auth, "123");
        assertEquals("Invalid accounts", expected, actual);
    }

    @Test
    public void testReadAudienceSegmentsByCountry(){
        AudienceSegment audienceSegment = generateDummyAudienceSegment();
        Results<AudienceSegment> expected = new Results<>(Collections.singleton(audienceSegment));
        when(accountsEndpointMock.getSpecificCountryAudienceSegments(any(), any(), any())).thenReturn(expected);

        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        Results<AudienceSegment> actual = testInstance.readAudienceSegments(auth, "123", "US");
        assertEquals("Invalid accounts", expected, actual);
    }

    @Test
    public void testReadLookalikeAudiences(){
        LookalikeAudience lookalikeAudience = generateDummyLookalikeAudiences();
        Results<LookalikeAudience> expected = new Results<>(Collections.singleton(lookalikeAudience));
        when(accountsEndpointMock.getLookalikeAudiences(any(), any())).thenReturn(expected);

        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        Results<LookalikeAudience> actual = testInstance.readLookalikeAudiences(auth, "123");
        assertEquals("Invalid accounts", expected, actual);
    }

    @Test
    public void testReadLookalikeAudiencesByCountry(){
        LookalikeAudience lookalikeAudience = generateDummyLookalikeAudiences();
        Results<LookalikeAudience> expected = new Results<>(Collections.singleton(lookalikeAudience));
        when(accountsEndpointMock.getSpecificCountryLookalikeAudiences(any(), any(), any())).thenReturn(expected);

        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        Results<LookalikeAudience> actual = testInstance.readSpecificCountryLookalikeAudiences(auth, "123", "US");
        assertEquals("Invalid accounts", expected, actual);
    }

    @Test
    public void testReadAccountBlockedPublishers() {
        AccountBlockedPublishers publishers = generateDummyAccountBlockedPublishers();
        when(accountsEndpointMock.getAccountBlockedPublishers(any(), any())).thenReturn(publishers);

        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        AccountBlockedPublishers actual = testInstance.readAccountBlockedPublishers(auth, "123");
        assertEquals("Invalid publishers", publishers, actual);
    }

    @Test
    public void testCreateReadAccountBlockedPublishers() {
        AccountBlockedPublishers blockedPublishers = generateDummyAccountBlockedPublishers();
        when(accountsEndpointMock.createAccountBlockedPublishers(any(), any(), any())).thenReturn(blockedPublishers);

        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        AccountBlockedPublishers actual = testInstance.createAccountBlockedPublishers(auth, "123", blockedPublishers);
        assertEquals("Invalid blockedPublishers", blockedPublishers, actual);
    }

    @Test
    public void testPatchAccountBlockedPublishers() {
        AccountBlockedPublishersPatch blockedPublishersPatch = generateDummyAccountBlockedPublishersPatch();
        when(accountsEndpointMock.patchAccountBlockedPublishers(any(), any(), any())).thenReturn(blockedPublishersPatch);

        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        AccountBlockedPublishersPatch actual = testInstance.patchAccountBlockedPublishers(auth, "123", blockedPublishersPatch);
        assertEquals("Invalid blockedPublishersPatch", blockedPublishersPatch, actual);
    }
}
