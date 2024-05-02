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
public class Voucher implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer Id;

    @Size(max = 30)
    @Column(name = "Code", length = 30)
    private String Code;

    @Size(max = 100)
    @Nationalized
    @Column(name = "Name", length = 100)
    private String Name;

    @Column(name = "TypeVoucher")
    private Boolean TypeVoucher;

    @Column(name = "IsVoucher")
    private Boolean IsVoucher;

    @Column(name = "Discount")
    private Integer Discount;

    @Column(name = "Cash")
    private BigDecimal Cash;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "StartDate")
    private Date StartDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EndDate")
    private Date EndDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CreateDate")
    private Date CreateDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UpdateDate")
    private Date UpdateDate;

    @Size(max = 30)
    @Column(name = "CreateBy", length = 30)
    private String CreateBy;

    @Size(max = 30)
    @Column(name = "UpdateBy", length = 30)
    private String UpdateBy;

    @Column(name = "Minimum")
    private Integer Minimum;

    @Column(name = "Status")
    private Integer Status;

    @JsonIgnore
    @OneToMany(mappedBy = "voucher")
    private Set<Bill> bills = new LinkedHashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "voucher")
    private Set<ProductVoucher> productVouchers = new LinkedHashSet<>();

}