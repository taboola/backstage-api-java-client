package com.taboola.backstage.services;

import com.taboola.backstage.exceptions.BackstageAPIConnectivityException;
import com.taboola.backstage.exceptions.BackstageAPIRequestException;
import com.taboola.backstage.exceptions.BackstageAPIUnauthorizedException;
import com.taboola.backstage.model.auth.BackstageAuthentication;
import com.taboola.backstage.model.media.campaigns.CampaignLookalikeAudienceTargeting;
import com.taboola.backstage.model.media.campaigns.CampaignMultiTargetingCollection;

/**
 * Created by vladi.m
 * Date 29/04/2020
 * Time 11
 * Copyright Taboola
 */
public interface CampaignAudienceTargetingService {

    /**
     * Read audience segments targeting
     *
     * @param auth Authentication object ({@link BackstageAuthentication})
     * @param accountId To which {@link com.taboola.backstage.model.Account Account} the campaign belongs. Taken from {@link com.taboola.backstage.model.Account#getAccountId() Account.getAccountId()}
     * @param campaignId {@link com.taboola.backstage.model.media.campaigns.Campaign Campaign} Id. Taken from {@link com.taboola.backstage.model.media.campaigns.Campaign Campaign#getId()} object
     * @return Fully populated {@link CampaignMultiTargetingCollection}
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    CampaignMultiTargetingCollection<Long> readAudienceSegments(BackstageAuthentication auth, String accountId, String campaignId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    /**
     * Updating audience segments targeting
     *
     * @param auth Authentication object ({@link BackstageAuthentication})
     * @param accountId To which {@link com.taboola.backstage.model.Account Account} the campaign belongs. Taken from {@link com.taboola.backstage.model.Account#getAccountId() Account.getAccountId()}
     * @param campaignId {@link com.taboola.backstage.model.media.campaigns.Campaign Campaign} Id. Taken from {@link com.taboola.backstage.model.media.campaigns.Campaign Campaign#getId()} object
     * @param targeting Full or partial {@link CampaignMultiTargetingCollection} pojo to update.
     * @return Fully populated {@link CampaignMultiTargetingCollection}
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    CampaignMultiTargetingCollection<Long> updateAudienceSegments(BackstageAuthentication auth, String accountId, String campaignId, CampaignMultiTargetingCollection<Long> targeting) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    /**
     * Read contextual segments targeting.
     *
     * @param auth Authentication object ({@link BackstageAuthentication})
     * @param accountId To which {@link com.taboola.backstage.model.Account Account} the campaign belongs. Taken from {@link com.taboola.backstage.model.Account#getAccountId() Account.getAccountId()}
     * @param campaignId {@link com.taboola.backstage.model.media.campaigns.Campaign Campaign} Id. Taken from {@link com.taboola.backstage.model.media.campaigns.Campaign Campaign#getId()} object
     * @return Fully populated {@link CampaignMultiTargetingCollection}
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    CampaignMultiTargetingCollection<Long> readContextualSegments(BackstageAuthentication auth, String accountId, String campaignId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    /**
     * Updating contextual segments targeting.
     *
     * @param auth Authentication object ({@link BackstageAuthentication})
     * @param accountId To which {@link com.taboola.backstage.model.Account Account} the campaign belongs. Taken from {@link com.taboola.backstage.model.Account#getAccountId() Account.getAccountId()}
     * @param campaignId {@link com.taboola.backstage.model.media.campaigns.Campaign Campaign} Id. Taken from {@link com.taboola.backstage.model.media.campaigns.Campaign Campaign#getId()} object
     * @param targeting Full or partial {@link CampaignMultiTargetingCollection} pojo to update.
     * @return Fully populated {@link CampaignMultiTargetingCollection}
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    CampaignMultiTargetingCollection<Long> updateContextualSegments(BackstageAuthentication auth, String accountId, String campaignId, CampaignMultiTargetingCollection<Long> targeting) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    /**
     * Read custom audience targeting
     *
     * @param auth Authentication object ({@link BackstageAuthentication})
     * @param accountId To which {@link com.taboola.backstage.model.Account Account} the campaign belongs. Taken from {@link com.taboola.backstage.model.Account#getAccountId() Account.getAccountId()}
     * @param campaignId {@link com.taboola.backstage.model.media.campaigns.Campaign Campaign} Id. Taken from {@link com.taboola.backstage.model.media.campaigns.Campaign Campaign#getId()} object
     * @return Fully populated {@link CampaignMultiTargetingCollection}
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    CampaignMultiTargetingCollection<Long> readCustomAudience(BackstageAuthentication auth, String accountId, String campaignId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    /**
     * Updating custom audience targeting
     *
     * @param auth Authentication object ({@link BackstageAuthentication})
     * @param accountId To which {@link com.taboola.backstage.model.Account Account} the campaign belongs. Taken from {@link com.taboola.backstage.model.Account#getAccountId() Account.getAccountId()}
     * @param campaignId {@link com.taboola.backstage.model.media.campaigns.Campaign Campaign} Id. Taken from {@link com.taboola.backstage.model.media.campaigns.Campaign Campaign#getId()} object
     * @param targeting Full or partial {@link CampaignMultiTargetingCollection} pojo to update.
     * @return Fully populated {@link CampaignMultiTargetingCollection}
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    CampaignMultiTargetingCollection<Long> updateCustomAudience(BackstageAuthentication auth, String accountId, String campaignId, CampaignMultiTargetingCollection<Long> targeting) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    /**
     * Read lookalike audience targeting
     *
     * @param auth Authentication object ({@link BackstageAuthentication})
     * @param accountId To which {@link com.taboola.backstage.model.Account Account} the campaign belongs. Taken from {@link com.taboola.backstage.model.Account#getAccountId() Account.getAccountId()}
     * @param campaignId {@link com.taboola.backstage.model.media.campaigns.Campaign Campaign} Id. Taken from {@link com.taboola.backstage.model.media.campaigns.Campaign Campaign#getId()} object
     * @return Fully populated collection {@link CampaignMultiTargetingCollection} with {@link CampaignLookalikeAudienceTargeting}
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    CampaignMultiTargetingCollection<CampaignLookalikeAudienceTargeting> readLookalikeAudience(BackstageAuthentication auth, String accountId, String campaignId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    /**
     * Updating lookalike audience targeting
     *
     * @param auth Authentication object ({@link BackstageAuthentication})
     * @param accountId To which {@link com.taboola.backstage.model.Account Account} the campaign belongs. Taken from {@link com.taboola.backstage.model.Account#getAccountId() Account.getAccountId()}
     * @param campaignId {@link com.taboola.backstage.model.media.campaigns.Campaign Campaign} Id. Taken from {@link com.taboola.backstage.model.media.campaigns.Campaign Campaign#getId()} object
     * @param targeting Full or partial {@link CampaignMultiTargetingCollection} pojo to update.
     * @return Fully populated collection {@link CampaignMultiTargetingCollection} with {@link CampaignLookalikeAudienceTargeting}
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    CampaignMultiTargetingCollection<CampaignLookalikeAudienceTargeting> updateLookalikeAudience(BackstageAuthentication auth, String accountId, String campaignId, CampaignMultiTargetingCollection<CampaignLookalikeAudienceTargeting> targeting) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    /**
     * Read marking labels targeting (pixel retargeting)
     *
     * @param auth Authentication object ({@link BackstageAuthentication})
     * @param accountId To which {@link com.taboola.backstage.model.Account Account} the campaign belongs. Taken from {@link com.taboola.backstage.model.Account#getAccountId() Account.getAccountId()}
     * @param campaignId {@link com.taboola.backstage.model.media.campaigns.Campaign Campaign} Id. Taken from {@link com.taboola.backstage.model.media.campaigns.Campaign Campaign#getId()} object
     * @return Fully populated {@link CampaignMultiTargetingCollection}
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    CampaignMultiTargetingCollection<String> readMarkingLabels(BackstageAuthentication auth, String accountId, String campaignId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    /**
     * Updating marking labels targeting (pixel retargeting)
     *
     * @param auth Authentication object ({@link BackstageAuthentication})
     * @param accountId To which {@link com.taboola.backstage.model.Account Account} the campaign belongs. Taken from {@link com.taboola.backstage.model.Account#getAccountId() Account.getAccountId()}
     * @param campaignId {@link com.taboola.backstage.model.media.campaigns.Campaign Campaign} Id. Taken from {@link com.taboola.backstage.model.media.campaigns.Campaign Campaign#getId()} object
     * @param targeting Full or partial {@link CampaignMultiTargetingCollection} pojo to update.
     * @return Fully populated {@link CampaignMultiTargetingCollection}
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    CampaignMultiTargetingCollection<String> updateMarkingLabels(BackstageAuthentication auth, String accountId, String campaignId, CampaignMultiTargetingCollection<String> targeting) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    /**
     * Read my audiences targeting
     *
     * @param auth Authentication object ({@link BackstageAuthentication})
     * @param accountId To which {@link com.taboola.backstage.model.Account Account} the campaign belongs. Taken from {@link com.taboola.backstage.model.Account#getAccountId() Account.getAccountId()}
     * @param campaignId {@link com.taboola.backstage.model.media.campaigns.Campaign Campaign} Id. Taken from {@link com.taboola.backstage.model.media.campaigns.Campaign Campaign#getId()} object
     * @return Fully populated {@link CampaignMultiTargetingCollection}
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    CampaignMultiTargetingCollection<Long> readMyAudiences(BackstageAuthentication auth, String accountId, String campaignId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;

    /**
     * Updating my audiences targeting
     *
     * @param auth Authentication object ({@link BackstageAuthentication})
     * @param accountId To which {@link com.taboola.backstage.model.Account Account} the campaign belongs. Taken from {@link com.taboola.backstage.model.Account#getAccountId() Account.getAccountId()}
     * @param campaignId {@link com.taboola.backstage.model.media.campaigns.Campaign Campaign} Id. Taken from {@link com.taboola.backstage.model.media.campaigns.Campaign Campaign#getId()} object
     * @param targeting Full or partial {@link CampaignMultiTargetingCollection} pojo to update.
     * @return Fully populated {@link CampaignMultiTargetingCollection}
     * @throws BackstageAPIUnauthorizedException {@link com.taboola.backstage.model.auth.Token Token} is expired or bad credentials
     * @throws BackstageAPIConnectivityException Connectivity issues (HTTP status 5xx)
     * @throws BackstageAPIRequestException Bad request (HTTP status 4xx)
     */
    CampaignMultiTargetingCollection<Long> updateMyAudiences(BackstageAuthentication auth, String accountId, String campaignId, CampaignMultiTargetingCollection<Long> targeting) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException;


}
