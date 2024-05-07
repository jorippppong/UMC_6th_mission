package com.forUMC.global.validation.validator;

import com.forUMC.app.domain.mapping.ChallengeMission;
import com.forUMC.app.repository.ChallengeMissionRepository;
import com.forUMC.app.web.dto.ChallengeMissionRequest;
import com.forUMC.global.apiPayLoad.code.status.ErrorStatus;
import com.forUMC.global.validation.annotation.ExistChallengeMission;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChallengeMissionExistValidator implements ConstraintValidator<ExistChallengeMission, ChallengeMissionRequest.AddChallengingMissionDTO> {
    private final ChallengeMissionRepository challengeMissionRepository;

    @Override
    public void initialize(ExistChallengeMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(ChallengeMissionRequest.AddChallengingMissionDTO value, ConstraintValidatorContext context) {
        boolean isValid = !challengeMissionRepository.existsByMemberIdAndMissionId(value.getMemberId(), value.getMissionId());

        if(!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.CHALLENGE_MISSION_EXISTS.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
