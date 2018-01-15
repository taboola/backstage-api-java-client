package com.taboola.backstage.model.media.campaigns.targeting;

import java.util.Collection;
import java.util.Objects;

/**
 * Created by vladi
 * Date: 1/15/2018
 * Time: 11:28 PM
 * By Taboola
 */
public class PostalTargeting {

    private Type type;
    private Collection<String> collection;

    public PostalTargeting() {
        //for serialization
    }

    public PostalTargeting(Collection<String> collection) {
        this.collection = collection;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Collection<String> getCollection() {
        return collection;
    }

    public void setCollection(Collection<String> collection) {
        this.collection = collection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostalTargeting that = (PostalTargeting) o;
        return type == that.type &&
        Objects.equals(collection, that.collection);
    }

    @Override
    public int hashCode() {

        return Objects.hash(type, collection);
    }

    @Override
    public String toString() {
        return "PostalTargeting{" +
        "type=" + type +
        ", collection=" + collection +
        '}';
    }
}
