package com.taboola.backstage.model;

import java.util.Collection;

/**
 * Created by vladi
 * Date: 9/12/2017
 * Time: 11:22 PM
 * By Taboola
 */
public class Report<T> {

    private String lastUsedRawdataUpdateTime;
    private String timezone;
    private Collection<T> results;
    private ColumnsMetadata metadata;

    public String getLastUsedRawdataUpdateTime() {
        return lastUsedRawdataUpdateTime;
    }

    public void setLastUsedRawdataUpdateTime(String lastUsedRawdataUpdateTime) {
        this.lastUsedRawdataUpdateTime = lastUsedRawdataUpdateTime;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Collection<T> getResults() {
        return results;
    }

    public void setResults(Collection<T> results) {
        this.results = results;
    }

    public ColumnsMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(ColumnsMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public String toString() {
        return "Report{" +
                "lastUsedRawdataUpdateTime='" + lastUsedRawdataUpdateTime + '\'' +
                ", timezone='" + timezone + '\'' +
                ", results=" + results +
                ", metadata=" + metadata +
                '}';
    }
}
