package com.taboola.backstage.model.media.campaigns.items;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

/**
 * <p>
 *    There are two possible types of items:
 *    <br>⚫ ITEM - A simple Item, referencing a specific URL of a web page (e.g. link to an article).
 *    <br>⚫ RSS - An item with a URL referencing an RSS feed (we support mRSS format). This Item will have Children Items - an Item for each URL in its feed.
 * </p>
 *
 * Created by vladi
 * Date: 1/15/2018
 * Time: 10:03 PM
 * By Taboola
 */
public enum ItemType {
    ITEM,
    RSS,
    @JsonEnumDefaultValue UNSUPPORTED_BY_SDK_VALUE
}
