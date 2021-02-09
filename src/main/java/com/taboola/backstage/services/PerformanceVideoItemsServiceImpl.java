/*
 * Copyright 2021 InPowered. All Rights Reserved.
 *
 * This software is the proprietary information of InPowered.
 * Use is subject to license terms.
 */
package com.taboola.backstage.services;

import com.taboola.backstage.exceptions.BackstageAPIConnectivityException;
import com.taboola.backstage.exceptions.BackstageAPIRequestException;
import com.taboola.backstage.exceptions.BackstageAPIUnauthorizedException;
import com.taboola.backstage.internal.BackstagePerformanceVideoItemsEndpoint;
import com.taboola.backstage.internal.FieldsValidator;
import com.taboola.backstage.model.Results;
import com.taboola.backstage.model.auth.BackstageAuthentication;
import com.taboola.backstage.model.media.campaigns.performancevideos.PerformanceVideoItem;
import com.taboola.backstage.model.media.campaigns.performancevideos.PerformanceVideoItemOperation;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import java.io.File;

/**
 * Performance video items service impl.
 *
 * Created by Gabriel Diaz, 09/02/2020.
 */
public class PerformanceVideoItemsServiceImpl implements PerformanceVideoItemsService {

    private final BackstagePerformanceVideoItemsEndpoint endpoint;
    private final Boolean performValidations;

    public PerformanceVideoItemsServiceImpl(Boolean performValidations, BackstagePerformanceVideoItemsEndpoint endpoint) {
        this.performValidations = performValidations;
        this.endpoint = endpoint;
    }

    @Override
    public PerformanceVideoItem createItem(BackstageAuthentication auth, String accountId, String campaignId, PerformanceVideoItemOperation itemOperation) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        if (performValidations) {
            FieldsValidator.validateCreateOperation(itemOperation);
        }

        boolean userMultipartForm = false;

        if (itemOperation.getVideoFile() != null) {
            if (itemOperation.getFallbackFile() == null) {
                throw new BackstageAPIRequestException("fallbackFile is Required");
            }
            userMultipartForm = true;
        }
        else if (itemOperation.getVideoUrl() != null) {
            if (itemOperation.getFallbackUrl() == null) {
                throw new BackstageAPIRequestException("fallbackUrl is Required");
            }
        }
        else {
            throw new BackstageAPIRequestException("videoUrl or videoFile Required");
        }

        String accessToken = auth.getToken().getAccessTokenForHeader();

        if (userMultipartForm) {
            File videoFile = itemOperation.getVideoFile();
            File fallbackFile = itemOperation.getFallbackFile();

            MultipartBody multipart = new MultipartBody.Builder()
                    .setType(MediaType.get("multipart/form"))
                    .addFormDataPart("url", itemOperation.getUrl())
                    .addFormDataPart("title", itemOperation.getTitle())
                    .addFormDataPart("video_file", videoFile.getName(), RequestBody.create(MediaType.parse("video/mp4"), videoFile))
                    .addFormDataPart("fallback_file", fallbackFile.getName(), RequestBody.create(MediaType.parse("image/jpg"), fallbackFile))
                    .build();

            return endpoint.uploadItem(accessToken, accountId, campaignId, multipart);
        }

        return endpoint.createItem(accessToken, accountId, campaignId, itemOperation);
    }

    @Override
    public Results<PerformanceVideoItem> readItems(BackstageAuthentication auth, String accountId, String campaignId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.readItems(accessToken, accountId, campaignId);
    }

    @Override
    public PerformanceVideoItem readItem(BackstageAuthentication auth, String accountId, String campaignId, String itemId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.readItem(accessToken, accountId, campaignId, itemId);
    }

    @Override
    public PerformanceVideoItem updateItem(BackstageAuthentication auth, String accountId, String campaignId, String itemId, PerformanceVideoItemOperation itemOperation) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        if (performValidations) {
            FieldsValidator.validateUpdateOperation(itemOperation);
        }
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.updateItem(accessToken, accountId, campaignId, itemId, itemOperation);
    }

    @Override
    public PerformanceVideoItem deleteItem(BackstageAuthentication auth, String accountId, String campaignId, String itemId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.deleteItem(accessToken, accountId, campaignId, itemId);
    }

}
