package com.example.cheko_app.dto;

import lombok.Data;


@Data
public class BrowseResponse {

    private String name;
    private String description;
    private Integer calories;
    private Double price;

}
