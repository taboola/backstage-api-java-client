package com.taboola.backstage.exceptions;


/**
 * Created by vladi
 * Date: 10/30/2017
 * Time: 11:08 PM
 * By Taboola
 */
public class BackstageAPIConnectivityException extends BackstageAPIException {

    public BackstageAPIConnectivityException() {
        super("Failed to perform API call, might be due to internet connectivity issues");
    }

    public BackstageAPIConnectivityException(int responseCode) {
        super("Failed to perform API call with response code [%d], might be due to internet connectivity issues", responseCode);
    }
}
