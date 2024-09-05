package com.example.demo.webclient;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.codec.xml.Jaxb2XmlDecoder;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@Slf4j
@RequiredArgsConstructor
public class XmlTestAPI {
    private WebClient webClient;

    @PostConstruct
    public void init() {
        this.webClient =
                WebClient.builder()
                        .exchangeStrategies(
                            ExchangeStrategies.builder()
                                    .codecs(configurer ->
                                            configurer.defaultCodecs().jaxb2Decoder(new Jaxb2XmlDecoder()))
                                    .build()
                        )
                        .baseUrl("http://localhost:8080/")
                        .build();
    }

    public <T> T get(String uri, Class<T> t) {
        return webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(t)
                .retry(1)
                .block();
    }
}
