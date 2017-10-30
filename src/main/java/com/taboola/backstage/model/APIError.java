package com.taboola.backstage.model;

/**
 * Created by vladi
 * Date: 10/12/2017
 * Time: 10:03 PM
 * By Taboola
 */
public class APIError {

    public static final APIError EMPTY = new APIError();

    private int statusCode;
    private String message;

    public APIError() {
        //for jackson
    }

    public APIError(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
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
        "statusCode=" + statusCode +
        ", message='" + message + '\'' +
        '}';
    }
}
