package com.taboola.backstage.model.media.campaigns.scheduling;

import java.util.Objects;

import com.taboola.backstage.annotations.Required;
import com.taboola.backstage.model.DayOfWeek;
import com.taboola.backstage.model.Hour;

/**
 * Created by vladi.m
 * Date 03/10/2018
 * Time 15:47
 * Copyright Taboola
 */
public class ActivityScheduleItem {

    @Required
    private Type type;
    @Required
    private DayOfWeek day;
    @Required
    private Hour fromHour;
    @Required
    private Hour untilHour;

    public Type getType() {
        return type;
    }

    public ActivityScheduleItem setType(Type type) {
        this.type = type;
        return this;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public ActivityScheduleItem setDay(DayOfWeek day) {
        this.day = day;
        return this;
    }

    public Hour getFromHour() {
        return fromHour;
    }

    public ActivityScheduleItem setFromHour(Hour fromHour) {
        this.fromHour = fromHour;
        return this;
    }

    public Hour getUntilHour() {
        return untilHour;
    }

    public ActivityScheduleItem setUntilHour(Hour untilHour) {
        this.untilHour = untilHour;
        return this;
    }

    @Override
    public String toString() {
        return "ActivityScheduleItem{" +
                "type=" + type +
                ", day=" + day +
                ", fromHour=" + fromHour +
                ", untilHour=" + untilHour +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivityScheduleItem that = (ActivityScheduleItem) o;
        return type == that.type &&
                day == that.day &&
                Objects.equals(fromHour, that.fromHour) &&
                Objects.equals(untilHour, that.untilHour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, day, fromHour, untilHour);
    }
}
