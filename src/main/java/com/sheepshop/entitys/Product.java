package com.sheepshop.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "collar_style_id")
    private CollarStyle collarStyle;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;

    @ManyToOne
    @JoinColumn(name = "size_id")
    private com.sheepshop.entitys.Size size;

    @ManyToOne
    @JoinColumn(name = "material_id")
    private Material material;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "image_id")
    private Image image;

    @Size(max = 30)
    @Column(name = "code", length = 30)
    private String code;

    @Size(max = 50)
    @Nationalized
    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price", precision = 18)
    private BigDecimal price;

    @Nationalized
    @Lob
    @Column(name = "description")
    private String description;

    @ColumnDefault("0")
    @Column(name = "status")
    private Integer status;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private Set<BillDetail> billDetails = new HashSet<BillDetail>();

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private Set<CartDetail> cartDetails = new HashSet<CartDetail>();

}