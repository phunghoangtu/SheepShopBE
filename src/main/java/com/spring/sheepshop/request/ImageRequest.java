package com.spring.sheepshop.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageRequest {
    private String Url;
    private Boolean MainImage;
    private Integer IdProduct;
}
