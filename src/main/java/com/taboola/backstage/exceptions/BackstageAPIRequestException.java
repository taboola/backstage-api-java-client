package com.taboola.backstage.exceptions;

import com.taboola.backstage.model.APIError;

/**
 * Created by vladi
 * Date: 10/30/2017
 * Time: 11:12 PM
 * By Taboola
 */
public class BackstageAPIRequestException extends BackstageAPIException {

    public BackstageAPIRequestException(APIError error, String message, Object... params) {
        super(error, message, params);
    }

    public BackstageAPIRequestException(APIError error, String message, Throwable t, Object... params) {
        super(error, message, t, params);
    }
}
