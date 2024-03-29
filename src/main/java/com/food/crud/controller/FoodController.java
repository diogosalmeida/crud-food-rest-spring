package com.food.crud.controller;

import com.food.crud.dto.request.FoodRequestDto;
import com.food.crud.dto.response.FoodResponseDto;
import com.food.crud.repository.FoodRepository;
import com.food.crud.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    final
    IFoodService foodService;

    public FoodController(IFoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping
    public ResponseEntity<List<FoodResponseDto>> getAllFoods() {
        return ResponseEntity.ok(foodService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<FoodResponseDto> getFoodById(@PathVariable long id) {
        return ResponseEntity.ok(foodService.findById(id));
    }

    @PostMapping
    public ResponseEntity<FoodResponseDto> createFood(@RequestBody FoodRequestDto req) {
        return ResponseEntity.status(HttpStatus.CREATED).body(foodService.create(req));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteFood(@PathVariable long id) {
        try {
            foodService.delete(id);
            return ResponseEntity.ok("Food delete");
        } catch (Exception e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }
}
