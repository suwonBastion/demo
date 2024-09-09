package com.example.demo.webclient.godomall.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record OrderSearchParam(
        @Schema(description = "검색시작일", example = "2024-09-06")
        @NotBlank(message = "startDate가 없습니다")
        String startDate,
        @Schema(description = "검색종료일", example = "2024-09-07")
        @NotBlank
        String endDate,
        @Schema(description = "주문번호(없으면 공백으로)", example = " ")
        @NotNull
        String orderNo,
        @Schema(description = "주문상태", example = "g1")
        @NotBlank(message = "orderStatus가 없습니다.")
        String orderStatus
) {
}
