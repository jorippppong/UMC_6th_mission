package com.forUMC.app.service.restaurant;

import com.forUMC.app.domain.Restaurant;
import com.forUMC.app.domain.Review;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface RestaurantQueryService {
    public boolean existById(Long id);
    Optional<Restaurant> findRestaurant(Long id);
    Page<Review> getReviewList(Long restaurantId, Integer page);
    Restaurant getMissions(Long restaurantId, Integer page);
}
