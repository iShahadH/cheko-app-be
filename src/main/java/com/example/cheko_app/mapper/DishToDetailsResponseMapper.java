package com.example.cheko_app.mapper;


import com.example.cheko_app.dto.DetailsDishResponse;
import com.example.cheko_app.entities.Dish;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DishToDetailsResponseMapper {

    DetailsDishResponse map(Dish dish);

    List<DetailsDishResponse> mapAll(List<Dish> dishes);
}