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
@Table(name = "voucher")
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 30)
    @Column(name = "code", length = 30)
    private String code;

    @Size(max = 100)
    @Nationalized
    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "type_voucher")
    private Boolean typeVoucher;

    @Column(name = "is_voucher")
    private Boolean isVoucher;

    @Column(name = "discount")
    private Integer discount;

    @Column(name = "cash")
    private BigDecimal cash;

    @Column(name = "start_date")
    private Instant startDate;

    @Column(name = "end_date")
    private Instant endDate;

    @Column(name = "create_date")
    private Instant createDate;

    @Column(name = "update_date")
    private Instant updateDate;

    @Size(max = 30)
    @Column(name = "create_by", length = 30)
    private String createBy;

    @Size(max = 30)
    @Column(name = "update_by", length = 30)
    private String updateBy;

    @Column(name = "status")
    private Integer status;

    @JsonIgnore
    @OneToMany(mappedBy = "voucher")
    private Set<Bill> bills = new LinkedHashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "voucher")
    private Set<ProductVoucher> productVouchers = new LinkedHashSet<>();

}