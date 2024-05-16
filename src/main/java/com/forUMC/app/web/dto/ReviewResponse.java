package com.forUMC.app.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ReviewResponse {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class addReviewResultDTO{
        private Long reviewId;
        private LocalDateTime createdAt;
    }
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ReviewPreviewListDTO<T>{
        private List<T> reviewList;
        private Integer listSize;
        private Integer totalPage;
        private Long totalElements;
        private Boolean isFirst;
        private Boolean isLast;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RestaurantReviewPreviewDTO {
        private String nickname;
        private Double score;
        private String body;
        private LocalDate createdAt;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ReviewPreviewList2DTO<T>{
        private List<T> reviewList;
        private Integer listSize;
        private Integer listPage;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MemberReviewPreviewDTO{
        private String nickname;
        private Double score;
        private String body;
        private LocalDate createdAt;
        private Long RestaurantId;
        private String RestaurantName;
    }

}
