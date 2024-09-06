package com.example.demo.service.godomall;

import com.example.demo.util.TokenUtils;
import com.example.demo.webclient.godomall.GodomallAPI;
import com.example.demo.webclient.godomall.dto.OrderSearchDto;
import com.example.demo.webclient.godomall.dto.OrderSearchParam;
import com.example.demo.webclient.godomall.dto.OrderStatusDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.ArrayList;
import java.util.List;

import static com.example.demo.path.ApiPaths.*;
import static com.example.demo.webclient.godomall.dto.OrderSearchDto.*;
import static com.example.demo.webclient.godomall.dto.OrderSearchDto.OrderData.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class GodomallService {
    private final GodomallAPI godomallAPI;
    private final TokenUtils tokenUtils;

    public ResponseEntity<?> orderSearch(OrderSearchParam param) {
        OrderSearchDto orderSearchDto =
                godomallAPI.post(GODOMALL_ORDER_SEARCH, createGodomallMap(param), OrderSearchDto.class);

        //주문상태변경(결재완료->상품준비중) API Request 요청 (테스트필요. 테스트환경 없음)
//        List<OrderSearchDto> orderSearchDtos = orderStatusUpdate(orderSearchDto);

        return ResponseEntity.ok(orderSearchDto);
    }









    /////////////////////////////////////////////// private //////////////////////////////////////////////////

    private MultiValueMap<String, Object> createGodomallMap(OrderSearchParam param) {
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("partner_key", tokenUtils.getGODOMALL_PARTNER());
        map.add("key", tokenUtils.getGODOMALL_USER());
        map.add("startDate", param.startDate());
        map.add("endDate", param.endDate());
        map.add("orderStatus", param.orderStatus());
        if (!param.orderNo().isEmpty()) map.add("orderNo", param.orderNo());

        return map;
    }

    private MultiValueMap<String, Object> createGodomallMap(List<OrderGoodsData> data) {

        StringBuilder sno = new StringBuilder();

        for (OrderGoodsData orderGoodsData : data) {
            sno.append(orderGoodsData.getSno()).append("|");
        }

        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("partner_key", tokenUtils.getGODOMALL_PARTNER());
        map.add("key", tokenUtils.getGODOMALL_USER());
        map.add("orderNo", data.getFirst().getOrderNo());
        map.add("sno", sno.substring(0,sno.length()-1));
        map.add("orderStatus", "g1");

        return map;
    }

    private List<OrderSearchDto> orderStatusUpdate(OrderSearchDto orderSearchDto) {
        List<OrderSearchDto> dtoList = new ArrayList<>();

        orderSearchDto.getOrderSearchReturn().getOrderData().forEach(orderData -> {
            OrderSearchDto response =
                    godomallAPI.post(
                            GODOMALL_ORDER_STATUS,
                            createGodomallMap(orderData.getOrderGoodsData()),
                            OrderSearchDto.class
                    );
            dtoList.add(response);
        });

        return dtoList;
    }
}
