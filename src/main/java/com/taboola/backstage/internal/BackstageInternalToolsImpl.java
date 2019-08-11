package com.taboola.backstage.internal;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

import com.taboola.backstage.internal.factories.BackstageEndpointsFactory;
import com.taboola.backstage.model.ColumnsMetadata;
import com.taboola.backstage.model.Report;
import com.taboola.backstage.model.dynamic.DynamicField;
import com.taboola.backstage.model.dynamic.DynamicFieldMetadata;
import com.taboola.backstage.model.dynamic.DynamicFields;
import com.taboola.backstage.model.dynamic.DynamicRow;

/**
 * Created by vladi
 * Date: 3/4/2018
 * Time: 12:37 AM
 * By Taboola
 */
public class BackstageInternalToolsImpl implements BackstageInternalTools {

    private final BackstageEndpointsFactory endpointsFactory;

    public BackstageInternalToolsImpl(BackstageEndpointsFactory endpointsFactory) {
        this.endpointsFactory = endpointsFactory;
    }

    @Override
    public BackstageEndpointsFactory endpointFactory() {
        return endpointsFactory;
    }

    @Override
    public <R extends DynamicRow> void attachDynamicFieldMetadataToFields(Report<R> report) {
        ColumnsMetadata metadata = report.getMetadata();
        if(metadata == null || metadata.getDynamicFields() == null) {
            return;
        }

        Map<String, DynamicFieldMetadata> dynamicFieldIdToMetadata = metadata.getDynamicFields()
                                                                            .stream()
                                                                            .collect(Collectors.toMap(DynamicFieldMetadata::getId, v -> v));

        Collection<R> rows = report.getResults();
        for(R row : rows) {
            DynamicFields dynamicFields = row.getDynamicFields();
            for(DynamicField field : dynamicFields) {
                DynamicFieldMetadata dynamicFieldMetadata = dynamicFieldIdToMetadata.get(field.getId());
                field.setDynamicFieldMetadata(dynamicFieldMetadata);
            }
        }
    }
}
