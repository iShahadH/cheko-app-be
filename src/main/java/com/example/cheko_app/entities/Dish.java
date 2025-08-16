package com.example.cheko_app.entities;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

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

}