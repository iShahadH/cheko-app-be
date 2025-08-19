package com.example.cheko_app.controllers;


import com.example.cheko_app.dto.ApiResponse;
import com.example.cheko_app.services.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("restaurant")
public class RestaurantController {
    private final RestaurantService restaurantService;

    @GetMapping("browse")
    public ResponseEntity<?> browse() {
        return ApiResponse.getSuccessResponse(restaurantService.browse());
    }

}
