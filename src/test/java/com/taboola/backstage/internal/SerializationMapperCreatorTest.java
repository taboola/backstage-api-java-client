package com.taboola.backstage.internal;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.taboola.backstage.internal.config.SerializationConfig;
import com.taboola.backstage.internal.serialization.SerializationMapperCreator;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SerializationMapperCreatorTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void createObjectMapper_defaultSerializationConfig_objectMapperWithDefaultValues() {
        ObjectMapper objectMapper = SerializationMapperCreator.createObjectMapper(new SerializationConfig());

        Assert.assertEquals("Invalid property naming strategy", PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES, objectMapper.getPropertyNamingStrategy());
        Assert.assertEquals("Invalid mixin count", 0, objectMapper.mixInCount());
    }

    @Test
    public void createObjectMapper_serializationConfigWithMixins_objectMapperIsCreatedWithMixins() {
        Map<Class<?>, Class<?>> mixins = new HashMap<>();
        mixins.put(SampleApi.class, SampleMixIn.class);
        SerializationConfig serializationConfig = new SerializationConfig().setMixins(mixins);
        ObjectMapper objectMapper = SerializationMapperCreator.createObjectMapper(serializationConfig);

        Assert.assertEquals("Invalid mixin count", 1, objectMapper.mixInCount());
        Assert.assertEquals("Invalid property naming strategy", SampleMixIn.class, objectMapper.findMixInClassFor(SampleApi.class));
    }

    @Test
    public void createObjectMapper_defaultSerializationConfigAndApiObjectHasAnySetter_anySetterIsCalledOnSerialization() throws IOException {
        expectedException.expect(Exception.class);
        expectedException.expectMessage("unknown field");
        ObjectMapper objectMapper = SerializationMapperCreator.createObjectMapper(new SerializationConfig());

        objectMapper.readValue("{ \"id\": 1, \"test\": \"test\" }", SampleApi.class);
    }

    @Test
    public void createObjectMapper_serializationConfigWithoutAnySetterAndApiObjectHasAnySetter_anySetterIsCalledOnSerialization() throws IOException {
        expectedException.expect(Exception.class);
        expectedException.expectMessage("unknown field");
        ObjectMapper objectMapper = SerializationMapperCreator.createObjectMapper(new SerializationConfig());

        objectMapper.readValue("{ \"id\": 1, \"test\": \"test\" }", SampleApi.class);
    }

    @Test
    public void createObjectMapper_serializationConfigWithIgnoreAnySetterAndApiObjectHasAnySetter_anySetterIgnored() throws IOException {
        SerializationConfig serializationConfig = new SerializationConfig().setShouldIgnoreAnySetterAnnotation();
        ObjectMapper objectMapper = SerializationMapperCreator.createObjectMapper(serializationConfig);

        SampleApi sampleApi = objectMapper.readValue("{ \"id\": 1, \"test\": \"test\" }", SampleApi.class);
        Assert.assertEquals("Id parsed incorrectly", 1, sampleApi.id);
        Assert.assertNull("Name is parsed incorrectly", sampleApi.name);
    }

    private static class SampleApi {
        @JsonProperty("id")
        int id;

        @JsonProperty("name")
        String name;

        @JsonAnySetter
        public void handlerUnknownSetter(String field, Object value) throws Exception {
            throw new Exception("unknown field");
        }
    }

    private abstract class SampleMixIn {
        @JsonIgnore
        private String name;
    }
}
