package com.taboola.backstage.model.publishers.reports;

/**
 * Created by vladi
 * Date: 2/3/2018
 * Time: 11:01 PM
 * By Taboola
 */
public enum RecirculationSummaryDimensions {

    DAY("day"),
    WEEK("week"),
    MONTH("month"),;
    //TODO impl


    private final String name;

    RecirculationSummaryDimensions(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
