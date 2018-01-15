package com.taboola.backstage.annotations;

import java.lang.annotation.*;

/**
 * Final fields are set once, when creating the resource, and become read-only afterwards.
 *
 * Created by vladi
 * Date: 1/15/2018
 * Time: 10:18 PM
 * By Taboola
 */
@Documented
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.FIELD})
public @interface Final {
}
