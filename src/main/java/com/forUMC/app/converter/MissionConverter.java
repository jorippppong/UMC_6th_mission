package com.forUMC.app.converter;

import com.forUMC.app.domain.Mission;
import com.forUMC.app.domain.Restaurant;
import com.forUMC.app.web.dto.MissionRequest;
import com.forUMC.app.web.dto.MissionResponse;

import java.time.LocalDate;
import java.util.List;

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
                .deadline(request.getDeadLine())
                .deadline(LocalDate.now())
                .build();
    }

    public static MissionResponse.MissionListDTO<MissionResponse.MissionDTO> toMissionListDTO(Restaurant restaurant, Integer page){
        return MissionResponse.MissionListDTO.<MissionResponse.MissionDTO>builder()
                .listSize(restaurant.getMissions().size())
                .listPage(page)
                .missionList(toRestaurantMissionDTO(restaurant.getMissions()))
                .build();
    }

    public static MissionResponse.MissionListDTO<MissionResponse.MissionDTO> toMissionListDTO(List<Mission> missionList, Integer page){
        return MissionResponse.MissionListDTO.<MissionResponse.MissionDTO>builder()
                .listSize(missionList.size())
                .listPage(page)
                .missionList(toRestaurantMissionDTO(missionList))
                .build();
    }

    public static List<MissionResponse.MissionDTO> toRestaurantMissionDTO(List<Mission> missionList){
        return missionList.stream().map(m ->
                MissionResponse.MissionDTO.builder()
                        .point(m.getPoint())
                        .foodPrice(m.getFoodPrice())
                        .deadline(m.getDeadline())
                        .build())
                .toList();
    }
}
