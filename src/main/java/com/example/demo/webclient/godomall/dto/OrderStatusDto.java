package com.example.demo.webclient.godomall.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "data")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatusDto {
    @XmlElement(name = "header")
    private Header header;
    @XmlElement(name = "return")
    private OrderStatusReturn orderStatusReturn;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class OrderStatusReturn {
        @XmlElement(name = "code")
        private String code;
        @XmlElement(name = "msg")
        private String msg;
        @XmlElement(name = "statusData")
        private String statusData;
        @XmlElement(name = "orderGoodsData")
        private OrderGoodsData orderGoodsData;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class OrderGoodsData {
        @XmlElement(name = "sno")
        private int sno;
        @XmlElement(name = "orderNo")
        private int orderNo;
        @XmlElement(name = "orderCd")
        private int orderCd;
        @XmlElement(name = "orderGroupCd")
        private int orderGroupCd;
        @XmlElement(name = "orderStatus")
        private String orderStatus;
        @XmlElement(name = "invoiceCompanySno")
        private int invoiceCompanySno;
        @XmlElement(name = "invoiceNo")
        private String invoiceNo;
        @XmlElement(name = "scmNo")
        private int scmNo;
        @XmlElement(name = "commission")
        private float commission;
        @XmlElement(name = "goodsNo")
        private int goodsNo;
        @XmlElement(name = "goodsCd")
        private String goodsCd;
        @XmlElement(name = "goodsModelNo")
        private String goodsModelNo;
        @XmlElement(name = "goodsNm")
        private String goodsNm;
        @XmlElement(name = "goodsCnt")
        private int goodsCnt;
        @XmlElement(name = "goodsPrice")
        private float goodsPrice;
        @XmlElement(name = "addGoodsPrice")
        private float addGoodsPrice;
        @XmlElement(name = "optionPrice")
        private float optionPrice;
        @XmlElement(name = "optionTextPrice")
        private float optionTextPrice;
        @XmlElement(name = "fixedPrice")
        private float fixedPrice;
        @XmlElement(name = "costPrice")
        private float costPrice;
        @XmlElement(name = "goodsDcPrice")
        private float goodsDcPrice;
        @XmlElement(name = "memberDcPrice")
        private float memberDcPrice;
        @XmlElement(name = "memberOverlapDcPrice")
        private float memberOverlapDcPrice;
        @XmlElement(name = "couponGoodsDcPrice")
        private float couponGoodsDcPrice;
        @XmlElement(name = "goodsMileage")
        private float goodsMileage;
        @XmlElement(name = "memberMileage")
        private float memberMileage;
        @XmlElement(name = "couponGoodsMileage")
        private float couponGoodsMileage;
        @XmlElement(name = "minusDepositFl")
        private String minusDepositFl;
        @XmlElement(name = "minusRestoreDepositFl")
        private String minusRestoreDepositFl;
        @XmlElement(name = "minusMileageFl")
        private String minusMileageFl;
        @XmlElement(name = "minusRestoreMileageFl")
        private String minusRestoreMileageFl;
        @XmlElement(name = "plusMileageFl")
        private String plusMileageFl;
        @XmlElement(name = "plusRestoreMileageFl")
        private String plusRestoreMileageFl;
        @XmlElement(name = "minusStockFl")
        private String minusStockFl;
        @XmlElement(name = "minusRestoreStockFl")
        private String minusRestoreStockFl;
        @XmlElement(name = "optionSno")
        private int optionSno;
        @XmlElement(name = "optionInfo")
        private String optionInfo;
        @XmlElement(name = "optionTextInfo")
        private String optionTextInfo;
        @XmlElement(name = "cancelDt")
        private String cancelDt;
        @XmlElement(name = "paymentDt")
        private String paymentDt;
        @XmlElement(name = "invoiceDt")
        private String invoiceDt;
        @XmlElement(name = "deliveryDt")
        private String deliveryDt;
        @XmlElement(name = "deliveryCompleteDt")
        private String deliveryCompleteDt;
        @XmlElement(name = "finishDt")
        private String finishDt;
    }
}
