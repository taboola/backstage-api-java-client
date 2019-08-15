package com.taboola.backstage.internal;

import com.taboola.backstage.internal.factories.BackstageEndpointsFactory;
import com.taboola.backstage.model.Report;
import com.taboola.backstage.model.dynamic.DynamicRow;

/**
 * <p>
 *   Backstage internal tools
 * </p>
 * @author vladi
 * @since 1.0.2
 */
public interface BackstageInternalTools {

    /**
     * <p>
     *   Backstage endpoints factory, creates interface implementations
     * </p>
     * @return {@link BackstageEndpointsFactory}
     */
    BackstageEndpointsFactory endpointFactory();

    /**
     * <p>
     *   Backstage {@link Report} helper function. Goes over dynamic fields in the given report object
     *   and attach to each dynamic field its metadata.
     *   Side effect: supplied object is changed by reference
     * </p>
     * @param report {@link Report}
     * @param <R> represents dynamic row model
     */
    <R extends DynamicRow> void attachDynamicFieldMetadataToFields(Report<R> report);
}
