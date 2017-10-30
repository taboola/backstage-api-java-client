package com.taboola.backstage.model.auth;

/**
 * Created by vladi
 * Date: 9/13/2017
 * Time: 11:31 PM
 * By Taboola
 */
public class Token {

    private String accessToken;
    private String refreshToken;
    private String tokenType;
    private Integer expiresIn;

    public String getAccessToken() {
        return accessToken;
    }

    public String getAccessTokenForHeader() {
        return "Bearer " + getAccessToken();
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    @Override
    public String toString() {
        return "Token{" +
        "accessToken='" + accessToken + '\'' +
        ", refreshToken='" + refreshToken + '\'' +
        ", tokenType='" + tokenType + '\'' +
        ", expiresIn=" + expiresIn +
        '}';
    }
}
