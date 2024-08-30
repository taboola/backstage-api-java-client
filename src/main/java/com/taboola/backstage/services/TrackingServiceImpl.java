package com.taboola.backstage.services;

import com.taboola.backstage.internal.BackstageTrackingEndpoint;
import com.taboola.backstage.model.tracking.Conversion;

/**
 * Created by Marcelo Dias on 08/30/2024.
 */
public class TrackingServiceImpl implements TrackingService {

    private final BackstageTrackingEndpoint trackingEndpoint;

    public TrackingServiceImpl(BackstageTrackingEndpoint trackingEndpoint) {
        this.trackingEndpoint = trackingEndpoint;
    }

    @Override
    public void sendConversion(String accountId, Conversion conversion) {
            trackingEndpoint.sendConversion(accountId, conversion);
    }
}
