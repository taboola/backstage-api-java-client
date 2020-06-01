package com.taboola.backstage.internal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taboola.backstage.exceptions.BackstageAPIConnectivityException;
import com.taboola.backstage.exceptions.BackstageAPIRequestException;
import com.taboola.backstage.exceptions.BackstageAPIUnauthorizedException;
import com.taboola.backstage.model.APIError;
import okhttp3.ResponseBody;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * Created by vladi
 * Date: 11/19/2017
 * Time: 11:53 PM
 * By Taboola
 */
public class SynchronousCallAdapterFactory  extends CallAdapter.Factory {

    private static final Logger logger = LogManager.getLogger(SynchronousCallAdapterFactory.class);
    private static final int UNAUTHORIZED_HTTP_STATUS_CODE = 401;
    private static final int BAD_REQUEST_HTTP_STATUS_CODE = 400;
    private static final int INTERNAL_SERVER_ERROR_HTTP_STATUS_CODE = 500;

    private final ObjectMapper objectMapper;

    public static SynchronousCallAdapterFactory create(ObjectMapper objectMapper) {
        return new SynchronousCallAdapterFactory(objectMapper);
    }

    private SynchronousCallAdapterFactory(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public CallAdapter<Object, Object> get(final Type returnType, Annotation[] annotations, Retrofit retrofit) {
        if (returnType instanceof Call ||
            returnType.toString().contains("retrofit2.Call")) {

            return null;
        }

        return new CallAdapter<Object, Object>() {
            @Override
            public Type responseType() {
                return returnType;
            }

            @Override
            public Object adapt(Call<Object> call) {
                Object obj;
                try {
                    Response<Object> response = call.execute();
                    if(response.isSuccessful()) {
                        obj = response.body();
                    } else {
                        int responseCode = response.code();
                        if(responseCode == UNAUTHORIZED_HTTP_STATUS_CODE) {
                            throw new BackstageAPIUnauthorizedException(safeCreateCauseException(response));

                        } else if(responseCode >= BAD_REQUEST_HTTP_STATUS_CODE && responseCode < INTERNAL_SERVER_ERROR_HTTP_STATUS_CODE) {
                            throw new BackstageAPIRequestException(responseCode, normalizeError(parseError(response)));
                        }

                        throw new BackstageAPIConnectivityException(safeCreateCauseException(response), responseCode);
                    }

                } catch (IOException e) {
                    logger.error(e);
                    throw new BackstageAPIConnectivityException(e);
                }

                return obj;
            }
        };
    }

    private IOException safeCreateCauseException(Response<Object> response) {
        try {
            return new IOException(response.errorBody().string());
        } catch (Throwable t) {
            logger.warn("Failed to parse API error response", t);
            return new IOException("Failed to parse API error response", t);
        }
    }

    private APIError parseError(Response errorResponse) {
        ResponseBody errorBody = errorResponse.errorBody();
        try {
            return objectMapper.readValue(errorBody.bytes(), APIError.class);
        } catch (Throwable e) {
            logger.warn("Failed to parse API error response object [{}]", errorResponse.message());
            return new APIError(errorResponse.message(), errorResponse.code());
        }
    }

    APIError normalizeError(APIError error) {
        String message = error.getMessage();
        if(message != null) {
            error.setMessage(message.replaceAll("%", "%%"));
        }

        return error;
    }
}
