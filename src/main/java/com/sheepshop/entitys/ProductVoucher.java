package com.sheepshop.entitys;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "Product_Voucher")
public class ProductVoucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "IdVoucher")
    private Voucher voucher;

    @ManyToOne
    @JoinColumn(name = "IdProduct")
    private Product product;

}