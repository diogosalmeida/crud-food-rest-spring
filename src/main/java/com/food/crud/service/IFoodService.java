package com.food.crud.service;

import com.food.crud.dto.request.FoodRequestDto;
import com.food.crud.dto.response.FoodResponseDto;

import java.util.List;

public interface IFoodService {
    List<FoodResponseDto> findAll();

    FoodResponseDto findById(long id);

    FoodResponseDto create(FoodRequestDto requestDto);

    void delete(long id);
}
