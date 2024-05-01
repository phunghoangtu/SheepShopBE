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
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Size(max = 30)
    @Column(name = "Code", length = 30)
    private String code;

    @Size(max = 100)
    @Nationalized
    @Column(name = "Name", length = 100)
    private String name;

    @Column(name = "TypeVoucher")
    private Boolean typeVoucher;

    @Column(name = "IsVoucher")
    private Boolean isVoucher;

    @Column(name = "Discount")
    private Integer discount;

    @Column(name = "Cash")
    private BigDecimal cash;

    @Column(name = "StartDate")
    private Date startDate;

    @Column(name = "EndDate")
    private Date endDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CreateDate")
    private Date createDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UpdateDate")
    private Date updateDate;

    @Size(max = 30)
    @Column(name = "CreateBy", length = 30)
    private String createBy;

    @Size(max = 30)
    @Column(name = "UpdateBy", length = 30)
    private String updateBy;

    @Column(name = "Status")
    private Integer status;

    @JsonIgnore
    @OneToMany(mappedBy = "voucher")
    private Set<Bill> bills = new LinkedHashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "voucher")
    private Set<ProductVoucher> productVouchers = new LinkedHashSet<>();

}