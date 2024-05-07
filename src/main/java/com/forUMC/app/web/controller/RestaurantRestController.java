package com.forUMC.app.web.controller;

import com.forUMC.app.converter.RestaurantConverter;
import com.forUMC.app.domain.Restaurant;
import com.forUMC.app.service.restaurant.RestaurantCommandService;
import com.forUMC.app.web.dto.RestaurantRequest;
import com.forUMC.app.web.dto.RestaurantResponse;
import com.forUMC.global.apiPayLoad.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurants")
@RequiredArgsConstructor
@Validated
public class RestaurantRestController {
    private final RestaurantCommandService restaurantCommandService;

    @PostMapping("/")
    public ApiResponse<RestaurantResponse.addRestaurantResultDTO> addRestaurant(
            @RequestBody @Valid RestaurantRequest.addRestaurantDTO request
    ){
        Restaurant restaurant = restaurantCommandService.addRestaurant(request);
        return ApiResponse.onSuccess(RestaurantConverter.toAddRestaurantResultDTO(restaurant));
    }

}
