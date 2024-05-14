package com.forUMC.global.validation.validator;

import com.forUMC.global.apiPayLoad.code.status.ErrorStatus;
import com.forUMC.global.validation.annotation.PageNumberOverOne;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class PageNumberOverOneValidator implements ConstraintValidator<PageNumberOverOne, Integer> {

    @Override
    public void initialize(PageNumberOverOne constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        boolean isValid = value >= 1;

        if(!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.PAGE_NUMBER_UNDER_ONE.toString()).addConstraintViolation();
        }
        return isValid;
    }
}
