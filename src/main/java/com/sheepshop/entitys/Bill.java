package com.sheepshop.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Nationalized;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "Bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Size(max = 30)
    @Column(name = "Code", length = 30)
    private String code;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PurchaseDate")
    private Date purchaseDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EstimatedDate")
    private Date estimatedDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PaymentDate")
    private Date paymentDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DeliveryDate")
    private Date deliveryDate;

    @Column(name = "TotalPrice")
    private BigDecimal totalPrice;

    @Column(name = "ShipPrice")
    private BigDecimal shipPrice;

    @Column(name = "TotalPriceLast")
    private BigDecimal totalPriceLast;

    @Size(max = 255)
    @Nationalized
    @Column(name = "Note")
    private String note;

    @Column(name = "PayType")
    private Integer payType;

    @Column(name = "PayStatus")
    private Integer payStatus;

    @Column(name = "TypeStatus")
    private Integer typeStatus;

    @Column(name = "Status")
    private Integer status;

    @Size(max = 30)
    @Column(name = "CodeGHN", length = 30)
    private String codeGHN;

    @Column(name = "IdCoupon")
    private Integer idCoupon;

    @ManyToOne
    @JoinColumn(name = "IdAddress")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "IdEmployee")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "IdVoucher")
    private Voucher voucher;

    @ManyToOne
    @JoinColumn(name = "IdCustomer")
    private Customer customer;

    @JsonIgnore
    @OneToMany(mappedBy = "bill")
    private Set<BillDetail> billDetails = new LinkedHashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "bill")
    private Set<BillHistory> billHistories = new LinkedHashSet<>();

}