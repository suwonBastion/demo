package com.example.demo.webclient.godomall.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record OrderSearchParam(
        @NotBlank(message = "startDate가 없습니다")
        String startDate,
        @NotBlank
        String endDate,
        @NotNull
        String orderNo,
        @NotBlank(message = "orderStatus가 없습니다.")
        String orderStatus
) {
}
