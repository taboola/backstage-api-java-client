package com.taboola.backstage.internal;

import com.taboola.backstage.internal.config.CommunicationConfig;
import org.junit.Assert;
import org.junit.Before;
import com.taboola.backstage.BackstageTestBase;
import org.junit.Test;

/**
 * Created by vladi
 * Date: 1/16/2018
 * Time: 10:24 PM
 * By Taboola
 */
public class CommunicationFactoryTest extends BackstageTestBase {

    private CommunicationFactory testInstance;

    @Before
    public void beforeTest() {
        CommunicationConfig config = new CommunicationConfig("http://localhost", 1L, 1L, 1L, "Dummy-Agent");
        testInstance = new CommunicationFactory(config);
    }

    @Test
    public void testHappyFlowServices() {
        Assert.assertNotNull("Missing service instance", testInstance.getAccountService());
        Assert.assertNotNull("Missing service instance", testInstance.getAuthService());
        Assert.assertNotNull("Missing service instance", testInstance.getCampaignItemService());
        Assert.assertNotNull("Missing service instance", testInstance.getCampaignPostalCodeTargeting());
        Assert.assertNotNull("Missing service instance", testInstance.getCampaignsService());
        Assert.assertNotNull("Missing service instance", testInstance.getDictionaryService());
        Assert.assertNotNull("Missing service instance", testInstance.getMediaReportsService());
    }


}
