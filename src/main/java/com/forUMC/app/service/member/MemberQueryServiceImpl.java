package com.forUMC.app.service.member;

import com.forUMC.app.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService{
    private final MemberRepository memberRepository;

    @Override
    public boolean existById(Long id) {
        return memberRepository.existsById(id);
    }
}
