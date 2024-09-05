package com.example.demo.webclient.godomall;

import com.example.demo.util.TokenUtils;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.codec.xml.Jaxb2XmlDecoder;
import org.springframework.http.codec.xml.Jaxb2XmlEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
@Slf4j
public class GodomallAPI {
    private final TokenUtils tokenUtils;

    private WebClient webClient;

    @PostConstruct
    public void init() {
        this.webClient =
                WebClient.builder()
                        .exchangeStrategies(
                                ExchangeStrategies.builder()
                                        .codecs(configurer -> {
                                                    configurer.defaultCodecs().jaxb2Decoder(new Jaxb2XmlDecoder());
                                                    configurer.defaultCodecs().maxInMemorySize(-1);
                                                }
                                        )
                                        .build()
                        )
                        .baseUrl("https://openhub.godo.co.kr/")
                        .build();
    }

    public <T> T get(String uri, MultiValueMap map, Class<T> t) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(uri)
                        .queryParams(map)
                        .build()
                )
                .retrieve()
                .bodyToMono(t)
                .retry(1)
                .block();
    }
}
