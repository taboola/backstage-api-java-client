package com.taboola.backstage.model.dictionary;

import java.util.Objects;

/**
 * Created by vladi
 * Date: 10/17/2017
 * Time: 11:31 PM
 * By Taboola
 */
public class Resource {

    private String name;
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Resource{" +
        "name='" + name + '\'' +
        ", value='" + value + '\'' +
        '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resource resource = (Resource) o;
        return Objects.equals(name, resource.name) &&
        Objects.equals(value, resource.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }
}
