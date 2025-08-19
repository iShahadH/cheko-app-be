package com.example.cheko_app.mapper;


import com.example.cheko_app.dto.BrowseDishResponse;
import com.example.cheko_app.entities.Dish;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DishToBrowseDishResponseMapper {

    BrowseDishResponse map(Dish dish);

    List<BrowseDishResponse> mapAll(List<Dish> dishes);
}