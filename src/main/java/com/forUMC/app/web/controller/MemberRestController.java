package com.forUMC.app.web.controller;

import com.forUMC.app.converter.MemberConverter;
import com.forUMC.app.domain.Member;
import com.forUMC.app.service.member.MemberCommandService;
import com.forUMC.app.web.dto.MemberRequest;
import com.forUMC.app.web.dto.MemberResponse;
import com.forUMC.global.apiPayLoad.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberRestController {
    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponse.JoinResultDTO> join(
            @RequestBody @Valid MemberRequest.JoinDTO request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }
}
