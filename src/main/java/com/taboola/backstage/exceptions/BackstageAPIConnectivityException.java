package com.taboola.backstage.exceptions;


/**
 * Created by vladi
 * Date: 10/30/2017
 * Time: 11:08 PM
 * By Taboola
 */
public class BackstageAPIConnectivityException extends BackstageAPIException {

    private static final String ERROR_STR = "Failed to perform API call, might be due to internet connectivity issues";
    private static final String ERROR_STR_WITH_RESPONSE_CODE = "Failed to perform API call with response code [%d], might be due to internet connectivity issues";

    public BackstageAPIConnectivityException() {
        super(ERROR_STR);
    }

    public BackstageAPIConnectivityException(Throwable cause) {
        super(cause, ERROR_STR);
    }

    public BackstageAPIConnectivityException(int responseCode) {
        super(ERROR_STR_WITH_RESPONSE_CODE, responseCode);
    }

    public BackstageAPIConnectivityException(Throwable cause, int responseCode) {
        super(cause, ERROR_STR_WITH_RESPONSE_CODE, responseCode);
    }
}
