package com.forUMC.app.service.challengeMission;

public interface ChallengeMissionQueryService {
    public boolean existsByMemberIdAndMissionId(Long memberId, Long missionId);
}
