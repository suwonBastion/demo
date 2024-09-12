package com.example.demo.util;

import com.example.demo.webclient.dto.NaverAPIDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
@RequiredArgsConstructor
@Slf4j
@Getter
public class TokenUtils {

    @Value("${jonsoft.naver.clientid}")
    private String NAVER_CLIENTID;
    @Value("${jonsoft.naver.secret}")
    private String NAVER_CLIENT_SECRET;
    @Value("${jonsoft.godomall.sun.partner}")
    private String GODOMALL_PARTNER;
    @Value("${jonsoft.godomall.sun.user}")
    private String GODOMALL_USER;
    @Value("${jonsoft.esm.masterid}")
    private String ESM_MASTERID;
    @Value("${jonsoft.esm.gmarketid}")
    private String ESM_GMARKETID;
    @Value("${jonsoft.esm.auctionid}")
    private String ESM_AUCTIONID;
    @Value("${jonsoft.esm.secret}")
    private String ESM_SECRET;
    @Value("${jonsoft.coupang.access}")
    private String COUPANG_ACCESSKEY;
    @Value("${jonsoft.coupang.secret}")
    private String COUPANG_SECRETKEY;

    public MultiValueMap createMultiValueMap(String sign, Long timestamp) {
        MultiValueMap map = new LinkedMultiValueMap();
        map.add("client_id", NAVER_CLIENTID);
        map.add("client_secret_sign", sign);
        map.add("timestamp", String.valueOf(timestamp));
        map.add("grant_type", "client_credentials");
        map.add("type", "SELF");

        return map;
    }

    public MultiValueMap getAccessToken() {

        long l = System.currentTimeMillis();

        String result =
                Base64.getUrlEncoder()
                        .encodeToString(BCrypt.hashpw(StringUtils.joinWith("_", NAVER_CLIENTID, l), NAVER_CLIENT_SECRET)
                                .getBytes(StandardCharsets.UTF_8));

        return createMultiValueMap(result, l);
    }


}
