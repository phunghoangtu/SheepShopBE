package com.sheepshop.model.resp;

import java.math.BigDecimal;

public interface ProductDetailResponse {
    Integer getId();
    String getCode();
    String getName();
    String getNameColor();
    String getNameSize();
    Integer getQuantity();
    BigDecimal getPrice();
}
