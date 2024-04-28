package com.sheepshop.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "\"size\"")
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @jakarta.validation.constraints.Size(max = 50)
    @Nationalized
    @Column(name = "name", length = 50)
    private String name;

    @Nationalized
    @Lob
    @Column(name = "description")
    private String description;

    @ColumnDefault("0")
    @Column(name = "status")
    private Integer status;

    @JsonIgnore
    @OneToMany(mappedBy = "size")
    private Set<Product> products = new HashSet<Product>();

}