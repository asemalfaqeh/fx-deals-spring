package com.af.demo.entities;



import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Entity(name = "deals")
public class DealsEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String dealUniqueId;
    @Column(unique = true)
    private String fromCurrency;
    @Column(unique = true)
    private String toCurrencyISOCode;
    @Column(unique = true)
    private LocalDateTime dealTimestamp;
    @Column(unique = true)
    private BigDecimal dealAmount;

    public DealsEntity(){}

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

    public LocalDateTime getDealTimestamp() {
        return dealTimestamp;
    }

    public void setDealTimestamp(LocalDateTime dealTimestamp) {
        this.dealTimestamp = dealTimestamp;
    }

    public BigDecimal getDealAmount() {
        return dealAmount;
    }

    public void setDealAmount(BigDecimal dealAmount) {
        this.dealAmount = dealAmount;
    }
}
