package com.taboola.backstage.internal;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taboola.backstage.internal.config.CommunicationConfig;
import com.taboola.backstage.internal.config.SerializationConfig;
import com.taboola.backstage.internal.interceptors.CommunicationInterceptor;
import com.taboola.backstage.internal.interceptors.HeadersInterceptor;
import com.taboola.backstage.internal.interceptors.UserAgentInterceptor;
import com.taboola.backstage.internal.serialization.SerializationMapperCreator;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by vladi
 * Date: 10/4/2017
 * Time: 10:54 PM
 * By Taboola
 */
public final class CommunicationFactory {

    private final ObjectMapper objectMapper;
    private final Retrofit retrofit;
    private final Retrofit authRetrofit;

    public CommunicationFactory(CommunicationConfig communicationConfig, SerializationConfig serializationConfig, Collection<Header> headers) {
        this.objectMapper = SerializationMapperCreator.createObjectMapper(serializationConfig);
        Retrofit.Builder retrofitBuilder = createRetrofitBuilder(communicationConfig, headers);

        this.authRetrofit = retrofitBuilder.baseUrl(communicationConfig.getAuthenticationBaseUrl()).build();
        this.retrofit = retrofitBuilder.baseUrl(communicationConfig.getBackstageBaseUrl()).build();
    }

    private HttpLoggingInterceptor createLoggingInterceptor(CommunicationConfig config) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new CommunicationInterceptor());
        if(config.isDebug()) {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            loggingInterceptor.redactHeader("Authorization");
            loggingInterceptor.redactHeader("Cookie");
        } else {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        }

        return loggingInterceptor;
    }

    private Retrofit.Builder createRetrofitBuilder(CommunicationConfig config, Collection<Header> headers) {
        return new Retrofit.Builder()
                            //TODO add ability to start retrofit2 in mock mode {option retrofit-mock}
                            .addConverterFactory(StringConverterFactory.create())
                            .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                            .addCallAdapterFactory(SynchronousCallAdapterFactory.create(objectMapper))
                            .client(createOkHttpClient(config, headers));
    }

    private OkHttpClient createOkHttpClient(CommunicationConfig config, Collection<Header> headers) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                //TODO use global connection pool to prevent OkHttpClient default behaviour from creating too many file descriptors when performing async calls
                .addInterceptor(createLoggingInterceptor(config))
                .addInterceptor(new UserAgentInterceptor(config.getUserAgent()))
                .readTimeout(config.getReadTimeoutMillis(), TimeUnit.MILLISECONDS)
                .writeTimeout(config.getWriteTimeoutMillis(), TimeUnit.MILLISECONDS)
                .connectTimeout(config.getConnectionTimeoutMillis(), TimeUnit.MILLISECONDS)
                .connectionPool(new ConnectionPool(config.getMaxIdleConnections(),
                        config.getKeepAliveDurationMillis(), TimeUnit.MILLISECONDS));
        applyHeaders(builder, headers);
        return builder.build();
    }

    private void applyHeaders(OkHttpClient.Builder builder, Collection<Header> headers) {
        if (headers != null && !headers.isEmpty()){
            builder.addInterceptor(new HeadersInterceptor(headers));
        }
    }

    public <E> E createRetrofitAuthEndpoint(Class<E> clazz) {
        return authRetrofit.create(clazz);
    }

    public <E> E createRetrofitEndpoint(Class<E> clazz) {
        return retrofit.create(clazz);
    }
}
