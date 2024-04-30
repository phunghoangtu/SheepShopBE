package com.sheepshop.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "\"size\"")
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @jakarta.validation.constraints.Size(max = 100)
    @Nationalized
    @Column(name = "name", length = 100)
    private String name;

    @jakarta.validation.constraints.Size(max = 255)
    @Nationalized
    @Column(name = "description")
    private String description;

    @Column(name = "create_date")
    private Instant createDate;

    @Column(name = "update_date")
    private Instant updateDate;

    @jakarta.validation.constraints.Size(max = 30)
    @Column(name = "create_by", length = 30)
    private String createBy;

    @jakarta.validation.constraints.Size(max = 30)
    @Column(name = "update_by", length = 30)
    private String updateBy;

    @Column(name = "status")
    private Integer status;

    @JsonIgnore
    @OneToMany(mappedBy = "size")
    private Set<ProductDetailColorSize> productDetailColorSizes = new LinkedHashSet<>();

}