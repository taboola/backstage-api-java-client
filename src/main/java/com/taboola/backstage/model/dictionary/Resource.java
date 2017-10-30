package com.taboola.backstage.model.dictionary;

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
}
