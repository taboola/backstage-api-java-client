package com.taboola.backstage.services;

import com.taboola.backstage.BackstageTestBase;
import com.taboola.backstage.exceptions.BackstageAPIConnectivityException;
import com.taboola.backstage.exceptions.BackstageAPIRequestException;
import com.taboola.backstage.exceptions.BackstageAPITokenExpiredException;
import com.taboola.backstage.model.auth.BackstageAuthentication;
import com.taboola.backstage.model.auth.GrantType;
import com.taboola.backstage.model.auth.Token;
import com.taboola.backstage.model.auth.TokenDetails;
import com.taboola.backstage.services.internal.BackstageAuthenticationService;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by vladi
 * Date: 11/14/2017
 * Time: 10:14 PM
 * By Taboola
 */
public class AuthenticationServiceImplTest extends BackstageTestBase {

    private AuthenticationServiceImpl testInstance;
    private BackstageAuthenticationService internalAuthServiceMock;

    @Before
    public void beforeTest() {
        internalAuthServiceMock = mock(BackstageAuthenticationService.class);
        testInstance = new AuthenticationServiceImpl(internalAuthServiceMock);

        reset(internalAuthServiceMock);
    }

    @Test
    public void testClientCredentials() throws BackstageAPIRequestException, BackstageAPITokenExpiredException, BackstageAPIConnectivityException, IOException {
        Token expectedToken = generateDummyToken();
        when(internalAuthServiceMock.getAuthToken("DummyClientId", "DummyClientSecret", GrantType.CLIENT_CREDENTIALS.getValue())).thenReturn(expectedToken);

        BackstageAuthentication actual = testInstance.clientCredentials("DummyClientId", "DummyClientSecret");

        assertEquals("Invalid client id", "DummyClientId", actual.getClientId());
        assertEquals("Invalid client secret", "DummyClientSecret", actual.getClientSecret());
        assertEquals("Invalid grand type", GrantType.CLIENT_CREDENTIALS, actual.getGrantType());
        assertNull("Invalid username", actual.getUsername());
        assertNull("Invalid password", actual.getPassword());
        assertEquals("Invalid token", expectedToken, actual.getToken());

        verify(internalAuthServiceMock, times(1)).getAuthToken(any(), any(), any());
        verify(internalAuthServiceMock, times(0)).getAuthToken(any(), any(), any(), any(), any());
    }

    @Test
    public void testPasswordAuthentication() throws BackstageAPIRequestException, BackstageAPITokenExpiredException, BackstageAPIConnectivityException {
        Token expectedToken = generateDummyToken();
        when(internalAuthServiceMock.getAuthToken("DummyClientId", "DummyClientSecret", "username", "pass", GrantType.PASSWORD_AUTHENTICATION.getValue())).thenReturn(expectedToken);

        BackstageAuthentication actual = testInstance.passwordAuthentication("DummyClientId", "DummyClientSecret", "username", "pass");
        assertEquals("Invalid client id", "DummyClientId", actual.getClientId());
        assertEquals("Invalid client secret", "DummyClientSecret", actual.getClientSecret());
        assertEquals("Invalid grand type", GrantType.PASSWORD_AUTHENTICATION, actual.getGrantType());
        assertEquals("Invalid username", "username", actual.getUsername());
        assertEquals("Invalid password", "pass", actual.getPassword());
        assertEquals("Invalid token", expectedToken, actual.getToken());

        verify(internalAuthServiceMock, times(0)).getAuthToken(any(), any(), any());
        verify(internalAuthServiceMock, times(1)).getAuthToken(any(), any(), any(), any(), any());
    }

    @Test
    public void testReAuthenticate_ClientCredentials() throws BackstageAPIRequestException, BackstageAPITokenExpiredException, BackstageAPIConnectivityException {
        BackstageAuthentication existingAuth = generateDummyClientCredentialsBackstageAuth();

        Token expectedReAuthedToken = generateDummyToken();
        expectedReAuthedToken.setAccessToken("reauthenticated_token_clientcred");
        when(internalAuthServiceMock.getAuthToken(existingAuth.getClientId(), existingAuth.getClientSecret(), existingAuth.getGrantType().getValue())).thenReturn(expectedReAuthedToken);

        BackstageAuthentication reAuthenticatedAuth = testInstance.reAuthenticate(existingAuth);
        assertEquals("Invalid grand type", GrantType.CLIENT_CREDENTIALS, reAuthenticatedAuth.getGrantType());
        assertEquals("Invalid client id", existingAuth.getClientId(), reAuthenticatedAuth.getClientId());
        assertEquals("Invalid client secret", existingAuth.getClientSecret(), reAuthenticatedAuth.getClientSecret());
        assertNull("Invalid username", reAuthenticatedAuth.getUsername());
        assertNull("Invalid password", reAuthenticatedAuth.getPassword());
        assertEquals("Invalid token", expectedReAuthedToken, reAuthenticatedAuth.getToken());

        verify(internalAuthServiceMock, times(1)).getAuthToken(any(), any(), any());
        verify(internalAuthServiceMock, times(0)).getAuthToken(any(), any(), any(), any(), any());
    }

    @Test
    public void testReAuthenticate_PasswordAuthentication() throws BackstageAPIRequestException, BackstageAPITokenExpiredException, BackstageAPIConnectivityException {
        BackstageAuthentication existingAuth = generateDummyPasswordBackstageAuth();

        Token expectedReAuthedToken = generateDummyToken();
        expectedReAuthedToken.setAccessToken("reauthenticated_token_pass");
        when(internalAuthServiceMock.getAuthToken(existingAuth.getClientId(), existingAuth.getClientSecret(), existingAuth.getUsername(), existingAuth.getPassword(), existingAuth.getGrantType().getValue())).thenReturn(expectedReAuthedToken);

        BackstageAuthentication reAuthenticatedAuth = testInstance.reAuthenticate(existingAuth);
        assertEquals("Invalid grand type", GrantType.PASSWORD_AUTHENTICATION, reAuthenticatedAuth.getGrantType());
        assertEquals("Invalid client id", existingAuth.getClientId(), reAuthenticatedAuth.getClientId());
        assertEquals("Invalid client secret", existingAuth.getClientSecret(), reAuthenticatedAuth.getClientSecret());
        assertEquals("Invalid username", existingAuth.getUsername(), reAuthenticatedAuth.getUsername());
        assertEquals("Invalid password", existingAuth.getPassword(), reAuthenticatedAuth.getPassword());
        assertEquals("Invalid token", expectedReAuthedToken, reAuthenticatedAuth.getToken());

        verify(internalAuthServiceMock, times(0)).getAuthToken(any(), any(), any());
        verify(internalAuthServiceMock, times(1)).getAuthToken(any(), any(), any(), any(), any());
    }

    @Test
    public void testGetTokenDetails() throws BackstageAPIRequestException, BackstageAPITokenExpiredException, BackstageAPIConnectivityException {
        BackstageAuthentication auth = generateDummyPasswordBackstageAuth();

        TokenDetails expected = new TokenDetails();
        when(internalAuthServiceMock.getTokenDetails(auth.getToken().getAccessTokenForHeader())).thenReturn(expected);

        TokenDetails actual = testInstance.getTokenDetails(auth);
        assertEquals("Invalid token details", expected, actual);


        verify(internalAuthServiceMock, times(0)).getAuthToken(any(), any(), any());
        verify(internalAuthServiceMock, times(0)).getAuthToken(any(), any(), any(), any(), any());
        verify(internalAuthServiceMock, times(1)).getTokenDetails(any());
    }
}
