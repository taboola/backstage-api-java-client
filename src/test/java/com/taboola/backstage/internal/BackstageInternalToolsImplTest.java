package com.taboola.backstage.internal;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.taboola.backstage.BackstageTestBase;
import com.taboola.backstage.model.dynamic.DynamicField;
import com.taboola.backstage.model.dynamic.DynamicFields;
import com.taboola.backstage.model.dynamic.DynamicFieldsMetadata;
import com.taboola.backstage.model.media.reports.CampaignSummaryReport;
import com.taboola.backstage.model.media.reports.CampaignSummaryRow;

/**
 * Created by vladi.m
 * Date 2019-08-11
 * Time 12:58
 * Copyright Taboola
 */
public class BackstageInternalToolsImplTest extends BackstageTestBase {

    private BackstageInternalTools backstageInternalTools;

    public BackstageInternalToolsImplTest() {
        this.backstageInternalTools = new BackstageInternalToolsImpl(null);
    }

    @Test
    public void attachDynamicFieldMetadataToFields_whenFlagEnabled_expectingMetadataOnField() throws InstantiationException, IllegalAccessException {
        CampaignSummaryReport report = generateDummyReport(CampaignSummaryReport.class, CampaignSummaryRow.class, 1, 1);

        backstageInternalTools.attachDynamicFieldMetadataToFields(report);

        assertNotNull("Expecting metadata object", report.getMetadata());
        DynamicFields dynamicFields = report.getResults().iterator().next().getDynamicFields();
        assertNotNull("Expecting dynamic fields", dynamicFields);

        DynamicFieldsMetadata dynamicFieldsMetadata = report.getMetadata().getDynamicFields();
        for(DynamicField field : dynamicFields) {
            assertEquals("Miss match between dynamic field and its metadata", field.getId(), field.getDynamicFieldMetadata().getId());
            assertThat("Metadata does not exists", dynamicFieldsMetadata, hasItem(field.getDynamicFieldMetadata()));
        }
    }
}
