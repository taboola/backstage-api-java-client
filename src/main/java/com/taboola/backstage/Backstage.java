package com.taboola.backstage;

import java.util.Collection;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taboola.backstage.internal.BackstageAccountEndpoint;
import com.taboola.backstage.internal.BackstageAudienceTargetingEndpoint;
import com.taboola.backstage.internal.BackstageAuthenticationEndpoint;
import com.taboola.backstage.internal.BackstageCampaignItemsEndpoint;
import com.taboola.backstage.internal.BackstageCampaignsEndpoint;
import com.taboola.backstage.internal.BackstageDictionaryEndpoint;
import com.taboola.backstage.internal.BackstageInternalTools;
import com.taboola.backstage.internal.BackstageInternalToolsImpl;
import com.taboola.backstage.internal.BackstageMediaReportsEndpoint;
import com.taboola.backstage.internal.BackstagePostalTargetingEndpoint;
import com.taboola.backstage.internal.BackstagePublisherReportsEndpoint;
import com.taboola.backstage.internal.BackstageSharedBudgetEndpoint;
import com.taboola.backstage.internal.factories.BackstageAPIExceptionFactory;
import com.taboola.backstage.internal.factories.BackstageEndpointsFactory;
import com.taboola.backstage.internal.factories.BackstageEndpointsRetrofitFactory;
import com.taboola.backstage.services.AccountsService;
import com.taboola.backstage.services.AccountsServiceImpl;
import com.taboola.backstage.services.AdvertiserReportsService;
import com.taboola.backstage.services.AuthenticationService;
import com.taboola.backstage.services.AuthenticationServiceImpl;
import com.taboola.backstage.services.CampaignAudienceTargetingService;
import com.taboola.backstage.services.CampaignAudienceTargetingServiceImpl;
import com.taboola.backstage.services.CampaignItemsService;
import com.taboola.backstage.services.CampaignItemsServiceImpl;
import com.taboola.backstage.services.CampaignPostalTargetingService;
import com.taboola.backstage.services.CampaignPostalTargetingServiceImpl;
import com.taboola.backstage.services.CampaignsService;
import com.taboola.backstage.services.CampaignsServiceImpl;
import com.taboola.backstage.services.DictionaryService;
import com.taboola.backstage.services.DictionaryServiceImpl;
import com.taboola.backstage.services.PublisherReportsService;
import com.taboola.backstage.services.ReportsService;
import com.taboola.backstage.services.ReportsServiceImpl;
import com.taboola.backstage.services.SharedBudgetService;
import com.taboola.backstage.services.SharedBudgetServiceImpl;
import com.taboola.backstage.services.UserService;
import com.taboola.backstage.services.UserServiceImpl;
import com.taboola.rest.api.RestAPIClient;
import com.taboola.rest.api.internal.config.SerializationConfig;
import com.taboola.rest.api.internal.serialization.SerializationMapperCreator;
import com.taboola.rest.api.model.RequestHeader;

