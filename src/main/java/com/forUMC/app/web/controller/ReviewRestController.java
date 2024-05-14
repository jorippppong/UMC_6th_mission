package com.forUMC.app.web.controller;

import com.forUMC.app.converter.ReviewConverter;
import com.forUMC.app.domain.Review;
import com.forUMC.app.repository.ReviewRepository;
import com.forUMC.app.service.review.ReviewCommandService;
import com.forUMC.app.web.dto.ReviewRequest;
import com.forUMC.app.web.dto.ReviewResponse;
import com.forUMC.global.apiPayLoad.ApiResponse;
import com.forUMC.global.validation.annotation.ExistMember;
import com.forUMC.global.validation.annotation.ExistRestaurant;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
@Validated
public class ReviewRestController {
    private final ReviewCommandService reviewCommandService;
    private final ReviewRepository reviewRepository;

    @PostMapping("")
    public ApiResponse<ReviewResponse.addReviewResultDTO> addReview(
            @RequestParam(value = "memberId", required = true) @ExistMember Long memberId,
            @RequestParam(value = "restaurantId", required = true) @ExistRestaurant Long restaurantId,
            @RequestBody @Valid ReviewRequest.AddReviewDTO request
        ){
        Review review = reviewCommandService.addReview(memberId, restaurantId, request);
        //reviewCommandService.check(memberId, restaurantId, request);
        return ApiResponse.onSuccess(ReviewConverter.toAddReviewResultDTO(review));
    }


    @DeleteMapping("")
    public String deleteReview(
            @RequestParam(value = "reviewId", required = true) @Valid Long reviewId
    ){
        reviewRepository.deleteById(reviewId);
        reviewCommandService.check2();
        return "삭제 OK";
    }




}
