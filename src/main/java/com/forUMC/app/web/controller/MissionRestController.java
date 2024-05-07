package com.forUMC.app.web.controller;

import com.forUMC.app.converter.MissionConverter;
import com.forUMC.app.domain.Mission;
import com.forUMC.app.service.mission.MissionCommendService;
import com.forUMC.app.web.dto.MissionRequest;
import com.forUMC.app.web.dto.MissionResponse;
import com.forUMC.global.apiPayLoad.ApiResponse;
import com.forUMC.global.validation.annotation.ExistRestaurants;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
@Validated
public class MissionRestController {
    private final MissionCommendService missionCommendService;

    @PostMapping("")
    public ApiResponse<MissionResponse.addMissionResultDTO> addMission(
            @ExistRestaurants @RequestParam(value = "restaurantId", required = true) Long restaurantId,
            @RequestBody @Valid MissionRequest.addMissionDTO request
        ){
        Mission mission = missionCommendService.addMission(restaurantId, request);
        return ApiResponse.onSuccess(MissionConverter.toAddMissionResultDTO(mission));
    }
}
