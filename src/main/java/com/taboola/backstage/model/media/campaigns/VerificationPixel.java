package com.taboola.backstage.model.media.campaigns;

import java.util.List;
import java.util.Objects;

/**
 * Created by George
 * Date: 5/2/2020
 * Time: 17:00 PM
 * By InPowered
 */
public class VerificationPixel {
    private List<VerificationPixelItem> verificationPixelItems;

    public List<VerificationPixelItem> getVerificationPixelItems() {
        return verificationPixelItems;
    }

    public void setVerificationPixelItems(List<VerificationPixelItem> verificationPixelItems) {
        this.verificationPixelItems = verificationPixelItems;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("VerificationPixel{");
        sb.append("verificationPixelItems=").append(verificationPixelItems);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VerificationPixel)) return false;
        VerificationPixel that = (VerificationPixel) o;
        return Objects.equals(getVerificationPixelItems(), that.getVerificationPixelItems());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVerificationPixelItems());
    }
}
