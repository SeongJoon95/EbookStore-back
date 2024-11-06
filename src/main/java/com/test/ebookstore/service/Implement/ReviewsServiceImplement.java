package com.test.ebookstore.service.Implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.test.ebookstore.dto.request.reviews.AddReviewsRequestDto;
import com.test.ebookstore.dto.response.ResponseDto;
import com.test.ebookstore.entity.ReviewsEntity;
import com.test.ebookstore.repository.ReviewsRepository;
import com.test.ebookstore.service.ReviewsService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewsServiceImplement implements ReviewsService {

    private final ReviewsRepository reviewsRepository;

    @Override
    public ResponseEntity<ResponseDto> addReviews(AddReviewsRequestDto dto, Integer booksId) {

        String userId = dto.getUserId();

        try {

            // dto.getBooksId와 booksId의 값이 일치하지 않을경우 반환
            Integer bookId = dto.getBooksId();
            if (bookId != booksId)
                return ResponseDto.notMatchValue();

            // 리뷰작성 유효성 검사
            boolean checkReviews = reviewsRepository.existsByUserIdAndBooksId(userId, booksId);
            if (checkReviews)
                return ResponseDto.duplicatedReviews();

            ReviewsEntity reviewsEntity = new ReviewsEntity(dto);
            reviewsRepository.save(reviewsEntity);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.databaseError();
        }

        return ResponseDto.success();
    }

}
