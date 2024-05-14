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

    public static MissionResponse.MissionListDTO<MissionResponse.RestaurantMissionDTO> toRestaurantMissionListDTO(Restaurant restaurant, Integer page){
        return MissionResponse.MissionListDTO.<MissionResponse.RestaurantMissionDTO>builder()
                .listSize(restaurant.getMissions().size())
                .listPage(page)
                .missionList(toRestaurantMissionDTO(restaurant.getMissions()))
                .build();
    }

    public static List<MissionResponse.RestaurantMissionDTO> toRestaurantMissionDTO(List<Mission> missionList){
        return missionList.stream().map(m ->
                MissionResponse.RestaurantMissionDTO.builder()
                        .point(m.getPoint())
                        .foodPrice(m.getFoodPrice())
                        .deadline(m.getDeadline())
                        .build())
                .toList();
    }
}
