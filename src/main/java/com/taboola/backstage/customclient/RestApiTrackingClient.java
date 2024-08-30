package com.taboola.backstage.customclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taboola.rest.api.exceptions.factories.DefaultExceptionFactory;
import com.taboola.rest.api.exceptions.factories.ExceptionFactory;
import com.taboola.rest.api.internal.CommunicationFactory;
import com.taboola.rest.api.internal.StringResponseFactories;
import com.taboola.rest.api.internal.config.CommunicationConfig;
import com.taboola.rest.api.internal.config.SerializationConfig;
import com.taboola.rest.api.internal.serialization.SerializationMapperCreator;
import com.taboola.rest.api.model.CommunicationInterceptor;
import com.taboola.rest.api.model.HttpLoggingLevel;
import com.taboola.rest.api.model.NoOpCommunicationInterceptor;
import com.taboola.rest.api.model.RequestHeader;
import com.taboola.rest.api.model.StringResponseFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * Created by Marcelo Dias on 08/30/2024.
 */
public class RestApiTrackingClient {
    private static final Logger logger = LogManager.getLogger(RestApiTrackingClient.class);

    private final CommunicationFactory communicator;

    private RestApiTrackingClient(CommunicationFactory communicator) {
        this.communicator = communicator;
    }

    public <E> E createRetrofitEndpoint(Class<E> endpointClazz) {
        Objects.requireNonNull(endpointClazz, "clazz");
        logger.debug("creating endpoint using retrofit for class [{}]", endpointClazz::toString);
        return communicator.createRetrofitEndpoint(endpointClazz);
    }

    public static RestApiTrackingClient.RestAPIClientBuilder builder() {
        return new RestApiTrackingClient.RestAPIClientBuilder();
    }

    public static class RestAPIClientBuilder {
        private static final Integer DEFAULT_MAX_IDLE_CONNECTIONS = 5;
        private static final Long DEFAULT_KEEP_ALIVE_DURATION_MILLIS = 300_000L;
        private static final SerializationConfig DEFAULT_SERIALIZATION_CONFIG = new SerializationConfig();
        private static final ExceptionFactory DEFAULT_EXCEPTION_FACTORY = new DefaultExceptionFactory();
        private static final CommunicationInterceptor DEFAULT_COMMUNICATION_INTERCEPTOR = new NoOpCommunicationInterceptor();

        private String baseUrl;
        private Long writeTimeoutMillis;
        private Long connectionTimeoutMillis;
        private Long readTimeoutMillis;
        private Integer maxIdleConnections;
        private Long keepAliveDurationMillis;
        private Boolean debug;
        private SerializationConfig serializationConfig;
        private ExceptionFactory exceptionFactory;
        private ObjectMapper objectMapper;
        private final StringResponseFactories stringResponseFactories = new StringResponseFactories();
        private HttpLoggingLevel loggingLevel;
        private CommunicationInterceptor communicationInterceptor;

        public RestApiTrackingClient.RestAPIClientBuilder setLoggingLevel(HttpLoggingLevel loggingLevel) {
            this.loggingLevel = loggingLevel;
            return this;
        }

        public RestApiTrackingClient.RestAPIClientBuilder setBaseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
            return this;
        }

        public RestApiTrackingClient.RestAPIClientBuilder setConnectionTimeoutMillis(Long connectionTimeoutMillis) {
            this.connectionTimeoutMillis = connectionTimeoutMillis;
            return this;
        }

        public RestApiTrackingClient.RestAPIClientBuilder setReadTimeoutMillis(Long readTimeoutMillis) {
            this.readTimeoutMillis = readTimeoutMillis;
            return this;
        }

        public RestApiTrackingClient.RestAPIClientBuilder setWriteTimeoutMillis(Long writeTimeoutMillis) {
            this.writeTimeoutMillis = writeTimeoutMillis;
            return this;
        }

        public RestApiTrackingClient.RestAPIClientBuilder setMaxIdleConnections(Integer maxIdleConnections) {
            this.maxIdleConnections = maxIdleConnections;
            return this;
        }

        public RestApiTrackingClient.RestAPIClientBuilder setKeepAliveDurationMillis(Long keepAliveDurationMillis) {
            this.keepAliveDurationMillis = keepAliveDurationMillis;
            return this;
        }

        public RestApiTrackingClient.RestAPIClientBuilder setDebug(Boolean debug) {
            this.debug = debug;
            return this;
        }

        public RestApiTrackingClient.RestAPIClientBuilder setSerializationConfig(SerializationConfig serializationConfig) {
            this.serializationConfig = serializationConfig;
            return this;
        }

        public RestApiTrackingClient.RestAPIClientBuilder setExceptionFactory(ExceptionFactory exceptionFactory) {
            this.exceptionFactory = exceptionFactory;
            return this;
        }

        public RestApiTrackingClient.RestAPIClientBuilder setObjectMapper(ObjectMapper objectMapper) {
            this.objectMapper = objectMapper;
            return this;
        }

        public RestApiTrackingClient.RestAPIClientBuilder setCommunicationInterceptor(CommunicationInterceptor communicationInterceptor) {
            this.communicationInterceptor = communicationInterceptor;
            return this;
        }

        public RestApiTrackingClient.RestAPIClientBuilder addStringBodyResponseFactory(Class<?> clazz, StringResponseFactory stringResponseFactory) {
            stringResponseFactories.addFactory(clazz, stringResponseFactory);
            return this;
        }

        public RestApiTrackingClient build() {
            organizeState();
            Collection<RequestHeader> headers = new ArrayList<>();
            CommunicationConfig config = new CommunicationConfig(baseUrl, connectionTimeoutMillis, readTimeoutMillis, writeTimeoutMillis, maxIdleConnections,
                    keepAliveDurationMillis, headers, debug, exceptionFactory, objectMapper, stringResponseFactories, loggingLevel, communicationInterceptor);
            return new RestApiTrackingClient(new CommunicationFactory(config));
        }

        private void organizeState() {
            if (baseUrl == null) {
                throw new IllegalStateException("Missing base url");
            }

            if (connectionTimeoutMillis == null) {
                connectionTimeoutMillis = 0L;
            }

            if (readTimeoutMillis == null) {
                readTimeoutMillis = 0L;
            }

            if (writeTimeoutMillis == null) {
                writeTimeoutMillis = 0L;
            }

            if (maxIdleConnections == null) {
                maxIdleConnections = DEFAULT_MAX_IDLE_CONNECTIONS;
            }

            if (keepAliveDurationMillis == null) {
                keepAliveDurationMillis = DEFAULT_KEEP_ALIVE_DURATION_MILLIS;
            }

            if (debug == null) {
                debug = false;
            }

            if (serializationConfig == null) {
                serializationConfig = DEFAULT_SERIALIZATION_CONFIG;
            }

            if (exceptionFactory == null) {
                exceptionFactory = DEFAULT_EXCEPTION_FACTORY;
            }

            if (objectMapper == null) {
                objectMapper = SerializationMapperCreator.createObjectMapper(serializationConfig);
            }

            if (loggingLevel == null) {
                loggingLevel = HttpLoggingLevel.BASIC;
            }

            if(communicationInterceptor == null) {
                communicationInterceptor = DEFAULT_COMMUNICATION_INTERCEPTOR;
            }
        }
    }
}

