package com.taboola.backstage.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

/**
 * Created by vladi
 * Date: 9/12/2017
 * Time: 11:22 PM
 * By Taboola
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Report<T> {

    @JsonProperty("last-used-rawdata-update-time")
    private String lastUsedRawdataUpdateTime;
    @JsonProperty("last-used-rawdata-update-time-gmt-millisec")
    private Long lastUsedRawdataUpdateTimeGmtMillisec;
    private String timezone;
    private Collection<T> results;
    @JsonProperty("recordCount")
    private Integer recordCount;
    private ColumnsMetadata metadata;

    public String getLastUsedRawdataUpdateTime() {
        return lastUsedRawdataUpdateTime;
    }

    public void setLastUsedRawdataUpdateTime(String lastUsedRawdataUpdateTime) {
        this.lastUsedRawdataUpdateTime = lastUsedRawdataUpdateTime;
    }

    public Long getLastUsedRawdataUpdateTimeGmtMillisec() {
        return lastUsedRawdataUpdateTimeGmtMillisec;
    }

    public void setLastUsedRawdataUpdateTimeGmtMillisec(Long lastUsedRawdataUpdateTimeGmtMillisec) {
        this.lastUsedRawdataUpdateTimeGmtMillisec = lastUsedRawdataUpdateTimeGmtMillisec;
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

    public Integer getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(Integer recordCount) {
        this.recordCount = recordCount;
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
            ", lastUsedRawdataUpdateTimeGmtMillisec=" + lastUsedRawdataUpdateTimeGmtMillisec +
            ", timezone='" + timezone + '\'' +
            ", results=" + results +
            ", metadata=" + metadata +
            '}';
    }

}
