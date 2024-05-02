package com.sheepshop.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Nationalized;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Bill implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer Id;

    @Size(max = 30)
    @Column(name = "Code", length = 30)
    private String Code;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PurchaseDate")
    private Date PurchaseDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EstimatedDate")
    private Date EstimatedDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PaymentDate")
    private Date PaymentDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DelyveryDate")
    private Date DelyveryDate;

    @Column(name = "TotalPrice")
    private BigDecimal TotalPrice;

    @Column(name = "ShipPrice")
    private BigDecimal ShipPrice;

    @Column(name = "TotalPriceLast")
    private BigDecimal TotalPriceLast;

    @Size(max = 255)
    @Nationalized
    @Column(name = "Note")
    private String Note;

    @Column(name = "PayType")
    private Integer PayType;

    @Column(name = "PayStatus")
    private Integer PayStatus;

    @Column(name = "TypeStatus")
    private Integer TypeStatus;

    @Column(name = "Status")
    private Integer Status;

    @Size(max = 30)
    @Column(name = "CodeGHN", length = 30)
    private String CodeGHN;

    @Column(name = "IdCoupon")
    private Integer IdCoupon;

    @ManyToOne
    @JoinColumn(name = "IdAddress")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "IdCustomer")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "IdVoucher")
    private Voucher voucher;

    @ManyToOne
    @JoinColumn(name = "IdEmployee")
    private Employee employee;

    @JsonIgnore
    @OneToMany(mappedBy = "bill")
    private Set<BillDetail> billDetails = new LinkedHashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "bill")
    private Set<BillHistory> billHistories = new LinkedHashSet<>();

}