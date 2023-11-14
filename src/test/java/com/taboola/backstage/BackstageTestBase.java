package com.taboola.backstage;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.stream.Collectors;

import com.taboola.backstage.model.Account;
import com.taboola.backstage.model.ColumnsMetadata;
import com.taboola.backstage.model.Report;
import com.taboola.backstage.model.auth.BackstageAuthentication;
import com.taboola.backstage.model.auth.ClientCredentialAuthenticationDetails;
import com.taboola.backstage.model.auth.PasswordAuthenticationDetails;
import com.taboola.backstage.model.auth.Token;
import com.taboola.backstage.model.dictionary.AudienceSegment;
import com.taboola.backstage.model.dictionary.LookalikeAudience;
import com.taboola.backstage.model.dictionary.Resource;
import com.taboola.backstage.model.dynamic.DynamicField;
import com.taboola.backstage.model.dynamic.DynamicFieldMetadata;
import com.taboola.backstage.model.dynamic.DynamicFields;
import com.taboola.backstage.model.dynamic.DynamicFieldsMetadata;
import com.taboola.backstage.model.dynamic.DynamicRow;
import com.taboola.backstage.model.media.account.AccountBlockedPublishers;
import com.taboola.backstage.model.media.account.AccountBlockedPublishersPatch;
import com.taboola.backstage.model.media.campaigns.Campaign;
import com.taboola.backstage.model.media.campaigns.CampaignBase;
import com.taboola.backstage.model.media.campaigns.CampaignLookalikeAudienceTargeting;
import com.taboola.backstage.model.media.campaigns.CampaignMultiTargetingCollection;
import com.taboola.backstage.model.media.campaigns.CampaignOperation;
import com.taboola.backstage.model.media.campaigns.CampaignPatch;
import com.taboola.backstage.model.media.campaigns.CampaignsMassiveOperation;
import com.taboola.backstage.model.media.campaigns.SharedBudgetBase;
import com.taboola.backstage.model.media.campaigns.SharedBudgetOperation;
import com.taboola.backstage.model.media.campaigns.items.CampaignItem;
import com.taboola.backstage.model.media.campaigns.items.CampaignItemOperation;
import com.taboola.backstage.model.media.campaigns.items.CampaignPerformanceVideoItem;
import com.taboola.backstage.model.media.campaigns.items.CampaignPerformanceVideoItemOperation;
import com.taboola.backstage.model.media.campaigns.items.PerformanceVideoBulkCreateOperation;
import com.taboola.backstage.model.media.campaigns.items.PerformanceVideoBulkUpdateOperation;
import com.taboola.backstage.model.media.campaigns.targeting.PostalTargeting;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 * Created by vladi
 * Date: 11/14/2017
 * Time: 10:26 PM
 * By Taboola
 */
public abstract class BackstageTestBase {

    protected static final PodamFactory factory = new PodamFactoryImpl();

    protected BackstageAuthentication generateDummyPasswordBackstageAuth() {
        return new BackstageAuthentication(generateDummyPasswordAuthenticationDetails(), generateDummyToken());
    }

    protected BackstageAuthentication generateDummyClientCredentialsBackstageAuth() {
        return new BackstageAuthentication(generateDummyClientCredAuthenticationDetails(), generateDummyToken());
    }

    protected PasswordAuthenticationDetails generateDummyPasswordAuthenticationDetails() {
        return new PasswordAuthenticationDetails("DummyClientId", "DummyClientSecret",
        "DummyUsername", "DummyPassword");
    }

    protected ClientCredentialAuthenticationDetails generateDummyClientCredAuthenticationDetails() {
        return new ClientCredentialAuthenticationDetails("DummyClientId", "DummyClientSecret");
    }

    protected Token generateDummyToken() {
        Token token = new Token();
        token.setAccessToken("accesstoken");
        token.setExpiresIn(1000);
        token.setRefreshToken("refreshtoken");
        token.setTokenType("bearer");
        return token;
    }

