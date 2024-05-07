package com.forUMC.app.web.dto;

import lombok.Getter;

public class ReviewRequest {

    @Getter
    public static class AddReviewDTO{
        private double star;
        private String body;
    }
}
