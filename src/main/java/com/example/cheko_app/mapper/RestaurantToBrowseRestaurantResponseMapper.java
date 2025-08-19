package com.example.cheko_app.mapper;


import com.example.cheko_app.dto.BrowseRestaurantResponse;
import com.example.cheko_app.entities.Restaurant;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RestaurantToBrowseRestaurantResponseMapper {

    BrowseRestaurantResponse map(Restaurant restaurant);

    List<BrowseRestaurantResponse> mapAll(List<Restaurant> restaurants);
}