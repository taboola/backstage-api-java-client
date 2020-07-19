package com.taboola.backstage.exceptions;

/**
 * Created by vladi
 * Date: 10/30/2017
 * Time: 10:51 PM
 * By Taboola
 */
public class BackstageAPIUnauthorizedException extends BackstageAPIException {

    private static final String ERROR_STR = "Unauthorized, expired token or invalid credentials";

    public BackstageAPIUnauthorizedException() {
        super(ERROR_STR);
    }

    public BackstageAPIUnauthorizedException(Throwable cause) {
        super(cause, ERROR_STR);
    }
}
