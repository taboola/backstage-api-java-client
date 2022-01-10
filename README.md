## Backstage API Java Client

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.taboola/backstage-api-java-client/badge.svg?style=plastic)](https://maven-badges.herokuapp.com/maven-central/com.taboola/backstage-api-java-client)
[![Build Status](https://travis-ci.com/taboola/backstage-api-java-client.svg?branch=master)](https://travis-ci.com/taboola/backstage-api-java-client)

### Table of Contents
1. [Getting Started](#1-getting-started)
2. [Full Example - Create first campaign and item ](#2-full-example---create-first-campaign-and-item)
3. [Authentication](#3-authentication)
4. [Exceptions](#4-exceptions)
5. [Custom endpoints](#5-custom-endpoints)
6. [Usage](#6-usage)

### Intro
The Taboola Backstage API allow you to manage your campaign, items and view reports.
This Java client is based on Taboola Backstage API v1.0.

Please refer to the Taboola Backstage API documentation for more details.

## 1. Getting Started


### 1.1 Perform Authentication
First you will need _BackstageAuthentication.java_ object
```
Backstage backstage = Backstage.builder().build();

BackstageAuthentication clientAuth = backstage.authenticationService()
                                              .clientCredentials("your_client_id", "your_client_secret");
```

### 1.2 Perform API call using services
Once you have _BackstageAuthentication.java_ object you will be able to perform all 
API calls by using services which can be found on _Backstage.java_ object
```
String myAccountId = backstage.authenticationService().getTokenDetails(clientAuth).getAccountId();
backstage.campaignsService().read(clientAuth, myAccountId);
```


## 2. Full Example - Create first campaign and item
```
// Backstage instance should be singleton, its creation is costy 
Backstage backstage = Backstage.builder().build();

try {
    //establish authentication
    BackstageAuthentication clientAuth = backstage.authenticationService()
                                                  .clientCredentials("your_client_id...", "your_client_secret...");

    //know your account ID in advance or by fetching it
    //how to get user's assigned account: String accountId = backstage.authenticationService().getTokenDetails(clientAuth).getAccountId();
    //how to get user's all allowed accounts: Results<Account> myAccounts = backstage.userService().readAllowedAccounts(clientAuth);
    String accountId = "your_account_id";

    //configure campaign
    CampaignOperation createCampaignOperation = CampaignOperation.create()
                                                    .setName("My Campaign")
                                                    .setStartDate(new Date())
                                                    .setCpc(1.0d)
                                                    .setBrandingText("My Branding Text")
                                                    .setSpendingLimit(100d)
                                                    .setSpendingLimitModel(SpendingLimitModel.ENTIRE);

    //create campaign
    Campaign campaign = backstage.campaignsService().create(clientAuth, accountId, createCampaignOperation);

    //configure item
    CampaignItemOperation campaignItemOperation = CampaignItemOperation.create()
                                                    .setUrl("http://www.example.com");

    //create item
    CampaignItem item = backstage.campaignItemsService().createItem(clientAuth, accountId,
                                                                    campaign.getId(), campaignItemOperation);

    //polling until Taboola crawler done crawling our supplied URL
    while(ItemStatus.CRAWLING.equals(item.getStatus())) {
        Thread.sleep(10_000L);
        item = backstage.campaignItemsService().readItem(clientAuth, accountId, campaign.getId(), item.getId());
    }

    //item done crawling, do something...

} catch (BackstageAPIUnauthorizedException e) {
    logger.warn("Token is expired or bad credentials", e);
} catch (BackstageAPIRequestException e) {
    logger.warn("Bad request", e);
} catch (BackstageAPIConnectivityException e) {
    logger.warn("Connectivity issues", e);
}
```

### 3. Authentication

Supports:
1. CLIENT_CREDENTIALS
2. PASSWORD_AUTHENTICATION

Authentication service can be found under Backstage instance, see below:
```
Backstage backstage = Backstage.builder().build();
AuthenticationService authService = backstage.authenticationService();
```

BackstageAuthentication instance is valid 12 hours after its creation. 
In order to re-authenticate the same BackstageAuthentication instance the following can be done:

```
//Assuming you have previously created BackstageAuthentication under the name 'auth'
BackstageAuthentication auth = backstage.authenticationService().reAuthenticate(auth);
``` 

### 4. Exceptions

- **BackstageAPIUnauthorizedException** - Token is expired or bad credentials were supplied (HTTP status 401)
  - Can be resolved by re-authentication or making sure that supplied credentials are correct
- **BackstageAPIRequestException** - Bad request (HTTP status 4xx)
  - Can be resolved by fixing the request to a valid one
- **BackstageAPIConnectivityException** - Connectivity issues (HTTP status 5xx)
  - Can be resolved by retrying or fixing networking issues

### 5. Custom endpoints

If there are unsupported API endpoints or models, SDK provides tools to extend.

To know what is possible when creating endpoints interface please refer to [Retrofit2 documentation](https://square.github.io/retrofit/)

Lets assume following model and endpoint is not present in current running SDK version
```
public class EntityModelExample {
  private String id;
  private String name;

  public String getId() { return id; }
  public void setId(String id) { this.id = id; }
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
}

public interface ExampleNewEndpoint {

    @POST("/{account_id}")
    @Headers("Content-Type: application/json")
    EntityModelExample update(@Header("Authorization") String accessToken,
                             @Path("account_id") String accountId,
                             @Body EntityModelExample entity) throws RestAPIException;
}
```

In order to create interface instance SDK provides endpoint factory tools 

```
// Backstage instance should be singleton, its creation is costy
Backstage backstage = Backstage.builder().build();
BackstageInternalTools tools = backstage.internalTools();
BackstageEndpointsFactory backstageEndpointsFactory = tools.endpointFactory();

...

// Worth saving below instance as singleton as its creation is costy
ExampleNewEndpoint newEndpoint = backstageEndpointsFactory.createEndpoint(ExampleNewEndpoint.class);

// Instance was created, invoke its method
```

### 6. Usage

If your project is built with Maven add following to your pom file:

```
<dependency>
    <groupId>com.taboola</groupId>
    <artifactId>backstage-api-java-client</artifactId>
    <version>x.y.z</version>
</dependency>
```

If your project is built with Gradle add following to your gradle setting file:

```
// https://mvnrepository.com/artifact/com.taboola/backstage-api-java-client
compile group: 'com.taboola', name: 'backstage-api-java-client', version: 'x.y.z'
```

Replace 'x.y.z' with the latest available version from [Maven Central](https://mvnrepository.com/artifact/com.taboola/backstage-api-java-client)