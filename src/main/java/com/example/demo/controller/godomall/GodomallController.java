package com.example.demo.controller.godomall;

import com.example.demo.service.godomall.GodomallService;
import com.example.demo.webclient.godomall.dto.DeliveryStatusDto;
import com.example.demo.webclient.godomall.dto.OrderSearchDto;
import com.example.demo.dto.godomall.OrderSearchParam;
import com.example.demo.webclient.godomall.dto.OrderStatusDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/godomall")
@Tag(name = "고도몰 API", description = "고도몰 주문조회,주문상태변경 API 입니다.")
public class GodomallController {
    private final GodomallService godomallService;

    @Operation(summary = "주문수집", description = "결제완료된 주문을 수집함")
    @ApiResponse(responseCode = "200", description = "성공",
    content = {@Content(
            mediaType = "application/json",
            schema = @Schema(implementation = OrderSearchDto.class)
    )})
    @PostMapping("/order-search")
    public ResponseEntity<?> orderSearch(@Valid @RequestBody OrderSearchParam param) {
        return godomallService.orderSearch(param);
    }

    @Operation(summary = "주문상태변경", description = "상품준비중을 배송중으로 변경")
    @ApiResponse(responseCode = "200", description = "성공",
            content = {@Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = OrderStatusDto.class)
            )})
    @PostMapping("/delivery-status")
    public ResponseEntity<?> deliveryStatus(@Valid @RequestBody DeliveryStatusDto param) {
        return godomallService.deliveryStatus(param);
    }
}
