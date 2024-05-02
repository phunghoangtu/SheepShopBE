package com.sheepshop.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Nationalized;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer Id;

    @Size(max = 100)
    @Nationalized
    @Column(name = "Fullname", length = 100)
    private String Fullname;

    @Size(max = 15)
    @Column(name = "Phone", length = 15)
    private String Phone;

    @Size(max = 255)
    @Nationalized
    @Column(name = "Address")
    private String Address;

    @Size(max = 100)
    @Nationalized
    @Column(name = "CityName", length = 100)
    private String CityName;

    @Size(max = 100)
    @Nationalized
    @Column(name = "DistrictName", length = 100)
    private String DistrictName;

    @Size(max = 100)
    @Nationalized
    @Column(name = "WardName", length = 100)
    private String WardName;

    @Column(name = "CityId")
    private Integer CityId;

    @Column(name = "DistrictId")
    private Integer DistrictId;

    @Column(name = "WardId")
    private Integer WardId;

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

    @Column(name = "Status")
    private Integer Status;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "IdCustomer")
    private Customer customer;

    @JsonIgnore
    @OneToMany(mappedBy = "address")
    private Set<Bill> bills = new LinkedHashSet<>();

}