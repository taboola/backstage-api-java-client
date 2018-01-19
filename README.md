## Backstage API Java Client

### Table of Contents
1. [Getting Started](#1-getting-started)
2. [Full Example - Create first campaign and item ](#2-full-example---create-first-campaign-and-item)

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