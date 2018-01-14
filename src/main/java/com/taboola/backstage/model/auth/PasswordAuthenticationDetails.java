package com.taboola.backstage.model.auth;

import java.util.Objects;

/**
 * Created by vladi
 * Date: 1/13/2018
 * Time: 10:51 PM
 * By Taboola
 */
public class PasswordAuthenticationDetails extends AuthenticationDetails {

    private final String clientId;
    private final String clientSecret;
    private final String username;
    private final String password;

    public PasswordAuthenticationDetails(String clientId, String clientSecret,
                                         String username, String password) {
        super(GrantType.PASSWORD_AUTHENTICATION);
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.username = username;
        this.password = password;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PasswordAuthenticationDetails that = (PasswordAuthenticationDetails) o;
        return Objects.equals(clientId, that.clientId) &&
        Objects.equals(clientSecret, that.clientSecret) &&
        Objects.equals(username, that.username) &&
        Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), clientId, clientSecret, username, password);
    }

    @Override
    public String toString() {
        return "PasswordAuthenticationDetails{" +
        super.toString() +
        ", clientId='" + clientId + '\'' +
        ", clientSecret='**********'"+
        ", username='" + username + '\'' +
        ", password='**********'" +
        '}';
    }
}
