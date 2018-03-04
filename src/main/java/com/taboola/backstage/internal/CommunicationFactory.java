package com.taboola.backstage.internal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.taboola.backstage.internal.config.CommunicationConfig;
import com.taboola.backstage.internal.interceptors.CommunicationInterceptor;
import com.taboola.backstage.internal.interceptors.UserAgentInterceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.concurrent.TimeUnit;

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

    public CommunicationFactory(CommunicationConfig config) {
        this.objectMapper = createObjectMapper();

        Retrofit.Builder retrofitBuilder = createRetrofitBuilder(config);

        this.authRetrofit = retrofitBuilder.baseUrl(config.getAuthenticationBaseUrl()).build();
        this.retrofit = retrofitBuilder.baseUrl(config.getBackstageBaseUrl()).build();
    }

    private ObjectMapper createObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper;
    }

    private HttpLoggingInterceptor createLoggingInterceptor(CommunicationConfig config) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new CommunicationInterceptor());
        if(config.isDebug()) {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        }

        return loggingInterceptor;
    }

    private Retrofit.Builder createRetrofitBuilder(CommunicationConfig config) {
        return new Retrofit.Builder()
                            //TODO add ability to start retrofit2 in mock mode {option retrofit-mock}
                            .addConverterFactory(StringConverterFactory.create())
                            .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                            .addCallAdapterFactory(SynchronousCallAdapterFactory.create(objectMapper))
                            .client(createOkHttpClient(config));
    }

    private OkHttpClient createOkHttpClient(CommunicationConfig config) {
        return new OkHttpClient.Builder()
                            //TODO use global connection pool to prevent OkHttpClient default behaviour from creating too many file descriptors when performing async calls
                            .addInterceptor(createLoggingInterceptor(config))
                            .addInterceptor(new UserAgentInterceptor(config.getUserAgent()))
                            .readTimeout(config.getReadTimeoutMillis(), TimeUnit.MILLISECONDS)
                            .writeTimeout(config.getWriteTimeoutMillis(), TimeUnit.MILLISECONDS)
                            .connectTimeout(config.getConnectionTimeoutMillis(), TimeUnit.MILLISECONDS)
                            .build();
    }

    public <E> E createAuthEndpoint(Class<E> clazz) {
        return authRetrofit.create(clazz);
    }

    public <E> E createEndpoint(Class<E> clazz) {
        return retrofit.create(clazz);
    }
}
