package com.sheepshop.entitys;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Coupon {
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

    @Column(name = "IsType")
    private Boolean isType;

    @Column(name = "Discount")
    private Integer discount;

    @Column(name = "Cash")
    private BigDecimal cash;

    @Column(name = "CreateDate")
    private Date createDate;

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

    @ManyToOne
    @JoinColumn(name = "IdCustomer")
    private Customer customer;

}