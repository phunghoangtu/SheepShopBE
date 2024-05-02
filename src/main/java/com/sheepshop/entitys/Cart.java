package com.sheepshop.entitys;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Cart implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer Id;

    @ManyToOne
    @JoinColumn(name = "IdCustomer")
    private Customer customer;

    @OneToMany(mappedBy = "cart")
    private Set<CartDetail> cartDetails = new LinkedHashSet<>();

}