package com.taboola.backstage.services;

import com.taboola.backstage.model.tracking.Conversion;

/**
 * Created by Marcelo Dias on 08/30/2024.
 *
 * Service for tracking conversions.
 */
public interface TrackingService {

    /**
     * Sends offline conversion data to Taboola.
     *
     * @param accountId The account ID to send the conversion data to.
     * @param conversion The conversion data to send.
     */
    void sendConversion(String accountId, Conversion conversion);
}
