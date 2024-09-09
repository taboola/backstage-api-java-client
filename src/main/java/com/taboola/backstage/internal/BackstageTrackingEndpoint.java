package com.taboola.backstage.internal;

import com.taboola.backstage.model.tracking.Conversion;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Marcelo Dias on 08/30/2024.
 */
public interface BackstageTrackingEndpoint {
    @POST( "{account_id}/log/3/bulk-s2s-action")
    @Headers("Content-Type: application/json")
    Void sendConversion(@Path("account_id") String accountId, @Body Conversion conversion);
}
