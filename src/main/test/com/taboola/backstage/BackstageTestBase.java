package com.taboola.backstage;

import com.taboola.backstage.model.auth.BackstageAuthentication;
import com.taboola.backstage.model.auth.GrantType;
import com.taboola.backstage.model.auth.Token;

/**
 * Created by vladi
 * Date: 11/14/2017
 * Time: 10:26 PM
 * By Taboola
 */
public abstract class BackstageTestBase {


    protected BackstageAuthentication generateDummyPasswordBackstageAuth() {
        return new BackstageAuthentication("DummyClientId", "DummyClientSecret",
                        "DummyUsername", "DummyPassword", GrantType.PASSWORD_AUTHENTICATION, generateDummyToken());
    }

    protected BackstageAuthentication generateDummyClientCredentialsBackstageAuth() {
        return new BackstageAuthentication("DummyClientId", "DummyClientSecret",
                        null, null, GrantType.CLIENT_CREDENTIALS, generateDummyToken());
    }

    protected Token generateDummyToken(){
        Token token = new Token();
        token.setAccessToken("accesstoken");
        token.setExpiresIn(1000);
        token.setRefreshToken("refreshtoken");
        token.setTokenType("bearer");
        return token;
    }
}
