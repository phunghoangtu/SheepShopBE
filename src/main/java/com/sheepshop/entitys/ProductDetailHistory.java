package com.sheepshop.entitys;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Nationalized;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "ProductDetailHistory")
public class ProductDetailHistory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer Id;

    @Lob
    @Column(name = "ImageMain")
    private String ImageMain;

    @Lob
    @Column(name = "ImageList")
    private String ImageList;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UpdateDate")
    private Date UpdateDate;

    @Size(max = 30)
    @Column(name = "UpdateBy", length = 30)
    private String UpdateBy;

    @Size(max = 100)
    @Nationalized
    @Column(name = "Name", length = 100)
    private String Name;

    @Column(name = "Price")
    private BigDecimal Price;

    @Column(name = "Weight")
    private Double Weight;

    @Size(max = 255)
    @Nationalized
    @Column(name = "Description")
    private String Description;

    @Column(name = "IdCategory")
    private Integer IdCategory;

    @Column(name = "IdBrand")
    private Integer IdBrand;

    @Column(name = "IdDesign")
    private Integer IdDesign;

    @Lob
    @Column(name = "IdMaterial")
    private String IdMaterial;

    @Lob
    @Column(name = "IdVoucher")
    private String IdVoucher;

    @Lob
    @Column(name = "IdColor_Size_Quantity")
    private String IdcolorSizeQuantity;

    @Column(name = "Discount")
    private Integer Discount;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DiscountDate")
    private Date DiscountDate;

    @Size(max = 100)
    @Nationalized
    @Column(name = "SupplierName", length = 100)
    private String SupplierName;

    @Size(max = 15)
    @Column(name = "SupplierPhone", length = 15)
    private String SupplierPhone;

    @Size(max = 255)
    @Nationalized
    @Column(name = "SupplierAddress")
    private String SupplierAddress;

    @Size(max = 255)
    @Nationalized
    @Column(name = "SupplierAgree")
    private String SupplierAgree;

    @ManyToOne
    @JoinColumn(name = "IdProductDetail")
    @JsonBackReference
    private ProductDetail productDetail;


}