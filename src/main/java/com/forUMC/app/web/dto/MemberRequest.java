package com.forUMC.app.web.dto;

import com.forUMC.global.validation.annotation.ExistFoodCategories;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

public class MemberRequest {

    @Getter
    public static class JoinDTO {
        @NotBlank
        private String name;
        @NotNull
        private Integer gender;
        @NotNull
        private LocalDate birthday;
        @Size(min = 5, max = 5)
        private String zipcode;
        private String address;
        @ExistFoodCategories
        private List<Long> preferCategory;
    }
}
