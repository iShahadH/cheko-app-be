package com.example.cheko_app.mapper;


import com.example.cheko_app.dto.DetailsResponse;
import com.example.cheko_app.entities.Dish;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DishToDetailsResponseMapper {

    DetailsResponse map(Dish dish);

    List<DetailsResponse> mapAll(List<Dish> dishes);
}