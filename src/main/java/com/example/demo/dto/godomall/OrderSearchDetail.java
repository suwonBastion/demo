package com.example.demo.dto.godomall;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderSearchDetail {
    @Schema(description = "검색시작일", example = "2024-09-06")
    @NotBlank(message = "startDate가 없습니다")
    private String startDate;
    @Schema(description = "검색종료일", example = "2024-09-07")
    @NotBlank
    private String endDate;
    @Schema(description = "주문번호(없으면 공백으로)", example = " ")
    @NotNull
    private String orderNo;
    @Schema(description = "주문상태", example = "문의바람")
    private String orderStatus;
}
