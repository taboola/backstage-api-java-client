package com.taboola.backstage.internal;

import com.taboola.backstage.exceptions.BackstageAPIException;
import com.taboola.backstage.model.auth.Token;
import com.taboola.backstage.model.auth.TokenDetails;
import retrofit2.http.*;

/**
 * Created by vladi
 * Date: 10/2/2017
 * Time: 10:23 PM
 * By Taboola
 */
public interface BackstageAuthenticationEndpoint {

    @POST("oauth/token")
    @FormUrlEncoded
    Token getAuthToken(@Field("client_id") String clientId,
                             @Field("client_secret") String clientSecret,
                             @Field("grant_type") String grantType) throws BackstageAPIException;

    @POST("oauth/token")
    @FormUrlEncoded
    Token getAuthToken(@Field("client_id") String clientId,
                             @Field("client_secret") String clientSecret,
                             @Field("username") String username,
                             @Field("password") String password,
                             @Field("grant_type") String grantType) throws BackstageAPIException;


    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/token-details")
    @Headers("Content-Type: application/json")
    TokenDetails getTokenDetails(@Header("Authorization") String authToken) throws BackstageAPIException;
}
