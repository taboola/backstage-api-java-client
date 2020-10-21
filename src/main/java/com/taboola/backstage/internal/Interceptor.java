package com.taboola.backstage.internal;

import okhttp3.Response;

import java.io.IOException;

/**
 * Created on 10/21/20.
 */
public interface Interceptor {
    Response intercept(okhttp3.Interceptor.Chain var1) throws IOException;
}
