package com.forUMC.app.service.review;

import com.forUMC.app.domain.Review;
import com.forUMC.app.web.dto.ReviewRequest;

public interface ReviewCommandService {
    Review addReview(Long memberId, Long restaurantId, ReviewRequest.AddReviewDTO request);

    void check(Long memberId, Long restaurantId, ReviewRequest.AddReviewDTO request);

    void check2();
}
