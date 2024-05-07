package com.forUMC.app.web.controller;

import com.forUMC.app.converter.ChallengeMissionConverter;
import com.forUMC.app.domain.mapping.ChallengeMission;
import com.forUMC.app.service.challengeMission.ChallengeMissionCommandService;
import com.forUMC.app.web.dto.ChallengeMissionRequest;
import com.forUMC.app.web.dto.ChallengeMissionResponse;
import com.forUMC.global.apiPayLoad.ApiResponse;
import com.forUMC.global.validation.annotation.ExistChallengeMission;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missions/challenge")
@RequiredArgsConstructor
@Validated
public class ChallengeMissionController {
    private final ChallengeMissionCommandService challengeMissionCommandService;

    @PutMapping("")
    public ApiResponse<ChallengeMissionResponse.AddChallengingMissionResultDTO> addChallengingMission(
            @RequestBody @ExistChallengeMission @Valid ChallengeMissionRequest.AddChallengingMissionDTO request
        ){
        ChallengeMission challengeMission = challengeMissionCommandService.addChallengingMission(request);
        return ApiResponse.onSuccess(ChallengeMissionConverter.toAddChallengingMissionResultDTO(challengeMission));
    }
}
