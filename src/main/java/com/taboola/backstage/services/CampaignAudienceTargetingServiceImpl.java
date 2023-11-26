package com.taboola.backstage.services;

import com.taboola.backstage.exceptions.BackstageAPIConnectivityException;
import com.taboola.backstage.exceptions.BackstageAPIRequestException;
import com.taboola.backstage.exceptions.BackstageAPIUnauthorizedException;
import com.taboola.backstage.internal.BackstageAudienceTargetingEndpoint;
import com.taboola.backstage.model.auth.BackstageAuthentication;
import com.taboola.backstage.model.media.campaigns.CampaignLookalikeAudienceTargeting;
import com.taboola.backstage.model.media.campaigns.CampaignMultiTargetingCollection;
import com.taboola.rest.api.internal.FieldsValidator;

/**
 * Created by vladi.m
 * Date 29/04/2020
 * Time 11:01
 * Copyright Taboola
 */
public class CampaignAudienceTargetingServiceImpl implements CampaignAudienceTargetingService {

    private final Boolean performClientValidations;
    private final BackstageAudienceTargetingEndpoint endpoint;

    public CampaignAudienceTargetingServiceImpl(Boolean performClientValidations, BackstageAudienceTargetingEndpoint endpoint) {
        this.endpoint = endpoint;
        this.performClientValidations = performClientValidations;
    }

    @Override
    public CampaignMultiTargetingCollection<Long> readAudienceSegments(BackstageAuthentication auth, String accountId, String campaignId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        return endpoint.readAudienceSegments(auth.getToken().getAccessTokenForHeader(), accountId, campaignId);
    }

    @Override
    public CampaignMultiTargetingCollection<Long> updateAudienceSegments(BackstageAuthentication auth, String accountId, String campaignId, CampaignMultiTargetingCollection<Long> targeting) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        if(performClientValidations) {
            FieldsValidator.validateCreateOperation(targeting);
        }
        return endpoint.updateAudienceSegments(auth.getToken().getAccessTokenForHeader(), accountId, campaignId, targeting);
    }

    @Override
    public CampaignMultiTargetingCollection<Long> readContextualSegments(BackstageAuthentication auth, String accountId, String campaignId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        return endpoint.readContextualSegments(auth.getToken().getAccessTokenForHeader(), accountId, campaignId);
    }

    @Override
    public CampaignMultiTargetingCollection<Long> updateContextualSegments(BackstageAuthentication auth, String accountId, String campaignId, CampaignMultiTargetingCollection<Long> targeting) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        if(performClientValidations) {
            FieldsValidator.validateCreateOperation(targeting);
        }
        return endpoint.updateContextualSegments(auth.getToken().getAccessTokenForHeader(), accountId, campaignId, targeting);
    }

    @Override
    public CampaignMultiTargetingCollection<Long> readCustomAudience(BackstageAuthentication auth, String accountId, String campaignId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        return endpoint.readCustomAudience(auth.getToken().getAccessTokenForHeader(), accountId, campaignId);
    }

    @Override
    public CampaignMultiTargetingCollection<Long> updateCustomAudience(BackstageAuthentication auth, String accountId, String campaignId, CampaignMultiTargetingCollection<Long> targeting) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        if(performClientValidations) {
            FieldsValidator.validateCreateOperation(targeting);
        }

        return endpoint.updateCustomAudience(auth.getToken().getAccessTokenForHeader(), accountId, campaignId, targeting);
    }

    @Override
    public CampaignMultiTargetingCollection<CampaignLookalikeAudienceTargeting> readLookalikeAudience(BackstageAuthentication auth, String accountId, String campaignId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        return endpoint.readLookalikeAudience(auth.getToken().getAccessTokenForHeader(), accountId, campaignId);
    }

    @Override
    public CampaignMultiTargetingCollection<CampaignLookalikeAudienceTargeting> updateLookalikeAudience(BackstageAuthentication auth, String accountId, String campaignId, CampaignMultiTargetingCollection<CampaignLookalikeAudienceTargeting> targeting) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        if(performClientValidations) {
            FieldsValidator.validateCreateOperation(targeting);
        }

        return endpoint.updateLookalikeAudience(auth.getToken().getAccessTokenForHeader(), accountId, campaignId, targeting);
    }

    @Override
    public CampaignMultiTargetingCollection<String> readMarkingLabels(BackstageAuthentication auth, String accountId, String campaignId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        return endpoint.readMarkingLabels(auth.getToken().getAccessTokenForHeader(), accountId, campaignId);
    }

    @Override
    public CampaignMultiTargetingCollection<String> updateMarkingLabels(BackstageAuthentication auth, String accountId, String campaignId, CampaignMultiTargetingCollection<String> targeting) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        if(performClientValidations) {
            FieldsValidator.validateCreateOperation(targeting);
        }

        return endpoint.updateMarkingLabels(auth.getToken().getAccessTokenForHeader(), accountId, campaignId, targeting);
    }
}
