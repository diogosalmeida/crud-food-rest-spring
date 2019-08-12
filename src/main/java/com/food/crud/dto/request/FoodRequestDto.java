package com.food.crud.dto.request;

public class FoodRequestDto {
    private String name;

    public FoodRequestDto(String name) {
        this.name = name;
    }

    public  FoodRequestDto () {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
