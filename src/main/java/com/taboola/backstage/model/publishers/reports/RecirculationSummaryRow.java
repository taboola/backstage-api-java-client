package com.taboola.backstage.model.publishers.reports;

import java.util.Objects;

/**
 * Created by vladi
 * Date: 2/3/2018
 * Time: 10:50 PM
 * By Taboola
 */
public class RecirculationSummaryRow {

    private Integer pageViews;
    private Double ctr;
    private Integer clicks;
    private Double averageViewsAfterClick;

    // dimension specific
    private String date;
    private String dateEndPeriod;
    private String pateType;
    private String placement;
    private String publisher;
    private String publisherName;
    private String country;
    private String countryName;
    private String platform;
    private String platformName;

    public Integer getPageViews() {
        return pageViews;
    }

    public void setPageViews(Integer pageViews) {
        this.pageViews = pageViews;
    }

    public Double getCtr() {
        return ctr;
    }

    public void setCtr(Double ctr) {
        this.ctr = ctr;
    }

    public Integer getClicks() {
        return clicks;
    }

    public void setClicks(Integer clicks) {
        this.clicks = clicks;
    }

    public Double getAverageViewsAfterClick() {
        return averageViewsAfterClick;
    }

    public void setAverageViewsAfterClick(Double averageViewsAfterClick) {
        this.averageViewsAfterClick = averageViewsAfterClick;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDateEndPeriod() {
        return dateEndPeriod;
    }

    public void setDateEndPeriod(String dateEndPeriod) {
        this.dateEndPeriod = dateEndPeriod;
    }

    public String getPateType() {
        return pateType;
    }

    public void setPateType(String pateType) {
        this.pateType = pateType;
    }

    public String getPlacement() {
        return placement;
    }

    public void setPlacement(String placement) {
        this.placement = placement;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecirculationSummaryRow that = (RecirculationSummaryRow) o;
        return Objects.equals(pageViews, that.pageViews) &&
        Objects.equals(ctr, that.ctr) &&
        Objects.equals(clicks, that.clicks) &&
        Objects.equals(averageViewsAfterClick, that.averageViewsAfterClick) &&
        Objects.equals(date, that.date) &&
        Objects.equals(dateEndPeriod, that.dateEndPeriod) &&
        Objects.equals(pateType, that.pateType) &&
        Objects.equals(placement, that.placement) &&
        Objects.equals(publisher, that.publisher) &&
        Objects.equals(publisherName, that.publisherName) &&
        Objects.equals(country, that.country) &&
        Objects.equals(countryName, that.countryName) &&
        Objects.equals(platform, that.platform) &&
        Objects.equals(platformName, that.platformName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(pageViews, ctr, clicks, averageViewsAfterClick, date, dateEndPeriod, pateType, placement, publisher, publisherName, country, countryName, platform, platformName);
    }

    @Override
    public String toString() {
        return "RecirculationSummaryRow{" +
        "pageViews=" + pageViews +
        ", ctr=" + ctr +
        ", clicks=" + clicks +
        ", averageViewsAfterClick=" + averageViewsAfterClick +
        ", date='" + date + '\'' +
        ", dateEndPeriod='" + dateEndPeriod + '\'' +
        ", pateType='" + pateType + '\'' +
        ", placement='" + placement + '\'' +
        ", publisher='" + publisher + '\'' +
        ", publisherName='" + publisherName + '\'' +
        ", country='" + country + '\'' +
        ", countryName='" + countryName + '\'' +
        ", platform='" + platform + '\'' +
        ", platformName='" + platformName + '\'' +
        '}';
    }
}
