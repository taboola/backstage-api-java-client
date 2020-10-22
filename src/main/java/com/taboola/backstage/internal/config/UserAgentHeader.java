package com.taboola.backstage.internal.config;

import com.taboola.backstage.model.RequestHeader;

/**
 * Created on 10/21/20.
 */
public class UserAgentHeader implements RequestHeader {
    private static final String USER_AGENT_HEADER_NAME = "User-Agent";
    private final String userAgent;

    public UserAgentHeader(String userAgent) {
        this.userAgent = userAgent;
    }

    @Override
    public String getName() {
        return USER_AGENT_HEADER_NAME;
    }

    @Override
    public String getValue() {
        return userAgent;
    }

    @Override
    public String toString() {
        return "UserAgentHeader{" +
                "userAgent='" + userAgent + '\'' +
                '}';
    }
}
