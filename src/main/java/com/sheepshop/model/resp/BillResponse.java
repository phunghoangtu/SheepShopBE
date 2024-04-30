package com.sheepshop.model.resp;

import com.sheepshop.entitys.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

public interface BillResponse {
    Integer getId();
    String getCode();
    Date getPurchaseDate();
    Date getEstimatedDate();
    Date getPaymentDate();
    Date getDeliveryDate();
    BigDecimal getTotalPrice();
    BigDecimal getShipPrice();
    BigDecimal getTotalPriceLast();
    String getNote();
    Integer getPayType();
    Integer getPayStatus();
    Integer getStatus();
    Integer getTypeStatus();
    String getCodeGHN();
    Integer getIdCoupon();
    Integer getIdAddress();
    Integer getIdCustomer();
    Integer getIdVoucher();
    Integer getIdEmployee();
}