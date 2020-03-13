package com.taboola.backstage.model.auth;

import java.util.List;
import java.util.Objects;

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
    private String userId;

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

    public String getUserId() { return userId; }

    public void setUserId() { this.userId = userId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TokenDetails that = (TokenDetails) o;
        return Objects.equals(username, that.username) &&
        Objects.equals(accountId, that.accountId) &&
        Objects.equals(fullName, that.fullName) &&
        Objects.equals(expiresIn, that.expiresIn) &&
        Objects.equals(permissions, that.permissions) &&
        Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, accountId, fullName, expiresIn, permissions, userId);
    }

    @Override
    public String toString() {
        return "TokenDetails{" +
        "username='" + username + '\'' +
        ", accountId='" + accountId + '\'' +
        ", fullName='" + fullName + '\'' +
        ", userId=" + userId + '\'' +
        ", expiresIn=" + expiresIn +
        ", permissions=" + permissions +
        '}';
    }
}
