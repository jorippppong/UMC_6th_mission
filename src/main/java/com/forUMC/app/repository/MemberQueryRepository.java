package com.forUMC.app.repository;

import com.forUMC.app.domain.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberQueryRepository {
    @PersistenceContext
    private final EntityManager em;

    public Member getReviews(Long memberId, Integer page, Integer size){
        return em.createQuery(
                "select m from Member m"+
                " where m.id = :memberId", Member.class)
                .setParameter("memberId", memberId)
                .setFirstResult(page)
                .setMaxResults(size)
                .getSingleResult();
    }

}
