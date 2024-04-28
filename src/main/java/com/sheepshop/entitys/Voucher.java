package com.sheepshop.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "voucher")
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 30)
    @Column(name = "code", length = 30)
    private String code;

    @Size(max = 100)
    @Nationalized
    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "type_voucher")
    private Boolean typeVoucher;

    @Column(name = "discount")
    private Integer discount;

    @Column(name = "Cash", precision = 18)
    private BigDecimal cash;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @ColumnDefault("0")
    @Column(name = "status")
    private Integer status;

    @JsonIgnore
    @OneToMany(mappedBy = "voucher")
    private Set<Bill> bills = new HashSet<Bill>();

}