package Uz.market.UzMarket.service.dto;

import Uz.market.UzMarket.domain.MarketBase;
import Uz.market.UzMarket.domain.PaymentList;

import java.math.BigDecimal;

public class PaymentParamResult {

    private Long productId;

    private String productName;

    private Integer quantity;

    private BigDecimal currentPrise;

    private BigDecimal sum;

    public PaymentParamResult(Long productId, String productName, Integer quantity, BigDecimal currentPrise, BigDecimal sum) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.currentPrise = currentPrise;
        this.sum = sum;
    }

    public PaymentParamResult(PaymentList paymentList, MarketBase marketBase) {

    }

    public PaymentParamResult(MarketBase marketBase) {
        this.productId = marketBase.getProduct().getId();
        this.productName = marketBase.getProduct().getName();
        this.quantity = marketBase.getQuantity();
        this.currentPrise = marketBase.getCurrentPrice();
        this.sum = marketBase.getCurrentPrice();
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getCurrentPrise() {
        return currentPrise;
    }

    public void setCurrentPrise(BigDecimal currentPrise) {
        this.currentPrise = currentPrise;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }
}
