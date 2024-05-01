package com.sheepshop.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Nationalized;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "\"Size\"")
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @jakarta.validation.constraints.Size(max = 100)
    @Nationalized
    @Column(name = "Name", length = 100)
    private String name;

    @jakarta.validation.constraints.Size(max = 255)
    @Nationalized
    @Column(name = "Description")
    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CreateDate")
    private Date createDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UpdateDate")
    private Date updateDate;

    @jakarta.validation.constraints.Size(max = 30)
    @Column(name = "CreateBy", length = 30)
    private String createBy;

    @jakarta.validation.constraints.Size(max = 30)
    @Column(name = "UpdateBy", length = 30)
    private String updateBy;

    @Column(name = "Status")
    private Integer status;

    @JsonIgnore
    @OneToMany(mappedBy = "size")
    private Set<ProductdetailColorSize> productdetailColorSizes = new LinkedHashSet<>();

}