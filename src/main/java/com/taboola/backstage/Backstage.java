package com.taboola.backstage;

import com.taboola.backstage.internal.*;
import com.taboola.backstage.internal.config.CommunicationConfig;
import com.taboola.backstage.internal.factories.BackstageEndpointsFactory;
import com.taboola.backstage.internal.factories.BackstageEndpointsRetrofitFactory;
import com.taboola.backstage.internal.BackstageInternalTools;
import com.taboola.backstage.internal.BackstageInternalToolsImpl;
import com.taboola.backstage.services.*;

/**
 * Backstage is the gateway object to all services.
 * <br>
 * In order to get {@link Backstage} object use its builder as following:
 * <pre>
 * {@code
 * Backstage backstage = Backstage.builder().build();
 * }
 *</pre>
 *
 * Example : getting all {@link com.taboola.backstage.model.media.campaigns.Campaign Campaigns} that belong to my account id
 * <pre>
 * {@code
 *  Backstage backstage = Backstage.builder().build();
 *
 *  try {
 *      //establish authentication
 *      BackstageAuthentication clientAuth = backstage.authenticationService().clientCredentials("your_client_id...",
 *                                                                                               "your_client_secret...");
 *      //know your account ID in advance or by fetching token details
 *      String accountId = backstage.authenticationService().getTokenDetails(clientAuth).getAccountId();
 *
 *      //get all your account campaigns
 *      Results<Campaign> campaignResults = backstage.campaignsService().read(clientAuth, accountId);
 *      //do something...
 *
 *   } catch (BackstageAPIUnauthorizedException e) {
 *      //handle HTTP status 401 : token is expired or bad credentials
 *
 *   } catch (BackstageAPIRequestException e) {
 *      //handle HTTP status 4xx
 *
 *   } catch (BackstageAPIConnectivityException e) {
 *      //handle connectivity issues
 *   }
 * }
 * </pre>
 *
 * @author vladi
 * @version 1.0
 */
public class Backstage {

    private final CampaignsService campaignsService;
    private final AuthenticationService authenticationService;
    private final UserService userService;
    private final CampaignItemsService campaignItemsService;
    private final DictionaryService dictionaryService;
    private final ReportsService reportsService;
    private final AccountsService accountsService;
    private final CampaignPostalTargetingService campaignPostalCodeTargetingService;
    private final BackstageInternalTools internalTools;

