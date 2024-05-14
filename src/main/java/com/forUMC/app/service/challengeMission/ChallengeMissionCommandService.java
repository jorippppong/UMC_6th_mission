package com.forUMC.app.service.challengeMission;

import com.forUMC.app.domain.mapping.ChallengeMission;
import com.forUMC.app.web.dto.ChallengeMissionRequest;

public interface ChallengeMissionCommandService {
    ChallengeMission addChallengingMission(ChallengeMissionRequest.AddChallengingMissionDTO request);

    ChallengeMission completeChallengingMission(Long id);
}
