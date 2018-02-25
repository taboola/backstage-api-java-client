package com.taboola.backstage.plugin;

import com.taboola.backstage.internal.CommunicationFactory;

/**
 * Created by vladi
 * Date: 2/25/2018
 * Time: 11:00 PM
 * By Taboola
 */
public class BackstagePluginFactoryImpl implements BackstagePluginFactory {

    private final CommunicationFactory communicationFactory;

    public BackstagePluginFactoryImpl(CommunicationFactory communicationFactory) {
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
