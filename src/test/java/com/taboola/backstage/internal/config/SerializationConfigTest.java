package com.taboola.backstage.internal.config;

import org.junit.Assert;
import org.junit.Test;

public class SerializationConfigTest {

    @Test
    public void serializationConfig_defaultBuilder_emptyMixinIsCreated() {
        SerializationConfig serializationConfig = SerializationConfig.builder().build();
        Assert.assertNotNull("Missing mixin", serializationConfig.getMixins());
        Assert.assertEquals("Mixin is not empty by default", 0, serializationConfig.getMixins().size());
        Assert.assertFalse("Wrong default value for isAnySetterAnnotationIgnored", serializationConfig.isAnySetterAnnotationIgnored());
    }
}
