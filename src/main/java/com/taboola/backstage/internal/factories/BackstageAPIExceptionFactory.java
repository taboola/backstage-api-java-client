package com.taboola.backstage.internal.factories;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taboola.backstage.exceptions.BackstageAPIConnectivityException;
import com.taboola.backstage.exceptions.BackstageAPIRequestException;
import com.taboola.backstage.exceptions.BackstageAPIUnauthorizedException;
import com.taboola.backstage.model.APIError;
import com.taboola.rest.api.exceptions.factories.ExceptionFactory;

/**
 * Created by vladi.m
 * Date 28/06/2021
 * Time 13:46
 * Copyright Taboola
 */
public class BackstageAPIExceptionFactory implements ExceptionFactory {

    private static final Logger logger = LogManager.getLogger(BackstageAPIExceptionFactory.class);

    private final ObjectMapper objectMapper;

    public BackstageAPIExceptionFactory(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public RuntimeException createUnauthorizedException(Throwable cause) {
        return new BackstageAPIUnauthorizedException(cause);
    }

    @Override
    public RuntimeException createRequestException(int responseCode, byte[] errorBytes, String message) {
        return new BackstageAPIRequestException(responseCode, normalizeError(parseError(responseCode, errorBytes, message)));
    }

    private APIError parseError(int responseCode, byte[] errorBytes, String message) {
        try {
            return objectMapper.readValue(errorBytes, APIError.class);
        } catch (Throwable e) {
            logger.warn("Failed to parse API error response object [{}]", message);
            return new APIError(message, responseCode);
        }
    }

    APIError normalizeError(APIError error) {
        String message = error.getMessage();
        if(message != null) {
            error.setMessage(message.replaceAll("%", "%%"));
        }

        return error;
    }

    @Override
    public RuntimeException createConnectivityException(Throwable cause, int responseCode) {
        return new BackstageAPIConnectivityException(cause, responseCode);
    }

    @Override
    public RuntimeException createConnectivityException(Throwable cause) {
        return new BackstageAPIConnectivityException(cause);
    }
}
