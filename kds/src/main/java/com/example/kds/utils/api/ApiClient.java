package com.example.kds.utils.api;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Component
public class ApiClient {
    private final RestTemplate restTemplate = new RestTemplate();

    public <T> CompletableFuture<T> get(int index) {
        return CompletableFuture.supplyAsync(() -> {
            Object res = this.restTemplate.getForObject("https://www.swapi.tech/api/people/" + index, Object.class);
            return (T) res;
        });
    }
}
