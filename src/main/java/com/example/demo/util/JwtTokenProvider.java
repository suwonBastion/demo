package com.example.demo.util;

import com.coupang.openapi.sdk.Hmac;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {
    private final TokenUtils tokenUtils;

    public String createToken(){
        return Jwts.builder()
                .setHeader(setHeader())
                .setIssuer("www.jonsoft.com")
                .setSubject("sell")
                .setAudience("sa.esmplus.com")
                .claim("ssi",setSsi())
                .signWith(Keys.hmacShaKeyFor(tokenUtils.getESM_SECRET().getBytes(StandardCharsets.UTF_8)), SignatureAlgorithm.HS256)
                .compact();
    }

    public String createCoupangAuth(String method, String path){

        UriComponentsBuilder builder = UriComponentsBuilder.newInstance().path(path);
        return Hmac.generate(method, builder.toUriString(), tokenUtils.getCOUPANG_SECRETKEY(), tokenUtils.getCOUPANG_ACCESSKEY());
    }


    private Map<String,Object> setHeader(){
        Map<String, Object> header = new HashMap<>();
        header.put("typ", "JWT");
        header.put("alg", "HS256");
        header.put("kid","EMS+"+tokenUtils.getESM_MASTERID());
        return header;
    }

    private String setSsi(){
        return String.format("A:%s,G:%s",tokenUtils.getESM_AUCTIONID(),tokenUtils.getESM_GMARKETID());
    }
}
