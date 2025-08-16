package com.example.cheko_app.mapper;


import com.example.cheko_app.dto.BrowseResponse;
import com.example.cheko_app.entities.Dish;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DishToBrowseResponseMapper {

    BrowseResponse map(Dish dish);

    List<BrowseResponse> mapAll(List<Dish> dishes);
}