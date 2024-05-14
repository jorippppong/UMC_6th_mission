package com.forUMC.app.web.controller;

import com.forUMC.app.converter.MemberConverter;
import com.forUMC.app.converter.MissionConverter;
import com.forUMC.app.converter.ReviewConverter;
import com.forUMC.app.domain.Member;
import com.forUMC.app.domain.Mission;
import com.forUMC.app.service.member.MemberCommandService;
import com.forUMC.app.service.member.MemberQueryService;
import com.forUMC.app.service.mission.MissionQueryService;
import com.forUMC.app.web.dto.MemberRequest;
import com.forUMC.app.web.dto.MemberResponse;
import com.forUMC.app.web.dto.MissionResponse.MissionListDTO;
import com.forUMC.app.web.dto.ReviewResponse;
import com.forUMC.global.apiPayLoad.ApiResponse;
import com.forUMC.global.validation.annotation.ExistMember;
import com.forUMC.global.validation.annotation.PageNumberOverOne;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.forUMC.app.web.dto.MissionResponse.*;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
@Validated
public class MemberRestController {
    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;
    private final MissionQueryService missionQueryService;

    @PostMapping("/")
    public ApiResponse<MemberResponse.JoinResultDTO> join(
            @RequestBody @Valid MemberRequest.JoinDTO request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @GetMapping("{memberId}/reviews")
    @Operation(summary = "내가 작성한 리뷰 목록 조회 API", description = "내가 작성한 리뷰 목록을 조회하는 API이며, 페이징을 포함합니다. query String으로 page 번호를 주세요")
    @Parameters({
            @Parameter(name = "memberId", description = "유저 ID, path variable 입니다."),
            @Parameter(name = "page", description = "페이지 번호, 1 이상의 정수를 작성해주세요.")
    })
    public ApiResponse<ReviewResponse.ReviewPreviewList2DTO<ReviewResponse.MemberReviewPreviewDTO>> getReviewList(
        @ExistMember @PathVariable(name = "memberId") Long memberId,
        @PageNumberOverOne @RequestParam(name = "page") Integer page
    ){
        Member member = memberQueryService.getReviews(memberId, page);
        return ApiResponse.onSuccess(ReviewConverter.toMemberReviewPreviewListDTO(member, page));
    }

    @GetMapping("{memberId}/missions/challenging")
    @Operation(summary = "내가 진행 중인 미션 목록 조회 API", description = "내가 진행 중인 미션 목록을 조회하는 API이며, 페이징을 포함합니다. query String으로 page 번호를 주세요")
    @Parameters({
            @Parameter(name = "memberId", description = "유저 ID, path variable 입니다."),
            @Parameter(name = "page", description = "페이지 번호, 1 이상의 정수를 작성해주세요."),
    })
    public ApiResponse<MissionListDTO<MissionDTO>> getChallengingMission(
            @ExistMember @PathVariable(name = "memberId") Long memberId,
            @PageNumberOverOne @RequestParam(name = "page") Integer page
    ){
        List<Mission> missionList = missionQueryService.getChallengingMission(memberId, page);
        return ApiResponse.onSuccess(MissionConverter.toMissionListDTO(missionList, page));
    }
}
