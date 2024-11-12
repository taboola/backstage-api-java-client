package com.taboola.backstage.model.media.reports;

import com.taboola.backstage.model.dynamic.DynamicFields;
import com.taboola.backstage.model.dynamic.DynamicRow;

import java.util.Objects;

/**
 * Created by vladi
 * Date: 12/7/2017
 * Time: 10:10 PM
 * By Taboola
 */
public class CampaignSummaryRow implements DynamicRow {

    private Integer impressions;
    private Integer visibleImpressions;
    private Double conversionsValue;
    private Double ctr;
    private Double vctr;
    private Integer clicks;
    private Double cpc;
    private Double cpm;
    private Double vcpm;
    private Double cpa;
    private Double cpaClicks;
    private Double cpaViews;
    private Double cpaConversionRate;
    private Double cpaConversionRateClicks;
    private Double cpaConversionRateViews;
    private Integer cpaActionsNum;
    private Integer cpaActionsNumFromClicks;
    private Integer cpaActionsNumFromViews;
    private Double spent;
    private String currency;

    // dimension specific
    private String date;
    private String dateEndPeriod;
    private String hourOfDay;
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
    private String region;
    private String dma;
    private String platform;
    private String platformName;
    private String osFamily;
    private String osVersion;
    private String browser;
    private BlockingLevelType blockingLevel;
    private Double roas;
    private String partnerName;
    private String audienceName;
    private String dataPartnerAudienceId;
    private String impressionsPct;

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

    public String getOsFamily() {
        return osFamily;
    }

