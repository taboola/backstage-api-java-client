package com.taboola.backstage.model.publishers.reports;


/**
 * Created by vladi
 * Date: 2/3/2018
 * Time: 10:59 PM
 * By Taboola
 */
public enum RevenueSummaryDimensions {

    DAY("day"),
    WEEK("week"),
    MONTH("month"),;
    //TODO impl


    private final String name;

    RevenueSummaryDimensions(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
