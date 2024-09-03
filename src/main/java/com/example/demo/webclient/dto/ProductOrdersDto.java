package com.example.demo.webclient.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductOrdersDto {
    private String timestamp;
    private String traceId;
    private ProductOrdersData data;


    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ProductOrdersData {
        private List<ProductOrdersContent> contents;
        private ProductOrdersPagination pagination;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ProductOrdersContent {
        private ProductOrdersOrder order;
        private ProductOrdersProductOrder productorder;
        private ProductOrdersBeforeClaim beforeClaim;
        private ProductOrdersCurrentClaim currentClaim;
        private ProductOrdersDeliver delivery;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ProductOrdersOrder {
        private int chargeAmountPaymentAmount;
        private int checkoutAccumulationPaymentAmount;
        private int generalPaymentAmount;
        private int naverMileagePaymentAmount;
        private String orderDate;
        private int orderDiscountAmount;
        private String orderId;
        private String ordererId;
        private String ordererName;
        private String ordererTel;
        private String paymentDate;
        private String paymentDueDate;
        private String paymentMeans;
        private String isDeliveryMemoParticularInput;
        private String payLocationType;
        private String ordererNo;
        private int payLaterPaymentAmount;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ProductOrdersProductOrder {
        private String claimStatus;
        private String claimType;
        private String decisionDate;
        private String delayedDispatchDetailedReason;
        private String delayedDispatchReason;
        private int deliveryDiscountAmount;
        private int deliveryFeeAmount;
        private String deliveryPolicyType;
        private String expectedDeliveryMethod;
        private String freeGift;
        private String mallId;
        private String optionCode;
        private int optionPrice;
        private String packageNumber;
        private String placeOrderDate;
        private String placeOrderStatus;
        private String productClass;
        private int productDiscountAmount;
        private String productId;
        private String originalProductId;
        private String merchantChannelId;
        private String productName;
        private String productOption;
        private String productOrderId;
        private String productOrderStatus;
        private int quantity;
        private int sectionDeliveryFee;
        private String sellerProductCode;
        private ProductOrdersShippingAddress shippingAddress;
        private String shippingStartDate;
        private String shippingDueDate;
        private String shippingFeeType;
        private String shippingMemo;
        private AddressDetail takingAddress;
        private int totalPaymentAmount;
        private int totalProductAmount;
        private int unitPrice;
        private int sellerBurdenDiscountAmount;
        private String commissionRatingType;
        private String commissionPrePayStatus;
        private int paymentCommission;
        private int saleCommission;
        private int expectedSettlementAmount;
        private String inflowPath;
        private String inflowPathAdd;
        private String itemNo;
        private String optionManageCode;
        private String sellerCustomCode1;
        private String sellerCustomCode2;
        private String claimId;
        private int channelCommission;
        private String individualCustomUniqueCode;
        private int productImediateDiscountAmount;
        private int productProductDiscountAmount;
        private int productMultiplePurchaseDiscountAmount;
        private int sellerBurdenImediateDiscountAmount;
        private int sellerBurdenProductDiscountAmount;
        private int sellerBurdenMultiplePurchaseDiscountAmount;
        private int knowledgeShoppingSellingInterlockCommission;
        private String giftReceivingStatus;
        private int sellerBurdenStoreDiscountAmount;
        private String sellerBurdenMultiplePurchaseDiscountType;
        private String logisticsCompanyId;
        private String logisticsCenterId;
        private ProductOrdersHopeDelivery hopeDelivery;
        private String arrivalGuaranteeDate;
        private String deliveryAttributeType;
        private String expectedDeliveryCompany;
        private ProductOrdersBeforeClaim beforeClaim;
        private ProductOrdersCurrentClaim currentClaim;
        private ProductOrdersDeliver delivery;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AddressDetail {
        private String addressType;
        private String baseAddress;
        private String city;
        private String country;
        private String detailedAddress;
        private String name;
        private String state;
        private String tel1;
        private String tel2;
        private String zipCode;
        private boolean isRoadNameAddress;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ProductOrdersShippingAddress extends AddressDetail {
        private String pickupLocationType;
        private String pickupLocationContent;
        private String entryMethod;
        private String entryMethodContent;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ProductOrdersHopeDelivery {
        private String region;
        private int additionalFee;
        private String hopeDeliveryYmd;
        private String hopeDeliveryHm;
        private String changeReason;
        private String changer;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ProductOrdersBeforeClaim {
        private BeforeClaimExchange exchange;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class BeforeClaimExchange {
        private String claimId;
        private int claimDeliveryFeeDemandAmount;
        private String claimDeliveryFeePayMeans;
        private String claimDeliveryFeePayMethod;
        private String claimRequestDate;
        private String claimStatus;
        private AddressDetail collectAddress;
        private String collectCompletedDate;
        private String collectDeliveryCompany;
        private String collectDeliveryMethod;
        private String collectStatus;
        private String collectTrackingNumber;
        private int etcFeeDemandAmount;
        private String etcFeePayMeans;
        private String etcFeePayMethod;
        private String exchangeDetailedReason;
        private String exchangeReason;
        private String holdbackDetailedReason;
        private String holdbackReason;
        private String holdbackStatus;
        private String reDeliveryMethod;
        private String reDeliveryStatus;
        private String reDeliveryCompany;
        private String reDeliveryTrackingNumber;
        private String requestChannel;
        private ExchangeReturnReceiveAddress returnReceiveAddress;
        private String holdbackConfigDate;
        private String holdbackConfigurer;
        private String holdbackReleaseDate;
        private String holdbackReleaser;
        private String claimDeliveryFeeProductOrderIds;
        private String reDeliveryOperationDate;
        private int claimDeliveryFeeDiscountAmount;
        private int remoteAreaCostChargeAmount;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ExchangeReturnReceiveAddress extends AddressDetail {
        private String logisticsCenterId;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ProductOrdersCurrentClaim {
        private CurrentClaimCancel cancel;
        @JsonProperty("return")
        private CurrentClaimReturn claimReturn;
        private CurrentClaimExchange exchange;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CurrentClaimCancel {
        private String claimId;
        private String cancelApprovalDate;
        private String cancelCompletedDate;
        private String cancelDetailedReason;
        private String cancelReason;
        private String claimRequestDate;
        private String claimStatus;
        private String refundExpectedDate;
        private String refundStandbyReason;
        private String refundStandbyStatus;
        private String requestChannel;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CurrentClaimReturn {
        private String claimId;
        private int claimDeliveryFeeDemandAmount;
        private String claimDeliveryFeePayMeans;
        private String claimDeliveryFeePayMethod;
        private String claimRequestDate;
        private String claimStatus;
        private AddressDetail collectAddress;
        private String collectCompletedDate;
        private String collectDeliveryCompany;
        private String collectDeliveryMethod;
        private String collectStatus;
        private String collectTrackingNumber;
        private int etcFeeDemandAmount;
        private String etcFeePayMeans;
        private String etcFeePayMethod;
        private String holdbackDetailedReason;
        private String holdbackReason;
        private String holdbackStatus;
        private String refundExpectedDate;
        private String refundStandbyReason;
        private String refundStandbyStatus;
        private String requestChannel;
        private String returnDetailedReason;
        private String returnReason;
        private ReturnReceiveAddress returnReceiveAddress;
        private String returnCompletedDate;
        private String holdbackConfigDate;
        private String holdbackConfigurer;
        private String holdbackReleaseDate;
        private String holdbackReleaser;
        private String claimDeliveryFeeProductOrderIds;
        private int claimDeliveryFeeDiscountAmount;
        private int remoteAreaCostChargeAmount;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ReturnReceiveAddress extends AddressDetail {
        private String logisticsCenterId;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CurrentClaimExchange {
        private String claimId;
        private int claimDeliveryFeeDemandAmount;
        private String claimDeliveryFeePayMeans;
        private String claimDeliveryFeePayMethod;
        private String claimRequestDate;
        private String claimStatus;
        private AddressDetail collectAddress;
        private String collectCompletedDate;
        private String collectDeliveryCompany;
        private String collectDeliveryMethod;
        private String collectStatus;
        private String collectTrackingNumber;
        private int etcFeeDemandAmount;
        private String etcFeePayMeans;
        private String etcFeePayMethod;
        private String exchangeDetailedReason;
        private String exchangeReason;
        private String holdbackDetailedReason;
        private String holdbackReason;
        private String holdbackStatus;
        private String reDeliveryMethod;
        private String reDeliveryStatus;
        private String reDeliveryCompany;
        private String reDeliveryTrackingNumber;
        private String requestChannel;
        private ReturnReceiveAddress returnReceiveAddress;
        private String holdbackConfigDate;
        private String holdbackConfigurer;
        private String holdbackReleaseDate;
        private String holdbackReleaser;
        private String claimDeliveryFeeProductOrderIds;
        private String reDeliveryOperationDate;
        private int claimDeliveryFeeDiscountAmount;
        private int remoteAreaCostChargeAmount;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ProductOrdersDeliver {
        private String deliveredDate;
        private String deliveryCompany;
        private String deliveryMethod;
        private String deliveryStatus;
        private boolean isWrongTrackingNumber;
        private String pickupDate;
        private String sendDate;
        private String trackingNumber;
        private String wrongTrackingNumberRegisteredDate;
        private String wrongTrackingNumberType;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ProductOrdersPagination {
        private int page;
        private int size;
        private boolean hasNext;
    }

}
