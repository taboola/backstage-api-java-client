package com.taboola.backstage.model.media.reports;

import java.util.Objects;

import com.taboola.backstage.model.dynamic.DynamicFields;
import com.taboola.backstage.model.dynamic.DynamicRow;

/**
 * Created by vladi
 * Date: 12/7/2017
 * Time: 10:10 PM
 * By Taboola
 */
public class CampaignSummaryRow implements DynamicRow {

    private Integer impressions;
    private Double ctr;
    private Integer clicks;
    private Double cpc;
    private Double cpm;
    private Double cpaConversionRate;
    private Integer cpaActionsNum;
    private Double spent;
    private String currency;

    // dimension specific
    private String date;
    private String dateEndPeriod;
    private String contentProvider;
    private String contentProviderName;
    private Long campaignsNum;
    private Long campaign;
    private String campaignName;
    private String site;
    private String siteName;
    private Integer siteId;
    private String country;
    private String countryName;
    private String platform;
    private String platformName;
    private BlockingLevelType blockLevel;
    private Double roas;

    // dynamic
    private DynamicFields dynamicFields;

    public Integer getImpressions() {
        return impressions;
    }

    public CampaignSummaryRow setImpressions(Integer impressions) {
        this.impressions = impressions;
        return this;
    }

    public Double getCtr() {
        return ctr;
    }

    public CampaignSummaryRow setCtr(Double ctr) {
        this.ctr = ctr;
        return this;
    }

    public Integer getClicks() {
        return clicks;
    }

    public CampaignSummaryRow setClicks(Integer clicks) {
        this.clicks = clicks;
        return this;
    }

    public Double getCpc() {
        return cpc;
    }

    public CampaignSummaryRow setCpc(Double cpc) {
        this.cpc = cpc;
        return this;
    }

    public Double getCpm() {
        return cpm;
    }

    public CampaignSummaryRow setCpm(Double cpm) {
        this.cpm = cpm;
        return this;
    }

    public Double getCpaConversionRate() {
        return cpaConversionRate;
    }

    public CampaignSummaryRow setCpaConversionRate(Double cpaConversionRate) {
        this.cpaConversionRate = cpaConversionRate;
        return this;
    }

    public Integer getCpaActionsNum() {
        return cpaActionsNum;
    }

    public CampaignSummaryRow setCpaActionsNum(Integer cpaActionsNum) {
        this.cpaActionsNum = cpaActionsNum;
        return this;
    }

    public Double getSpent() {
        return spent;
    }

