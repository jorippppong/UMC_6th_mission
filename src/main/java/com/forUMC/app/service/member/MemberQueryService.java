package com.forUMC.app.service.member;

import com.forUMC.app.domain.Member;

public interface MemberQueryService {
    public boolean existById(Long id);
    public Member getReviews(Long memberId, Integer page);
}
