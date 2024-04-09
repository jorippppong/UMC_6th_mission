package com.forUMC.domain;

import com.forUMC.domain.common.BaseEntity;
import com.forUMC.domain.enums.Gender;
import com.forUMC.domain.enums.MemberStatus;
import com.forUMC.domain.enums.SocialType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private LocalDate birthday;

    private Long zipcode;

    private String address;

    @Enumerated(EnumType.STRING)
    private MemberStatus status;

    private LocalDate inactiveDate;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    private String email;

    private Integer point;

    // private Boolean locationAllowance;
    // private Boolean marketing_Allowance;

}
