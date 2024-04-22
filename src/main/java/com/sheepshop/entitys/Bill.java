package com.sheepshop.entitys;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 30)
    @Column(name = "code", length = 30)
    private String code;

    @Column(name = "payment_date")
    private Instant paymentDate;

    @Column(name = "total_price")
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "voucher_id")
    private Voucher voucher;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

}