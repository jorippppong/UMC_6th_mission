package com.forUMC.app.converter;

import com.forUMC.app.domain.Mission;
import com.forUMC.app.web.dto.MissionRequest;
import com.forUMC.app.web.dto.MissionResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MissionConverter {
    public static MissionResponse.addMissionResultDTO toAddMissionResultDTO(Mission mission){
        return MissionResponse.addMissionResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(mission.getCreatedAt())
                .build();
    }

    public static Mission toMission(MissionRequest.addMissionDTO request){
        return Mission.builder()
                .point(request.getPoint())
                .foodPrice(request.getFoodPrice())
                // TODO .deadline(request.getDeadline())
                .deadline(LocalDate.now())
                .build();
    }
}
