package com.taboola.backstage.services;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.taboola.backstage.exceptions.BackstageAPIConnectivityException;
import com.taboola.backstage.exceptions.BackstageAPITokenExpiredException;
import com.taboola.backstage.exceptions.BackstageAPIRequestException;
import com.taboola.backstage.services.internal.*;
import com.taboola.backstage.model.APIError;
import com.taboola.backstage.services.internal.interceptors.UserAgentInterceptor;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * Created by vladi
 * Date: 10/4/2017
 * Time: 10:54 PM
 * By Taboola
 */
public final class CommunicationHandler {

    private static final Logger logger = LogManager.getLogger(CommunicationHandler.class);
    private static final int UNAUTHORIZED_HTTP_STATUS_CODE = 401;
    private static final int BAD_REQUEST_HTTP_STATUS_CODE = 400;
    private static final int INTERNAL_SERVER_ERROR_HTTP_STATUS_CODE = 500;

    private final ObjectMapper objectMapper;

    private final BackstageAuthenticationService authService;
    private final BackstageCampaignsService campaignsService;
    private final BackstageAccountService accountService;
    private final BackstageCampaignItemsService campaignItemService;
    private final BackstageDictionaryService dictionaryService;
    private final BackstageMediaReportsService mediaReportsService;

    public CommunicationHandler(String backstageBaseUrl, long connectionTimeoutMillis, long readTimeoutMillis, long writeTimeoutMillis, String userAgent) {
        this.objectMapper = createObjectMapper();

        Retrofit retrofit = createRetrofit(backstageBaseUrl, connectionTimeoutMillis, readTimeoutMillis, writeTimeoutMillis, userAgent);
        this.authService = retrofit.create(BackstageAuthenticationService.class);
        this.campaignsService = retrofit.create(BackstageCampaignsService.class);
        this.accountService = retrofit.create(BackstageAccountService.class);
        this.campaignItemService = retrofit.create(BackstageCampaignItemsService.class);
        this.dictionaryService = retrofit.create(BackstageDictionaryService.class);
        this.mediaReportsService = retrofit.create(BackstageMediaReportsService.class);
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
                            .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                            .client(client)
                            .build();
    }

    BackstageAuthenticationService getAuthService() {
        return authService;
    }

    BackstageCampaignsService getCampaignsService() {
        return campaignsService;
    }

    BackstageAccountService getAccountService() {
        return accountService;
    }

    BackstageCampaignItemsService getCampaignItemService() {
        return campaignItemService;
    }

    BackstageDictionaryService getDictionaryService() {
        return dictionaryService;
    }

    BackstageMediaReportsService getMediaReportsService() {
        return mediaReportsService;
    }

    <T> T request(String actionName, Supplier<Call<T>> supplier) throws BackstageAPITokenExpiredException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        Call<T> call = supplier.get();
        T obj;
        try {
            Response<T> response = call.execute();
            if(response.isSuccessful()) {
                obj = response.body();
            } else {
                int responseCode = response.code();
                if(responseCode == UNAUTHORIZED_HTTP_STATUS_CODE) {
                    throw new BackstageAPITokenExpiredException(actionName, responseCode);

                } else if(responseCode >= BAD_REQUEST_HTTP_STATUS_CODE && responseCode < INTERNAL_SERVER_ERROR_HTTP_STATUS_CODE) {
                    throw new BackstageAPIRequestException(actionName, responseCode, parseError(response));

                }

                throw new BackstageAPIConnectivityException(actionName, responseCode);
            }

        } catch (IOException e) {
            logger.error(e);
            throw new BackstageAPIConnectivityException(actionName);
        }

        return obj;
    }

    private APIError parseError(Response errorResponse) {
        ResponseBody errorBody = errorResponse.errorBody();
        try {
            return objectMapper.readValue(errorBody.bytes(), APIError.class);
        } catch (Throwable e) {
            logger.warn("Failed to parse API error response object [{}]", errorResponse.message());
            return new APIError(errorResponse.message(), errorResponse.code());
        }
    }
}
