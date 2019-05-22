package com.taboola.backstage.internal.serialization;

import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;

public class IgnoreAnySetterSerializationIntrospector extends JacksonAnnotationIntrospector {
    @Override
    public boolean hasAnySetterAnnotation(AnnotatedMethod am) {
        return false;
    }

    @Override
    public Boolean hasAnySetter(Annotated a) {
        return false;
    }
}
