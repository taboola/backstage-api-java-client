package com.taboola.backstage.model.publishers.reports;

import java.util.Objects;

/**
 * Created by vladi
 * Date: 2/3/2018
 * Time: 10:46 PM
 * By Taboola
 */
public class VisitValueRow {

    private Integer visits;
    private Double bounceRate;
    private Integer viewsVisit;
    private Integer pageViews;
    private Double pageViewsWithAdsPct;
    private Double adRpm;
    private Double adVisitRpm;
    private Double adRevenue;
    private String currency;

    // dimension specific
    private String date;
    private String dateEndPeriod;
    private String referralDomain;
    private String landingPage;
    private String landingPageTitle;
    private String landingPageUrl;
    private String landingPageThumb;
    private String pageType;
    private String country;
    private String platform;
    private String trackingCodeSourceMedium;
    private String trackingCodeCampaign;
    private String trackingCodeCustom;
    private String referralTrackingCodes;

    public Integer getVisits() {
        return visits;
    }

    public void setVisits(Integer visits) {
        this.visits = visits;
    }

    public Double getBounceRate() {
        return bounceRate;
    }

    public void setBounceRate(Double bounceRate) {
        this.bounceRate = bounceRate;
    }

    public Integer getViewsVisit() {
        return viewsVisit;
    }

    public void setViewsVisit(Integer viewsVisit) {
        this.viewsVisit = viewsVisit;
    }

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

    public Double getAdRpm() {
        return adRpm;
    }

    public void setAdRpm(Double adRpm) {
        this.adRpm = adRpm;
    }

    public Double getAdVisitRpm() {
        return adVisitRpm;
    }

    public void setAdVisitRpm(Double adVisitRpm) {
        this.adVisitRpm = adVisitRpm;
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

    public String getReferralDomain() {
        return referralDomain;
    }

    public void setReferralDomain(String referralDomain) {
        this.referralDomain = referralDomain;
    }

    public String getLandingPage() {
        return landingPage;
    }

    public void setLandingPage(String landingPage) {
        this.landingPage = landingPage;
    }

    public String getLandingPageTitle() {
        return landingPageTitle;
    }

    public void setLandingPageTitle(String landingPageTitle) {
        this.landingPageTitle = landingPageTitle;
    }

    public String getLandingPageUrl() {
        return landingPageUrl;
    }

    public void setLandingPageUrl(String landingPageUrl) {
        this.landingPageUrl = landingPageUrl;
    }

    public String getLandingPageThumb() {
        return landingPageThumb;
    }

    public void setLandingPageThumb(String landingPageThumb) {
        this.landingPageThumb = landingPageThumb;
    }

    public String getPageType() {
        return pageType;
    }

    public void setPageType(String pageType) {
        this.pageType = pageType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getTrackingCodeSourceMedium() {
        return trackingCodeSourceMedium;
    }

    public void setTrackingCodeSourceMedium(String trackingCodeSourceMedium) {
        this.trackingCodeSourceMedium = trackingCodeSourceMedium;
    }

    public String getTrackingCodeCampaign() {
        return trackingCodeCampaign;
    }

    public void setTrackingCodeCampaign(String trackingCodeCampaign) {
        this.trackingCodeCampaign = trackingCodeCampaign;
    }

    public String getTrackingCodeCustom() {
        return trackingCodeCustom;
    }

    public void setTrackingCodeCustom(String trackingCodeCustom) {
        this.trackingCodeCustom = trackingCodeCustom;
    }

    public String getReferralTrackingCodes() {
        return referralTrackingCodes;
    }

    public void setReferralTrackingCodes(String referralTrackingCodes) {
        this.referralTrackingCodes = referralTrackingCodes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VisitValueRow that = (VisitValueRow) o;
        return Objects.equals(visits, that.visits) &&
        Objects.equals(bounceRate, that.bounceRate) &&
        Objects.equals(viewsVisit, that.viewsVisit) &&
        Objects.equals(pageViews, that.pageViews) &&
        Objects.equals(pageViewsWithAdsPct, that.pageViewsWithAdsPct) &&
        Objects.equals(adRpm, that.adRpm) &&
        Objects.equals(adVisitRpm, that.adVisitRpm) &&
        Objects.equals(adRevenue, that.adRevenue) &&
        Objects.equals(currency, that.currency) &&
        Objects.equals(date, that.date) &&
        Objects.equals(dateEndPeriod, that.dateEndPeriod) &&
        Objects.equals(referralDomain, that.referralDomain) &&
        Objects.equals(landingPage, that.landingPage) &&
        Objects.equals(landingPageTitle, that.landingPageTitle) &&
        Objects.equals(landingPageUrl, that.landingPageUrl) &&
        Objects.equals(landingPageThumb, that.landingPageThumb) &&
        Objects.equals(pageType, that.pageType) &&
        Objects.equals(country, that.country) &&
        Objects.equals(platform, that.platform) &&
        Objects.equals(trackingCodeSourceMedium, that.trackingCodeSourceMedium) &&
        Objects.equals(trackingCodeCampaign, that.trackingCodeCampaign) &&
        Objects.equals(trackingCodeCustom, that.trackingCodeCustom) &&
        Objects.equals(referralTrackingCodes, that.referralTrackingCodes);
    }

    @Override
    public int hashCode() {

        return Objects.hash(visits, bounceRate, viewsVisit, pageViews, pageViewsWithAdsPct, adRpm, adVisitRpm, adRevenue, currency, date, dateEndPeriod, referralDomain, landingPage, landingPageTitle, landingPageUrl, landingPageThumb, pageType, country, platform, trackingCodeSourceMedium, trackingCodeCampaign, trackingCodeCustom, referralTrackingCodes);
    }

    @Override
    public String toString() {
        return "VisitValueRow{" +
        "visits=" + visits +
        ", bounceRate=" + bounceRate +
        ", viewsVisit=" + viewsVisit +
        ", pageViews=" + pageViews +
        ", pageViewsWithAdsPct=" + pageViewsWithAdsPct +
        ", adRpm=" + adRpm +
        ", adVisitRpm=" + adVisitRpm +
        ", adRevenue=" + adRevenue +
        ", currency='" + currency + '\'' +
        ", date='" + date + '\'' +
        ", dateEndPeriod='" + dateEndPeriod + '\'' +
        ", referralDomain='" + referralDomain + '\'' +
        ", landingPage='" + landingPage + '\'' +
        ", landingPageTitle='" + landingPageTitle + '\'' +
        ", landingPageUrl='" + landingPageUrl + '\'' +
        ", landingPageThumb='" + landingPageThumb + '\'' +
        ", pageType='" + pageType + '\'' +
        ", country='" + country + '\'' +
        ", platform='" + platform + '\'' +
        ", trackingCodeSourceMedium='" + trackingCodeSourceMedium + '\'' +
        ", trackingCodeCampaign='" + trackingCodeCampaign + '\'' +
        ", trackingCodeCustom='" + trackingCodeCustom + '\'' +
        ", referralTrackingCodes='" + referralTrackingCodes + '\'' +
        '}';
    }
}
