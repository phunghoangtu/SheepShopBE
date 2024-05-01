package com.sheepshop.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Nationalized;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Size(max = 30)
    @Column(name = "Code", length = 30)
    private String code;

    @Size(max = 100)
    @Nationalized
    @Column(name = "Fullname", length = 100)
    private String fullname;

    @Size(max = 50)
    @Column(name = "Username", length = 50)
    private String username;

    @Size(max = 64)
    @Column(name = "Password", length = 64)
    private String password;

    @Size(max = 255)
    @Column(name = "Image")
    private String image;

    @Column(name = "Gender")
    private Boolean gender;

    @Size(max = 20)
    @Column(name = "Phone", length = 20)
    private String phone;

    @Size(max = 100)
    @Column(name = "Email", length = 100)
    private String email;

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
    @OneToMany(mappedBy = "customer")
    private Set<Address> addresses = new LinkedHashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private Set<Bill> bills = new LinkedHashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private Set<Cart> carts = new LinkedHashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private Set<Coupon> coupons = new LinkedHashSet<>();

}