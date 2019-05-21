package com.taboola.backstage.internal.interceptors;

import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;

public class IgnoreAnySetterSerializationInterceptor extends JacksonAnnotationIntrospector {
    @Override
    public boolean hasAnySetterAnnotation(AnnotatedMethod am) {
        return false;
    }
}
