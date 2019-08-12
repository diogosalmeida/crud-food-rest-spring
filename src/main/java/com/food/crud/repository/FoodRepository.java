package com.food.crud.repository;

import com.food.crud.model.Food;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends PagingAndSortingRepository<Food, Long> {
    @Override
    List<Food> findAll();
}
