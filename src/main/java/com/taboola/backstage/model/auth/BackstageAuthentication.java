package com.taboola.backstage.model.auth;

import java.util.Objects;

/**
 * Created by vladi
 * Date: 9/12/2017
 * Time: 11:40 PM
 * By Taboola
 */
public class BackstageAuthentication {

    private Token token;
    private AuthenticationDetails details;

    public BackstageAuthentication(AuthenticationDetails details, Token token) {
        this.details = details;
        this.token = token;
    }

    public AuthenticationDetails getDetails() {
        return details;
    }

    public Token getToken() {
        return token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BackstageAuthentication that = (BackstageAuthentication) o;
        return Objects.equals(details, that.details) &&
        Objects.equals(token, that.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(details, token);
    }

    @Override
    public String toString() {
        return "BackstageAuthentication{" +
        "details=" + details +
        ", token=" + token +
        '}';
    }
}
