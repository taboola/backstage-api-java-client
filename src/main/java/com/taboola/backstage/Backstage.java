package com.taboola.backstage;

import com.taboola.backstage.internal.CommunicationFactory;
import com.taboola.backstage.internal.config.CommunicationConfig;
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

    private Backstage(CampaignsService campaignsService,
                      AuthenticationService authenticationService, UserService userService,
                      CampaignItemsService campaignItemsService, DictionaryService dictionaryService,
                      ReportsService reportsService, AccountsService accountsService,
                      CampaignPostalTargetingService campaignPostalCodeTargetingService) {

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

    //TODO support async services

    public static class BackstageBuilder {
        private static final String DEFAULT_BACKSTAGE_HOST = "https://backstage.taboola.com/backstage/";
        private static final String DEFAULT_AUTH_BACKSTAGE_HOST = "https://authentication.taboola.com/authentication/";
        private static final String DEFAULT_USER_AGENT = "Taboola Java Client";

        private String baseUrl;
        private String authBaseUrl;
        private String userAgent;
        private Long writeTimeoutMillis;
        private Long connectionTimeoutMillis;
        private Long readTimeoutMillis;
        private Boolean performClientValidations;
        private Boolean debug;

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

        public BackstageBuilder setPerformClientValidations(Boolean performClientValidations) {
            this.performClientValidations = performClientValidations;
            return this;
        }

        public BackstageBuilder setDebug(Boolean debug) {
            this.debug = debug;
            return this;
        }

        public Backstage build() {
            organizeState();
            CommunicationConfig config = new CommunicationConfig(baseUrl, authBaseUrl, connectionTimeoutMillis, readTimeoutMillis, writeTimeoutMillis, userAgent, debug);
            CommunicationFactory communicator = new CommunicationFactory(config);
            return new Backstage(
                new CampaignsServiceImpl(performClientValidations, communicator.getCampaignsService()),
                new AuthenticationServiceImpl(communicator.getAuthService()),
                new UserServiceImpl(communicator.getAccountService()),
                new CampaignItemsServiceImpl(performClientValidations, communicator.getCampaignItemService()),
                new DictionaryServiceImpl(communicator.getDictionaryService()),
                new ReportsServiceImpl(communicator.getMediaReportsService(), communicator.getPublisherReportsService()),
                new AccountsServiceImpl(communicator.getAccountService()),
                new CampaignPostalTargetingServiceImpl(performClientValidations, communicator.getCampaignPostalCodeTargeting())
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

            if(userAgent == null) {
                userAgent = DEFAULT_USER_AGENT;
            }

            if(performClientValidations == null) {
                performClientValidations = true;
            }

            if(debug == null) {
                debug = false;
            }
        }

    }
}
