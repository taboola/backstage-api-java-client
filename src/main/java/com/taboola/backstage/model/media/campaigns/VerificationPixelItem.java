package com.taboola.backstage.model.media.campaigns;

import java.util.Objects;

/**
 * Created by George
 * Date: 5/2/2020
 * Time: 17:00 PM
 * By InPowered
 */
public class VerificationPixelItem {
    private VerificationPixelType verificationPixelType;
    private String url;

    public VerificationPixelType getVerificationPixelType() {
        return verificationPixelType;
    }

    public void setVerificationPixelType(VerificationPixelType verificationPixelType) {
        this.verificationPixelType = verificationPixelType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("VerificationPixelItem{");
        sb.append("verificationPixelType=").append(verificationPixelType);
        sb.append(", url='").append(url).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VerificationPixelItem)) return false;
        VerificationPixelItem that = (VerificationPixelItem) o;
        return getVerificationPixelType() == that.getVerificationPixelType() &&
                Objects.equals(getUrl(), that.getUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVerificationPixelType(), getUrl());
    }
}
