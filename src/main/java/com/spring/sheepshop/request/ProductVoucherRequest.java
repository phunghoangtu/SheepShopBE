package com.spring.sheepshop.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductVoucherRequest {
    private Integer IdProduct;
    private Integer IdVoucher;
}