    public CampaignSummaryRow setSpent(Double spent) {
        this.spent = spent;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public CampaignSummaryRow setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public String getDate() {
        return date;
    }

    public CampaignSummaryRow setDate(String date) {
        this.date = date;
        return this;
    }

    public String getDateEndPeriod() {
        return dateEndPeriod;
    }

    public CampaignSummaryRow setDateEndPeriod(String dateEndPeriod) {
        this.dateEndPeriod = dateEndPeriod;
        return this;
    }

    public String getContentProvider() {
        return contentProvider;
    }

    public CampaignSummaryRow setContentProvider(String contentProvider) {
        this.contentProvider = contentProvider;
        return this;
    }

    public String getContentProviderName() {
        return contentProviderName;
    }

    public CampaignSummaryRow setContentProviderName(String contentProviderName) {
        this.contentProviderName = contentProviderName;
        return this;
    }

    public Long getCampaignsNum() {
        return campaignsNum;
    }

    public CampaignSummaryRow setCampaignsNum(Long campaignsNum) {
        this.campaignsNum = campaignsNum;
        return this;
    }

    public Long getCampaign() {
        return campaign;
    }

    public CampaignSummaryRow setCampaign(Long campaign) {
        this.campaign = campaign;
        return this;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public CampaignSummaryRow setCampaignName(String campaignName) {
        this.campaignName = campaignName;
        return this;
    }

    public String getSite() {
        return site;
    }

    public CampaignSummaryRow setSite(String site) {
        this.site = site;
        return this;
    }

    public String getSiteName() {
        return siteName;
    }

    public CampaignSummaryRow setSiteName(String siteName) {
        this.siteName = siteName;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public CampaignSummaryRow setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getCountryName() {
        return countryName;
    }

    public CampaignSummaryRow setCountryName(String countryName) {
        this.countryName = countryName;
        return this;
    }

    public String getPlatform() {
        return platform;
    }

    public CampaignSummaryRow setPlatform(String platform) {
        this.platform = platform;
        return this;
    }

    public String getPlatformName() {
        return platformName;
    }

    public CampaignSummaryRow setPlatformName(String platformName) {
        this.platformName = platformName;
        return this;
    }

    public BlockingLevelType getBlockLevel() {
        return blockLevel;
    }

    public CampaignSummaryRow setBlockLevel(BlockingLevelType blockLevel) {
        this.blockLevel = blockLevel;
        return this;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public CampaignSummaryRow setSiteId(Integer siteId) {
        this.siteId = siteId;
        return this;
    }

    public Double getRoas() {
        return roas;
    }

    public CampaignSummaryRow setRoas(Double roas) {
        this.roas = roas;
        return this;
    }

    public DynamicFields getDynamicFields() {
        return dynamicFields;
    }

    public CampaignSummaryRow setDynamicFields(DynamicFields dynamicFields) {
        this.dynamicFields = dynamicFields;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CampaignSummaryRow that = (CampaignSummaryRow) o;
        return Objects.equals(impressions, that.impressions) &&
                Objects.equals(ctr, that.ctr) &&
                Objects.equals(clicks, that.clicks) &&
                Objects.equals(cpc, that.cpc) &&
                Objects.equals(cpm, that.cpm) &&
                Objects.equals(cpaConversionRate, that.cpaConversionRate) &&
                Objects.equals(cpaActionsNum, that.cpaActionsNum) &&
                Objects.equals(spent, that.spent) &&
                Objects.equals(currency, that.currency) &&
                Objects.equals(date, that.date) &&
                Objects.equals(dateEndPeriod, that.dateEndPeriod) &&
                Objects.equals(contentProvider, that.contentProvider) &&
                Objects.equals(contentProviderName, that.contentProviderName) &&
                Objects.equals(campaignsNum, that.campaignsNum) &&
                Objects.equals(campaign, that.campaign) &&
                Objects.equals(campaignName, that.campaignName) &&
                Objects.equals(site, that.site) &&
                Objects.equals(siteName, that.siteName) &&
                Objects.equals(siteId, that.siteId) &&
                Objects.equals(country, that.country) &&
                Objects.equals(countryName, that.countryName) &&
                Objects.equals(platform, that.platform) &&
                Objects.equals(platformName, that.platformName) &&
                blockLevel == that.blockLevel &&
                Objects.equals(roas, that.roas) &&
                Objects.equals(dynamicFields, that.dynamicFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(impressions, ctr, clicks, cpc, cpm, cpaConversionRate, cpaActionsNum, spent,
                currency, date, dateEndPeriod, contentProvider, contentProviderName,
                campaignsNum, campaign, campaignName, site, siteName, siteId, country,
                countryName, platform, platformName, blockLevel, roas, dynamicFields);
    }

    @Override
    public String toString() {
        return "CampaignSummaryRow{" +
                "impressions=" + impressions +
                ", ctr=" + ctr +
                ", clicks=" + clicks +
                ", cpc=" + cpc +
                ", cpm=" + cpm +
                ", cpaConversionRate=" + cpaConversionRate +
                ", cpaActionsNum=" + cpaActionsNum +
                ", spent=" + spent +
                ", currency='" + currency + '\'' +
                ", date='" + date + '\'' +
                ", dateEndPeriod='" + dateEndPeriod + '\'' +
                ", contentProvider='" + contentProvider + '\'' +
                ", contentProviderName='" + contentProviderName + '\'' +
                ", campaignsNum=" + campaignsNum +
                ", campaign=" + campaign +
                ", campaignName='" + campaignName + '\'' +
                ", site='" + site + '\'' +
                ", siteName='" + siteName + '\'' +
                ", siteId=" + siteId +
                ", country='" + country + '\'' +
                ", countryName='" + countryName + '\'' +
                ", platform='" + platform + '\'' +
                ", platformName='" + platformName + '\'' +
                ", blockLevel=" + blockLevel +
                ", roas=" + roas +
                ", dynamicFields=" + dynamicFields +
                '}';
    }
}
