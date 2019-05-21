package com.taboola.backstage.internal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.taboola.backstage.internal.config.SerializationConfig;
import com.taboola.backstage.internal.serialization.ObjectMapperFactory;

import org.junit.Assert;
import org.junit.Test;

public class ObjectMapperFactoryTest {

    @Test
    public void createObjectMapper_defaultSerializationConfig_objectMapperWithDefaultValues() {
        ObjectMapper objectMapper = ObjectMapperFactory.create().createObjectMapper(new SerializationConfig());

        Assert.assertEquals("Invalid property naming strategy", PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES, objectMapper.getPropertyNamingStrategy());
        Assert.assertEquals("Invalid property naming strategy", 0, objectMapper.mixInCount());
    }

    //TODO write test for case of adding mixin that they were added

    //TODO write test for ignore anySetter that taking effect in object mapper
}
