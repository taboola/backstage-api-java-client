package com.taboola.backstage;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by vladi
 * Date: 1/16/2018
 * Time: 9:54 PM
 * By Taboola
 */
public class BackstageTest extends BackstageTestBase {

    @Test
    public void testHappyFlowServices() {
        Backstage testInstance = Backstage.builder().build();
        Assert.assertNotNull("Missing service instance", testInstance.accountsService());
        Assert.assertNotNull("Missing service instance", testInstance.authenticationService());
        Assert.assertNotNull("Missing service instance", testInstance.campaignItemsService());
        Assert.assertNotNull("Missing service instance", testInstance.campaignPostalCodeTargetingService());
        Assert.assertNotNull("Missing service instance", testInstance.campaignsService());
        Assert.assertNotNull("Missing service instance", testInstance.dictionaryService());
        Assert.assertNotNull("Missing service instance", testInstance.reportsService());
        Assert.assertNotNull("Missing service instance", testInstance.advertiserReportsService());
        Assert.assertNotNull("Missing service instance", testInstance.publisherReportsService());
        Assert.assertNotNull("Missing service instance", testInstance.userService());
        Assert.assertNotNull("Missing service instance", testInstance.campaignAudienceTargetingService());
        Assert.assertNotNull("Missing service instance", testInstance.sharedBudgetService());
        Assert.assertNotNull("Missing service instance", testInstance.internalTools());
    }
}
