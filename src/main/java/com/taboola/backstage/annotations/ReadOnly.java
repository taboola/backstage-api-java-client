package com.taboola.backstage.annotations;

import java.lang.annotation.*;

/**
 * Read-only fields are fields that should never be sent to the server, and will appear only when fetching a resource.
 *
 * Created by vladi
 * Date: 1/15/2018
 * Time: 10:17 PM
 * By Taboola
 */
@Documented
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.FIELD})
public @interface ReadOnly {
}
