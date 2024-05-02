package com.sheepshop.model.req;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductVoucherRequest {
    private Integer IdProduct;
    private Integer IdVoucher;
}
