package com.taboola.backstage.internal.serialization;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.taboola.backstage.internal.config.SerializationConfig;

public class ObjectMapperFactory {

    public static ObjectMapperFactory create() {
        return new ObjectMapperFactory();
    }

    private ObjectMapperFactory() { }

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
