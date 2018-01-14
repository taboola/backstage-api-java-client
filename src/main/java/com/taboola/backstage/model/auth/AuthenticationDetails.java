package com.taboola.backstage.model.auth;

import java.util.Objects;

/**
 * Created by vladi
 * Date: 12/8/2017
 * Time: 10:34 PM
 * By Taboola
 */
public abstract class AuthenticationDetails {

    private final GrantType grantType;

    public AuthenticationDetails(GrantType grantType) {
        this.grantType = grantType;
    }

    public GrantType getGrantType() {
        return grantType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthenticationDetails that = (AuthenticationDetails) o;
        return grantType == that.grantType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(grantType);
    }

    @Override
    public String toString() {
        return "AuthenticationDetails{" +
        "grantType=" + grantType +
        '}';
    }
}
