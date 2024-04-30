package com.sheepshop.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Size(max = 100)
    @Nationalized
    @Column(name = "Fullname", length = 100)
    private String fullname;

    @Size(max = 20)
    @Column(name = "Phone", length = 20)
    private String phone;

    @Size(max = 255)
    @Nationalized
    @Column(name = "Address")
    private String address;

    @Size(max = 100)
    @Nationalized
    @Column(name = "CityName", length = 100)
    private String cityName;

    @Size(max = 100)
    @Nationalized
    @Column(name = "DistrictName", length = 100)
    private String districtName;

    @Size(max = 100)
    @Nationalized
    @Column(name = "WardName", length = 100)
    private String wardName;

    @Column(name = "IdCity")
    private Integer idCity;

    @Column(name = "IdDistrict")
    private Integer idDistrict;

    @Column(name = "IdWard")
    private Integer idWard;

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

    @JsonIgnore
    @OneToMany(mappedBy = "address")
    private Set<Bill> bills = new LinkedHashSet<>();

}