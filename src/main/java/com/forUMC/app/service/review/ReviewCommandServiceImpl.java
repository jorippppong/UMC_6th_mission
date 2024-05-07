package com.forUMC.app.service.review;

import com.forUMC.app.converter.ReviewConverter;
import com.forUMC.app.domain.Member;
import com.forUMC.app.domain.Restaurant;
import com.forUMC.app.domain.Review;
import com.forUMC.app.repository.MemberRepository;
import com.forUMC.app.repository.RestaurantRepository;
import com.forUMC.app.repository.ReviewRepository;
import com.forUMC.app.web.dto.ReviewRequest;
import com.forUMC.global.apiPayLoad.code.status.ErrorStatus;
import com.forUMC.global.exception.handler.TempHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService{
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final RestaurantRepository restaurantRepository;

    @Override
    public Review addReview(Long memberId, Long restaurantId, ReviewRequest.AddReviewDTO request) {
        Review newReview = ReviewConverter.toReview(request);
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new TempHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(() -> new TempHandler(ErrorStatus.RESTAURANT_NOT_FOUND));
        newReview.setMember(member);
        newReview.setRestaurant(restaurant);
        return reviewRepository.save(newReview);
    }

    @Override
    public void check(Long memberId, Long restaurantId, ReviewRequest.AddReviewDTO request) {
        memberRepository.findById(memberId).orElseThrow(
                        () -> new TempHandler(ErrorStatus.MEMBER_NOT_FOUND))
                .getReviews().forEach(
                        r -> System.out.println("reviewId : " + r.getId() + ", restaurantId : " + r.getRestaurant().getId()));
        restaurantRepository.findById(restaurantId).orElseThrow(
                        () -> new TempHandler(ErrorStatus.RESTAURANT_NOT_FOUND))
                .getReviews().forEach(
                        r -> System.out.println("reviewId : " + r.getId() + ", memberId : "  + r.getMember().getId()));
    }

    @Override
    public void check2() {
        memberRepository.findById(1L).orElseThrow(
                        () -> new TempHandler(ErrorStatus.MEMBER_NOT_FOUND))
                .getReviews().forEach(
                        r -> System.out.println("reviewId : " + r.getId() + ", restaurantId : " + r.getRestaurant().getId()));
        restaurantRepository.findById(1L).orElseThrow(
                        () -> new TempHandler(ErrorStatus.RESTAURANT_NOT_FOUND))
                .getReviews().forEach(
                        r -> System.out.println("reviewId : " + r.getId() + ", memberId : "  + r.getMember().getId()));
    }
}
