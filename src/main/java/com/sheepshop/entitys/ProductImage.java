package com.sheepshop.entitys;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "Product_Image")
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @Column(name = "Url")
    private String url;

    @Column(name = "MainImage")
    private Boolean mainImage;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CreateDate")
    private Date createDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
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

}