    public CampaignSummaryRow setOsFamily(String osFamily) {
        this.osFamily = osFamily;
        return this;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public CampaignSummaryRow setOsVersion(String osVersion) {
        this.osVersion = osVersion;
        return this;
    }

    public String getBrowser() {
        return browser;
    }

    public CampaignSummaryRow setBrowser(String browser) {
        this.browser = browser;
        return this;
    }

    public BlockingLevelType getBlockingLevel() {
        return blockingLevel;
    }

    public void setBlockingLevel(BlockingLevelType blockingLevel) {
        this.blockingLevel = blockingLevel;
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

    public String getPartnerName() {
        return partnerName;
    }

    public CampaignSummaryRow setPartnerName(String partnerName) {
        this.partnerName = partnerName;
        return this;
    }

    public String getAudienceName() {
        return audienceName;
    }

    public CampaignSummaryRow setAudienceName(String audienceName) {
        this.audienceName = audienceName;
        return this;
    }

    public String getDataPartnerAudienceId() {
        return dataPartnerAudienceId;
    }

    public CampaignSummaryRow setDataPartnerAudienceId(String dataPartnerAudienceId) {
        this.dataPartnerAudienceId = dataPartnerAudienceId;
        return this;
    }

    public Integer getVisibleImpressions() {
        return visibleImpressions;
    }

    public CampaignSummaryRow setVisibleImpressions(Integer visibleImpressions) {
        this.visibleImpressions = visibleImpressions;
        return this;
    }

    public Double getConversionsValue() {
        return conversionsValue;
    }

    public CampaignSummaryRow setConversionsValue(Double conversionsValue) {
        this.conversionsValue = conversionsValue;
        return this;
    }

    public Double getVctr() {
        return vctr;
    }

    public CampaignSummaryRow setVctr(Double vctr) {
        this.vctr = vctr;
        return this;
    }

    public Double getVcpm() {
        return vcpm;
    }

    public CampaignSummaryRow setVcpm(Double vcpm) {
        this.vcpm = vcpm;
        return this;
    }

    public Double getCpa() {
        return cpa;
    }

    public CampaignSummaryRow setCpa(Double cpa) {
        this.cpa = cpa;
        return this;
    }

    public Double getCpaClicks() {
        return cpaClicks;
    }

    public CampaignSummaryRow setCpaClicks(Double cpaClicks) {
        this.cpaClicks = cpaClicks;
        return this;
    }

    public Double getCpaViews() {
        return cpaViews;
    }

    public CampaignSummaryRow setCpaViews(Double cpaViews) {
        this.cpaViews = cpaViews;
        return this;
    }

    public Double getCpaConversionRateClicks() {
        return cpaConversionRateClicks;
    }

    public CampaignSummaryRow setCpaConversionRateClicks(Double cpaConversionRateClicks) {
        this.cpaConversionRateClicks = cpaConversionRateClicks;
        return this;
    }

    public Double getCpaConversionRateViews() {
        return cpaConversionRateViews;
    }

    public CampaignSummaryRow setCpaConversionRateViews(Double cpaConversionRateViews) {
        this.cpaConversionRateViews = cpaConversionRateViews;
        return this;
    }

    public Integer getCpaActionsNumFromClicks() {
        return cpaActionsNumFromClicks;
    }

    public CampaignSummaryRow setCpaActionsNumFromClicks(Integer cpaActionsNumFromClicks) {
        this.cpaActionsNumFromClicks = cpaActionsNumFromClicks;
        return this;
    }

    public Integer getCpaActionsNumFromViews() {
        return cpaActionsNumFromViews;
    }

    public CampaignSummaryRow setCpaActionsNumFromViews(Integer cpaActionsNumFromViews) {
        this.cpaActionsNumFromViews = cpaActionsNumFromViews;
        return this;
    }

    public String getHourOfDay() {
        return hourOfDay;
    }

    public CampaignSummaryRow setHourOfDay(String hourOfDay) {
        this.hourOfDay = hourOfDay;
        return this;
    }

    public String getRegion() {
        return region;
    }

    public CampaignSummaryRow setRegion(String region) {
        this.region = region;
        return this;
    }

    public String getDma() {
        return dma;
    }

    public CampaignSummaryRow setDma(String dma) {
        this.dma = dma;
        return this;
    }

    public String getImpressionsPct() {
        return impressionsPct;
    }

    public CampaignSummaryRow setImpressionsPct(String impressionsPct) {
        this.impressionsPct = impressionsPct;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CampaignSummaryRow that = (CampaignSummaryRow) o;
        return Objects.equals(impressions, that.impressions) &&
                Objects.equals(visibleImpressions, that.visibleImpressions) &&
                Objects.equals(conversionsValue, that.conversionsValue) &&
                Objects.equals(ctr, that.ctr) &&
                Objects.equals(vctr, that.vctr) &&
                Objects.equals(clicks, that.clicks) &&
                Objects.equals(cpc, that.cpc) &&
                Objects.equals(cpm, that.cpm) &&
                Objects.equals(vcpm, that.vcpm) &&
                Objects.equals(cpa, that.cpa) &&
                Objects.equals(cpaClicks, that.cpaClicks) &&
                Objects.equals(cpaViews, that.cpaViews) &&
                Objects.equals(cpaConversionRate, that.cpaConversionRate) &&
                Objects.equals(cpaConversionRateClicks, that.cpaConversionRateClicks) &&
                Objects.equals(cpaConversionRateViews, that.cpaConversionRateViews) &&
                Objects.equals(cpaActionsNum, that.cpaActionsNum) &&
                Objects.equals(cpaActionsNumFromClicks, that.cpaActionsNumFromClicks) &&
                Objects.equals(cpaActionsNumFromViews, that.cpaActionsNumFromViews) &&
                Objects.equals(spent, that.spent) &&
                Objects.equals(currency, that.currency) &&
                Objects.equals(date, that.date) &&
                Objects.equals(dateEndPeriod, that.dateEndPeriod) &&
                Objects.equals(hourOfDay, that.hourOfDay) &&
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
                Objects.equals(region, that.region) &&
                Objects.equals(dma, that.dma) &&
                Objects.equals(platform, that.platform) &&
                Objects.equals(platformName, that.platformName) &&
                Objects.equals(osFamily, that.osFamily) &&
                Objects.equals(osVersion, that.osVersion) &&
                Objects.equals(browser, that.browser) &&
                blockingLevel == that.blockingLevel &&
                Objects.equals(roas, that.roas) &&
                Objects.equals(partnerName, that.partnerName) &&
                Objects.equals(audienceName, that.audienceName) &&
                Objects.equals(dataPartnerAudienceId, that.dataPartnerAudienceId) &&
                Objects.equals(impressionsPct, that.impressionsPct) &&
                Objects.equals(dynamicFields, that.dynamicFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(impressions, visibleImpressions, conversionsValue, ctr, vctr, clicks, cpc, cpm, vcpm, cpa,
                cpaClicks, cpaViews, cpaConversionRate, cpaConversionRateClicks, cpaConversionRateViews, cpaActionsNum,
                cpaActionsNumFromClicks, cpaActionsNumFromViews, spent, currency, date, dateEndPeriod, hourOfDay,
                contentProvider, contentProviderName, campaignsNum, campaign, campaignName, site, siteName, siteId,
                country, countryName, region, dma, platform, platformName, osFamily, blockingLevel, roas, partnerName,
                audienceName, dataPartnerAudienceId, impressionsPct, dynamicFields, browser, osVersion);
    }

    @Override
    public String toString() {
        return "CampaignSummaryRow{" +
                "impressions=" + impressions +
                ", visibleImpressions=" + visibleImpressions +
                ", conversionsValue=" + conversionsValue +
                ", ctr=" + ctr +
                ", vctr=" + vctr +
                ", clicks=" + clicks +
                ", cpc=" + cpc +
                ", cpm=" + cpm +
                ", vcpm=" + vcpm +
                ", cpa=" + cpa +
                ", cpaClicks=" + cpaClicks +
                ", cpaViews=" + cpaViews +
                ", cpaConversionRate=" + cpaConversionRate +
                ", cpaConversionRateClicks=" + cpaConversionRateClicks +
                ", cpaConversionRateViews=" + cpaConversionRateViews +
                ", cpaActionsNum=" + cpaActionsNum +
                ", cpaActionsNumFromClicks=" + cpaActionsNumFromClicks +
                ", cpaActionsNumFromViews=" + cpaActionsNumFromViews +
                ", spent=" + spent +
                ", currency='" + currency + '\'' +
                ", date='" + date + '\'' +
                ", dateEndPeriod='" + dateEndPeriod + '\'' +
                ", hourOfDay='" + hourOfDay + '\'' +
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
                ", region='" + region + '\'' +
                ", dma='" + dma + '\'' +
                ", platform='" + platform + '\'' +
                ", platformName='" + platformName + '\'' +
                ", osFamily='" + osFamily + '\'' +
                ", osVersion='" + osVersion + '\'' +
                ", browser='" + browser + '\'' +
                ", blockingLevel=" + blockingLevel +
                ", roas=" + roas +
                ", partnerName='" + partnerName + '\'' +
                ", audienceName='" + audienceName + '\'' +
                ", dataPartnerAudienceId='" + dataPartnerAudienceId + '\'' +
                ", impressionsPct='" + impressionsPct + '\'' +
                ", dynamicFields=" + dynamicFields +
                '}';
    }
}
