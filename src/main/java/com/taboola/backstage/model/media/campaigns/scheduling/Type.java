package com.taboola.backstage.model.media.campaigns.scheduling;

/**
 * <p>
 *    <br>⚫ INCLUDE - Only supplied values will activate campaign
 *    <br>⚫ EXCLUDE - All values should activate campaign other than the supplied values.
 *    <br>⚫ ALL - No restrictions - all options.
 * </p>
 *
 * Created by vladi.m
 * Date 03/10/2018
 * Time 16:15
 * Copyright Taboola
 */
public enum Type {
    INCLUDE,
    EXCLUDE
}
