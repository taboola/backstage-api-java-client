package com.taboola.backstage.internal.factories;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

import com.taboola.rest.api.RestAPIClient;

/**
 * Created by vladi
 * Date: 2/25/2018
 * Time: 11:00 PM
 * By Taboola
 */
public class BackstageEndpointsRetrofitFactory implements BackstageEndpointsFactory {

    private static final Logger logger = LogManager.getLogger(BackstageEndpointsRetrofitFactory.class);

    private final RestAPIClient backstageClient;
    private final RestAPIClient authenticationClient;

    public BackstageEndpointsRetrofitFactory(RestAPIClient backstageClient, RestAPIClient authenticationClient) {
        this.backstageClient = backstageClient;
        this.authenticationClient = authenticationClient;
    }

    @Override
    public <A> A createAuthEndpoint(Class<A> clazz) {
        Objects.requireNonNull(clazz, "clazz");
        logger.debug("creating authentication endpoint using retrofit for class [{}]", clazz::toString);
        return authenticationClient.createRetrofitEndpoint(clazz);
    }

    @Override
    public <E> E createEndpoint(Class<E> clazz) {
        Objects.requireNonNull(clazz, "clazz");
        logger.debug("creating endpoint using retrofit for class [{}]", clazz::toString);
        return backstageClient.createRetrofitEndpoint(clazz);
    }
}
