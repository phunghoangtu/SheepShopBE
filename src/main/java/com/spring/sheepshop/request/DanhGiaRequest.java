package com.spring.sheepshop.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DanhGiaRequest {
    private Integer Score;
    private String Note;
    private Integer IdProductDetail;
    private Integer IdCustomer;
}
