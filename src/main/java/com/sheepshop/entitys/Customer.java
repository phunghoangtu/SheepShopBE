package com.sheepshop.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 30)
    @Column(name = "code", length = 30)
    private String code;

    @Size(max = 100)
    @Nationalized
    @Column(name = "fullname", length = 100)
    private String fullname;

    @Size(max = 50)
    @Column(name = "username", length = 50)
    private String username;

    @Size(max = 70)
    @Column(name = "password", length = 70)
    private String password;

    @Lob
    @Column(name = "image")
    private String image;

    @Column(name = "gender")
    private Long gender;

    @Size(max = 20)
    @Column(name = "phone", length = 20)
    private String phone;

    @Size(max = 100)
    @Column(name = "email", length = 100)
    private String email;

    @ColumnDefault("0")
    @Column(name = "status")
    private Integer status;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private Set<Bill> bills = new HashSet<Bill>();

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private Set<Cart> carts = new HashSet<Cart>();

}