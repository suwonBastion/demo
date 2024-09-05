package com.example.demo.webclient;

import com.example.demo.exception.BaseException;
import com.example.demo.util.TokenUtils;
import com.example.demo.webclient.dto.NaverAPIDto;
import com.example.demo.webclient.dto.ProductBrandDto;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.servlet.View;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Component
@Slf4j
@RequiredArgsConstructor
public class NaverAPI {
    private final TokenUtils tokenUtils;

    private WebClient webClientForToken;
    private WebClient webClient;
    private static String accessToken;


    @PostConstruct
    public void init() {
        this.webClientForToken =
                WebClient.builder()
                        .baseUrl("https://api.commerce.naver.com/")
                        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                        .build();

        this.webClient =
                WebClient.builder()
                        .baseUrl("https://api.commerce.naver.com/")
                        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .filter((request, next) -> {
                            System.out.println("Sending request to: " + request.url());
                            return next.exchange(request);
                        })
                        .build();
    }

    public NaverAPIDto getAccessToken() {
        NaverAPIDto dto = webClientForToken.post()
                .uri("external/v1/oauth2/token")
                .bodyValue(tokenUtils.getAccessToken())
                .retrieve()
                .onStatus(status -> status.is4xxClientError() || status.is5xxServerError(),
                        response -> response.bodyToMono(String.class)
                                .flatMap(errorMsg -> {
                                    log.error("NAVER API 서버오류 : {}", errorMsg);
                                    return Mono.error(new BaseException(HttpStatus.BAD_REQUEST, 400, "NAVER API 서버오류"));
                                }))
                .bodyToMono(NaverAPIDto.class)
                .timeout(Duration.ofSeconds(2))
                .block();

        accessToken = Objects.requireNonNull(dto).accessToken();

        return dto;
    }

    public <T> T getList(String uri, MultiValueMap map, ParameterizedTypeReference<T> t) {
        String token = "Bearer " + accessToken;
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(uri)
                        .queryParams(map)
                        .build()
                )
                .header("Authorization", token)
                .retrieve()
                .bodyToMono(t)
                .retry(1)
                .block();
    }

    public <T> T getT(String uri, MultiValueMap map, Class<T> t) {
        String token = "Bearer " + accessToken;

        URI url = UriComponentsBuilder.fromHttpUrl("https://api.commerce.naver.com/"+uri+"?from=2024-06-07T19%3A00%3A00.000%2B09%3A00&rangeType=PAYED_DATETIME")
                .build(true)
                .toUri();

        return webClient.get()
                .uri(url)
                .header("Authorization", token)
                .retrieve()
                .bodyToMono(t)
                .retry(1)
                .block();
    }

}
