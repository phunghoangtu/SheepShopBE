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
@Table(name = "ProductDetail_Color_Size")
public class ProductdetailColorSize implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer Id;

    @ManyToOne
    @JoinColumn(name = "IdProductDetail")
    private ProductDetail productDetail;

    @ManyToOne
    @JoinColumn(name = "IdColor")
    private Color color;

    @ManyToOne
    @JoinColumn(name = "IdSize")
    private Size size;

    @Column(name = "Quantity")
    private Integer Quantity;

}