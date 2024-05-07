package com.forUMC.app.converter;

import com.forUMC.app.domain.Member;
import com.forUMC.app.domain.enums.Gender;
import com.forUMC.app.web.dto.MemberRequest;
import com.forUMC.app.web.dto.MemberResponse;

import java.util.ArrayList;

public class MemberConverter {
    public static MemberResponse.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponse.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(member.getCreatedAt())  // LocalDateTime.now()
                .build();
    }

    public static Member toMember(MemberRequest.JoinDTO request){
        Gender gender = switch (request.getGender()) {
            case 1 -> Gender.MALE;
            case 2 -> Gender.FEMALE;
            case 3 -> Gender.NONE;
            default -> null;
        };

        return Member.builder()
                .name(request.getName())
                .gender(gender)
                .birthday(request.getBirthday())
                .zipcode(request.getZipcode())
                .address(request.getAddress())
                .memberFoodCategories(new ArrayList<>())
                .build();
    }

}