    private Backstage(BackstageInternalTools internalTools, CampaignsService campaignsService,
                      AuthenticationService authenticationService, UserService userService,
                      CampaignItemsService campaignItemsService, DictionaryService dictionaryService,
                      ReportsService reportsService, AccountsService accountsService,
                      CampaignPostalTargetingService campaignPostalCodeTargetingService) {

        this.internalTools = internalTools;
        this.campaignsService = campaignsService;
        this.authenticationService = authenticationService;
        this.userService = userService;
        this.campaignItemsService = campaignItemsService;
        this.dictionaryService = dictionaryService;
        this.reportsService = reportsService;
        this.accountsService = accountsService;
        this.campaignPostalCodeTargetingService = campaignPostalCodeTargetingService;
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

    public AdvertiserReportsService advertiserReportsService() {
        return reportsService;
    }

    public PublisherReportsService publisherReportsService() {
        return reportsService;
    }

    public AccountsService accountsService() {
        return accountsService;
    }

    public CampaignPostalTargetingService campaignPostalCodeTargetingService() {
        return campaignPostalCodeTargetingService;
    }

    public BackstageInternalTools internalTools() {
        return internalTools;
    }

    //TODO support async services

    public static class BackstageBuilder {
        private static final String DEFAULT_BACKSTAGE_HOST = "https://backstage.taboola.com/backstage/";
        private static final String DEFAULT_AUTH_BACKSTAGE_HOST = "https://authentication.taboola.com/authentication/";
        private static final String DEFAULT_USER_AGENT = "Taboola Java Client";
        private static final String VERSION = "1.0.5";
        private static final Integer DEFAULT_MAX_IDLE_CONNECTIONS = 5;
        private static final Long DEFAULT_KEEP_ALIVE_DURATION_MILLIS = 300_000L;

        private String baseUrl;
        private String authBaseUrl;
        private String userAgent;
        private Long writeTimeoutMillis;
        private Long connectionTimeoutMillis;
        private Long readTimeoutMillis;
        private Integer maxIdleConnections;
        private Long keepAliveDurationMillis;
        private Boolean performClientValidations;
        private Boolean debug;
        private Boolean organizeDynamicColumns;

        public BackstageBuilder setBaseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
            return this;
        }

        public BackstageBuilder setAuthBaseUrl(String authBaseUrl) {
            this.authBaseUrl = authBaseUrl;
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

        public BackstageBuilder setMaxIdleConnections(Integer maxIdleConnections) {
            this.maxIdleConnections = maxIdleConnections;
            return this;
        }

        public BackstageBuilder setKeepAliveDurationMillis(Long keepAliveDurationMillis) {
            this.keepAliveDurationMillis = keepAliveDurationMillis;
            return this;
        }

        public BackstageBuilder setPerformClientValidations(Boolean performClientValidations) {
            this.performClientValidations = performClientValidations;
            return this;
        }

        public BackstageBuilder setDebug(Boolean debug) {
            this.debug = debug;
            return this;
        }

        public BackstageBuilder setOrganizeDynamicColumns(Boolean organizeDynamicColumns) {
            this.organizeDynamicColumns = organizeDynamicColumns;
            return this;
        }

        public Backstage build() {
            organizeState();
            String finalUserAgent = String.format("Backstage/%s (%s)", VERSION, userAgent);
            CommunicationConfig config = new CommunicationConfig(baseUrl, authBaseUrl, connectionTimeoutMillis, readTimeoutMillis, writeTimeoutMillis, maxIdleConnections,
                    keepAliveDurationMillis, finalUserAgent, debug);
            CommunicationFactory communicator = new CommunicationFactory(config);
            BackstageEndpointsFactory endpointsFactory = new BackstageEndpointsRetrofitFactory(communicator);
            return new Backstage(
                new BackstageInternalToolsImpl(endpointsFactory),
                new CampaignsServiceImpl(performClientValidations, endpointsFactory.createEndpoint(BackstageCampaignsEndpoint.class)),
                new AuthenticationServiceImpl(endpointsFactory.createAuthEndpoint(BackstageAuthenticationEndpoint.class)),
                new UserServiceImpl(endpointsFactory.createEndpoint(BackstageAccountEndpoint.class)),
                new CampaignItemsServiceImpl(performClientValidations, endpointsFactory.createEndpoint(BackstageCampaignItemsEndpoint.class)),
                new DictionaryServiceImpl(endpointsFactory.createEndpoint(BackstageDictionaryEndpoint.class)),
                new ReportsServiceImpl(endpointsFactory.createEndpoint(BackstageMediaReportsEndpoint.class), endpointsFactory.createEndpoint(BackstagePublisherReportsEndpoint.class), organizeDynamicColumns),
                new AccountsServiceImpl(endpointsFactory.createEndpoint(BackstageAccountEndpoint.class)),
                new CampaignPostalTargetingServiceImpl(performClientValidations, endpointsFactory.createEndpoint(BackstagePostalTargetingEndpoint.class))
            );
        }

        private void organizeState() {
            if(baseUrl == null) {
                baseUrl = DEFAULT_BACKSTAGE_HOST;
            }

            if(authBaseUrl == null) {
                authBaseUrl = DEFAULT_AUTH_BACKSTAGE_HOST;
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

            if(maxIdleConnections == null) {
                maxIdleConnections = DEFAULT_MAX_IDLE_CONNECTIONS;
            }

            if(keepAliveDurationMillis == null) {
                keepAliveDurationMillis = DEFAULT_KEEP_ALIVE_DURATION_MILLIS;
            }

            if(userAgent == null) {
                userAgent = DEFAULT_USER_AGENT;
            }

            if(performClientValidations == null) {
                performClientValidations = true;
            }

            if(debug == null) {
                debug = false;
            }

            if(organizeDynamicColumns == null) {
                organizeDynamicColumns = true;
            }
        }
    }
}
