package com.spring.sheepshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Material")
public class Material implements Serializable {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer Id;
    @Column(name = "CreateDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date CreateDate;
    @Column(name = "UpdateDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date UpdateDate;
    @Column(name = "CreateBy")
    private String CreateBy;
    @Column(name = "UpdateBy")
    private String UpdateBy;
    @Column(name = "Status")
    private Integer Status;
    @Column(name = "Name")
    private String Name;
    @Column(name = "Description")
    private String Description;
    @JsonIgnore
    @OneToMany(mappedBy = "material")
    private Set<ProductDetail_Material> productDetail_materials = new HashSet<ProductDetail_Material>();
}