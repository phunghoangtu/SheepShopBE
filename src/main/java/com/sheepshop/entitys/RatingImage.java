package com.sheepshop.entitys;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class RatingImage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer Id;

    @Size(max = 255)
    @Column(name = "Url")
    private String Url;

    @ManyToOne
    @JoinColumn(name = "IdRating")
    private Rating rating;

}