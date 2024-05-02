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
    private Integer Id;

    @Column(name = "UnitPrice")
    private BigDecimal UnitPrice;

    @Column(name = "Quantity")
    private Integer Quantity;

    @Column(name = "IdColor")
    private Integer IdColor;

    @Column(name = "IdSize")
    private Integer IdSize;

    @ManyToOne
    @JoinColumn(name = "IdOrder")
    private Bill bill;

    @ManyToOne
    @JoinColumn(name = "IdProductDetail")
    private ProductDetail productDetail;

}