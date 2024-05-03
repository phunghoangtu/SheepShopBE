package com.spring.sheepshop.request;


import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
public class VoucherRequest {
    @NotBlank(message = "Không được bỏ trống mã")
    @Size(max = 30,message = "Mã có độ dài nhỏ hơn hoặc bằng 30 kí tự")
    private String Code;
    @NotBlank(message = "Không được bỏ trống tên khuyến mãi")
    @Size(max = 30,message = "Tên có độ dài nhỏ hơn hoặc bằng 30 kí tự")
    private String Name;
    private Boolean TypeVoucher;
    private Boolean IsVoucher;
    private Integer Discount;
    private BigDecimal Cash;
    @NotNull(message = "Không được bỏ trống ngày bắt đầu ")
    private Timestamp StartDate;
    @NotNull(message = "Không được bỏ trống ngày kết thúc ")
    private Timestamp EndDate;
    private Integer Minimum;



}
