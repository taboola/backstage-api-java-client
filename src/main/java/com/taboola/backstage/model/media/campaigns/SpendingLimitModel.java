package com.taboola.backstage.model.media.campaigns;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

/**
 * <p>
 *    Generally speaking, Campaigns have two possible "Spending Models":
 *    <br> ● Entire​Budget​- The spending_limit field of the Campaign represents the entire
 *    amount of money this Campaign can consume. This means that once it depletes this
 *    budget, the Campaign will stop running, and its status will be DEPLETED.
 *    <br> ● Monthly​Budget​- The spending_limit field of the Campaign represents the amount of
 *    money this Campaign can consume each month. This means that once a Campaign
 *    depletes its budget, the Campaign will stop running, and its status will be
 *    MONTHLY_DEPLETED. Once a new month begins, the Campaign's budget will replenish
 *    and the Campaign will start running again.
 *    <br>
 *    <br> The Spending Model type of a certain Campaign is determined by setting the value of its
 *    spending_limit_model field. Setting the field to ENTIRE will set the Spending Model of the
 *    Campaign to "Entire Budget", while MONTHLY will set it to "Monthly Budget".
 * </p>
 *
 * Created by vladi
 * Date: 12/23/2017
 * Time: 10:36 PM
 * By Taboola
 */
public enum SpendingLimitModel {
    NONE,
    MONTHLY,
    ENTIRE,
    NONE,
    @JsonEnumDefaultValue UNSUPPORTED_BY_SDK_VALUE
}
