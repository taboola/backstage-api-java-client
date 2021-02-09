/*
 * Copyright 2021 InPowered. All Rights Reserved.
 *
 * This software is the proprietary information of InPowered.
 * Use is subject to license terms.
 */
package com.taboola.backstage.model.media.campaigns.performancevideos;

import java.io.File;

/**
 * Performance video item operation builder.
 *
 * Created by Gabriel Diaz, 09/02/2020.
 */
public class PerformanceVideoItemOperation extends PerformanceVideoItem {

    private PerformanceVideoItemOperation() {
        super();
    }

    public static PerformanceVideoItemOperation create() {
        return new PerformanceVideoItemOperation();
    }

    public PerformanceVideoItemOperation setUrl(String url) {
        this.url = url;
        return this;
    }

    public PerformanceVideoItemOperation setTitle(String title) {
        this.title = title;
        return this;
    }

    public PerformanceVideoItemOperation setActive(Boolean active) {
        this.isActive = active;
        return this;
    }

    public PerformanceVideoItemOperation setVideo(String videoUrl, String fallbackUrl) {
        this.videoUrl = videoUrl;
        this.fallbackUrl = fallbackUrl;
        return this;
    }

    public PerformanceVideoItemOperation uploadVideo(File videoFile, File fallbackFile) {
        this.videoFile = videoFile;
        this.fallbackFile = fallbackFile;
        return this;
    }

}
