package com.forUMC.app.web.dto;

import com.forUMC.global.validation.annotation.ExistRestaurantCategories;
import lombok.Getter;

public class RestaurantRequest {

    @Getter
    public static class addRestaurantDTO{
        private String name;
        private String address;
        @ExistRestaurantCategories
        private Long restaurantCategoryId;
    }
}
