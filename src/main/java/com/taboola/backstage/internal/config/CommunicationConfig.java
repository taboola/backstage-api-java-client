package com.taboola.backstage.internal.config;

/**
 * Created by vladi
 * Date: 1/16/2018
 * Time: 9:40 PM
 * By Taboola
 */
public class CommunicationConfig {

    private final String backstageBaseUrl;
    private final String authenticationBaseUrl;
    private final long connectionTimeoutMillis;
    private final long readTimeoutMillis;
    private final long writeTimeoutMillis;
    private final int maxIdleConnections;
    private final long keepAliveDurationSec;
    private final String userAgent;
    private final boolean debug;

    public CommunicationConfig(String backstageBaseUrl, String authenticationBaseUrl, Long connectionTimeoutMillis, Long readTimeoutMillis,
                               Long writeTimeoutMillis, Integer maxIdleConnections, Long keepAliveDurationSec, String userAgent, boolean debug) {
        this.backstageBaseUrl = backstageBaseUrl;
        this.authenticationBaseUrl = authenticationBaseUrl;
        this.connectionTimeoutMillis = connectionTimeoutMillis;
        this.readTimeoutMillis = readTimeoutMillis;
        this.writeTimeoutMillis = writeTimeoutMillis;
        this.maxIdleConnections = maxIdleConnections;
        this.keepAliveDurationSec = keepAliveDurationSec;
        this.userAgent = userAgent;
        this.debug = debug;
    }

    public String getBackstageBaseUrl() {
        return backstageBaseUrl;
    }

    public String getAuthenticationBaseUrl() {
        return authenticationBaseUrl;
    }

    public long getConnectionTimeoutMillis() {
        return connectionTimeoutMillis;
    }

    public long getReadTimeoutMillis() {
        return readTimeoutMillis;
    }

    public long getWriteTimeoutMillis() {
        return writeTimeoutMillis;
    }

    public int getMaxIdleConnections() {
        return maxIdleConnections;
    }

    public long getKeepAliveDurationSec() {
        return keepAliveDurationSec;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public boolean isDebug() {
        return debug;
    }

    @Override
    public String toString() {
        return "CommunicationConfig{" +
        "backstageBaseUrl='" + backstageBaseUrl + '\'' +
        ", authenticationBaseUrl='" + authenticationBaseUrl + '\'' +
        ", connectionTimeoutMillis=" + connectionTimeoutMillis +
        ", readTimeoutMillis=" + readTimeoutMillis +
        ", writeTimeoutMillis=" + writeTimeoutMillis +
        ", maxIdleConnections=" + maxIdleConnections +
        ", keepAliveDurationSec=" + keepAliveDurationSec +
        ", userAgent='" + userAgent + '\'' +
        ", debug=" + debug +
        '}';
    }
}
