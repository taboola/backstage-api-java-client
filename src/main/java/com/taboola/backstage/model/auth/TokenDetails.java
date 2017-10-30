package com.taboola.backstage.model.auth;

import java.util.List;

/**
 * Created by vladi
 * Date: 9/13/2017
 * Time: 12:09 AM
 * By Taboola
 */
public class TokenDetails {

    private String username;
    private String accountId;
    private String fullName;
    private Integer expiresIn;
    private List<String> permissions;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "TokenDetails{" +
        "username='" + username + '\'' +
        ", accountId='" + accountId + '\'' +
        ", fullName='" + fullName + '\'' +
        ", expiresIn=" + expiresIn +
        ", permissions=" + permissions +
        '}';
    }
}
