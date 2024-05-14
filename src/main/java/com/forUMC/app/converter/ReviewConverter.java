package com.forUMC.app.converter;

import com.forUMC.app.domain.Member;
import com.forUMC.app.domain.Review;
import com.forUMC.app.web.dto.ReviewRequest;
import com.forUMC.app.web.dto.ReviewResponse;
import org.springframework.data.domain.Page;

import java.util.List;

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

    public static ReviewResponse.ReviewPreviewListDTO<ReviewResponse.RestaurantReviewPreviewDTO> toRestaurantReviewPreviewListDTO(Page<Review> reviewList){
        List<ReviewResponse.RestaurantReviewPreviewDTO> restaurantReviewPreviewDTOS = reviewList.stream()
                .map(ReviewConverter::toReviewPreviewDTO).toList();
        return ReviewResponse.ReviewPreviewListDTO.<ReviewResponse.RestaurantReviewPreviewDTO>builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(restaurantReviewPreviewDTOS.size())
                .reviewList(restaurantReviewPreviewDTOS)
                .build();
    }

    public static ReviewResponse.RestaurantReviewPreviewDTO toReviewPreviewDTO(Review review){
        return ReviewResponse.RestaurantReviewPreviewDTO.builder()
                .nickname(review.getMember().getName())
                .score(review.getStar())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }

    public static ReviewResponse.ReviewPreviewList2DTO<ReviewResponse.MemberReviewPreviewDTO> toMemberReviewPreviewListDTO(Member member, Integer page){
        return ReviewResponse.ReviewPreviewList2DTO.<ReviewResponse.MemberReviewPreviewDTO>builder()
                .listPage(page)
                .listSize(member.getReviews().size())
                .reviewList(toMemberReviewPreviewDTO(member))
                .build();
    }

    public static List<ReviewResponse.MemberReviewPreviewDTO> toMemberReviewPreviewDTO(Member member){
        return member.getReviews().stream().map(r ->
                ReviewResponse.MemberReviewPreviewDTO.builder()
                        .nickname(member.getName())
                        .score(r.getStar())
                        .body(r.getBody())
                        .createdAt(r.getCreatedAt().toLocalDate())
                        .RestaurantId(r.getRestaurant().getId())
                        .RestaurantName(r.getRestaurant().getName())
                        .build())
                .toList();
    }
}
