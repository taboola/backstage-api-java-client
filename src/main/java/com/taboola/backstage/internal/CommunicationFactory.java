package com.taboola.backstage.internal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.taboola.backstage.internal.config.CommunicationConfig;
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
    private final BackstagePublisherReportsEndpoint publisherReportsService;
    private final BackstagePostalTargetingEndpoint campaignPostalCodeTargeting;

    public CommunicationFactory(CommunicationConfig config) {
        this.objectMapper = createObjectMapper();

        Retrofit retrofit = createRetrofit(config);
        this.authService = retrofit.create(BackstageAuthenticationEndpoint.class);
        this.campaignsService = retrofit.create(BackstageCampaignsEndpoint.class);
        this.accountService = retrofit.create(BackstageAccountEndpoint.class);
        this.campaignItemService = retrofit.create(BackstageCampaignItemsEndpoint.class);
        this.dictionaryService = retrofit.create(BackstageDictionaryEndpoint.class);
        this.mediaReportsService = retrofit.create(BackstageMediaReportsEndpoint.class);
        this.publisherReportsService = retrofit.create(BackstagePublisherReportsEndpoint.class);
        this.campaignPostalCodeTargeting = retrofit.create(BackstagePostalTargetingEndpoint.class);
    }

    private ObjectMapper createObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper;
    }

    private Retrofit createRetrofit(CommunicationConfig config) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(logger::info);
        if(config.isDebug()) {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        }

        //TODO add ability to start retrofit2 in mock mode {option retrofit-mock}

        OkHttpClient client = new OkHttpClient.Builder()
                                    //TODO use global connection pool to prevent OkHttpClient default behaviour from creating too many file descriptors when performing async calls
                                    .addInterceptor(loggingInterceptor)
                                    .addInterceptor(new UserAgentInterceptor(config.getUserAgent()))
                                    .readTimeout(config.getReadTimeoutMillis(), TimeUnit.MILLISECONDS)
                                    .writeTimeout(config.getWriteTimeoutMillis(), TimeUnit.MILLISECONDS)
                                    .connectTimeout(config.getConnectionTimeoutMillis(), TimeUnit.MILLISECONDS)
                                    .build();

        return new Retrofit.Builder()
                            .baseUrl(config.getBackstageBaseUrl())
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

    public BackstagePostalTargetingEndpoint getCampaignPostalCodeTargeting() {
        return campaignPostalCodeTargeting;
    }

    public BackstagePublisherReportsEndpoint getPublisherReportsService() {
        return publisherReportsService;
    }
}
