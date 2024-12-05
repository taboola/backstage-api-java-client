package com.taboola.backstage.model.media.campaigns.items;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

/**
 * Created by vladi.m
 * Date 11/11/2020
 * Time 9:52
 * Copyright Taboola
 */
public enum CtaType {
    DOWNLOAD,
    INSTALL_NOW,
    LEARN_MORE,
    SHOP_NOW,
    CLICK_HERE,
    SIGN_UP,
    PLAY_NOW,
    READ_MORE,
    GET_QUOTE,
    GET_OFFER,
    TRY_NOW,
    NONE,
    SEARCH_NOW,
    BOOK_NOW,
    CONTACT_US,
    WATCH_MORE,
    LISTEN_NOW,
    SUBSCRIBE,
    PLAY_GAME,
    DONATE_NOW,
    ORDER_NOW,
    JOIN_NOW,
    @JsonEnumDefaultValue UNSUPPORTED_BY_SDK_VALUE
}
