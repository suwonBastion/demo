package com.example.demo;

import com.example.demo.entity.Token;
import com.example.demo.repository.TokenRepo;
import com.example.demo.util.JwtTokenProvider;
import com.example.demo.util.TokenUtils;
import com.example.demo.webclient.godomall.dto.DeliveryStatusDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Map;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	TokenRepo tokenRepo;
	@Resource(name = "redisTemplate")
	private ValueOperations<String, String> valueOps;
	@Autowired
	JwtTokenProvider jwtTokenProvider;
	@Autowired
	TokenUtils tokenUtils;


	@Test
	void contextLoads() {
		valueOps.set("hello", "world");
		System.out.println(valueOps.get("hello"));
	}

	@Test
	void test(){
		Token token = new Token("park","asdasdd","qqqqqqq");
		tokenRepo.save(token);
		Token token1 = tokenRepo.findById("park").orElseThrow(() -> new RuntimeException("검색결과없음"));
		System.out.println(token1);
	}
	@Test
	void test2(){
		System.out.println(jwtTokenProvider.createToken());
	}

	@Test
	void test3(){
		String method = "GET";
		String path = "/v2/providers/seller_api/apis/api/v1/marketplace/meta/category-related-metas/display-category-codes/77723";
		System.out.println(jwtTokenProvider.createCoupangAuth(method,path));
	}

	@Test
	void test4(){
		String date = "2024-09-02T14:53:04.799+09:00";
		String replace = date.replace(":", "%3A");
		replace = replace.replace("+","%2B");
		System.out.println(replace);
	}

	@Test
	void test5(){
		ObjectMapper mapper = new ObjectMapper();
		DeliveryStatusDto dto = new DeliveryStatusDto(
		123,"123123","p1", "","","",""
				,"","","","",""
		);
		Map<String,Object> map = mapper.convertValue(dto, Map.class);

		MultiValueMap<String, Object> multiValueMap = new LinkedMultiValueMap<>();

		map.entrySet().forEach(entry -> {
			multiValueMap.add(entry.getKey(), entry.getValue());
		});

		multiValueMap.add("partner_key", tokenUtils.getGODOMALL_PARTNER());
		multiValueMap.add("key", tokenUtils.getGODOMALL_USER());

		System.out.println(multiValueMap);
	}

}
