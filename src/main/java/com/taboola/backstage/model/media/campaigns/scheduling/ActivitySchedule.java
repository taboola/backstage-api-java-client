package com.taboola.backstage.model.media.campaigns.scheduling;

import java.util.Collection;
import java.util.Objects;

import com.taboola.rest.api.annotations.Required;

/**
 * Created by vladi.m
 * Date 03/10/2018
 * Time 12:13
 * Copyright Taboola
 */
public class ActivitySchedule {

    @Required
    private ActivityScheduleMode mode;
    private Collection<ActivityScheduleItem> rules;
    private String timeZone;

    public ActivityScheduleMode getMode() {
        return mode;
    }

    public ActivitySchedule setMode(ActivityScheduleMode mode) {
        this.mode = mode;
        return this;
    }

    public Collection<ActivityScheduleItem> getRules() {
        return rules;
    }

    public ActivitySchedule setRules(Collection<ActivityScheduleItem> rules) {
        this.rules = rules;
        return this;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public ActivitySchedule setTimeZone(String timeZone) {
        this.timeZone = timeZone;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivitySchedule that = (ActivitySchedule) o;
        return mode == that.mode &&
                Objects.equals(rules, that.rules) &&
                Objects.equals(timeZone, that.timeZone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mode, rules, timeZone);
    }

    @Override
    public String toString() {
        return "ActivitySchedule{" +
                "mode='" + mode + '\'' +
                ", rules=" + rules +
                ", timeZone='" + timeZone + '\'' +
                '}';
    }
}
