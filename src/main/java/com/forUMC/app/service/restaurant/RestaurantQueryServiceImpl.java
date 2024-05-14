package com.forUMC.app.service.restaurant;

import com.forUMC.app.domain.Restaurant;
import com.forUMC.app.domain.Review;
import com.forUMC.app.repository.RestaurantRepository;
import com.forUMC.app.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RestaurantQueryServiceImpl implements RestaurantQueryService{
    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public boolean existById(Long id) {
        return restaurantRepository.existsById(id);
    }

    @Override
    public Optional<Restaurant> findRestaurant(Long id) {
        return restaurantRepository.findById(id);
    }

    @Override
    public Page<Review> getReviewList(Long restaurantId, Integer page) {
        Restaurant restaurant = findRestaurant(restaurantId).get();
        return reviewRepository.findAllByRestaurant(restaurant, PageRequest.of(page, 10));
    }
}
