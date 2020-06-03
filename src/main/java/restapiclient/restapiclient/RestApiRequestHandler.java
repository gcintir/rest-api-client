package restapiclient.restapiclient;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import java.util.Map;

public interface RestApiRequestHandler {

    <T> T sendRequest(String url, HttpMethod httpMethod, Class<T> responseType) throws RestApiRequestHandlerException;
    <T> T sendRequest(String url, HttpMethod httpMethod, ParameterizedTypeReference<T> responseType) throws RestApiRequestHandlerException;

    <T> T sendRequest(String url, HttpMethod httpMethod, HttpHeaders requestHeaders, Class<T> responseType) throws RestApiRequestHandlerException;
    <T> T sendRequest(String url, HttpMethod httpMethod, HttpHeaders requestHeaders, ParameterizedTypeReference<T> responseType) throws RestApiRequestHandlerException;

    <T> T sendRequest(String url, HttpMethod httpMethod, Map<String, String> requestHeaderParametersMap, Class<T> responseType) throws RestApiRequestHandlerException;
    <T> T sendRequest(String url, HttpMethod httpMethod, Map<String, String> requestHeaderParametersMap, ParameterizedTypeReference<T> responseType) throws RestApiRequestHandlerException;

    <T> T sendRequest(String url, HttpMethod httpMethod, HttpHeaders requestHeaders, Object requestBody, Class<T> responseType) throws RestApiRequestHandlerException;
    <T> T sendRequest(String url, HttpMethod httpMethod, HttpHeaders requestHeaders, Object requestBody, ParameterizedTypeReference<T> responseType) throws RestApiRequestHandlerException;

    <T> T sendRequest(String url, HttpMethod httpMethod, Map<String, String> requestHeaderParametersMap, Object requestBody, Class<T> responseType) throws RestApiRequestHandlerException;
    <T> T sendRequest(String url, HttpMethod httpMethod, Map<String, String> requestHeaderParametersMap, Object requestBody, ParameterizedTypeReference<T> responseType) throws RestApiRequestHandlerException;

}
