package com.forUMC.app.converter;

import com.forUMC.app.domain.Review;
import com.forUMC.app.web.dto.ReviewRequest;
import com.forUMC.app.web.dto.ReviewResponse;

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
}
