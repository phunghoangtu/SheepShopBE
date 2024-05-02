package com.sheepshop.entitys;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class ProductFault implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer Id;

    @Size(max = 255)
    @Nationalized
    @Column(name = "Note")
    private String Note;

    @Column(name = "IdColor")
    private Integer IdColor;

    @Column(name = "IdSize")
    private Integer IdSize;

    @Column(name = "Quantity")
    private Integer Quantity;

    @ManyToOne
    @JoinColumn(name = "IdProductDetail")
    private ProductDetail productDetail;

}