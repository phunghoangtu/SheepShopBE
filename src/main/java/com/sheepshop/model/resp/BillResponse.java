package com.sheepshop.model.resp;

import com.sheepshop.entitys.Customer;
import com.sheepshop.entitys.Employee;
import com.sheepshop.entitys.Voucher;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

public interface BillResponse {

    Integer getId();
    String getCode();
    BigDecimal getTotalPrice();
    BigDecimal getTotalPriceLast();
    Integer getPayType();
    String getCodeGhn();
    Integer getPayStatus();
    Integer getStatus();
    Integer getEmployee();
    Integer getVoucher();
    Integer getCustomer();
    Date getPurchaseDate();

}
