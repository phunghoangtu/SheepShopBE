package com.sheepshop.entitys;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "ProductDetail_Color_Size")
public class ProductdetailColorSize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "IdProductDetail")
    private ProductDetail productDetail;

    @ManyToOne
    @JoinColumn(name = "IdColor")
    private Color color;

    @ManyToOne
    @JoinColumn(name = "IdSize")
    private Size size;

    @Column(name = "Quantity")
    private Integer quantity;

}