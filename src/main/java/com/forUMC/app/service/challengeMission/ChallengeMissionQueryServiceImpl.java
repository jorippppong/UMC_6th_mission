package com.forUMC.app.service.challengeMission;

import com.forUMC.app.repository.ChallengeMissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ChallengeMissionQueryServiceImpl implements ChallengeMissionQueryService{
    private final ChallengeMissionRepository challengeMissionRepository;
    @Override
    public boolean existsByMemberIdAndMissionId(Long memberId, Long missionId) {
        return challengeMissionRepository.existsByMemberIdAndMissionId(memberId, missionId);
    }
}
