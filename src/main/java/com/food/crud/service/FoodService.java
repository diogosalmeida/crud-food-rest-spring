package com.food.crud.service;

import com.food.crud.dto.request.FoodRequestDto;
import com.food.crud.dto.response.FoodResponseDto;
import com.food.crud.model.Food;
import com.food.crud.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodService implements IFoodService {
    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public List<FoodResponseDto> findAll() {
        return foodRepository.findAll()
                .stream()
                .map(food -> new FoodResponseDto(food.getId(), food.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public FoodResponseDto findById(long id) {
        return foodRepository.findById(id).map(food -> new FoodResponseDto(food.getId(), food.getName()))
                             .orElseThrow(() -> new RuntimeException("Esta comida nãp existe"));
    }

    @Override
    public FoodResponseDto create(FoodRequestDto requestDto) {
        Food f = new Food();
        f.setName(requestDto.getName());
        f = foodRepository.save(f);
        return new FoodResponseDto(f.getId(), f.getName());
    }

    @Override
    public void delete(long id) {
         foodRepository.deleteById(id);
    }
}
