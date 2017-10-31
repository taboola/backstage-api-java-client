package com.taboola.backstage.exceptions;


/**
 * Created by vladi
 * Date: 10/30/2017
 * Time: 11:08 PM
 * By Taboola
 */
public class BackstageAPIConnectivityException extends BackstageAPIException {

    public BackstageAPIConnectivityException(String actionName) {
        super("Failed to perform API call [%s], might be due to internet connectivity issues", actionName);
    }

    public BackstageAPIConnectivityException(String actionName, int responseCode) {
        super("Failed to perform API call [%s] with response code [%d], might be due to internet connectivity issues", actionName, responseCode);
    }
}
