package com.taboola.backstage.services.internal.interceptors;

import okhttp3.Interceptor;
import okhttp3.Response;

import java.io.IOException;

/**
 * Created by vladi
 * Date: 10/14/2017
 * Time: 11:34 PM
 * By Taboola
 */
public class UserAgentInterceptor implements Interceptor {

    private final String userAgent;

    public UserAgentInterceptor(String userAgent) {
        this.userAgent = userAgent;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        return chain.proceed(chain.request().newBuilder().header("User-Agent", userAgent).build());
    }
}
