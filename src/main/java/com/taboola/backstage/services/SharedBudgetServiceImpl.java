package com.taboola.backstage.services;

import com.taboola.backstage.exceptions.BackstageAPIConnectivityException;
import com.taboola.backstage.exceptions.BackstageAPIRequestException;
import com.taboola.backstage.exceptions.BackstageAPIUnauthorizedException;
import com.taboola.backstage.internal.BackstageSharedBudgetEndpoint;
import com.taboola.backstage.model.Results;
import com.taboola.backstage.model.auth.BackstageAuthentication;
import com.taboola.backstage.model.media.campaigns.SharedBudget;
import com.taboola.backstage.model.media.campaigns.SharedBudgetBase;
import com.taboola.backstage.model.media.campaigns.SharedBudgetOperation;
import com.taboola.rest.api.internal.FieldsValidator;

public class SharedBudgetServiceImpl implements SharedBudgetService {

    private final Boolean performValidations;
    private final BackstageSharedBudgetEndpoint shareBudgetEndpoint;

    public SharedBudgetServiceImpl(Boolean performValidations, BackstageSharedBudgetEndpoint shareBudgetEndpoint) {
        this.performValidations = performValidations;
        this.shareBudgetEndpoint = shareBudgetEndpoint;
    }

    @Override
    public SharedBudget create(BackstageAuthentication auth, String accountId, SharedBudgetOperation sharedBudgetOperation) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        if(performValidations) {
            FieldsValidator.validateCreateOperation(sharedBudgetOperation);
        }

        return shareBudgetEndpoint.createSharedBudget(auth.getToken().getAccessTokenForHeader(), accountId, sharedBudgetOperation);
    }

    @Override
    public SharedBudget update(BackstageAuthentication auth, String accountId, Long shareBudgetId, SharedBudgetOperation sharedBudgetOperation) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        if(performValidations) {
            FieldsValidator.validateUpdateOperation(sharedBudgetOperation);
        }

        return shareBudgetEndpoint.updateSharedBudget(auth.getToken().getAccessTokenForHeader(), accountId, shareBudgetId, sharedBudgetOperation);
    }

    @Override
    public SharedBudget read(BackstageAuthentication auth, String accountId, Long shareBudgetId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        return shareBudgetEndpoint.getSharedBudget(auth.getToken().getAccessTokenForHeader(), accountId, shareBudgetId);
    }

    @Override
    public Results<SharedBudgetBase> readBase(BackstageAuthentication auth, String accountId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        return shareBudgetEndpoint.getAllSharedBudgetsBase(auth.getToken().getAccessTokenForHeader(), accountId);
    }
}
