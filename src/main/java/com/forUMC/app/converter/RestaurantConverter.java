package com.forUMC.app.converter;

import com.forUMC.app.domain.Restaurant;
import com.forUMC.app.web.dto.RestaurantRequest;
import com.forUMC.app.web.dto.RestaurantResponse;

import java.util.ArrayList;

public class RestaurantConverter {

    public static Restaurant toRestaurant(RestaurantRequest.addRestaurantDTO request){
        return Restaurant.builder()
                .name(request.getName())
                .address(request.getAddress())
                .reviews(new ArrayList<>())
                .build();
    }

    public static RestaurantResponse.addRestaurantResultDTO toAddRestaurantResultDTO(Restaurant restaurant){
        return RestaurantResponse.addRestaurantResultDTO.builder()
                .restaurantId(restaurant.getId())
                .createdAt(restaurant.getCreatedAt())
                .build();
    }


}
