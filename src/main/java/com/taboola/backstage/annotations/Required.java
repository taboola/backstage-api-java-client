package com.taboola.backstage.annotations;

import java.lang.annotation.*;

/**
 * Required fields are fields that must be sent to the server when creating a new resource.
 *
 * Created by vladi
 * Date: 1/15/2018
 * Time: 10:17 PM
 * By Taboola
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Required {
}
