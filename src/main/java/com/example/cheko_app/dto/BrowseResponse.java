package com.example.cheko_app.dto;

import lombok.Data;


@Data
public class BrowseResponse {

    private String name;
    private Integer calories;
    private Double price;
    private Boolean isBestSeller;

}
