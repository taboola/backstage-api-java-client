package test.com.taboola.backstage.services;

import com.taboola.backstage.internal.BackstageAccountEndpoint;
import com.taboola.backstage.model.Account;
import com.taboola.backstage.model.Results;
import com.taboola.backstage.model.auth.BackstageAuthentication;
import com.taboola.backstage.services.AccountsServiceImpl;
import org.junit.Before;
import org.junit.Test;
import test.com.taboola.backstage.BackstageTestBase;

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
        testInstance = new AccountsServiceImpl(accountsEndpointMock);

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
}
