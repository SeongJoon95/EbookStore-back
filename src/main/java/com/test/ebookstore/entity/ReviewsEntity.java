package com.test.ebookstore.entity;

import com.test.ebookstore.dto.request.reviews.AddReviewsRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Reviews")
@Table(name = "reviews")
public class ReviewsEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reviewsId;
    private Integer grade;
    private String content;
    private String userId;
    private Integer booksId;

    public ReviewsEntity(AddReviewsRequestDto dto){
        this.grade = dto.getGrade();
        this.content = dto.getContent();
        this.userId = dto.getUserId();
        this.booksId = dto.getBooksId();
    }
}
