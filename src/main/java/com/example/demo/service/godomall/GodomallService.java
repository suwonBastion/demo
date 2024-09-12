package com.example.demo.service.godomall;

import com.example.demo.dto.OrderSearchRes;
import com.example.demo.dto.godomall.OrderSearchDetail;
import com.example.demo.util.GodomallUtils;
import com.example.demo.webclient.godomall.GodomallAPI;
import com.example.demo.webclient.godomall.dto.DeliveryStatusDto;
import com.example.demo.webclient.godomall.dto.OrderSearchDto;
import com.example.demo.webclient.godomall.dto.OrderStatusDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.demo.path.ApiPaths.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class GodomallService {
    private final GodomallAPI godomallAPI;
    private final GodomallUtils godomallUtils;

    public ResponseEntity<?> orderSearch(OrderSearchDetail param) {
        if (param.getOrderStatus() == null) param.setOrderStatus("p1");

        OrderSearchDto orderSearchDto =
                godomallAPI.post(
                        GODOMALL_ORDER_SEARCH,
                        godomallUtils.createGodomallMap(param),
                        OrderSearchDto.class
                );

        //필요한 필드만 response. Dto로 Convert.
        List<OrderSearchRes> orderSearchRes = convertToOrderSearchRes(orderSearchDto);

        //주문상태변경(결재완료->상품준비중) API Request 요청 (테스트필요. 테스트환경 없음)
//        List<OrderStatusDto> orderSearchDtos = orderStatusUpdate(orderSearchDto);

        return ResponseEntity.ok(orderSearchRes);
    }

    public ResponseEntity<?> deliveryStatus(@Valid DeliveryStatusDto param) {
        OrderStatusDto res =
                godomallAPI.post(
                        GODOMALL_ORDER_STATUS,
                        godomallUtils.createGodomallMap(param),
                        OrderStatusDto.class
                );

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

    private List<OrderSearchRes> convertToOrderSearchRes(OrderSearchDto orderSearchDto) {
        List<OrderSearchRes> results = new ArrayList<>();
        //NPE VALID
        if (orderSearchDto.getOrderSearchReturn().getOrderData() == null) {
            return results;
        }

        orderSearchDto.getOrderSearchReturn().getOrderData().forEach(orderData -> {
            orderData.getOrderGoodsData().forEach(orderGoodsData -> {
                results.add(OrderSearchRes.createOrderSearchRes(orderSearchDto, orderData, orderGoodsData));
            });
        });

        return results;
    }

}
