package com.taboola.backstage.internal.extensions;

/**
 * <p>
 *   Backstage extension utils
 * </p>
 * @author vladi
 * @version 1.0
 */
public interface BackstageExtensionUtils {

    /**
     * <p>
     *   Backstage endpoints factory, creates interface implementations
     * </p>
     * @return {@link BackstageEndpointsFactory}
     */
    BackstageEndpointsFactory getEndpointFactory();

}
