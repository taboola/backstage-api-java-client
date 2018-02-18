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
    private final String userAgent;
    private final boolean debug;

    public CommunicationConfig(String backstageBaseUrl, String authenticationBaseUrl, Long connectionTimeoutMillis, Long readTimeoutMillis,
                               Long writeTimeoutMillis, String userAgent, boolean debug) {
        this.backstageBaseUrl = backstageBaseUrl;
        this.authenticationBaseUrl = authenticationBaseUrl;
        this.connectionTimeoutMillis = connectionTimeoutMillis;
        this.readTimeoutMillis = readTimeoutMillis;
        this.writeTimeoutMillis = writeTimeoutMillis;
        this.userAgent = userAgent;
        this.debug = debug;
    }

    public String getBackstageBaseUrl() {
        return backstageBaseUrl;
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

    public String getUserAgent() {
        return userAgent;
    }

    public boolean isDebug() {
        return debug;
    }

    public String getAuthenticationBaseUrl() {
        return authenticationBaseUrl;
    }

    @Override
    public String toString() {
        return "CommunicationConfig{" +
        "backstageBaseUrl='" + backstageBaseUrl + '\'' +
        ", authenticationBaseUrl='" + authenticationBaseUrl + '\'' +
        ", connectionTimeoutMillis=" + connectionTimeoutMillis +
        ", readTimeoutMillis=" + readTimeoutMillis +
        ", writeTimeoutMillis=" + writeTimeoutMillis +
        ", userAgent='" + userAgent + '\'' +
        ", debug=" + debug +
        '}';
    }
}
