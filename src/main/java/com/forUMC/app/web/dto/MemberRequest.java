package com.forUMC.app.web.dto;

import com.forUMC.global.validation.annotation.ExistFoodCategories;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.List;

public class MemberRequest {

    @Getter
    public static class JoinDTO {
        @NotBlank
        String name;
        @NotNull
        Integer gender;
        @NotNull
        Integer birthYear;
        @NotNull
        Integer birthMonth;
        @NotNull
        Integer birthDay;
        @Size(min = 5, max = 5)
        String zipcode;
        String address;
        @ExistFoodCategories
        List<Long> preferCategory;
    }
}
