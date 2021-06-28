package com.taboola.backstage.model.media.account;

import java.util.Objects;
import java.util.Set;

import com.taboola.backstage.model.Patch;
import com.taboola.rest.api.annotations.Required;

/**
 * Created by vladi.m
 * Date 16/12/2020
 * Time 11:29
 * Copyright Taboola
 */
public class AccountBlockedPublishersPatch extends Patch {

    @Required
    private Set<String> sites;

    public Set<String> getSites() {
        return sites;
    }

    public void setSites(Set<String> sites) {
        this.sites = sites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountBlockedPublishersPatch that = (AccountBlockedPublishersPatch) o;
        return Objects.equals(sites, that.sites);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sites);
    }

    @Override
    public String toString() {
        return "AccountBlockedPublishersPatch{" +
                "patchOperation=" + patchOperation +
                ", sites=" + sites +
                '}';
    }
}
