package com.forUMC.app.service.restaurant;

import com.forUMC.app.converter.RestaurantConverter;
import com.forUMC.app.domain.Restaurant;
import com.forUMC.app.domain.RestaurantCategory;
import com.forUMC.app.repository.RestaurantCategoryRepository;
import com.forUMC.app.repository.RestaurantRepository;
import com.forUMC.app.web.dto.RestaurantRequest;
import com.forUMC.global.apiPayLoad.code.status.ErrorStatus;
import com.forUMC.global.exception.handler.TempHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RestaurantCommandServiceImpl implements RestaurantCommandService{
    private final RestaurantRepository restaurantRepository;
    private final RestaurantCategoryRepository restaurantCategoryRepository;

    @Transactional
    @Override
    public Restaurant addRestaurant(RestaurantRequest.addRestaurantDTO request) {
        Restaurant newRestaurant = RestaurantConverter.toRestaurant(request);
        RestaurantCategory restaurantCategory = restaurantCategoryRepository.findById(request.getRestaurantCategoryId())
                .orElseThrow(() -> new TempHandler(ErrorStatus.RESTAURANT_CATEGORY_NOT_FOUND));
        newRestaurant.setRestaurantCategory(restaurantCategory);
        return restaurantRepository.save(newRestaurant);
    }
}
