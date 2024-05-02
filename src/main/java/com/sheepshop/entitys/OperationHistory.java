package com.sheepshop.entitys;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Nationalized;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class OperationHistory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer Id;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CreateDate")
    private Date CreateDate;

    @Size(max = 100)
    @Nationalized
    @Column(name = "CreateBy", length = 100)
    private String CreateBy;

    @Column(name = "IdProductDetail")
    private Integer IdProductDetail;

    @Column(name = "Status")
    private Integer Status;

}