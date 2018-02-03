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

    public RevenueSummaryRow setPageViews(Integer pageViews) {
        this.pageViews = pageViews;
        return this;
    }

    public Double getPageViewsWithAdsPct() {
        return pageViewsWithAdsPct;
    }

    public RevenueSummaryRow setPageViewsWithAdsPct(Double pageViewsWithAdsPct) {
        this.pageViewsWithAdsPct = pageViewsWithAdsPct;
        return this;
    }

    public Integer getPageViewsWithAds() {
        return pageViewsWithAds;
    }

    public RevenueSummaryRow setPageViewsWithAds(Integer pageViewsWithAds) {
        this.pageViewsWithAds = pageViewsWithAds;
        return this;
    }

    public Double getCtr() {
        return ctr;
    }

    public RevenueSummaryRow setCtr(Double ctr) {
        this.ctr = ctr;
        return this;
    }

    public Integer getClicks() {
        return clicks;
    }

    public RevenueSummaryRow setClicks(Integer clicks) {
        this.clicks = clicks;
        return this;
    }

    public Double getAdCpc() {
        return adCpc;
    }

    public RevenueSummaryRow setAdCpc(Double adCpc) {
        this.adCpc = adCpc;
        return this;
    }

    public Double getAdRpm() {
        return adRpm;
    }

    public RevenueSummaryRow setAdRpm(Double adRpm) {
        this.adRpm = adRpm;
        return this;
    }

    public Double getAdRevenue() {
        return adRevenue;
    }

    public RevenueSummaryRow setAdRevenue(Double adRevenue) {
        this.adRevenue = adRevenue;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public RevenueSummaryRow setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public String getDate() {
        return date;
    }

    public RevenueSummaryRow setDate(String date) {
        this.date = date;
        return this;
    }

    public String getDateEndPeriod() {
        return dateEndPeriod;
    }

    public RevenueSummaryRow setDateEndPeriod(String dateEndPeriod) {
        this.dateEndPeriod = dateEndPeriod;
        return this;
    }

    public String getPateType() {
        return pateType;
    }

    public RevenueSummaryRow setPateType(String pateType) {
        this.pateType = pateType;
        return this;
    }

    public String getPlacement() {
        return placement;
    }

    public RevenueSummaryRow setPlacement(String placement) {
        this.placement = placement;
        return this;
    }

    public String getPublisher() {
        return publisher;
    }

    public RevenueSummaryRow setPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public RevenueSummaryRow setPublisherName(String publisherName) {
        this.publisherName = publisherName;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public RevenueSummaryRow setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getCountryName() {
        return countryName;
    }

    public RevenueSummaryRow setCountryName(String countryName) {
        this.countryName = countryName;
        return this;
    }

    public String getPlatform() {
        return platform;
    }

    public RevenueSummaryRow setPlatform(String platform) {
        this.platform = platform;
        return this;
    }

    public String getPlatformName() {
        return platformName;
    }

    public RevenueSummaryRow setPlatformName(String platformName) {
        this.platformName = platformName;
        return this;
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
