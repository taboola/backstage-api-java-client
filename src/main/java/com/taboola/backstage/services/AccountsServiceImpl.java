package com.taboola.backstage.services;

import com.taboola.backstage.exceptions.BackstageAPIConnectivityException;
import com.taboola.backstage.exceptions.BackstageAPIRequestException;
import com.taboola.backstage.exceptions.BackstageAPIUnauthorizedException;
import com.taboola.backstage.internal.BackstageAccountEndpoint;
import com.taboola.backstage.model.Account;
import com.taboola.backstage.model.Results;
import com.taboola.backstage.model.auth.BackstageAuthentication;
import com.taboola.backstage.model.dictionary.AudienceSegment;
import com.taboola.backstage.model.dictionary.ContextualSegment;
import com.taboola.backstage.model.dictionary.CustomAudience;
import com.taboola.backstage.model.dictionary.LookalikeAudience;
import com.taboola.backstage.model.media.account.AccountBlockedPublishers;
import com.taboola.backstage.model.media.account.AccountBlockedPublishersPatch;
import com.taboola.backstage.model.universal_pixel.ConversionRule;
import com.taboola.rest.api.internal.FieldsValidator;

/**
 * Created by vladi
 * Date: 1/15/2018
 * Time: 11:05 PM
 * By Taboola
 */
public class AccountsServiceImpl implements AccountsService {

    private final Boolean performClientValidations;
    private final BackstageAccountEndpoint endpoint;

    public AccountsServiceImpl(Boolean performClientValidations, BackstageAccountEndpoint endpoint) {
        this.performClientValidations = performClientValidations;
        this.endpoint = endpoint;
    }

    @Override
    public Results<Account> readPublishersUnderTaboolaNetwork(BackstageAuthentication auth) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.getAvailablePublishersUnderTaboolaNetwork(accessToken);
    }

    @Override
    public Results<Account> readAllowedPublishers(BackstageAuthentication auth, String accountId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.getAccountAllowedPublishers(accessToken, accountId);
    }

    @Override
    public Results<AudienceSegment> readAudienceSegments(BackstageAuthentication auth, String accountId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.getAllAudienceSegments(accessToken, accountId);
    }

    @Override
    public Results<AudienceSegment> readAudienceSegments(BackstageAuthentication auth, String accountId, String countryCode) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.getSpecificCountryAudienceSegments(accessToken, accountId, countryCode);
    }

    @Override
    public Results<ContextualSegment> readContextualSegments(BackstageAuthentication auth, String accountId) throws BackstageAPIUnauthorizedException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.getContextualSegments(accessToken, accountId, null);
    }

    @Override
    public Results<ContextualSegment> readContextualSegments(BackstageAuthentication auth, String accountId, String... countryCodes) throws BackstageAPIUnauthorizedException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.getContextualSegments(accessToken, accountId, String.join(",", countryCodes));
    }

    @Override
    public Results<CustomAudience> readCustomAudiences(BackstageAuthentication auth, String accountId, String searchText) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.getCustomAudiences(accessToken, accountId, searchText);
    }

    @Override
    public Results<LookalikeAudience> readLookalikeAudiences(BackstageAuthentication auth, String accountId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.getLookalikeAudiences(accessToken, accountId);
    }

    @Override
    public Results<LookalikeAudience> readSpecificCountryLookalikeAudiences(BackstageAuthentication auth, String accountId, String countryCode) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.getSpecificCountryLookalikeAudiences(accessToken, accountId, countryCode);
    }

    @Override
    public AccountBlockedPublishers readAccountBlockedPublishers(BackstageAuthentication auth, String accountId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.getAccountBlockedPublishers(accessToken, accountId);
    }

    @Override
    public AccountBlockedPublishers createAccountBlockedPublishers(BackstageAuthentication auth, String accountId, AccountBlockedPublishers accountBlockPublishers) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        if(performClientValidations) {
            FieldsValidator.validateCreateOperation(accountBlockPublishers);
        }

        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.createAccountBlockedPublishers(accessToken, accountId, accountBlockPublishers);
    }

    @Override
    public AccountBlockedPublishersPatch patchAccountBlockedPublishers(BackstageAuthentication auth, String accountId, AccountBlockedPublishersPatch accountBlockedPublishersPatch) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        if(performClientValidations) {
            FieldsValidator.validateCreateOperation(accountBlockedPublishersPatch);
        }
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.patchAccountBlockedPublishers(accessToken, accountId, accountBlockedPublishersPatch);
    }

    @Override
    public Results<ConversionRule> getConversionRules(BackstageAuthentication auth,
                                                      String accountId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        return endpoint.getConversionRules(auth.getToken().getAccessTokenForHeader(), accountId);
    }

    @Override
    public ConversionRule createConversionRule(BackstageAuthentication auth,
                                               String accountId,
                                               ConversionRule conversionRule) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        return endpoint.createConversionRule(auth.getToken().getAccessTokenForHeader(), accountId, conversionRule);
    }

    @Override
    public ConversionRule updateConversionRule(BackstageAuthentication auth,
                                               String accountId,
                                               ConversionRule conversionRule) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        return endpoint.updateConversionRule(auth.getToken().getAccessTokenForHeader(), accountId, conversionRule.getId(), conversionRule);
    }
}