    protected Account generateDummyAccount() {
        return factory.manufacturePojo(Account.class);
    }

    protected Campaign generateDummyCampaign() {
        return factory.manufacturePojo(Campaign.class);
    }

    protected CampaignBase generateDummyCampaignBase() {
        return factory.manufacturePojo(CampaignBase.class);
    }

    protected CampaignsMassiveOperation generateDummyCampaignsBulkOperation() {
        return factory.manufacturePojo(CampaignsMassiveOperation.class);
    }

    protected CampaignOperation generateDummyCampaignOperation() {
        CampaignOperation campaign = factory.manufacturePojo(CampaignOperation.class);
        campaign.setName(null);
        campaign.setBrandingText(null);
        campaign.setCpc(null);
        campaign.setSpendingLimit(null);
        campaign.setSpendingLimitModel(null);
        campaign.setStartDate(null);
        return campaign;
    }

    protected SharedBudgetOperation generateDummySharedBudgetOperation() {
        SharedBudgetOperation sharedBudgetOperation = factory.manufacturePojo(SharedBudgetOperation.class);
        sharedBudgetOperation.setName(null);
        sharedBudgetOperation.setSpendingLimit(null);
        sharedBudgetOperation.setSpendingLimitModel(null);
        sharedBudgetOperation.setStartDate(null);
        return sharedBudgetOperation;
    }

    protected SharedBudgetBase generateDummyShareBudgetBase() {
        return factory.manufacturePojo(SharedBudgetBase.class);
    }

    protected CampaignItem generateDummyCampaignItem() {
        return factory.manufacturePojo(CampaignItem.class);
    }

    protected CampaignPerformanceVideoItem generateDummyCampaignPerformanceVideoItem() {
        return factory.manufacturePojo(CampaignPerformanceVideoItem.class);
    }

    protected CampaignPerformanceVideoItemOperation generateDummyCampaignPerformanceVideoItemOperation() {
        return factory.manufacturePojo(CampaignPerformanceVideoItemOperation.class);
    }

    protected PerformanceVideoBulkCreateOperation generateDummyPerformanceVideoBulkCreateOperation() {
        return factory.manufacturePojo(PerformanceVideoBulkCreateOperation.class);
    }

    protected PerformanceVideoBulkUpdateOperation generateDummyPerformanceVideoBulkUpdateOperation() {
        return factory.manufacturePojo(PerformanceVideoBulkUpdateOperation.class);
    }

    protected CampaignItemOperation generateDummyCampaignItemOperation() {
        CampaignItemOperation campaignItemOperation = factory.manufacturePojo(CampaignItemOperation.class);
        campaignItemOperation.setUrl(null);
        return campaignItemOperation;
    }

    protected Resource generateDummyResource() {
        return factory.manufacturePojo(Resource.class);
    }

    protected <REPORT extends Report<ROW>, ROW> REPORT generateDummyReport(Class<REPORT> reportClass, Class<ROW> rowClass, int numOfRandomRows) throws IllegalAccessException, InstantiationException {
        REPORT report = reportClass.newInstance();

        Collection<ROW> rows = new LinkedList<>();
        for(int i = 0 ; i < numOfRandomRows ; i++) {
            rows.add(factory.manufacturePojo(rowClass));
        }

        report.setResults(rows);
        report.setLastUsedRawdataUpdateTime(new Date().toString());
        report.setTimezone("EST");
        return report;
    }

    protected <REPORT extends Report<ROW>, ROW extends DynamicRow> REPORT generateDummyReport(Class<REPORT> reportClass, Class<ROW> rowClass, int numOfRandomRows, int numOfRandomDynamicFields) throws IllegalAccessException, InstantiationException {
        REPORT report = reportClass.newInstance();

        Collection<ROW> rows = new LinkedList<>();
        DynamicFields dynamicFields = generateDummyDynamicFields(numOfRandomDynamicFields);
        for(int i = 0 ; i < numOfRandomRows ; i++) {
            ROW row = factory.manufacturePojo(rowClass);

            DynamicFields generatedDynamicFields = row.getDynamicFields();
            row.getDynamicFields().clear();
            if(dynamicFields != null) {
                generatedDynamicFields.addAll(generateDynamicFieldsDataWithSameIds(dynamicFields));
            }
            rows.add(row);
        }

        report.setMetadata(generateDummyColumnsMetadata(dynamicFields));
        report.setResults(rows);
        report.setLastUsedRawdataUpdateTime(new Date().toString());
        report.setTimezone("EST");
        return report;
    }

