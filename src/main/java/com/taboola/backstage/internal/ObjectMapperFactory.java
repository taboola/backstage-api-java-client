package com.taboola.backstage.internal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.taboola.backstage.internal.config.SerializationConfig;
import com.taboola.backstage.internal.interceptors.IgnoreAnySetterSerializationInterceptor;

public class ObjectMapperFactory {
    public ObjectMapper createObjectMapper(SerializationConfig serializationConfig) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        serializationConfig.getMixins().forEach(objectMapper::addMixIn);

        if (serializationConfig.shouldIgnoreAnySetterAnnotation()) {
            objectMapper.setAnnotationIntrospector(new IgnoreAnySetterSerializationInterceptor());
        }

        return objectMapper;
    }
}
