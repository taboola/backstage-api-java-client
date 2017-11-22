package com.taboola.backstage.exceptions;

/**
 * Created by vladi
 * Date: 10/30/2017
 * Time: 10:51 PM
 * By Taboola
 */
public class BackstageAPITokenExpiredException extends BackstageAPIException {

    public BackstageAPITokenExpiredException() {
        super("Token is expired");
    }
}
