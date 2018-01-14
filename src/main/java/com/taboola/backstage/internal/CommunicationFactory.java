package com.taboola.backstage.internal;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.taboola.backstage.internal.interceptors.UserAgentInterceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private static final Logger logger = LogManager.getLogger(CommunicationFactory.class);

    private final ObjectMapper objectMapper;

    private final BackstageAuthenticationEndpoint authService;
    private final BackstageCampaignsEndpoint campaignsService;
    private final BackstageAccountEndpoint accountService;
    private final BackstageCampaignItemsEndpoint campaignItemService;
    private final BackstageDictionaryEndpoint dictionaryService;
    private final BackstageMediaReportsEndpoint mediaReportsService;

    public CommunicationFactory(String backstageBaseUrl, long connectionTimeoutMillis, long readTimeoutMillis, long writeTimeoutMillis, String userAgent) {
        this.objectMapper = createObjectMapper();

        Retrofit retrofit = createRetrofit(backstageBaseUrl, connectionTimeoutMillis, readTimeoutMillis, writeTimeoutMillis, userAgent);
        this.authService = retrofit.create(BackstageAuthenticationEndpoint.class);
        this.campaignsService = retrofit.create(BackstageCampaignsEndpoint.class);
        this.accountService = retrofit.create(BackstageAccountEndpoint.class);
        this.campaignItemService = retrofit.create(BackstageCampaignItemsEndpoint.class);
        this.dictionaryService = retrofit.create(BackstageDictionaryEndpoint.class);
        this.mediaReportsService = retrofit.create(BackstageMediaReportsEndpoint.class);
    }

    private ObjectMapper createObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper;
    }

    private Retrofit createRetrofit(String backstageBaseUrl, long connectionTimeoutMillis, long readTimeoutMillis, long writeTimeoutMillis, String userAgent) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(logger::info);
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

        //TODO add ability to start retrofit2 in mock mode {option retrofit-mock}

        OkHttpClient client = new OkHttpClient.Builder()
                                    .addInterceptor(loggingInterceptor)
                                    .addInterceptor(new UserAgentInterceptor(userAgent))
                                    .readTimeout(readTimeoutMillis, TimeUnit.MILLISECONDS)
                                    .writeTimeout(writeTimeoutMillis, TimeUnit.MILLISECONDS)
                                    .connectTimeout(connectionTimeoutMillis, TimeUnit.MILLISECONDS)
                                    .build();

        return new Retrofit.Builder()
                            .baseUrl(backstageBaseUrl)
                            .addConverterFactory(StringConverterFactory.create())
                            .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                            .addCallAdapterFactory(SynchronousCallAdapterFactory.create(objectMapper))
                            .client(client)
                            .build();
    }

    public BackstageAuthenticationEndpoint getAuthService() {
        return authService;
    }

    public BackstageCampaignsEndpoint getCampaignsService() {
        return campaignsService;
    }

    public BackstageAccountEndpoint getAccountService() {
        return accountService;
    }

    public BackstageCampaignItemsEndpoint getCampaignItemService() {
        return campaignItemService;
    }

    public BackstageDictionaryEndpoint getDictionaryService() {
        return dictionaryService;
    }

    public BackstageMediaReportsEndpoint getMediaReportsService() {
        return mediaReportsService;
    }
}
