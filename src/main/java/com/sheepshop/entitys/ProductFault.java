package com.sheepshop.entitys;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Nationalized;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "Product_Fault")
public class ProductFault {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @Nationalized
    @Column(name = "Note")
    private String note;

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "IdColor")
    private Integer idColor;

    @Column(name = "IdSize")
    private Integer idSize;

    @Column(name = "IdCollarStyle")
    private Integer idCollarStyle;

    @ManyToOne
    @JoinColumn(name = "IdProductDetail")
    private ProductDetail productDetail;

}