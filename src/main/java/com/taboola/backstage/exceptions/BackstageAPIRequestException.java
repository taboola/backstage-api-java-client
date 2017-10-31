package com.taboola.backstage.exceptions;

import com.taboola.backstage.model.APIError;

/**
 * Created by vladi
 * Date: 10/30/2017
 * Time: 11:12 PM
 * By Taboola
 */
public class BackstageAPIRequestException extends BackstageAPIException {

    public BackstageAPIRequestException(String actionName, int responseCode, APIError error) {
        super(error, "Failed to perform API call [%s] with response code [%d]", actionName, responseCode);
    }
}
