package com.sheepshop.entitys;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class BillDetail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
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