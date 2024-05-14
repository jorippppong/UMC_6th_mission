package com.forUMC.app.converter;

import com.forUMC.app.domain.Member;
import com.forUMC.app.domain.Restaurant;
import com.forUMC.app.domain.Review;
import com.forUMC.app.web.dto.ReviewRequest;
import com.forUMC.app.web.dto.ReviewResponse;
import org.springframework.data.domain.Page;

import java.util.List;

import static com.forUMC.app.web.dto.ReviewResponse.*;

public class ReviewConverter {
    public static addReviewResultDTO toAddReviewResultDTO(Review review){
        return addReviewResultDTO.builder()
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

    public static ReviewResponse.ReviewPreviewListDTO<RestaurantReviewPreviewDTO> toRestaurantReviewPreviewListDTO(Page<Review> reviewList){
        List<RestaurantReviewPreviewDTO> restaurantReviewPreviewDTOS = reviewList.stream()
                .map(ReviewConverter::toReviewPreviewDTO).toList();
        return ReviewPreviewListDTO.<RestaurantReviewPreviewDTO>builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(restaurantReviewPreviewDTOS.size())
                .reviewList(restaurantReviewPreviewDTOS)
                .build();
    }

    public static RestaurantReviewPreviewDTO toReviewPreviewDTO(Review review){
        return RestaurantReviewPreviewDTO.builder()
                .nickname(review.getMember().getName())
                .score(review.getStar())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }

    public static ReviewResponse.ReviewPreviewList2DTO<MemberReviewPreviewDTO> toMemberReviewPreviewListDTO(Member member, Integer page){
        return ReviewPreviewList2DTO.<MemberReviewPreviewDTO>builder()
                .listPage(page)
                .listSize(member.getReviews().size())
                .reviewList(toMemberReviewPreviewDTO(member))
                .build();
    }

    public static List<MemberReviewPreviewDTO> toMemberReviewPreviewDTO(Member member){
        return member.getReviews().stream().map(r ->
                MemberReviewPreviewDTO.builder()
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
