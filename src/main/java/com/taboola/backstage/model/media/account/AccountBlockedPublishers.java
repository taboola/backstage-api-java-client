package com.taboola.backstage.model.media.account;

import java.util.Objects;
import java.util.Set;

import com.taboola.rest.api.annotations.Required;

public class AccountBlockedPublishers {

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
        AccountBlockedPublishers that = (AccountBlockedPublishers) o;
        return Objects.equals(sites, that.sites);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sites);
    }

    @Override
    public String toString() {
        return "AccountBlockedPublishers{" +
                "sites=" + sites +
                '}';
    }
}
