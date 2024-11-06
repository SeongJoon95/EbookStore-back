package com.test.ebookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.ebookstore.entity.ReviewsEntity;

@Repository
public interface ReviewsRepository extends JpaRepository<ReviewsEntity, Integer>{
    
    
    boolean existsByUserIdAndBooksId(String userId, Integer booksId);

    ReviewsEntity findByBooksId(Integer booksId);
    
    ReviewsEntity findByUserId(String userId);

}
