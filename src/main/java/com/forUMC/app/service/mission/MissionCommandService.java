package com.forUMC.app.service.mission;

import com.forUMC.app.domain.Mission;
import com.forUMC.app.web.dto.MissionRequest;

public interface MissionCommandService {
    Mission addMission(Long restaurantId, MissionRequest.addMissionDTO request);
}
