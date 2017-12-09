package com.taboola.backstage.model;

/**
 * Created by vladi
 * Date: 10/12/2017
 * Time: 10:03 PM
 * By Taboola
 */
public class APIError {

    public static final APIError EMPTY = new APIError();

    private int httpStatus;
    private String message;

    public APIError() {
        //for jackson
    }

    public APIError(String message, int httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "APIError{" +
        "httpStatus=" + httpStatus +
        ", message='" + message + '\'' +
        '}';
    }
}
