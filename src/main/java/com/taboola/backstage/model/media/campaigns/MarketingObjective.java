package com.taboola.backstage.model.media.campaigns;

/**
 * <p>
 *    <br>⚫ BRAND_AWARENESS - Extent to which customers are able to recall or recognise a brand
 *    <br>⚫ LEADS_GENERATION - Marketing tactics aimed at finding potential customers with specific contact information
 *    <br>⚫ ONLINE_PURCHASES - Online product selling
 *    <br>⚫ DRIVE_WEBSITE_TRAFFIC - The amount of data sent and received by visitors to a website
 *    <br>⚫ MOBILE_APP_INSTALL - Install app on mobile
 *    <br>⚫ OTHER - Other object
 *    <br>⚫ NONE - No marketing objective
 * </p>
 *
 * Created by vladi.m
 * Date 03/10/2018
 * Time 12:06
 * Copyright Taboola
 */
public enum MarketingObjective {
    BRAND_AWARENESS,
    LEADS_GENERATION,
    ONLINE_PURCHASES,
    DRIVE_WEBSITE_TRAFFIC,
    MOBILE_APP_INSTALL,
    OTHER,
    @Deprecated NONE
}
