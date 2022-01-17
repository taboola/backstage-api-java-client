package com.taboola.backstage.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.taboola.backstage.BackstageTestBase;
import com.taboola.backstage.internal.BackstageSharedBudgetEndpoint;
import com.taboola.backstage.model.Results;
import com.taboola.backstage.model.auth.BackstageAuthentication;
import com.taboola.backstage.model.media.campaigns.SharedBudget;
import com.taboola.backstage.model.media.campaigns.SharedBudgetBase;
import com.taboola.backstage.model.media.campaigns.SharedBudgetOperation;
import com.taboola.backstage.model.media.campaigns.SpendingLimitModel;

/**
 * Created by vladi
 * Date: 01/13/2022
 * Time: 13:00 PM
 * By Taboola
 */
public class SharedBudgetServiceImplTest extends BackstageTestBase {

    private SharedBudgetServiceImpl testInstance;
    private BackstageSharedBudgetEndpoint endpointMock;

    @Before
    public void beforeTest() {
        endpointMock = mock(BackstageSharedBudgetEndpoint.class);
        testInstance = new SharedBudgetServiceImpl(true, endpointMock);

        reset(endpointMock);
    }

    @Test
    public void testCreate() {
        SharedBudgetOperation sharedBudgetOperation = generateDummySharedBudgetOperation();
        sharedBudgetOperation.setName("dummy_name")
                        .setSpendingLimit(1d)
                        .setSpendingLimitModel(SpendingLimitModel.ENTIRE)
                        .setStartDate(new Date());
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.createSharedBudget(auth.getToken().getAccessTokenForHeader(),"accountId", sharedBudgetOperation)).thenReturn(sharedBudgetOperation);

        SharedBudget actual = testInstance.create(auth, "accountId", sharedBudgetOperation);
        assertEquals("Invalid share budget", sharedBudgetOperation, actual);
        verify(endpointMock, times(1)).createSharedBudget(any(), any(), any());
    }

    @Test
    public void testCreate_notPerformingValidations() {
        testInstance = new SharedBudgetServiceImpl(false, endpointMock);
        SharedBudgetOperation sharedBudgetOperation = generateDummySharedBudgetOperation();
        sharedBudgetOperation.setName(null)
                .setSpendingLimit(null)
                .setSpendingLimitModel(null)
                .setMarketingObjective(null)
                .setStartDate(null);
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.createSharedBudget(auth.getToken().getAccessTokenForHeader(),"accountId", sharedBudgetOperation)).thenReturn(sharedBudgetOperation);

        SharedBudget actual = testInstance.create(auth, "accountId", sharedBudgetOperation);
        assertEquals("Invalid share budget", sharedBudgetOperation, actual);
        verify(endpointMock, times(1)).createSharedBudget(any(), any(), any());
    }

    @Test
    public void testRead() {
        SharedBudgetOperation sharedBudgetOperation = generateDummySharedBudgetOperation();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.getSharedBudget(auth.getToken().getAccessTokenForHeader(),"accountId", sharedBudgetOperation.getId())).thenReturn(sharedBudgetOperation);

        SharedBudget actual = testInstance.read(auth, "accountId", sharedBudgetOperation.getId());
        assertEquals("Invalid share budget", sharedBudgetOperation, actual);
        verify(endpointMock, times(1)).getSharedBudget(any(), any(), any());
    }

    @Test
    public void testReadAllBase() {
        SharedBudgetBase sharedBudgetBase = generateDummyShareBudgetBase();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        Results<SharedBudgetBase> results = new Results<>(Collections.singleton(sharedBudgetBase));
        when(endpointMock.getAllSharedBudgetsBase(auth.getToken().getAccessTokenForHeader(),"accountId")).thenReturn(results);

        Results<SharedBudgetBase> actual = testInstance.readBase(auth, "accountId");
        assertEquals("Invalid share budget results", results, actual);
        verify(endpointMock, times(1)).getAllSharedBudgetsBase(any(), any());
    }

    @Test
    public void testUpdate() {
        SharedBudgetOperation sharedBudgetOperation = generateDummySharedBudgetOperation();
        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        when(endpointMock.updateSharedBudget(auth.getToken().getAccessTokenForHeader(),"accountId", sharedBudgetOperation.getId(), sharedBudgetOperation)).thenReturn(sharedBudgetOperation);

        SharedBudget actual = testInstance.update(auth, "accountId", sharedBudgetOperation.getId(), sharedBudgetOperation);
        assertEquals("Invalid sharedBudgetOperation", sharedBudgetOperation, actual);
        verify(endpointMock, times(1)).updateSharedBudget(any(), any(), any(), any());
    }
}
