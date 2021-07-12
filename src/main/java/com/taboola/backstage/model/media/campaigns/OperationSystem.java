package com.taboola.backstage.model.media.campaigns;

import java.util.Collection;
import java.util.Objects;

import com.taboola.rest.api.annotations.Required;

/**
 * Created by vladi.m
 * Date 03/10/2018
 * Time 9:35
 * Copyright Taboola
 */
public class OperationSystem {

    @Required
    private String osFamily;
    private Collection<String> subCategories;

    public String getOsFamily() {
        return osFamily;
    }

    public OperationSystem setOsFamily(String osFamily) {
        this.osFamily = osFamily;
        return this;
    }

    public Collection<String> getSubCategories() {
        return subCategories;
    }

    public OperationSystem setSubCategories(Collection<String> subCategories) {
        this.subCategories = subCategories;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperationSystem that = (OperationSystem) o;
        return Objects.equals(osFamily, that.osFamily) &&
                Objects.equals(subCategories, that.subCategories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(osFamily, subCategories);
    }

    @Override
    public String toString() {
        return "OperationSystem{" +
                "osFamily='" + osFamily + '\'' +
                ", subCategories=" + subCategories +
                '}';
    }
}
