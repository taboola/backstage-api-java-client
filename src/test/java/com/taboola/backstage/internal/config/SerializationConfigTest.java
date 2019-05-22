package com.taboola.backstage.internal.config;

import org.junit.Assert;
import org.junit.Test;

public class SerializationConfigTest {

    @Test
    public void serializationConfig_defaultConstructor_configInitializedWithDefaultValues() {
        SerializationConfig serializationConfig = new SerializationConfig();
        Assert.assertNotNull("Missing mixin", serializationConfig.getMixins());
        Assert.assertEquals("Mixin is not empty by default", 0, serializationConfig.getMixins().size());
        Assert.assertFalse("Wrong default value for shouldIgnoreAnySetterAnnotation", serializationConfig.shouldIgnoreAnySetterAnnotation());
    }
}
