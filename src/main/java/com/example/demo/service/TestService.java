package com.example.demo.service;

import com.example.demo.path.ApiPaths;
import com.example.demo.util.DateUtils;
import com.example.demo.util.TokenUtils;
import com.example.demo.webclient.NaverAPI;
import com.example.demo.webclient.dto.NaverAPIDto;
import com.example.demo.webclient.dto.ProductBrandDto;
import com.example.demo.webclient.dto.ProductOrdersDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import static com.example.demo.path.ApiPaths.*;
import static com.example.demo.util.DateUtils.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class TestService {
    private final NaverAPI naverAPI;
    private final TokenUtils tokenUtils;


    public ResponseEntity<?> test2() {

        NaverAPIDto naverAPIDto = naverAPI.getAccessToken();

        return ResponseEntity.ok(naverAPIDto);
    }

    public ResponseEntity<?> test3(String name) {
        try {

            MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
            map.add("name", name);

            return ResponseEntity.ok(naverAPI.get(PRODUCT, map, bodyListClass(ProductBrandDto.class)));

        } catch (WebClientResponseException e) {

            log.error(e.getMessage());
            log.error(e.getResponseBodyAsString());

            MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
            map.add("name", name);

            return retry("getProductBrands", map);
        }
    }

    public ResponseEntity<?> test4(Map<String, String> rawMap) throws UnsupportedEncodingException {

        String date = convertDate(rawMap.get("from"));
        String rangeType = rawMap.get("rangeType");

        System.out.println(date);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("from", date);
        map.add("rangeType", rangeType);

        try {
            return ResponseEntity.ok(naverAPI.getT(PRODUCT_ORDERS, map, ProductOrdersDto.class));
        } catch (WebClientResponseException e) {
            log.error(e.getMessage());
            log.error(e.getResponseBodyAsString());

            return retry("getConditionProductOrders", map);
        }
    }

    public <T> ResponseEntity<?> retry(String func, T t) {
        naverAPI.getAccessToken();
        switch (func) {
            case "getProductBrands" -> {
                return ResponseEntity.ok(naverAPI.get(PRODUCT, (MultiValueMap) t, bodyListClass(ProductBrandDto.class)));
            }
            case "getConditionProductOrders" -> {
                return ResponseEntity.ok(naverAPI.getT(PRODUCT_ORDERS, (MultiValueMap) t, ProductOrdersDto.class));
            }
        }
        log.error("네이버 서버 오류");
        return null;
    }

    private <T> ParameterizedTypeReference<T> bodyClass(Class<T> clazz) {
        return new ParameterizedTypeReference<T>() {
        };
    }

    private <T> ParameterizedTypeReference<List<T>> bodyListClass(Class<T> clazz) {
        return new ParameterizedTypeReference<List<T>>() {
        };
    }

}
