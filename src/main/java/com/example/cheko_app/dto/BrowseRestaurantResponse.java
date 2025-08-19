package com.example.cheko_app.dto;

import lombok.Data;


@Data
public class BrowseRestaurantResponse {

    private String id;
    private String name;
    private Double latitude;
    private Double longitude;

}
