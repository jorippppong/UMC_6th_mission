package com.forUMC.app.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class MissionRequest {
    @Getter
    public static class addMissionDTO{
        @NotNull
        private Integer point;
        @NotNull
        private Integer foodPrice;
        private LocalDate deadLine;
    }
}
