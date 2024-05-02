package com.sheepshop.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class CartDetail implements Serializable {
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
    @JoinColumn(name = "IdCart")
    private Cart cart;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "IdProductDetail")
    private ProductDetail productDetail;

}