package com.taboola.backstage.services.internal;

import com.taboola.backstage.model.Results;
import com.taboola.backstage.model.Account;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

/**
 * Created by vladi
 * Date: 10/16/2017
 * Time: 11:24 PM
 * By Taboola
 */
public interface BackstageAccountService {

    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/users/current/allowed-accounts")
    @Headers("Content-Type: application/json")
    Call<Results<Account>> getUserAllowedAccounts(@Header("Authorization") String accessToken);
}
