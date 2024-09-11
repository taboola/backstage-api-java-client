package com.taboola.backstage.model.media.campaigns;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.taboola.backstage.model.CampaignType;
import com.taboola.backstage.model.media.campaigns.brandsafety.ExternalBrandSafety;
import com.taboola.backstage.model.media.campaigns.scheduling.ActivitySchedule;
import com.taboola.backstage.model.media.campaigns.verifications.VerificationPixel;
import com.taboola.backstage.model.media.campaigns.viewability.ViewabilityTag;
import com.taboola.backstage.model.metadata.ExternalMetadata;
import com.taboola.rest.api.annotations.Final;
import com.taboola.rest.api.annotations.ReadOnly;
import com.taboola.rest.api.annotations.Required;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * Created by vladi
 * Date: 9/12/2017
 * Time: 11:22 PM
 * By Taboola
 */
public class Campaign {

    private static final String EXTENDED_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd";
    protected final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_TIME_FORMAT);
    private final SimpleDateFormat extendedDateFormat = new SimpleDateFormat(EXTENDED_DATE_TIME_FORMAT);
    @ReadOnly
    protected String id;
    @ReadOnly
    protected String advertiserId;
    @Required
    protected String name;
    @Required
    protected String brandingText;
    protected String trackingCode;
    protected Double cpc;
    protected Double dailyCap;
    protected DailyAdDeliveryModel dailyAdDeliveryModel;
    protected PublisherBidModifier publisherBidModifier;
    protected BidStrategyModifiers publisherBidStrategyModifiers;
    protected TrafficAllocationMode trafficAllocationMode;
    protected Double spendingLimit;
    @Required
    protected SpendingLimitModel spendingLimitModel;
    protected CampaignTargeting<String> countryTargeting;
    protected CampaignTargeting<String> dmaCountryTargeting;
    protected CampaignTargeting<String> regionCountryTargeting;
    protected CampaignTargeting<String> subCountryTargeting;
    protected CampaignTargeting<String> cityTargeting;
    protected CampaignTargeting<String> platformTargeting;
    protected CampaignTargeting<String> publisherTargeting;
    @ReadOnly
    protected CampaignTargeting<String> autoPublisherTargeting;
    protected CampaignTargeting<OperationSystem> osTargeting;
    protected CampaignTargeting<ConnectionType> connectionTypeTargeting;
    protected CampaignTargeting<String> contextualTargeting;
    protected CampaignTargeting<String> browserTargeting;
    @ReadOnly
    protected CampaignTargeting<String> postalCodeTargeting;
    @ReadOnly
    protected CampaignMultiTargeting<Long> audienceSegmentsMultiTargeting;
    @ReadOnly
    protected CampaignMultiTargeting<Long> customAudienceTargeting;
    @ReadOnly
    protected CampaignMultiTargeting<String> markingLabelMultiTargeting;
    @ReadOnly
    protected CampaignMultiTargeting<Long> contextualSegmentsTargeting;
    protected CampaignMultiTargeting<CampaignLookalikeAudienceTargeting> lookalikeAudienceTargeting;
    protected String comments;
    protected BidType bidType;
    @Required
    protected MarketingObjective marketingObjective;
    protected ActivitySchedule activitySchedule;
    @Final
    protected String startDate;
    protected String endDate;
    @ReadOnly
    protected String startDateInUtc;
    @ReadOnly
    protected String endDateInUtc;
    @ReadOnly
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    protected Date trafficAllocationAbTestEndDate;
    @ReadOnly
    protected CampaignApprovalState approvalState;
    protected Boolean isActive;
    @ReadOnly
    protected Double spent;
    @ReadOnly
    protected CampaignStatus status;
    protected Double cpaGoal;
    protected CampaignPricingModel pricingModel;
    protected ExternalBrandSafety externalBrandSafety;
    protected VerificationPixel verificationPixel;
    protected ViewabilityTag viewabilityTag;
    protected CampaignPolicyReview policyReview;
    protected CampaignLinkedGroups campaignGroups;
    @ReadOnly
    protected CampaignType type;
    @ReadOnly
    protected CampaignLearningState learningState;
    protected CampaignBidStrategy bidStrategy;
    protected ExternalMetadata externalMetadata;
    protected CampaignUnipRuleOptimizations conversionRules;
    protected AttributionConfig conversionConfiguration;
    protected String isSpendGuardActive;

    public String getId() {
        return id;
    }

    public String getAdvertiserId() {
        return advertiserId;
    }

    public String getName() {
        return name;
    }

    public String getBrandingText() {
        return brandingText;
    }

    public String getTrackingCode() {
        return trackingCode;
    }

    public Double getCpc() {
        return cpc;
    }

    public Double getDailyCap() {
        return dailyCap;
    }

    public DailyAdDeliveryModel getDailyAdDeliveryModel() {
        return dailyAdDeliveryModel;
    }

    public PublisherBidModifier getPublisherBidModifier() {
        return publisherBidModifier;
    }

    public Double getSpendingLimit() {
        return spendingLimit;
    }

    public SpendingLimitModel getSpendingLimitModel() {
        return spendingLimitModel;
    }

    public CampaignTargeting<String> getCountryTargeting() {
        return countryTargeting;
    }

    public CampaignTargeting<String> getSubCountryTargeting() {
        return subCountryTargeting;
    }

    public CampaignTargeting<String> getCityTargeting() {
        return cityTargeting;
    }

    public CampaignTargeting<String> getPlatformTargeting() {
        return platformTargeting;
    }

    public CampaignTargeting<String> getPublisherTargeting() {
        return publisherTargeting;
    }

    public CampaignTargeting<String> getPostalCodeTargeting() {
        return postalCodeTargeting;
    }

    public CampaignTargeting<String> getBrowserTargeting() {
        return browserTargeting;
    }

    public CampaignTargeting<OperationSystem> getOsTargeting() {
        return osTargeting;
    }

    public String getComments() {
        return comments;
    }

    public Date getStartDate() {
        if (startDate != null) {
            try {
                return dateFormat.parse(startDate);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    @JsonIgnore
    public String getStartDateStr() {
        return startDate;
    }

    public Date getEndDate() {
        if (endDate != null) {
            try {
                return dateFormat.parse(endDate);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    @JsonIgnore
    public String getEndDateStr() {
        return endDate;
    }

    public CampaignApprovalState getApprovalState() {
        return approvalState;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public Double getSpent() {
        return spent;
    }

    public CampaignStatus getStatus() {
        return status;
    }

    public TrafficAllocationMode getTrafficAllocationMode() {
        return trafficAllocationMode;
    }

    public BidType getBidType() {
        return bidType;
    }

    public MarketingObjective getMarketingObjective() {
        return marketingObjective;
    }

    public ActivitySchedule getActivitySchedule() {
        return activitySchedule;
    }

    public CampaignTargeting<ConnectionType> getConnectionTypeTargeting() {
        return connectionTypeTargeting;
    }

    public Double getCpaGoal() {
        return cpaGoal;
    }

    public BidStrategyModifiers getPublisherBidStrategyModifiers() {
        return publisherBidStrategyModifiers;
    }

    public CampaignTargeting<String> getDmaCountryTargeting() {
        return dmaCountryTargeting;
    }

    public CampaignTargeting<String> getRegionCountryTargeting() {
        return regionCountryTargeting;
    }

    public CampaignTargeting<String> getAutoPublisherTargeting() {
        return autoPublisherTargeting;
    }

    public CampaignTargeting<String> getContextualTargeting() {
        return contextualTargeting;
    }

    public CampaignMultiTargeting<Long> getAudienceSegmentsMultiTargeting() {
        return audienceSegmentsMultiTargeting;
    }

    public CampaignMultiTargeting<Long> getCustomAudienceTargeting() {
        return customAudienceTargeting;
    }

    public CampaignMultiTargeting<String> getMarkingLabelMultiTargeting() {
        return markingLabelMultiTargeting;
    }

    public CampaignMultiTargeting<CampaignLookalikeAudienceTargeting> getLookalikeAudienceTargeting() {
        return lookalikeAudienceTargeting;
    }

    public CampaignMultiTargeting<Long> getContextualSegmentsTargeting() {
        return contextualSegmentsTargeting;
    }

    public Date getStartDateInUtc() {
        if (startDateInUtc != null) {
            try {
                return extendedDateFormat.parse(startDateInUtc);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    public String getStartDateInUtcStr() {
        return startDateInUtc;
    }

    public Date getEndDateInUtc() {
        if (endDateInUtc != null) {
            try {
                return extendedDateFormat.parse(endDateInUtc);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    public String getEndDateInUtcStr() {
        return endDateInUtc;
    }

    public CampaignPricingModel getPricingModel() {
        return pricingModel;
    }

    public ExternalBrandSafety getExternalBrandSafety() {
        return externalBrandSafety;
    }

    public VerificationPixel getVerificationPixel() {
        return verificationPixel;
    }

    public ViewabilityTag getViewabilityTag() {
        return viewabilityTag;
    }

    public CampaignPolicyReview getPolicyReview() {
        return policyReview;
    }

    public Date getTrafficAllocationAbTestEndDate() {
        return trafficAllocationAbTestEndDate;
    }

    public CampaignLinkedGroups getCampaignGroups() {
        return campaignGroups;
    }

    public CampaignType getType() {
        return type;
    }

    public ExternalMetadata getExternalMetadata() {
        return externalMetadata;
    }

    public CampaignLearningState getLearningState() {
        return learningState;
    }

    public CampaignBidStrategy getBidStrategy() {
        return bidStrategy;
    }

    public CampaignUnipRuleOptimizations getConversionRules() {
        return conversionRules;
    }

    public AttributionConfig getConversionConfiguration() {
        return conversionConfiguration;
    }

    public String getIsSpendGuardActive() {
        return isSpendGuardActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Campaign campaign = (Campaign) o;
        return Objects.equals(dateFormat, campaign.dateFormat) && Objects.equals(extendedDateFormat, campaign.extendedDateFormat) && Objects.equals(id, campaign.id) && Objects.equals(advertiserId, campaign.advertiserId) && Objects.equals(name, campaign.name) && Objects.equals(brandingText, campaign.brandingText) && Objects.equals(trackingCode, campaign.trackingCode) && Objects.equals(cpc, campaign.cpc) && Objects.equals(dailyCap, campaign.dailyCap) && dailyAdDeliveryModel == campaign.dailyAdDeliveryModel && Objects.equals(publisherBidModifier, campaign.publisherBidModifier) && Objects.equals(publisherBidStrategyModifiers, campaign.publisherBidStrategyModifiers) && trafficAllocationMode == campaign.trafficAllocationMode && Objects.equals(spendingLimit, campaign.spendingLimit) && spendingLimitModel == campaign.spendingLimitModel && Objects.equals(countryTargeting, campaign.countryTargeting) && Objects.equals(dmaCountryTargeting, campaign.dmaCountryTargeting) && Objects.equals(regionCountryTargeting, campaign.regionCountryTargeting) && Objects.equals(subCountryTargeting, campaign.subCountryTargeting) && Objects.equals(cityTargeting, campaign.cityTargeting) && Objects.equals(platformTargeting, campaign.platformTargeting) && Objects.equals(publisherTargeting, campaign.publisherTargeting) && Objects.equals(autoPublisherTargeting, campaign.autoPublisherTargeting) && Objects.equals(osTargeting, campaign.osTargeting) && Objects.equals(connectionTypeTargeting, campaign.connectionTypeTargeting) && Objects.equals(contextualTargeting, campaign.contextualTargeting) && Objects.equals(browserTargeting, campaign.browserTargeting) && Objects.equals(postalCodeTargeting, campaign.postalCodeTargeting) && Objects.equals(audienceSegmentsMultiTargeting, campaign.audienceSegmentsMultiTargeting) && Objects.equals(customAudienceTargeting, campaign.customAudienceTargeting) && Objects.equals(markingLabelMultiTargeting, campaign.markingLabelMultiTargeting) && Objects.equals(contextualSegmentsTargeting, campaign.contextualSegmentsTargeting) && Objects.equals(lookalikeAudienceTargeting, campaign.lookalikeAudienceTargeting) && Objects.equals(comments, campaign.comments) && bidType == campaign.bidType && marketingObjective == campaign.marketingObjective && Objects.equals(activitySchedule, campaign.activitySchedule) && Objects.equals(startDate, campaign.startDate) && Objects.equals(endDate, campaign.endDate) && Objects.equals(startDateInUtc, campaign.startDateInUtc) && Objects.equals(endDateInUtc, campaign.endDateInUtc) && Objects.equals(trafficAllocationAbTestEndDate, campaign.trafficAllocationAbTestEndDate) && approvalState == campaign.approvalState && Objects.equals(isActive, campaign.isActive) && Objects.equals(spent, campaign.spent) && status == campaign.status && Objects.equals(cpaGoal, campaign.cpaGoal) && pricingModel == campaign.pricingModel && Objects.equals(externalBrandSafety, campaign.externalBrandSafety) && Objects.equals(verificationPixel, campaign.verificationPixel) && Objects.equals(viewabilityTag, campaign.viewabilityTag) && Objects.equals(policyReview, campaign.policyReview) && Objects.equals(campaignGroups, campaign.campaignGroups) && type == campaign.type && learningState == campaign.learningState && bidStrategy == campaign.bidStrategy && Objects.equals(externalMetadata, campaign.externalMetadata) && Objects.equals(conversionRules, campaign.conversionRules) && Objects.equals(conversionConfiguration, campaign.conversionConfiguration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateFormat, extendedDateFormat, id, advertiserId, name, brandingText, trackingCode, cpc, dailyCap, dailyAdDeliveryModel, publisherBidModifier, publisherBidStrategyModifiers, trafficAllocationMode, spendingLimit, spendingLimitModel, countryTargeting, dmaCountryTargeting, regionCountryTargeting, subCountryTargeting, cityTargeting, platformTargeting, publisherTargeting, autoPublisherTargeting, osTargeting, connectionTypeTargeting, contextualTargeting, browserTargeting, postalCodeTargeting, audienceSegmentsMultiTargeting, customAudienceTargeting, markingLabelMultiTargeting, contextualSegmentsTargeting, lookalikeAudienceTargeting, comments, bidType, marketingObjective, activitySchedule, startDate, endDate, startDateInUtc, endDateInUtc, trafficAllocationAbTestEndDate, approvalState, isActive, spent, status, cpaGoal, pricingModel, externalBrandSafety, verificationPixel, viewabilityTag, policyReview, campaignGroups, type, learningState, bidStrategy, externalMetadata, conversionRules, conversionConfiguration);
    }

    @Override
    public String toString() {
        return "Campaign{" +
                "id='" + id + '\'' +
                ", advertiserId='" + advertiserId + '\'' +
                ", name='" + name + '\'' +
                ", brandingText='" + brandingText + '\'' +
                ", trackingCode='" + trackingCode + '\'' +
                ", cpc=" + cpc +
                ", dailyCap=" + dailyCap +
                ", dailyAdDeliveryModel=" + dailyAdDeliveryModel +
                ", publisherBidModifier=" + publisherBidModifier +
                ", publisherBidStrategyModifiers=" + publisherBidStrategyModifiers +
                ", trafficAllocationMode=" + trafficAllocationMode +
                ", spendingLimit=" + spendingLimit +
                ", spendingLimitModel=" + spendingLimitModel +
                ", countryTargeting=" + countryTargeting +
                ", dmaCountryTargeting=" + dmaCountryTargeting +
                ", regionCountryTargeting=" + regionCountryTargeting +
                ", subCountryTargeting=" + subCountryTargeting +
                ", cityTargeting=" + cityTargeting +
                ", platformTargeting=" + platformTargeting +
                ", publisherTargeting=" + publisherTargeting +
                ", autoPublisherTargeting=" + autoPublisherTargeting +
                ", osTargeting=" + osTargeting +
                ", connectionTypeTargeting=" + connectionTypeTargeting +
                ", contextualTargeting=" + contextualTargeting +
                ", browserTargeting=" + browserTargeting +
                ", postalCodeTargeting=" + postalCodeTargeting +
                ", audienceSegmentsMultiTargeting=" + audienceSegmentsMultiTargeting +
                ", customAudienceTargeting=" + customAudienceTargeting +
                ", markingLabelMultiTargeting=" + markingLabelMultiTargeting +
                ", contextualSegmentsTargeting=" + contextualSegmentsTargeting +
                ", lookalikeAudienceTargeting=" + lookalikeAudienceTargeting +
                ", comments='" + comments + '\'' +
                ", bidType=" + bidType +
                ", marketingObjective=" + marketingObjective +
                ", activitySchedule=" + activitySchedule +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", startDateInUtc=" + startDateInUtc +
                ", endDateInUtc=" + endDateInUtc +
                ", trafficAllocationAbTestEndDate=" + trafficAllocationAbTestEndDate +
                ", approvalState=" + approvalState +
                ", isActive=" + isActive +
                ", spent=" + spent +
                ", status=" + status +
                ", cpaGoal=" + cpaGoal +
                ", pricingModel=" + pricingModel +
                ", externalBrandSafety=" + externalBrandSafety +
                ", verificationPixel=" + verificationPixel +
                ", viewabilityTag=" + viewabilityTag +
                ", policyReview=" + policyReview +
                ", campaignGroups=" + campaignGroups +
                ", type=" + type +
                ", externalMetadata=" + externalMetadata +
                ", learningState=" + learningState +
                ", conversionRules=" + conversionRules +
                ", conversionConfiguration=" + conversionConfiguration +
                ", isSpendGuardActive=" + isSpendGuardActive +
                '}';
    }

}
