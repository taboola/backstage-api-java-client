package com.taboola.backstage.exceptions;


/**
 * Created by vladi
 * Date: 10/30/2017
 * Time: 11:08 PM
 * By Taboola
 */
public class BackstageAPIConnectivityException extends BackstageAPIException {


    public BackstageAPIConnectivityException(String message, Object... params) {
        super(message, params);
    }
}
