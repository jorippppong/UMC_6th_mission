package com.forUMC.app.service.restautantCategory;

import com.forUMC.app.repository.RestaurantCategoryRepository;
import com.forUMC.app.service.restaurant.RestaurantQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestaurantCategoryQueryServiceImpl implements RestaurantCategoryQueryService {
    private final RestaurantCategoryRepository restaurantCategoryRepository;

    @Override
    public boolean existById(Long id) {
        return restaurantCategoryRepository.existsById(id);
    }
}
