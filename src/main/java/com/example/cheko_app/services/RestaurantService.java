package com.example.cheko_app.services;

import com.example.cheko_app.dto.BrowseRestaurantResponse;
import com.example.cheko_app.mapper.RestaurantToBrowseRestaurantResponseMapper;
import com.example.cheko_app.repositories.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantToBrowseRestaurantResponseMapper restaurantToBrowseRestaurantResponseMapper;

    public List<BrowseRestaurantResponse> browse() {
        return restaurantToBrowseRestaurantResponseMapper.mapAll(restaurantRepository.findAll());
    }
}
