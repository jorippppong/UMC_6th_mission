package com.forUMC.app.service.restaurant;

import com.forUMC.app.domain.Restaurant;
import com.forUMC.app.web.dto.RestaurantRequest;

public interface RestaurantCommandService {
    Restaurant addRestaurant(RestaurantRequest.addRestaurantDTO request);
}
