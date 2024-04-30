package com.sheepshop.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    @Column(name = "purchase_date")
    private Instant purchaseDate;

    @Column(name = "estimated_date")
    private Instant estimatedDate;

    @Column(name = "payment_date")
    private Instant paymentDate;

    @Column(name = "delyvery_date")
    private Instant delyveryDate;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @Column(name = "ship_price")
    private BigDecimal shipPrice;

    @Column(name = "total_price_last")
    private BigDecimal totalPriceLast;

    @Size(max = 255)
    @Nationalized
    @Column(name = "note")
    private String note;

    @Column(name = "pay_type")
    private Integer payType;

    @Column(name = "pay_status")
    private Integer payStatus;

    @Column(name = "type_status")
    private Integer typeStatus;

    @Column(name = "status")
    private Integer status;

    @Size(max = 30)
    @Column(name = "CodeGHN", length = 30)
    private String codeGHN;

    @Column(name = "coupon_id")
    private Integer couponId;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

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
    @OneToMany(mappedBy = "order")
    private Set<BillDetail> billDetails = new LinkedHashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "order")
    private Set<BillHistory> billHistories = new LinkedHashSet<>();

}