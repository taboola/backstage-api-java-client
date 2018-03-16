package com.taboola.backstage.internal.factories;

/**
 * <p>
 *   Backstage endpoints factory, creates interface implementations
 * </p>
 * @author vladi
 * @since 1.0.2
 */
public interface BackstageEndpointsFactory {

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
