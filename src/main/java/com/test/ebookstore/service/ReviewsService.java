package com.test.ebookstore.service;

import org.springframework.http.ResponseEntity;

import com.test.ebookstore.dto.request.reviews.AddReviewsRequestDto;
import com.test.ebookstore.dto.response.ResponseDto;

public interface ReviewsService {
    
    // 리뷰작성
    ResponseEntity<ResponseDto> addReviews(AddReviewsRequestDto dto, Integer booksId);
}
