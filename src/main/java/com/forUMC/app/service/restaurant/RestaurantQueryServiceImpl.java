package com.forUMC.app.service.restaurant;

import com.forUMC.app.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestaurantQueryServiceImpl implements RestaurantQueryService{
    private final RestaurantRepository restaurantRepository;

    @Override
    public boolean existById(Long id) {
        return restaurantRepository.existsById(id);
    }
}
