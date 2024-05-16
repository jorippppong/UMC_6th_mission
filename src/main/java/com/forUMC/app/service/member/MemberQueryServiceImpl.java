package com.forUMC.app.service.member;

import com.forUMC.app.domain.Member;
import com.forUMC.app.repository.MemberQueryRepository;
import com.forUMC.app.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService{
    private final MemberRepository memberRepository;
    private final MemberQueryRepository memberQueryRepository;

    @Override
    public boolean existById(Long id) {
        return memberRepository.existsById(id);
    }

    @Override
    public Member getReviews(Long memberId, Integer page) {
        return memberQueryRepository.getReviews(memberId, page-1, 10);
    }
}
