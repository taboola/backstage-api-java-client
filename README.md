## Backstage API Java Client

### Table of Contents
1. [Getting Started](#1-getting-started)
2. [Full Example - Read campaign items ](#2-full-example---read-campaign-items)

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


## 2. Full Example - Read campaign items 
```
Backstage backstage = Backstage.builder().build();

try {
    //establish authentication
    BackstageAuthentication clientAuth = backstage.authenticationService().clientCredentials("your_client_id...", "your_client_secret...");
    
    //know your account ID in advance or by fetching token details
    //how to: String accountId = backstage.authenticationService().getTokenDetails(clientAuth).getAccountId();
    String accountId = "your_account_id";
    
    //get all your account campaigns
    Results<Campaign> campaignResults = backstage.campaignsService().read(clientAuth, accountId);
    
    //get all your campaign items
    for(Campaign currCampaign : campaignResults.getResults()) {
        Results<CampaignItem> campaignItemResults = backstage.campaignItemsService().readItems(clientAuth, accountId, currCampaign.getId());
        //do something with campaign item...
    }
    
} catch (BackstageAPIUnauthorizedException e) {
    //handle HTTP status 401 : token is expired or bad credentials
    
} catch (BackstageAPIConnectivityException e) {
    //handle connectivity issues
    
} catch (BackstageAPIRequestException e) {
    //handle HTTP status 400 : bad request
}
```

