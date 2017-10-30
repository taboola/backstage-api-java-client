package com.taboola.backstage.model.auth;

/**
 * Created by vladi
 * Date: 9/12/2017
 * Time: 11:40 PM
 * By Taboola
 */
public class BackstageAuthentication {

    private final String clientId;
    private final String clientSecret;
    private final String username;
    private final String password;
    private final GrantType grantType;
    private final Token token;

    public BackstageAuthentication(String clientId, String clientSecret,
                                   String username, String password, GrantType grantType, Token token) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.username = username;
        this.password = password;
        this.grantType = grantType;
        this.token = token;
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

    public Token getToken() {
        return token;
    }

    @Override
    public String toString() {
        return "BackstageAuthentication{" +
        ", clientId='" + clientId + '\'' +
        ", clientSecret='************'" +
        ", username='" + username + '\'' +
        ", password='************'" +
        ", grantType=" + grantType +
        ", token=" + token +
        '}';
    }
}
