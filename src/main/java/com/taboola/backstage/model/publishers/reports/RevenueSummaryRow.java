package com.taboola.backstage.model.publishers.reports;


import java.util.Objects;

/**
 * Created by vladi
 * Date: 2/3/2018
 * Time: 12:29 AM
 * By Taboola
 */
public class RevenueSummaryRow {

    private Integer pageViews;
    private Double pageViewsWithAdsPct;
    private Integer pageViewsWithAds;
    private Double ctr;
    private Integer clicks;
    private Double adCpc;
    private Double adRpm;
    private Double adRevenue;
    private String currency;

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

    public Double getPageViewsWithAdsPct() {
        return pageViewsWithAdsPct;
    }

    public void setPageViewsWithAdsPct(Double pageViewsWithAdsPct) {
        this.pageViewsWithAdsPct = pageViewsWithAdsPct;
    }

    public Integer getPageViewsWithAds() {
        return pageViewsWithAds;
    }

    public void setPageViewsWithAds(Integer pageViewsWithAds) {
        this.pageViewsWithAds = pageViewsWithAds;
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

    public Double getAdCpc() {
        return adCpc;
    }

    public void setAdCpc(Double adCpc) {
        this.adCpc = adCpc;
    }

    public Double getAdRpm() {
        return adRpm;
    }

    public void setAdRpm(Double adRpm) {
        this.adRpm = adRpm;
    }

    public Double getAdRevenue() {
        return adRevenue;
    }

    public void setAdRevenue(Double adRevenue) {
        this.adRevenue = adRevenue;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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
        RevenueSummaryRow that = (RevenueSummaryRow) o;
        return Objects.equals(pageViews, that.pageViews) &&
        Objects.equals(pageViewsWithAdsPct, that.pageViewsWithAdsPct) &&
        Objects.equals(pageViewsWithAds, that.pageViewsWithAds) &&
        Objects.equals(ctr, that.ctr) &&
        Objects.equals(clicks, that.clicks) &&
        Objects.equals(adCpc, that.adCpc) &&
        Objects.equals(adRpm, that.adRpm) &&
        Objects.equals(adRevenue, that.adRevenue) &&
        Objects.equals(currency, that.currency) &&
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
        return Objects.hash(pageViews, pageViewsWithAdsPct, pageViewsWithAds, ctr, clicks, adCpc, adRpm, adRevenue, currency, date, dateEndPeriod, pateType, placement, publisher, publisherName, country, countryName, platform, platformName);
    }

    @Override
    public String toString() {
        return "RevenueSummaryRow{" +
        "pageViews=" + pageViews +
        ", pageViewsWithAdsPct=" + pageViewsWithAdsPct +
        ", pageViewsWithAds=" + pageViewsWithAds +
        ", ctr=" + ctr +
        ", clicks=" + clicks +
        ", adCpc=" + adCpc +
        ", adRpm=" + adRpm +
        ", adRevenue=" + adRevenue +
        ", currency='" + currency + '\'' +
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
