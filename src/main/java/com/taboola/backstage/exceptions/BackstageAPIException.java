package com.taboola.backstage.exceptions;

import com.taboola.backstage.model.APIError;

/**
 * Created by vladi
 * Date: 9/13/2017
 * Time: 12:23 AM
 * By Taboola
 */
public abstract class BackstageAPIException extends RuntimeException {

    private APIError error = APIError.EMPTY;

    public BackstageAPIException(String message, Object ... params) {
        super(String.format(message, params));
    }

    public BackstageAPIException(APIError error, String message, Object ... params) {
        super(String.format(message + parseError(error), params));
        this.error = error;
    }

    public BackstageAPIException(APIError error, String message, Throwable t, Object ... params) {
        super(String.format(message + parseError(error), params), t);
        this.error = error;
    }

    private static String parseError(APIError error) {
        if(error == null || APIError.EMPTY.equals(error)) {
            return "";
        }

        return String.format(". Response payload status [%s], message [%s]", error.getHttpStatus(), error.getMessage());
    }

    public APIError getError() {
        return error;
    }
}
