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
@Table(name = "ProductDetail_Material")
public class ProductdetailMaterial implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer Id;

    @ManyToOne
    @JoinColumn(name = "IdProductDetail")
    private ProductDetail productDetail;

    @ManyToOne
    @JoinColumn(name = "IdMaterial")
    private Material material;

}