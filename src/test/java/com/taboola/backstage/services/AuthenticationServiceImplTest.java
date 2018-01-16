package com.taboola.backstage.services;

import com.taboola.backstage.exceptions.BackstageAPIConnectivityException;
import com.taboola.backstage.exceptions.BackstageAPIRequestException;
import com.taboola.backstage.exceptions.BackstageAPIUnauthorizedException;
import com.taboola.backstage.internal.BackstageAuthenticationEndpoint;
import com.taboola.backstage.model.auth.*;
import org.junit.Before;
import org.junit.Test;
import com.taboola.backstage.BackstageTestBase;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
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
    private BackstageAuthenticationEndpoint authEndpointMock;

    @Before
    public void beforeTest() {
        authEndpointMock = mock(BackstageAuthenticationEndpoint.class);
        testInstance = new AuthenticationServiceImpl(authEndpointMock);

        reset(authEndpointMock);
    }

    @Test
    public void testClientCredentials() throws BackstageAPIRequestException, BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, IOException {
        Token expectedToken = generateDummyToken();
        when(authEndpointMock.getAuthToken("DummyClientId", "DummyClientSecret", GrantType.CLIENT_CREDENTIALS.getValue())).thenReturn(expectedToken);

        BackstageAuthentication auth = testInstance.clientCredentials("DummyClientId", "DummyClientSecret");
        ClientCredentialAuthenticationDetails actual = (ClientCredentialAuthenticationDetails) auth.getDetails();
        assertEquals("Invalid client id", "DummyClientId", actual.getClientId());
        assertEquals("Invalid client secret", "DummyClientSecret", actual.getClientSecret());
        assertEquals("Invalid grand type", GrantType.CLIENT_CREDENTIALS, actual.getGrantType());
        assertEquals("Invalid token", expectedToken, auth.getToken());

        verify(authEndpointMock, times(1)).getAuthToken(any(), any(), any());
        verify(authEndpointMock, times(0)).getAuthToken(any(), any(), any(), any(), any());
    }

    @Test
    public void testPasswordAuthentication() throws BackstageAPIRequestException, BackstageAPIUnauthorizedException, BackstageAPIConnectivityException {
        Token expectedToken = generateDummyToken();
        when(authEndpointMock.getAuthToken("DummyClientId", "DummyClientSecret", "username", "pass", GrantType.PASSWORD_AUTHENTICATION.getValue())).thenReturn(expectedToken);

        BackstageAuthentication auth = testInstance.passwordAuthentication("DummyClientId", "DummyClientSecret", "username", "pass");
        PasswordAuthenticationDetails actual = (PasswordAuthenticationDetails) auth.getDetails();
        assertEquals("Invalid client id", "DummyClientId", actual.getClientId());
        assertEquals("Invalid client secret", "DummyClientSecret", actual.getClientSecret());
        assertEquals("Invalid grand type", GrantType.PASSWORD_AUTHENTICATION, actual.getGrantType());
        assertEquals("Invalid username", "username", actual.getUsername());
        assertEquals("Invalid password", "pass", actual.getPassword());
        assertEquals("Invalid token", expectedToken, auth.getToken());

        verify(authEndpointMock, times(0)).getAuthToken(any(), any(), any());
        verify(authEndpointMock, times(1)).getAuthToken(any(), any(), any(), any(), any());
    }

    @Test
    public void testReAuthenticate_ClientCredentials() throws BackstageAPIRequestException, BackstageAPIUnauthorizedException, BackstageAPIConnectivityException {
        BackstageAuthentication existingAuth = generateDummyClientCredentialsBackstageAuth();
        ClientCredentialAuthenticationDetails existingAuthDetails = (ClientCredentialAuthenticationDetails) existingAuth.getDetails();
        Token expectedReAuthedToken = generateDummyToken();
        expectedReAuthedToken.setAccessToken("reauthenticated_token_clientcred");
        when(authEndpointMock.getAuthToken(existingAuthDetails.getClientId(), existingAuthDetails.getClientSecret(), existingAuthDetails.getGrantType().getValue())).thenReturn(expectedReAuthedToken);

        BackstageAuthentication reAuthenticatedAuth = testInstance.reAuthenticate(existingAuth);
        ClientCredentialAuthenticationDetails reAuthenticatedDetails = (ClientCredentialAuthenticationDetails) reAuthenticatedAuth.getDetails();
        assertEquals("Invalid grand type", GrantType.CLIENT_CREDENTIALS, reAuthenticatedDetails.getGrantType());
        assertEquals("Invalid client id", existingAuthDetails.getClientId(), reAuthenticatedDetails.getClientId());
        assertEquals("Invalid client secret", existingAuthDetails.getClientSecret(), reAuthenticatedDetails.getClientSecret());
        assertEquals("Invalid token", expectedReAuthedToken, reAuthenticatedAuth.getToken());

        verify(authEndpointMock, times(1)).getAuthToken(any(), any(), any());
        verify(authEndpointMock, times(0)).getAuthToken(any(), any(), any(), any(), any());
    }

    @Test
    public void testReAuthenticate_PasswordAuthentication() throws BackstageAPIRequestException, BackstageAPIUnauthorizedException, BackstageAPIConnectivityException {
        BackstageAuthentication existingAuth = generateDummyPasswordBackstageAuth();
        PasswordAuthenticationDetails existingAuthDetails = (PasswordAuthenticationDetails) existingAuth.getDetails();

        Token expectedReAuthedToken = generateDummyToken();
        expectedReAuthedToken.setAccessToken("reauthenticated_token_pass");
        when(authEndpointMock.getAuthToken(existingAuthDetails.getClientId(), existingAuthDetails.getClientSecret(), existingAuthDetails.getUsername(), existingAuthDetails.getPassword(), existingAuthDetails.getGrantType().getValue())).thenReturn(expectedReAuthedToken);

        BackstageAuthentication reAuthenticatedAuth = testInstance.reAuthenticate(existingAuth);
        PasswordAuthenticationDetails reAuthenticatedDetails = (PasswordAuthenticationDetails) reAuthenticatedAuth.getDetails();
        assertEquals("Invalid grand type", GrantType.PASSWORD_AUTHENTICATION, reAuthenticatedDetails.getGrantType());
        assertEquals("Invalid client id", existingAuthDetails.getClientId(), reAuthenticatedDetails.getClientId());
        assertEquals("Invalid client secret", existingAuthDetails.getClientSecret(), reAuthenticatedDetails.getClientSecret());
        assertEquals("Invalid username", existingAuthDetails.getUsername(), reAuthenticatedDetails.getUsername());
        assertEquals("Invalid password", existingAuthDetails.getPassword(), reAuthenticatedDetails.getPassword());
        assertEquals("Invalid token", expectedReAuthedToken, reAuthenticatedAuth.getToken());

        verify(authEndpointMock, times(0)).getAuthToken(any(), any(), any());
        verify(authEndpointMock, times(1)).getAuthToken(any(), any(), any(), any(), any());
    }

    @Test
    public void testGetTokenDetails() throws BackstageAPIRequestException, BackstageAPIUnauthorizedException, BackstageAPIConnectivityException {
        BackstageAuthentication auth = generateDummyPasswordBackstageAuth();

        TokenDetails expected = new TokenDetails();
        when(authEndpointMock.getTokenDetails(auth.getToken().getAccessTokenForHeader())).thenReturn(expected);

        TokenDetails actual = testInstance.getTokenDetails(auth);
        assertEquals("Invalid token details", expected, actual);


        verify(authEndpointMock, times(0)).getAuthToken(any(), any(), any());
        verify(authEndpointMock, times(0)).getAuthToken(any(), any(), any(), any(), any());
        verify(authEndpointMock, times(1)).getTokenDetails(any());
    }

    @Test(expected = IllegalStateException.class)
    public void testInvalidDowncast_PasswordAuthentication() {
        BackstageAuthentication invalidInstance = new BackstageAuthentication(new AuthenticationDetails(GrantType.PASSWORD_AUTHENTICATION) {
            @Override
            public GrantType getGrantType() {
                return super.getGrantType();
            }
        }, new Token());

        testInstance.reAuthenticate(invalidInstance);
    }

    @Test(expected = IllegalStateException.class)
    public void testInvalidDowncast_ClientCredentials() {
        BackstageAuthentication invalidInstance = new BackstageAuthentication(new AuthenticationDetails(GrantType.CLIENT_CREDENTIALS) {
            @Override
            public GrantType getGrantType() {
                return super.getGrantType();
            }
        }, new Token());

        testInstance.reAuthenticate(invalidInstance);
    }
}
