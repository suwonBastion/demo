package com.example.demo.service.godomall;

import com.example.demo.util.GodomallUtils;
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

import java.util.ArrayList;
import java.util.List;

import static com.example.demo.path.ApiPaths.*;
import static com.example.demo.webclient.godomall.dto.OrderSearchDto.*;

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
        List<OrderData> test = orderSearchDto.getOrderSearchReturn().getOrderData();
        System.out.println("주문일자 : " + test.get(0).getOrderDate());
        System.out.println("주문번호 : " + test.get(0).getOrderNo());
        System.out.println("주문자 / 수령자 : " + test.get(0).getOrderInfoData().getOrderName() + " / " + test.get(0).getOrderInfoData().getReceiverName());
        System.out.println("상품 : " + test.get(0).getOrderGoodsNm());
        System.out.println("수량 : " + test.get(0).getOrderGoodsCnt());
        System.out.println("상세요구사항 : " + test.get(0).getOrderInfoData().getOrderMemo());

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
