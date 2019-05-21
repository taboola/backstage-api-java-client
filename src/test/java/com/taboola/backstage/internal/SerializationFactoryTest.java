package com.taboola.backstage.internal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.taboola.backstage.internal.config.SerializationConfig;
import com.taboola.backstage.internal.interceptors.IgnoreAnySetterSerializationInterceptor;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class SerializationFactoryTest {

    @Test
    public void applySerializationConfig_defaultSerializationConfig_appliedDefaultConfig() {
        SerializationConfig serializationConfig = SerializationConfig.builder()
                .build();

        ObjectMapper objectMapper = Mockito.mock(ObjectMapper.class);
        SerializationFactory.create().applySerializationConfig(serializationConfig, objectMapper);

        verify(objectMapper).setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
        verify(objectMapper).setSerializationInclusion(JsonInclude.Include.NON_NULL);
        verify(objectMapper).configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        verify(objectMapper, never()).addMixIn(any(), any());
        verify(objectMapper, never()).setAnnotationIntrospector(any());
    }

    @Test
    public void applySerializationConfig_shouldIgnoreAnySetterSetToTrue_addedAnnotationIntrospector() {
        SerializationConfig serializationConfig = SerializationConfig.builder()
                .setShouldIgnoreAnySetterAnnotation(true)
                .build();

        ObjectMapper objectMapper = Mockito.mock(ObjectMapper.class);
        SerializationFactory.create().applySerializationConfig(serializationConfig, objectMapper);

        verify(objectMapper).setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
        verify(objectMapper).setSerializationInclusion(JsonInclude.Include.NON_NULL);
        verify(objectMapper).configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        verify(objectMapper, never()).addMixIn(any(), any());
        verify(objectMapper).setAnnotationIntrospector(any(IgnoreAnySetterSerializationInterceptor.class));
    }
}
