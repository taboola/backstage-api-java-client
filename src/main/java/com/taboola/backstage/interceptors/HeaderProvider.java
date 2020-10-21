package com.taboola.backstage.interceptors;

import com.taboola.backstage.model.Header;

/**
 * Created by vladi.m
 * Date 21/10/2020
 * Time 21
 * Copyright Taboola
 */
public interface HeaderProvider {

    Header get();
}
