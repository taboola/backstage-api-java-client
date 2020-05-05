package com.taboola.backstage.model.media.campaigns;

/**
 * Created by vladi.m
 * Date 16/04/2020
 * Time 13:00
 * Copyright Taboola
 */
public class BidStrategyPerAffiliate {
    private String publisher;
    private CampaignBidStrategy bidStrategy;

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public CampaignBidStrategy getBidStrategy() {
        return bidStrategy;
    }

    public void setBidStrategy(CampaignBidStrategy bidStrategy) {
        this.bidStrategy = bidStrategy;
    }

    @Override
    public String toString() {
        return "BidStrategyPerAffiliate{" +
                "publisher='" + publisher + '\'' +
                ", bidStrategy=" + bidStrategy +
                '}';
    }
}
