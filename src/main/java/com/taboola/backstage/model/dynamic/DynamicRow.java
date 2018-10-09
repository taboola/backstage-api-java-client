package com.taboola.backstage.model.dynamic;

/**
 * Created by vladi.m
 * Date 05/10/2018
 * Time 14:33
 * Copyright Taboola
 */
public interface DynamicRow {

    /**
     * Returns dynamic fields of specific row
     */
    DynamicFields getDynamicFields();
}