    private DynamicFields generateDynamicFieldsDataWithSameIds(DynamicFields dynamicFields) {
        if(dynamicFields == null) {
            return null;
        }

        DynamicFields res = new DynamicFields();
        res.addAll(dynamicFields.stream().map(curr -> {
            DynamicField field = factory.manufacturePojo(DynamicField.class);
            // populated by the client logic not the API response
            field.setDynamicFieldMetadata(null);
            return field.setId(curr.getId());
        }).collect(Collectors.toList()));
        return res;

    }

    protected PostalTargeting generateDummyPostalCodeTargeting() {
        return factory.manufacturePojo(PostalTargeting.class);
    }

    protected CampaignMultiTargetingCollection<Long> generateDummyAudienceMultiTargeting() {
        return factory.manufacturePojo(CampaignMultiTargetingCollection.class, Long.class.getGenericSuperclass());
    }

    protected CampaignMultiTargetingCollection<Long> generateDummyCustomAudience() {
        return factory.manufacturePojo(CampaignMultiTargetingCollection.class, Long.class.getGenericSuperclass());
    }

    protected CampaignMultiTargetingCollection<CampaignLookalikeAudienceTargeting> generateDummyLookalikeAudience() {
        return factory.manufacturePojo(CampaignMultiTargetingCollection.class, CampaignLookalikeAudienceTargeting.class.getGenericSuperclass());
    }

    protected CampaignMultiTargetingCollection<String> generateDummyMarkingLabels() {
        return factory.manufacturePojo(CampaignMultiTargetingCollection.class, String.class.getGenericSuperclass());
    }

    protected DynamicFields generateDummyDynamicFields(int numOfFields) {
        if(numOfFields == 0) {
            return null;
        }

        DynamicFields dynamicFields = new DynamicFields();

        for(int i = 0 ; i < numOfFields ; i++) {
            DynamicField dynamicField = factory.manufacturePojo(DynamicField.class);
            dynamicField.setDynamicFieldMetadata(null);
            dynamicFields.add(dynamicField);
        }

        return dynamicFields;
    }

    protected ColumnsMetadata generateDummyColumnsMetadata(DynamicFields dynamicFields) {
        if(dynamicFields == null) {
            return null;
        }

        ColumnsMetadata reportMetadata = new ColumnsMetadata();

        DynamicFieldsMetadata dynamicFieldMetadata = new DynamicFieldsMetadata();
        for (DynamicField field : dynamicFields) {
            DynamicFieldMetadata metadata = factory.manufacturePojo(DynamicFieldMetadata.class);
            metadata.setId(field.getId());
            dynamicFieldMetadata.add(metadata);
        }

        reportMetadata.setDynamicFields(dynamicFieldMetadata);
        return reportMetadata;
    }

    protected CampaignPatch generateDummyCampaignPatch() {
        return factory.manufacturePojo(CampaignPatch.class);
    }

    protected AudienceSegment generateDummyAudienceSegment() {
        return factory.manufacturePojo(AudienceSegment.class);
    }

    protected LookalikeAudience generateDummyLookalikeAudiences() {
        return factory.manufacturePojo(LookalikeAudience.class);
    }

    protected AccountBlockedPublishers generateDummyAccountBlockedPublishers() {
        return factory.manufacturePojo(AccountBlockedPublishers.class);
    }

    protected AccountBlockedPublishersPatch generateDummyAccountBlockedPublishersPatch() {
        return factory.manufacturePojo(AccountBlockedPublishersPatch.class);
    }
}
