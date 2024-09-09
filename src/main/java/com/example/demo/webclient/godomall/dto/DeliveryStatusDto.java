package com.example.demo.webclient.godomall.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DeliveryStatusDto(
        @Schema(description = "주문번호", example = "20241212....")
        @NotBlank(message = "orderNo가 없습니다")
        int orderNo,
        @Schema(description = "주문상품번호", example = "22|23|24 (구분자'|') ")
        @NotBlank(message = "sno가 없습니다")
        String sno,
        @Schema(description = "주문상태", example = "g1")
        @NotBlank(message = "orderStatus가 없습니다")
        String orderStatus,
        @Schema(description = "송장번호")
        @NotNull
        String invoiceNo,
        @Schema(description = "택배사 SNO")
        @NotNull
        String invoiceCompanySno,
        @Schema(description =
                "클레임수량\n" +
                "입력한 주문상품번호의 클레임 접수 수량을 입력한다.\n" +
                "ex) 2|1\n" +
                "주문상품번호 23의 주문수량 중 2개 클레임 접수\n" +
                "주문상품번호 24의 주문수량 중 1개 클레임 접수\n" +
                "단, 주문수량보다 큰 값을 입력하는 경우 실패처리된다.\n" +
                "※환불/반품/교환 접수시 사용\n" +
                "※클레임 접수시 필수 (네이버페이 주문 미사용)",
                example = "2|1"
        )
        @NotNull
        String cancelCnt,
        @Schema(description =
                "환불사유 - 공통코드조회API 참조\n" +
                "※환불/반품/교환 접수시 사용\n" +
                "※클레임 접수시 필수\n" +
                "※네이버페이 주문은 [네이버페이 환불사유 코드] 참조")
        @NotNull
        String handleReason,
        @Schema(description =
                "환불수단 - 공통코드조회API 참조\n" +
                "※환불/반품 접수시 사용\n" +
                "※클레임 접수시 필수 (네이버페이 주문 미사용)")
        @NotNull
        String refundMethod,
        @Schema(description =
                "상세사유\n" +
                "※환불/반품/교환 접수시 사용\n" +
                "※클레임 접수시 필수")
        @NotNull
        String handleDetailReason,
        @Schema(description =
                "환불 계좌은행명 - 공통코드조회API 참조\n" +
                "※환불/반품 접수시 사용")
        @NotNull
        String refundBankName,
        @Schema(description =
                "환불 계좌번호\n" +
                "※환불/반품 접수시 사용")
        @NotNull
        String refundAccountNumber,
        @Schema(description =
                "예금주\n" +
                "※환불/반품 접수시 사용\n")
        @NotNull
        String refundDepositor
) {
}
