package com.sheepshop.entitys;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 15)
    @Nationalized
    @Column(name = "name", length = 15)
    private String name;

    @OneToMany(mappedBy = "role" , fetch = FetchType.EAGER)
    private Set<UserRole> userRoles = new LinkedHashSet<>();

}