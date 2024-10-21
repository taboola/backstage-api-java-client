package com.taboola.backstage.internal;

import com.taboola.backstage.exceptions.BackstageAPIException;
import com.taboola.backstage.model.Results;
import com.taboola.backstage.model.Account;
import com.taboola.backstage.model.dictionary.AudienceSegment;
import com.taboola.backstage.model.dictionary.ContextualSegment;
import com.taboola.backstage.model.dictionary.CustomAudience;
import com.taboola.backstage.model.dictionary.LookalikeAudience;

import com.taboola.backstage.model.media.account.AccountBlockedPublishersPatch;
import com.taboola.backstage.model.media.account.AccountBlockedPublishers;

import com.taboola.backstage.model.universal_pixel.ConversionRule;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by vladi
 * Date: 10/16/2017
 * Time: 11:24 PM
 * By Taboola
 */
public interface BackstageAccountEndpoint {

    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/users/current/allowed-accounts")
    @Headers("Content-Type: application/json")
    Results<Account> getUserAllowedAccounts(@Header("Authorization") String accessToken) throws BackstageAPIException;

    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/users/current/account")
    @Headers("Content-Type: application/json")
    Account getUserAccount(@Header("Authorization") String accessToken) throws BackstageAPIException;

    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/taboola-network/publishers")
    @Headers("Content-Type: application/json")
    Results<Account> getAvailablePublishersUnderTaboolaNetwork(@Header("Authorization") String accessToken) throws BackstageAPIException;

    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/allowed-publishers")
    @Headers("Content-Type: application/json")
    Results<Account> getAccountAllowedPublishers(@Header("Authorization") String accessToken,
                                                 @Path("account_id") String accountId) throws BackstageAPIException;

    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/dictionary/audience_segments")
    @Headers("Content-Type: application/json")
    Results<AudienceSegment> getAllAudienceSegments(@Header("Authorization") String accessToken,
                                                    @Path("account_id") String accountId) throws BackstageAPIException;

    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/dictionary/audience_segments/{country_code}")
    @Headers("Content-Type: application/json")
    Results<AudienceSegment> getSpecificCountryAudienceSegments(@Header("Authorization") String accessToken,
                                                                @Path("account_id") String accountId,
                                                                @Path("country_code") String countryCode) throws BackstageAPIException;

    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/dictionary/contextual_segments")
    @Headers("Content-Type: application/json")
    Results<ContextualSegment> getContextualSegments(@Header("Authorization") String accessToken,
                                                     @Path("account_id") String accountId,
                                                     @Query("countryCodes") String countryCodes) throws BackstageAPIException;

    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/combined_audiences/resources/audiences")
    @Headers("Content-Type: application/json")
    Results<CustomAudience> getCustomAudiences(@Header("Authorization") String accessToken,
                                               @Path("account_id") String accountId,
                                               @Query("search_text") String searchText) throws BackstageAPIException;

    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/dictionary/lookalike_audiences")
    @Headers("Content-Type: application/json")
    Results<LookalikeAudience> getLookalikeAudiences(@Header("Authorization") String accessToken,
                                                     @Path("account_id") String accountId) throws BackstageAPIException;

    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/dictionary/lookalike_audiences/{country_code}")
    @Headers("Content-Type: application/json")
    Results<LookalikeAudience> getSpecificCountryLookalikeAudiences(@Header("Authorization") String accessToken,
                                                                    @Path("account_id") String accountId,
                                                                    @Path("country_code") String countryCode) throws BackstageAPIException;

    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/block-publisher")
    @Headers("Content-Type: application/json")
    AccountBlockedPublishers getAccountBlockedPublishers(@Header("Authorization") String accessToken,
                                                         @Path("account_id") String accountId) throws BackstageAPIException;

    @POST(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/block-publisher")
    @Headers("Content-Type: application/json")
    AccountBlockedPublishers createAccountBlockedPublishers(@Header("Authorization") String accessToken,
                                                            @Path("account_id") String accountId,
                                                            @Body AccountBlockedPublishers accountBlockedPublishers) throws BackstageAPIException;

    @PATCH(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/block-publisher")
    @Headers("Content-Type: application/json")
    AccountBlockedPublishersPatch patchAccountBlockedPublishers(@Header("Authorization") String accessToken,
                                                                @Path("account_id") String accountId,
                                                                @Body AccountBlockedPublishersPatch accountBlockedPublishersPatch) throws BackstageAPIException;

    @GET(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/universal_pixel/conversion_rule")
    @Headers("Content-Type: application/json")
    Results<ConversionRule> getConversionRules(@Header("Authorization") String accessToken,
                                               @Path("account_id") String accountId) throws BackstageAPIException;

    @POST(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/universal_pixel/conversion_rule")
    @Headers("Content-Type: application/json")
    ConversionRule createConversionRule(@Header("Authorization") String accessToken,
                                        @Path("account_id") String accountId,
                                        @Body ConversionRule conversionRule) throws BackstageAPIException;

    @POST(BackstagePaths.BACKSTAGE_API_PATH_PREFIX + "/{account_id}/universal_pixel/conversion_rule/{rule_id}")
    @Headers("Content-Type: application/json")
    ConversionRule updateConversionRule(@Header("Authorization") String accessToken,
                                        @Path("account_id") String accountId,
                                        @Path("rule_id") Long ruleId,
                                        @Body ConversionRule conversionRule) throws BackstageAPIException;
}
