package com.taboola.backstage.internal.config;

/**
 * Created by vladi
 * Date: 1/16/2018
 * Time: 9:40 PM
 * By Taboola
 */
public class CommunicationConfig {

    private String backstageBaseUrl;
    private long connectionTimeoutMillis;
    private long readTimeoutMillis;
    private long writeTimeoutMillis;
    private String userAgent;

    public CommunicationConfig(String backstageBaseUrl, Long connectionTimeoutMillis, Long readTimeoutMillis, Long writeTimeoutMillis, String userAgent) {
        this.backstageBaseUrl = backstageBaseUrl;
        this.connectionTimeoutMillis = connectionTimeoutMillis;
        this.readTimeoutMillis = readTimeoutMillis;
        this.writeTimeoutMillis = writeTimeoutMillis;
        this.userAgent = userAgent;
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

    @Override
    public String toString() {
        return "CommunicationConfig{" +
        "backstageBaseUrl='" + backstageBaseUrl + '\'' +
        ", connectionTimeoutMillis=" + connectionTimeoutMillis +
        ", readTimeoutMillis=" + readTimeoutMillis +
        ", writeTimeoutMillis=" + writeTimeoutMillis +
        ", userAgent='" + userAgent + '\'' +
        '}';
    }
}
