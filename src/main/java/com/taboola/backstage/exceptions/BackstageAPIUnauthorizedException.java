package com.taboola.backstage.exceptions;

/**
 * Created by vladi
 * Date: 10/30/2017
 * Time: 10:51 PM
 * By Taboola
 */
public class BackstageAPIUnauthorizedException extends BackstageAPIException {

    public BackstageAPIUnauthorizedException() {
        super("Unauthorized, expired token or invalid credentials");
    }
}
