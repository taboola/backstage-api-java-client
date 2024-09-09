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
     * @param <A> represents endpoint class
     * @return implementation of a supplied endpoint class
     */
    <A> A createAuthEndpoint(Class<A> endpointClazz);

    /**
     * Creates backstage endpoint
     * @param endpointClazz interface representing endpoint
     * @param <E> represents auth endpoint class
     * @return implementation of a supplied endpoint class
     */
    <E> E createEndpoint(Class<E> endpointClazz);

    /**
     * Creates backstage tracking endpoint
     * @param endpointClazz interface representing endpoint
     * @param <E> represents auth endpoint class
     * @return implementation of a supplied endpoint class
     */
    <E> E createTrackingEndpoint(Class<E> endpointClazz);
}
