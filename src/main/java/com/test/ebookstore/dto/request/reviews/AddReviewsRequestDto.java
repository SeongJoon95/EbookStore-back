package com.test.ebookstore.dto.request.reviews;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddReviewsRequestDto {
    
    private Integer grade; // 평점
    private String content; // 내용
    private String userId; // 유저 아이디
    private Integer booksId; // 책고유번호
}
