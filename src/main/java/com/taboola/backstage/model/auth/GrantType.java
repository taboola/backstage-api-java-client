package com.taboola.backstage.model.auth;

/**
 * Created by vladi
 * Date: 9/12/2017
 * Time: 11:47 PM
 * By Taboola
 */
public enum GrantType {
    CLIENT_CREDENTIALS("client_credentials"),
    PASSWORD_AUTHENTICATION("password"),;
//    IMPLICIT_GRANT,
//    AUTHORIZATION_CODE

    private final String value;

    GrantType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
