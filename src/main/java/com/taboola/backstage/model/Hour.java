package com.taboola.backstage.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by vladi.m
 * Date 03/10/2018
 * Time 16:22
 * Copyright Taboola
 */
public enum Hour {
    ZERO(0),
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    ELEVEN(11),
    TWELVE(12),
    THIRTEEN(13),
    FOURTEEN(14),
    FIFTEEN(15),
    SIXTEEN(16),
    SEVENTEEN(17),
    EIGHTEEN(18),
    NINETEEN(19),
    TWENTY(20),
    TWENTY_ONE(21),
    TWENTY_TWO(22),
    TWENTY_THREE(23),
    TWENTY_FOUR(24);

    private int num;

    Hour(int num) {
        this.num = num;
    }

    @JsonCreator
    public static Hour toEnum(String strHour) {
        try {
            int parsedNum = Integer.parseInt(strHour);
            for (Hour type : Hour.values()) {
                if (type.num == parsedNum) {
                    return type;
                }
            }
        } catch(Throwable ignored) {}
        return null;
    }

    @JsonValue
    private Integer toInteger() {
        return num;
    }
}
