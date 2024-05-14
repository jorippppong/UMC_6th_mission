package com.forUMC.app.web.controller;

import com.forUMC.app.converter.RestaurantConverter;
import com.forUMC.app.converter.ReviewConverter;
import com.forUMC.app.domain.Restaurant;
import com.forUMC.app.domain.Review;
import com.forUMC.app.service.restaurant.RestaurantCommandService;
import com.forUMC.app.service.restaurant.RestaurantQueryService;
import com.forUMC.app.web.dto.RestaurantRequest;
import com.forUMC.app.web.dto.RestaurantResponse;
import com.forUMC.app.web.dto.ReviewResponse;
import com.forUMC.global.apiPayLoad.ApiResponse;
import com.forUMC.global.validation.annotation.ExistRestaurant;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurants")
@RequiredArgsConstructor
@Validated
public class RestaurantRestController {
    private final RestaurantCommandService restaurantCommandService;
    private final RestaurantQueryService restaurantQueryService;

    @PostMapping("/")
    public ApiResponse<RestaurantResponse.addRestaurantResultDTO> addRestaurant(
            @RequestBody @Valid RestaurantRequest.addRestaurantDTO request
    ){
        Restaurant restaurant = restaurantCommandService.addRestaurant(request);
        return ApiResponse.onSuccess(RestaurantConverter.toAddRestaurantResultDTO(restaurant));
    }

    @GetMapping("/{restaurantId}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API", description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다.")
    })
    public ApiResponse<ReviewResponse.ReviewPreviewListDTO<ReviewResponse.RestaurantReviewPreviewDTO>> getReviewList(
            @ExistRestaurant @PathVariable(name = "restaurantId") Long restaurantId,
            @RequestParam(name = "page") Integer page
    ){
        Page<Review> reviewPage = restaurantQueryService.getReviewList(restaurantId, page);
        return ApiResponse.onSuccess(ReviewConverter.toRestaurantReviewPreviewListDTO(reviewPage));
    }

}
