package com.forUMC.domain;

import com.forUMC.domain.common.BaseEntity;
import com.forUMC.domain.enums.Gender;
import com.forUMC.domain.enums.MemberStatus;
import com.forUMC.domain.enums.SocialType;
import com.forUMC.domain.mapping.MemberAllowance;
import com.forUMC.domain.mapping.MemberFoodCategory;
import com.forUMC.domain.mapping.MemberMission;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private Gender gender;

    private LocalDate birthday;

    private String zipcode;

    private String address;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(20) DEFAULT 'ACTIVE'")
    private MemberStatus status;

    private LocalDate inactiveDate;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private SocialType socialType;

    @Column(nullable = false)
    private String email;

    private Integer point;

    // private Boolean locationAllowance;
    // private Boolean marketing_Allowance;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberAllowance> memberAllowances = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberFoodCategory> memberFoodCategories = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissions = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();
}
