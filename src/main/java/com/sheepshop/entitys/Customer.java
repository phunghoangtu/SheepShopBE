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
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer Id;

    @Size(max = 30)
    @Column(name = "Code", length = 30)
    private String Code;

    @Size(max = 100)
    @Nationalized
    @Column(name = "Fullname", length = 100)
    private String Fullname;

    @Size(max = 30)
    @Column(name = "Username", length = 30)
    private String Username;

    @Size(max = 30)
    @Column(name = "Password", length = 30)
    private String Password;

    @Size(max = 255)
    @Column(name = "Image")
    private String Image;

    @Column(name = "Gender")
    private Boolean Gender;

    @Size(max = 15)
    @Column(name = "Phone", length = 15)
    private String Phone;

    @Size(max = 50)
    @Column(name = "Email", length = 50)
    private String Email;

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

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private Set<Rating> ratings = new LinkedHashSet<>();

}