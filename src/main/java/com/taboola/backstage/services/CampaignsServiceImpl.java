package com.taboola.backstage.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taboola.backstage.exceptions.BackstageAPIConnectivityException;
import com.taboola.backstage.exceptions.BackstageAPIRequestException;
import com.taboola.backstage.exceptions.BackstageAPIUnauthorizedException;
import com.taboola.backstage.model.APIError;
import com.taboola.backstage.model.Results;
import com.taboola.backstage.model.auth.BackstageAuthentication;
import com.taboola.backstage.model.media.campaigns.Campaign;
import com.taboola.backstage.internal.BackstageCampaignsEndpoint;
import com.taboola.backstage.model.media.campaigns.CampaignBase;
import com.taboola.backstage.model.media.campaigns.CampaignOperation;
import com.taboola.backstage.model.media.campaigns.CampaignPatch;
import com.taboola.backstage.model.media.campaigns.CampaignTargetingCollection;
import com.taboola.backstage.model.media.campaigns.CampaignsMassiveOperation;
import com.taboola.rest.api.internal.FieldsValidator;
import okhttp3.ResponseBody;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by vladi
 * Date: 10/13/2017
 * Time: 11:37 PM
 * By Taboola
 */
public class CampaignsServiceImpl implements CampaignsService {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final Pattern API_ERROR_TEXT = Pattern.compile(
            "APIError\\(\\s*httpStatus\\s*=\\s*(\\d+)\\s*,\\s*" +
                    "message\\s*=\\s*(.*?),\\s*" +
                    "offendingField\\s*=\\s*(.*?),\\s*" +
                    "messageCode\\s*=\\s*(.*?),\\s*" +
                    "messageCodeEnglishTemplate\\s*=\\s*(.*?),\\s*" +
                    "templateParameters\\s*=\\s*\\[(.*?)]\\s*\\)\\s*",
            Pattern.DOTALL
    );
    private final BackstageCampaignsEndpoint endpoint;
    private final Boolean performValidations;



    public CampaignsServiceImpl(Boolean performValidations, BackstageCampaignsEndpoint endpoint) {
        this.endpoint = endpoint;
        this.performValidations = performValidations;
    }

