package com.taboola.backstage.internal.extensions;

/**
 * Created by vladi
 * Date: 3/4/2018
 * Time: 12:37 AM
 * By Taboola
 */
public class BackstageExtensionUtilsImpl implements BackstageExtensionUtils {

    private final BackstageEndpointsFactory endpointsFactory;

    public BackstageExtensionUtilsImpl(BackstageEndpointsFactory endpointsFactory) {
        this.endpointsFactory = endpointsFactory;
    }

    @Override
    public BackstageEndpointsFactory getEndpointFactory() {
        return endpointsFactory;
    }
}
