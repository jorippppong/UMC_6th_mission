package com.forUMC.app.converter;

import com.forUMC.app.domain.mapping.ChallengeMission;
import com.forUMC.app.web.dto.ChallengeMissionResponse.AddChallengingMissionResultDTO;

public class ChallengeMissionConverter {
    public static AddChallengingMissionResultDTO toAddChallengingMissionResultDTO(ChallengeMission challengeMission){
        return AddChallengingMissionResultDTO.builder()
                .challengeMissionId(challengeMission.getId())
                .missionStatus(challengeMission.getMissionStatus().toString())
                .createdAt(challengeMission.getCreatedAt())
                .build();
    }

    public static ChallengeMission toChallengeMission(){
        return ChallengeMission.builder().build();
    }
}
