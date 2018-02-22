package com.taboola.backstage.internal.interceptors;

import okhttp3.logging.HttpLoggingInterceptor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by vladi
 * Date: 2/18/2018
 * Time: 11:45 PM
 * By Taboola
 */
public class CommunicationInterceptor implements HttpLoggingInterceptor.Logger {

    private static final Logger logger = LogManager.getLogger(CommunicationInterceptor.class);

    @Override
    public void log(String message) {
        logger.info(message);
    }
}
