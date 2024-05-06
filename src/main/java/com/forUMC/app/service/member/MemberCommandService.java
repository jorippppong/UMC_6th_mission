package com.forUMC.app.service.member;

import com.forUMC.app.domain.Member;
import com.forUMC.app.web.dto.MemberRequest;

public interface MemberCommandService {
    public Member joinMember(MemberRequest.JoinDTO request);
}
