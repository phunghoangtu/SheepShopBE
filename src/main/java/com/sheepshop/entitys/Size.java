package com.sheepshop.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Nationalized;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Size implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer Id;

    @jakarta.validation.constraints.Size(max = 100)
    @Nationalized
    @Column(name = "Name", length = 100)
    private String Name;

    @jakarta.validation.constraints.Size(max = 255)
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

    @jakarta.validation.constraints.Size(max = 30)
    @Column(name = "CreateBy", length = 30)
    private String CreateBy;

    @jakarta.validation.constraints.Size(max = 30)
    @Column(name = "UpdateBy", length = 30)
    private String UpdateBy;

    @Column(name = "Status")
    private Integer Status;

    @JsonIgnore
    @OneToMany(mappedBy = "size")
    private Set<ProductdetailColorSize> productdetailColorSizes = new LinkedHashSet<>();

}