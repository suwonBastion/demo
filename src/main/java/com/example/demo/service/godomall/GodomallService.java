package com.example.demo.service.godomall;

import com.example.demo.path.ApiPaths;
import com.example.demo.util.TokenUtils;
import com.example.demo.webclient.godomall.GodomallAPI;
import com.example.demo.webclient.godomall.dto.OrderSearchDto;
import com.example.demo.webclient.godomall.dto.OrderSearchParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static com.example.demo.path.ApiPaths.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class GodomallService {
    private final GodomallAPI godomallAPI;
    private final TokenUtils tokenUtils;

    public ResponseEntity<?> orderSearch(OrderSearchParam param) {
        return ResponseEntity.ok(godomallAPI.get(GODOMALL_ORDER_SEARCH, createGodomallMap(param), OrderSearchDto.class));
    }

    private MultiValueMap<String, Object> createGodomallMap(OrderSearchParam param) {
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("partner_key", tokenUtils.getGODOMALL_PARTNER());
        map.add("key", tokenUtils.getGODOMALL_USER());
        map.add("startDate", param.startDate());
        map.add("endDate", param.endDate());
        map.add("orderStatus",param.orderStatus());
        if (!param.orderNo().isEmpty()) map.add("orderNo", param.orderNo());

        return map;
    }
}
