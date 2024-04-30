package com.sheepshop.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 100)
    @Nationalized
    @Column(name = "fullname", length = 100)
    private String fullname;

    @Size(max = 20)
    @Column(name = "Phone", length = 20)
    private String phone;

    @Size(max = 255)
    @Nationalized
    @Column(name = "address")
    private String address;

    @Size(max = 100)
    @Nationalized
    @Column(name = "city_name", length = 100)
    private String cityName;

    @Size(max = 100)
    @Nationalized
    @Column(name = "district_name", length = 100)
    private String districtName;

    @Size(max = 100)
    @Nationalized
    @Column(name = "ward_name", length = 100)
    private String wardName;

    @Column(name = "city_id")
    private Integer cityId;

    @Column(name = "district_id")
    private Integer districtId;

    @Column(name = "ward_id")
    private Integer wardId;

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

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @JsonIgnore
    @OneToMany(mappedBy = "address")
    private Set<Bill> bills = new LinkedHashSet<>();

}