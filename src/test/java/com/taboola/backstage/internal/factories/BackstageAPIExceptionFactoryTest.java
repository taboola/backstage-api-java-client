package com.taboola.backstage.internal.factories;

import static org.junit.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taboola.backstage.exceptions.BackstageAPIException;
import com.taboola.backstage.exceptions.BackstageAPIRequestException;
import com.taboola.backstage.model.APIError;

/**
 * Created by vladi.m
 * Date 28/06/2021
 * Time 15:46
 * Copyright Taboola
 */
public class BackstageAPIExceptionFactoryTest {

    private static final Logger logger = LogManager.getLogger(BackstageAPIExceptionFactoryTest.class);

    private BackstageAPIExceptionFactory testInstance;

    @Before
    public void beforeTest(){
        testInstance = new BackstageAPIExceptionFactory(new ObjectMapper());
    }

    @Test
    public void testParseError_whenErrorMsgContainsPercentSign_expectingValidFormatForStringFormat() {
        APIError apiError = new APIError("Cpc boost value must be between -99% and 100%", 400);
        apiError = testInstance.normalizeError(apiError);
        BackstageAPIException ex = new BackstageAPIRequestException(400, apiError);
        logger.info(ex);
        assertEquals("Failed to perform API call with response code [400]. Response payload status [400], message [Cpc boost value must be between -99% and 100%], offending field [null], message code [null]", ex.getMessage());
    }
}
