package com.example.cheko_app.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "mst_type")
public class MasterType {

    @Id
    private Long id;

    @Column(nullable = false)
    private String nameAr;

    @Column(nullable = false)
    private String nameEn;
}