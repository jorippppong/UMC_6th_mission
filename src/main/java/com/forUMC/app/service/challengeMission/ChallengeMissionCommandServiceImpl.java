package com.forUMC.app.service.challengeMission;

import com.forUMC.app.converter.ChallengeMissionConverter;
import com.forUMC.app.domain.Member;
import com.forUMC.app.domain.Mission;
import com.forUMC.app.domain.mapping.ChallengeMission;
import com.forUMC.app.repository.ChallengeMissionRepository;
import com.forUMC.app.repository.MemberRepository;
import com.forUMC.app.repository.MissionRepository;
import com.forUMC.app.web.dto.ChallengeMissionRequest;
import com.forUMC.global.apiPayLoad.code.status.ErrorStatus;
import com.forUMC.global.exception.handler.TempHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ChallengeMissionCommandServiceImpl implements ChallengeMissionCommandService {
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final ChallengeMissionRepository challengeMissionRepository;

    @Transactional
    @Override
    public ChallengeMission addChallengingMission(ChallengeMissionRequest.AddChallengingMissionDTO request) {
        ChallengeMission newChallengeMission = ChallengeMissionConverter.toChallengeMission();
        Member member = memberRepository.findById(request.getMemberId()).orElseThrow(() -> new TempHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Mission mission = missionRepository.findById(request.getMissionId()).orElseThrow(() -> new TempHandler(ErrorStatus.MEMBER_NOT_FOUND));
        newChallengeMission.setMember(member);
        newChallengeMission.setMission(mission);
        return challengeMissionRepository.save(newChallengeMission);
    }

    @Override
    @Transactional
    public ChallengeMission completeChallengingMission(Long id) {
        ChallengeMission challengeMission = challengeMissionRepository.findById(id).orElseThrow(() -> new TempHandler(ErrorStatus.CHALLENGE_MISSION_NOT_EXISTS));
        challengeMission.completeMission();
        return challengeMission;
    }
}
