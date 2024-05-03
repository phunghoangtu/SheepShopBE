package com.spring.sheepshop.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class ProductDetailRequest {
    private BigDecimal Price;
    private Integer Discount;
    private String Description;
    private String CreateBy;
    private String UpdateBy;
    private Integer IdProduct;
    private Integer IdBrand;
    private Integer IdCategory;
    private Integer IdDesign;
    private Date DiscountDate;
}
