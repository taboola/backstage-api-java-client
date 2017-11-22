package com.taboola.backstage.model;

import java.util.Collection;
import java.util.Objects;

/**
 * Created by vladi
 * Date: 10/13/2017
 * Time: 10:33 PM
 * By Taboola
 */
public class Results<T> {

    private Collection<T> results;

    public Results() {
        //for serialization
    }

    public Results(Collection<T> results) {
        this.results = results;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Results<?> results1 = (Results<?>) o;
        return Objects.equals(results, results1.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }
}
