package com.taboola.backstage.services;

import com.taboola.backstage.exceptions.BackstageAPIConnectivityException;
import com.taboola.backstage.exceptions.BackstageAPIRequestException;
import com.taboola.backstage.exceptions.BackstageAPIUnauthorizedException;
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

/**
 * Accounts service allow fetching data regarding different account types (Partners, Publishers)
 *
 * @author vladi
 * @version 1.0
 */
public interface AccountsService {

    /**
     * In order to be able to block specific Publishers, one must know the Publisher's account_id. Need in order to fetch a list of all Publisher Accounts in the Taboola network.
     * @param auth Authentication object {@link BackstageAuthentication}
     * @return Collection of {@link Account}
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    Results<Account> readPublishersUnderTaboolaNetwork(BackstageAuthentication auth) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    /**
     * Returns a list of all publishers on which the given account could be served
     * @param auth Authentication object {@link BackstageAuthentication}
     * @return Collection of {@link Account}
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    Results<Account> readAllowedPublishers(BackstageAuthentication auth, String accountId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;



    /**
     * Read all audience segments
     *
     * @param auth Authentication object {@link BackstageAuthentication}
     * @param accountId {@link com.taboola.backstage.model.Account Account} to which {@link AudienceSegment} belongs. Taken from {@link com.taboola.backstage.model.Account#getAccountId Account.getAccountId()}
     * @return Fully populated collection of {@link AudienceSegment}
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    Results<AudienceSegment> readAudienceSegments(BackstageAuthentication auth, String accountId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    /**
     * Read audience segments by given country code (codes supplied by {@link DictionaryService#getCountries})
     *
     * @param auth Authentication object {@link BackstageAuthentication}
     * @param accountId {@link com.taboola.backstage.model.Account Account} to which {@link AudienceSegment} belongs. Taken from {@link com.taboola.backstage.model.Account#getAccountId Account.getAccountId()}
     * @param countryCode taken from {@link DictionaryService#getCountries}
     * @return Fully populated collection of {@link AudienceSegment}
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    Results<AudienceSegment> readAudienceSegments(BackstageAuthentication auth, String accountId, String countryCode) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    /**
     * Read contextual segments.
     *
     * @param auth Authentication object {@link BackstageAuthentication}
     * @param accountId {@link com.taboola.backstage.model.Account Account} to which {@link AudienceSegment} belongs. Taken from {@link com.taboola.backstage.model.Account#getAccountId Account.getAccountId()}
     * @return Fully populated collection of {@link ContextualSegment}
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    Results<ContextualSegment> readContextualSegments(BackstageAuthentication auth, String accountId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    /**
     * Read contextual segments given a list of country codes (codes supplied by {@link DictionaryService#getCountries})
     *
     * @param auth Authentication object {@link BackstageAuthentication}
     * @param accountId {@link com.taboola.backstage.model.Account Account} to which {@link AudienceSegment} belongs. Taken from {@link com.taboola.backstage.model.Account#getAccountId Account.getAccountId()}
     * @param countryCodes taken from {@link DictionaryService#getCountries}
     * @return Fully populated collection of {@link ContextualSegment}
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    Results<ContextualSegment> readContextualSegments(BackstageAuthentication auth, String accountId, String... countryCodes) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    /**
     * Read custom audiences.
     *
     * @param auth Authentication object {@link BackstageAuthentication}
     * @param accountId {@link com.taboola.backstage.model.Account Account} to which {@link CustomAudience} belongs. Taken from {@link com.taboola.backstage.model.Account#getAccountId Account.getAccountId()}
     * @return Fully populated collection of {@link CustomAudience}
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    default Results<CustomAudience> readCustomAudiences(BackstageAuthentication auth, String accountId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        return readCustomAudiences(auth, accountId, null);
    }

    /**
     * Read custom audiences by given search text.
     *
     * @param auth Authentication object {@link BackstageAuthentication}
     * @param accountId {@link com.taboola.backstage.model.Account Account} to which {@link CustomAudience} belongs. Taken from {@link com.taboola.backstage.model.Account#getAccountId Account.getAccountId()}
     * @param searchText A free text search to filter the results
     * @return Fully populated collection of {@link CustomAudience}
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    Results<CustomAudience> readCustomAudiences(BackstageAuthentication auth, String accountId, String searchText) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;


    /**
     * Read all lookalike audiences
     *
     * @param auth Authentication object {@link BackstageAuthentication}
     * @param accountId {@link com.taboola.backstage.model.Account Account} to which {@link LookalikeAudience} belongs. Taken from {@link com.taboola.backstage.model.Account#getAccountId Account.getAccountId()}
     * @return Fully populated collection of {@link LookalikeAudience}
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    Results<LookalikeAudience> readLookalikeAudiences(BackstageAuthentication auth, String accountId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    /**
     * Read lookalike audiences by given country code (codes supplied by {@link DictionaryService#getCountries})
     *
     * @param auth Authentication object {@link BackstageAuthentication}
     * @param accountId {@link com.taboola.backstage.model.Account Account} to which {@link LookalikeAudience} belongs. Taken from {@link com.taboola.backstage.model.Account#getAccountId Account.getAccountId()}
     * @param countryCode taken from {@link DictionaryService#getCountries}
     * @return Fully populated collection of {@link LookalikeAudience}
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    Results<LookalikeAudience> readSpecificCountryLookalikeAudiences(BackstageAuthentication auth, String accountId, String countryCode) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    /**
     * Read account-wide blocked publishers
     *
     * @param auth Authentication object {@link BackstageAuthentication}
     * @param accountId {@link com.taboola.backstage.model.Account Account}. Taken from {@link com.taboola.backstage.model.Account#getAccountId Account.getAccountId()}
     * @return Account blocked publishers model
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    AccountBlockedPublishers readAccountBlockedPublishers(BackstageAuthentication auth, String accountId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    /**
     * Create account-wide blocked publishers
     *
     * @param auth Authentication object {@link BackstageAuthentication}
     * @param accountId {@link com.taboola.backstage.model.Account Account}. Taken from {@link com.taboola.backstage.model.Account#getAccountId Account.getAccountId()}
     * @return Account blocked publishers model
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    AccountBlockedPublishers createAccountBlockedPublishers(BackstageAuthentication auth, String accountId, AccountBlockedPublishers accountBlockedPublishers) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    /**
     * Patch account-wide blocked publishers
     *
     * @param auth Authentication object {@link BackstageAuthentication}
     * @param accountId {@link com.taboola.backstage.model.Account Account}. Taken from {@link com.taboola.backstage.model.Account#getAccountId Account.getAccountId()}
     * @return Account blocked publishers model in patch form
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    AccountBlockedPublishersPatch patchAccountBlockedPublishers(BackstageAuthentication auth, String accountId, AccountBlockedPublishersPatch accountBlockedPublishersPatch) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    Results<ConversionRule> getConversionRules(BackstageAuthentication auth, String accountId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    ConversionRule createConversionRule(BackstageAuthentication auth, String accountId, ConversionRule conversionRule) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    ConversionRule updateConversionRule(BackstageAuthentication auth, String accountId, ConversionRule conversionRule) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

}
