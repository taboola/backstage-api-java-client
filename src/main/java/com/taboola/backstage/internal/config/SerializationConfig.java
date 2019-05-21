package com.taboola.backstage.internal.config;

import java.util.HashMap;
import java.util.Map;

public class SerializationConfig {
    private final Map<Class<?>, Class<?>> mixins;
    private final boolean shouldIgnoreAnySetterAnnotation;

    private SerializationConfig(Map<Class<?>, Class<?>> mixins, boolean shouldIgnoreAnySetterAnnotation) {
        this.mixins = mixins;
        this.shouldIgnoreAnySetterAnnotation = shouldIgnoreAnySetterAnnotation;
    }

    public Map<Class<?>, Class<?>> getMixins() {
        return mixins;
    }

    public boolean shouldIgnoreAnySetterAnnotation() {
        return shouldIgnoreAnySetterAnnotation;
    }

    @Override
    public String toString() {
        return "SerializationConfig{" +
                "mixins=" + mixins +
                ", shouldIgnoreAnySetterAnnotation=" + shouldIgnoreAnySetterAnnotation +
                '}';
    }

    public static SerializationConfigBuilder builder() {
        return new SerializationConfigBuilder();
    }

    public static class SerializationConfigBuilder {
        private Map<Class<?>, Class<?>> mixins;
        private Boolean shouldIgnoreAnySetterAnnotation;

        public SerializationConfigBuilder setMixins(Map<Class<?>, Class<?>> mixins) {
            this.mixins = mixins;
            return this;
        }

        public SerializationConfigBuilder setShouldIgnoreAnySetterAnnotation(Boolean shouldIgnoreAnySetterAnnotation) {
            this.shouldIgnoreAnySetterAnnotation = shouldIgnoreAnySetterAnnotation;
            return this;
        }

        public SerializationConfig build() {
            organizeState();
            return new SerializationConfig(mixins, shouldIgnoreAnySetterAnnotation);
        }

        private void organizeState() {
            if (mixins == null) {
                mixins = new HashMap<>();
            }

            if (this.shouldIgnoreAnySetterAnnotation == null) {
                shouldIgnoreAnySetterAnnotation = false;
            }
        }
    }
}
