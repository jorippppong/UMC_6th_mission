package com.forUMC.app.service.member;

import com.forUMC.app.converter.MemberConverter;
import com.forUMC.app.converter.MemberPreferConverter;
import com.forUMC.app.domain.FoodCategory;
import com.forUMC.app.domain.Member;
import com.forUMC.app.domain.mapping.MemberFoodCategory;
import com.forUMC.app.repository.FoodCategoryRepository;
import com.forUMC.app.repository.MemberRepository;
import com.forUMC.app.web.dto.MemberRequest;
import com.forUMC.global.apiPayLoad.code.status.ErrorStatus;
import com.forUMC.global.exception.GeneralException;
import com.forUMC.global.exception.handler.TempHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{
    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequest.JoinDTO request) {
        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategories = request.getPreferCategory().stream()
                .map(category -> foodCategoryRepository
                                .findById(category)
                                .orElseThrow(() -> new TempHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND)))
                .toList();
        List<MemberFoodCategory> memberFoodCategories = MemberPreferConverter.toMemberFoodCategory(foodCategories);
        memberFoodCategories.forEach(memberPrefer -> memberPrefer.setMember(newMember));
        return memberRepository.save(newMember);

    }
}
