package com.taboola.backstage.internal.interceptors;

import okhttp3.Interceptor;
import okhttp3.Response;

import java.io.IOException;

import com.taboola.backstage.interceptors.HeaderProvider;
import com.taboola.backstage.model.Header;

/**
 * Created by vladi.m
 * Date 21/10/2020
 * Time 21:59
 * Copyright Taboola
 */
public class HeaderInterceptor implements Interceptor {

    private final HeaderProvider headerProvider;

    public HeaderInterceptor(HeaderProvider headerProvider) {
        this.headerProvider = headerProvider;
    }

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Header header = headerProvider.get();
        return chain.proceed(chain.request().newBuilder().header(header.getName(), header.getValue()).build());
    }
}