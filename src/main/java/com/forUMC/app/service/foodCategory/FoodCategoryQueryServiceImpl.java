package com.forUMC.app.service.foodCategory;

import com.forUMC.app.repository.FoodCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FoodCategoryQueryServiceImpl implements FoodCategoryQueryService {
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    public boolean existById(List<Long> ids) {
        return ids.stream()
                .allMatch(foodCategoryRepository::existsById);
    }
}
