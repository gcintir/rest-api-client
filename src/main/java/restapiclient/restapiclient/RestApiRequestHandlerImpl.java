package restapiclient.restapiclient;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.net.URI;
import java.util.Map;

@Service
@Log4j2
public class RestApiRequestHandlerImpl implements RestApiRequestHandler {

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public <T> T sendRequest(String url, HttpMethod httpMethod, Class<T> responseType) throws RestApiRequestHandlerException {
        return sendRequest(url, httpMethod, new HttpHeaders(), responseType);
    }

    @Override
    public <T> T sendRequest(String url, HttpMethod httpMethod, ParameterizedTypeReference<T> responseType) throws RestApiRequestHandlerException {
        return sendRequest(url, httpMethod, new HttpHeaders(), responseType);
    }

    @Override
    public <T> T sendRequest(String url, HttpMethod httpMethod, Map<String, String> requestHeaderParametersMap, Class<T> responseType) throws RestApiRequestHandlerException {
        HttpHeaders requestHeaders = new HttpHeaders();
        if (null != requestHeaderParametersMap) {
            requestHeaderParametersMap.keySet().stream().forEach(key -> requestHeaders.set(key, requestHeaderParametersMap.get(key)));
        }
        return sendRequest(url, httpMethod, requestHeaders, responseType);
    }

    @Override
    public <T> T sendRequest(String url, HttpMethod httpMethod, Map<String, String> requestHeaderParametersMap, ParameterizedTypeReference<T> responseType) throws RestApiRequestHandlerException {
        HttpHeaders requestHeaders = new HttpHeaders();
        if (null != requestHeaderParametersMap) {
            requestHeaderParametersMap.keySet().stream().forEach(key -> requestHeaders.set(key, requestHeaderParametersMap.get(key)));
        }
        return sendRequest(url, httpMethod, requestHeaders, responseType);
    }

    @Override
    public <T> T sendRequest(String url, HttpMethod httpMethod, Map<String, String> requestHeaderParametersMap, Object requestBody, Class<T> responseType) throws RestApiRequestHandlerException {
        if (null == requestBody)
            return sendRequest(url, httpMethod, createRequestHeaders(requestHeaderParametersMap), responseType);
        return sendRequest(url, httpMethod, createRequestHeaders(requestHeaderParametersMap), requestBody, responseType);
    }

    @Override
    public <T> T sendRequest(String url, HttpMethod httpMethod, Map<String, String> requestHeaderParametersMap, Object requestBody, ParameterizedTypeReference<T> responseType) throws RestApiRequestHandlerException {
        if (null == requestBody)
            return sendRequest(url, httpMethod, createRequestHeaders(requestHeaderParametersMap), responseType);
        return sendRequest(url, httpMethod, createRequestHeaders(requestHeaderParametersMap), requestBody, responseType);
    }

    @Override
    public <T> T sendRequest(String url, HttpMethod httpMethod, HttpHeaders requestHeaders, Object requestBody, Class<T> responseType) throws RestApiRequestHandlerException {
        if (null == requestBody)
            return sendRequest(url, httpMethod, requestHeaders, responseType);
        return sendRequest(url, httpMethod, new HttpEntity<>(requestBody, requestHeaders), responseType);
    }

    @Override
    public <T> T sendRequest(String url, HttpMethod httpMethod, HttpHeaders requestHeaders, Object requestBody, ParameterizedTypeReference<T> responseType) throws RestApiRequestHandlerException {
        if (null == requestBody)
            return sendRequest(url, httpMethod, requestHeaders, responseType);
        return sendRequest(url, httpMethod, new HttpEntity<>(requestBody, requestHeaders), responseType);
    }

    @Override
    public <T> T sendRequest(String url, HttpMethod httpMethod, HttpHeaders requestHeaders, Class<T> responseType) throws RestApiRequestHandlerException {
        return sendRequest(url, httpMethod, new HttpEntity<>(requestHeaders), responseType);
    }

    @Override
    public <T> T sendRequest(String url, HttpMethod httpMethod, HttpHeaders requestHeaders, ParameterizedTypeReference<T> responseType) throws RestApiRequestHandlerException {
        return sendRequest(url, httpMethod, new HttpEntity<>(requestHeaders), responseType);
    }

    private <T> T sendRequest(String url, HttpMethod httpMethod, HttpEntity requestEntity, Class<T> responseType) throws RestApiRequestHandlerException {
        try {
            return handleResponseEntity(restTemplate.exchange(URI.create(url), httpMethod, requestEntity, responseType));
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RestApiRequestHandlerException(ex.getMessage());
        }
    }

    private <T> T sendRequest(String url, HttpMethod httpMethod, HttpEntity requestEntity, ParameterizedTypeReference<T> responseType) throws RestApiRequestHandlerException {
        try {
            return handleResponseEntity(restTemplate.exchange(URI.create(url), httpMethod, requestEntity, responseType));
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RestApiRequestHandlerException(ex.getMessage());
        }

    }

    private <T> T handleResponseEntity (ResponseEntity<T> responseEntity) throws RestApiRequestHandlerException {
        log.info("incoming responseEntity --> " + responseEntity);
        if (null == responseEntity)
            throw new RestApiRequestHandlerException("incoming responseEntity is NULL");
        if (HttpStatus.OK != responseEntity.getStatusCode())
            throw new RestApiRequestHandlerException("incoming responseEntity status code is " + responseEntity.getStatusCode());
        if (null == responseEntity.getBody())
            throw new RestApiRequestHandlerException("incoming responseEntity body is NULL");
        return responseEntity.getBody();
    }

    private HttpHeaders createRequestHeaders(Map<String, String> requestHeaderParametersMap) {
        HttpHeaders requestHeaders = new HttpHeaders();
        if (null != requestHeaderParametersMap) {
            requestHeaderParametersMap.keySet().stream().forEach(key -> requestHeaders.set(key, requestHeaderParametersMap.get(key)));
        }
        return requestHeaders;
    }
}
