package com.mikegambino.ApiService.util;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class RestTemplateGetter {
    private final RestTemplate restTemplate;

    public RestTemplateGetter(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public <T> ResponseEntity<T> request(String url, Class<T> cls) {
        return restTemplate.getForEntity(url, cls);
    }

    public <T> ResponseEntity<List<T>> requestList(String url, Class<T> cls) {
        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {}
        );
    }
}
