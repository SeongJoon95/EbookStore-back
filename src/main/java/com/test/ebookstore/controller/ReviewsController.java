package com.test.ebookstore.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.ebookstore.dto.request.reviews.AddReviewsRequestDto;
import com.test.ebookstore.dto.response.ResponseDto;
import com.test.ebookstore.service.ReviewsService;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/review")
@RequiredArgsConstructor
public class ReviewsController {
    
    private final ReviewsService reviewsService;

    // 리뷰 작성 // 하다 말았음 내일 완성 조건생각잘할것
    @PostMapping("books/{booksId}/reviews")
    public ResponseEntity<ResponseDto> addReviews(
        @RequestBody @Valid AddReviewsRequestDto requestBody,
        @PathParam("booksId") Integer booksId
    ) {
        ResponseEntity<ResponseDto> response = reviewsService.addReviews(requestBody, booksId);
        return response;
    }
}
