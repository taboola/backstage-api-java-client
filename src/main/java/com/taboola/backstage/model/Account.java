package com.taboola.backstage.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) &&
        Objects.equals(name, account.name) &&
        Objects.equals(accountId, account.accountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, accountId);
    }
}
