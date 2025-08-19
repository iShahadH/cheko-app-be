package com.example.cheko_app.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@Table(name = "dish")
public class Dish {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private MasterType type;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer calories;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Boolean isBestSeller = false;

    @Column(name = "s3_url")
    private String s3Url;

}