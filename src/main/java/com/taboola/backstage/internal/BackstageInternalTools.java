package com.taboola.backstage.internal;

import com.taboola.backstage.internal.factories.BackstageEndpointsFactory;

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

}
