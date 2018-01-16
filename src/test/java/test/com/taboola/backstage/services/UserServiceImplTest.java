package test.com.taboola.backstage.services;

import com.taboola.backstage.internal.BackstageAccountEndpoint;
import com.taboola.backstage.model.Account;
import com.taboola.backstage.model.Results;
import com.taboola.backstage.model.auth.BackstageAuthentication;
import com.taboola.backstage.services.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import test.com.taboola.backstage.BackstageTestBase;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by vladi
 * Date: 11/22/2017
 * Time: 11:21 PM
 * By Taboola
 */
public class UserServiceImplTest extends BackstageTestBase {

    private BackstageAccountEndpoint accountsEndpointMock;
    private UserServiceImpl testInstance;

    @Before
    public void beforeTest() {
        accountsEndpointMock = mock(BackstageAccountEndpoint.class);
        testInstance = new UserServiceImpl(accountsEndpointMock);

        reset(accountsEndpointMock);
    }

    @Test
    public void testReadAllowedAccounts(){
        Account account = generateDummyAccount();
        Results<Account> expected = new Results<>(Collections.singleton(account));
        when(accountsEndpointMock.getUserAllowedAccounts(any())).thenReturn(expected);

        BackstageAuthentication auth = generateDummyClientCredentialsBackstageAuth();
        Results<Account> actual = testInstance.readAllowedAccounts(auth);
        assertEquals("Invalid accounts", expected, actual);
    }
}
