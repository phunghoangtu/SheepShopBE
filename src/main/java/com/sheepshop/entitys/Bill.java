package com.sheepshop.entitys;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "bill")
public class Bill implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 30)
    @Column(name = "code", length = 30)
    private String code;

    @Column(name = "payment_date")
    private Instant paymentDate;

    @Column(name = "total_price", precision = 18)
    private BigDecimal totalPrice;

    @Column(name = "total_price_last")
    private Instant totalPriceLast;

    @Column(name = "pay_type")
    private Integer payType;

    @Column(name = "pay_status")
    private Integer payStatus;

    @Size(max = 30)
    @Column(name = "code_ghn", length = 30)
    private String codeGhn;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


    @ManyToOne
    @JoinColumn(name = "voucher_id")
    private Voucher voucher;

}