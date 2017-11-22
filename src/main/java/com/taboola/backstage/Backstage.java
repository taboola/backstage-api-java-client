package com.taboola.backstage;

import com.taboola.backstage.services.*;

/**
 * Created by vladi
 * Date: 10/13/2017
 * Time: 11:37 PM
 * By Taboola
 */
public class Backstage {

    private final CampaignsService campaignsService;
    private final AuthenticationService authenticationService;
    private final UserService userService;
    private final CampaignItemsService campaignItemsService;
    private final DictionaryService dictionaryService;
    private final ReportsService reportsService;

    private Backstage(CampaignsService campaignsService,
                      AuthenticationService authenticationService, UserService userService,
                      CampaignItemsService campaignItemsService, DictionaryService dictionaryService,
                      ReportsService reportsService) {

        this.campaignsService = campaignsService;
        this.authenticationService = authenticationService;
        this.userService = userService;
        this.campaignItemsService = campaignItemsService;
        this.dictionaryService = dictionaryService;
        this.reportsService = reportsService;
    }

    public static BackstageBuilder builder() {
        return new BackstageBuilder();
    }

    public CampaignsService campaignsService() {
        return campaignsService;
    }

    public AuthenticationService authenticationService() {
        return authenticationService;
    }

    public UserService userService() {
        return userService;
    }

    public CampaignItemsService campaignItemsService() {
        return campaignItemsService;
    }

    public DictionaryService dictionaryService() {
        return dictionaryService;
    }

    public ReportsService reportsService() {
        return reportsService;
    }

    public static class BackstageBuilder {
        private static final String DEFAULT_BACKSTAGE_HOST = "https://backstage.taboola.com";
        private static final String DEFAULT_USER_AGENT = "Taboola Java Client";

        private String baseUrl;
        private String userAgent;
        private Long writeTimeoutMillis;
        private Long connectionTimeoutMillis;
        private Long readTimeoutMillis;

        public BackstageBuilder setBaseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
            return this;
        }

        public BackstageBuilder setUserAgent(String userAgent) {
            this.userAgent = userAgent;
            return this;
        }

        public BackstageBuilder setConnectionTimeoutMillis(Long connectionTimeoutMillis) {
            this.connectionTimeoutMillis = connectionTimeoutMillis;
            return this;
        }

        public BackstageBuilder setReadTimeoutMillis(Long readTimeoutMillis) {
            this.readTimeoutMillis = readTimeoutMillis;
            return this;
        }

        public BackstageBuilder setWriteTimeoutMillis(Long writeTimeoutMillis) {
            this.writeTimeoutMillis = writeTimeoutMillis;
            return this;
        }

        public Backstage build() {
            organizeState();
            CommunicationFactory communicator = new CommunicationFactory(baseUrl, connectionTimeoutMillis, readTimeoutMillis, writeTimeoutMillis, userAgent);
            return new Backstage(
                new CampaignsServiceImpl(communicator.getCampaignsService()),
                new AuthenticationServiceImpl(communicator.getAuthService()),
                new UserServiceImpl(communicator.getAccountService()),
                new CampaignItemsServiceImpl(communicator.getCampaignItemService()),
                new DictionaryServiceImpl(communicator.getDictionaryService()),
                new ReportsServiceImpl(communicator.getMediaReportsService())
            );
        }

        private void organizeState() {
            if(baseUrl == null) {
                baseUrl = DEFAULT_BACKSTAGE_HOST;
            }

            if(connectionTimeoutMillis == null) {
                connectionTimeoutMillis = 0L;
            }

            if(readTimeoutMillis == null) {
                readTimeoutMillis = 0L;
            }

            if(writeTimeoutMillis == null) {
                writeTimeoutMillis = 0L;
            }

            if(userAgent == null) {
                userAgent = DEFAULT_USER_AGENT;
            }
        }

    }
}
