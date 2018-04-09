package com.taboola.backstage.internal.factories;

import com.taboola.backstage.internal.CommunicationFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

/**
 * Created by vladi
 * Date: 2/25/2018
 * Time: 11:00 PM
 * By Taboola
 */
public class BackstageEndpointsRetrofitFactory implements BackstageEndpointsFactory {

    private static final Logger logger = LogManager.getLogger(BackstageEndpointsRetrofitFactory.class);

    private final CommunicationFactory communicationFactory;

    public BackstageEndpointsRetrofitFactory(CommunicationFactory communicationFactory) {
        this.communicationFactory = communicationFactory;
    }

    @Override
    public <A> A createAuthEndpoint(Class<A> clazz) {
        Objects.requireNonNull(clazz, "clazz");
        logger.debug("creating authentication endpoint using retrofit for class [{}]", clazz::toString);
        return communicationFactory.createRetrofitAuthEndpoint(clazz);
    }

    @Override
    public <E> E createEndpoint(Class<E> clazz) {
        Objects.requireNonNull(clazz, "clazz");
        logger.debug("creating endpoint using retrofit for class [{}]", clazz::toString);
        return communicationFactory.createRetrofitEndpoint(clazz);
    }
}
