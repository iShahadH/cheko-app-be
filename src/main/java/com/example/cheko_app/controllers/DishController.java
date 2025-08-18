package com.example.cheko_app.controllers;


import com.example.cheko_app.dto.ApiResponse;
import com.example.cheko_app.services.DishService;
import com.example.cheko_app.validators.DishExists;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("dish")
public class DishController {
    private final DishService dishService;

    @GetMapping("browse")
    public ResponseEntity<?> browse(
            @RequestParam(value = "search", required = false) String search,
            @RequestParam(value = "type", required = false) Long type) {
        return ApiResponse.getSuccessResponse(dishService.browse(search, type));
    }

    @GetMapping("/count-by-type")
    public ResponseEntity<?> getDishCountsByType() {
        return ResponseEntity.ok(dishService.countGroupedByType());
    }

    @GetMapping("details/{dishId}")
    public ResponseEntity<?> getDishDetails(@PathVariable @DishExists Long dishId) {
        return ResponseEntity.ok(dishService.details(dishId));
    }

}