/**
 * Backstage is the gateway object to all services.
 * <br>
 * In order to get {@link Backstage} object use its builder as following:
 * <pre>
 * {@code
 * Backstage backstage = Backstage.builder().build();
 * }
 * </pre>
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
    private final CampaignAudienceTargetingService campaignAudienceTargetingService;
    private final SharedBudgetService sharedBudgetService;

    private Backstage(BackstageInternalTools internalTools, CampaignsService campaignsService,
                      AuthenticationService authenticationService, UserService userService,
                      CampaignItemsService campaignItemsService, DictionaryService dictionaryService,
                      ReportsService reportsService, AccountsService accountsService,
                      CampaignPostalTargetingService campaignPostalCodeTargetingService,
                      CampaignAudienceTargetingService campaignAudienceTargetingService,
                      SharedBudgetService sharedBudgetService) {

        this.internalTools = internalTools;
        this.campaignsService = campaignsService;
        this.authenticationService = authenticationService;
        this.userService = userService;
        this.campaignItemsService = campaignItemsService;
        this.dictionaryService = dictionaryService;
        this.reportsService = reportsService;
        this.accountsService = accountsService;
        this.campaignPostalCodeTargetingService = campaignPostalCodeTargetingService;
        this.campaignAudienceTargetingService = campaignAudienceTargetingService;
        this.sharedBudgetService = sharedBudgetService;
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

    public CampaignAudienceTargetingService campaignAudienceTargetingService() {
        return campaignAudienceTargetingService;
    }

    public SharedBudgetService sharedBudgetService() {
        return sharedBudgetService;
    }

    public BackstageInternalTools internalTools() {
        return internalTools;
    }

    public static class BackstageBuilder {
        private static final String DEFAULT_BACKSTAGE_HOST = "https://backstage.taboola.com/backstage/";
        private static final String DEFAULT_AUTH_BACKSTAGE_HOST = "https://authentication.taboola.com/authentication/";
        private static final String DEFAULT_USER_AGENT = "Taboola Java Client";
        private static final String VERSION = "1.1.4";
        private static final SerializationConfig DEFAULT_SERIALIZATION_CONFIG = new SerializationConfig();

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
        private SerializationConfig serializationConfig;
        private Collection<RequestHeader> headers;

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

        public BackstageBuilder setSerializationConfig(SerializationConfig serializationConfig) {
            this.serializationConfig = serializationConfig;
            return this;
        }

        public BackstageBuilder setHeaders(Collection<RequestHeader> headers){
            this.headers = headers;
            return this;
        }

        public Backstage build() {
            organizeState();

            ObjectMapper objectMapper = SerializationMapperCreator.createObjectMapper(serializationConfig);
            RestAPIClient.RestAPIClientBuilder restAPIClientBuilder = RestAPIClient.builder()
                    .setAPIVersion(VERSION)
                    .setObjectMapper(objectMapper)
                    .setConnectionTimeoutMillis(connectionTimeoutMillis)
                    .setMaxIdleConnections(maxIdleConnections)
                    .setReadTimeoutMillis(readTimeoutMillis)
                    .setWriteTimeoutMillis(writeTimeoutMillis)
                    .setSerializationConfig(serializationConfig)
                    .setHeaders(headers)
                    .setKeepAliveDurationMillis(keepAliveDurationMillis)
                    .setExceptionFactory(new BackstageAPIExceptionFactory(objectMapper))
                    .setUserAgentSuffix(userAgent)
                    .setDebug(debug);

            RestAPIClient backstageClient = restAPIClientBuilder.setBaseUrl(baseUrl).setUserAgentPrefix("Backstage").build();
            RestAPIClient authenticationClient = restAPIClientBuilder.setBaseUrl(authBaseUrl).setUserAgentPrefix("Authentication").build();

            BackstageEndpointsFactory endpointsFactory = new BackstageEndpointsRetrofitFactory(backstageClient, authenticationClient);
            BackstageInternalToolsImpl internalTools = new BackstageInternalToolsImpl(endpointsFactory);
            return new Backstage(
                    internalTools,
                    new CampaignsServiceImpl(performClientValidations, endpointsFactory.createEndpoint(BackstageCampaignsEndpoint.class)),
                    new AuthenticationServiceImpl(endpointsFactory.createAuthEndpoint(BackstageAuthenticationEndpoint.class)),
                    new UserServiceImpl(endpointsFactory.createEndpoint(BackstageAccountEndpoint.class)),
                    new CampaignItemsServiceImpl(performClientValidations, endpointsFactory.createEndpoint(BackstageCampaignItemsEndpoint.class)),
                    new DictionaryServiceImpl(endpointsFactory.createEndpoint(BackstageDictionaryEndpoint.class)),
                    new ReportsServiceImpl(endpointsFactory.createEndpoint(BackstageMediaReportsEndpoint.class), endpointsFactory.createEndpoint(BackstagePublisherReportsEndpoint.class), internalTools, organizeDynamicColumns),
                    new AccountsServiceImpl(performClientValidations, endpointsFactory.createEndpoint(BackstageAccountEndpoint.class)),
                    new CampaignPostalTargetingServiceImpl(performClientValidations, endpointsFactory.createEndpoint(BackstagePostalTargetingEndpoint.class)),
                    new CampaignAudienceTargetingServiceImpl(performClientValidations, endpointsFactory.createEndpoint(BackstageAudienceTargetingEndpoint.class)),
                    new SharedBudgetServiceImpl(performClientValidations, endpointsFactory.createEndpoint(BackstageSharedBudgetEndpoint.class))
            );
        }

        private void organizeState() {
            if (baseUrl == null) {
                baseUrl = DEFAULT_BACKSTAGE_HOST;
            }

            if (authBaseUrl == null) {
                authBaseUrl = DEFAULT_AUTH_BACKSTAGE_HOST;
            }

            if (userAgent == null) {
                userAgent = DEFAULT_USER_AGENT;
            }

            if (performClientValidations == null) {
                performClientValidations = true;
            }

            if (serializationConfig == null) {
                serializationConfig = DEFAULT_SERIALIZATION_CONFIG;
            }
        }
    }
}
