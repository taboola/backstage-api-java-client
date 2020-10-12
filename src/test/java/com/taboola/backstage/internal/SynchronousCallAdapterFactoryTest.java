package com.taboola.backstage.internal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taboola.backstage.exceptions.BackstageAPIRequestException;
import com.taboola.backstage.model.APIError;
import com.taboola.backstage.model.media.campaigns.Campaign;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import retrofit2.Call;
import retrofit2.CallAdapter;
import static org.junit.Assert.assertEquals;

import com.taboola.backstage.BackstageTestBase;

/**
 * Created by vladi
 * Date: 1/16/2018
 * Time: 10:16 PM
 * By Taboola
 */
public class SynchronousCallAdapterFactoryTest extends BackstageTestBase {

    private static final Logger logger = LogManager.getLogger(SynchronousCallAdapterFactoryTest.class);
    private SynchronousCallAdapterFactory testInstance;

    @Before
    public void beforeTest() {
        testInstance = SynchronousCallAdapterFactory.create(new ObjectMapper());
    }

    @Test
    public void testSynchronousAdapterForNonCallType() {
        CallAdapter<Object, Object> actualAdapter = testInstance.get(Campaign.class, null, null);
        Assert.assertNotNull("Invalid adapter, expecting adapter", actualAdapter);
        Assert.assertEquals("Invalid adapter type", Campaign.class, actualAdapter.responseType());

        actualAdapter = testInstance.get(Object.class, null, null);
        Assert.assertNotNull("Invalid adapter, expecting adapter", actualAdapter);
        Assert.assertEquals("Invalid adapter type", Object.class, actualAdapter.responseType());
    }

    @Test
    public void testSynchronousAdapterForCallType() {
        CallAdapter<Object, Object> actualAdapter = testInstance.get(Call.class, null, null);
        Assert.assertNull("Invalid adapter, expecting no adapter", actualAdapter);
    }

    @Test
    public void testParseError_whenErrorMsgContainsPercentSign_expectingValidFormatForStringFormat() {
        APIError apiError = new APIError("Cpc boost value must be between -99% and 100%", 400);
        apiError = testInstance.normalizeError(apiError);
        BackstageAPIRequestException ex = new BackstageAPIRequestException(400, apiError);
        logger.info(ex);
        assertEquals("Failed to perform API call with response code [400]. Response payload status [400], message [Cpc boost value must be between -99% and 100%], offending field [null], message code [null]", ex.getMessage());
    }

    //TODO add more tests - retrofit2#Response.class is final therefore mockito is not working on it
}
