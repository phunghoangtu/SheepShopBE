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
public class Background implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer Id;

    @Size(max = 30)
    @Column(name = "Type", length = 30)
    private String Type;

    @Size(max = 255)
    @Column(name = "Url")
    private String Url;

    @Size(max = 255)
    @Nationalized
    @Column(name = "Content")
    private String Content;

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

}