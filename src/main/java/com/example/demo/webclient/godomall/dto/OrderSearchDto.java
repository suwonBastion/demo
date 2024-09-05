package com.example.demo.webclient.godomall.dto;


import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "data")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderSearchDto {
    @XmlElement(name = "header")
    private Header header;
    @XmlElement(name = "return")
    private OrderSearchReturn orderSearchReturn;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class OrderSearchReturn {
        @XmlElement(name = "order_data")
        private List<OrderData> orderData;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Header {
        @XmlElement(name = "code")
        private String code;
        @XmlElement(name = "msg")
        private String msg;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class OrderData {
        @XmlElement(name = "orderNo")
        private String orderNo;
        @XmlElement(name = "apiOrderNo")
        private String apiOrderNo;
        @XmlElement(name = "mallSno")
        private String mallSno;
        @XmlElement(name = "memNo")
        private String memNo;
        @XmlElement(name = "orderStatus")
        private String orderStatus;
        @XmlElement(name = "orderIp")
        private String orderIp;
        @XmlElement(name = "orderChannelFl")
        private String orderChannelFl;
        @XmlElement(name = "orderTypeFl")
        private String orderTypeFl;
        @XmlElement(name = "appOs")
        private String appOs;
        @XmlElement(name = "pushCode")
        private String pushCode;
        @XmlElement(name = "statisticsAppOrderCntFl")
        private String statisticsAppOrderCntFl;
        @XmlElement(name = "orderEmail")
        private String orderEmail;
        @XmlElement(name = "orderGoodsNm")
        private String orderGoodsNm;
        @XmlElement(name = "orderGoodsNmStandard")
        private String orderGoodsNmStandard;
        @XmlElement(name = "orderGoodsCnt")
        private String orderGoodsCnt;
        @XmlElement(name = "settlePrice")
        private String settlePrice;
        @XmlElement(name = "overseasSettleCurrency")
        private String overseasSettleCurrency;
        @XmlElement(name = "overseasSettlePrice")
        private String overseasSettlePrice;
        @XmlElement(name = "taxSupplyPrice")
        private String taxSupplyPrice;
        @XmlElement(name = "taxVatPrice")
        private String taxVatPrice;
        @XmlElement(name = "taxFreePrice")
        private String taxFreePrice;
        @XmlElement(name = "realTaxSupplyPrice")
        private String realTaxSupplyPrice;
        @XmlElement(name = "realTaxVatPrice")
        private String realTaxVatPrice;
        @XmlElement(name = "realTaxFreePrice")
        private String realTaxFreePrice;
        @XmlElement(name = "useMileage")
        private String useMileage;
        @XmlElement(name = "useDeposit")
        private String useDeposit;
        @XmlElement(name = "totalGoodsPrice")
        private String totalGoodsPrice;
        @XmlElement(name = "totalDeliveryCharge")
        private String totalDeliveryCharge;
        @XmlElement(name = "totalDeliveryInsuranceFee")
        private String totalDeliveryInsuranceFee;
        @XmlElement(name = "totalGoodsDcPrice")
        private String totalGoodsDcPrice;
        @XmlElement(name = "totalMemberDcPrice")
        private String totalMemberDcPrice;
        @XmlElement(name = "totalMemberBankDcPrice")
        private String totalMemberBankDcPrice;
        @XmlElement(name = "totalMemberOverlapDcPrice")
        private String totalMemberOverlapDcPrice;
        @XmlElement(name = "totalMemberDeliveryDcPrice")
        private String totalMemberDeliveryDcPrice;
        @XmlElement(name = "totalCouponGoodsDcPrice")
        private String totalCouponGoodsDcPrice;
        @XmlElement(name = "totalCouponOrderDcPrice")
        private String totalCouponOrderDcPrice;
        @XmlElement(name = "totalCouponDeliveryDcPrice")
        private String totalCouponDeliveryDcPrice;
        @XmlElement(name = "totalMyappDcPrice")
        private String totalMyappDcPrice;
        @XmlElement(name = "totalCatePriceVariantDcPrice")
        private String totalCatePriceVariantDcPrice;
        @XmlElement(name = "totalMileage")
        private String totalMileage;
        @XmlElement(name = "totalGoodsMileage")
        private String totalGoodsMileage;
        @XmlElement(name = "totalMemberMileage")
        private String totalMemberMileage;
        @XmlElement(name = "totalCouponGoodsMileage")
        private String totalCouponGoodsMileage;
        @XmlElement(name = "totalCouponOrderMileage")
        private String totalCouponOrderMileage;
        @XmlElement(name = "totalEnuriDcPrice")
        private String totalEnuriDcPrice;
        @XmlElement(name = "totalDeliveryWeight")
        private String totalDeliveryWeight;
        @XmlElement(name = "firstSaleFl")
        private String firstSaleFl;
        @XmlElement(name = "settleKind")
        private String settleKind;
        @XmlElement(name = "currencyPolicy")
        private String currencyPolicy;
        @XmlElement(name = "exchangeRatePolicy")
        private String exchangeRatePolicy;
        @XmlElement(name = "myappPolicy")
        private String myappPolicy;
        @XmlElement(name = "adminMemo")
        private String adminMemo;
        @XmlElement(name = "pgRealTaxSupplyPrice")
        private String pgRealTaxSupplyPrice;
        @XmlElement(name = "pgRealTaxVatPrice")
        private String pgRealTaxVatPrice;
        @XmlElement(name = "pgRealTaxFreePrice")
        private String pgRealTaxFreePrice;
        @XmlElement(name = "addField")
        private String addField;
        @XmlElement(name = "bankdaManualNo")
        private String bankdaManualNo;
        @XmlElement(name = "bankdaManualFl")
        private String bankdaManualFl;
        @XmlElement(name = "bankdaManualMangerId")
        private String bankdaManualMangerId;
        @XmlElement(name = "paymentDt")
        private String paymentDt;
        @XmlElement(name = "multiShippingFl")
        private String multiShippingFl;
        @XmlElement(name = "trackingKey")
        private String trackingKey;
        @XmlElement(name = "userHandleProcess")
        private String userHandleProcess;
        @XmlElement(name = "pgChargeBack")
        private String pgChargeBack;
        @XmlElement(name = "boxGoodsPolicy")
        private BoxGoodsPolicy boxGoodsPolicy;
        @XmlElement(name = "fbPixelKey")
        private String fbPixelKey;
        @XmlElement(name = "catePriceVariantPolicy")
        private CatePriceVariantPolicy catePriceVariantPolicy;
        @XmlElement(name = "orderDate")
        private String orderDate;
        @XmlElement(name = "memGroupNm")
        private String memGroupNm;
        @XmlElement(name = "memId")
        private String memId;
        @XmlElement(name = "orderGoodsStatusCnt")
        private String orderGoodsStatusCnt;
        @XmlElement(name = "orderDeliveryData")
        private List<OrderDeliveryData> orderDeliveryData;
        @XmlElement(name = "orderInfoData")
        private OrderInfoData orderInfoData;
        @XmlElement(name = "orderGoodsData")
        private List<OrderGoodsData> orderGoodsData;


        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        @XmlAccessorType(XmlAccessType.FIELD)
        public static class BoxGoodsPolicy {
            @XmlElement(name = "price20")
            private String price20;
            @XmlElement(name = "price10_19")
            private String price10_19;


        }

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        @XmlAccessorType(XmlAccessType.FIELD)
        public static class CatePriceVariantPolicy {
            @XmlElement(name = "applyCd")
            private ApplyCd applyCd;
            @XmlElement(name = "policy")
            private Policy policy;
            @XmlElement(name = "applySum")
            private ApplySum applySum;
            @XmlElement(name = "applyGoodsNo")
            private ApplyGoodsNo applyGoodsNo;
            @XmlElement(name = "applyGoodsNoCnt")
            private ApplyGoodsNoCnt applyGoodsNoCnt;
            @XmlElement(name = "applyDiscount")
            private ApplyDiscount applyDiscount;
            @XmlElement(name = "applyDiscountUnit")
            private ApplyDiscountUnit applyDiscountUnit;
        }

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        @XmlAccessorType(XmlAccessType.FIELD)
        public static class ApplyCd {
            @XmlElement(name = "code")
            private String code;
        }

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        @XmlAccessorType(XmlAccessType.FIELD)
        public static class Policy {
            @XmlElement(name = "discounts")
            private List<Discount> discounts;

        }

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        @XmlAccessorType(XmlAccessType.FIELD)
        public static class Discount {
            @XmlElement(name = "unitStart")
            private String unitStart;
            @XmlElement(name = "unitEnd")
            private String unitEnd;
            @XmlElement(name = "discount")
            private String discount;
            @XmlElement(name = "discountUnit")
            private String discountUnit;
        }


        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        @XmlAccessorType(XmlAccessType.FIELD)
        public static class ApplySum {
            @XmlElement(name = "sum")
            private String sum;


        }

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        @XmlAccessorType(XmlAccessType.FIELD)
        public static class ApplyGoodsNo {
            @XmlElement(name = "goodsNos")
            private List<String> goodsNos;


        }

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        @XmlAccessorType(XmlAccessType.FIELD)
        public static class ApplyGoodsNoCnt {
            @XmlElement(name = "goodsNo")
            private String goodsNo;
            @XmlElement(name = "count")
            private String count;


        }

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        @XmlAccessorType(XmlAccessType.FIELD)
        public static class ApplyDiscount {
            @XmlElement(name = "discount")
            private String discount;


        }

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        @XmlAccessorType(XmlAccessType.FIELD)
        public static class ApplyDiscountUnit {
            @XmlElement(name = "discountUnit")
            private String discountUnit;
        }


        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        @XmlAccessorType(XmlAccessType.FIELD)
        public static class OrderDeliveryData {
            @XmlElement(name = "sno")
            private String sno;
            @XmlElement(name = "scmNo")
            private String scmNo;
            @XmlElement(name = "commission")
            private String commission;
            @XmlElement(name = "scmAdjustNo")
            private String scmAdjustNo;
            @XmlElement(name = "scmAdjustAfterNo")
            private String scmAdjustAfterNo;
            @XmlElement(name = "deliveryCharge")
            private String deliveryCharge;
            @XmlElement(name = "deliveryPolicyCharge")
            private String deliveryPolicyCharge;
            @XmlElement(name = "deliveryAreaCharge")
            private String deliveryAreaCharge;
            @XmlElement(name = "divisionDeliveryUseDeposit")
            private String divisionDeliveryUseDeposit;
            @XmlElement(name = "divisionDeliveryUseMileage")
            private String divisionDeliveryUseMileage;
            @XmlElement(name = "divisionDeliveryCharge")
            private String divisionDeliveryCharge;
            @XmlElement(name = "divisionMemberDeliveryDcPrice")
            private String divisionMemberDeliveryDcPrice;
            @XmlElement(name = "deliveryInsuranceFee")
            private String deliveryInsuranceFee;
            @XmlElement(name = "deliveryFixFl")
            private String deliveryFixFl;
            @XmlElement(name = "deliveryWeightInfo")
            private DeliveryWeightInfo deliveryWeightInfo;
            @XmlElement(name = "overseasDeliveryPolicy")
            private String overseasDeliveryPolicy;
            @XmlElement(name = "deliveryCollectFl")
            private String deliveryCollectFl;
            @XmlElement(name = "deliveryCollectPrice")
            private String deliveryCollectPrice;
            @XmlElement(name = "deliveryWholeFreePrice")
            private String deliveryWholeFreePrice;
            @XmlElement(name = "statisticsOrderFl")
            private String statisticsOrderFl;

        }

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        @XmlAccessorType(XmlAccessType.FIELD)
        public static class DeliveryWeightInfo {
            @XmlElement(name = "box")
            private String box;
            @XmlElement(name = "goods")
            private String goods;
            @XmlElement(name = "total")
            private String total;
        }


        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        @XmlAccessorType(XmlAccessType.FIELD)
        public static class OrderInfoData {
            @XmlElement(name = "orderName")
            private String orderName;
            @XmlElement(name = "orderEmail")
            private String orderEmail;
            @XmlElement(name = "orderPhonePrefixCode")
            private String orderPhonePrefixCode;
            @XmlElement(name = "orderPhonePrefix")
            private String orderPhonePrefix;
            @XmlElement(name = "orderPhone")
            private String orderPhone;
            @XmlElement(name = "orderCellPhonePrefixCode")
            private String orderCellPhonePrefixCode;
            @XmlElement(name = "orderCellPhonePrefix")
            private String orderCellPhonePrefix;
            @XmlElement(name = "orderCellPhone")
            private String orderCellPhone;
            @XmlElement(name = "orderZipcode")
            private String orderZipcode;
            @XmlElement(name = "orderZonecode")
            private String orderZonecode;
            @XmlElement(name = "orderState")
            private String orderState;
            @XmlElement(name = "orderCity")
            private String orderCity;
            @XmlElement(name = "orderAddress")
            private String orderAddress;
            @XmlElement(name = "orderAddressSub")
            private String orderAddressSub;
            @XmlElement(name = "receiverName")
            private String receiverName;
            @XmlElement(name = "receiverCountryCode")
            private String receiverCountryCode;
            @XmlElement(name = "receiverPhonePrefixCode")
            private String receiverPhonePrefixCode;
            @XmlElement(name = "receiverPhonePrefix")
            private String receiverPhonePrefix;
            @XmlElement(name = "receiverPhone")
            private String receiverPhone;
            @XmlElement(name = "receiverCellPhonePrefixCode")
            private String receiverCellPhonePrefixCode;
            @XmlElement(name = "receiverCellPhonePrefix")
            private String receiverCellPhonePrefix;
            @XmlElement(name = "receiverCellPhone")
            private String receiverCellPhone;
            @XmlElement(name = "receiverUseSafeNumberFl")
            private String receiverUseSafeNumberFl;
            @XmlElement(name = "receiverSafeNumber")
            private String receiverSafeNumber;
            @XmlElement(name = "receiverSafeNumberDt")
            private String receiverSafeNumberDt;
            @XmlElement(name = "receiverZipcode")
            private String receiverZipcode;
            @XmlElement(name = "receiverZonecode")
            private String receiverZonecode;
            @XmlElement(name = "receiverCountry")
            private String receiverCountry;
            @XmlElement(name = "receiverState")
            private String receiverState;
            @XmlElement(name = "receiverCity")
            private String receiverCity;
            @XmlElement(name = "receiverAddress")
            private String receiverAddress;
            @XmlElement(name = "receiverAddressSub")
            private String receiverAddressSub;
            @XmlElement(name = "deliveryVisit")
            private String deliveryVisit;
            @XmlElement(name = "visitAddress")
            private String visitAddress;
            @XmlElement(name = "visitName")
            private String visitName;
            @XmlElement(name = "visitPhone")
            private String visitPhone;
            @XmlElement(name = "visitMemo")
            private String visitMemo;
            @XmlElement(name = "customIdNumber")
            private String customIdNumber;
            @XmlElement(name = "orderMemo")
            private String orderMemo;
            @XmlElement(name = "packetCode")
            private String packetCode;
            @XmlElement(name = "orderInfoCd")
            private String orderInfoCd;
            @XmlElement(name = "smsFl")
            private String smsFl;
        }

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        @XmlAccessorType(XmlAccessType.FIELD)
        public static class OrderGoodsData {
            @XmlElement(name = "sno")
            private String sno;
            @XmlElement(name = "orderNo")
            private String orderNo;
            @XmlElement(name = "mallSno")
            private String mallSno;
            @XmlElement(name = "apiOrderGoodsNo")
            private String apiOrderGoodsNo;
            @XmlElement(name = "orderCd")
            private String orderCd;
            @XmlElement(name = "orderGroupCd")
            private String orderGroupCd;
            @XmlElement(name = "eventSno")
            private String eventSno;
            @XmlElement(name = "orderStatus")
            private String orderStatus;
            @XmlElement(name = "orderDeliverySno")
            private String orderDeliverySno;
            @XmlElement(name = "invoiceCompany")
            private String invoiceCompany;
            @XmlElement(name = "invoiceCompanySno")
            private String invoiceCompanySno;
            @XmlElement(name = "invoiceNo")
            private String invoiceNo;
            @XmlElement(name = "scmNo")
            private String scmNo;
            @XmlElement(name = "purchaseNo")
            private String purchaseNo;
            @XmlElement(name = "commission")
            private String commission;
            @XmlElement(name = "scmAdjustAfterNo")
            private String scmAdjustAfterNo;
            @XmlElement(name = "goodsType")
            private String goodsType;
            @XmlElement(name = "timeSaleFl")
            private String timeSaleFl;
            @XmlElement(name = "parentMustFl")
            private String parentMustFl;
            @XmlElement(name = "parentGoodsNo")
            private String parentGoodsNo;
            @XmlElement(name = "goodsNo")
            private String goodsNo;
            @XmlElement(name = "listImageData")
            private String listImageData;
            @XmlElement(name = "goodsCd")
            private String goodsCd;
            @XmlElement(name = "goodsModelNo")
            private String goodsModelNo;
            @XmlElement(name = "goodsNm")
            private String goodsNm;
            @XmlElement(name = "goodsNmStandard")
            private String goodsNmStandard;
            @XmlElement(name = "goodsCnt")
            private String goodsCnt;
            @XmlElement(name = "goodsPrice")
            private String goodsPrice;
            @XmlElement(name = "divisionUseDeposit")
            private String divisionUseDeposit;
            @XmlElement(name = "divisionUseMileage")
            private String divisionUseMileage;
            @XmlElement(name = "divisionGoodsDeliveryUseDeposit")
            private String divisionGoodsDeliveryUseDeposit;
            @XmlElement(name = "divisionGoodsDeliveryUseMileage")
            private String divisionGoodsDeliveryUseMileage;
            @XmlElement(name = "divisionCouponOrderDcPrice")
            private String divisionCouponOrderDcPrice;
            @XmlElement(name = "divisionCouponOrderMileage")
            private String divisionCouponOrderMileage;
            @XmlElement(name = "addGoodsPrice")
            private String addGoodsPrice;
            @XmlElement(name = "optionPrice")
            private String optionPrice;
            @XmlElement(name = "optionCostPrice")
            private String optionCostPrice;
            @XmlElement(name = "smsFoptionTextPricel")
            private String optionTextPrice;
            @XmlElement(name = "fixedPrice")
            private String fixedPrice;
            @XmlElement(name = "costPrice")
            private String costPrice;
            @XmlElement(name = "goodsDcPrice")
            private String goodsDcPrice;
            @XmlElement(name = "memberDcPrice")
            private String memberDcPrice;
            @XmlElement(name = "memberOverlapDcPrice")
            private String memberOverlapDcPrice;
            @XmlElement(name = "couponGoodsDcPrice")
            private String couponGoodsDcPrice;
            @XmlElement(name = "timeSalePrice")
            private String timeSalePrice;
            @XmlElement(name = "brandBankSalePrice")
            private String brandBankSalePrice;
            @XmlElement(name = "myappDcPrice")
            private String myappDcPrice;
            @XmlElement(name = "catePriceVariantDcPrice")
            private String catePriceVariantDcPrice;
            @XmlElement(name = "goodsDeliveryCollectPrice")
            private String goodsDeliveryCollectPrice;
            @XmlElement(name = "goodsMileage")
            private String goodsMileage;
            @XmlElement(name = "memberMileage")
            private String memberMileage;
            @XmlElement(name = "couponGoodsMileage")
            private String couponGoodsMileage;
            @XmlElement(name = "goodsDeliveryCollectFl")
            private String goodsDeliveryCollectFl;
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
            private String optionSno;
            @XmlElement(name = "optionInfo")
            private String optionInfo;
            @XmlElement(name = "optionTextInfo")
            private String optionTextInfo;
            @XmlElement(name = "cateAllCd")
            private String cateAllCd;
            @XmlElement(name = "hscode")
            private String hscode;
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
            @XmlElement(name = "mileageGiveDt")
            private String mileageGiveDt;
            @XmlElement(name = "checkoutData")
            private String checkoutData;
            @XmlElement(name = "statisticsOrderFl")
            private String statisticsOrderFl;
            @XmlElement(name = "statisticsGoodsFl")
            private String statisticsGoodsFl;
            @XmlElement(name = "sendSmsFl")
            private String sendSmsFl;
            @XmlElement(name = "deliveryEndFl")
            private String deliveryEndFl;
            @XmlElement(name = "trackingKey")
            private String trackingKey;
            @XmlElement(name = "goodsMemo")
            private String goodsMemo;
            @XmlElement(name = "statusMode")
            private String statusMode;
            @XmlElement(name = "orderWriteCouponInfo")
            private String orderWriteCouponInfo;
            @XmlElement(name = "optionText")
            private List<OptionText> optionText;
        }

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        @XmlAccessorType(XmlAccessType.FIELD)
        public static class OptionText {
            @XmlElement(name = "optionSno")
            private String optionSno;
            @XmlElement(name = "optionText")
            private String optionText;
            @XmlElement(name = "optionTextData")
            private String optionTextData;
        }

    }
}
