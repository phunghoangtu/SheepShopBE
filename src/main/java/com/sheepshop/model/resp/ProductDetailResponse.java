package com.sheepshop.model.resp;

import java.math.BigDecimal;

public interface ProductDetailResponse {
    Integer getId();
    Integer getIdProductDetail();
    String getCode();
    String getName();
    String getIdColor();
    String getIdSize();
    String getNameColor();
    String getNameSize();
    Integer getQuantity();
    BigDecimal getPrice();

}
