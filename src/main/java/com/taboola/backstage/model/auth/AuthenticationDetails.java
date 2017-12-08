package com.taboola.backstage.model.auth;

/**
 * Created by vladi
 * Date: 12/8/2017
 * Time: 10:34 PM
 * By Taboola
 */
public class AuthenticationDetails {

    private final String clientId;
    private final String clientSecret;
    private final String username;
    private final String password;
    private final GrantType grantType;

    public AuthenticationDetails(String clientId, String clientSecret,
                                   String username, String password, GrantType grantType) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.username = username;
        this.password = password;
        this.grantType = grantType;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public GrantType getGrantType() {
        return grantType;
    }

    @Override
    public String toString() {
        return "AuthenticationDetails{" +
        ", clientId='" + clientId + '\'' +
        ", clientSecret='************'" +
        ", username='" + username + '\'' +
        ", password='************'" +
        ", grantType=" + grantType +
        '}';
    }
}
