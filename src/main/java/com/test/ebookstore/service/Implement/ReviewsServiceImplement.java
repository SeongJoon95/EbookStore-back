package com.test.ebookstore.service.Implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.test.ebookstore.dto.request.reviews.AddReviewsRequestDto;
import com.test.ebookstore.dto.response.ResponseDto;
import com.test.ebookstore.repository.ReviewsRepository;
import com.test.ebookstore.service.ReviewsService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewsServiceImplement implements ReviewsService{
    
    private final ReviewsRepository reviewsRepository; 

    @Override
    public ResponseEntity<ResponseDto> addReviews(AddReviewsRequestDto dto, Integer booksId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addReviews'");
    }
    

}
