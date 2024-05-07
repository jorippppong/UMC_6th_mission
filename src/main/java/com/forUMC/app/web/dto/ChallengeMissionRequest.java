package com.forUMC.app.web.dto;

import com.forUMC.global.validation.annotation.ExistMember;
import com.forUMC.global.validation.annotation.ExistMission;
import lombok.Getter;

public class ChallengeMissionRequest {
    @Getter
    public static class AddChallengingMissionDTO{
        @ExistMember
        private Long memberId;
        @ExistMission
        private Long missionId;
    }
}
