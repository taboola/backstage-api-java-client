package com.taboola.backstage.internal.config;

import java.util.HashMap;
import java.util.Map;

public class SerializationConfig {
    private final Map<Class<?>, Class<?>> mixins;
    private final boolean isAnySetterAnnotationIgnored;

    private SerializationConfig(Map<Class<?>, Class<?>> mixins, boolean isAnySetterAnnotationIgnored) {
        this.mixins = mixins;
        this.isAnySetterAnnotationIgnored = isAnySetterAnnotationIgnored;
    }

    public Map<Class<?>, Class<?>> getMixins() {
        return mixins;
    }

    public boolean isAnySetterAnnotationIgnored() {
        return isAnySetterAnnotationIgnored;
    }

    @Override
    public String toString() {
        return "SerializationConfig{" +
                "mixins=" + mixins +
                ", isAnySetterAnnotationIgnored=" + isAnySetterAnnotationIgnored +
                '}';
    }

    public static SerializationConfigBuilder builder() {
        return new SerializationConfigBuilder();
    }

    public static class SerializationConfigBuilder {
        private Map<Class<?>, Class<?>> mixins;
        private Boolean isAnySetterAnnotationIgnored;

        public SerializationConfigBuilder setMixins(Map<Class<?>, Class<?>> mixins) {
            this.mixins = mixins;
            return this;
        }

        public SerializationConfigBuilder setIsAnySetterAnnotationIgnored(Boolean isAnySetterAnnotationIgnored) {
            this.isAnySetterAnnotationIgnored = isAnySetterAnnotationIgnored;
            return this;
        }

        public SerializationConfig build() {
            organizeState();
            return new SerializationConfig(mixins, isAnySetterAnnotationIgnored);
        }

        private void organizeState() {
            if (mixins == null) {
                mixins = new HashMap<>();
            }

            if (this.isAnySetterAnnotationIgnored == null) {
                isAnySetterAnnotationIgnored = false;
            }
        }
    }
}
