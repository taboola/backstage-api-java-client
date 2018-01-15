package com.taboola.backstage.model.media.campaigns.targeting;

/**
 * <p>
 *    <br>⚫ INCLUDE - Only supplied values should be included in Targeting
 *    <br>⚫ EXCLUDE - All values should be Targeted other than the supplied values.
 *    <br>⚫ ALL - No restrictions - target all options.
 * </p>
 *
 * Created by vladi
 * Date: 1/15/2018
 * Time: 11:54 PM
 * By Taboola
 */
public enum Type {
    INCLUDE,
    EXCLUDE,
    ALL
}
