package com.spring.sheepshop.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class UpdateBillShipPrice {
    private String Code;
    private BigDecimal Money;
}
