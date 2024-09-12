package com.example.demo.dto;

import com.example.demo.webclient.godomall.dto.OrderSearchDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import static com.example.demo.util.DateUtils.nowDate;
import static com.example.demo.webclient.godomall.dto.OrderSearchDto.*;
import static com.example.demo.webclient.godomall.dto.OrderSearchDto.OrderData.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderSearchRes {
    @Schema(description = "주문일자", example = "2024-09-06")
    private String orderDate; //주문일자
    @Schema(description = "판매처", example = "고도몰")
    private String marketName;//판매처
    @Schema(description = "주문번호", example = "2409111847157804")
    private String orderNum;//주문번호
    @Schema(description = "주문상품번호", example = "22")
    private String sno;//주문상품번호
    @Schema(description = "주문자연락처", example = "02-123-1234")
    private String orderPhone;//주문번호연락처
    @Schema(description = "주문자휴대폰번호", example = "010-1111-1111")
    private String orderCellPhone;//주문자휴대폰번호
    @Schema(description = "상품", example = "[용차전용출고]B211 - 270 x 200 x 110 (93장)")
    private String product;//상품
    @Schema(description = "이미지", example = "https://{imageUrl...}")
    private String image;//이미지
    @Schema(description = "수량", example = "1")
    private String productQty;//수량
    @Schema(description = "금액", example = "22000")
    private String amount;//금액
    @Schema(description = "주문자", example = "농구왕메시")
    private String orders;//주문자
    @Schema(description = "수령자", example = "축구왕르브론")
    private String receiverName;//수령자
    @Schema(description = "배송방법", example = "선불")
    private String ShippingType;//배송방법
    @Schema(description = "진행현황", example = "2024-09-06")
    private String process;//진행현황
    @Schema(description = "검색시작일", example = "2024-09-06")
    private String csStatus;//cs상태

    public static <T, S, U> OrderSearchRes createOrderSearchRes(T t, S s, U u) {
        OrderSearchRes orderSearchRes = new OrderSearchRes();

        if (t instanceof OrderSearchDto dto) {
            OrderData orderData = (OrderData) s;
            OrderGoodsData goodsData = (OrderGoodsData) u;

            orderSearchRes.setOrderDate(nowDate());
            orderSearchRes.setMarketName("고도몰");
            orderSearchRes.setOrderNum(orderData.getOrderNo());
            orderSearchRes.setSno(goodsData.getSno());
            orderSearchRes.setOrderPhone(orderData.getOrderInfoData().getOrderPhone());
            orderSearchRes.setOrderCellPhone(orderData.getOrderInfoData().getOrderCellPhone());
            orderSearchRes.setProduct(orderData.getOrderGoodsNm());
            orderSearchRes.setImage(goodsData.getListImageData());
            orderSearchRes.setProductQty(goodsData.getGoodsCnt());
            orderSearchRes.setAmount(goodsData.getGoodsPrice());
            orderSearchRes.setOrders(orderData.getOrderInfoData().getOrderName());
            orderSearchRes.setReceiverName(orderData.getOrderInfoData().getReceiverName());
            orderSearchRes.setShippingType(orderData.getOrderDeliveryData().get(0).getDeliveryCollectFl().equals("pre") ? "선불" : "착불");
            orderSearchRes.setProcess("결제완료");
            orderSearchRes.setCsStatus("");
        }

        return orderSearchRes;
    }
}
