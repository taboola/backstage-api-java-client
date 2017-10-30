package com.taboola.backstage.model;

/**
 * Created by vladi
 * Date: 10/16/2017
 * Time: 11:21 PM
 * By Taboola
 */
public class Account {

    private Long id;
    private String name;
    private String accountId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "Account{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", accountId='" + accountId + '\'' +
        '}';
    }
}
