package com.example.demo.service.godomall;

import com.example.demo.util.GodomallUtils;
import com.example.demo.util.TokenUtils;
import com.example.demo.webclient.godomall.GodomallAPI;
import com.example.demo.webclient.godomall.dto.DeliveryStatusDto;
import com.example.demo.webclient.godomall.dto.OrderSearchDto;
import com.example.demo.webclient.godomall.dto.OrderSearchParam;
import com.example.demo.webclient.godomall.dto.OrderStatusDto;
import jakarta.validation.Valid;
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
    private final GodomallUtils godomallUtils;

    public ResponseEntity<?> orderSearch(OrderSearchParam param) {
        OrderSearchDto orderSearchDto =
                godomallAPI.post(GODOMALL_ORDER_SEARCH, godomallUtils.createGodomallMap(param), OrderSearchDto.class);

        //주문상태변경(결재완료->상품준비중) API Request 요청 (테스트필요. 테스트환경 없음)
//        OrderStatusDto orderSearchDtos = orderStatusUpdate(orderSearchDto);

        return ResponseEntity.ok(orderSearchDto);
    }

    public ResponseEntity<?> deliveryStatus(@Valid DeliveryStatusDto param) {
        OrderStatusDto res =
                godomallAPI.post(GODOMALL_ORDER_STATUS, godomallUtils.createGodomallMap(param), OrderStatusDto.class);

        return ResponseEntity.ok(res);
    }




    /////////////////////////////////////////////// private //////////////////////////////////////////////////

    private List<OrderStatusDto> orderStatusUpdate(OrderSearchDto orderSearchDto) {
        List<OrderStatusDto> dtoList = new ArrayList<>();

        orderSearchDto.getOrderSearchReturn().getOrderData().forEach(orderData -> {
            OrderStatusDto response =
                    godomallAPI.post(
                            GODOMALL_ORDER_STATUS,
                            godomallUtils.createGodomallMap(orderData.getOrderGoodsData()),
                            OrderStatusDto.class
                    );
            dtoList.add(response);
        });

        return dtoList;
    }

}
