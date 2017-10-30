package com.taboola.backstage.model;

import java.util.Collection;

/**
 * Created by vladi
 * Date: 10/13/2017
 * Time: 10:33 PM
 * By Taboola
 */
public class Results<T> {

    private Collection<T> results;

    public Collection<T> getResults() {
        return results;
    }

    public void setResults(Collection<T> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "Results{" +
        "results=" + results +
        '}';
    }
}
