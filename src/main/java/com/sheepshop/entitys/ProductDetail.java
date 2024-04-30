package com.sheepshop.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "Product_Detail")
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "Price")
    private BigDecimal price;

    @Column(name = "Discount")
    private Integer discount;

    @Column(name = "DiscountDate")
    private Instant discountDate;

    @Size(max = 255)
    @Nationalized
    @Column(name = "Description")
    private String description;

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "UpdateDate")
    private Date updateDate;

    @Size(max = 30)
    @Column(name = "CreateBy", length = 30)
    private String createBy;

    @Size(max = 30)
    @Column(name = "UpdateBy", length = 30)
    private String updateBy;

    @Column(name = "Status")
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "IdProduct")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "IdBrand")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "IdCollarStyle")
    private CollarStyle collarStyle;

    @ManyToOne
    @JoinColumn(name = "IdMaterial")
    private Material material;

    @ManyToOne
    @JoinColumn(name = "IdCategory")
    private Category category;

    @JsonIgnore
    @OneToMany(mappedBy = "productDetail")
    private Set<BillDetail> billDetails = new LinkedHashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "productDetail")
    private Set<CartDetail> cartDetails = new LinkedHashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "productDetail")
    private Set<ProductdetailColorSize> productdetailColorSizes = new LinkedHashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "productDetail")
    private Set<ProductFault> productFaults = new LinkedHashSet<>();

}