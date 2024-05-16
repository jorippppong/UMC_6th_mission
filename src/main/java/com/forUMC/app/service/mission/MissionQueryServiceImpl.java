package com.forUMC.app.service.mission;

import com.forUMC.app.domain.Mission;
import com.forUMC.app.domain.mapping.ChallengeMission;
import com.forUMC.app.repository.ChallengeMissionQueryRepository;
import com.forUMC.app.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService{
    private final MissionRepository missionRepository;
    private final ChallengeMissionQueryRepository challengeMissionQueryRepository;

    @Override
    public boolean existById(Long id) {
        return missionRepository.existsById(id);
    }

    @Override
    public List<Mission> getChallengingMission(Long memberId, Integer page) {
        return challengeMissionQueryRepository.getChallengingMission(memberId, page-1, 10)
                .stream().map(ChallengeMission::getMission).toList();
    }
}
