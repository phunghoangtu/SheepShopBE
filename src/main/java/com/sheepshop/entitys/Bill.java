package com.sheepshop.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "bill")
public class Bill {
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

    @Column(name = "total_price_last", precision = 18)
    private BigDecimal totalPriceLast;

    @Column(name = "pay_type")
    private Integer payType;

    @ColumnDefault("0")
    @Column(name = "pay_status")
    private Integer payStatus;

    @Size(max = 30)
    @Column(name = "code_ghn", length = 30)
    private String codeGhn;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "voucher_id")
    private Voucher voucher;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @JsonIgnore
    @OneToMany(mappedBy = "bill")
    private Set<BillDetail> billDetails = new HashSet<BillDetail>();

    @JsonIgnore
    @OneToMany(mappedBy = "cart")
    private Set<CartDetail> cartDetails = new HashSet<CartDetail>();

}