package com.taboola.backstage.model.auth;

import java.util.Objects;

/**
 * Created by vladi
 * Date: 9/13/2017
 * Time: 11:31 PM
 * By Taboola
 */
public class Token {

    private static final int MILLISECONDS_IN_SINGLE_SECOND = 1000;
    
    private String accessToken;
    private String refreshToken;
    private String tokenType;
    private Integer expiresIn; //seconds
    private final Long creationTimestamp;

    public Token() {
        this.creationTimestamp = System.currentTimeMillis();
    }

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

    public boolean isExpired() {
        Objects.requireNonNull(expiresIn, "Expires in is null");
        return System.currentTimeMillis() >= (creationTimestamp + (expiresIn * MILLISECONDS_IN_SINGLE_SECOND));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return Objects.equals(accessToken, token.accessToken) &&
        Objects.equals(refreshToken, token.refreshToken) &&
        Objects.equals(tokenType, token.tokenType) &&
        Objects.equals(creationTimestamp, token.creationTimestamp) &&
        Objects.equals(expiresIn, token.expiresIn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessToken, refreshToken, tokenType, expiresIn, creationTimestamp);
    }

    @Override
    public String toString() {
        return "Token{" +
        "accessToken='" + accessToken + '\'' +
        ", refreshToken='" + refreshToken + '\'' +
        ", tokenType='" + tokenType + '\'' +
        ", expiresIn=" + expiresIn +
        ", creationTimestamp=" + creationTimestamp +
        '}';
    }
}
