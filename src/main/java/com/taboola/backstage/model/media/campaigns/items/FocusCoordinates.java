package com.taboola.backstage.model.media.campaigns.items;

import java.util.Objects;

/**
 * Created by vladi.m
 * Date 11/11/2020
 * Time 9:54
 * Copyright Taboola
 */
public class FocusCoordinates {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FocusCoordinates that = (FocusCoordinates) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "FocusCoordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
