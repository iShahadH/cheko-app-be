package com.example.cheko_app.controllers;


import com.example.cheko_app.dto.ApiResponse;
import com.example.cheko_app.dto.QuantityActionRequest;
import com.example.cheko_app.services.DishService;
import com.example.cheko_app.validators.DishExists;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("dish")
public class DishController {
    private final DishService dishService;

    @GetMapping("browse")
    public ResponseEntity<?> browse(
            @RequestParam(value = "search", required = false) String search,
            @RequestParam(value = "type", required = false) Long type) { //Parameter validation can be applied here.
        return ApiResponse.getSuccessResponse(dishService.browse(search, type));
    }

    @GetMapping("/count-by-type")
    public ResponseEntity<?> getDishCountsByType() {
        return ApiResponse.getSuccessResponse(dishService.countGroupedByType());
    }

    @GetMapping("details/{dishId}")
    public ResponseEntity<?> getDishDetails(@PathVariable @DishExists Long dishId) {
        return ApiResponse.getSuccessResponse(dishService.details(dishId));
    }

    @GetMapping("image/{dishId}")
    public ResponseEntity<?> getDishImage(@PathVariable Long dishId) throws Exception {
        return ResponseEntity.ok(dishService.getDishImage(dishId));
    }

    // We can combine this into a single API that receives an action and performs the corresponding operation.
    @PostMapping("increase/quantity")
    public ResponseEntity<?> increaseQuantity(
            @RequestBody QuantityActionRequest request) {

        dishService.increase(request.getDishId());
        return ApiResponse.getSuccessResponse();
    }

    @PostMapping("decrease/quantity")
    public ResponseEntity<?> decreaseQuantity(
            @RequestBody QuantityActionRequest request) {

        dishService.decrease(request.getDishId());
        return ApiResponse.getSuccessResponse();
    }

    @GetMapping("second-highest-calorie")
    public ResponseEntity<?> getSecondHighestCalorie() {
        return ApiResponse.getSuccessResponse(dishService.getSecondHighestCalorie());
    }

    //Helper method to handle image uploads
    @PostMapping("image/{dishId}")
    public ResponseEntity<?> uploadDishImage(@PathVariable Long dishId,
                                             @RequestParam("file") MultipartFile file) throws IOException {
        dishService.uploadDishImage(dishId, file);
        return ResponseEntity.ok().build();
    }

}
