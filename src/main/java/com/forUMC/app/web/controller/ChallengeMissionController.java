package com.forUMC.app.web.controller;

import com.forUMC.app.converter.ChallengeMissionConverter;
import com.forUMC.app.domain.mapping.ChallengeMission;
import com.forUMC.app.service.challengeMission.ChallengeMissionCommandService;
import com.forUMC.app.web.dto.ChallengeMissionRequest;
import com.forUMC.app.web.dto.ChallengeMissionResponse;
import com.forUMC.global.apiPayLoad.ApiResponse;
import com.forUMC.global.validation.annotation.ExistChallengeMission;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
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

    @PostMapping("/new")
    public ApiResponse<ChallengeMissionResponse.AddChallengingMissionResultDTO> addChallengingMission(
            @RequestBody @ExistChallengeMission @Valid ChallengeMissionRequest.AddChallengingMissionDTO request
        ){
        ChallengeMission challengeMission = challengeMissionCommandService.addChallengingMission(request);
        return ApiResponse.onSuccess(ChallengeMissionConverter.toAddChallengingMissionResultDTO(challengeMission));
    }

    // TODO 이미 완료되었는지 validation
    @PatchMapping("/complete/{challengingMissionId}")
    @Operation(summary = "진행 중인 미션 진행 완료로 바꾸기 API", description = "진행 중인 미션 진행 완료로 바꾸는 API입니다.")
    @Parameters({
            @Parameter(name = "challengingMissionId", description = "challengingMission ID, path variable 입니다.")
    })
    public ApiResponse<ChallengeMissionResponse.AddChallengingMissionResultDTO> completeChallengingMission(
            @PathVariable(name = "challengingMissionId") Long id
    ){
        ChallengeMission challengeMission = challengeMissionCommandService.completeChallengingMission(id);
        return ApiResponse.onSuccess(ChallengeMissionConverter.toAddChallengingMissionResultDTO(challengeMission));
    }
}
