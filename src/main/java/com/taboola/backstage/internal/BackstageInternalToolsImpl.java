package com.taboola.backstage.internal;

import com.taboola.backstage.internal.factories.BackstageEndpointsFactory;

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
}
