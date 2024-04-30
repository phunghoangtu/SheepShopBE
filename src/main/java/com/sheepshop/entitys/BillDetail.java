package com.sheepshop.entitys;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "Bill_Detail")
public class BillDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "UnitPrice")
    private BigDecimal unitPrice;

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "IdColor")
    private Integer idColor;

    @Column(name = "IdSize")
    private Integer idSize;

    @ManyToOne
    @JoinColumn(name = "IdOrder")
    private Bill bill;

    @ManyToOne
    @JoinColumn(name = "IdProductDetail")
    private ProductDetail productDetail;

}