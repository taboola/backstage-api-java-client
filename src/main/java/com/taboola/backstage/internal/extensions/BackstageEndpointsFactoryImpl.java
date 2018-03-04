package com.taboola.backstage.internal.extensions;

import com.taboola.backstage.internal.CommunicationFactory;

/**
 * Created by vladi
 * Date: 2/25/2018
 * Time: 11:00 PM
 * By Taboola
 */
public class BackstageEndpointsFactoryImpl implements BackstageEndpointsFactory {

    private final CommunicationFactory communicationFactory;

    public BackstageEndpointsFactoryImpl(CommunicationFactory communicationFactory) {
        this.communicationFactory = communicationFactory;
    }

    @Override
    public <A> A createAuthEndpoint(Class<A> clazz) {
        return communicationFactory.createAuthEndpoint(clazz);
    }

    @Override
    public <E> E createEndpoint(Class<E> clazz) {
        return communicationFactory.createEndpoint(clazz);
    }
}
