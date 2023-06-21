package com.af.demo.model.request;


import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.util.Date;

public class DealsRequest {
    private Long id;

    private String dealUniqueId;
    @NotBlank(message = "from currency ISO code is required")
    @Pattern(regexp = "^[A-Z]{3}$", message = "Invalid from currency ISO code")
    private String fromCurrency;
    @NotBlank(message = "to currency ISO code is required")
    @Pattern(regexp = "^[A-Z]{3}$", message = "Invalid to currency ISO code")
    private String toCurrencyISOCode;
    private Date dealTimestamp;
    @Digits(integer = 9, fraction = 2, message = "Enter Valid Amount Value")
    @NotNull(message = "Amount is required")
    private BigDecimal dealAmount;

    public DealsRequest(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDealUniqueId() {
        return dealUniqueId;
    }

    public void setDealUniqueId(String dealUniqueId) {
        this.dealUniqueId = dealUniqueId;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrencyISOCode() {
        return toCurrencyISOCode;
    }

    public void setToCurrencyISOCode(String toCurrencyISOCode) {
        this.toCurrencyISOCode = toCurrencyISOCode;
    }

    public Date getDealTimestamp() {
        return dealTimestamp;
    }

    public void setDealTimestamp(Date dealTimestamp) {
        this.dealTimestamp = dealTimestamp;
    }

    public BigDecimal getDealAmount() {
        return dealAmount;
    }

    public void setDealAmount(BigDecimal dealAmount) {
        this.dealAmount = dealAmount;
    }

    @Override
    public String toString() {
        return "DealsRequest{" +
                "id=" + id +
                ", dealUniqueId='" + dealUniqueId + '\'' +
                ", fromCurrency='" + fromCurrency + '\'' +
                ", toCurrencyISOCode='" + toCurrencyISOCode + '\'' +
                ", dealTimestamp=" + dealTimestamp +
                ", dealAmount=" + dealAmount +
                '}';
    }
}
