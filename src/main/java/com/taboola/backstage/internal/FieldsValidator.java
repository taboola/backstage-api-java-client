package com.taboola.backstage.internal;

import com.taboola.backstage.annotations.Final;
import com.taboola.backstage.annotations.ReadOnly;
import com.taboola.backstage.annotations.Required;
import com.taboola.backstage.exceptions.BackstageAPIRequestException;
import com.taboola.backstage.internal.functional.BiFunction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by vladi
 * Date: 1/17/2018
 * Time: 10:56 PM
 * By Taboola
 */
public class FieldsValidator {

    private static final Logger logger = LogManager.getLogger(FieldsValidator.class);
    private static final BiFunction<Object, Field, Boolean, IllegalAccessException> FAIL_ON_NULL_FUNC = (object, field) -> field.get(object) == null;
    private static final BiFunction<Object, Field, Boolean, IllegalAccessException> FAIL_ON_NOT_NULL_FUNC = (object, field) -> field.get(object) != null;

    private static final Map<Class<?>, BiFunction<Object, Field, Boolean, IllegalAccessException>> FAIL_ON_CREATION;
    private static final Map<Class<?>, BiFunction<Object, Field, Boolean, IllegalAccessException>> FAIL_ON_UPDATE;

    static {
        FAIL_ON_CREATION = new HashMap<>();
        FAIL_ON_CREATION.put(Required.class, FAIL_ON_NULL_FUNC);
        FAIL_ON_CREATION.put(Final.class, FAIL_ON_NULL_FUNC);
        FAIL_ON_CREATION.put(ReadOnly.class, FAIL_ON_NOT_NULL_FUNC);

        FAIL_ON_UPDATE = new HashMap<>();
        FAIL_ON_UPDATE.put(ReadOnly.class, FAIL_ON_NOT_NULL_FUNC);
        FAIL_ON_UPDATE.put(Final.class, FAIL_ON_NOT_NULL_FUNC);
    }

    public static void validateCreateOperation(Object obj) {
        validate(obj, FAIL_ON_CREATION);
    }

    public static void validateUpdateOperation(Object obj) {
        validate(obj, FAIL_ON_UPDATE);
    }

    private static void validate(Object obj, Map<Class<?>, BiFunction<Object, Field, Boolean, IllegalAccessException>> failOn) {
        List<Field> declaredFields = getAllFields(obj.getClass());
        for(Field field : declaredFields) {
            for(Annotation fieldAnnotation : field.getDeclaredAnnotations()) {
                Class<?> annotation = fieldAnnotation.annotationType();
                BiFunction<Object, Field, Boolean, IllegalAccessException> func = failOn.get(annotation);
                if(func != null) {
                    field.setAccessible(true);
                    try {
                        if(func.apply(obj, field)) {
                            throw new BackstageAPIRequestException("Field '%s' is '%s'", field.getName(), annotation.getSimpleName());
                        }

                    } catch (IllegalAccessException e) {
                        logger.error("Failed to pull field data from field [{}] for annotation [{}]", field.getName(), annotation.toString());
                    }
                }
            }
        }
    }

    private static List<Field> getAllFields(Class<?> type) {
        List<Field> fields = new LinkedList<>();
        for (Class<?> c = type ; c != null ; c = c.getSuperclass()) {
            fields.addAll(Arrays.asList(c.getDeclaredFields()));
        }
        return fields;
    }
}