    @Override
    public Campaign create(BackstageAuthentication auth, String accountId, CampaignOperation campaignOperation) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        if(performValidations) {
            FieldsValidator.validateCreateOperation(campaignOperation);
        }
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.createCampaign(accessToken, accountId, campaignOperation);
    }

    @Override
    public Campaign read(BackstageAuthentication auth, String accountId, String campaignId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.getCampaign(accessToken, accountId, campaignId);
    }

    @Override
    public Results<CampaignBase> readBase(BackstageAuthentication auth, String accountId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.getAllCampaignsBase(accessToken, accountId);
    }

    @Override
    public Results<Campaign> read(BackstageAuthentication auth, String accountId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.getAllCampaigns(accessToken, accountId);
    }

    @Override
    public Campaign update(BackstageAuthentication auth, String accountId, String campaignId, CampaignOperation campaignOperation)
            throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {

        if (performValidations) {
            FieldsValidator.validateUpdateOperation(campaignOperation);
        }

        String accessToken = auth.getToken().getAccessTokenForHeader();

        Response<Campaign> resp = null;
        try {
            resp = endpoint
                    .updateCampaign(accessToken, accountId, campaignId, campaignOperation)
                    .execute();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (!resp.isSuccessful()) {
            APIError apiError = APIError.EMPTY;
            String raw = null;

            try (ResponseBody eb = resp.errorBody()) {
                if (eb != null) {
                    raw = eb.string();
                    try {
                        apiError = parseApiError(raw, resp.code());
                    } catch (Exception ignored) { }
                }
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }

            throw new BackstageAPIRequestException(
                    apiError,
                    "Failed to perform API call with response code [%d]. Raw error: %s",
                    resp.code(),
                    raw
            );
        }

        return resp.body();
    }

    @Override
    public Results<Campaign> updateMassive(BackstageAuthentication auth, String accountId, CampaignsMassiveOperation campaignsMassiveOperation) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        if(performValidations) {
            FieldsValidator.validateUpdateOperation(campaignsMassiveOperation);
        }

        return endpoint.updateMassiveCampaigns(auth.getToken().getAccessTokenForHeader(), accountId, campaignsMassiveOperation);
    }

    @Override
    public Campaign duplicate(BackstageAuthentication auth, String accountId, String campaignId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        return endpoint.duplicateCampaign(auth.getToken().getAccessTokenForHeader(), accountId, campaignId);
    }

    @Override
    public Campaign duplicate(BackstageAuthentication auth, String accountId, String campaignId, CampaignOperation campaignOperation) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        return endpoint.duplicateCampaign(auth.getToken().getAccessTokenForHeader(), accountId, campaignId,  campaignOperation);
    }

    @Override
    public CampaignPatch patch(BackstageAuthentication auth, String accountId, String campaignId, CampaignPatch campaignPatch) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        if(performValidations) {
            FieldsValidator.validateCreateOperation(campaignPatch);
        }
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.patchCampaign(accessToken, accountId, campaignId, campaignPatch);
    }

    @Override
    public Campaign delete(BackstageAuthentication auth, String accountId, String campaignId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.deleteCampaign(accessToken, accountId, campaignId);
    }

    @Override
    public CampaignTargetingCollection<String> readTargetingWhiteList(BackstageAuthentication auth, String accountId, String campaignId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.getCampaignTargetingWhiteList(accessToken, accountId, campaignId);
    }

    public static APIError parseApiError(String raw, int fallbackHttpStatus) {
        if (raw == null || raw.isEmpty()) {
            APIError e = new APIError();
            e.setHttpStatus(fallbackHttpStatus);
            e.setMessage(null);
            e.setTemplateParameters(Collections.emptyList());
            return e;
        }

        String trimmed = raw.trim();

        if (trimmed.startsWith("{") || trimmed.startsWith("[")) {
            try {
                return MAPPER.readValue(trimmed, APIError.class);
            }
            catch (Exception ignore) { }
        }

        Matcher m = API_ERROR_TEXT.matcher(trimmed);
        if (m.find()) {
            APIError e = new APIError();
            e.setHttpStatus(parseIntSafe(m.group(1), fallbackHttpStatus));
            e.setMessage(nullIfLiteralNull(clean(m.group(2))));
            e.setOffendingField(nullIfLiteralNull(clean(m.group(3))));
            e.setMessageCode(nullIfLiteralNull(clean(m.group(4))));
            e.setMessageCodeEnglishTemplate(nullIfLiteralNull(clean(m.group(5))));
            e.setTemplateParameters(parseParams(m.group(6)));
            return e;
        }

        APIError e = new APIError();
        e.setHttpStatus(fallbackHttpStatus);
        e.setMessage(trimmed);
        e.setTemplateParameters(Collections.emptyList());
        return e;
    }

    private static Integer parseIntSafe(String s, int fallback) {
        try { return Integer.parseInt(s.trim()); } catch (Exception ex) { return fallback; }
    }

    private static String nullIfLiteralNull(String s) {
        if (s == null) return null;
        String t = s.trim();
        return "null".equalsIgnoreCase(t) ? null : t;
    }

    private static String clean(String s) {
        if (s == null) return null;
        String t = s.trim();
        if ((t.startsWith("\"") && t.endsWith("\"")) || (t.startsWith("'") && t.endsWith("'"))) {
            return t.substring(1, t.length()-1);
        }
        return t;
    }

    private static List<String> parseParams(String insideBrackets) {
        if (insideBrackets == null) return Collections.emptyList();
        String t = insideBrackets.trim();
        if (t.isEmpty()) return Collections.emptyList();
        String[] parts = t.split(",");
        List<String> out = new ArrayList<>(parts.length);
        for (String p : parts) {
            String v = clean(p);
            if (v != null && !v.isEmpty()) out.add(v);
        }
        return out;
    }
}
