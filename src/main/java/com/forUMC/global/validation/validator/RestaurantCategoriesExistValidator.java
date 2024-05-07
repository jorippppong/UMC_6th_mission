package com.forUMC.global.validation.validator;

import com.forUMC.app.service.restautantCategory.RestaurantCategoryQueryService;
import com.forUMC.global.apiPayLoad.code.status.ErrorStatus;
import com.forUMC.global.validation.annotation.ExistRestaurantCategories;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RestaurantCategoriesExistValidator implements ConstraintValidator<ExistRestaurantCategories, Long> {
    private final RestaurantCategoryQueryService restaurantCategoryQueryService;

    @Override
    public void initialize(ExistRestaurantCategories constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = restaurantCategoryQueryService.existById(value);

        if(!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.RESTAURANT_CATEGORY_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
