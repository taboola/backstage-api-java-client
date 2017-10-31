# Backstage API Java Client

### Example - Easy To Use
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
    
} catch (BackstageAPITokenExpiredException e) {
    //handle token is expired
    
} catch (BackstageAPIConnectivityException e) {
    //handle connectivity issues
    
} catch (BackstageAPIRequestException e) {
    //handle bad request
}
```

