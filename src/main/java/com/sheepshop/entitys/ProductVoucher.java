package com.sheepshop.entitys;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "Product_Voucher")
public class ProductVoucher implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer Id;

    @ManyToOne
    @JoinColumn(name = "IdVoucher")
    private Voucher voucher;

    @ManyToOne
    @JoinColumn(name = "IdProduct")
    private Product product;

}