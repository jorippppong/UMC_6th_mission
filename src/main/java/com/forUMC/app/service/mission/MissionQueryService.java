package com.forUMC.app.service.mission;

import com.forUMC.app.domain.Mission;

import java.util.List;

public interface MissionQueryService {
    public boolean existById(Long id);
    public List<Mission> getChallengingMission(Long memberId, Integer page);
}
