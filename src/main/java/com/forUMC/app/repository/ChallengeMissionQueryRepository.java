package com.forUMC.app.repository;

import com.forUMC.app.domain.Mission;
import com.forUMC.app.domain.enums.MissionStatus;
import com.forUMC.app.domain.mapping.ChallengeMission;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ChallengeMissionQueryRepository {
    @PersistenceContext
    private final EntityManager em;

    public List<ChallengeMission> getChallengingMission(Long memberId, Integer page, Integer size){
        return em.createQuery(
                "select cm from ChallengeMission cm"+
                        " join fetch cm.mission cmMission"+
                        " join fetch cm.member cmMember"+
                        " where cmMember.id = :memberId and cm.missionStatus = :challenging", ChallengeMission.class)
                .setParameter("memberId", memberId)
                .setParameter("challenging", MissionStatus.CHALLENGING)
                .setFirstResult(page*size)
                .setMaxResults(size)
                .getResultList();
    }
}
