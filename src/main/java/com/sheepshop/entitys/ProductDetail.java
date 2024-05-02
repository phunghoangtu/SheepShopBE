package com.sheepshop.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Nationalized;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class ProductDetail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer Id;

    @Column(name = "Weight")
    private Double Weight;

    @Column(name = "Price")
    private BigDecimal Price;

    @Column(name = "Discount")
    private Integer Discount;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DiscountDate")
    private Date DiscountDate;

    @Size(max = 255)
    @Nationalized
    @Column(name = "Description")
    private String Description;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CreateDate")
    private Date CreateDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UpdateDate")
    private Date UpdateDate;

    @Size(max = 30)
    @Column(name = "CreateBy", length = 30)
    private String CreateBy;

    @Size(max = 30)
    @Column(name = "UpdateBy", length = 30)
    private String UpdateBy;

    @Column(name = "Status")
    private Integer Status;

    @ManyToOne
    @JoinColumn(name = "IdProduct")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "IdBrand")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "IdCategory")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "IdDesign")
    private Design design;

    @JsonIgnore
    @OneToMany(mappedBy = "productDetail")
    private Set<BillDetail> billDetails = new LinkedHashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "productDetail")
    private Set<CartDetail> cartDetails = new LinkedHashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "productDetail")
    private Set<ProductDetailHistory> productDetailHistories = new LinkedHashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "productDetail")
    private Set<ProductdetailColorSize> productdetailColorSizes = new LinkedHashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "productDetail")
    private Set<ProductdetailMaterial> productdetailMaterials = new LinkedHashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "productDetail")
    private Set<ProductFault> productFaults = new LinkedHashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "productDetail")
    private Set<Rating> ratings = new LinkedHashSet<>();

}