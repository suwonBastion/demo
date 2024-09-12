package com.example.demo.util;

import com.example.demo.dto.godomall.OrderSearchDetail;
import com.example.demo.webclient.godomall.dto.OrderSearchDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
@Slf4j
public class GodomallUtils {
    private final TokenUtils tokenUtils;
    private static final ObjectMapper mapper = new ObjectMapper();

    public MultiValueMap<String, Object> createGodomallMap(OrderSearchDetail param) {
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("partner_key", tokenUtils.getGODOMALL_PARTNER());
        map.add("key", tokenUtils.getGODOMALL_USER());
        map.add("startDate", param.getStartDate());
        map.add("endDate", param.getEndDate());
        map.add("orderStatus", param.getOrderStatus());
        if (!param.getOrderNo().isEmpty()) map.add("orderNo", param.getOrderNo());

        return map;
    }

    public <T> MultiValueMap<String, Object> createGodomallMap(T param) {
        Map<String, Object> map = mapper.convertValue(param, Map.class);
        MultiValueMap<String, Object> multiValueMap = new LinkedMultiValueMap<>();

        map.forEach(multiValueMap::add);

        multiValueMap.add("partner_key", tokenUtils.getGODOMALL_PARTNER());
        multiValueMap.add("key", tokenUtils.getGODOMALL_USER());

        return multiValueMap;
    }

    public MultiValueMap<String, Object> createGodomallMap(List<OrderSearchDto.OrderData.OrderGoodsData> data) {

        StringBuilder sno = new StringBuilder();

        data.forEach(orderGoodsData -> sno.append(orderGoodsData.getSno()));

        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("partner_key", tokenUtils.getGODOMALL_PARTNER());
        map.add("key", tokenUtils.getGODOMALL_USER());
        map.add("orderNo", data.getFirst().getOrderNo());
        map.add("sno", sno.substring(0, sno.length() - 1));
        map.add("orderStatus", "g1");

        return map;
    }

}
