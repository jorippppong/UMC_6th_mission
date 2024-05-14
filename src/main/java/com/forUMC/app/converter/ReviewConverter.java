package com.forUMC.app.converter;

import com.forUMC.app.domain.Review;
import com.forUMC.app.web.dto.ReviewRequest;
import com.forUMC.app.web.dto.ReviewResponse;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {
    public static ReviewResponse.addReviewResultDTO toAddReviewResultDTO(Review review){
        return ReviewResponse.addReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(review.getCreatedAt())
                .build();
    }

    public static Review toReview(ReviewRequest.AddReviewDTO request){
        return Review.builder()
                .star(request.getStar())
                .body(request.getBody())
                .build();
    }

    public static ReviewResponse.ReviewPreviewListDTO toReviewPreviewListDTO(Page<Review> reviewList){
        List<ReviewResponse.ReviewPreviewDTO> reviewPreviewDTOs = reviewList.stream()
                .map(ReviewConverter::toReviewPreviewDTO).toList();
        return ReviewResponse.ReviewPreviewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreviewDTOs.size())
                .reviewList(reviewPreviewDTOs)
                .build();
    }

    public static ReviewResponse.ReviewPreviewDTO toReviewPreviewDTO(Review review){
        return ReviewResponse.ReviewPreviewDTO.builder()
                .nickname(review.getMember().getName())
                .score(review.getStar())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }
}
