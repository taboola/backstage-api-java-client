package com.taboola.backstage.plugin;

/**
 * Created by vladi
 * Date: 2/25/2018
 * Time: 10:22 PM
 * By Taboola
 */
public interface BackstagePluginFactory {

    /**
     * Creates backstage authentication endpoint
     * @param endpointClazz interface representing endpoint
     * @return implementation of a supplied endpoint class
     */
    <A> A createAuthEndpoint(Class<A> endpointClazz);

    /**
     * Creates backstage endpoint
     * @param endpointClazz interface representing endpoint
     * @return implementation of a supplied endpoint class
     */
    <E> E createEndpoint(Class<E> endpointClazz);
}
