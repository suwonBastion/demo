package com.example.demo.webclient;

import com.example.demo.util.TokenUtils;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class CoupangAPI {
    private final TokenUtils tokenUtils;

    private WebClient webClient;
    private static String accessToken;


    @PostConstruct
    public void init() {
        this.webClient =
                WebClient.builder()
                        .baseUrl("https://api-gateway.coupang.com/")
                        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .build();
    }

    public <T> T get(String uri, MultiValueMap map, ParameterizedTypeReference<T> t, String token) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(uri)
                        .queryParams(map)
                        .build()
                )
                .header("Authorization", token)
                .retrieve()
                .bodyToMono(t)
                .retry(3)
                .block();
    }
}
